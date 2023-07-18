package br.com.estetica.model;

public class TesteDataView {

	public static void main(String[] args) {
		TesteData data = new TesteData();
		data.setData("28/02/2005");
		
		
		if(data.getData() == true) {
			System.out.println("erro");
		}else {
			System.out.println("sem erro");
		}
	}

}
