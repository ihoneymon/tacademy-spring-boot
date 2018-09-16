package io.honeymon.springboot.bookstore.admin.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaAuditing
@EntityScan("io.honeymon.springboot.t.bookstore.core")
@EnableJpaRepositories("io.honeymon.springboot.t.bookstore.core")
public class JpaConfiguration {

}
