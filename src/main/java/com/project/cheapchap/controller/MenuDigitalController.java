package com.project.cheapchap.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class MenuDigitalController {

	@GetMapping("menu-digital")
	public ModelAndView index(HttpServletRequest request, Model model) {
		ModelAndView md = new ModelAndView("MenuDigital");
		return md;
	}
}
