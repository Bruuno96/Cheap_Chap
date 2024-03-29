package com.project.cheapchap.controller;

import javax.servlet.http.HttpServletRequest;

import com.project.cheapchap.model.*;
import com.project.cheapchap.service.EventoService;
import com.project.cheapchap.service.UsuarioFisicoService;
import com.project.cheapchap.service.UsuarioJuridicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/")
public class EventoController {

	public static String FOLDER_PATH = "C:\\Users\\Windows 10\\OneDrive\\Área de Trabalho\\ECLIPSE\\CheapChap\\Cheap_Chap\\src\\main\\java\\com\\project\\cheapchap\\ImagensEvento\\";

	@Autowired
	private EventoService eventoService;


	
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

	@GetMapping("lista")
	public ModelAndView listOnDashboard(Model model, Authentication auth, Evento evento, BindingResult result) {
		UsuarioJuridico u =  (UsuarioJuridico)  auth.getPrincipal();
		List<Evento> list = eventoService.findByUsuarioJuridicoId(u.getIdUsuario());
		ModelAndView modelAndView = new ModelAndView("listaEventosDashboard");
		modelAndView.addObject("lista",list);
		return modelAndView;
	}

	@PostMapping("/createEvent")
	public String createEvent(Evento evento, BindingResult result,
							  @ModelAttribute("dataInicio") String dataInicio,
							  @ModelAttribute("dataTermino") String dataTermino,
							  @ModelAttribute("horaInicio") String horaInicio,
							  @ModelAttribute("horaFinal") String horaFinal,
							  RedirectAttributes redirAttrs,
							  Authentication authentication,
							  @RequestParam("fotoBanner")MultipartFile arquivo) throws ParseException {

		LocalDate dt= LocalDate.parse(dataInicio);
		LocalDate dt2= LocalDate.parse(dataTermino);
		String dataInicioFormat = dt + " " + horaInicio;
		String dataInicioFormat2 = dt2 + " " + horaFinal;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime dateTime = LocalDateTime.parse(dataInicioFormat, formatter);
		LocalDateTime dateTime2 = LocalDateTime.parse(dataInicioFormat2, formatter);
		evento.setDataInicio(dateTime);
		evento.setDataTermino(dateTime2);
		UsuarioJuridico principal = (UsuarioJuridico) authentication.getPrincipal();
		principal.getEventos().addAll(Arrays.asList(evento));
		evento.setUsuarioJuridico(principal);
		Evento created = eventoService.create(evento);
		try {
			if(!arquivo.isEmpty()){
				byte[] bytes = arquivo.getBytes();
				Path path = Paths.get(FOLDER_PATH+String.valueOf(created.getId())+arquivo.getOriginalFilename());
				Files.write(path,bytes);
				evento.setFotoBanner(String.valueOf(created.getId())+arquivo.getOriginalFilename());
			}
		}catch (IOException exception){
			exception.printStackTrace();
		}

		eventoService.create(created);
		return "redirect:/lista";
	}

	@GetMapping("/mostrarImagemEvento/{imagem}")
	@ResponseBody
	public byte[] exibirImagem(@PathVariable("imagem") String imagem, Authentication authentication) throws IOException {
		File imagemArquivo = new File(FOLDER_PATH + imagem);
		if(imagem != null) {
			return Files.readAllBytes(imagemArquivo.toPath());
		}
		return null;
	}

}