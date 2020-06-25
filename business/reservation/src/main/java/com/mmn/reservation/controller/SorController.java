package com.mmn.reservation.controller;

import com.mmn.reservation.config.SorProperties;
import com.mmn.reservation.model.*;
import com.mmn.reservation.model.entity.PassportUser;
import com.mmn.reservation.service.PassportUserService;
import com.mmn.reservation.service.SorClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/sor")
public class SorController {
    private static final int TEN_MINUTES = 600000;
    private final SorProperties sorProperties;
    private final SorClientService sorClientService;
    private final PassportUserService passportUserService;

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }

    @PostMapping("/create-user")
    public ResponseEntity<?> createUser(@RequestHeader("subscriptionId") final String subscriptionId,
                                        @RequestBody final AccountDto accountDto)
            throws IOException {
        final SorProperties.Pack pack = getPackBySubscriptionId(subscriptionId);
        if (pack == null) return ResponseEntity.badRequest().body("Invalid ID");
        return ResponseEntity.ok(this.sorClientService.create(pack.getUsername(), pack.getPassword(), accountDto));
    }

    @PostMapping("/members")
    public ResponseEntity<?> listAll(
            @RequestBody(required = false) final Optional<List<ListMembersDto.MemberSearchListDto>> MemberSearchListDto)
            throws IOException {
        final SorProperties.Pack pack = getPackBySubscriptionId("3");
        if (pack == null) return ResponseEntity.badRequest().body("Invalid ID");
        return ResponseEntity.ok(this.sorClientService.listAll(
                ListMembersDto.builder()
                        .APIUsername(pack.getUsername())
                        .APIPassword(pack.getPassword())
                        .MemberSearchList(MemberSearchListDto.orElse(null))
                        .build()
        ));
    }

    @PostMapping("/create")
    public ResponseEntity<?> passportUserCreate(
            @RequestBody final PassportUser passportUser) {
        final SorProperties.Pack pack = getPackBySubscriptionId("3");
        if (Objects.nonNull(passportUserService.save(pack, passportUser))) {
            return ResponseEntity.ok(NewUserDataSetResponseDto
                    .builder()
                    .HTTPStatus("200 OK")
                    .ResponseCode("200")
                    .ResponseMessage(true)
                    .build());
        }
        return ResponseEntity.ok(NewUserDataSetResponseDto
                .builder()
                .HTTPStatus("409 Conflict")
                .ResponseCode("409")
                .ResponseMessage(false)
                .build());
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(
            @RequestHeader("subscriptionId") final String subscriptionId,
            @RequestBody final LoginDto loginDto)
            throws IOException {
        log.info(loginDto.toString());
        final SorProperties.Pack pack = getPackBySubscriptionId(subscriptionId);
        if (pack == null) return ResponseEntity.badRequest().body("Invalid ID");
        final FullLoginDto fullLoginDto = FullLoginDto.builder()
                .APIUsername(pack.getUsername())
                .APIPassword(pack.getPassword())
                .Email(loginDto.getEmail())
                .ContractNumber(loginDto.getContractNumber())
                .build();
        log.info(fullLoginDto.toString());
        final String login = this.sorClientService.login(fullLoginDto);
        log.info(login.toString());
        final String[] split = login.replaceAll("\"", "").split(":");
        if (split.length == 2) {
            return ResponseEntity.ok(
                    LoginResponseDto.builder()
                            .token(split[1])
                            .generateTimeMilis(System.currentTimeMillis())
                            .expireTimeMilis(System.currentTimeMillis() + TEN_MINUTES)
                            .build());
        } else if (login.replaceAll("\"", "").equals("Member not found.")) {
            throw new RuntimeException("Member not found.");
        }
        return ResponseEntity.ok(login);
    }

    private SorProperties.Pack getPackBySubscriptionId(final String subscriptionId) {
        try {
            int id = Integer.parseInt(subscriptionId);
            final List<SorProperties.Pack> packs = sorProperties.getPacks();
            if (!(id >= 0 && id < packs.size())) {
                return null;
            }
            return packs.get(id);
        } catch (Exception e) {
            return null;
        }
    }
}
