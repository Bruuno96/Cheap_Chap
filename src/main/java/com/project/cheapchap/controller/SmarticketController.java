package com.project.cheapchap.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/")
public class SmarticketController {

	 @GetMapping("smartickets")
	    public ModelAndView createEvent(HttpServletRequest request, Model model) {
	        ModelAndView modelAndView = new ModelAndView("Smarticket");
	        return modelAndView;
	    }
			
	
}
