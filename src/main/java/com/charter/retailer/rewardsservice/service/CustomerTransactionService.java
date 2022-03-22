package com.charter.retailer.rewardsservice.service;

import com.charter.retailer.rewardsservice.exception.ResourceNotFoundError;
import com.charter.retailer.rewardsservice.model.CustomerTransaction;
import com.charter.retailer.rewardsservice.repository.CustomerTransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTransactionService {

    @Autowired
    public CustomerTransactionRepo customerTransactionRepo;

    public void createCustomerTransaction(CustomerTransaction customerTransaction) {
        //todo create a new resource
    }

    public CustomerTransaction isValidClient(String customerId) {
        return this.customerTransactionRepo.getTransactionsByCustomer(customerId)
                .stream().findFirst()
                .orElseThrow(() -> {
                    try {
                        throw new ResourceNotFoundError("customerId: "+ customerId +" doesn't exists ");
                    } catch (ResourceNotFoundError e) {
                        e.printStackTrace();
                    }
                    return null;
                });
    }

    public List<CustomerTransaction> getTransactions(){
      return this.customerTransactionRepo.getTransactions();
    }

    public List<CustomerTransaction> getTransactionsByCustomer(String customerId){
        return this.customerTransactionRepo
                .getTransactionsByCustomer(customerId);
    }
}
