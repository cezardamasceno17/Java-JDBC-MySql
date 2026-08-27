package br.com.projeto.model;

public class Cliente {
	private int ID;
	private String nome;
	private String contato;
	private String cnpj;

	public Cliente() {
	}

	public Cliente(String nome, String contato, String cnpj) {
		this.nome = nome;
		this.contato = contato;
		this.cnpj = cnpj;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

}
