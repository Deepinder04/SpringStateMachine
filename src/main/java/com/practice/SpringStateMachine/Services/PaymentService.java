package com.practice.SpringStateMachine.Services;

import com.practice.SpringStateMachine.domain.Payment;
import com.practice.SpringStateMachine.domain.PaymentEvent;
import com.practice.SpringStateMachine.domain.PaymentState;
import org.springframework.statemachine.StateMachine;

public interface PaymentService {

    Payment newPayment(Payment payment);
    StateMachine<PaymentState, PaymentEvent> preAuth(Long paymentId);
    StateMachine<PaymentState, PaymentEvent> authorizePayment(Long paymentId);
    StateMachine<PaymentState, PaymentEvent> declineAuth(Long paymentId);
}
