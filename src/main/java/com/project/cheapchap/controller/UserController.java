package com.project.cheapchap.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.cheapchap.model.Endereco;
import com.project.cheapchap.model.UsuarioFisico;
import com.project.cheapchap.model.UsuarioJuridico;

@ControllerAdvice
@RequestMapping("/")
public class UserController {

	
	@GetMapping("RegistroPessoaFisica")
 	public ModelAndView indexFisico(Endereco endereco, UsuarioFisico usuarioFisico, BindingResult br, Model model) {
		ModelAndView modelAndView = new ModelAndView("RegistroPessoaFisica");
        return modelAndView;
    }
 	
 	@GetMapping("RegistroPessoaJuridica")
 	public ModelAndView indexJuridico(UsuarioJuridico usuarioJuridico) {
        ModelAndView modelAndView = new ModelAndView("RegistroPessoaJuridica");
        return modelAndView;
    }
 	
 	@GetMapping("LoginPage")
 	public ModelAndView login(HttpServletRequest request, Model model) {
        ModelAndView modelAndView = new ModelAndView("LoginPage");
        return modelAndView;
    }
 	 	
 	 
 	
}
