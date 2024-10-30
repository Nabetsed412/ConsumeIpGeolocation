package org.example.consumeipgeolocation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.example.consumeipgeolocation.manager.H2ServerManager;


@SpringBootApplication
public class ConsumeIpGeolocationApplication {

    public static void main(String[] args) {
        H2ServerManager h2ServerManager = new H2ServerManager();
        h2ServerManager.startH2Server();
        SpringApplication.run(ConsumeIpGeolocationApplication.class, args);
    }
}
