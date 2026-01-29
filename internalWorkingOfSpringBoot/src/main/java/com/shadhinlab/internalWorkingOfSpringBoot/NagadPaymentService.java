package com.shadhinlab.internalWorkingOfSpringBoot;


import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@Component
//@RestController
//@Repository
//@Service
//@Controller

@ConditionalOnProperty(name = "payment.provider", havingValue = "nagad")
public class NagadPaymentService implements PaymentService{

    @Override
    public String pay() {
        String payment = "Nagad Payment";
        System.out.println("Paying From: " + payment);

        return "";
    }
}
