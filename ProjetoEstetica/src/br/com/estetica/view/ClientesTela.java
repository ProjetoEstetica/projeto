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

import br.com.clientesDAO.ClientesDAO;
import br.com.estetica.model.InfoClients;
import br.com.factory.ConnectionFactory;
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

public class ClientesTela {

	private JFrame frame;
	private JTextField textNomeApelido;
	private JTextField textNomeCompleto;
	private JTextField textCel;
	private JTextField textAniver;
	private JTextField textCep;
	private JTextField textRua;
	private JTextField textNum;
	private JTextField textComp;
	private JTextField textBairro;
	private JTextField textCidade;
	private JTextField textEstado;
	private JTable tabela;
	private JTextField textLocalizar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientesTela window = new ClientesTela();
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
	public ClientesTela() {
		initialize();
		tableLoad();
	}
	
	public void tableLoad() {
		try {		
			Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/clientes", "root", "");
			PreparedStatement pst = (PreparedStatement) con.prepareStatement("select id, apelido from cadastro_clientes");
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
		ClientesDAO clientsDB = new ClientesDAO();
		// info dos clientes
		InfoClients exec = new InfoClients();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 641);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Clientes");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setBounds(370, 11, 70, 31);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Dados", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 48, 396, 385);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel LblNomeCompleto = new JLabel("Nome Completo:");
		LblNomeCompleto.setBounds(10, 53, 116, 18);
		LblNomeCompleto.setFont(new Font("Arial", Font.PLAIN, 15));
		panel.add(LblNomeCompleto);
		
		JLabel LblNomeApelido_1 = new JLabel("Nome/Apelido:");
		LblNomeApelido_1.setFont(new Font("Arial", Font.PLAIN, 15));
		LblNomeApelido_1.setBounds(10, 23, 106, 18);
		panel.add(LblNomeApelido_1);
		
		JLabel LblCelular = new JLabel("Celular:");
		LblCelular.setFont(new Font("Arial", Font.PLAIN, 15));
		LblCelular.setBounds(10, 82, 106, 18);
		panel.add(LblCelular);
		
		JLabel LblAniversario = new JLabel("Aniversario:");
		LblAniversario.setFont(new Font("Arial", Font.PLAIN, 15));
		LblAniversario.setBounds(10, 111, 106, 18);
		panel.add(LblAniversario);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Endereco", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 144, 377, 230);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel LblCEP = new JLabel("CEP:");
		LblCEP.setBounds(10, 22, 106, 18);
		panel_1.add(LblCEP);
		LblCEP.setFont(new Font("Arial", Font.PLAIN, 15));
		
		JLabel LblRua = new JLabel("Rua:");
		LblRua.setFont(new Font("Arial", Font.PLAIN, 15));
		LblRua.setBounds(10, 51, 106, 18);
		panel_1.add(LblRua);
		
		JLabel LblComplemento = new JLabel("Complemento:");
		LblComplemento.setFont(new Font("Arial", Font.PLAIN, 15));
		LblComplemento.setBounds(10, 109, 106, 18);
		panel_1.add(LblComplemento);
		
		JLabel LblNumero = new JLabel("Numero:");
		LblNumero.setFont(new Font("Arial", Font.PLAIN, 15));
		LblNumero.setBounds(10, 80, 106, 18);
		panel_1.add(LblNumero);
		
		JLabel LblBairro = new JLabel("Bairro:");
		LblBairro.setFont(new Font("Arial", Font.PLAIN, 15));
		LblBairro.setBounds(10, 138, 106, 18);
		panel_1.add(LblBairro);
		
		JLabel LbCidade = new JLabel("Cidade:");
		LbCidade.setFont(new Font("Arial", Font.PLAIN, 15));
		LbCidade.setBounds(10, 167, 106, 18);
		panel_1.add(LbCidade);
		
		JLabel LblEstado = new JLabel("Estado:");
		LblEstado.setFont(new Font("Arial", Font.PLAIN, 15));
		LblEstado.setBounds(10, 196, 106, 18);
		panel_1.add(LblEstado);
		
		textCep = new JTextField();
		textCep.setBounds(54, 22, 154, 20);
		panel_1.add(textCep);
		textCep.setColumns(10);
		
		textRua = new JTextField();
		textRua.setBounds(48, 51, 191, 20);
		panel_1.add(textRua);
		textRua.setColumns(10);
		
		textNum = new JTextField();
		textNum.setBounds(73, 80, 86, 20);
		panel_1.add(textNum);
		textNum.setColumns(10);
		
		textComp = new JTextField();
		textComp.setBounds(111, 109, 128, 20);
		panel_1.add(textComp);
		textComp.setColumns(10);
		
		textBairro = new JTextField();
		textBairro.setBounds(55, 138, 184, 20);
		panel_1.add(textBairro);
		textBairro.setColumns(10);
		
		textCidade = new JTextField();
		textCidade.setBounds(73, 167, 166, 20);
		panel_1.add(textCidade);
		textCidade.setColumns(10);
		
		textEstado = new JTextField();
		textEstado.setBounds(73, 196, 166, 20);
		panel_1.add(textEstado);
		textEstado.setColumns(10);
		
		textNomeApelido = new JTextField();
		textNomeApelido.setBounds(111, 23, 276, 20);
		panel.add(textNomeApelido);
		textNomeApelido.setColumns(10);
		
		textNomeCompleto = new JTextField();
		textNomeCompleto.setBounds(121, 53, 266, 18);
		panel.add(textNomeCompleto);
		textNomeCompleto.setColumns(10);
		
		textCel = new JTextField();
		textCel.setBounds(64, 82, 156, 20);
		panel.add(textCel);
		textCel.setColumns(10);
		
		textAniver = new JTextField();
		textAniver.setBounds(92, 111, 127, 20);
		panel.add(textAniver);
		textAniver.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(416, 53, 358, 380);
		frame.getContentPane().add(scrollPane);
		
		tabela = new JTable();
		scrollPane.setViewportView(tabela);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Localizar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(266, 444, 273, 65);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblLocNome = new JLabel("Nome:");
		lblLocNome.setFont(new Font("Arial", Font.PLAIN, 15));
		lblLocNome.setBounds(10, 26, 61, 17);
		panel_2.add(lblLocNome);
				
		// mostrando info nas posicoes
		textLocalizar = new JTextField();
		textLocalizar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {

					String id = textLocalizar.getText();
					Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/clientes", "root", "");
					PreparedStatement pst = (PreparedStatement) con.prepareStatement(
							"SELECT nome_completo, apelido, celular, aniversario, cep, rua, numero, comp, bairro, cidade, estado from cadastro_clientes WHERE id = ?");
					pst.setString(1, id);
					ResultSet rs = pst.executeQuery();

					if (rs.next() == true) {

						String nomeCompleto = rs.getString(1);
						String apelido = rs.getString(2);
						String celular = rs.getString(3);
						String aniversario = rs.getString(4);
						String cep = rs.getString(5);
						String rua = rs.getString(6);
						String num = rs.getString(7);
						String comp = rs.getString(8);
						String bairro = rs.getString(9);
						String cidade = rs.getString(10);
						String estado = rs.getString(11);

						textNomeCompleto.setText(nomeCompleto);
						textNomeApelido.setText(apelido);
						textCel.setText(celular);
						textAniver.setText(aniversario);
						textCep.setText(cep);
						textRua.setText(rua);
						textNum.setText(num);
						textComp.setText(comp);
						textBairro.setText(bairro);
						textCidade.setText(cidade);
						textEstado.setText(estado);

					} else {
						textNomeCompleto.setText("");
						textNomeApelido.setText("");
						textCel.setText("");
						textAniver.setText("");
						textCep.setText("");
						textRua.setText("");
						textNum.setText("");
						textComp.setText("");
						textBairro.setText("");
						textCidade.setText("");
						textEstado.setText("");
					}

				}

				catch (SQLException ex) {
					ex.printStackTrace();
				}

			}
		});
		textLocalizar.setBounds(81, 23, 182, 20);
		panel_2.add(textLocalizar);
		textLocalizar.setColumns(10);

		//adicionar as registro
		JButton btnNovo = new JButton("Cadastrar");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nomeCompleto = textNomeCompleto.getText();
				String apelido = textNomeApelido.getText();
				String aniversario = textAniver.getText();
				String celular = textCel.getText();
				String cep = textCep.getText();
				String rua = textRua.getText();
				String comp = textComp.getText();
				int num = Integer.parseInt(textNum.getText());
				String bairro = textBairro.getText();
				String cidade = textCidade.getText();
				String estado = textEstado.getText();

				exec.setNomeCompleto(nomeCompleto);
				exec.setApelido(apelido);
				exec.setCelular(celular);
				exec.setCep(cep);
				exec.setRua(rua);
				exec.setComp(comp);
				exec.setBairro(bairro);
				exec.setCidade(cidade);
				exec.setEstado(estado);
				exec.setNum(num);
				exec.setAniversario(aniversario);

				clientsDB.save(exec);
				tableLoad();
				
			}
		});
		btnNovo.setBounds(128, 536, 115, 36);
		frame.getContentPane().add(btnNovo);
		
		// alterar registro
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nomeCompleto = textNomeCompleto.getText();
				String apelido = textNomeApelido.getText();
				String aniversario = textAniver.getText();
				String celular = textCel.getText();
				String cep = textCep.getText();
				String rua = textRua.getText();
				String comp = textComp.getText();
				int num = Integer.parseInt(textNum.getText());
				String bairro = textBairro.getText();
				String cidade = textCidade.getText();
				String estado = textEstado.getText();
				
				exec.setNomeCompleto(nomeCompleto);
				exec.setApelido(apelido);
				exec.setCelular(celular);
				exec.setCep(cep);
				exec.setRua(rua);
				exec.setComp(comp);
				exec.setBairro(bairro);
				exec.setCidade(cidade);
				exec.setEstado(estado);
				exec.setNum(num);
				exec.setAniversario(aniversario);

				clientsDB.update(exec, textLocalizar.getText());
				tableLoad();
			}
		});
		btnAlterar.setBounds(266, 536, 115, 36);
		frame.getContentPane().add(btnAlterar);
		
		// botao de limpar linhas
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textNomeCompleto.setText("");
				textNomeApelido.setText("");
				textCel.setText("");
				textAniver.setText("");
				textCep.setText("");
				textRua.setText("");
				textNum.setText("");
				textComp.setText("");
				textBairro.setText("");
				textCidade.setText("");
				textEstado.setText("");

				textNomeCompleto.requestFocus();
				
			}
		});
		btnLimpar.setBounds(405, 536, 115, 36);
		frame.getContentPane().add(btnLimpar);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clientsDB.delete(textLocalizar.getText());
				tableLoad();
				
				//limpando campos
				textNomeCompleto.setText("");
				textNomeApelido.setText("");
				textCel.setText("");
				textAniver.setText("");
				textCep.setText("");
				textRua.setText("");
				textNum.setText("");
				textComp.setText("");
				textBairro.setText("");
				textCidade.setText("");
				textEstado.setText("");
			}
		});
		btnDeletar.setBounds(551, 536, 115, 36);
		frame.getContentPane().add(btnDeletar);
	}
}
