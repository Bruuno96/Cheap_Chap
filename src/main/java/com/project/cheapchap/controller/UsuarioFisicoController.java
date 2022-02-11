package com.project.cheapchap.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.Optional;

import javax.validation.Valid;

import com.project.cheapchap.model.Usuario;
import com.project.cheapchap.model.UsuarioJuridico;
import com.project.cheapchap.service.UsuarioJuridicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.cheapchap.model.UsuarioFisico;
import com.project.cheapchap.service.UsuarioFisicoService;

@Controller
@RequestMapping("/")
public class UsuarioFisicoController {

	public static String FOLDER_PATH = "/home/bruno/Desktop/CheapChapProject/backend/cheapchap/src/main/java/com/project/cheapchap/Imagens";

	@Autowired
	private UsuarioFisicoService fisicoService;

	@Autowired
	private UsuarioJuridicoService juridicoService;


	@PostMapping("RegistroPessoaFisica")
	public String save(@Valid UsuarioFisico usuarioFisico, BindingResult result, ModelAndView model, RedirectAttributes redirAttrs)  {
		if(result.hasErrors()) {
			model.setViewName("RegistroPessoaFisica");
			return "redirect:/RegistroPessoaFisica";
		}else {
			Optional<UsuarioJuridico> u = juridicoService.findByEmail(usuarioFisico.getEmail());
			Optional<UsuarioFisico> cnpj = fisicoService.findByCpf(usuarioFisico.getCpf());
			Optional<UsuarioFisico> telefone = fisicoService.findByTelefone(usuarioFisico.getTelefone());
			if (u.isPresent()) {
				redirAttrs.addFlashAttribute("message", "Email já cadastrado ou inválido");
				model.setViewName("RegistroPessoaFisica");
				return "redirect:/RegistroPessoaFisica";
			}else if(cnpj.isPresent()) {
				System.out.println("erro cnpj");
				redirAttrs.addFlashAttribute("message2", "CNPJ já cadastrado ou inválido");
				return "redirect:/RegistroPessoaFisica";
			}else if(telefone.isPresent()){
				System.out.println("erro telefone");
				redirAttrs.addFlashAttribute("message3", "Telefone já cadastrado");
				return "redirect:/RegistroPessoaFisica";

			} else {
				fisicoService.create(usuarioFisico);
				model.setViewName("index");
				return "index";
			}
		}
	}
	 
	 @GetMapping("usuarioFisico/{imagem}")
	 	@ResponseBody
	 	public byte[] exibirImagem(@PathVariable("imagem") String imagem) throws IOException {
	 		File imagemArquivo = new File(FOLDER_PATH + imagem);
	 		if(imagem != null) {
	 			return Files.readAllBytes(imagemArquivo.toPath());
	 		}
	 		return null;
	 	}
	
	
}
