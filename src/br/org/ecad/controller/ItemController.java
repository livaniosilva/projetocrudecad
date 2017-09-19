package br.org.ecad.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.org.ecad.model.Item;
import br.org.ecad.persistence.ItemDaoImpl;

@ManagedBean
@SessionScoped
public class ItemController {
	
	@EJB
	private ItemDaoImpl itemDao;
	private Item item = new Item();
	private List<Item> listarItem;
	
	 public void salvar() {
		 FacesContext context = FacesContext.getCurrentInstance();
		 boolean resultado = itemDao.save(item);
		 
		 if(resultado) {
			 item = new Item();
			 context.addMessage(null, new FacesMessage("Item gravado com sucesso"));
		 } else
			 context.addMessage(null, new FacesMessage("Erro ao efetuar a transacao"));
	 }
	 
		public void remover() {
			FacesContext context = FacesContext.getCurrentInstance();
			boolean resultado = itemDao.remove(item);
			if(resultado) {
				item = new Item();
				context.addMessage(null, new FacesMessage("Item removido com sucesso"));
			}else
				context.addMessage(null, new FacesMessage("Erro ao efetuar a transacao"));
			
		}

		public List<Item>ListarItem(){
			listarItem = itemDao.listaItem();
			return listarItem;
		}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

}
