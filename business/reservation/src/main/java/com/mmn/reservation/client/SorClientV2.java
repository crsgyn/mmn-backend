package com.mmn.reservation.client;

import com.mmn.reservation.model.AccountDto;
import com.mmn.reservation.model.AccountResponseDto;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(
        name = "SorApiV2",
        url = "${reservation.sor_url}/v2"
)
@Headers({
        "Content-Type: application/json"
})
public interface SorClientV2 {
    @PostMapping("/clubmembership/createdefault")
    ResponseEntity<AccountResponseDto> create(@RequestHeader("x-saveon-username") String username,
                                              @RequestHeader("x-saveon-secret") String secret,
                                              @RequestBody AccountDto accountDto);
}
