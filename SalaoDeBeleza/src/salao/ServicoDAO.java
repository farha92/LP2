package salao;
	import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;




	import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

	public class ServicoDAO {

		private static final String selectFindServico = "select * from servico where tipo = ?";
		private static final String insertServico = "insert into servico(tipo) values (?)";
		private static final String deleteServico = "delete *from servico(tipo) values(?)" ;
//		private static final String updateServico = "update into servico(tipo) values (?)";

		// Configura essas variáveis de acordo com o seu banco


		public Servico findServico(String tipo) {
		
			Servico se = null;
			
			try {
				Connection con = DriverManager.getConnection(
						"jdbc:postgresql://localhost/SalaodeBeleza", "postgres",
						"senacrs");
				
			
				
				PreparedStatement stmt = con.prepareStatement(selectFindServico);
				stmt.setString(1, tipo);
				ResultSet rs = stmt.executeQuery();
				if (rs.next()) {
			    	int id = rs.getInt("id");
					String tiipo = rs.getString("tipo");
					se = new Servico(tiipo, id);
				}
			} catch (Exception e) {
				e.printStackTrace();
				// FIXME: comunicar erro ao programa
			}
			// FIXME: fechar conexões

			return se;
			
		}
		
		public void inserir(Servico s) {
			if (s == null) {
				throw new IllegalArgumentException("O cliente não pode ser null!");
			}
			

			try {
				Connection con = DriverManager.getConnection(
						"jdbc:postgresql://localhost/SalaodeBeleza", "postgres",
						"senacrs");

				PreparedStatement stmt = con.prepareStatement(insertServico);
				stmt.setString(1, s.getTipo());
				
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
		
		public void deletar(Servico dl) {
			if (dl == null) {
				throw new IllegalArgumentException("O cliente não pode ser null!");
			}
			

			try {
				Connection con = DriverManager.getConnection(
						"jdbc:postgresql://localhost/SalaodeBeleza", "postgres",
						"senacrs");

				PreparedStatement stmt = con.prepareStatement(deleteServico);
				stmt.setString(1, dl.getTipo());
				
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
		

		

	}

	

