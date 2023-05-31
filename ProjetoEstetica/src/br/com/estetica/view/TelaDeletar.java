package br.com.estetica.view;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.clientesDAO.ClientesDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaDeletar extends JFrame {

	private JPanel contentPane;
	private JTextField campo;
	private JTextField valor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaDeletar frame = new TelaDeletar();
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
	public TelaDeletar() {
		ClientesDAO clients = new ClientesDAO();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("campo");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(66, 38, 68, 46);
		contentPane.add(lblNewLabel);
		
		campo = new JTextField();
		campo.setBounds(165, 53, 144, 20);
		contentPane.add(campo);
		campo.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("valor");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(66, 95, 54, 20);
		contentPane.add(lblNewLabel_1);
		
		valor = new JTextField();
		valor.setBounds(165, 98, 144, 20);
		contentPane.add(valor);
		valor.setColumns(10);
		
		JButton btnNewButton = new JButton("executar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "campo: " + campo.getText() + " valor: " + valor.getText());
				// escuta o comando para deletar
				clients.delete(campo.getText(), valor.getText());
				
			}
		});
		btnNewButton.setBounds(154, 189, 89, 23);
		contentPane.add(btnNewButton);
	}

}
