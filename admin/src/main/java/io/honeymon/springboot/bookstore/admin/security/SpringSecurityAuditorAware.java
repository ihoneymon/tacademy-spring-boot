package io.honeymon.springboot.bookstore.admin.security;

import io.honeymon.springboot.t.bookstore.core.domain.admin.Admin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@Slf4j
public class SpringSecurityAuditorAware implements AuditorAware<Admin> {
    @Override
    public Optional<Admin> getCurrentAuditor() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null || !authentication.isAuthenticated()) {
            return Optional.empty();
        }
        log.trace("getCurrentAuditor: {}", authentication);
        return Optional.of((Admin)authentication.getPrincipal());
    }
}

