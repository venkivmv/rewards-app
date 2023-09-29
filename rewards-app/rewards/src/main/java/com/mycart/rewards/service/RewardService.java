package com.mycart.rewards.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycart.rewards.dto.CustomerPurchaseDto;
import com.mycart.rewards.dto.CustomerRewardDto;
import com.mycart.rewards.entity.CustomerPurchase;
import com.mycart.rewards.repository.CustomerPurchaseRepository;

@Service
public class RewardService {

	@Autowired
	private CustomerPurchaseRepository rewardsRepository;


	
	public List<CustomerRewardDto> getRewardsPerCustomer(Date start,Date end){
		return rewardsRepository.findRewardsGroupByCustomers(start,end);
	}
	
	public List<CustomerPurchase> getPurchaseByCustomerId(String customerId,Date start,Date end){
		return rewardsRepository.findPurchaseByCustomerId(customerId,start,end);
	}
	
	public List<CustomerPurchase> findAllPurchases(){
		return rewardsRepository.findAll();
	}

	public Long getTotalRewards(Date start,Date end) {
		return rewardsRepository.findTotalRewards(start,end);
	}
	
	public void savePuchase(List<CustomerPurchaseDto> customerPurchaseDtos) {
		
		for(CustomerPurchaseDto customerPurchaseDto:customerPurchaseDtos) {
			savePuchase(customerPurchaseDto);
		}
	}

	public void savePuchase(CustomerPurchaseDto customerPurchaseDto) {
		
		
		CustomerPurchase customerPurchase = new CustomerPurchase() ;
		customerPurchase.setAmount(customerPurchaseDto.getAmount());
		customerPurchase.setPurchaseDate(customerPurchaseDto.getPurchaseDate());
		customerPurchase.setCustomerId(customerPurchaseDto.getCustomerId());
		customerPurchase.setReward(calculateRewards(customerPurchaseDto.getAmount().intValue()));
		rewardsRepository.save(customerPurchase);
	}
	
	private int calculateRewards(int amount) {
		int reward = 0;
		if(amount <= 50) {
			return reward;
		}
		else if(amount > 50 && amount <=100){
			reward += (amount - 50);
		}
		else if(amount > 100)
		{
			reward += 50;
			reward += (amount-100)*2;
		}
		return reward;
	}


}
