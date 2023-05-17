package br.com.estetica.view;

import java.util.Date;

import javax.swing.JOptionPane;

import br.com.clientesDAO.ClientesDAO;
import br.com.estetica.model.InfoClients;

public class Terminal {

	public static void main(String[] args) {
		InfoClients exec = new InfoClients();
		ClientesDAO clients = new ClientesDAO();
		
		String nomeCompleto = JOptionPane.showInputDialog("Digite o nome completo");
		String apelido = JOptionPane.showInputDialog("digite o apelido");
		String celular = JOptionPane.showInputDialog("digite o celular");
		String cep = JOptionPane.showInputDialog("digite o cep");
		String rua = JOptionPane.showInputDialog("digite a rua");
		String comp = JOptionPane.showInputDialog("digite o complemento");
		int num = Integer.parseInt(JOptionPane.showInputDialog("digite o numero"));
		String bairro = JOptionPane.showInputDialog("digite o bairro");
		String cidade = JOptionPane.showInputDialog("digite a cidade");
		String estado = JOptionPane.showInputDialog("digite o estado");
		
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
		exec.setAniversario(new Date());

		clients.save(exec);

	}

}
