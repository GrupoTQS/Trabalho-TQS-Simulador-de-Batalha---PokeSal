package Atividade;
 
public class Terreno {
	public static double BTerreeno(String Atacante, String Terra, boolean Dano) {
		if (Terra.equals("Asfalto Quente") && Atacante.equals("Fogo")) {
			return 1.5;
		}
		if (Terra.equals("Poça de Chuva") && Atacante.equals("Agua") && Dano) {
			return 1.10;
		}
		return 1.0;
	}
 
	public static int Ccentral(String Terra, String TipoPokemon, int HPAtual, int HPMaximo) {
		if (!TipoPokemon.equals("Grama")) {
			return HPAtual;
		}
		int cura = (int) (HPMaximo * 0.05);
		int novoHP = HPAtual + cura;
		if (novoHP > HPMaximo) {
			novoHP = HPMaximo;
		}
		return novoHP;
	}
}
 
