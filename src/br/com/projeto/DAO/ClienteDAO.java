package br.com.projeto.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.projeto.connectionfactory.ConnectionToMySql;
import br.com.projeto.model.Cliente;

public class ClienteDAO {

	public void saveCliente(Cliente cliente) {
		String query = "INSERT INTO cliente (nome,contato,cnpj) VALUES (?,?,?);";
		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionToMySql.connectionMySql();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, cliente.getNome());
			pstm.setString(2, cliente.getContato());
			pstm.setString(3, cliente.getCnpj());
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public List<Cliente> viewCliente() {

		String query = "SELECT * FROM cliente;";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<Cliente> clientesList = new ArrayList<Cliente>();

		try {
			conn = ConnectionToMySql.connectionMySql();
			pstm = conn.prepareStatement(query);
			rs = pstm.executeQuery();

			while (rs.next()) {
				Cliente cliente = new Cliente();
				rs.getInt("ID");
				rs.getString("nome");
				rs.getString("contato");
				rs.getString("cnpj");

				cliente.setID(rs.getInt("ID"));
				cliente.setNome(rs.getString("nome"));
				cliente.setContato(rs.getString("contato"));
				cliente.setCnpj(rs.getString("cnpj"));

				clientesList.add(cliente);
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstm != null)
					pstm.close();

				if (conn != null) {
					conn.close();
				}
			}

			catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		for(Cliente c:clientesList) {
			System.out.print(c.getID()+",");
			System.out.print(c.getNome()+",");
			System.out.print(c.getContato()+",");
			System.out.println(c.getCnpj());
		}
		
		return clientesList;
	}
	
	public void updateCliente(Cliente cliente,int ID) {
		String query = "UPDATE cliente SET nome = ?, contato = ? , cnpj = ? WHERE ID = ?"; 
		Connection conn = null;
		PreparedStatement pstm  = null;
		
		try {
			conn = ConnectionToMySql.connectionMySql();
			pstm = conn.prepareStatement(query);
			
			pstm.setString(1, cliente.getNome());
			pstm.setString(2, cliente.getContato());
			pstm.setString(3, cliente.getCnpj());
			pstm.setInt(4,ID);
			pstm.execute();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(pstm!=null) {
					pstm.close();
				}
				if(conn!=null) {
					conn.close();
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void deleteCliente(int ID) {
		String query = "DELETE FROM cliente WHERE ID = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionToMySql.connectionMySql();
			pstm = conn.prepareStatement(query);
			pstm.setInt(1, ID);
			pstm.execute();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			try {
				if(pstm!=null) {
					pstm.close();
				}
				if(conn!=null) {
					conn.close();
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
