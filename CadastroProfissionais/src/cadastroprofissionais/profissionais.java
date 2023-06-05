package cadastroprofissionais;

import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.MatteBorder;

public class profissionais {

	private JFrame frame;
	private JTextField textApelido;
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
	private JTextField textIDNome;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					profissionais window = new profissionais();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Criando a aplicação.
	 */
	public profissionais() {
		initialize();
		Connect();
		table_load();
	}

	/** Fazendo Conexão com Banco **/
	Connection con;
	PreparedStatement pst;
	ResultSet rs;

	public void Connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/profissionais", "root", "");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	public void table_load() {
		try {
			pst = con.prepareStatement("select id, apelido from cadastro_profissionais");
			rs = pst.executeQuery();
			tabela.setModel(DbUtils.resultSetToTableModel(rs));
			// **DbUtils = O rs2xml.jar é uma biblioteca Java que fornece recursos para
			// facilitar a exibição de dados de um ResultSet**//
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Iniciando a Aplicação.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 641);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblLabelProfissionais = new JLabel("Profissionais");
		lblLabelProfissionais.setFont(new Font("Arial", Font.BOLD, 25));
		lblLabelProfissionais.setBounds(338, 11, 166, 41);
		frame.getContentPane().add(lblLabelProfissionais);

		JPanel panel_dados = new JPanel();
		panel_dados.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Dados",
				TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_dados.setBounds(10, 57, 408, 384);
		frame.getContentPane().add(panel_dados);
		panel_dados.setLayout(null);

		JLabel lblNomeApelido = new JLabel("Nome/Apelido: ");
		lblNomeApelido.setFont(new Font("Arial", Font.BOLD, 15));
		lblNomeApelido.setBounds(10, 29, 107, 18);
		panel_dados.add(lblNomeApelido);

		JLabel lblNomeCompleto = new JLabel("Nome completo: ");
		lblNomeCompleto.setFont(new Font("Arial", Font.BOLD, 15));
		lblNomeCompleto.setBounds(10, 58, 118, 18);
		panel_dados.add(lblNomeCompleto);

		JLabel lblCel = new JLabel("Celular: ");
		lblCel.setFont(new Font("Arial", Font.BOLD, 15));
		lblCel.setBounds(10, 89, 59, 18);
		panel_dados.add(lblCel);

		JLabel lblAniver = new JLabel("Aniversário: ");
		lblAniver.setFont(new Font("Arial", Font.BOLD, 15));
		lblAniver.setBounds(10, 118, 89, 18);
		panel_dados.add(lblAniver);

		JPanel panel_endereco = new JPanel();
		panel_endereco.setForeground(Color.BLACK);
		panel_endereco.setBorder(new TitledBorder(null, "Endereço", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panel_endereco.setBounds(10, 147, 373, 228);
		panel_dados.add(panel_endereco);
		panel_endereco.setLayout(null);

		JLabel lblCep = new JLabel("CEP: ");
		lblCep.setBounds(10, 21, 39, 18);
		panel_endereco.add(lblCep);
		lblCep.setFont(new Font("Arial", Font.BOLD, 15));

		JLabel lblRua = new JLabel("Rua: ");
		lblRua.setBounds(10, 52, 36, 18);
		panel_endereco.add(lblRua);
		lblRua.setFont(new Font("Arial", Font.BOLD, 15));

		JLabel lblNum = new JLabel("Número: ");
		lblNum.setFont(new Font("Arial", Font.BOLD, 15));
		lblNum.setBounds(10, 81, 64, 18);
		panel_endereco.add(lblNum);

		JLabel lblComp = new JLabel("Complemento: ");
		lblComp.setFont(new Font("Arial", Font.BOLD, 15));
		lblComp.setBounds(10, 110, 106, 18);
		panel_endereco.add(lblComp);

		JLabel lblBairro = new JLabel("Bairro: ");
		lblBairro.setFont(new Font("Arial", Font.BOLD, 15));
		lblBairro.setBounds(10, 139, 52, 18);
		panel_endereco.add(lblBairro);

		JLabel lblCidade = new JLabel("Cidade: ");
		lblCidade.setFont(new Font("Arial", Font.BOLD, 15));
		lblCidade.setBounds(10, 168, 64, 18);
		panel_endereco.add(lblCidade);

		JLabel lblEstado = new JLabel("Estado: ");
		lblEstado.setFont(new Font("Arial", Font.BOLD, 15));
		lblEstado.setBounds(10, 197, 64, 18);
		panel_endereco.add(lblEstado);

		textCep = new JTextField();
		textCep.setColumns(10);
		textCep.setBounds(54, 21, 137, 20);
		panel_endereco.add(textCep);

		textRua = new JTextField();
		textRua.setColumns(10);
		textRua.setBounds(54, 52, 202, 20);
		panel_endereco.add(textRua);

		textNum = new JTextField();
		textNum.setColumns(10);
		textNum.setBounds(75, 81, 64, 20);
		panel_endereco.add(textNum);

		textComp = new JTextField();
		textComp.setColumns(10);
		textComp.setBounds(119, 110, 137, 20);
		panel_endereco.add(textComp);

		textBairro = new JTextField();
		textBairro.setColumns(10);
		textBairro.setBounds(65, 139, 137, 20);
		panel_endereco.add(textBairro);

		textCidade = new JTextField();
		textCidade.setColumns(10);
		textCidade.setBounds(75, 168, 137, 20);
		panel_endereco.add(textCidade);

		textEstado = new JTextField();
		textEstado.setColumns(10);
		textEstado.setBounds(75, 197, 137, 20);
		panel_endereco.add(textEstado);

		textApelido = new JTextField();
		textApelido.setBounds(124, 29, 270, 20);
		panel_dados.add(textApelido);
		textApelido.setColumns(10);

		textNomeCompleto = new JTextField();
		textNomeCompleto.setColumns(10);
		textNomeCompleto.setBounds(134, 58, 260, 20);
		panel_dados.add(textNomeCompleto);

		textCel = new JTextField();
		textCel.setColumns(10);
		textCel.setBounds(70, 89, 137, 20);
		panel_dados.add(textCel);

		textAniver = new JTextField();
		textAniver.setColumns(10);
		textAniver.setBounds(102, 118, 137, 20);
		panel_dados.add(textAniver);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(424, 63, 350, 378);
		frame.getContentPane().add(scrollPane);

		tabela = new JTable();
		scrollPane.setViewportView(tabela);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Localizar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(228, 452, 350, 99);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblLabelID = new JLabel("ID : ");
		lblLabelID.setBounds(64, 38, 36, 18);
		lblLabelID.setFont(new Font("Arial", Font.BOLD, 15));
		panel.add(lblLabelID);

		// **Evento para localizar id do banco e usuários**//
		textIDNome = new JTextField();
		textIDNome.setColumns(10);
		textIDNome.setBounds(110, 38, 216, 20);
		panel.add(textIDNome);
		textIDNome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {

					String id = textIDNome.getText();

					pst = con.prepareStatement(
							"SELECT nome_completo, apelido, celular, aniversario, cep, rua, numero, comp, bairro, cidade, estado from cadastro_profissionais WHERE id = ?");
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
						textApelido.setText(apelido);
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
						textApelido.setText("");
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

				}

			}
		});

		// **Evento para limpar campos da interface**//
		JButton btnButtonLimpar = new JButton("Limpar");
		btnButtonLimpar.setBounds(390, 568, 114, 23);
		frame.getContentPane().add(btnButtonLimpar);
		btnButtonLimpar.setFont(new Font("Arial", Font.PLAIN, 15));
		btnButtonLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				textNomeCompleto.setText("");
				textApelido.setText("");
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

		// **Evento para adcionar usuários na base de dados**//
		JButton btnButtonSave = new JButton("Novo");
		btnButtonSave.setBounds(89, 568, 114, 23);
		frame.getContentPane().add(btnButtonSave);
		btnButtonSave.setFont(new Font("Arial", Font.PLAIN, 15));
		btnButtonSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String nomeCompleto, apelido, celular, aniversario, cep, rua, num, comp, bairro, cidade, estado;

				nomeCompleto = textNomeCompleto.getText();
				apelido = textApelido.getText();
				celular = textCel.getText();
				aniversario = textAniver.getText();
				cep = textCep.getText();
				rua = textRua.getText();
				num = textNum.getText();
				comp = textComp.getText();
				bairro = textBairro.getText();
				cidade = textCidade.getText();
				estado = textEstado.getText();

				try {
					pst = con.prepareStatement(
							"INSERT INTO cadastro_profissionais(nome_completo, apelido, celular, aniversario, cep, rua, numero, comp, bairro, cidade, estado) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
					pst.setString(1, nomeCompleto);
					pst.setString(2, apelido);
					pst.setString(3, celular);
					pst.setString(4, aniversario);
					pst.setString(5, cep);
					pst.setString(6, rua);
					pst.setString(7, num);
					pst.setString(8, comp);
					pst.setString(9, bairro);
					pst.setString(10, cidade);
					pst.setString(11, estado);
					pst.executeUpdate();

					JOptionPane.showMessageDialog(null, "Profissional Adcionado!");
					table_load();

					textNomeCompleto.setText("");
					textApelido.setText("");
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
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});

		// **Evento para alterar dados dos usuários cadastrados na base de dados**//
		JButton btnButtonAlterar = new JButton("Alterar");
		btnButtonAlterar.setBounds(238, 568, 114, 23);
		frame.getContentPane().add(btnButtonAlterar);
		btnButtonAlterar.setFont(new Font("Arial", Font.PLAIN, 15));
		btnButtonAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nomeCompleto, apelido, celular, aniversario, cep, rua, num, comp, bairro, cidade, estado, idnome;

				nomeCompleto = textNomeCompleto.getText();
				apelido = textApelido.getText();
				celular = textCel.getText();
				aniversario = textAniver.getText();
				cep = textCep.getText();
				rua = textRua.getText();
				num = textNum.getText();
				comp = textComp.getText();
				bairro = textBairro.getText();
				cidade = textCidade.getText();
				estado = textEstado.getText();
				idnome = textIDNome.getText();

				try {
					pst = con.prepareStatement(
							"UPDATE cadastro_profissionais set nome_completo = ?, apelido = ?, celular = ?, aniversario = ?, cep = ?, rua = ?, numero = ?, comp = ?, bairro = ?, cidade = ?, estado = ? where id = ?");

					pst.setString(1, nomeCompleto);
					pst.setString(2, apelido);
					pst.setString(3, celular);
					pst.setString(4, aniversario);
					pst.setString(5, cep);
					pst.setString(6, rua);
					pst.setString(7, num);
					pst.setString(8, comp);
					pst.setString(9, bairro);
					pst.setString(10, cidade);
					pst.setString(11, estado);
					pst.setString(12, idnome);
					pst.executeUpdate();

					JOptionPane.showMessageDialog(null, "Profissional Editado!");
					table_load();

					textNomeCompleto.setText("");
					textApelido.setText("");
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

				catch (SQLException e1) {

					e1.printStackTrace();
				}

			}
		});

		// **Evento para deletar um id da base de dados**//
		JButton btnButtonDel = new JButton("Deletar");
		btnButtonDel.setBounds(552, 568, 114, 23);
		frame.getContentPane().add(btnButtonDel);
		btnButtonDel.setFont(new Font("Arial", Font.PLAIN, 15));
		btnButtonDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bid;
				bid = textIDNome.getText();
				try {
					pst = con.prepareStatement("delete from cadastro_profissionais where id =?");
					pst.setString(1, bid);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Profissional Deletado!");
					table_load();

					textNomeCompleto.setText("");
					textApelido.setText("");
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

				catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

	}
}
