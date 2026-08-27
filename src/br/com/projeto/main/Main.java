package br.com.projeto.main;

import br.com.projeto.DAO.ClienteDAO;

public class Main {
	public static void main(String[] args) {
		ClienteDAO CDAO = new ClienteDAO();
		
		CDAO.viewCliente();
	}
} 	
