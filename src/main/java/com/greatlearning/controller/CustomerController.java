package com.greatlearning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.entity.CustomerEntity;
import com.greatlearning.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// need to inject our customer service
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model model) {
		model.addAttribute("customers", this.customerService.findAllCustomers());
		
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
				
		model.addAttribute("customer", new CustomerEntity());
		
		return "customer-form";
	}
	
	@PostMapping("/save")
	public String saveCustomer(@ModelAttribute("customer") CustomerEntity customer) {
		
		this.customerService.saveCustomer(customer);	
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int custId,
									Model model) {
		
		model.addAttribute("customer", this.customerService.getCustomer(custId));
		
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int custId) {
		
		this.customerService.deleteCustomer(custId);
		
		return "redirect:/customer/list";
	}
}










