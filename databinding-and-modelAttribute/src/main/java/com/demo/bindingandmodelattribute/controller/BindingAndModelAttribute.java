package com.demo.bindingandmodelattribute.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.bindingandmodelattribute.model.UserInfoDTO;

@Controller
public class BindingAndModelAttribute {

	@RequestMapping("/homePage")
	public String printHelloWorld(Model model) {
		//read the default properties by fetching it from DTO class
		UserInfoDTO userInfo=new UserInfoDTO();
		model.addAttribute("userInfo",userInfo);
		return "index";
	}
	
	//Use of @ModelAttribute annotation: we can get the input values through form tag modelAttribute and bind to UserInfoDTO properties
	@RequestMapping("/")
	public String homePage(@ModelAttribute("userInfo") UserInfoDTO userInfoDTO) {
		return "index";
	}

	@RequestMapping("/process-page")
	public String getResult(@RequestParam("yourName") String yourName,
			@RequestParam("crushName") String crushName,Model model) {
		//@RequestParam is basically used to bind the url query string parameters to the method parameter 
		model.addAttribute("yourName",yourName);
		model.addAttribute("crushName",crushName);
		return "result-home";
	}
	
	
	//Another Way to binding variables through POJO class 
	@RequestMapping("/process-page-dto")
	public String getResults(UserInfoDTO userInfoDTO,Model model) {
		//writing the value to the DTO class properties by fetching from url
		model.addAttribute("yourName",userInfoDTO.getYourName());
		model.addAttribute("crushName",userInfoDTO.getCrushName());
		return "result-home";
	}
	
	@RequestMapping("/process-page-dto-modelAttribute")
	public String getResults(@ModelAttribute("userInfo") UserInfoDTO userInfoDTO) {
		//writing the value to the DTO class properties by fetching from url
		return "result-home";
	}
	
	@RequestMapping("/email-landing")
	public String emailPageLanding() {
		return "email-home";
	}

}
