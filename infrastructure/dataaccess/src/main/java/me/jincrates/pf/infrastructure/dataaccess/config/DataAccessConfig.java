package me.jincrates.pf.infrastructure.dataaccess.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "me.jincrates.pf.infrastructure.dataaccess")
public class DataAccessConfig {

}
