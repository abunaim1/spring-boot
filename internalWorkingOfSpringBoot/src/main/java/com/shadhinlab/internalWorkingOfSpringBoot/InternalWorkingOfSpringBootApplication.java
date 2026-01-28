package com.shadhinlab.internalWorkingOfSpringBoot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InternalWorkingOfSpringBootApplication implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(InternalWorkingOfSpringBootApplication.class, args);
	}

	private DBBLPaymentService dbblPayment ;

	public InternalWorkingOfSpringBootApplication(DBBLPaymentService dbblPayment) {
		this.dbblPayment = dbblPayment;
	}

	@Override
	public void run(String... args) throws Exception {
		String payment = dbblPayment.pay();
		System.out.println("Payment Done: " + payment);
	}
}
