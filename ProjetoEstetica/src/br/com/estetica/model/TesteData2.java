package br.com.estetica.model;

import javax.swing.JOptionPane;

public class TesteData2 {
	public static void main(String[] args) {
		String data = "30/02/2004";
		String[] divisao = data.split("/");

		int dia = Integer.parseInt(divisao[0]);
		String mes = divisao[1];
		int ano = Integer.parseInt(divisao[2]);
		// fazer com os 30 e 31
		System.out.println("Dia: " + dia);
		System.out.println("Mês: " + mes);
		System.out.println("Ano: " + ano);

		if (data.length() != 10) {
			JOptionPane.showMessageDialog(null, "Aniversario digitado de maneira incorreta. tente:\n(dd/mm/yyyy)");
		} else {
			if (ano % 4 == 0) {
				if (mes.equals("02") && dia > 29) {
					JOptionPane.showMessageDialog(null, "Erro, ano ate 29/02");
					
				}
			} else if (mes.equals("02") && dia > 28) {
				JOptionPane.showMessageDialog(null, "Erro, ano ate 28/02");
			}
			JOptionPane.showMessageDialog(null, "Sucesso");

		}
	}
}
