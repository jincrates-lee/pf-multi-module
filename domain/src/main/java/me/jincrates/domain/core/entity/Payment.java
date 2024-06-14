package me.jincrates.domain.core.entity;

public record Payment(
    Long id,
    String paymentMethodCode,
    String transKey
) {

}
