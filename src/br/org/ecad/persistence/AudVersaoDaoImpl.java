package br.org.ecad.persistence;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.org.ecad.model.AudVersao;


@Stateless
public class AudVersaoDaoImpl implements AudVersaoDao{
	@PersistenceContext(unitName="VersaoJPAPU")
	EntityManager em ;

	@Override
	public boolean save(AudVersao audVersao) {
		boolean sucesso = false;
		try {
				  em.merge(audVersao);
				  sucesso = true;
		}catch (Exception e) {
			System.err.println("Erro ao efetuar transacao" + e);
			em.getTransaction().rollback();
		}
		 return sucesso;
		
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<AudVersao> listaAudVersao() {
		List<AudVersao>listar = null;
		try {
			Query query = em.createQuery("select aud from audversao aud");
			listar = query.getResultList();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return listar;
	}

	@Override
	public boolean remove(AudVersao audVersao) {
		boolean sucesso = false;
	        try {
	            AudVersao aud = em.find(AudVersao.class, audVersao.getCod_aud_versao());
	            em.remove(aud);
	            sucesso = true;
	        } catch (Exception e) {
	        		System.err.println("Erro ao efetuar remocao" + e);
	            em.getTransaction().rollback();
	        }
	        
	        return sucesso;
		
	}

	/*@Override
	public void update(AudVersao audVersao) {
		try {
				  em.merge(audVersao);
				  sucesso = true;
		}catch (Exception e) {
			System.err.println("Erro ao efetuar transacao" + e);
			em.getTransaction().rollback();
		}
		return sucesso;
	}*/
}
