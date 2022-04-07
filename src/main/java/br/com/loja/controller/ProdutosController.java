package br.com.loja.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.loja.dao.ProdutoDAO;

@Controller
@Path("produtos")
public class ProdutosController {
	
	@Inject Result result;
	@Inject ProdutoDAO prodDao;
	
	@Get("")
	public void produtos() {
		
		result.include("produtos", prodDao.selectAll());
		
	}
}