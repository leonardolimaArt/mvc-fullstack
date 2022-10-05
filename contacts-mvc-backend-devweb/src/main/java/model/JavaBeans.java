package model;

public class JavaBeans {

	private int idcontatos_ctt;
	private String nome_ctt;
	private String fone_ctt;
	private String email_ctt;
	private int idsucontac_ctt;
	
	private int idusuario_usr;
	private String nome_usr;
	private String email_usr;
	private String senha_usr;
	
	public JavaBeans() {
		super();
	}
	public JavaBeans(int idcontatos_ctt, String nome_ctt, String fone_ctt, String email_ctt) {
		super();
		this.idcontatos_ctt = idcontatos_ctt;
		this.nome_ctt = nome_ctt;
		this.fone_ctt = fone_ctt;
		this.email_ctt = email_ctt;
	
	}
	public int getIdcontatos_ctt() {
		return idcontatos_ctt;
	}
	public void setIdcontatos_ctt(int idcontatos_ctt) {
		this.idcontatos_ctt = idcontatos_ctt;
	}
	public String getNome_ctt() {
		return nome_ctt;
	}
	public void setNome_ctt(String nome_ctt) {
		this.nome_ctt = nome_ctt;
	}
	public String getFone_ctt() {
		return fone_ctt;
	}
	public void setFone_ctt(String fone_ctt) {
		this.fone_ctt = fone_ctt;
	}
	public String getEmail_ctt() {
		return email_ctt;
	}
	public void setEmail_ctt(String email_ctt) {
		this.email_ctt = email_ctt;
	}
	public int getIdsucontac_ctt() {
		return idsucontac_ctt;
	}
	public void setIdsucontac_ctt(int idsucontac_ctt) {
		this.idsucontac_ctt = idsucontac_ctt;
	}
	
	
	
	
	public int getIdusuario_usr() {
		return idusuario_usr;
	}
	public void setIdusuario_usr(int idusuario_usr) {
		this.idusuario_usr = idusuario_usr;
	}
	public String getNome_usr() {
		return nome_usr;
	}
	public void setNome_usr(String nome_usr) {
		this.nome_usr = nome_usr;
	}
	public String getEmail_usr() {
		return email_usr;
	}
	public void setEmail_usr(String email_usr) {
		this.email_usr = email_usr;
	}
	public String getSenha_usr() {
		return senha_usr;
	}
	public void setSenha_usr(String senha_usr) {
		this.senha_usr = senha_usr;
	}
	
	
	
}
