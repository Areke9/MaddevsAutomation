package com.cucumber.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;


@Data
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(ignoreInvalidFields = true)
@PropertySources({
        @PropertySource(value = "classpath:properties/application-jdbc.properties"),
        @PropertySource(value = "classpath:properties/application-${spring.profiles.active}.properties", ignoreResourceNotFound = true),
        @PropertySource(value = "classpath:properties/application-mainpage.properties"),
        @PropertySource(value = "classpath:properties/application-texts.properties"),
        @PropertySource(value = "classpath:properties/application-servicepage.properties")
})
public class PropertiesConfig {

    private Web web;

    @lombok.Data
    public static class Web {
        private String baseurl;
        private Auth user;
    }

    @lombok.Data
    public static class Auth {
        private String username;
        private String password;
    }

}
