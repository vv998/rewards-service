package com.charter.retailer.rewardsservice.repository;

import com.charter.retailer.rewardsservice.model.Rewards;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerTransactionRepo {
    public Rewards getRewardByCustomer(String customerId) {

        //TODO: customerId validation is required
        return null;

    }
}
