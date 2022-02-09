package com.project.cheapchap.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.cheapchap.model.UsuarioJuridico;
import com.project.cheapchap.service.UsuarioJuridicoService;

@Controller
@RequestMapping("/")
public class UsuarioJuridicoController {

	public static String FOLDER_PATH = "/home/bruno/Desktop/CheapChapProject/backend/cheapchap/src/main/java/com/project/cheapchap/Imagens";

	@Autowired
	private UsuarioJuridicoService juridicoService;

	
	 @PostMapping("RegistroPessoaJuridica")
     public String save(@Valid UsuarioJuridico usuarioJuridico,BindingResult result,ModelAndView model, RedirectAttributes redirAttrs)  {
 		if(result.hasErrors()) {
			model.setViewName("RegistroPessoaJuridica");
			return "redirect:/RegistroPessoaJuridica";
		}else {

			UsuarioJuridico u = juridicoService.findByUserEmail(usuarioJuridico.getEmail());			
			UsuarioJuridico findByCnpj = juridicoService.findByCnpj(usuarioJuridico.getCnpj());
			System.out.println("CNPJ encontrado: "+findByCnpj);
			if (u.getCnpj()  != null ) {			
				redirAttrs.addFlashAttribute("message", "Email já cadastrado");
				model.setViewName("RegistroPessoaJuridica");
				return "redirect:/RegistroPessoaJuridica";
			}else if(findByCnpj != null) {
				redirAttrs.addFlashAttribute("message2", "Cpf já cadastrado");
				return "redirect:/RegistroPessoaJuridica";
			}else {
				juridicoService.create(usuarioJuridico);
				model.setViewName("index");
				return "index";
				}
			}
	}
	 
		 
//	 	@GetMapping("usuarioFisico/{imagem}")
//	 	@ResponseBody
//	 	public byte[] exibirImagem(@PathVariable("imagem") String imagem) throws IOException {
//	 		File imagemArquivo = new File(FOLDER_PATH + imagem);
//	 		if(imagem != null) {
//	 			return Files.readAllBytes(imagemArquivo.toPath());
//	 		}
//	 		return null;
//	 	}
	
	
}
