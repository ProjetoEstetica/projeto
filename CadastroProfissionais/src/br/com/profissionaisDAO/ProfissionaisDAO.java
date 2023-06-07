package br.com.profissionaisDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;


import br.com.estetica.model.InfoProfissionais;
import br.com.factory.ConnectionFactory;
import net.proteanit.sql.DbUtils;

public class ProfissionaisDAO {
	// Lugar para fazer o crud

	public void save(InfoProfissionais prof) {
		String insert = "INSERT into cadastro_profissionais(nome_completo, apelido, celular, aniversario, cep, rua, numero, comp, bairro, cidade, estado) values(?,?,?,?,?,?,?,?,?,?,?)";

		Connection conn = null;
		// prepara estrutura para executar
		PreparedStatement pstm = null;

		try {
			// tentando realizar conexao com o banco
			conn = ConnectionFactory.createConnectionToMySQL();
			// adicionando string no cursor para executar no mysql
			pstm = (PreparedStatement) conn.prepareStatement(insert);
			// guardando valor no sql
			pstm.setString(1, prof.getNomeCompleto());
			pstm.setString(2, prof.getApelido());
			pstm.setString(3, prof.getCelular());
			pstm.setString(4, prof.getAniversario());
			pstm.setString(5, prof.getCep());
			pstm.setString(6, prof.getRua());
			pstm.setInt(7, prof.getNum());
			pstm.setString(8, prof.getComp());
			pstm.setString(9, prof.getBairro());
			pstm.setString(10, prof.getCidade());
			pstm.setString(11, prof.getEstado());

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

	public void update(InfoProfissionais prof, String id) {
		String update =  "UPDATE cadastro_profissionais set nome_completo = ?, apelido = ?, celular = ?, aniversario = ?, cep = ?, rua = ?, numero = ?, comp = ?, bairro = ?, cidade = ?, estado = ? where id = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(update);
			pstm.setString(1, prof.getNomeCompleto());
			pstm.setString(2, prof.getApelido());
			pstm.setString(3, prof.getCelular());
			pstm.setString(4, prof.getAniversario());
			pstm.setString(5, prof.getCep());
			pstm.setString(6, prof.getRua());
			pstm.setInt(7, prof.getNum());
			pstm.setString(8, prof.getComp());
			pstm.setString(9, prof.getBairro());
			pstm.setString(10, prof.getCidade());
			pstm.setString(11, prof.getEstado());
			pstm.setString(12, id);

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
		
		String deletar = "DELETE from cadastro_profissionais where id =?";
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(deletar);
			pstm.setString(1, id);
			pstm.executeUpdate();
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
