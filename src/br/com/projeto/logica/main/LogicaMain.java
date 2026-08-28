package br.com.projeto.logica.main;

import java.util.Scanner;

import br.com.projeto.DAO.ClienteDAO;
import br.com.projeto.model.Cliente;

public class LogicaMain {

	
	
	public static void iniciarPrograma() {
		
		
		boolean escolha = false;
		do {
			Scanner sc = new Scanner(System.in);
			System.out.println("Tabela Cliente:");
			System.out.println("1.Adicionar");
			System.out.println("2.Atualizar");
			System.out.println("3.Listar");
			System.out.println("4.Deletar");
			System.out.println("5.Sair do Programa");
			
			int opcao = sc.nextInt();
			sc.nextLine();
			
			if(opcao == 1) {
				System.out.println();
				System.out.println("Nome do Cliente:");
				String nomeCliente = sc.nextLine();
				System.out.println("Contato do Cliente:");
				String contatoCliente = sc.nextLine();
				System.err.println("Caso não tenha CNPJ deixe em branco!");
				System.out.println("CNPJ do Cliente:");
				String cnpjCliente = sc.nextLine();
				
				if(cnpjCliente == "" || cnpjCliente == " ") {
					cnpjCliente = "NULL";
				}
				
				Cliente c = new Cliente(nomeCliente, contatoCliente, cnpjCliente);
				
				ClienteDAO Cdao = new ClienteDAO();
				
				Cdao.saveCliente(c);
				
				System.out.println();
				
				Cdao.viewCliente();
				
				System.out.println();
			}
			
			if(opcao == 2 ) {
				ClienteDAO Cdao = new ClienteDAO();
				
				System.out.println();
				
				System.out.println("Nome do Cliente:");
				String nomeCliente = sc.nextLine();
				System.out.println("Contato do Cliente:");
				String contatoCliente = sc.nextLine();
				System.err.println("Caso não tenha CNPJ deixe em branco!");
				System.out.println("CNPJ do Cliente:");
				String cnpjCliente = sc.nextLine();
				System.out.println();
				Cdao.viewCliente();
				System.out.println();
				System.out.println("Qual o ID para atualizar?");
				int ID = sc.nextInt();
				
				if(cnpjCliente == "" || cnpjCliente == " ") {
					cnpjCliente = "NULL";
				}
				
				Cliente c = new Cliente(nomeCliente, contatoCliente, cnpjCliente);
				
				
				
				Cdao.updateCliente(c, ID);
				
			}
			
			if(opcao ==3) {
				ClienteDAO cdao = new ClienteDAO();
				System.out.println();
				cdao.viewCliente();
				System.out.println();
				
			}
			
			if(opcao == 4) {
				ClienteDAO cdao = new ClienteDAO();
				System.out.println();
				cdao.viewCliente();
				System.out.println("Apagar qual Cliente,DIGITAR ID");
				int IDapagar = sc.nextInt();
				
				
				
				cdao.deleteCliente(IDapagar);
				System.out.println();
				
			}
			
			if(opcao == 5) {
				escolha = true;
			}
			
			

		} while (escolha != true);
		
	}
}
