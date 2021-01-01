package com.ovo.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ovo.spring.model.Coupon;

public interface CouponRepo extends JpaRepository<Coupon, Long> {

	Coupon findByCode(String code);

}
