package io.honeymon.springboot.t.bookstore.core.common.enums;

import lombok.Getter;

@Getter
public enum ActivityStatus implements TypeEnum {
    DRAFT("draft", "작성중"),
    ACTIVE("active", "활성화"),
    SUSPEND("suspend", "일시중지"),
    TERMINATION("termination", "종료");

    private String code;
    private String description;

    ActivityStatus(String code, String description) {
        this.code = code;
        this.description = description;
    }
}
