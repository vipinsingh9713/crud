package com.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.emp.model.Employee;
import com.emp.service.EmployeeService;

import jakarta.validation.Valid;

@Controller
public class HomeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/")
	public String viewHomepage(Model model)
	{
		model.addAttribute("listOfEmployee", employeeService.getAllEmployee());
		return "home";
	}
	
	@GetMapping("/register-page")
	public String registerPage(Model model)
	{
		model.addAttribute("employee", new Employee());
		return "register";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("employee") Employee employee , BindingResult result, Model model)
	{
		if(result.hasErrors())
		{
			return "register";
		}
		
		if(!employeeService.isEmailUnique(employee.getEmail()))
		{
			result.rejectValue("email", "error.employee","email is already taken");
			
			return "register";
		}
		
		else
		{
			this.employeeService.saveEmployee(employee);
			model.addAttribute("success","Employee registered successfully....");
			return "redirect:/";
		}
	}
	
	@GetMapping(path="/delete/{id}")
	public String employeeDelete(@PathVariable("id") int id)
	{
		this.employeeService.deleteEmployee(id);
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") int id , Model model)
	{
		Employee employee = employeeService.getEmployeeById(id);
		model.addAttribute("employee",employee);
		return "update";
	}
	
	@PostMapping("/update/{id}")
	public String updateEmployee( @PathVariable("id") int id , @Valid @ModelAttribute("employee") Employee employee , BindingResult result , Model model)
	{
		if(result.hasErrors())
		{
			return "update";
		}
		
		else
		{
			employee.setId(id);
			this.employeeService.updateEmployee(employee);
			model.addAttribute("success","updated successfully");
			return "redirect:/";
		}
	}
	
}
