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


public class FuncionarioDAO {

	

		private static final String selectFindFuncionario = "select * from funcionario where nome = ?";
		private static final String insertFuncionario = "insert into funcionario(nome,endereco,telefone,funcao) values (?, ?, ?,?)";
		private static final String deleteFuncionario = "delete *from cliente(nome,endereco,telefone,funcao) values(?,?,?,?)" ;
//		private static final String updateCliente = "update into cliente(nome,endereco,telefone) values (?, ?, ?)";

		// Configura essas variáveis de acordo com o seu banco


		public Funcionario findFuncionario(String nome) {
		
			Funcionario fu = null;
			
			try {
				Connection con = DriverManager.getConnection(
						"jdbc:postgresql://localhost/SalaodeBeleza", "postgres",
						"senacrs");
				
			
				
				PreparedStatement stmt = con.prepareStatement(selectFindFuncionario);
				stmt.setString(1, nome);
				ResultSet rs = stmt.executeQuery();
				if (rs.next()) {
			    	int id = rs.getInt("id");
					String nome2 = rs.getString("nome");
					String endereco = rs.getString("endereco");
					String telefone = rs.getString("telefone");
					String funcao = rs.getString("funcao");
					fu = new Funcionario(nome2, endereco, telefone, funcao,id);
				}
			} catch (Exception e) {
				e.printStackTrace();
				// FIXME: comunicar erro ao programa
			}
			// FIXME: fechar conexões

			return fu;
			
		}
		
		public void inserir(Funcionario f) {
			if (f == null) {
				throw new IllegalArgumentException("O cliente não pode ser null!");
			}
			

			try {
				Connection con = DriverManager.getConnection(
						"jdbc:postgresql://localhost/SalaodeBeleza", "postgres",
						"senacrs");

				PreparedStatement stmt = con.prepareStatement(insertFuncionario);
				stmt.setString(1, f.getNome());
				stmt.setString(2, f.getEndereco());
				stmt.setString(3, f.getTelefone());
				stmt.setString(4, f.getFuncao());
				
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
		
		public void deletar(Funcionario del) {
			if (del == null) {
				throw new IllegalArgumentException("O cliente não pode ser null!");
			}
			

			try {
				Connection con = DriverManager.getConnection(
						"jdbc:postgresql://localhost/SalaodeBeleza", "postgres",
						"senacrs");

				PreparedStatement stmt = con.prepareStatement(deleteFuncionario);
				stmt.setString(1, del.getNome());
				stmt.setString(2, del.getEndereco());
				stmt.setString(3, del.getTelefone());
				stmt.setString(4, del.getFuncao());
				
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


