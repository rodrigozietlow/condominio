package apartamento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import morador.Morador;
import morador.MoradorDAO;
import run.ConexaoBD;

/**
 * 
 */
public class ApartamentoDAOConcreto implements ApartamentoDAO {

	private ConexaoBD conexao;
	private MoradorDAO moDAO;
	
    public ApartamentoDAOConcreto(ConexaoBD c, MoradorDAO moDAO) {
    	this.conexao = c;
    	this.moDAO = moDAO;
    }

    public List<Apartamento> CarregarApartamentos() {
        List<Apartamento> lista = new ArrayList<Apartamento>();
        List<Morador> moradores = this.moDAO.CarregarMoradores();
        
        try {
			PreparedStatement stmt = this.conexao.getConexao().prepareStatement("SELECT * FROM apartamento");
			PreparedStatement stmt2 = this.conexao.getConexao().prepareStatement("SELECT * FROM padrão WHERE idApartamento = ?");
			PreparedStatement stmt3 = this.conexao.getConexao().prepareStatement("SELECT * FROM luxo WHERE idApartamento = ?");
			PreparedStatement stmt4 = this.conexao.getConexao().prepareStatement("SELECT idMorador FROM morador_apartamento WHERE idApartamento = ?");
			Apartamento a;
			
			ResultSet r = stmt.executeQuery();
			while (r.next()) {
				if(r.getInt("tipo") == 1) {
					stmt2.setInt(1, r.getInt("id"));
					ResultSet r2 = stmt2.executeQuery();
					if(r2.next()) {
						a = new Padrão(r.getInt("id"), r.getInt("numero"), r.getInt("andar"), null, new ArrayList<Morador>(), r2.getString("tipoArmarios"), r2.getString("tipoPisos"));
						lista.add(a);
					}
					else {
						throw new SQLException("Impossível localizar o apartamento especificado :: ele não possui tipo");
					}
				}
				else {
					stmt3.setInt(1, r.getInt("id"));
					ResultSet r2 = stmt3.executeQuery();
					if(r2.next()) {
						a = new Luxo(r.getInt("id"), r.getInt("numero"), r.getInt("andar"), null, new ArrayList<Morador>(), r2.getString("luminarias"), r2.getBoolean("geladeira"), r2.getBoolean("fogao"));
						lista.add(a);
					}
					else {
						throw new SQLException("Impossível localizar o apartamento especificado :: ele não possui tipo");
					}
				}
				
				// carregar os moradores daquele apartamento
				stmt4.setInt(1, r.getInt("id"));
				ResultSet r3 = stmt4.executeQuery();
				while(r3.next()) {
					for (Morador morador : moradores) {
						if(r3.getInt("idMorador") == morador.getId()) {
							morador.getApartamentos().add(a);
							a.getMoradores().add(morador);
						}
					}
				}
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
        return lista;
    }
    
    public boolean SalvarApartamento(Apartamento a) {
        // TODO implement here
        return false;
    }

    public boolean ExcluirApartamento(Apartamento a) {
        // TODO implement here
        return false;
    }

	@Override
	public boolean ExcluirAssociacaoMorador(Apartamento a, Morador m) {
		boolean retorno = false;
		
		try {
			PreparedStatement stmt = this.conexao.getConexao().prepareStatement("DELETE FROM morador_apartamento WHERE idMorador = ? AND idApartamento = ?");
			stmt.setInt(1, m.getId());
			stmt.setInt(2, a.getId());
			if(stmt.executeUpdate() > 0) {
				retorno = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return retorno;
	}

	@Override
	public boolean AdicionarAssociacaoMorador(Apartamento a, Morador m) {
boolean retorno = false;
		
		try {
			PreparedStatement stmt = this.conexao.getConexao().prepareStatement("INSERT INTO morador_apartamento (idMorador, idApartamento, data) VALUES (?, ?, CURDATE())");
			stmt.setInt(1, m.getId());
			stmt.setInt(2, a.getId());
			if(stmt.executeUpdate() > 0) {
				retorno = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return retorno;
	}
}