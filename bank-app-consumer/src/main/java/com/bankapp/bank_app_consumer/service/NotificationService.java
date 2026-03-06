package com.bankapp.bank_app_consumer.service;

import org.springframework.stereotype.Service;

import com.bankapp.bank_app_producer.model.BankTransaction;

@Service
public class NotificationService {

	public void sendNotification(BankTransaction transaction) {		
		  System.out.println( "Notification: Transaction of ₹" +
		  transaction.getAmount() + " from " + transaction.getFromAccount() + " to " +
		  transaction.getToAccount() + " completed." );
		  System.out.println("Notification Raised");
	}

}
