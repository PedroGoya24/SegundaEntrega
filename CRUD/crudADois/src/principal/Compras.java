package principal;

import java.util.Date;


public class Compras {
	private int id;
	private Pacotes idPac;
	private Cliente idCli;
	private Date dataIda;
	private Date dataVolta;
	
	public Compras(int id, Pacotes idPac, Cliente idCli, Date dataIda, Date dataVolta) {
		super();
		this.id = id;
		this.idPac = idPac;
		this.idCli = idCli;
		this.dataIda = dataIda;
		this.dataVolta = dataVolta;
		
	}
	
	public Compras() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Pacotes getIdPac() {
		return idPac;
	}

	public void setIdPac(Pacotes idPac) {
		this.idPac = idPac;
	}

	public Cliente getIdCli() {
		return idCli;
	}

	public void setIdCli(Cliente idCli) {
		this.idCli = idCli;
	}

	public Date getDataIda() {
		return dataIda;
	}

	public void setDataIda(Date dataIda) {
		this.dataIda = dataIda;
	}

	public Date getDataVolta() {
		return dataVolta;
	}

	public void setDataVolta(Date dataVolta) {
		this.dataVolta = dataVolta;
	}
	
	
	
}
