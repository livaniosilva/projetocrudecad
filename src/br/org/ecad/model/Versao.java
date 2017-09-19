package br.org.ecad.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="versao")
@SequenceGenerator(sequenceName="seqVersao", name ="seqVersao")
public class Versao implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator="seqVersao")
	private Integer codVersao;
	
	@Column(name="NrVersao",length=10)
	private String nrVersao;
	
	@Column(name="data Versao")
	private Timestamp dataVersao;
	
	@Column(name="indLiberado",length=1)
	private String indLiberado;
	
	@Column(name="indSituacao",length=1)
	private String indSituacao;
	
	
	public Versao(Integer codigoVersao, String nrVersao, Timestamp dataVersao, String indLiberado, String indSituacao) {
		this.codVersao = codigoVersao;
		this.nrVersao = nrVersao;
		this.dataVersao = dataVersao;
		this.indLiberado = indLiberado;
		this.indSituacao = indSituacao;
	}
	
	public Versao() {}
	
	public Integer getCodigoVersao() {
		return codVersao;
	}
	public void setCodigoVersao(Integer codigoVersao) {
		this.codVersao = codigoVersao;
	}
	public String getNrVersao() {
		return nrVersao;
	}
	public void setNrVersao(String nrVersao) {
		this.nrVersao = nrVersao;
	}
	public Timestamp getDataVersao() {
		return dataVersao;
	}
	public void setDataVersao(Timestamp dataVersao) {
		this.dataVersao = dataVersao;
	}
	public String getIndLiberado() {
		return indLiberado;
	}
	public void setIndLiberado(String indLiberado) {
		this.indLiberado = indLiberado;
	}
	public String getIndSituacao() {
		return indSituacao;
	}
	public void setIndSituacao(String indSituacao) {
		this.indSituacao = indSituacao;
	}
	
	
	
	

}
