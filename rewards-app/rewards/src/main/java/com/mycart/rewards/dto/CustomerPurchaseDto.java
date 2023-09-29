package com.mycart.rewards.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CustomerPurchaseDto implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@NotBlank
	private String customerId;

	@NotNull
	private Float amount;

	@NotNull
	@JsonFormat(pattern = "MM/dd/yyy")
	private Date purchaseDate;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

}
