package Atividade;

public class Itemnamochila {
	private String nome;
	private int cura;
	private boolean curastatus;
	
	public Itemnamochila(String nome, int cura, boolean curastatus) {
		super();
		this.nome = nome;
		this.cura = cura;
		this.curastatus = curastatus;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCura() {
		return cura;
	}

	public void setCura(int cura) {
		this.cura = cura;
	}

	public boolean isCurastatus() {
		return curastatus;
	}

	public void setCurastatus(boolean curastatus) {
		this.curastatus = curastatus;
	}
	
	

}
