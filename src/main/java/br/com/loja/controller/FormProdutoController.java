package br.com.loja.controller;

import javax.inject.Inject;
import javax.validation.Valid;

import br.com.caelum.vraptor.validator.Validator;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.loja.dao.CategoriaDAO;
import br.com.loja.dao.ProdutoDAO;
import br.com.loja.interceptors.SomenteLogado;
import br.com.loja.model.Produto;


@Controller
@Path("formProduto")
public class FormProdutoController {
	
	@Inject Validator validator;
	@Inject CategoriaDAO categoriaDao;
	@Inject ProdutoDAO prodDao;
	@Inject Result result;
	
	@Get("") //@SomenteLogado
	public void formProduto(Produto produto) {
		
		result.include("categorias", categoriaDao.selectAll());
		
	}
	
	@Post("salvaFormProduto")
	public void salvaFormProduto( @Valid Produto produto) {
		System.out.println("\n\n\n passou por produto \n\n\n");
		validator.addIf(produto ==  null, new SimpleMessage("erro", "produto invalida"));
		validator.onErrorRedirectTo(this).formProduto(produto);// no erro 
		prodDao.insert(produto);
		System.out.println("\n\n inseriu \n\n");
		result.redirectTo(ProdutosController.class).produtos();
	}
}
