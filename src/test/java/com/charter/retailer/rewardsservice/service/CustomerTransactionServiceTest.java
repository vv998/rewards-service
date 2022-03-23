package com.charter.retailer.rewardsservice.service;

import com.charter.retailer.rewardsservice.model.CustomerTransaction;
import com.charter.retailer.rewardsservice.repository.CustomerTransactionRepo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class CustomerTransactionServiceTest {

    public static final String CUSTOMER_ID = "custId";

    @InjectMocks
    private CustomerTransactionService transactionService;
    @Mock
    private CustomerTransactionRepo transactionRepo;

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
    public void createTransaction() {
        Mockito.doNothing()
                .when(this.transactionRepo)
                .createTransaction(Mockito.any(CustomerTransaction.class));

        CustomerTransaction transaction = this.transactionService
                .createTransaction(this.transaction);
        Assert.assertEquals(CUSTOMER_ID, transaction.getCustomerId());
    }

    @Test
    public void isTransactionExist() {
    }

    @Test
    public void isValidClient() {
        Mockito.doReturn(this.transactions)
                .when(this.transactionRepo)
                .getTransactionsByCustomer(CUSTOMER_ID);

        CustomerTransaction transaction = this.transactionService
                .isValidClient(CUSTOMER_ID);
        Assert.assertEquals(CUSTOMER_ID, transaction.getCustomerId());
    }

    @Test
    public void isValidClientWithInvalidClientId() {
        Mockito.doReturn(null)
                .when(this.transactionRepo)
                .getTransactionsByCustomer("INVALID_CLIENT_ID");

        CustomerTransaction transaction = this.transactionService
                .isValidClient(CUSTOMER_ID);
        Assert.assertNull(transaction);
    }

    @Test
    public void getTransactions() {
        Mockito.doReturn(this.transactions)
                .when(this.transactionRepo)
                .getTransactions();

        List<CustomerTransaction> transactions = this.transactionService
                .getTransactions();
        Assert.assertEquals(1, transactions.size());
        Assert.assertEquals(CUSTOMER_ID, transactions.get(0).getCustomerId());
    }

    @Test
    public void getTransactionsByCustomer() {
        Mockito.doReturn(this.transactions)
                .when(this.transactionRepo)
                .getTransactionsByCustomer(CUSTOMER_ID);

        List<CustomerTransaction> transactions = this.transactionService
                .getTransactionsByCustomer(CUSTOMER_ID);
        Assert.assertEquals(1, transactions.size());
        Assert.assertEquals(CUSTOMER_ID, transactions.get(0).getCustomerId());
    }
}