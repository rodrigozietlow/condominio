package condominio;

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
public class CondominioDAOConcreto implements CondominioDAO {
	private ConexaoBD conexao;
	
    public CondominioDAOConcreto(ConexaoBD c) {
    	this.conexao = c;
    }

    public List<Condominio> CarregarCondominios() {
        ArrayList<Condominio> condominios = new ArrayList<Condominio>();
        
        try {
			PreparedStatement stmt = this.conexao.getConexao().prepareStatement("SELECT * FROM condominio");
			ResultSet r = stmt.executeQuery();
			while (r.next()) {
				Condominio c = new Condominio(r.getInt("id"), r.getString("nome"), r.getString("cidade"), r.getString("bairro"), r.getString("numero").charAt(0));
				condominios.add(c);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
        return condominios;
    }

    public boolean SalvarCondominio(Condominio c) {
    	boolean retorno = false;
    	
    	try {
    		PreparedStatement stmt;
    		
	    	if(m.getId() == 0) {
	    		stmt = this.conexao.getConexao().prepareStatement("INSERT INTO condominio VALUES (NULL, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
	    		stmt.setString(1, m.getNome());
	    		stmt.setString(2, m.getCidade());
	    		stmt.setString(3, m.getBairro());
	    		stmt.setInt(4, m.getNumero());
	    	}
	    	else {
	    		stmt = this.conexao.getConexao().prepareStatement("UPDATE condominio SET nome = ?, cidade = ?, bairro = ?, numero = ? WHERE id = ?");
	    		stmt.setString(1, m.getNome());
	    		stmt.setString(2, m.getCidade());
	    		stmt.setString(3, m.getBairro());
	    		stmt.setInt(4, m.getNumero());
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

    public boolean ExcluirCondominio(Condominio c) {
        
        boolean retorno = false;
        
        try {
			PreparedStatement stmt = this.conexao.getConexao().prepareStatement("DELETE FROM condominio WHERE id=?");
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