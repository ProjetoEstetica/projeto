package br.com.estetica.view;

import java.awt.EventQueue;

import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import br.com.estetica.model.InfoServicos;
import br.com.factory.ConnectionFactory;
import br.com.servicosDAO.ServicosDAO;
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
import br.com.factory.ConnectionFactory;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class ServicosTela{

	private JFrame frame;
	private JTextField textNomeServico;
	private JTextField textCategoria;
	private JTextField textTipoServico;
	private JTextField textCustoProd;
	private JTextField textPrecoVenda;
	private JTextField textDescontoMax;
	private JTextField textDescontoPromo;
	private JTextField textDuracaoAprox;
	private JTextField textComissao;
	private JTextField textPercentual;
	private JTextField textDescontarProdutos;
	private JTextField textObservacao;
	private JTextField textLocalizar;
	private JTable tabela;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServicosTela window = new ServicosTela();
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
	public ServicosTela() {
		initialize();
		tableLoad();
	}
	
	public void tableLoad() {
        try {
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/servicos", "root", "");
            PreparedStatement pst = (PreparedStatement) con.prepareStatement("select id, nomeServico from cadastro_servicos");
            ResultSet rs = pst.executeQuery();
            tabela.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//importando as config do banco
		ServicosDAO servicosDB = new ServicosDAO();
		// info dos clientes
		InfoServicos exec = new InfoServicos();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 735);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Serviços");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setBounds(370, 5, 75, 31);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Dados", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 33, 396, 485);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel LblCategoria = new JLabel("Categoria:");
		LblCategoria.setBounds(10, 53, 67, 18);
		LblCategoria.setFont(new Font("Arial", Font.PLAIN, 15));
		panel.add(LblCategoria);
		
		JLabel LblNomeServico = new JLabel("Nome do serviço:");
		LblNomeServico.setFont(new Font("Arial", Font.PLAIN, 15));
		LblNomeServico.setBounds(10, 23, 116, 18);
		panel.add(LblNomeServico);
		
		JLabel LblTipoServico = new JLabel("Tipo do serviço:");
		LblTipoServico.setFont(new Font("Arial", Font.PLAIN, 15));
		LblTipoServico.setBounds(10, 82, 106, 18);
		panel.add(LblTipoServico);
		
		JLabel LblCustoProd = new JLabel("Custo com produtos:");
		LblCustoProd.setFont(new Font("Arial", Font.PLAIN, 15));
		LblCustoProd.setBounds(10, 111, 137, 18);
		panel.add(LblCustoProd);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Comiss\u00F5es", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(8, 250, 377, 112);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel LblTipoComissao = new JLabel("Tipo de comissão:");
		LblTipoComissao.setBounds(10, 22, 120, 18);
		panel_1.add(LblTipoComissao);
		LblTipoComissao.setFont(new Font("Arial", Font.PLAIN, 15));
		
		JLabel LblComissaoPercentual = new JLabel("Comissão percentual:");
		LblComissaoPercentual.setFont(new Font("Arial", Font.PLAIN, 15));
		LblComissaoPercentual.setBounds(10, 51, 143, 18);
		panel_1.add(LblComissaoPercentual);
		
		JLabel LblDescontarCustoProdutos = new JLabel("Descontar custo de produtos:");
		LblDescontarCustoProdutos.setFont(new Font("Arial", Font.PLAIN, 15));
		LblDescontarCustoProdutos.setBounds(10, 80, 198, 18);
		panel_1.add(LblDescontarCustoProdutos);
		
		textComissao = new JTextField();
		textComissao.setBounds(131, 22, 185, 20);
		panel_1.add(textComissao);
		textComissao.setColumns(10);
		
		textPercentual = new JTextField();
		textPercentual.setBounds(153, 51, 41, 20);
		panel_1.add(textPercentual);
		textPercentual.setColumns(10);
		
		textDescontarProdutos = new JTextField();
		textDescontarProdutos.setBounds(203, 80, 68, 20);
		panel_1.add(textDescontarProdutos);
		textDescontarProdutos.setColumns(10);
		
		textNomeServico = new JTextField();
		textNomeServico.setBounds(129, 23, 258, 20);
		panel.add(textNomeServico);
		textNomeServico.setColumns(10);
		
		textCategoria = new JTextField();
		textCategoria.setBounds(80, 54, 289, 18);
		panel.add(textCategoria);
		textCategoria.setColumns(10);
		
		textTipoServico = new JTextField();
		textTipoServico.setBounds(117, 82, 252, 20);
		panel.add(textTipoServico);
		textTipoServico.setColumns(10);
		
		textCustoProd = new JTextField();
		textCustoProd.setBounds(149, 111, 86, 20);
		panel.add(textCustoProd);
		textCustoProd.setColumns(10);
		
		JLabel LblProdutoReais = new JLabel("reais");
		LblProdutoReais.setFont(new Font("Arial", Font.PLAIN, 15));
		LblProdutoReais.setBounds(239, 114, 46, 14);
		panel.add(LblProdutoReais);
		
		JLabel LblPrecoVenda = new JLabel("Preço de venda:");
		LblPrecoVenda.setFont(new Font("Arial", Font.PLAIN, 15));
		LblPrecoVenda.setBounds(10, 140, 106, 18);
		panel.add(LblPrecoVenda);
		
		textPrecoVenda = new JTextField();;
		textPrecoVenda.setBounds(117, 140, 86, 20);
		panel.add(textPrecoVenda);
		textPrecoVenda.setColumns(10);
		
		JLabel LblVendaReais = new JLabel("reais");
		LblVendaReais.setFont(new Font("Arial", Font.PLAIN, 15));
		LblVendaReais.setBounds(206, 143, 46, 14);
		panel.add(LblVendaReais);
		
		JLabel lblDescontoMximo = new JLabel("Desconto máximo:");
		lblDescontoMximo.setFont(new Font("Arial", Font.PLAIN, 15));
		lblDescontoMximo.setBounds(10, 169, 123, 18);
		panel.add(lblDescontoMximo);
		
		textDescontoMax = new JTextField();
		textDescontoMax.setBounds(134, 168, 35, 20);
		panel.add(textDescontoMax);
		textDescontoMax.setColumns(10);
		
		JLabel LblMaxPorcent = new JLabel("%");
		LblMaxPorcent.setFont(new Font("Arial", Font.PLAIN, 15));
		LblMaxPorcent.setBounds(174, 172, 13, 14);
		panel.add(LblMaxPorcent);
		
		JLabel lblDescontoPromocional = new JLabel("Desconto promocional:");
		lblDescontoPromocional.setFont(new Font("Arial", Font.PLAIN, 15));
		lblDescontoPromocional.setBounds(10, 194, 151, 18);
		panel.add(lblDescontoPromocional);
		
		textDescontoPromo = new JTextField();
		textDescontoPromo.setBounds(163, 193, 35, 20);
		panel.add(textDescontoPromo);
		textDescontoPromo.setColumns(10);
		
		JLabel LblPromoPorcent = new JLabel("%");
		LblPromoPorcent.setFont(new Font("Arial", Font.PLAIN, 15));
		LblPromoPorcent.setBounds(203, 197, 13, 14);
		panel.add(LblPromoPorcent);
		
		JLabel lblDuraoAproximada = new JLabel("Duração aproximada:");
		lblDuraoAproximada.setFont(new Font("Arial", Font.PLAIN, 15));
		lblDuraoAproximada.setBounds(10, 223, 140, 18);
		panel.add(lblDuraoAproximada);
		
		textDuracaoAprox = new JTextField();
		textDuracaoAprox.setBounds(152, 223, 86, 20);
		panel.add(textDuracaoAprox);
		textDuracaoAprox.setColumns(10);
		
		JLabel LblAproximadaMinutos = new JLabel("minutos");
		LblAproximadaMinutos.setFont(new Font("Arial", Font.PLAIN, 15));
		LblAproximadaMinutos.setBounds(242, 226, 60, 14);
		panel.add(LblAproximadaMinutos);
		
		JLabel lblObservacao = new JLabel("Observação:");
		lblObservacao.setFont(new Font("Arial", Font.PLAIN, 15));
		lblObservacao.setBounds(10, 407, 86, 18);
		panel.add(lblObservacao);
		
		textObservacao = new JTextField();
		textObservacao.setBounds(106, 370, 271, 100);
		panel.add(textObservacao);
		textObservacao.setColumns(10);

		//adicionar as registro
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nomeServico = textNomeServico.getText();
				String categoria = textCategoria.getText();
				String tipoServico = textTipoServico.getText();
				float custoProd = Float.parseFloat(textCustoProd.getText());
				float precoVenda = Float.parseFloat(textPrecoVenda.getText());
				int descontoMax = Integer.parseInt(textDescontoMax.getText());
				int descontoPromo = Integer.parseInt(textDescontoPromo.getText());
				int duracaoAprox = Integer.parseInt(textDuracaoAprox.getText());
				String comissao = textComissao.getText();
				int percentual = Integer.parseInt(textPercentual.getText());
				int descontarProdutos = Integer.parseInt(textDescontarProdutos.getText());
				String observacao = textObservacao.getText();
				
				exec.setNomeServico(nomeServico);
				exec.setCategoria(categoria);
				exec.setTipoServico(tipoServico);
				exec.setCustoProd(custoProd);
				exec.setPrecoVenda(precoVenda);
				exec.setDescontoMax(descontoMax);
				exec.setDescontoPromo(descontoPromo);
				exec.setDuracaoAprox(duracaoAprox);
				exec.setComissao(comissao);
				exec.setPercentual(percentual);
				exec.setDescontarProdutos(descontarProdutos);
				exec.setObservacao(observacao);

				servicosDB.save(exec);
				JOptionPane.showMessageDialog(null, "Adicionado com sucesso");
				tableLoad();
				
			}
		});
		btnCadastrar.setBounds(127, 620, 115, 36);
		frame.getContentPane().add(btnCadastrar);
		
		// alterar registro
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nomeServico = textNomeServico.getText();
				String categoria = textCategoria.getText();
				String tipoServico = textTipoServico.getText();
				float custoProd = Float.parseFloat(textCustoProd.getText());
				float precoVenda = Float.parseFloat(textPrecoVenda.getText());
				int descontoMax = Integer.parseInt(textDescontoMax.getText());
				int descontoPromo = Integer.parseInt(textDescontoPromo.getText());
				int duracaoAprox = Integer.parseInt(textDuracaoAprox.getText());
				String comissao = textComissao.getText();
				int percentual = Integer.parseInt(textPercentual.getText());
				int descontarProdutos = Integer.parseInt(textDescontarProdutos.getText());
				String observacao = textObservacao.getText();
				
				exec.setNomeServico(nomeServico);
				exec.setCategoria(categoria);
				exec.setTipoServico(tipoServico);
				exec.setCustoProd(custoProd);
				exec.setPrecoVenda(precoVenda);
				exec.setDescontoMax(descontoMax);
				exec.setDescontoPromo(descontoPromo);
				exec.setDuracaoAprox(duracaoAprox);
				exec.setComissao(comissao);
				exec.setPercentual(percentual);
				exec.setDescontarProdutos(descontarProdutos);
				exec.setObservacao(observacao);
				
				JOptionPane.showMessageDialog(null, "Alterado com sucesso");
				tableLoad();

				servicosDB.update(exec, textLocalizar.getText());
				tableLoad();
			}
		});
		btnAlterar.setBounds(266, 620, 115, 36);
		frame.getContentPane().add(btnAlterar);
		
		// botao de limpar linhas
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				textNomeServico.setText("");
				textCategoria.setText("");
				textTipoServico.setText("");
				textCustoProd.setText("");
				textPrecoVenda.setText("");
				textDescontoMax.setText("");
				textDescontoPromo.setText("");
				textDuracaoAprox.setText("");
				textComissao.setText("");
				textPercentual.setText("");
				textDescontarProdutos.setText("");
				textObservacao.setText("");
				
				textNomeServico.requestFocus();
				
				
			}
		});
		btnLimpar.setBounds(405, 620, 115, 36);
		frame.getContentPane().add(btnLimpar);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				servicosDB.delete(textLocalizar.getText());
				tableLoad();
				
			}
		});
		btnDeletar.setBounds(551, 620, 115, 36);
		frame.getContentPane().add(btnDeletar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(417, 38, 342, 477);
		frame.getContentPane().add(scrollPane);
		
		tabela = new JTable();
		scrollPane.setViewportView(tabela);
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Localizar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(254, 529, 266, 71);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblLocNome = new JLabel("Id:");
		lblLocNome.setFont(new Font("Arial", Font.PLAIN, 15));
		lblLocNome.setBounds(32, 26, 43, 17);
		panel_2.add(lblLocNome);
		
		// mostrando info nas posicoes
		textLocalizar = new JTextField();
		textLocalizar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {

					String id = textLocalizar.getText();
					Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/servicos", "root", "");
					PreparedStatement pst = (PreparedStatement) con.prepareStatement(
							"SELECT nomeServico, categoria, tipoServico, custoProd, precoVenda, descontoMax, descontoPromo, duracaoAprox, comissao, percentComissao, descontarCustoProd, observacao from cadastro_servicos WHERE id = ?");
					pst.setString(1, id);
					ResultSet rs = pst.executeQuery();

					if (rs.next() == true) {

						String nomeServico = rs.getString(1);
                        String categoria = rs.getString(2);
                        String tipoServico = rs.getString(3);
                        String custoProd = Float.toString(rs.getFloat(4));
                        String precoVenda = Float.toString(rs.getFloat(5));
                        String descontoMax = Integer.toString(rs.getInt(6));
                        String descontoPromo = Integer.toString(rs.getInt(7));
                        String duracaoAprox = Integer.toString(rs.getInt(8));
                        String comissao = rs.getString(9);
                        String percentual = Integer.toString(rs.getInt(10));
                        String descontarProdutos = Integer.toString(rs.getInt(11));
                        String observacao = rs.getString(12);


                        textNomeServico.setText(nomeServico);
                        textCategoria.setText(categoria);
                        textTipoServico.setText(tipoServico);
                        textCustoProd.setText(custoProd);
                        textPrecoVenda.setText(precoVenda);
                        textDescontoMax.setText(descontoMax);
                        textDescontoPromo.setText(descontoPromo);
                        textDuracaoAprox.setText(duracaoAprox);
                        textComissao.setText(comissao);
                        textPercentual.setText(percentual);
                        textDescontarProdutos.setText(descontarProdutos);
                        textObservacao.setText(observacao);

					} else {
						textNomeServico.setText("");
                        textCategoria.setText("");
                        textTipoServico.setText("");
                        textCustoProd.setText("");
                        textPrecoVenda.setText("");
                        textDescontoMax.setText("");
                        textDescontoPromo.setText("");
                        textDuracaoAprox.setText("");
                        textComissao.setText("");
                        textPercentual.setText("");
                        textDescontarProdutos.setText("");
                        textObservacao.setText("");
					}

				}

				catch (SQLException ex) {
					ex.printStackTrace();
				}

			}
		});
		textLocalizar.setBounds(59, 25, 182, 20);
		panel_2.add(textLocalizar);
		textLocalizar.setColumns(10);
	}
}

