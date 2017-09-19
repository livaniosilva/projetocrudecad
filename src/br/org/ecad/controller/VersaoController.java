package br.org.ecad.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.org.ecad.model.Versao;
import br.org.ecad.persistence.VersaoDaoImpl;

@ManagedBean
@SessionScoped
public class VersaoController {
	
	@EJB
	private VersaoDaoImpl versaoDao;
	private Versao versao = new Versao();
	private List<Versao> versoes;
	
	 public void salvar() {
		 FacesContext context = FacesContext.getCurrentInstance();
		 boolean resultado = versaoDao.save(versao);
		 
		 if(resultado) {
			 versao = new Versao();
			 context.addMessage(null, new FacesMessage("Versao gravado com sucesso"));
		 } else
			 context.addMessage(null, new FacesMessage("Erro ao efetuar a transacao"));
	 }
	 
	 
	 public void remover() {
			FacesContext context = FacesContext.getCurrentInstance();
			boolean resultado = versaoDao.remove(versao);
			if(resultado) {
				versao = new Versao();
				context.addMessage(null, new FacesMessage("Versao removido com sucesso"));
			}else
				context.addMessage(null, new FacesMessage("Erro ao efetuar a transacao"));
			
		}
	
	public Versao getVersao() {
		return versao;
	}
	
	public void setVersao(Versao versao) {
		this.versao = versao;
	}
	

	
	public List<Versao>ListarVersao(){
		versoes = versaoDao.listaVersao();
		return versoes;
	}
	



}
