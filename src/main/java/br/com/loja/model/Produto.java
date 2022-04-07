package br.com.loja.model;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.swing.text.NumberFormatter;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;

import br.com.loja.rn.converterDataDeEnParaCalendar;
import br.com.olimposistema.aipa.imagem.Imagem;
import br.com.olimposistema.aipa.model.Model;

@Entity
public class Produto extends Model {

	@NotEmpty @NotNull(message ="{produtos.nome.notnull}")
	private String nome; 
	
	@NotNull(message ="{produtos.descricao.notnull}") @Type(type = "text") 
	private String descricao;
	
	@NotNull (message ="{produtos.valor.notnull}")
	@Min(value=1, message ="{produtos.valor.min}")
	private double valor;
	
	@ManyToOne @NotNull(message= "{produtos.categoria.notnull}")
	private Categoria categoria;
	
	@Temporal(TemporalType.DATE) @NotNull(message = "{produtos.dataValidade.notnull}")
	private Calendar dataValidade;
	
	@NotNull (message = "{produtos.imagem.notnull}")
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, 
	fetch = FetchType.EAGER, 
	orphanRemoval = true)
	private Imagem imagem;
	
	public Categoria getCategoria() {
		return categoria;
	}
	
	public Calendar getDataValidade() {
		return dataValidade;
	}
	
	public void setDataValidade(Calendar dataValidade) {
		this.dataValidade = dataValidade;
	}
	
	public void setDataValidadeEn(String data) {
		if(data == null) return;
		this.dataValidade = new converterDataDeEnParaCalendar().executa(data);
	}
	
	public String getDataValidadeFormatado() {
		String dataFormatado = new SimpleDateFormat("dd/MM/yyyy").format(dataValidade.getTime());
		return dataFormatado;
	}
	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public Imagem getImagem() {
		return imagem;
	}

	public void setImagem(Imagem imagem) {
		this.imagem = imagem;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public double getValor() {
		return valor;
	}
	
	public String getValorDinheiro() {
		String valorFormatado = NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(valor);
		return valorFormatado;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
}
