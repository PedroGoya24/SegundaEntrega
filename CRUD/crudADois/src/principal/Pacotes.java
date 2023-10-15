package principal;

public class Pacotes {
	private int id;
	private String tipoPac;
	private double precoPac;
	private Destinos destinos;
	private boolean promocao;
	
	
	public Pacotes(int id, String tipoPac, double precoPac, Destinos destinos, boolean promocao) {
		super();
		this.id = id;
		this.tipoPac = tipoPac;
		this.precoPac = precoPac;
		this.destinos = destinos;
		this.promocao = promocao;
	}
	
	public boolean isPromocao() {
		return promocao;
	}

	public void setPromocao(boolean promocao) {
		this.promocao = promocao;
	}

	public Pacotes() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipoPac() {
		return tipoPac;
	}

	public void setTipoPac(String tipoPac) {
		this.tipoPac = tipoPac;
	}

	public double getPrecoPac() {
		return precoPac;
	}

	public void setPrecoPac(Double precoPac) {
		this.precoPac = precoPac;
	}

	public Destinos getDestinos() {
		return destinos;
	}

	public void setDestinos(Destinos destinos) {
		this.destinos = destinos;
	}
	
	
	
}
