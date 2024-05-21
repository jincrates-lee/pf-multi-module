package me.jincrates.pf.pg;

import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
class ConsolePaymentGateway implements PaymentGateway {

    @Override
    public void prepare(Long orderId, String paymentMethodCode) {
        log.info("결제준비 처리 :: orderId: {}, paymentMethodCode: {}", orderId, paymentMethodCode);
    }

    @Override
    public String approve(Long orderId, String paymentMethodCode) {
        log.info("결제승인 처리 :: orderId: {}, paymentMethodCode: {}", orderId, paymentMethodCode);
        // 결제 트랜잭션 ID
        return UUID.randomUUID().toString();
    }
}
