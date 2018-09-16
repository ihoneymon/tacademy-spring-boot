package io.honeymon.springboot.bookstore.admin.support.exceptionhandler;

import io.honeymon.springboot.t.bookstore.core.common.annotation.ViewController;
import io.honeymon.springboot.t.bookstore.core.common.exceptions.BookNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@ControllerAdvice(annotations = {ViewController.class})
public class GlobalViewControllerAdvice {
    @ExceptionHandler(BookNotFoundException.class)
    public ModelAndView handleException(Exception e) {
        ModelAndView mav = new ModelAndView("error");
        mav.addObject("code", "9999");
        mav.addObject("message", e.getMessage());
        return mav;
    }
}
