package br.org.ecad.persistence;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.org.ecad.model.Versao;

@Stateless
public class VersaoDaoImpl implements VersaoDao {
	@PersistenceContext(unitName="VersaoJPAPU")
	EntityManager em ;

	@Override
	public boolean save(Versao versao) {
		boolean sucesso = false;
		try {
				  em.merge(versao);
				  sucesso = true;
		}catch (Exception e) {
			System.err.println("Erro ao efetuar transacao" + e);
			em.getTransaction().rollback();
		}
		 return sucesso;
	}

	

	@SuppressWarnings("unchecked")
	@Override
	public List<Versao> listaVersao() {
		List<Versao>listar = null;
		try {
			Query query = em.createQuery("select v from versao v");
			listar = query.getResultList();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return listar;
	}

	@Override
	public boolean remove(Versao versao) {
		boolean sucesso = false;
        try {
            Versao vers = em.find(Versao.class, versao.getCodigoVersao());
            em.remove(vers);
            sucesso = true;
        } catch (Exception e) {
        		System.err.println("Erro ao efetuar remocao" + e);
            em.getTransaction().rollback();
        }
        
        return sucesso;
		
	}

	

}
