package com.mmn.reservation.exception;

import com.google.common.io.CharStreams;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.Cleanup;
import org.springframework.stereotype.Component;

import java.io.Reader;

import static feign.FeignException.errorStatus;

@Component
public class FeignErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(final String methodKey, final Response response) {
        if (
                (response.status() >= 400 && response.status() <= 499) ||
                        (response.status() >= 500 && response.status() <= 599)
        ) {
            try {
                @Cleanup final Reader reader = response.body().asReader();
                return new FeignErrorException(
                        response.status(),
                        response.reason(),
                        CharStreams.toString(reader)
                );
            } catch (Exception e) {
                return new FeignErrorException(
                        response.status(),
                        response.reason(),
                        e.getMessage()
                );
            }
        }
        return errorStatus(methodKey, response);
    }
}
