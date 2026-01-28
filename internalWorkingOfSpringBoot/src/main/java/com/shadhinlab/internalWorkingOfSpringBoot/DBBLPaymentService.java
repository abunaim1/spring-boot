package com.shadhinlab.internalWorkingOfSpringBoot;


import org.springframework.stereotype.Component;


@Component
public class DBBLPaymentService {
    public String pay(){
        String payment = "DBBL Payment";
        System.out.println("DBBL: " + payment);
        return payment;
    }
}
