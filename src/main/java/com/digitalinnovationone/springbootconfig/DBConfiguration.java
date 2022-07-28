package com.digitalinnovationone.springbootconfig;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties("spring.datasource")
@Getter
@Setter
public class DBConfiguration {
    private String driverClassName;
    private String url;
    private String username;
    private String password;

    @Profile("dev")
    @Bean
    public String testDatabaseConnection() {
        System.out.println("DB connection for - H2");
        System.out.println("Driver Class Name: " + driverClassName);
        System.out.println("URL: " + url);
        System.out.println("DB conection for - H2");

        return "DB conection for - H2";
    }

    @Profile("prod")
    @Bean
    public String productionDatabaseConnection() {
        System.out.println("DB conection for - MySQL");
        System.out.println("Driver Class Name: " + driverClassName);
        System.out.println("URL: " + url);
        System.out.println("DB conection for - MySQL - PROD");

        return "DB conection for - H2";
    }

}
