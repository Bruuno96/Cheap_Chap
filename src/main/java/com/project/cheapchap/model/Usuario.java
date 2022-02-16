package com.project.cheapchap.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import javax.annotation.ManagedBean;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;

@Entity
@SequenceGenerator(name = "sq_usuario", sequenceName = "SQ_USUARIO", allocationSize = 1)
@Inheritance(strategy = InheritanceType.JOINED)
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

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "user_role", joinColumns = {
			@JoinColumn(name = "id_user")
	}, inverseJoinColumns = {
			@JoinColumn(name = "id_role")
	})
	private List<Role> roles = new ArrayList<>();
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="endereco_id")
	private Endereco endereco;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_carteira")
	private Carteira carteira;



	public Usuario() {
		super();
	}

	public Usuario(String nome, String ultimoNome, String username, String password, String email,
				   String telefone, byte[] fotoPerfil, String nomeImagem, List<Role> roles, Endereco endereco,
				   Carteira carteira) {
		this.nome = nome;
		this.ultimoNome = ultimoNome;
		this.username = username;
		this.password = password;
		this.email = email;
		this.telefone = telefone;
		this.fotoPerfil = fotoPerfil;
		this.nomeImagem = nomeImagem;
		this.roles = roles;
		this.endereco = endereco;
		this.carteira = carteira;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUltimoNome() {
		return ultimoNome;
	}

	public void setUltimoNome(String ultimoNome) {
		this.ultimoNome = ultimoNome;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public byte[] getFotoPerfil() {
		return fotoPerfil;
	}

	public void setFotoPerfil(byte[] fotoPerfil) {
		this.fotoPerfil = fotoPerfil;
	}

	public String getNomeImagem() {
		return nomeImagem;
	}

	public void setNomeImagem(String nomeImagem) {
		this.nomeImagem = nomeImagem;
	}

	public void addRole(Role role){
			 this.roles.add(role);
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Carteira getCarteira() {
		return carteira;
	}

	public void setCarteira(Carteira carteira) {
		this.carteira = carteira;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.roles;
	}

	@Override
	public String getUsername() {
		return this.email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
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

	public List<Role> getRoles() {
		return roles;
	}
}
