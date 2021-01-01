package com.ovo.spring.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ovo.spring.model.Coupon;
import com.ovo.spring.repo.CouponRepo;

@RestController
@RequestMapping("/couponapi")
public class CouponRestController {
    
	@Autowired 
	CouponRepo repo;
	

	@RequestMapping(value = "/coupons", method = RequestMethod.GET)
	@ResponseBody 
	public List<Coupon> taskList(Map<String, Object> model) {
	    List<Coupon> couponList = repo.findAll();
	    return couponList;
	  }
	
	@RequestMapping(value = "/coupons",method = RequestMethod.POST)
	 public Coupon create (@RequestBody Coupon coupon){
		return repo.save(coupon);
		 
	 }
	
	@RequestMapping(value = "/coupons/{code}",method = RequestMethod.GET)
	public Coupon getCoupon(@PathVariable("code") String code) {
		return repo.findByCode(code);
		
		
  }
}