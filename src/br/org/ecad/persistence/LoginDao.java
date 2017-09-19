package br.org.ecad.persistence;

import br.org.ecad.model.Login;

public interface LoginDao {
	public Login getLogin(String login);
	public boolean save (Login login);
	public boolean remove(Login login);

	}
