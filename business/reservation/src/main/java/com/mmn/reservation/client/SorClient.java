package com.mmn.reservation.client;

import com.mmn.reservation.model.FullLoginDto;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(
        name = "SorApi",
        url = "${reservation.sor_url}"
)
@Headers({
        "Content-Type: application/json"
})
public interface SorClient {
    @PostMapping("/clubmembership/getlogintokennovalidation")
    @ResponseBody
    ResponseEntity<String> login(@RequestBody FullLoginDto loginDto);
}
