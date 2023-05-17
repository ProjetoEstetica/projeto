package br.com.clientesDAO;

import java.sql.Connection;
import java.sql.Date;

import javax.imageio.plugins.tiff.ExifParentTIFFTagSet;

import com.mysql.jdbc.PreparedStatement;

import br.com.estetica.model.InfoClients;
import br.com.factory.ConnectionFactory;

public class ClientesDAO {
	// Lugar para fazer o crud
	
	public void save(InfoClients client) {
		String insert = 
		"insert into cadastro_clientes("
		+ "nome_completo, apelido, celular, aniversario, cep, rua, numero, bairro, cidade, estado"
		+ " values(?,?,?,?,?,?,?,?,?,?)";
		
		Connection conn = null;
		
		// prepara estrutura para executar
		PreparedStatement pstm = null;
		
		try {
			// tentando realizar conexao com o banco
			conn = ConnectionFactory.createConnectionToMySQL();
			// adicionando string no cursor para executar no mysql
			pstm = (PreparedStatement) conn.prepareStatement(insert);
			// guardando valor no sql
			pstm.setString(1, client.getNomeCompleto());
			pstm.setString(2, client.getApelido());
			pstm.setString(3, client.getCelular());
			pstm.setDate(4, (Date) client.getAniversario());
			pstm.setString(5, client.getCep());
			pstm.setString(6, client.getRua());
			pstm.setInt(7, client.getNum());
			pstm.setString(8, client.getBairro());
			pstm.setString(9, client.getCidade());
			pstm.setString(10, client.getEstado());
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
