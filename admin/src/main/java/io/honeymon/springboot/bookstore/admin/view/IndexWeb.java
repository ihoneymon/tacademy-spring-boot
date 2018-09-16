package io.honeymon.springboot.bookstore.admin.view;

import io.honeymon.springboot.t.bookstore.core.common.annotation.ViewController;
import org.springframework.web.bind.annotation.GetMapping;

@ViewController
public class IndexWeb {
    @GetMapping("/")
    public String index() {
        return "index";
    }
}
