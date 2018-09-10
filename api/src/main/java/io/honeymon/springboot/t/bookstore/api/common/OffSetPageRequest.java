package io.honeymon.springboot.t.bookstore.api.common;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;

@Getter
@Setter
@NoArgsConstructor
public class OffSetPageRequest {
    private int offset;
    private int limit;

    @Builder
    public OffSetPageRequest(int offset, int limit) {
        this.offset = offset;
        this.limit = limit;
    }

    public PageRequest getPageRequest() {
        int page = this.offset / this.limit;
        return PageRequest.of(page, this.limit);
    }
}
