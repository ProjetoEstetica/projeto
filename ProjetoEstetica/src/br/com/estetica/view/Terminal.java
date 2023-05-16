package br.com.estetica.view;

import javax.swing.JOptionPane;

import br.com.estetica.classes.Comandos;

public class Terminal {

	public static void main(String[] args) {
		Comandos exec = new Comandos();
		
		String nomeCompleto = JOptionPane.showInputDialog("Digite o nome completo");
		String apelido = JOptionPane.showInputDialog("digite o apelido");
		String celular = JOptionPane.showInputDialog("digite o celular");
		String cep = JOptionPane.showInputDialog("digite o cep");
		String rua = JOptionPane.showInputDialog("digite a rua");
		int num = Integer.parseInt(JOptionPane.showInputDialog("digite o telefonw"));
		String cidade = JOptionPane.showInputDialog("digite a cidade");
		String estado = JOptionPane.showInputDialog("digite o estadp");
		
		exec.setNomeCompleto(nomeCompleto);
		exec.setApelido(apelido);
		exec.setCelular(celular);
		exec.setCep(cep);
		exec.setRua(rua);
		exec.setCidade(cidade);
		exec.setEstado(estado);
		exec.setNumero(num);
		
		

	}

}
