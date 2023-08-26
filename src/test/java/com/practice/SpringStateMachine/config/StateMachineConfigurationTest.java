package com.practice.SpringStateMachine.config;

import com.practice.SpringStateMachine.domain.PaymentEvent;
import com.practice.SpringStateMachine.domain.PaymentState;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@Slf4j
@SpringBootTest
class StateMachineConfigurationTest {
    @Autowired
    StateMachineFactory<PaymentState, PaymentEvent> factory;

    @Test
    public void testNewStateMachine(){
        StateMachine<PaymentState,PaymentEvent> sm = factory.getStateMachine(UUID.randomUUID());
        sm.start();
        log.info("initial state: {}",sm.getState().toString());

        sm.sendEvent(PaymentEvent.PRE_AUTHORIZE);
        log.info("state after event PRE_AUTHORIZE : {}",sm.getState().toString());

        sm.sendEvent(PaymentEvent.PRE_AUTH_DECLINED);
        log.info("state after event PRE_AUTH_DECLINED : {}",sm.getState().toString());
    }
}