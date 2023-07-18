package br.com.estetica.podutosDAO;

import java.sql.Connection;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

import br.com.estetica.factory.ConnectionFactory;
import br.com.estetica.model.InfoProdutos;

public class ComandosBancoProduto {
	public void cadastrarProdutos(InfoProdutos produto) {
		String insert = "insert into cadastro_produtos(produto, tipo_produto, custo, "
				+ "preco_venda, desconto_max, desconto_promo, comissao, desconta_comi) values (?,?,?,?,?,?,?,?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(insert);

			pstm.setString(1, produto.getProduto());
			pstm.setString(2, produto.getTipoProduto());
			pstm.setDouble(3, produto.getCusto());
			pstm.setDouble(4, produto.getPrecoVenda());
			pstm.setDouble(5, produto.getDescontoMax());
			pstm.setDouble(6, produto.getDescontoPromo());
			pstm.setInt(7, produto.getComissao());
			pstm.setString(8, produto.getDescontaComissao());
			pstm.execute();
			JOptionPane.showMessageDialog(null, "adicionado com sucesso");

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

	public void alterarPordutos(InfoProdutos produtos, String produto) {
		String update = "UPDATE cadastro_produtos set produto = ?,"
				+ " tipo_produto = ?, custo = ?, preco_venda = ?, desconto_max = ?, "
				+ "desconto_promo = ?, comissao = ?, desconta_comi = ? where produto = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(update);

			pstm.setString(1, produtos.getProduto());
			pstm.setString(2, produtos.getTipoProduto());
			pstm.setDouble(3, produtos.getCusto());
			pstm.setDouble(4, produtos.getPrecoVenda());
			pstm.setDouble(5, produtos.getDescontoMax());
			pstm.setDouble(6, produtos.getDescontoPromo());
			pstm.setInt(7, produtos.getComissao());
			pstm.setString(8, produtos.getDescontaComissao());
			pstm.setString(9, produto);
			pstm.execute();
			JOptionPane.showMessageDialog(null, "alterado com sucesso");

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

	public void deletar(String produto) {
		String deletar = "delete from cadastro_produtos where produto =?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(deletar);
			pstm.setString(1, produto);
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
