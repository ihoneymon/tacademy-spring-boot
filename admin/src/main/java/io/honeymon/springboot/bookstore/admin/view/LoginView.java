package io.honeymon.springboot.bookstore.admin.view;

import io.honeymon.springboot.t.bookstore.core.common.annotation.ViewController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@ViewController
public class LoginView {
    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
