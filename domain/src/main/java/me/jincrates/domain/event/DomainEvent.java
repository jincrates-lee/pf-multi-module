package me.jincrates.domain.event;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

public interface DomainEvent {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    LocalDateTime issuedAt();
}
