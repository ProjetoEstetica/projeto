package br.com.estetica.model;

import javax.swing.JOptionPane;

public class TesteData {

	private String data, aniversario;
	protected boolean existeErro = false;

	public String getAniversario() {
		aniversario = data;
		return aniversario;
	}

	public void setData(String data) {
		this.data = data;
	}

	public boolean getData() {

		String[] divisao = data.split("/", -1);

		if (divisao.length != 3 || data.length() != 10) {
			JOptionPane.showMessageDialog(null, "A data está incorreta. Por favor, utilize o formato: dd/mm/yyyy");
			existeErro = true;
			return existeErro;
		}

		int dia = Integer.parseInt(divisao[0]);
		int mes = Integer.parseInt(divisao[1]);
		int ano = Integer.parseInt(divisao[2]);

		if (mes > 12) {
			JOptionPane.showMessageDialog(null, "Ano digitado tem mais que 12");
			existeErro = true;
		}

		if (mes == 2) {
			if (ano % 4 == 0 && dia > 29) {
				JOptionPane.showMessageDialog(null, "Mês de fevereiro não suporta 29/02 em ano bissexto");
				existeErro = true;
			} else if (ano % 4 != 0 && dia > 28) {
				JOptionPane.showMessageDialog(null, "Mês de fevereiro não suporta 28/02 em ano não bissexto");
				existeErro = true;
			}
		}

		if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
			if (dia > 30) {
				JOptionPane.showMessageDialog(null, "O mês especificado possui no máximo 30 dias");
				existeErro = true;
			}
		}

		if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
			if (dia > 31) {
				JOptionPane.showMessageDialog(null, "O mês especificado possui no máximo 31 dias");
				existeErro = true;
			}
		}

		return existeErro;
	}
}
