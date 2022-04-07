package br.com.loja.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.loja.dao.CategoriaDAO;
import br.com.loja.interceptors.SomenteLogado;
import br.com.loja.model.Categoria;
import br.com.olimposistema.aipa.service.Util;

@Controller
@Path("formCategorias")
public class FormCategoriasController {
	
	@Inject CategoriaDAO categoriaDao;

	@Inject Result result;
	@Inject Validator validator;
	
	@Get("") @SomenteLogado
	public void formCategorias(Categoria categoria ) {
		
		if(Util.isNotNull(categoria) && Util.isPositivo(categoria.getId())) {
			
			Categoria categoriaDoBanco = categoriaDao.selectPorId(categoria);
			result.include("categoria", categoriaDoBanco);

		}

	}
	
	@Post("salvaCategoria")
	public void salvaCategoria( @Valid Categoria categoria) {
		System.out.println("\n\n\n passou aqui \n\n\n");
		validator.addIf(categoria ==  null, new SimpleMessage("erro", "categoria invalida"));
		validator.onErrorRedirectTo(this).formCategorias(categoria);// no erro 
		categoriaDao.insertOrUpdate(categoria);  
		
		result.redirectTo(CategoriasController.class).categorias();// no acerto
		
		
		System.out.println(categoria.getNomeCategoria());
		
		
	}
}
