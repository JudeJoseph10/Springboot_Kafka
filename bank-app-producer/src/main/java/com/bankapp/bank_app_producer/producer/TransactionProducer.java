package com.bankapp.bank_app_producer.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.bankapp.bank_app_producer.model.BankTransaction;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransactionProducer {
	
	private final KafkaTemplate<String, BankTransaction> kafkaTemplate;
	
	private static final String TOPIC = "bank-transactions";
	
	public void sendTransaction(BankTransaction bankTransaction) {
		kafkaTemplate.send(TOPIC,
							bankTransaction.getTransactionId(),
							bankTransaction);
		System.out.println("Transaction Sent ....");
	}
}
