package apartamento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import morador.Morador;
import run.ConexaoBD;

/**
 * 
 */
public class ApartamentoDAOConcreto implements ApartamentoDAO {

	private ConexaoBD conexao;
	
    public ApartamentoDAOConcreto(ConexaoBD c) {
    	this.conexao = c;
    }

    public List<Apartamento> CarregarApartamentos() {
        List<Apartamento> lista = new ArrayList<Apartamento>();
        
        try {
			PreparedStatement stmt = this.conexao.getConexao().prepareStatement("SELECT * FROM apartamento");
			ResultSet r = stmt.executeQuery();
			while (r.next()) {
				if(r.getInt("tipo") == 1) {
					PreparedStatement stmt2 = this.conexao.getConexao().prepareStatement("SELECT * FROM padrao WHERE idApartamento = ?");
					stmt2.setInt(1, r.getInt("id"));
					ResultSet r2 = stmt2.executeQuery();
					if(r2.next()) {
						Apartamento a = new Padrão(r.getInt("id"), r.getInt("numero"), r.getInt("andar"), null, new ArrayList<Morador>(), r2.getString("tipoArmarios"), r2.getString("tipoPisos"));
						lista.add(a);
					}
					else {
						throw new SQLException("Impossível localizar o apartamento especificado :: ele não possui tipo");
					}
				}
				else {
					PreparedStatement stmt2 = this.conexao.getConexao().prepareStatement("SELECT * FROM luxo WHERE idApartamento = ?");
					stmt2.setInt(1, r.getInt("id"));
					ResultSet r2 = stmt2.executeQuery();
					if(r2.next()) {
						Apartamento a = new Luxo(r.getInt("id"), r.getInt("numero"), r.getInt("andar"), null, new ArrayList<Morador>(), r2.getString("luminarias"), r2.getBoolean("geladeira"), r2.getBoolean("fogao"));
						lista.add(a);
					}
					else {
						throw new SQLException("Impossível localizar o apartamento especificado :: ele não possui tipo");
					}
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
        return lista;
    }

	@Override
	public List<Apartamento> CarregarApartamentosMorador(Morador m) {
		// TODO Auto-generated method stub
		return null;
	}
    
    public boolean SalvarApartamento(Apartamento a) {
        // TODO implement here
        return false;
    }

    public boolean ExcluirApartamento(Apartamento a) {
        // TODO implement here
        return false;
    }
}