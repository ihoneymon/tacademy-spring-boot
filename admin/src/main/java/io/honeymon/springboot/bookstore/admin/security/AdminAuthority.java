package io.honeymon.springboot.bookstore.admin.security;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

@Getter
public enum AdminAuthority implements GrantedAuthority {
    ADMIN("admin");

    private String authority;

    AdminAuthority(String authority) {
        this.authority = authority;
    }
}
