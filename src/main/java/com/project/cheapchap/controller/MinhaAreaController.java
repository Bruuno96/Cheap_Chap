package com.project.cheapchap.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import io.swagger.models.Model;

@Controller
@RequestMapping(value = "/")
public class MinhaAreaController {

	@GetMapping("/profile")
	public ModelAndView profile(HttpServletRequest http, Model model ) {
		ModelAndView md = new ModelAndView("profile");
		return md;
	}
	
	@GetMapping("/transferir")
	public ModelAndView trasfer(HttpServletRequest http, Model model ) {
		ModelAndView md = new ModelAndView("transferir");
		return md;
	}
	
	@GetMapping("/MinhaCarteira")
	public ModelAndView wallet(HttpServletRequest http, Model model ) {
		ModelAndView md = new ModelAndView("MinhaCarteira");
		return md;
	}
	
	@GetMapping("/saque")
	public ModelAndView withdraw(HttpServletRequest http, Model model ) {
		ModelAndView md = new ModelAndView("saque");
		return md;
	}
	
	@GetMapping("/dashboard")
	public ModelAndView dashboard(HttpServletRequest http, Model model ) {
		ModelAndView md = new ModelAndView("dashboard");
		return md;
	}
	
}
