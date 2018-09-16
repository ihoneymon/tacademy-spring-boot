package io.honeymon.springboot.bookstore.admin.security;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
public class PasswordEncoderTest {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
    public void testEncode() {
        String source = "1234";
        String encoded = passwordEncoder.encode(source);
        System.out.println("Encoded Password: " + encoded);
        log.debug("rawPassword: {}, encodedPassword: {}", source, encoded);

        assertThat(passwordEncoder.matches(source, encoded)).isTrue();
    }
}
