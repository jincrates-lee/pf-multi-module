package me.jincrates.pf.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = "me.jincrates.pf.infrastructure.dataaccess")
@EnableJpaRepositories(basePackages = "me.jincrates.pf.infrastructure.dataaccess")
@ComponentScan(basePackages = "me.jincrates.pf")
@SpringBootApplication
public class ApiRunner {

    public static void main(String[] args) {
        SpringApplication.run(
            ApiRunner.class,
            args
        );
    }
}
