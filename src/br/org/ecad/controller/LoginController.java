package br.org.ecad.controller;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.org.ecad.model.Login;
import br.org.ecad.persistence.LoginDao;
import br.org.ecad.persistence.LoginDaoImpl;

@ManagedBean
@ViewScoped
public class LoginController {
	
	@EJB
	private LoginDao loginDao = new LoginDaoImpl();
	private Login login = new Login();
	
	public void gravar() {
		FacesContext context = FacesContext.getCurrentInstance();

		boolean resultado = loginDao.save(login);
		limpar();
		if(resultado) {
			login = new Login();
			context.addMessage(null, new FacesMessage("Login gravado com sucesso"));
		}else
			context.addMessage(null, new FacesMessage("Erro ao efetuar a transacao"));
		
	}
	public void limpar() {
		login = new Login();
	}
	
	public void remover() {
		FacesContext context = FacesContext.getCurrentInstance();
		boolean resultado = loginDao.remove(login);
		if(resultado) {
			login = new Login();
			context.addMessage(null, new FacesMessage("Login removido com sucesso"));
		}else
			context.addMessage(null, new FacesMessage("Erro ao efetuar a transacao"));
		
	}
	
	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
	
	
	

}
