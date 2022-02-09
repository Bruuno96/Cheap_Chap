package com.project.cheapchap.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/")
public class RestauranteController {


	 @GetMapping("/restaurantes")
	    public ModelAndView index(HttpServletRequest request, Model model) {
	        ModelAndView modelAndView = new ModelAndView("CategoriaRestaurante");
	        return modelAndView;
	    }
	 
	 @GetMapping("lista-restaurantes")
	 public ModelAndView list(HttpServletRequest request, Model model) {
	        ModelAndView modelAndView = new ModelAndView("lista-restaurantes");
	        return modelAndView;
	    }
	 
	 @GetMapping("more-Details-Restaurant")
	 public ModelAndView moreDetails(HttpServletRequest request, Model model) {
	        ModelAndView modelAndView = new ModelAndView("more-Details-Restaurant");
	        return modelAndView;
	    }
}
