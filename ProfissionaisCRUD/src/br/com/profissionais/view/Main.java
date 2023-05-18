package br.com.profissionais.view;

import br.com.profissionais.model.Profissionais;
import br.com.profissionais.dao.ProfissionaisDAO;

public class Main {

	public static void main(String[] args) {
		ProfissionaisDAO profissionaisDao = new ProfissionaisDAO();
		
		Profissionais profissionais = new Profissionais();
		profissionais.setNomeCompleto("Diego de Melo Basilio");
		profissionais.setApelido("Basilio");
		profissionais.setCelular(941527358);
		profissionais.setAniversario("10/11/2004");
		profissionais.setCep("03470070");
		profissionais.setRua("Praça Simões da Cunha");
		profissionais.setNumero(69);
		profissionais.setComp("");
		profissionais.setBairro("Jardim Vila Formosa");
		profissionais.setCidade("São Paulo");
		profissionais.setEstado("SP");
		
		profissionaisDao.save(profissionais);
		
		//Visualização dos Registros BD *
		
		for(Profissionais p : profissionaisDao.getProfissionais()) {
			System.out.println("Profissionais: " + p.getNomeCompleto());
		}
		
		
	}

}
