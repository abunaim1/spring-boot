package com.shadhinlab.internalWorkingOfSpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InternalWorkingOfSpringBootApplication implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(InternalWorkingOfSpringBootApplication.class, args);
	}


	private final PaymentService paymentService;



//	Constructor dependency injection
	public InternalWorkingOfSpringBootApplication(PaymentService paymentService) {
        this.paymentService = paymentService;
	}

    @Override
	public void run(String... args) throws Exception {
		String payment = paymentService.pay();
		System.out.println("Payment Done: " + payment);
	}
}
