package br.com.loja.interceptors;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.AcceptsWithAnnotations;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;
import br.com.loja.controller.LoginController;
import br.com.loja.model.Usuario;
import br.com.olimposistema.aipa.service.Util;

@Intercepts
@AcceptsWithAnnotations(SomenteLogado.class)
public class LoginInterceptor {
	
	@Inject HttpSession session;
	@Inject Result result;
	
	//continua se o usuario estiver logado
	@AroundCall
	public void prossegueLogado(SimpleInterceptorStack sis) { 
		
		
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
			
		if(Util.isNull(usuario)) {	
			result.redirectTo(LoginController.class).login();
		} else {
			sis.next();
		}
		
	}
	
}
