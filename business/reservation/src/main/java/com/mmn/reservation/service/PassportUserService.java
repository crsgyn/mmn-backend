package com.mmn.reservation.service;

import com.mmn.reservation.config.SorProperties;
import com.mmn.reservation.model.ListMembersDto;
import com.mmn.reservation.model.ListMembersResponseDto;
import com.mmn.reservation.model.entity.PassportUser;
import com.mmn.reservation.repository.PassportUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class PassportUserService {
    private final PassportUserRepository passportUserRepository;
    private final SorEmailService sorEmailService;
    private final SorClientService sorClientService;

    public PassportUser save(final SorProperties.Pack pack, final PassportUser passportUser) {
        final PassportUser savedPassportUser = this.passportUserRepository.save(passportUser);
        if (Objects.nonNull(savedPassportUser)) {
            final String referringUserID = savedPassportUser.getReferringUserID();
            try {
                final List<ListMembersResponseDto> listMembersResponseDtos = this.sorClientService.listAll(
                        ListMembersDto.builder()
                                .APIUsername(pack.getUsername())
                                .APIPassword(pack.getPassword())
                                .MemberSearchList(null)
                                .build());
                final ListMembersResponseDto referUser = listMembersResponseDtos.stream()
                        .filter(Objects::nonNull)
                        .filter(member -> member.getUserID().toString().equals(referringUserID))
                        .findAny()
                        .orElseThrow(() -> new RuntimeException("ReferringUserId not found"));
                if (referUser != null) {
                    this.sorEmailService.sendInvitationEmail(
                            referUser.getOtherID(),
                            passportUser.getEmail(),
                            passportUser.getFirstName());
                }
            } catch (IOException io) {
                throw new RuntimeException("Error calling the list members request");
            }
        }
        return savedPassportUser;
    }
}
