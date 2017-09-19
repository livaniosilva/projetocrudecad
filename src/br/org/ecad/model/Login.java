package br.org.ecad.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="login")
@SequenceGenerator(sequenceName="seqLogin", name ="seqLogin")

public class Login implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="nomeLogin",length=20)
	private String nomLogin;
	
	@Column(name="textonome",length=80)
	private String txtNome;
	
	
	public Login(String nomeLogin, String nomeUsuario) {
		this.nomLogin = nomeLogin;
		this.txtNome = nomeUsuario;
	}
	public Login() {	}
	
	
	public String getNomeLogin() {
		return nomLogin;
	}
	public void setNomeLogin(String nomeLogin) {
		this.nomLogin = nomeLogin;
	}
	public String getTxtNome() {
		return txtNome;
	}
	public void setTxtNome(String txtNome) {
		this.txtNome = txtNome;
	}

	
	
	
	

}
