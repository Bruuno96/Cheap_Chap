package com.project.cheapchap.controller;

import javax.validation.Valid;

import com.project.cheapchap.Utils.ValidaCNPJ;
import com.project.cheapchap.model.UsuarioFisico;
import com.project.cheapchap.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.cheapchap.model.UsuarioJuridico;
import com.project.cheapchap.service.UsuarioJuridicoService;

import java.time.LocalDate;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class UsuarioJuridicoController {

	public static String FOLDER_PATH = "/home/bruno/Desktop/CheapChapProject/backend/cheapchap/src/main/java/com/project/cheapchap/Imagens";

	@Autowired
	private UsuarioJuridicoService juridicoService;


	@PostMapping("RegistroPessoaJuridica")
	public String save(@Valid UsuarioJuridico usuarioJuridico, BindingResult result, ModelAndView model, RedirectAttributes redirAttrs) {
		if (result.hasErrors()) {
			model.setViewName("RegistroPessoaJuridica");
			return "redirect:/RegistroPessoaJuridica";
		} else {
			Optional<UsuarioJuridico> u = juridicoService.findByEmail(usuarioJuridico.getEmail());
			Optional<UsuarioJuridico> cnpj = juridicoService.findByCnpj(usuarioJuridico.getCnpj());
			Optional<UsuarioJuridico> telefone = juridicoService.findByTelefone(usuarioJuridico.getTelefone());
			if (u.isPresent()) {
				System.out.println("Email já cadastrado ou inválido");
				redirAttrs.addFlashAttribute("message", "Email já cadastrado ou inválido");
				model.setViewName("RegistroPessoaJuridica");
				return "redirect:/RegistroPessoaJuridica";

				// SE cnpj estiver != null OU cnpj informado for false
			} else if (cnpj.isPresent() || ValidaCNPJ.isValidCNPJ(usuarioJuridico.getCnpj())) {
				System.out.println("erro cnpj");
				redirAttrs.addFlashAttribute("message2", "CNPJ já cadastrado ou inválido");
				return "redirect:/RegistroPessoaJuridica";
			} else if (telefone.isPresent()) {
				System.out.println("erro telefone");
				redirAttrs.addFlashAttribute("message3", "Telefone já cadastrado");
				return "redirect:/RegistroPessoaJuridica";
			} else {
				juridicoService.create(usuarioJuridico);
				model.setViewName("index");
				return "index";
			}
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
