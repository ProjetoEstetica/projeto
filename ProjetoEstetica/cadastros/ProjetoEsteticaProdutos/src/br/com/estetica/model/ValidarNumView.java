package br.com.estetica.model;

public class ValidarNumView {

	public static void main(String[] args) {
		ValidarNum num = new ValidarNum();
		num.setNumero("12,3");
		System.out.println("numero transformado " + num.getNumero());

	}

}
