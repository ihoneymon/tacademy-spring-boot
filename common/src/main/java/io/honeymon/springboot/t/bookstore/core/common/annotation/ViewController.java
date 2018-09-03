package io.honeymon.springboot.t.bookstore.core.common.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Controller;

import java.lang.annotation.*;

/**
 * <code>ControllerAdvice</code>를 이용할 때 <code>Controller</code>를 그대로 사용할 경우 <core>RestController</core>의 필터링도
 * 걸리는 문제가 있어 이를 구분짓기 위해 별도의 애너테이션을 생성한다.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Controller
public @interface ViewController {
    @AliasFor(annotation = Controller.class)
    String value() default "";
}
