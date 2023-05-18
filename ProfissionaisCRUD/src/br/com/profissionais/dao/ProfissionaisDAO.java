package br.com.profissionais.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;
import br.com.profissionais.model.Profissionais;
import br.com.profissionais.factory.ConnectionFactory;

public class ProfissionaisDAO {
	//CRUD
	
	public void save(Profissionais profissional) {

		String sql = "INSERT INTO cadastro_profissionais(nome_completo, apelido, celular, aniversario, cep, rua, numero, comp, bairro, cidade, estado) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, profissional.getNomeCompleto());
			pstm.setString(2, profissional.getApelido());
			pstm.setInt(3, profissional.getCelular());
			pstm.setString(4, profissional.getAniversario());
			pstm.setString(5, profissional.getCep());
			pstm.setString(6, profissional.getRua());
			pstm.setInt(7, profissional.getNumero());
			pstm.setString(8, profissional.getComp());
			pstm.setString(9, profissional.getBairro());
			pstm.setString(10, profissional.getCidade());
			pstm.setString(11, profissional.getEstado());
			
			
			pstm.execute();
			
			System.out.println("Profissional salvo com sucesso!");
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

	
	public List<Profissionais> getProfissionais(){
		
		String sql = "SELECT * FROM cadastro_profissionais";
		
		List<Profissionais> profissionais = new ArrayList<Profissionais>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement)conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			
			while (rset.next()) {
				Profissionais profissional = new Profissionais();
				
				profissional.setNomeCompleto(rset.getString("nome_completo"));
				profissional.setApelido(rset.getString("apelido"));
				profissional.setCelular(rset.getInt("celular"));
				profissional.setAniversario(rset.getString("aniversario"));
				profissional.setCep(rset.getString("cep"));
				profissional.setRua(rset.getString("rua"));
				profissional.setNumero(rset.getInt("numero"));
				profissional.setComp(rset.getString("comp"));
				profissional.setBairro(rset.getString("bairro"));	
				profissional.setCidade(rset.getString("cidade"));
				profissional.setEstado(rset.getString("estado"));
				
				profissionais.add(profissional);
			}
		}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(rset!=null) {
						rset.close();
					}
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
			return profissionais;
	}
}

	

	