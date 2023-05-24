package br.com.profissionais.view;

import br.com.profissionais.model.Profissionais;
import br.com.profissionais.dao.ProfissionaisDAO;
import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		Profissionais exec = new Profissionais();
		ProfissionaisDAO profissionaisDao = new ProfissionaisDAO();
		
		
		int selecionar = Integer.parseInt(JOptionPane.showInputDialog("Selecione a opção desejada!"
				+ "\n1 - Adicionar Profissionais \n2 - Visualizar Profissionais \n3 - Alterar Dados Profissionais \n4 - Deletar Profissionais"));
		
		switch(selecionar) {
		case 1: {
			String nomeCompleto = JOptionPane.showInputDialog("Digite o nome completo");
			String apelido = JOptionPane.showInputDialog("Digite o apelido");
			String aniversario = JOptionPane.showInputDialog("Digite o aniversario");
			String celular = JOptionPane.showInputDialog("Digite o celular");
			String cep = JOptionPane.showInputDialog("Digite o cep");
			String rua = JOptionPane.showInputDialog("Digite a rua");
			String comp = JOptionPane.showInputDialog("Digite o complemento");
			int num = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero"));
			String bairro = JOptionPane.showInputDialog("Digite o bairro");
			String cidade = JOptionPane.showInputDialog("Digite a cidade");
			String estado = JOptionPane.showInputDialog("Digite o estado");
			
			exec.setNomeCompleto(nomeCompleto);
			exec.setApelido(apelido);
			exec.setCelular(celular);
			exec.setCep(cep);
			exec.setRua(rua);
			exec.setComp(comp);
			exec.setBairro(bairro);
			exec.setCidade(cidade);
			exec.setEstado(estado);
			exec.setNumero(num);
			exec.setAniversario(aniversario);

			profissionaisDao.save(exec);
		}
		case 2:{
			String profissionais = JOptionPane.showInputDialog("Digite Nome Completo - Profissional");
			for(Profissionais p : profissionaisDao.getProfissionais(profissionais)) {
				JOptionPane.showMessageDialog(null, "Profissionais: " + p.getNomeCompleto());
			}
		}
		case 3: {
			//profissionaisDao.update("");
		}
		
		case 4: {
			//profissionaisDao.delete("");
		}
		}
		
		
	}
}
