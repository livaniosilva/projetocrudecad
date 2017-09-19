package br.org.ecad.persistence;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.org.ecad.model.Item;

@Stateless
public class ItemDaoImpl implements ItemDao {
	@PersistenceContext(unitName="VersaoJPAPU")
	EntityManager em ;

	@Override
	public boolean save(Item item) {
			
		boolean sucesso = false;
		try {
				  em.merge(item);
				  sucesso = true;
		}catch (Exception e) {
			System.err.println("Erro ao efetuar transacao" + e);
			em.getTransaction().rollback();
		}
		 return sucesso;
	}



	@SuppressWarnings("unchecked")
	@Override
	public List<Item> listaItem() {
		List<Item>listar = null;
		try {
			Query query = em.createQuery("select i from item i");
			listar = query.getResultList();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return listar;
	}

	@Override
	public boolean remove(Item item) {
		boolean sucesso = false;
        try {
            Item itens = em.find(Item.class, item.getCodItem());
            em.remove(itens);
            sucesso = true;
        } catch (Exception e) {
        		System.err.println("Erro ao efetuar remocao" + e);
            em.getTransaction().rollback();
        }
        
        return sucesso;
		
	}

}
