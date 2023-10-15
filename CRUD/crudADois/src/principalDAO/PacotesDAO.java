package principalDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import principal.Conexao;
import principal.Destinos;
import principal.Pacotes;

public class PacotesDAO {
	
	private Connection conexao;
	DestinosDAO destinosDAO = new DestinosDAO();
		
	public PacotesDAO() {
		try{
			conexao = Conexao.conectar();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void criarPacote(Pacotes pacotes) {
		String sql = "INSERT INTO pacotes (tipoPac, precoPac, idDes) VALUES (?,?,?)";
		
		try(PreparedStatement stmt = conexao.prepareStatement(sql)){
			stmt.setString(1, pacotes.getTipoPac());
			stmt.setDouble(2, pacotes.getPrecoPac());
			stmt.setInt(3, pacotes.getDestinos().getId());
			stmt.executeUpdate();
			System.out.println("Pacote cadastrado com sucesso!!!");
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public List<Pacotes> listarPacotes(){
		List<Pacotes> listPacotes = new ArrayList<>();
		
		String sql = "SELECT * FROM pacotes as p " + "INNER JOIN destinos as d " + "ON p.idDes = d.idDes ";
		
		try(PreparedStatement stmt = conexao.prepareStatement(sql)){
			ResultSet resultado = stmt.executeQuery();
			
			while(resultado.next()) {
				
				Pacotes pacotes = new Pacotes();
				pacotes.setId(resultado.getInt("idPac"));
				pacotes.setTipoPac(resultado.getString("tipoPac"));
				pacotes.setPrecoPac(resultado.getDouble("precoPac"));
				
				//Destinos
				Destinos destinos = new Destinos();
				destinos.setId(resultado.getInt("idDes"));
				destinos.setNomeDest(resultado.getString("nomeDest"));
				pacotes.setDestinos(destinos);
				
				listPacotes.add(pacotes);
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return listPacotes;
		
	}
	
	public List<Pacotes> listarPromos(){
		List<Pacotes> listarPromos = new ArrayList<>();
		
		String sql = "SELECT * FROM pacotes as p" + " INNER JOIN destinos as d " + " ON p.idDes = d.idDes "+ " WHERE p.promocao = 1 ";
		
		try(PreparedStatement stmt = conexao.prepareStatement(sql)){
			ResultSet resultado = stmt.executeQuery();
			
			while (resultado.next()) {
				Pacotes promos = new Pacotes();
				
				//Pacotes
				promos.setId(resultado.getInt("idPac"));
				promos.setTipoPac(resultado.getString("tipoPac"));
				promos.setPrecoPac(resultado.getDouble("precoPac"));
				
				//Destinos
				Destinos destinos = new Destinos();
				destinos.setId(resultado.getInt("idDes"));
				destinos.setNomeDest(resultado.getString("nomeDest"));
				promos.setDestinos(destinos);
				
				listarPromos.add(promos);
				
			}
					
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return listarPromos;
		
	}
	
	
	public void atualizarPacote(Pacotes Pacote) {
		String sql = "UPDATE pacotes SET tipoPac = ?, precoPac = ?, promocao = ? " + " WHERE idPac = ? ";
		try(PreparedStatement stmt = conexao.prepareStatement(sql)){
			
			stmt.setString(1, Pacote.getTipoPac());
			stmt.setDouble(2, Pacote.getPrecoPac());
			stmt.setBoolean(3, Pacote.isPromocao());
			stmt.setInt(4, Pacote.getId());
			stmt.executeUpdate();
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public Pacotes buscarPacote(int id) {
		Pacotes pacotes = null;
		String sql = "SELECT * from pacotes WHERE idPac = ?";
		
		try(PreparedStatement stmt = conexao.prepareStatement(sql)){
			
			stmt.setInt(1, id);
			ResultSet resultado = stmt.executeQuery();
			
			if(resultado.next()) {
				pacotes = new Pacotes();
				pacotes.setId(resultado.getInt("idPac"));
				pacotes.setTipoPac(resultado.getString("tipoPac"));
				pacotes.setPrecoPac(resultado.getDouble("precoPac"));
				pacotes.setDestinos(destinosDAO.buscarDestinos(resultado.getInt("idDes")));
								
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return pacotes;
		
	}
	
	
	public void excluirPacote(int id) {
		String sql = "DELETE FROM pacotes WHERE idPac = ?";
		try(PreparedStatement stmt = conexao.prepareStatement(sql)){
			
			stmt.setInt(1, id);
			stmt.executeUpdate();
			System.out.println("Pacote excluido com sucesso!!!");
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
}
