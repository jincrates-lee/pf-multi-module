package me.jincrates.domain.core.entity;

import me.jincrates.domain.core.enumtype.PayMethod;

public record Payment(
    Long id,
    PayMethod payMethod,
    String transKey
) {

}
