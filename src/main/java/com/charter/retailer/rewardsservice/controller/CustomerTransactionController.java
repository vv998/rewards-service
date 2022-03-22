package com.charter.retailer.rewardsservice.controller;

import com.charter.retailer.rewardsservice.model.Rewards;
import com.charter.retailer.rewardsservice.service.CustomerTransactionService;
import com.charter.retailer.rewardsservice.service.RewardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer/transactions")
public class CustomerTransactionController {

    @Autowired
    private CustomerTransactionService customerTransactionService;

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<Rewards> getRewardByCustomer(@PathVariable String customerId){
         //Rewards rewards = this.rewardsService.getRewardByCustomer(customerId);

         return null;//new ResponseEntity(rewards, HttpStatus.OK);
    }
}
