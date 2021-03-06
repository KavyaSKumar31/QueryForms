package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Customer;
import com.example.demo.entity.OnlineBooking;
import com.example.demo.entity.Query;
import com.example.demo.service.OnlineBookingService;
import com.example.demo.service.QueryService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class Controller {
	@Autowired
	private OnlineBookingService onlineBookingService;
	
	@Autowired
	private QueryService queryService;
	
	@PostMapping("/onlineBookings")
	public void saveOnlineBooking(@RequestBody OnlineBooking data) {
		System.out.println("data"+data.getSid());
		onlineBookingService.save(data);
		
	}
	@GetMapping("/getCustomerData/{email}")
	public Customer getCustomerData(@PathVariable String email) {
		return onlineBookingService.getCustomerData(email);
		
	}
	@PostMapping("/save")
	public void saveQueryForm(@RequestBody Query queryForm) {
		//System.out.println("hi");
		System.out.println("name"+queryForm.getFullName());
		System.out.println("email"+ queryForm.getEmail());
		System.out.println( "contact"+queryForm.getContact());
		System.out.println( "others"+queryForm.getOthers());
		System.out.println("quest"+ queryForm.getQuestion());
		queryService.saveForm(queryForm);
		
	}
}
