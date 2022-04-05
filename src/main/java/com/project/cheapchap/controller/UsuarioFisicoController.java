package com.project.cheapchap.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

import javax.validation.Valid;

import com.project.cheapchap.model.Usuario;
import com.project.cheapchap.model.UsuarioJuridico;
import com.project.cheapchap.service.UsuarioJuridicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.cheapchap.model.UsuarioFisico;
import com.project.cheapchap.service.UsuarioFisicoService;

@Controller
@RequestMapping("/")
public class UsuarioFisicoController {

	public static String FOLDER_PATH = "C:\\Users\\Windows 10\\OneDrive\\Área de Trabalho\\ECLIPSE\\CheapChap\\Cheap_Chap\\src\\main\\java\\com\\project\\cheapchap\\Imagens\\";

	@Autowired
	private UsuarioFisicoService fisicoService;

	@Autowired
	private UsuarioJuridicoService juridicoService;


	@PostMapping("RegistroPessoaFisica")
	public String save(@Valid UsuarioFisico usuarioFisico,
					   @ModelAttribute("data") String dataNascimento ,
					   BindingResult result,
					   ModelAndView model,
					   RedirectAttributes redirAttrs,
					   @RequestParam("file") MultipartFile arquivo) throws ParseException {
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

				try {
					if(!arquivo.isEmpty()){
						byte[] bytes = arquivo.getBytes();
						Path path = Paths.get(FOLDER_PATH+arquivo.getOriginalFilename());
						Files.write(path,bytes);
						usuarioFisico.setNomeImagem(arquivo.getOriginalFilename());
					}
				}catch (IOException exception){
					exception.printStackTrace();
				}
				LocalDate dt= LocalDate.parse(dataNascimento);
				usuarioFisico.setDataNascimento(dt);
				fisicoService.create(usuarioFisico);
				return "index";
			}
		}
	}
	 
	 	@GetMapping("/mostrarImagem/{imagem}")
	 	@ResponseBody
	 	public byte[] exibirImagem(@PathVariable("imagem") String imagem, Authentication authentication) throws IOException {
	 		File imagemArquivo = new File(FOLDER_PATH + imagem);
//			UsuarioFisico u = authentication.getPrincipal();
			if(imagem != null) {
	 			return Files.readAllBytes(imagemArquivo.toPath());
	 		}
	 		return null;
	 	}
	
	
}
