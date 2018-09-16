package io.honeymon.springboot.bookstore.admin.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

@Slf4j
public class AdminUserDetailsAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {
    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;

    public AdminUserDetailsAuthenticationProvider(PasswordEncoder passwordEncoder, UserDetailsService userDetailsService) {
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        if (authentication.getCredentials() == null) {
            log.warn("Authentication fail: no credentials provided.");
            throw new BadCredentialsException("security_exception_bad_credentials");
        }

        String credentialsPassword = authentication.getCredentials().toString();
        if (!passwordEncoder.matches(credentialsPassword, userDetails.getPassword())) {
            log.warn("Authentication fail: password does not match stored value.");
            throw new BadCredentialsException("security_exception_bad_credentials");
        }
    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        log.info("Retrieve User: {}", username);
        UserDetails retrieveUser ;

        try {
            retrieveUser = userDetailsService.loadUserByUsername(username);
        } catch (UsernameNotFoundException notFoundException) {
            if (hideUserNotFoundExceptions) {
                throw new BadCredentialsException("security_exception_bad_credentials");
            }
            throw notFoundException;
        } catch (BadCredentialsException badCredentialsException) {
            throw new BadCredentialsException("security_exception_bad_credentials", badCredentialsException);
        } catch (Exception authenticationProblem) {
            log.error("Occurred Exception: {}", authenticationProblem);
            throw new InternalAuthenticationServiceException(authenticationProblem.getMessage(), authenticationProblem);
        }

        return retrieveUser;
    }
}
