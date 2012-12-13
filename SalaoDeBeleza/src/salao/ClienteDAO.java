package salao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ClienteDAO {

	private static final String selectCliente = "select * from cliente";
	private static final String selectFindCliente = "select * from cliente where id = ?";
	private static final String insertCliente = "insert into cliente(nome,endereco,telefone) values (?, ?, ?)";
	private static final String deleteCliente = "delete from cliente where id = ?" ;
//	private static final String updateCliente = "update into cliente(nome,endereco,telefone) values (?, ?, ?)";

	// Configura essas variáveis de acordo com o seu banco


	public Cliente findCliente(int id) {
	
		Cliente cl = null;
		
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:postgresql://localhost/SalaodeBeleza", "postgres",
					"senacrs");
			
		
			
			PreparedStatement stmt = con.prepareStatement(selectFindCliente);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
		    	int id2 = rs.getInt("id");
				String nome = rs.getString("nome");
				String endereco = rs.getString("endereco");
				String telefone = rs.getString("telefone");
				cl = new Cliente(id2,nome, endereco, telefone);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// FIXME: comunicar erro ao programa
		}
		// FIXME: fechar conexões

		return cl;
		
	}
	
	public void inserir(Cliente c) {
		if (c == null) {
			throw new IllegalArgumentException("O cliente não pode ser null!");
		}
		

		try {
			Connection con = DriverManager.getConnection(
					"jdbc:postgresql://localhost/SalaodeBeleza", "postgres",
					"senacrs");

			PreparedStatement stmt = con.prepareStatement(insertCliente);
			stmt.setString(1, c.getNome());
			stmt.setString(2, c.getEndereco());
			stmt.setString(3, c.getTelefone());
			
			int r = stmt.executeUpdate();
			if (r != 1) {
				throw new RuntimeException("Erro ao inserir operação");
			}
		} catch (Exception e) {
			// FIXME: comunicar erro ao programa
			e.printStackTrace();
		}
		// FIXME: fechar conexões
	}
	
	public void deletar(Cliente d) {
		if (d == null) {
			throw new IllegalArgumentException("O cliente não pode ser null!");
		}
		

		try {
			Connection con = DriverManager.getConnection(
					"jdbc:postgresql://localhost/SalaodeBeleza", "postgres",
					"senacrs");

			PreparedStatement stmt = con.prepareStatement(deleteCliente);
			stmt.setInt(1, d.getId());			
			int r = stmt.executeUpdate();
			if (r != 1) {
				throw new RuntimeException("Erro ao deletar");
			}
		} catch (Exception e) {
			// FIXME: comunicar erro ao programa
			e.printStackTrace();
		}
		// FIXME: fechar conexões
	}
	
	
	public List<Cliente> consultarCliente() {
		
		List<Cliente> ops = new ArrayList<Cliente>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			con = DriverManager.getConnection(
					"jdbc:postgresql://localhost/SalaodeBeleza", "postgres",
					"senacrs");

			stmt = con.prepareStatement(selectCliente);
			rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String nome  = rs.getString("nome");
				String endereco  = rs.getString("endereco");
				String telefone = rs.getString("telefone");
				Cliente op = new Cliente(id,nome,endereco,telefone);
				ops.add(op);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// FIXME: comunicar erro ao programa cliente
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (rs != null) {
					stmt.close();
				}
				if (con != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				// FIXME: comunicar erro ao programa cliente
			}
		}
		return ops;
	}
	

	

}
