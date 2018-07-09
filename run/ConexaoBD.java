package run;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoBD {
	
	private Connection conexao;
	
	// Metodo responsável para estabelecer conexão
    public ConexaoBD() {
		String driver = "org.mariadb.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/predios?useSSL=false&serverTimezone=GMT";
		String user = "root";
		String password = "root";
		
		try {
			Class.forName(driver);
			this.conexao = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			System.out.println(e);
		}
    }
    
    public Connection getConexao() {
    	return this.conexao;
    }
}