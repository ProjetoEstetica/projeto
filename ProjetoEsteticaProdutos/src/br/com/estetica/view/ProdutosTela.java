package br.com.estetica.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import br.com.estetica.clientesDAO.ComandosBanco;
import br.com.estetica.model.InfoProdutos;
import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class ProdutosTela {

	private JFrame frame;
	private JTextField textFieldProduto;
	private JTextField textFieldTipoProduto;
	private JTextField textFieldCusto;
	private JTextField textFieldPrecoVenda;
	private JTextField textFieldDescMax;
	private JTextField textFieldDescPromo;
	private JTextField textFieldComissao;
	private JTextField textFieldDescontaComi;
	private JTable table;
	private JTextField textFieldLocalizar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProdutosTela window = new ProdutosTela();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ProdutosTela() {
		initialize();
		tableLoad();
	}
	
	// colocando a tabela
	public void tableLoad() {
		try {		
			Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/produtos", "root", "");
			PreparedStatement pst = (PreparedStatement) con.prepareStatement("select id, produto from cadastro_produtos");
			ResultSet rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 641);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel labelProduto = new JLabel("Produto");
		labelProduto.setFont(new Font("Tahoma", Font.PLAIN, 19));
		labelProduto.setBounds(21, 28, 87, 38);
		frame.getContentPane().add(labelProduto);
				
		JLabel labelTipoProduto = new JLabel("Tipo Produto");
		labelTipoProduto.setFont(new Font("Tahoma", Font.PLAIN, 19));
		labelTipoProduto.setBounds(21, 76, 120, 38);
		frame.getContentPane().add(labelTipoProduto);
				
		JLabel labelCusto = new JLabel("Custo");
		labelCusto.setFont(new Font("Tahoma", Font.PLAIN, 19));
		labelCusto.setBounds(21, 124, 87, 38);
		frame.getContentPane().add(labelCusto);
		
		JLabel labelPrecoVenda = new JLabel("Preço Venda");
		labelPrecoVenda.setFont(new Font("Tahoma", Font.PLAIN, 19));
		labelPrecoVenda.setBounds(10, 172, 121, 38);
		frame.getContentPane().add(labelPrecoVenda);
		
		JLabel labelDescontoMax = new JLabel("Desconto Maximo");
		labelDescontoMax.setFont(new Font("Tahoma", Font.PLAIN, 19));
		labelDescontoMax.setBounds(10, 220, 167, 38);
		frame.getContentPane().add(labelDescontoMax);
		
		JLabel labelDescontoPromo = new JLabel("Desconto Promo");
		labelDescontoPromo.setFont(new Font("Tahoma", Font.PLAIN, 19));
		labelDescontoPromo.setBounds(10, 278, 167, 38);
		frame.getContentPane().add(labelDescontoPromo);
		
		JLabel labelID = new JLabel("ID");
		labelID.setFont(new Font("Tahoma", Font.PLAIN, 19));
		labelID.setBounds(184, 456, 57, 38);
		frame.getContentPane().add(labelID);
		
		JLabel labelComissao = new JLabel("Comissao");
		labelComissao.setFont(new Font("Tahoma", Font.PLAIN, 19));
		labelComissao.setBounds(10, 334, 167, 38);
		frame.getContentPane().add(labelComissao);
		
		JLabel labelDescontaComissao = new JLabel("Desconta Comissao?");
		labelDescontaComissao.setFont(new Font("Tahoma", Font.PLAIN, 19));
		labelDescontaComissao.setBounds(10, 382, 201, 38);
		frame.getContentPane().add(labelDescontaComissao);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(419, 28, 357, 403);
		frame.getContentPane().add(scrollPane);
		
		textFieldProduto = new JTextField();
		textFieldProduto.setBounds(118, 35, 174, 33);
		frame.getContentPane().add(textFieldProduto);
		textFieldProduto.setColumns(10);
		
		textFieldTipoProduto = new JTextField();
		textFieldTipoProduto.setColumns(10);
		textFieldTipoProduto.setBounds(165, 83, 174, 33);
		frame.getContentPane().add(textFieldTipoProduto);
		
		textFieldCusto = new JTextField();
		textFieldCusto.setColumns(10);
		textFieldCusto.setBounds(98, 131, 174, 33);
		frame.getContentPane().add(textFieldCusto);
		
		textFieldPrecoVenda = new JTextField();
		textFieldPrecoVenda.setColumns(10);
		textFieldPrecoVenda.setBounds(141, 179, 174, 33);
		frame.getContentPane().add(textFieldPrecoVenda);
		
		textFieldDescMax = new JTextField();
		textFieldDescMax.setColumns(10);
		textFieldDescMax.setBounds(187, 227, 174, 33);
		frame.getContentPane().add(textFieldDescMax);
		
		textFieldDescPromo = new JTextField();
		textFieldDescPromo.setColumns(10);
		textFieldDescPromo.setBounds(187, 285, 174, 33);
		frame.getContentPane().add(textFieldDescPromo);
		
		textFieldComissao = new JTextField();
		textFieldComissao.setColumns(10);
		textFieldComissao.setBounds(118, 339, 174, 33);
		frame.getContentPane().add(textFieldComissao);
		
		textFieldDescontaComi = new JTextField();
		textFieldDescontaComi.setColumns(10);
		textFieldDescontaComi.setBounds(187, 382, 174, 33);
		frame.getContentPane().add(textFieldDescontaComi);
		
		textFieldLocalizar = new JTextField();
		textFieldLocalizar.setColumns(10);
		textFieldLocalizar.setBounds(236, 456, 174, 33);
		frame.getContentPane().add(textFieldLocalizar);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		ComandosBanco execBanco = new ComandosBanco();
		InfoProdutos execProdutos = new InfoProdutos();
		
		//adicionando info no banco
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String produto = textFieldProduto.getText();
				String tipoProduto = textFieldTipoProduto.getText();
				String custo = textFieldCusto.getText();
				String precoVenda = textFieldPrecoVenda.getText();
				String descMax = textFieldDescMax.getText();
				String descPromo = textFieldDescPromo.getText();
				int comissao = Integer.parseInt(textFieldComissao.getText());
				String descComissao = textFieldDescontaComi.getText();
				
				execProdutos.setProduto(produto);
				execProdutos.setTipo_produto(tipoProduto);
				execProdutos.setCusto(custo);
				execProdutos.setPrecoVenda(precoVenda);
				execProdutos.setDescontoMax(descMax);
				execProdutos.setDescontoPromo(descPromo);
				execProdutos.setComissao(comissao);
				execProdutos.setDescontaComissao(descComissao);
				
				execBanco.cadastrarProdutos(execProdutos);
				tableLoad();
				
				
			}
		});
		btnAdicionar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnAdicionar.setBounds(10, 519, 154, 56);
		frame.getContentPane().add(btnAdicionar);
		
		//setar os elementos
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String produto = textFieldProduto.getText();
				String tipoProduto = textFieldTipoProduto.getText();
				String custo = textFieldCusto.getText();
				String precoVenda = textFieldPrecoVenda.getText();
				String descMax = textFieldDescMax.getText();
				String descPromo = textFieldDescPromo.getText();
				int comissao = Integer.parseInt(textFieldComissao.getText());
				String descComissao = textFieldDescontaComi.getText();
				
				execProdutos.setProduto(produto);
				execProdutos.setTipo_produto(tipoProduto);
				execProdutos.setCusto(custo);
				execProdutos.setPrecoVenda(precoVenda);
				execProdutos.setDescontoMax(descMax);
				execProdutos.setDescontoPromo(descPromo);
				execProdutos.setComissao(comissao);
				execProdutos.setDescontaComissao(descComissao);
				
				execBanco.alterarPordutos(execProdutos, textFieldLocalizar.getText());
				tableLoad();
				
			}
		});
		btnAlterar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnAlterar.setBounds(201, 519, 154, 56);
		frame.getContentPane().add(btnAlterar);
		
		// limpando campos
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textFieldProduto.setText("");
				textFieldTipoProduto.setText("");
				textFieldCusto.setText("");
				textFieldPrecoVenda.setText("");
				textFieldDescMax.setText("");
				textFieldDescPromo.setText("");
				textFieldComissao.setText("");
				textFieldDescontaComi.setText("");

				textFieldProduto.requestFocus();
			}
		});
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnLimpar.setBounds(384, 519, 154, 56);
		frame.getContentPane().add(btnLimpar);
		
		//deletando info do banco
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textFieldLocalizar.getText();
				execBanco.deletar(id);
				tableLoad();
				
				//limpando campos
				textFieldProduto.setText("");
				textFieldTipoProduto.setText("");
				textFieldCusto.setText("");
				textFieldPrecoVenda.setText("");
				textFieldDescMax.setText("");
				textFieldDescPromo.setText("");
				textFieldComissao.setText("");
				textFieldDescontaComi.setText("");
				
			}
		});
		btnDeletar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnDeletar.setBounds(573, 519, 154, 56);
		frame.getContentPane().add(btnDeletar);
		
		// colocando informacoes para o usuario pelo id
		textFieldLocalizar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {

					String id = textFieldLocalizar.getText();
					Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/produtos", "root", "");
					PreparedStatement pst = (PreparedStatement) con.prepareStatement(
							"SELECT * from cadastro_produtos WHERE id = ?");
					pst.setString(1, id);
					ResultSet rs = pst.executeQuery();

					if (rs.next() == true) {

						String produto = rs.getString(2);
						String tipoProduto = rs.getString(3);
						String custo = rs.getString(4);
						String precoVenda = rs.getString(5);
						String descMax = rs.getString(6);
						String descPromo = rs.getString(7);
						String comissao = rs.getString(8);
						String descComissao = rs.getString(9);

						textFieldProduto.setText(produto);
						textFieldTipoProduto.setText(tipoProduto);
						textFieldCusto.setText(custo);
						textFieldPrecoVenda.setText(precoVenda);
						textFieldDescMax.setText(descMax);
						textFieldDescPromo.setText(descPromo);
						textFieldComissao.setText(comissao);
						textFieldDescontaComi.setText(descComissao);
				

					} else {
						textFieldProduto.setText("");
						textFieldTipoProduto.setText("");
						textFieldCusto.setText("");
						textFieldPrecoVenda.setText("");
						textFieldDescMax.setText("");
						textFieldDescPromo.setText("");
						textFieldComissao.setText("");
						textFieldDescontaComi.setText("");
					}

				}

				catch (SQLException ex) {
					ex.printStackTrace();
				}

			}
		});
		
	}
}
