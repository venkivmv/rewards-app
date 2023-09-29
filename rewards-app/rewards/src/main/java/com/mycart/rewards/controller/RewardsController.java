package com.mycart.rewards.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mycart.rewards.dto.CustomerPurchaseDto;
import com.mycart.rewards.dto.CustomerRewardDto;
import com.mycart.rewards.entity.CustomerPurchase;
import com.mycart.rewards.service.RewardService;

@Validated
@RestController
public class RewardsController {


	@Autowired
	private RewardService rewardService;

	@RequestMapping(value = "/purchase", method = RequestMethod.POST)
	public ResponseEntity<String> savePurachse(@RequestBody List<@Valid CustomerPurchaseDto> customerPurchaseDtos) {
		rewardService.savePuchase(customerPurchaseDtos);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@RequestMapping(value = "/rewards", method = RequestMethod.GET)
	public ResponseEntity<List<CustomerRewardDto>> getRewardsPerCustomer(@RequestParam(value = "start")Date start,@RequestParam(value = "end")Date end) {
		List<CustomerRewardDto> rewards = rewardService.getRewardsPerCustomer(start,end);	
		return new ResponseEntity<List<CustomerRewardDto>>(rewards, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/rewards/total", method = RequestMethod.GET)
	public ResponseEntity<Long> getTotalRewards(@RequestParam(value = "start")Date start,@RequestParam(value = "end")Date end) {
		Long rewards = rewardService.getTotalRewards(start,end);	
		return new ResponseEntity<Long>(rewards, HttpStatus.OK);
	}

	@RequestMapping(value = "/purchase/{customerId}", method = RequestMethod.GET)
	public ResponseEntity<List<CustomerPurchase>> getPurchaseByCustomerId(@PathVariable(value = "customerId") String customerId,
			@RequestParam(value = "start")Date start,@RequestParam(value = "end")Date end) {
		List<CustomerPurchase> rewards = rewardService.getPurchaseByCustomerId(customerId,start,end);	
		return new ResponseEntity<List<CustomerPurchase>>(rewards, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/purchase", method = RequestMethod.GET)
	public ResponseEntity<List<CustomerPurchase>> getAll() {
		List<CustomerPurchase> rewards = rewardService.findAllPurchases();
		return new ResponseEntity<List<CustomerPurchase>>(rewards, HttpStatus.OK);
	}

}