package br.com.clientesDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

import br.com.estetica.model.InfoClients;
import br.com.estetica.model.TesteData;
import br.com.factory.ConnectionFactory;
import net.proteanit.sql.DbUtils;

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
			TesteData data = new TesteData();
			data.setData(client.getAniversario());
			boolean hasError = data.getData(); // Armazena o resultado do método getData()

			if (hasError) {
			    JOptionPane.showMessageDialog(null, "Tem erro: " + hasError);
			} else {
			    JOptionPane.showMessageDialog(null, "Sem erro: " + hasError);
			    pstm.setString(4, client.getAniversario());
			    // Restante do código
			    if (client.getCep().length() != 9) {
			        JOptionPane.showMessageDialog(null, "CEP digitado de maneira incorreta. Tente: (xxxxx-xxx)");
			    } else {
			        pstm.setString(5, client.getCep());
			        pstm.setString(6, client.getRua());
			        pstm.setInt(7, client.getNum());
			        pstm.setString(8, client.getComp());
			        pstm.setString(9, client.getBairro());
			        pstm.setString(10, client.getCidade());
			        if (client.getEstado().length() == 2) {
			            pstm.setString(11, client.getEstado());
			            JOptionPane.showMessageDialog(null, "Adicionado com sucesso");
			        } else {
			            JOptionPane.showMessageDialog(null, "Estado tem menos ou mais que 2 caracteres");
			        }
			    }
			}



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

	public void update(InfoClients client, String id) {
		String update =  "UPDATE cadastro_clientes set nome_completo = ?, apelido = ?, celular = ?, aniversario = ?, cep = ?, rua = ?, numero = ?, comp = ?, bairro = ?, cidade = ?, estado = ? where id = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(update);
			pstm.setString(1, client.getNomeCompleto());
			pstm.setString(2, client.getApelido());
			pstm.setString(3, client.getCelular());
			if(client.getAniversario().length() != 10) {
				JOptionPane.showMessageDialog(null, "Aniversario digitado de maneira incorreta. tente:\n(dd/mm/yyyy)");
			}else {
				pstm.setString(4, client.getAniversario());
				if(client.getCep().length() != 9) {
					JOptionPane.showMessageDialog(null, "CEP digitado de maneira incorreta. tente:\n(xxxxx-xxx)");
				}else {
					pstm.setString(5, client.getCep());
					pstm.setString(6, client.getRua());
					pstm.setInt(7, client.getNum());
					pstm.setString(8, client.getComp());
					pstm.setString(9, client.getBairro());
					pstm.setString(10, client.getCidade());
					if(client.getEstado().length() == 2) {
						pstm.setString(11, client.getEstado());
						pstm.setString(12, id);
						JOptionPane.showMessageDialog(null, "Editado com sucesso");
					}else {
						JOptionPane.showMessageDialog(null, "Estado tem menos ou mais que 2 caracteres");
					}
				}
			}

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

	public void delete(String id) {
		
		String deletar = "delete from cadastro_clientes where id =?";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(deletar);
			pstm.setString(1, id);
			pstm.executeUpdate();
			JOptionPane.showMessageDialog(null, "Cliente Deletado!");
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
			}}
	}
}