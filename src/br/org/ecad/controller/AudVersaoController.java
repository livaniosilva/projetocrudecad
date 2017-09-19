package br.org.ecad.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.org.ecad.model.AudVersao;
import br.org.ecad.persistence.AudVersaoDaoImpl;

@ManagedBean
@SessionScoped
public class AudVersaoController {
	
	@EJB
	private AudVersaoDaoImpl audVersaoDao;
	private AudVersao audVersao = new AudVersao();
	private List<AudVersao> audVersoes;
	

	 public void salvar() {
		 FacesContext context = FacesContext.getCurrentInstance();
		 boolean resultado = audVersaoDao.save(audVersao);
		 
		 if(resultado) {
			 audVersao = new AudVersao();
			 context.addMessage(null, new FacesMessage("AudVersao gravado com sucesso"));
		 } else
			 context.addMessage(null, new FacesMessage("Erro ao efetuar a transacao"));
	 }
	 
	public void remover() {
		FacesContext context = FacesContext.getCurrentInstance();
		boolean resultado = audVersaoDao.remove(audVersao);
		if(resultado) {
			audVersao = new AudVersao();
			context.addMessage(null, new FacesMessage("AudVersao removido com sucesso"));
		}else
			context.addMessage(null, new FacesMessage("Erro ao efetuar a transacao"));
		
	}
	
	public AudVersao getAudVersao() {
		return audVersao;
	}
	
	public List<AudVersao>ListarAudVersao(){
		audVersoes = audVersaoDao.listaAudVersao();
		return audVersoes;
	}
	
	public void setAudVersao(AudVersao audVersao) {
		this.audVersao = audVersao;
	}
	
	

}
