package dev.diego.spotifyconsumerapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Entrypoint {
    public static void main(String[] args) {
        SpringApplication.run(Entrypoint.class, args);
    }

}