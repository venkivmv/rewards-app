package com.mycart.rewards.dto;

import java.io.Serializable;

public class CustomerRewardDto implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	private String customerId;

	private Long rewards;
	

	public CustomerRewardDto(String customerId, Long rewards) {
		super();
		this.customerId = customerId;
		this.rewards = rewards;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public Long getRewards() {
		return rewards;
	}

	public void setRewards(Long rewards) {
		this.rewards = rewards;
	}
	
}
