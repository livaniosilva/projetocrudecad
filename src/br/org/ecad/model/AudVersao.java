package br.org.ecad.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="audversao")
@SequenceGenerator(sequenceName="seqAudVersao", name ="seqAudVersao")
public class AudVersao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator="seqAudVersao")
	private Integer cod_aud_versao ;
	
	@Column(name="nomeColuna",length=20)
	private String nom_coluna;
	
	@Column(name="conteudoAntigo",length=1001)
	private String conteudo_antigo;
	
	@Column(name="conteudoNovo",length=1001)
	private String conteudo_novo;
	
	@Id
	@ManyToOne
	@JoinColumn(name="col_nomLogin", referencedColumnName="nomLogin", insertable=false, updatable=false)
	private Login login;
	
	@Id
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="col_codVersao", referencedColumnName="codVersao", insertable=false, updatable=false)
	private Versao versao;
	
	public AudVersao() {	}

	public AudVersao(Integer cod_aud_versao, String nom_coluna, String conteudo_antigo, String conteudo_novo,
			Login login, Versao versao) {
		super();
		this.cod_aud_versao = cod_aud_versao;
		this.nom_coluna = nom_coluna;
		this.conteudo_antigo = conteudo_antigo;
		this.conteudo_novo = conteudo_novo;
		this.login = login;
		this.versao = versao;
	}

	public Integer getCod_aud_versao() {
		return cod_aud_versao;
	}

	public void setCod_aud_versao(Integer cod_aud_versao) {
		this.cod_aud_versao = cod_aud_versao;
	}

	public String getNom_coluna() {
		return nom_coluna;
	}

	public void setNom_coluna(String nom_coluna) {
		this.nom_coluna = nom_coluna;
	}

	public String getConteudo_antigo() {
		return conteudo_antigo;
	}

	public void setConteudo_antigo(String conteudo_antigo) {
		this.conteudo_antigo = conteudo_antigo;
	}

	public String getConteudo_novo() {
		return conteudo_novo;
	}

	public void setConteudo_novo(String conteudo_novo) {
		this.conteudo_novo = conteudo_novo;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public Versao getVersao() {
		return versao;
	}

	public void setVersao(Versao versao) {
		this.versao = versao;
	}
	
	
	
	
	

}
