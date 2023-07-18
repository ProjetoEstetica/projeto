package br.com.estetica.model;


public class ValidarNum {
	private String numeroRecebido;
	private double numeroDevolvido;
	
	
	public Double getNumero() {
		if(numeroRecebido.contains(",")) {
			String nuemroComPonto = numeroRecebido.replace(",", ".");
			numeroDevolvido = Double.parseDouble(nuemroComPonto);
			
		}else {
			numeroDevolvido = Double.parseDouble(numeroRecebido);
		}
		return numeroDevolvido;
	}

	public void setNumero(String numeroRecebido) {
		this.numeroRecebido = numeroRecebido;
	}
}
