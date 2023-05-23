package br.com.clientesDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

import br.com.estetica.model.InfoClients;
import br.com.factory.ConnectionFactory;

public class ClientesDAO {
	// Lugar para fazer o crud

	public void save(InfoClients client) {
		String insert = "insert into cadastro_clientes(nome_completo, apelido, celular, aniversario, cep, rua, numero, comp, bairro, cidade, estado) values(?,?,?,?,?,?,?,?,?,?,?)";

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
			pstm.setString(4, client.getAniversario());
			pstm.setString(5, client.getCep());
			pstm.setString(6, client.getRua());
			pstm.setInt(7, client.getNum());
			pstm.setString(8, client.getComp());
			pstm.setString(9, client.getBairro());
			pstm.setString(10, client.getCidade());
			pstm.setString(11, client.getEstado());

			// executando

			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			// finalizando o cursor
			try {
				if (pstm != null) {
					pstm.close();
				} else if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public List<InfoClients> getClientes() {
		String sql = "select * from cadastro_clientes";

		List<InfoClients> cliente = new ArrayList<InfoClients>();

		Connection conn = null;
		PreparedStatement pstm = null;
		// classe para recuperar os dados do banco
		ResultSet rset = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {
				InfoClients clientesInfo = new InfoClients();

				// recuperar o nome
				clientesInfo.setNomeCompleto(rset.getString("nome_completo"));
				// apelido
				clientesInfo.setApelido(rset.getString("apelido"));
				clientesInfo.setCelular(rset.getString("celular"));
				clientesInfo.setAniversario(rset.getString("aniversario"));
				clientesInfo.setCep(rset.getString("cep"));
				clientesInfo.setRua(rset.getString("rua"));
				clientesInfo.setNum(rset.getInt("numero"));
				clientesInfo.setComp(rset.getString("comp"));
				clientesInfo.setBairro(rset.getString("bairro"));
				clientesInfo.setCidade(rset.getString("cidade"));
				clientesInfo.setEstado(rset.getString("estado"));

				cliente.add(clientesInfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				} else if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return cliente;
	}

	public void update(String colunaUpdate, String novoValor, String colunaWhere, String valorWhere) {
		String sql = "UPDATE cadastro_clientes" + " SET " + colunaUpdate + " = '" + novoValor + "'" + " WHERE "
				+ colunaWhere + " = '" + valorWhere + "'";
				
		try {
			Connection conn = ConnectionFactory.createConnectionToMySQL();
			PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.execute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

	public void delete(String nome) {
		String sql = "delete from cadastro_clientes where nome_completo = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, nome);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				} else if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
