package com.charter.retailer.rewardsservice.controller;

import com.charter.retailer.rewardsservice.model.CustomerTransaction;
import com.charter.retailer.rewardsservice.service.CustomerTransactionService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class CustomerTransactionControllerTest {

    public static final String CUSTOMER_ID = "custId";

    @InjectMocks
    private  CustomerTransactionController transactionController;
    @Mock
    private CustomerTransactionService transactionService;

    private CustomerTransaction transaction;
    private List<CustomerTransaction> transactions;

    @Before
    public void setUp() {
        this.transaction = new CustomerTransaction("custTran5",
                LocalDate.now().minusMonths(1), 200L, "custId");
        this.transactions = Arrays.asList(this.transaction);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getTransactionsByCustomer() {
        Mockito.doReturn(this.transactions)
                .when(this.transactionService)
                .getTransactionsByCustomer(CUSTOMER_ID);

        ResponseEntity<List<CustomerTransaction>> response = this.transactionController
                .getTransactionsByCustomer(CUSTOMER_ID);
        List<CustomerTransaction> transactions = response.getBody();
        Assert.assertEquals(200, response.getStatusCodeValue());
        Assert.assertEquals(1, transactions.size());
        Assert.assertEquals(CUSTOMER_ID, transactions.get(0).getCustomerId());
    }

    @Test
    public void createTransaction() {
        Mockito.doReturn(this.transaction)
                .when(this.transactionService)
                .createTransaction(this.transaction);

        ResponseEntity<CustomerTransaction> response = this.transactionController
                .createTransaction(this.transaction);
        CustomerTransaction transaction = response.getBody();
        Assert.assertEquals(201, response.getStatusCodeValue());
        Assert.assertEquals(CUSTOMER_ID, transaction.getCustomerId());
    }
}