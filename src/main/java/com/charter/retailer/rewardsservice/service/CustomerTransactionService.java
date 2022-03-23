package com.charter.retailer.rewardsservice.service;

import com.charter.retailer.rewardsservice.model.CustomerTransaction;
import com.charter.retailer.rewardsservice.repository.CustomerTransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerTransactionService {

    @Autowired
    public CustomerTransactionRepo transactionRepo;

    //TODO: ideally defaulted customerTransaction object will be returned.
    public CustomerTransaction createTransaction(CustomerTransaction customerTransaction) {
        this.transactionRepo.createTransaction(customerTransaction);
        return customerTransaction;
    }

    public boolean isTransactionExist(String transactionId) {
        return this.transactionRepo.containsKey(transactionId);
    }

    public CustomerTransaction isValidClient(String customerId) {
        return this.transactionRepo.getTransactionsByCustomer(customerId)
                .stream().findFirst().orElse(null);
    }

    public List<CustomerTransaction> getTransactions(){
      return this.transactionRepo.getTransactions();
    }

    public List<CustomerTransaction> getTransactionsByCustomer(String customerId){
        return this.transactionRepo
                .getTransactionsByCustomer(customerId);
    }
}
