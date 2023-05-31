package br.com.estetica.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.clientesDAO.ClientesDAO;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaAlterar extends JFrame {

	private JPanel contentPane;
	private JTextField campo;
	private JTextField valorA;
	private JTextField nomeTel;
	private JTextField novoValor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAlterar frame = new TelaAlterar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaAlterar() {
		ClientesDAO clients = new ClientesDAO();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Campo a ser alterado");
		lblNewLabel.setBounds(154, 11, 125, 14);
		contentPane.add(lblNewLabel);
		
		campo = new JTextField();
		campo.setBounds(108, 36, 210, 20);
		contentPane.add(campo);
		campo.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("valor para alterar");
		lblNewLabel_1.setBounds(154, 67, 125, 14);
		contentPane.add(lblNewLabel_1);
		
		valorA = new JTextField();
		valorA.setBounds(108, 93, 210, 20);
		contentPane.add(valorA);
		valorA.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("escolha nome_completo / celular");
		lblNewLabel_2.setBounds(118, 124, 188, 14);
		contentPane.add(lblNewLabel_2);
		
		nomeTel = new JTextField();
		nomeTel.setBounds(108, 149, 210, 20);
		contentPane.add(nomeTel);
		nomeTel.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("digite nome ou celular");
		lblNewLabel_3.setBounds(148, 180, 118, 14);
		contentPane.add(lblNewLabel_3);
		
		novoValor = new JTextField();
		novoValor.setBounds(108, 196, 210, 20);
		contentPane.add(novoValor);
		novoValor.setColumns(10);
		
		JButton btnNewButton = new JButton("executar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				clients.update(campo.getText(), valorA.getText(), nomeTel.getText(), novoValor.getText());
			}
		});
		btnNewButton.setBounds(167, 227, 89, 23);
		contentPane.add(btnNewButton);
	}

}
