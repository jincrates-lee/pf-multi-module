package me.jincrates.domain.pg;

import me.jincrates.domain.core.enumtype.PayMethod;

public interface PaymentGateway {

    void prepare(PayMethod payMethod);

    void approve(PayMethod payMethod);

    void status(PayMethod payMethod);

    void cancel(PayMethod payMethod);
}
