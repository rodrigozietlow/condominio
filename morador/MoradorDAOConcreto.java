package morador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import apartamento.Apartamento;
import run.ConexaoBD;
/**
 * 
 */
public class MoradorDAOConcreto implements MoradorDAO {
	private ConexaoBD conexao;
	
    public MoradorDAOConcreto(ConexaoBD c) {
    	this.conexao = c;
    }

    public List<Morador> CarregarMoradores() {
        ArrayList<Morador> moradores = new ArrayList<Morador>();
        
        try {
			PreparedStatement stmt = this.conexao.getConexao().prepareStatement("SELECT * FROM morador");
			ResultSet r = stmt.executeQuery();
			while (r.next()) {
				Morador m = new Morador(r.getInt("id"), r.getString("nome"), r.getString("cpf"), r.getString("rg"), r.getString("sexo").charAt(0), r.getInt("idade"), r.getFloat("renda"), new ArrayList<Apartamento>());
				moradores.add(m);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
        return moradores;
    }

    public boolean SalvarMorador(Morador m) {
    	boolean retorno = false;
    	
    	try {
    		PreparedStatement stmt;
    		
	    	if(m.getId() == 0) {
	    		stmt = this.conexao.getConexao().prepareStatement("INSERT INTO morador VALUES (NULL, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
	    		stmt.setString(1, m.getNome());
	    		stmt.setString(2, m.getCpf());
	    		stmt.setString(3, m.getRg());
	    		stmt.setString(4, String.valueOf(m.getSexo()));
	    		stmt.setInt(5, m.getIdade());
	    		stmt.setFloat(6, m.getRenda());
	    	}
	    	else {
	    		stmt = this.conexao.getConexao().prepareStatement("UPDATE morador SET nome = ?, cpf = ?, rg = ?, sexo = ?, idade = ?, renda = ? WHERE id = ?");
	    		stmt.setString(1, m.getNome());
	    		stmt.setString(2, m.getCpf());
	    		stmt.setString(3, m.getRg());
	    		stmt.setString(4, String.valueOf(m.getSexo()));
	    		stmt.setInt(5, m.getIdade());
	    		stmt.setFloat(6, m.getRenda());
	    		stmt.setInt(7, m.getId());
	    	}
	    	
	    	if(stmt.executeUpdate() > 0) {
	    		if(m.getId()==0) {
	    			ResultSet rs = stmt.getGeneratedKeys();
		    		if(rs.next()) {
		    			m.setId(rs.getInt(1));
		    		}
	    		}
	    		retorno = true;
	    	}
    	}
    	catch (Exception e) {
			e.printStackTrace();
		}
    	
        return retorno;
    }

    public boolean ExcluirMorador(Morador m) {
        
        boolean retorno = false;
        
        try {
			PreparedStatement stmt = this.conexao.getConexao().prepareStatement("DELETE FROM morador WHERE id=?");
			stmt.setInt(1, m.getId());
			
			if(stmt.executeUpdate() > 0) {
				retorno = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        return retorno;
    }
}