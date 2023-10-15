package principalDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

import principal.Compras;
import principal.Conexao;

public class ComprasDAO {
	
	private Connection conexao;
	ClienteDAO clienteDAO = new ClienteDAO();
	PacotesDAO pacotesDAO = new PacotesDAO();
	
	public ComprasDAO() {
		try {
			conexao = Conexao.conectar();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void criarCompra(Compras compras) {
		//Criar compra
		
		String sql = "INSERT INTO compras ( idCli, idPac, dataIda, dataVolta) VALUES (?, ?, ?, ?)";
		
		try(PreparedStatement stmt = conexao.prepareStatement(sql)){
			stmt.setInt(1, compras.getIdCli().getId());
			stmt.setInt(2, compras.getIdPac().getId());
			stmt.setTimestamp(3, new java.sql.Timestamp(compras.getDataIda().getTime()));
			stmt.setTimestamp(4, new java.sql.Timestamp(compras.getDataVolta().getTime()));
			stmt.executeUpdate();
			
			System.out.println("Compra cadastrada com sucesso!!!");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Compras> listarCompras(){
		List<Compras> compras = new ArrayList<>();
				
		String sql = " SELECT * FROM compras as c " + " INNER JOIN clientes as cli " + " ON c.idCli = cli.idCli " + "INNER JOIN pacotes as p " + " ON c.idPac = p.idPac ";
		
		try(PreparedStatement stmt = conexao.prepareStatement(sql)){
			
			ResultSet resultado = stmt.executeQuery();			
			while(resultado.next()) {
				
				Compras compra = new Compras();
				compra.setId(resultado.getInt("idComp"));
				compra.setIdCli(clienteDAO.buscarCliente(resultado.getInt("idCLi")));
				compra.setIdPac(pacotesDAO.buscarPacote(resultado.getInt("idPac")));
				compra.setDataIda(resultado.getTimestamp("dataIda"));
				compra.setDataVolta(resultado.getTimestamp("dataVolta"));
				compras.add(compra);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return compras;
	}
	
	public void atualizarCompra(Compras compra) {
		String sql = "UPDATE compras SET idCli = ?, idPac = ?, dataIda = ?, dataVolta = ? WHERE idComp = ?";
		try(PreparedStatement stmt = conexao.prepareStatement(sql)){
			stmt.setInt(1, compra.getIdCli().getId());
			stmt.setInt(2, compra.getIdPac().getId());
			stmt.setTimestamp(3, new java.sql.Timestamp(compra.getDataIda().getTime()));
			stmt.setTimestamp(4, new java.sql.Timestamp(compra.getDataVolta().getTime()));
			stmt.setInt(5, compra.getId());
			stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Compras buscarCompra(int id) {
		Compras compra = null;
		String sql = "SELECT * FROM compras WHERE idComp = ?";
		try(PreparedStatement stmt = conexao.prepareStatement(sql)){
			stmt.setInt(1, id);
			ResultSet resultado = stmt.executeQuery();
			if(resultado.next()) {
				compra = new Compras();
				compra.setId(resultado.getInt("idComp"));
				compra.setIdCli(clienteDAO.buscarCliente(resultado.getInt("idCli")));
				compra.setIdPac(pacotesDAO.buscarPacote(resultado.getInt("idPac")));
				compra.setDataIda(resultado.getTimestamp("dataIda"));
				compra.setDataVolta(resultado.getTimestamp("dataVolta"));				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return compra;
	}
	
	public void excluirConsulta(int id) {
		String sql = "DELETE FROM compras WHERE idComp = ?";
		try(PreparedStatement stmt = conexao.prepareStatement(sql)){
			stmt.setInt(1, id);
			stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
}
























