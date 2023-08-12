package br.com.estetica.servicosDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

import br.com.estetica.factory.ConnectionFactory;
import br.com.estetica.model.InfoServicos;
import net.proteanit.sql.DbUtils;

public class ComandosBancoServicos {
	// Lugar para fazer o crud

	public void save(InfoServicos client) {
		String insert = "insert into cadastro_servicos(nomeServico, categoria, tipoServico, custoProd, precoVenda, descontoMax, descontoPromo, duracaoAprox, comissao, percentComissao, descontarCustoProd, observacao) values(?,?,?,?,?,?,?,?,?,?,?,?)";

		Connection conn = null;

		// prepara estrutura para executar
		PreparedStatement pstm = null;

		try {
			// tentando realizar conexao com o banco
			conn = ConnectionFactory.createConnectionToMySQL();
			// adicionando string no cursor para executar no mysql
			pstm = (PreparedStatement) conn.prepareStatement(insert);
			// guardando valor no sql

			pstm.setString(1, client.getNomeServico());
			pstm.setString(2, client.getCategoria());
			pstm.setString(3, client.getTipoServico());
			pstm.setFloat(4, client.getCustoProd());
			pstm.setFloat(5, client.getPrecoVenda());
			pstm.setInt(6, client.getDescontoMax());
			pstm.setInt(7, client.getDescontoPromo());
			pstm.setInt(8, client.getDuracaoAprox());
			pstm.setString(9, client.getComissao());
			pstm.setInt(10, client.getPercentual());
			pstm.setInt(11, client.getDescontarProdutos());
			pstm.setString(12, client.getObservacao());
	
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

	public void update(InfoServicos client, String id) {
		String update =  "UPDATE cadastro_servicos set nomeServico = ?, categoria = ?, tipoServico = ?, custoProd = ?, precoVenda = ?, descontoMax = ?, descontoPromo = ?, duracaoAprox = ?, comissao = ?, percentComissao = ?, descontarCustoProd = ?, observacao = ? where id = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(update);
			pstm.setString(1, client.getNomeServico());
			pstm.setString(2, client.getCategoria());
			pstm.setString(3, client.getTipoServico());
			pstm.setFloat(4, client.getCustoProd());
			pstm.setFloat(5, client.getPrecoVenda());
			pstm.setInt(6, client.getDescontoMax());
			pstm.setInt(7, client.getDescontoPromo());
			pstm.setInt(8, client.getDuracaoAprox());
			pstm.setString(9, client.getComissao());
			pstm.setInt(10, client.getPercentual());
			pstm.setInt(11, client.getDescontarProdutos());
			pstm.setString(12, client.getObservacao());
			pstm.setString(13, id);
		
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
		
		String deletar = "delete from cadastro_servicos where id =?";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(deletar);
			pstm.setString(1, id);
			pstm.executeUpdate();
			JOptionPane.showMessageDialog(null, "Serviço Deletado!");
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
