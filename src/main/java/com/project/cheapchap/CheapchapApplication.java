package com.project.cheapchap;

import java.util.*;
import java.util.stream.Collectors;

import com.project.cheapchap.model.*;
import com.project.cheapchap.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.project.cheapchap.service.EstabelecimentoService;
import com.project.cheapchap.service.EventoService;
import com.project.cheapchap.service.UsuarioJuridicoService;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@ComponentScan({"com.project.cheapchap.service"})
@ComponentScan({"com.project.cheapchap.repository"})
@EntityScan({"com.project.cheapchap.model"})
@SpringBootApplication
public class CheapchapApplication implements CommandLineRunner {


//	@Autowired
//	private EnderecoRepository enderecoRepository;
//
//	@Autowired
//	private UsuarioRepository userRepository;
//
//	@Autowired
//	private CarteiraRepository carteiraRepository;
//
	@Autowired
	private UsuarioJuridicoService usuarioJuridicoService;
//
//	@Autowired
//	private UsuarioRepository usuarioRepository;

//
//	@Autowired
//	private UsuarioJuridicoRepository us;
//
//	@Autowired
//	private EstabelecimentoService estabelecimentoService;
//
//	@Autowired
//	private TipoIngressoRepository tipoIngressoRepository;
//
	@Autowired
	private RoleRepository roleRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CheapchapApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//
//		UsuarioJuridico found = usuarioJuridicoService.findById(1L);
//		System.out.println("Usuario: "+found.getIdUsuario()+"\nNome: "+found.getNome());
//
//		List<Evento> byUsuarioJuridicoId = eventoService.findByUsuarioJuridicoId(1L);
//		byUsuarioJuridicoId.forEach((evento -> System.out.println("Evento"+evento.getNomeEvento()+" de usuario "+evento.getUsuarioJuridico().getIdUsuario())));

//		System.out.println("oi");


//		List<UsuarioJuridico> all = usuarioJuridicoService.findAll();
//		List<UsuarioJuridico> collect = all.stream()
//				.filter(u -> u.getEmail().equals("brunotkd96@gmail.com")).collect(Collectors.toList());


//	Endereco e = new Endereco(null,"Elisio Ferreira","358","São Lucas","São mateus","03964010","SP","Credicard Hall");

//		Role admin = new Role("ROLE_BUSINESS");
//		Role user = new Role("ROLE_USER");
//		Role superAdmin = new Role("ROLE_ADMIN");
//		roleRepository.saveAll(Arrays.asList(admin,user,superAdmin));

//		Role role_user = roleRepository.findByName("USER");
//
//		System.out.println(role_user.getName());

//		Categoria c1 = new Categoria(null,"POP");
//		Categoria c2 = new Categoria(null,"Pagode");
//		Categoria c3 = new Categoria(null,"Sertanejo");
//		Categoria c4 = new Categoria(null,"Forró");
//		Categoria c5 = new Categoria(null,"Rock");
//		Categoria c6 = new Categoria(null,"LGBTQIA+");
//		Categoria c7 = new Categoria(null,"Japonesa");
//		Categoria c8 = new Categoria(null,"Brasileira");
//		Categoria c9 = new Categoria(null,"Salgados");
//		Categoria c10 = new Categoria(null,"Chinesa");
//		Categoria c11 = new Categoria(null,"Lanches");
//		Categoria c12 = new Categoria(null,"Saudável");
//		categoriaRepository.saveAll(Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12));
//
//		Categoria categoria = categoriaRepository.findById(1L).orElseThrow();
////
//		Evento event = new Evento(null,"Bruno Mars","BANNER",Calendar.getInstance(),
//								Calendar.getInstance(),"Descrição do evento",2000,null,categoria,e);
////		
////		event.setCategoria(categoria);
//		UsuarioJuridico u = usuarioJuridicoService.findById(2L);
//		event.setUsuarioJuridico(u);
//		u.getEventos().add(event);
//		us.save(u);

		//		Estabelecimento estabelecimento = new Estabelecimento("Restaurante Da Vó",200,e,null);
//		
//		UsuarioJuridico u = usuarioJuridicoService.findById(1L);
//		estabelecimento.setCategoria(categoria);
//		estabelecimento.setUsuarioJuridico(u);
//		u.getEstabelecimentos().add(estabelecimento);
//		TipoIngresso tipo1 = new TipoIngresso(null, "MASCULINO");
//		TipoIngresso tipo2 = new TipoIngresso(null, "MEIA");
//		TipoIngresso tipo3 = new TipoIngresso(null, "FEMININO");
//		
//		tipoIngressoRepository.saveAll(Arrays.asList(tipo1,tipo2,tipo3));
//		
//	Evento evento = eventoRepository.findById(3L).orElseThrow();
//	TipoIngresso tipo = tipoIngressoRepository.findById(2L).orElseThrow();
//	Ingresso ingresso = new Ingresso(null,50,300,evento,tipo);
//	evento.getIngresso().add(ingresso);
//	ingresso.setEvento(evento);
//	eventoRepository.save(evento);
	
		
//		Evento event = eventoService.findById(1L);
//		UsuarioJuridico u = usuarioJuridicoService.findById(2L);
////		event.setUsuarioJuridico(u);
//		event.setUsuarioJuridico(u);
//		u.getEventos().add(event);
//		System.out.println(event.getUsuarioJuridico().getIdUsuario());
//		System.out.println(u.getEventos().size());
//		eventoRepository.save(evento);
//		us.save(u);
		
		
//		
//		usuarioJuridicoService.create(u);
		
		
		
	}

}
;