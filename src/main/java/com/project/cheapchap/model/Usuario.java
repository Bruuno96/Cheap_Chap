package com.project.cheapchap.model;

import java.io.Serializable; 
import java.util.Collection;
import java.util.Objects;

import javax.annotation.ManagedBean;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;


@Entity
@SequenceGenerator(name = "sq_usuario", sequenceName = "SQ_USUARIO", allocationSize = 1)
@Data
@Inheritance(strategy = InheritanceType.JOINED)
@ManagedBean
public class Usuario implements UserDetails, Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_usuario")
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "sq_usuario")
	private Long idUsuario;

	@NotBlank(message = "O campo nome deve ser preenchido")
	@Column(name = "nm_primeiro_nome")
	private String nome;
	
	@NotBlank(message = "O campo ultimo nome deve ser preenchido")
	@Column(name = "nm_ultimo_nome")
	private String ultimoNome;
	
	@NotBlank(message = "Já existe ou deve ser preenchido.")
    @Column(unique=true)
    private String username;
	
	@NotBlank(message = "Dcoumento CPF deve ser preenchido")
    @JsonIgnore
    private String password;

    @NotBlank(message = "Email obrigatório")
	@Column(name = "ds_email", unique = true)
	@Email(message = "Insira um email válido")
	private String email;

    @NotBlank(message = "Celular deve ser preenchido")
	@NumberFormat(pattern = "(##)#####-####")
	@Column(name = "ds_telefone", length = 20, nullable = false, unique = true)
	private String telefone;
	
	@Column(name = "ft_perfil")
	@Lob
	private byte[] fotoPerfil;
	
	private String nomeImagem;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private Collection<Role> roles;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="endereco_id")
	private Endereco endereco;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_carteira")
	private Carteira carteira;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.roles;
	}
	
	public Usuario(Long idUsuario, String nome, String ultimoNome, String username, String password, String email,
			String telefone, byte[] fotoPerfil, Collection<Role> roles, Endereco endereco, Carteira carteira) {
		super();
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.ultimoNome = ultimoNome;
		this.username = username;
		this.password = password;
		this.email = email;
		this.telefone = telefone;
		this.fotoPerfil = fotoPerfil;
		this.roles = roles;
		this.endereco = endereco;
		this.carteira = carteira;
	}
	
	
	public Usuario() {
		super();
	}
	
	@Override
	public String getUsername() {
		return this.email;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(idUsuario, other.idUsuario);
	}

	@Override
	public int hashCode() {
		return Objects.hash(idUsuario);
	}

}
