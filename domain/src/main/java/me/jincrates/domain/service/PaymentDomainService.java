package me.jincrates.domain.service;

import me.jincrates.domain.core.dto.Order;
import me.jincrates.domain.core.dto.Payment;

public interface PaymentDomainService {
    Payment save(Payment payment);
    Payment findById(Long id);
}
