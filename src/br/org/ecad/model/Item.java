package br.org.ecad.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="item")
@SequenceGenerator(sequenceName="seqItem", name ="seqItem")
public class Item implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator="seqItem")
	private Integer codItem;
	
	@OneToMany( cascade = CascadeType.ALL)
	@JoinTable(
			name="versaoItem",
			joinColumns = @JoinColumn(name="codItem"),
			inverseJoinColumns = @JoinColumn(name="codVersao")
			
			)
	
	@Column(name="Titulo", length=20)
	private String titulo;
	
	@Column(name="Descricao",length=500)
	private String txtDescricao;
	
	
	
	public Item() {}


	public Item(Integer codItem, String titulo, String txtDescricao) {
		super();
		this.codItem = codItem;
		this.titulo = titulo;
		this.txtDescricao = txtDescricao;
	}


	public Integer getCodItem() {
		return codItem;
	}


	public void setCodItem(Integer codItem) {
		this.codItem = codItem;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getTxtDescricao() {
		return txtDescricao;
	}


	public void setTxtDescricao(String txtDescricao) {
		this.txtDescricao = txtDescricao;
	}
	
	
	
	
}
