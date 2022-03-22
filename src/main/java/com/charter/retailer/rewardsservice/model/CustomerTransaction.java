package com.charter.retailer.rewardsservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerTransaction {
    private String transactionId;
    private LocalDate transactionDate;
    private String customerId;
    private String name;
}