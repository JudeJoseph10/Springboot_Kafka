package com.bankapp.bank_app_producer.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.bank_app_producer.model.BankTransaction;
import com.bankapp.bank_app_producer.producer.TransactionProducer;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionController {
	
	  private final TransactionProducer producer;

	    @PostMapping
	    public String createTransaction(@RequestBody BankTransaction transaction) {
	        transaction.setStatus("INITIATED");
	        producer.sendTransaction(transaction);
	        return "Transaction Submitted";
	    }
	    
}
