package me.jincrates.domain.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.jincrates.domain.core.dto.Payment;
import me.jincrates.domain.core.entity.PaymentEntity;
import me.jincrates.domain.core.repository.PaymentRepository;
import me.jincrates.domain.exception.DomainException;
import me.jincrates.domain.mapper.PaymentDomainMapper;
import me.jincrates.domain.service.PaymentDomainService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PaymentDomainServiceImpl implements PaymentDomainService {
    private final PaymentDomainMapper paymentMapper;
    private final PaymentRepository paymentRepository;

    @Transactional
    public Payment save(Payment payment) {
        PaymentEntity entity = paymentMapper.toEntity(payment);
        return paymentMapper.toDomain(paymentRepository.save(entity));
    }

    public Payment findById(Long id) {
        return paymentMapper.toDomain(paymentRepository.findById(id)
            .orElseThrow(() -> {
                log.info("결제 정보를 찾을 수 없습니다. id: {}", id);
                return new DomainException("결제 정보를 찾을 수 없습니다.");
            }));
    }
}
