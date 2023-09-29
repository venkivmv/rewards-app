package com.mycart.rewards.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mycart.rewards.dto.CustomerRewardDto;
import com.mycart.rewards.entity.CustomerPurchase;

@Transactional
@Repository
public interface CustomerPurchaseRepository extends JpaRepository<CustomerPurchase, Long> {
	
	@Query(value = "SELECT new com.mycart.rewards.dto.CustomerRewardDto(cr.customerId, SUM(cr.reward)) "
			  + "FROM CustomerPurchase as cr where cr.purchaseDate >= :start and cr.purchaseDate <= :end "
			  + " GROUP BY cr.customerId ORDER BY cr.customerId")
			List<CustomerRewardDto> findRewardsGroupByCustomers(Date start,Date end);
	
	
	@Query(value = "SELECT cr "
			  + "FROM CustomerPurchase AS cr where cr.purchaseDate >= :start and cr.purchaseDate <= :end and cr.customerId = :customerId")
	List<CustomerPurchase> findPurchaseByCustomerId(String customerId,Date start,Date end);
	
	
	@Query(value = "SELECT new java.lang.Long(SUM(cr.reward)) "
			  + "FROM CustomerPurchase AS cr where cr.purchaseDate >= :start and cr.purchaseDate <= :end")
			Long findTotalRewards(Date start,Date end);
	

}
