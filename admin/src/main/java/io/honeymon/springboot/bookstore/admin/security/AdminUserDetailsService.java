package io.honeymon.springboot.bookstore.admin.security;

import io.honeymon.springboot.t.bookstore.core.domain.admin.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

import static io.honeymon.springboot.bookstore.admin.security.AdminAuthority.ADMIN;

@Service
public class AdminUserDetailsService implements UserDetailsService {
    @Autowired
    AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return adminRepository.findByEmail(username)
                .map(admin -> new User(username, admin.getPassword(), Arrays.asList(ADMIN)))
                .orElseThrow(() -> new UsernameNotFoundException(String.format("Username(%s) not found.", username)));
    }
}
