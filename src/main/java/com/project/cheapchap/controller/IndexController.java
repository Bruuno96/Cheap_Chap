package com.project.cheapchap.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.project.cheapchap.model.UsuarioFisico;
import com.project.cheapchap.service.UsuarioFisicoService;

@Controller
@RequestMapping("/")
public class IndexController {
	
		@Autowired
		private UsuarioFisicoService fisicoService;


	 	@GetMapping("index")
	    public ModelAndView index(HttpServletRequest request, Model model) {
	        ModelAndView modelAndView = new ModelAndView("index");
	        return modelAndView;
	    }

		@GetMapping("new")
		public ModelAndView dash(HttpServletRequest request, Model model) {
			ModelAndView modelAndView = new ModelAndView("dashboardSideBar");
			return modelAndView;
		}
	 	
	 	
	 	
}