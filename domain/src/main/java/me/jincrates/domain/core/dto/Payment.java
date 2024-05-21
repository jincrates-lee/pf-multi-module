package me.jincrates.domain.core.dto;

import lombok.Getter;

public record Payment(
    Long id,
    String paymentMethodCode,
    String transKey
) {
}
