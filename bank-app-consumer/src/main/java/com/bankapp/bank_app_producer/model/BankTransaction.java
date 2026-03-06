package com.bankapp.bank_app_producer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BankTransaction {

	private String transactionId;
    private String fromAccount;
    private String toAccount;
    private Double amount;
    private String status;
    
}
