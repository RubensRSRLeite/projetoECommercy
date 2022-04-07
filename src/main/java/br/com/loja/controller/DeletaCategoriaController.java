package br.com.loja.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.loja.dao.CategoriaDAO;
import br.com.loja.interceptors.SomenteLogado;
import br.com.loja.model.Categoria;

@Controller
@Path("deletaCategoria")
public class DeletaCategoriaController {
	
	@Inject CategoriaDAO categoriaDao;
	@Inject Result result;
	
	
	@Get("/{categoria.id}")@SomenteLogado
	public void deletaCategoria(Categoria categoria) {
		
		categoriaDao.delete(categoria);
		result.redirectTo(CategoriasController.class).categorias();
		
	}

}
