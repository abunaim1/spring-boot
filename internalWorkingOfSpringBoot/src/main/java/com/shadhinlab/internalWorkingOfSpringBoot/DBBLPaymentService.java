package com.shadhinlab.internalWorkingOfSpringBoot;


import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;


@Component
@ConditionalOnProperty(name = "payment.provider", havingValue = "dbbl")
public class DBBLPaymentService implements PaymentService{

    @Override
    public String pay(){
        String payment = "DBBL Payment";
        System.out.println("DBBL: " + payment);
        return payment;
    }
}
