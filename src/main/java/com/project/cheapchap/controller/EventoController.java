package com.project.cheapchap.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class EventoController {
	
	 @GetMapping("cadastrarEvento")
	    public ModelAndView createEvent(HttpServletRequest request, Model model) {
	        ModelAndView modelAndView = new ModelAndView("cadastrarEvento");
	        return modelAndView;
	    }
	 
	 @GetMapping("eventos")
	    public ModelAndView listCategories(HttpServletRequest request, Model model) {
	        ModelAndView modelAndView = new ModelAndView("CategoriaEvento");
	        return modelAndView;
	    }
	 
	 @GetMapping("listaEventos")
	    public ModelAndView listEvent(HttpServletRequest request, Model model) {
	        ModelAndView modelAndView = new ModelAndView("lista-eventos");
	        return modelAndView;
	    }
	 
	 @GetMapping("more-Details-Events")
	 public ModelAndView moreDetailsEvent(HttpServletRequest request, Model model) {
	        ModelAndView modelAndView = new ModelAndView("more-Details-Events");
	        return modelAndView;
	    }
}