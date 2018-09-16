package io.honeymon.springboot.bookstore.admin.config;

import io.honeymon.springboot.bookstore.admin.security.AdminAuthenticationFailureHandler;
import io.honeymon.springboot.bookstore.admin.security.AdminAuthenticationSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.*;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

import java.util.HashMap;
import java.util.Map;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    public static final String JSESSIONID = "JSESSIONID";
    public static final String USERNAME_PARAMETER = "username";
    public static final String PASSWORD_PARAMETER = "password";

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/css/**", "/img/**", "/js/**", "/font/**", "/webjars/**")
                .antMatchers("/work/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
//                .antMatchers("/admin/**", "/couponinfo/**").hasAnyRole("ADMIN")
                // 나머지 요청에 대해서는 인증
                .anyRequest().authenticated();

//        http.csrf().disable();

        // 로그인 처리
        http.formLogin()
                .loginPage("/login").permitAll()
                .usernameParameter(USERNAME_PARAMETER)
                .passwordParameter(PASSWORD_PARAMETER)
                .successHandler(new AdminAuthenticationSuccessHandler())
                .failureHandler(new AdminAuthenticationFailureHandler());

        // 로그아웃 처리
        http.logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout")
                .deleteCookies(JSESSIONID).permitAll();

//        http.sessionManagement()
//                .maximumSessions(2)
//                .maxSessionsPreventsLogin(true);
    }

    /**
     * @see <a href="https://java.ihoney.pe.kr/498">Spring Security 5 새로운점</a>
     */
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        String encodingId = "bcrypt";
//        Map<String, PasswordEncoder> encoders = new HashMap<>();
//        encoders.put(encodingId, new BCryptPasswordEncoder());
//        encoders.put("pbkdf2", new Pbkdf2PasswordEncoder());
//        encoders.put("scrypt", new SCryptPasswordEncoder());
//
//        return new DelegatingPasswordEncoder(encodingId, encoders);
//    }
}
