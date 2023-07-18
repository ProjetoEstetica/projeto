package br.com.estetica.view;


import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import br.com.estetica.model.InfoProdutos;
import br.com.estetica.podutosDAO.ComandosBancoProduto;
import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProdutosTela {

	private JFrame frame;
	private JTable table;
	private JTextField textFieldProduto;
	private JTextField textFieldTipoProduto;
	private JTextField textFieldCusto;
	private JTextField textFieldPrecoVenda;
	private JTextField textFieldDescMax;
	private JTextField textFieldDescPromo;
	private JTextField textFieldComissao;
	private JTextField textFieldDescontaComi;
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

	public void tableLoad() {
		try {
			Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/produtos", "root",
					"");
			PreparedStatement pst = (PreparedStatement) con
					.prepareStatement("SELECT produto FROM cadastro_produtos ORDER BY nome_completo ASC");
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
		// importando as config do banco
		ComandosBancoProduto execBanco = new ComandosBancoProduto();
		// info dos produtos
		InfoProdutos execProdutos = new InfoProdutos();

		frame = new JFrame();
		frame.setBounds(100, 100, 800, 641);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblProdutos = new JLabel("Produtos");
		lblProdutos.setFont(new Font("Arial", Font.PLAIN, 20));
		lblProdutos.setBounds(361, 11, 115, 31);
		frame.getContentPane().add(lblProdutos);

		JPanel panelDados = new JPanel();
		panelDados.setBorder(new TitledBorder(null, "Dados", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDados.setBounds(10, 48, 396, 385);
		frame.getContentPane().add(panelDados);
		panelDados.setLayout(null);

		JLabel LblTipoProd = new JLabel("Tipo Produto");
		LblTipoProd.setBounds(10, 66, 116, 18);
		LblTipoProd.setFont(new Font("Arial", Font.PLAIN, 15));
		panelDados.add(LblTipoProd);

		JLabel LblNome = new JLabel("Nome");
		LblNome.setFont(new Font("Arial", Font.PLAIN, 15));
		LblNome.setBounds(10, 23, 106, 18);
		panelDados.add(LblNome);

		JLabel LblCusto = new JLabel("Custo");
		LblCusto.setFont(new Font("Arial", Font.PLAIN, 15));
		LblCusto.setBounds(10, 110, 106, 18);
		panelDados.add(LblCusto);

		JLabel LblPrecoVenda = new JLabel("Preço Venda");
		LblPrecoVenda.setFont(new Font("Arial", Font.PLAIN, 15));
		LblPrecoVenda.setBounds(10, 150, 106, 18);
		panelDados.add(LblPrecoVenda);

		JLabel LblDescMax = new JLabel("Desconto Máximo");
		LblDescMax.setFont(new Font("Arial", Font.PLAIN, 15));
		LblDescMax.setBounds(10, 195, 144, 18);
		panelDados.add(LblDescMax);

		JLabel LblDescPromo = new JLabel("Desconto Promoção");
		LblDescPromo.setFont(new Font("Arial", Font.PLAIN, 15));
		LblDescPromo.setBounds(10, 248, 144, 18);
		panelDados.add(LblDescPromo);

		JLabel LblComicao = new JLabel("Comissão");
		LblComicao.setFont(new Font("Arial", Font.PLAIN, 15));
		LblComicao.setBounds(10, 292, 144, 18);
		panelDados.add(LblComicao);

		JLabel LblDescComi = new JLabel("Desconta Comissão");
		LblDescComi.setFont(new Font("Arial", Font.PLAIN, 15));
		LblDescComi.setBounds(10, 333, 144, 18);
		panelDados.add(LblDescComi);

		textFieldProduto = new JTextField();
		textFieldProduto.setBounds(55, 23, 129, 20);
		panelDados.add(textFieldProduto);
		textFieldProduto.setColumns(10);

		textFieldTipoProduto = new JTextField();
		textFieldTipoProduto.setColumns(10);
		textFieldTipoProduto.setBounds(102, 66, 129, 20);
		panelDados.add(textFieldTipoProduto);

		textFieldCusto = new JTextField();
		textFieldCusto.setColumns(10);
		textFieldCusto.setBounds(55, 110, 129, 20);
		panelDados.add(textFieldCusto);

		textFieldPrecoVenda = new JTextField();
		textFieldPrecoVenda.setColumns(10);
		textFieldPrecoVenda.setBounds(102, 150, 129, 20);
		panelDados.add(textFieldPrecoVenda);

		textFieldDescMax = new JTextField();
		textFieldDescMax.setColumns(10);
		textFieldDescMax.setBounds(132, 195, 129, 20);
		panelDados.add(textFieldDescMax);

		textFieldDescPromo = new JTextField();
		textFieldDescPromo.setColumns(10);
		textFieldDescPromo.setBounds(153, 248, 129, 20);
		panelDados.add(textFieldDescPromo);

		textFieldComissao = new JTextField();
		textFieldComissao.setColumns(10);
		textFieldComissao.setBounds(80, 292, 129, 20);
		panelDados.add(textFieldComissao);

		textFieldDescontaComi = new JTextField();
		textFieldDescontaComi.setColumns(10);
		textFieldDescontaComi.setBounds(153, 333, 129, 20);
		panelDados.add(textFieldDescontaComi);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(416, 53, 358, 380);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		// Adicione um ouvinte de seleção à table
		table.getSelectionModel().addListSelectionListener(e -> {
			// Verifique se alguma linha está selecionada
			if (table.getSelectedRow() != -1) {
				// Obtenha o valor da coluna "produto" da linha selecionada
				String produto = table.getValueAt(table.getSelectedRow(), 0).toString();

				// Use o valor obtido para buscar as informações correspondentes no banco de
				// dados
				// e definir os campos de texto
				try {
					Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/produtos",
							"root", "");
					PreparedStatement pst = (PreparedStatement) con
							.prepareStatement("SELECT * FROM cadastro_produtos WHERE produto = ?");
					pst.setString(1, produto);
					ResultSet rs = pst.executeQuery();

					// Verifique se o resultado contém dados
					if (rs.next()) {
						textFieldProduto.setText(rs.getString("produto"));
						textFieldTipoProduto.setText(rs.getString("tipo_produto"));
						textFieldCusto.setText(rs.getString("custo"));
						textFieldPrecoVenda.setText(rs.getString("preco_venda"));
						textFieldDescMax.setText(rs.getString("desconto_max"));
						textFieldDescPromo.setText(rs.getString("desconto_promo"));
						textFieldComissao.setText(rs.getString("comissao"));

					}
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		});

		// adicionar as registro
		JButton btnNovo = new JButton("Cadastrar");
		btnNovo.setFont(new Font("Arial", Font.PLAIN, 15));
		btnNovo.addActionListener(new ActionListener() {

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
		btnNovo.setBounds(126, 555, 115, 36);
		frame.getContentPane().add(btnNovo);

		// alterar registro
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setFont(new Font("Arial", Font.PLAIN, 15));
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
		btnAlterar.setBounds(265, 555, 115, 36);
		frame.getContentPane().add(btnAlterar);

		// botao de limpar linhas
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Arial", Font.PLAIN, 15));
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
				textFieldLocalizar.setText("");

				textFieldProduto.requestFocus();

			}
		});
		btnLimpar.setBounds(416, 555, 115, 36);
		frame.getContentPane().add(btnLimpar);

		// botao de deletar
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setFont(new Font("Arial", Font.PLAIN, 15));
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				execBanco.deletar(textFieldLocalizar.getText());

				// limpando campos
				textFieldProduto.setText("");
				textFieldTipoProduto.setText("");
				textFieldCusto.setText("");
				textFieldPrecoVenda.setText("");
				textFieldDescMax.setText("");
				textFieldDescPromo.setText("");
				textFieldComissao.setText("");
				textFieldDescontaComi.setText("");

				tableLoad();
			}
		});
		btnDeletar.setBounds(549, 555, 115, 36);
		frame.getContentPane().add(btnDeletar);

		// painel da aba localizar
		JPanel panelLocalizar = new JPanel();
		panelLocalizar.setForeground(new Color(0, 0, 0));
		panelLocalizar
				.setBorder(new TitledBorder(null, "Localizar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelLocalizar.setBounds(235, 444, 304, 71);
		frame.getContentPane().add(panelLocalizar);
		panelLocalizar.setLayout(null);

		textFieldLocalizar = new JTextField();
		textFieldLocalizar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {

					String product = textFieldLocalizar.getText();
					Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/produtos",
							"root", "");
					PreparedStatement pst = (PreparedStatement) con
							.prepareStatement("SELECT * from cadastro_produtos WHERE produto = ?");
					pst.setString(1, product);
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
		textFieldLocalizar.setBounds(68, 29, 207, 23);
		panelLocalizar.add(textFieldLocalizar);
		textFieldLocalizar.setColumns(10);

		JLabel lblNome = new JLabel("Nome :");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNome.setBounds(16, 31, 61, 14);
		panelLocalizar.add(lblNome);
		
		// filtro de dados da tabela em tempo real
		textFieldLocalizar.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				filterTable();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				filterTable();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				filterTable();
			}
		});

		// Adcionando ouvinte de seleção à table para levar texto para o textField
		table.getSelectionModel().addListSelectionListener(e -> {
			// Verifique se alguma linha está selecionada
			if (table.getSelectedRow() != -1) {
				// Obtenha o valor da coluna "produto" da linha selecionada
				String produto = table.getValueAt(table.getSelectedRow(), 0).toString();

				// Use o valor obtido para preencher o campo textFieldLocalizar
				textFieldLocalizar.setText(produto);
			}
		});

		// Adicione um ouvinte de seleção à table
		table.getSelectionModel().addListSelectionListener(e -> {
			// Verifique se alguma linha está selecionada
			if (table.getSelectedRow() != -1) {
				// Obtenha o valor da coluna "produto" da linha selecionada
				String produto = table.getValueAt(table.getSelectedRow(), 0).toString();

				// Use o valor obtido para buscar as informações correspondentes no banco de
				// dados
				// e definir os campos de texto
				try {
					Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/produtos",
							"root", "");
					PreparedStatement pst = (PreparedStatement) con
							.prepareStatement("SELECT * FROM cadastro_produtos WHERE produto = ?");
					pst.setString(1, produto);
					ResultSet rs = pst.executeQuery();

					// Verifique se o resultado contém dados
					if (rs.next()) {
						textFieldProduto.setText(rs.getString("produto"));
						textFieldTipoProduto.setText(rs.getString("tipo_produto"));
						textFieldCusto.setText(rs.getString("custo"));
						textFieldPrecoVenda.setText(rs.getString("preco_venda"));
						textFieldDescMax.setText(rs.getString("desconto_max"));
						textFieldDescPromo.setText(rs.getString("desconto_promo"));
						textFieldComissao.setText(rs.getString("comissao"));

					}
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		});

		// deixando a table imutável
		DefaultTableModel model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				// Definindo todas as células como não editáveis
				return false;
			}
		};
		table.setModel(model);

	}

	// pesquisa o nome digitado na table
	private void filterTable() {
		try {
			String localizaLetra = textFieldLocalizar.getText();
			// Consulta SQL para filtrar a table com base na inicial do nome completo
			String query = "SELECT produto FROM cadastro_produtos WHERE produto LIKE ? ORDER BY nome_completo ASC";
			Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/produtos", "root",
					"");
			PreparedStatement pst = (PreparedStatement) con.prepareStatement(query);
			pst.setString(1, localizaLetra + "%"); // Adiciona % apenas após a inicial
			ResultSet rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
