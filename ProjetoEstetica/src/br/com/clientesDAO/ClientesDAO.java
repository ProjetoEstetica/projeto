package br.com.clientesDAO;

import java.sql.Connection;
import java.sql.Date;


import com.mysql.jdbc.PreparedStatement;

import br.com.estetica.model.InfoClients;
import br.com.factory.ConnectionFactory;

public class ClientesDAO {
	// Lugar para fazer o crud
	
	public void save(InfoClients client) {
		String insert = 
		"insert into cadastro_clientes(nome_completo, apelido, celular, aniversario, cep, rua, numero, comp, bairro, cidade, estado) values(?,?,?,?,?,?,?,?,?,?,?)";
		
		Connection conn = null;
		
		// prepara estrutura para executar
		PreparedStatement pstm = null;
		
		try {
			// tentando realizar conexao com o banco
			conn = ConnectionFactory.createConnectionToMySQL();
			// adicionando string no cursor para executar no mysql
			pstm = (PreparedStatement) conn.prepareStatement(insert);
			// guardando valor no sql
			pstm.setString(1, client.getNomeCompleto());
			pstm.setString(2, client.getApelido());
			pstm.setString(3, client.getCelular());
			pstm.setDate(4, new Date(client.getAniversario().getTime()));
			pstm.setString(5, client.getCep());
			pstm.setString(6, client.getRua());
			pstm.setInt(7, client.getNum());
			pstm.setString(8, client.getComp());
			pstm.setString(9, client.getBairro());
			pstm.setString(10, client.getCidade());
			pstm.setString(11, client.getEstado());
			
			
			//executando 
			
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
			// finalizando o cursor
			try {
				if (pstm != null) {
					pstm.close();
				}
				else if(conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
