
package Atividade;
 
public class Golpe {
 
	private String nome;
	private int dano;
	private boolean apenasfisico;
	private String efeito;
	private int cefeito;
	private int turno;
 
	private int danoport;
	private double reducaoATK;
	private double reducaoSPD;
 
	public Golpe(String nome, int dano, boolean apenasfisico, String efeito, int cefeito, int turno, int danoport,
			double reducaoATK, double reducaoSPD) {
		this.nome = nome;
		this.dano = dano;
		this.apenasfisico = apenasfisico;
		this.efeito = efeito;
		this.cefeito = cefeito;
		this.turno = turno;
		this.danoport = danoport;
		this.reducaoATK = reducaoATK;
		this.reducaoSPD = reducaoSPD;
	}
 
	public String getnome() { return nome; }
	public int getDano() { return dano; }
	boolean isapenasfisico() { return apenasfisico; }
	public String getefeito() { return efeito; }
	public int getcefeito() { return cefeito; }
	public int turno() { return turno; }
	public int danoport() { return danoport; }
	public double getReducaoSPD() { return reducaoSPD; }
	public double getreducaoATK() { return reducaoATK; }
	
}
