package br.org.ecad.persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.org.ecad.model.Login;

@Stateless
public class LoginDaoImpl implements LoginDao {
	@PersistenceContext(unitName="VersaoJPAPU")
	EntityManager em ;
	
	public Login getLogin(String nomelogin) {
		Login login = null;
		try {
			//login = (Login) em.createQuery("select l from login l where l.nomLogin = :nomLogin").setParameter("login", getLogin(nomelogin)).getSingleResult();
			login = em.find(Login.class, nomelogin);
		
		}catch (Exception e) {
			System.err.println("Erro ao obter login" + e);
			e.printStackTrace();
			
		}
		return login;
		
	}

	@Override
	public boolean save(Login login) {
		boolean sucesso = false;
		try {
				em.merge(login);
				sucesso =true;
				
		}catch (Exception e) {
			System.err.println("Erro ao salvar usuario" + e);
			e.printStackTrace();
			
		}
		return sucesso;
	}

	@Override
	public boolean remove(Login login) {
		boolean sucesso = false;
		try {	
				login = em.find(Login.class, login.getNomeLogin());
				em.remove(login);
				sucesso = true;
		
		}catch (Exception e) {
			System.err.println("Erro ao deletar usuario" + e);
			e.printStackTrace();
			}
		return sucesso;

		
	}

	

}
