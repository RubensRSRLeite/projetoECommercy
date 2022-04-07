package br.com.loja.controller;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.loja.dao.UsuarioDAO;
import br.com.loja.model.Usuario;
import br.com.olimposistema.aipa.dao.DAO;




//Definindo controller
@Controller
@Path("login")
public class LoginController {
	
	@Inject Validator validator; 
	@Inject EntityManager em;
	@Inject Result result;
	@Inject UsuarioDAO usuarioDao;
	@Inject HttpSession session;

	
	
	//Login method para chamar a pagina
	@Get("")
	public void login() {
		session.removeAttribute("usuarioLogado");
	}
	
	
	
	@Post("autenticar")
	public void autenticar( @NotEmpty String email, @NotEmpty  String senha) {
		validator.onErrorRedirectTo(this).login();
		Usuario usuario = usuarioDao.existeUsuarioCom(email, senha);
		
		session.setAttribute("usuarioLogado", usuario);
		
		validator.addIf(usuario ==  null, new SimpleMessage("erro", "email ou senha são invalidos"));
		validator.onErrorRedirectTo(this).login();
		result.redirectTo(ProdutosController.class).produtos();
		//System.out.println(usuario.getEmail()+ " " +usuario.getSenha());
		
	}
	
}
