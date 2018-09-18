package io.honeymon.springboot.t.bookstore.api.support.exceptionhandler;

import io.honeymon.springboot.t.bookstore.core.common.api.ApiResponse;
import io.honeymon.springboot.t.bookstore.core.common.exceptions.BookNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@ControllerAdvice(annotations = {RestController.class})
@ResponseBody
public class GlobalRestControllerAdvice {

    @ExceptionHandler(BookNotFoundException.class)
    public ApiResponse<Void> handleException(Exception e) {
        log.error("Occurred Exception: {}", e);
        return ApiResponse.error(e.getMessage());
    }
}
