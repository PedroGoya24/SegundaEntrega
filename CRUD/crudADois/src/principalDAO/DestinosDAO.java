package principalDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import principal.Conexao;
import principal.Destinos;

public class DestinosDAO {
	
	
	private Connection conexao;
	
	public DestinosDAO() {
		try {
			conexao = Conexao.conectar();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}
	
	public void fecharConexao() {
		try {
			if(conexao != null && !conexao.isClosed()) {
				conexao.close();
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void criarDestino(Destinos Destinos) {
		String sql = "INSERT INTO Destinos (nomeDest) VALUES (?)";
		
		try(PreparedStatement stmt = conexao.prepareStatement(sql)){
			stmt.setString(1, Destinos.getNomeDest());
			
			stmt.executeUpdate();
			System.out.println("Destino cadastrado com sucesso!!!");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public List<Destinos> listarDestinos(){
		List<Destinos> Destinos = new ArrayList<>();
		String sql = "SELECT * FROM Destinos";
		
		try (PreparedStatement stmt = conexao.prepareStatement(sql)){
			ResultSet resultado = stmt.executeQuery();
			
			while(resultado.next()) {
				Destinos Destino = new Destinos();
				Destino.setId(resultado.getInt("idDes"));
				Destino.setNomeDest(resultado.getString("nomeDest"));
				Destinos.add(Destino);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return Destinos;
	}
	
	
	public void atualizarDestinos(Destinos destino) {
		String sql = "UPDATE Destinos SET nomeDest = ? WHERE idDes = ?";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, destino.getNomeDest());
			stmt.setInt(2, destino.getId());
			stmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			fecharConexao();
		}
	}
	
	
	public Destinos buscarDestinos(int id) {
		Destinos Destino = null;
		String sql = "SELECT * FROM Destinos WHERE idDes = ?";
		try(PreparedStatement stmt = conexao.prepareStatement(sql)){
			stmt.setInt(1, id);			
			ResultSet resultado = stmt.executeQuery();
			
			if(resultado.next()) {
				Destino = new Destinos();
				Destino.setId(resultado.getInt("idDes"));
				Destino.setNomeDest(resultado.getString("nomeDest"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return Destino;
	}
	
	public void excluirDestinos(int id) {
		String sql = "DELETE FROM Destinos WHERE idDes = ?";
		
		try(PreparedStatement stmt = conexao.prepareStatement(sql)){
			
			stmt.setInt(1, id);
			stmt.executeUpdate();
			System.out.println("Excluido com sucesso!!!");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
