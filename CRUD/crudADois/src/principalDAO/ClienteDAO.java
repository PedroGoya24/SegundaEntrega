package principalDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import principal.Cliente;
import principal.Conexao;

public class ClienteDAO {
	
	private Connection conexao;
	
	public ClienteDAO() {
		try {
			conexao = Conexao.conectar();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void criarCliente(Cliente Cliente) {
		String sql = "INSERT INTO Clientes (nomeCli, idadeCli, enderecoCli, rgCli, telefoneCli) VALUES (?, ?, ?, ? ,?)";
		
		try(PreparedStatement stmt = conexao.prepareStatement(sql)){
			
			stmt.setString(1, Cliente.getNome());
			stmt.setInt(2, Cliente.getIdade());
			stmt.setString(3, Cliente.getEndereco());
			stmt.setString(4, Cliente.getRg());
			stmt.setString(5, Cliente.getTelefone());
			stmt.executeUpdate();
			System.out.println("Cadastrado com sucesso!!!");
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void fecharConexao() {
		try {
			if(conexao != null  && !conexao.isClosed()) {
				conexao.close();
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public List<Cliente> listarClientes(){
		List<Cliente> Clientes = new ArrayList<>();
		
		String sql = "SELECT * FROM clientes";
		
		try(PreparedStatement stmt = conexao.prepareStatement(sql)){
			ResultSet resultado = stmt.executeQuery();
		
			while(resultado.next()) {
				
				Cliente Cliente = new Cliente();
				Cliente.setId(resultado.getInt("idCli"));
				Cliente.setNome(resultado.getString("nomeCli"));
				Cliente.setIdade(resultado.getInt("idadeCli"));
				Cliente.setEndereco(resultado.getString("enderecoCli"));
				Cliente.setRg(resultado.getString("rgCli"));
				Cliente.setTelefone(resultado.getString("telefoneCli"));			
				Clientes.add(Cliente);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Clientes;
	}
	
	public void excluirCliente(int id) {
		
		String sql = "DELETE FROM clientes WHERE id = ?";
		
		try(PreparedStatement stmt = conexao.prepareStatement(sql)){
			
			stmt.setInt(1, id);
			stmt.executeUpdate();
			System.out.println("Excluido com sucesso!!!");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void atualizarCliente(Cliente cliente) {
		String sql = "UPDATE clientes SET nomeCli = ?, idadeCli = ?, enderecoCli = ?, rgCli = ?, telefoneCli = ?" + " WHERE idCli = ?";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setInt(2, cliente.getIdade());
			stmt.setString(3, cliente.getEndereco());
			stmt.setString(4, cliente.getRg());
			stmt.setString(5, cliente.getTelefone());
			stmt.setInt(6, cliente.getId());
			stmt.executeUpdate();					
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Cliente buscarCliente(int id) {
		
		Cliente Cliente = null;
		String sql = "SELECT * FROM clientes WHERE idCli = ?";
		
		try(PreparedStatement stmt = conexao.prepareStatement(sql)){
			stmt.setInt(1, id);
			ResultSet resultado = stmt.executeQuery();
			
			if(resultado.next()) {
				
				Cliente = new Cliente();
				Cliente.setId(resultado.getInt("idCli"));
				Cliente.setNome(resultado.getString("nomeCli"));
				Cliente.setIdade(resultado.getInt("idadeCli"));
				Cliente.setEndereco(resultado.getString("enderecoCli"));
				Cliente.setRg(resultado.getString("rgCli"));
				Cliente.setTelefone(resultado.getString("telefoneCli"));				
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return Cliente;
		
		
	}
	
}
