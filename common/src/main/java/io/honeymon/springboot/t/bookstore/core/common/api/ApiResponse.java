package io.honeymon.springboot.t.bookstore.core.common.api;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ApiResponse<T> {
    private String code;
    private String message;
    private T data;

    @Builder
    public ApiResponse(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> ApiResponse<T> ok(T data) {
        return new ApiResponse<>("0000", null, data);
    }
}
