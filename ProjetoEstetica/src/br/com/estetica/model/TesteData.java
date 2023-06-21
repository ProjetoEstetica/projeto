package br.com.estetica.model;
import java.time.LocalDate;

import java.time.format.DateTimeFormatter;

public class TesteData {
	public static void main(String[] args) {
        String dataString = "30/02/2004";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data = LocalDate.parse(dataString, formatter);

        int dia = data.getDayOfMonth();
        int mes = data.getMonthValue();
        int ano = data.getYear();
        
        System.out.println(dia);
    }
}
