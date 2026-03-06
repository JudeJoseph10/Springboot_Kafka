package com.bankapp.bank_app_consumer.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.bankapp.bank_app_consumer.BankAppConsumerApplication;
import com.bankapp.bank_app_consumer.service.NotificationService;
import com.bankapp.bank_app_producer.model.BankTransaction;
import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransactionConsumer {

    private final BankAppConsumerApplication bankAppConsumerApplication;

	 private final NotificationService notificationService;

	    @KafkaListener(topics = "bank-transactions")
	    public void onMessage(ConsumerRecord<String, BankTransaction> transaction) {
	    	
	    	String key = transaction.key();
	    	BankTransaction value = transaction.value();

	        System.out.println("Transaction Received: " + value);

	        notificationService.sendNotification(value);
	    }
   
}
