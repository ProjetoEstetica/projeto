package br.com.estetica.clientesDAO;

import java.sql.Connection;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

import br.com.estetica.factory.ConnectionFactory;
import br.com.estetica.model.InfoProdutos;

public class ComandosBanco {
	public void cadastrarProdutos(InfoProdutos products) {
		String insert = "insert into cadastro_clientes(produto, tipo_produto, custo, "
				+ "preco_venda, desconto_max, desconto_promo, comissao, " + "desconta_comi) values (?,?,?,?,?,?,?,?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(insert);

			InfoProdutos produto = new InfoProdutos();
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
}
