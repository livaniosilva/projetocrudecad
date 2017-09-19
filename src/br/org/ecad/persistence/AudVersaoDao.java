package br.org.ecad.persistence;

import java.util.List;

import br.org.ecad.model.AudVersao;

public interface AudVersaoDao {
	
	public boolean save(AudVersao audVersao);
	public List<AudVersao> listaAudVersao();
	public boolean remove (AudVersao audVersao);
	//public void update (AudVersao audversao);
	

}
