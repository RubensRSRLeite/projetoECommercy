package br.com.loja.controller;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.loja.dao.UsuarioDAO;
import br.com.loja.interceptors.SomenteLogado;
import br.com.loja.model.Usuario;
import br.com.olimposistema.aipa.dao.DAO;

@Controller
@Path("cadastrar")
public class CadastrarController {
	
	@Inject EntityManager em;
	@Inject Result result;
	@Inject UsuarioDAO usuarioDao;
	@Inject Validator validator;
	@Inject HttpSession session;
	
	
	@Get("") 
	public void cadastrar() {
			
	}
	
	@Post("salvaUsuario")
	public void salvaUsuario( @Valid Usuario usuario, String confirmaSenha) {
		
		boolean senhaIgual = usuario.getSenha().equals(confirmaSenha);
		validator.ensure(senhaIgual, new SimpleMessage("erro", "A senha confirmada é diferente da senha anterior"));
		validator.onErrorRedirectTo(this).cadastrar();
		usuarioDao.insert(usuario);
		session.setAttribute("usuarioLogado", usuario);
		result.redirectTo(LoginController.class).login();
		System.out.println(usuario.getNome());
		System.out.println(usuario.getEmail());
		System.out.println(usuario.getSenha());
		
	}
}

