package br.com.loja.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import br.com.olimposistema.aipa.model.Model;

@Entity
public class Usuario extends Model{
	
	
	@NotEmpty @Size(min = 3, max = 100, message= "{usuario.nome.size}" )
	private String nome;
	@NotNull @Email  @Size(min = 5, max = 200, message= "{usuario.email.size}" ) @Column(unique = true)
	private String email;
	@NotNull  @Size(min = 5, max = 100, message= "{usuario.senha.size}" )
	private String senha;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
	
}
