package br.org.ecad.persistence;

import java.util.List;

import br.org.ecad.model.Versao;

public interface VersaoDao {
	public boolean save(Versao versao);
	public List<Versao> listaVersao();
	public boolean remove (Versao versao);
}
