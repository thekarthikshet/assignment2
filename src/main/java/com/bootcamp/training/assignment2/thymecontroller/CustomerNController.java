package com.bootcamp.training.assignment2.thymecontroller;

import com.bootcamp.training.assignment2.model.Customer;
import com.bootcamp.training.assignment2.model.Job;
import com.bootcamp.training.assignment2.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

@Controller
public class CustomerNController {
	@Autowired
	CustomerService customerService;

	@GetMapping("/customers")
	public String getCustomers(Model model) {
		// Retrieve a list of customers from a service layer or database
		List<Customer> customers = customerService.findAll();
		model.addAttribute("customers", customers);
		return "customers";
	}

	@GetMapping("/addCustomer")
	public String addCustomer(Model model) {
		model.addAttribute("customer", new Customer());
		return "addCustomer";
	}

	@PostMapping("/addCustomer")
	public String addCustomer(Customer customer) {
		customerService.save(customer);
		return "redirect:/sales/add";
	}

	@GetMapping("/deleteCustomer/{id}")
	public String deleteCustomer(@PathVariable String id) {
		customerService.deleteById(id);
		return "redirect:/customers";
	}
}