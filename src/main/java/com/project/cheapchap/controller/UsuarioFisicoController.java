package com.project.cheapchap.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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

	
	 @PostMapping("RegistroPessoaFisica")
     public String save(@Valid UsuarioFisico usuarioFisico,BindingResult result,ModelAndView model, RedirectAttributes redirAttrs)  {
 		if(result.hasErrors()) {
			model.setViewName("RegistroPessoaFisica");
			return "redirect:/RegistroPessoaFisica";
		}else {

			Optional<UsuarioFisico> u = fisicoService.findByEmail(usuarioFisico.getEmail());			
			Optional<UsuarioFisico> cpf = fisicoService.findByCpf(usuarioFisico.getCpf());
			
			if (!u.isEmpty() && cpf != null ) {			
				redirAttrs.addFlashAttribute("message", "Email já cadastrado");
				model.setViewName("RegistroPessoaFisica");
				return "redirect:/RegistroPessoaFisica";
			}else if(cpf != null) {
				redirAttrs.addFlashAttribute("message2", "Cpf já cadastrado");
				return "redirect:/RegistroPessoaFisica";
			}else {
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
