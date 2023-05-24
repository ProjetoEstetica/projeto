package br.com.estetica.view;

import javax.swing.JOptionPane;

import br.com.clientesDAO.ClientesDAO;
import br.com.estetica.model.InfoClients;

public class Terminal {

	public static void main(String[] args) {
		InfoClients exec = new InfoClients();
		ClientesDAO clients = new ClientesDAO();

		int selecionar = Integer.parseInt(JOptionPane.showInputDialog("Selecione a opcao que deseja"
				+ "\n1 - Adicionar cliente \n2 - Visualizar todos registros \n3 - Mudar valor \n4 - Delete"));

		switch (selecionar) {
		case 1: {
			// adicionar dados
			String nomeCompleto = JOptionPane.showInputDialog("Digite o nome completo");
			String apelido = JOptionPane.showInputDialog("digite o apelido");
			String aniversario = JOptionPane.showInputDialog("digite o aniversario");
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
			exec.setAniversario(aniversario);

			clients.save(exec);

		}
		case 2: {
			// visualizacao de todos registros
			for (InfoClients c : clients.getClientes()) {
				JOptionPane.showMessageDialog(null, "Cliente: " + c.getNomeCompleto());
			}

		}

		case 3: {
			// alterar dados
			String campAleterar = JOptionPane.showInputDialog("Digite o que deseja mudar: ");
			String rua1 = JOptionPane.showInputDialog("Digite o valor a ser alterado: ");
			String respWhere = JOptionPane.showInputDialog("Escolha telefone ou nome completo");
			String valorWhere = JOptionPane.showInputDialog("digite o telefone ou nome completo");

			clients.update(campAleterar, rua1, respWhere, valorWhere);
		}

		case 4: {
			// deletar dados
			clients.delete("celular", "9877654112");
		}

		}

	}
}
