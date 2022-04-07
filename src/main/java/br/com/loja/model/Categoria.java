package br.com.loja.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.loja.controller.ProdutosController;
import br.com.olimposistema.aipa.model.Model;

@Entity
public class Categoria extends Model{
		
	@NotEmpty @Size(min = 3, max = 100 ) 
	private String nomeCategoria;
	@OneToMany(mappedBy = "categoria")
	private List<Produto> produtoList;

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}
	
	
	
}
