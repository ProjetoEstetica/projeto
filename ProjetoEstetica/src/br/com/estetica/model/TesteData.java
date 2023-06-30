package br.com.estetica.model;

import java.util.Scanner;

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
		if (!data.contains("/")) {
			JOptionPane.showMessageDialog(null, "a data nao contem /");
			existeErro = true;
		}
		String[] divisao = data.split("/");
		int dia = Integer.parseInt(divisao[0]);
		int mes = Integer.parseInt(divisao[1]);
		int ano = Integer.parseInt(divisao[2]);

		if (data.length() != 10) {
			JOptionPane.showMessageDialog(null, "Aniversario digitado de maneira incorreta. tente:\n(dd/mm/yyyy)");
			existeErro = true;
		}

		if (mes > 12) {
			JOptionPane.showMessageDialog(null, "Ano digitado tem mais que 12");
			existeErro = true;
		}

		if (mes == 02) {
			if (ano % 4 == 0 && dia > 29) {
				JOptionPane.showMessageDialog(null, "Mes de fevereiro nao suporta 29/02");
				existeErro = true;
			} else if (ano % 4 != 0 && dia > 28) {
				JOptionPane.showMessageDialog(null, "Ano nao é bissesto entao Mes de fevereiro nao suporta 28/02");
				existeErro = true;
			}
		}

		if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
			if (dia > 30) {
				JOptionPane.showMessageDialog(null, "mes termina com 30");
				existeErro = true;
			}

		}

		if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 9 || mes == 11 || mes == 12) {
			if (dia > 31) {
				JOptionPane.showMessageDialog(null, "mes termina com 31");
				existeErro = true;
			}

		}

		return existeErro;
	}
}
