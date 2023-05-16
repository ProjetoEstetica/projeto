package br.com.profissionais.dao;

import java.sql.Connection;
import com.mysql.jdbc.PreparedStatement;
import br.com.profissionais.model.Profissionais;
import br.com.profissionais.factory.ConnectionFactory;
import java.sql.Date;

public class ProfissionaisDAO {
	//CRUD
	
	public void save(Profissionais profissional) {
		String sql = "INSERT INTO cadastro_profissionais(nomeCompleto, apelido, celular, aniversario, cep, rua, numero, comp, bairro, cidade, estado) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, profissional.getNomeCompleto());
			pstm.setString(2, profissional.getApelido());
			pstm.setInt(3, profissional.getCelular());
			pstm.setDate(4, new Date(profissional.getAniversario().getTime()));
			pstm.setString(5, profissional.getCep());
			pstm.setString(6, profissional.getRua());
			pstm.setInt(7, profissional.getNumero());
			pstm.setString(8, profissional.getComp());
			pstm.setString(9, profissional.getBairro());
			pstm.setString(10, profissional.getCidade());
			pstm.setString(11, profissional.getEstado());
			
			
			pstm.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!=null) {
					pstm.close();
				}
				if(conn!=null) {
					conn.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
	