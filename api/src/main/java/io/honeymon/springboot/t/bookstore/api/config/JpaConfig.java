package io.honeymon.springboot.t.bookstore.api.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan("io.honeymon.springboot.t.bookstore.core.domain")
@EnableJpaRepositories("io.honeymon.springboot.t.bookstore.core.domain")
public class JpaConfig {

}
