package com.mmn.reservation.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@ToString
@Component
@PropertySource("classpath:sor.properties")
@ConfigurationProperties(prefix = "sor")
public class SorProperties {

    @Value("${reservation.sor_url}")
    private String SOR_URL;

    private List<Pack> packs;

    @Getter
    @Setter
    @ToString
    public static class Pack {
        private String id;
        private String name;
        private String username;
        private String password;
    }

}
