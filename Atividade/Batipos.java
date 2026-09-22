package Atividade;
 
public class Batipos {
	public static double vantagem(String Atacante, String Defensor) {
		if (Atacante.equals("Grama") && Defensor.equals("Agua")) {
			return 2.0;
		}
		if (Atacante.equals("Agua") && Defensor.equals("Fogo")) {
			return 2.0;
		}
		if (Atacante.equals("Fogo") && Defensor.equals("Grama")) {
			return 2.0;
		}
		if (Atacante.equals("Agua") && Defensor.equals("Grama")) {
			return 0.5;
		}
		if (Atacante.equals("Fogo") && Defensor.equals("Agua")) {
			return 0.5;
		}
		if (Atacante.equals("Grama") && Defensor.equals("Fogo")) {
			return 0.5;
		}
		return 1.0;
	}
 
	public static int calcularDano(int atk, int def, int danoBase, String tipo, String tipo2, String terreno,
			boolean critico) {
		double multiplicadorTipo = vantagem(tipo, tipo2);
		double multiplicadorTerreno = Terreno.BTerreeno(tipo, terreno, true);
 
		double proporcao = (double) atk / (double) (atk + Math.max(def, 1));
		double danoBruto = danoBase * (proporcao * 2);
		double danoFinal = danoBruto * multiplicadorTipo * multiplicadorTerreno;
 
		if (critico) {
			danoFinal *= 1.5;
		}
 
		int resultado = (int) Math.round(danoFinal);
		return Math.max(resultado, 1);
	}
 
	public static int regenerarHPCanteiroCentral(String terreno, String tipo, int hpAtual, int hpMaximo) {
		if (!terreno.equals("Canteiro Central")) {
			return hpAtual;
		}
		return Terreno.Ccentral(terreno, tipo, hpAtual, hpMaximo);
	}
 
	public static int regenerarHPCanteiroCentral1(String terreno, String tipo, int hpAtual, int hpMaximo) {
		if (!terreno.equals("Canteiro Central")) {
			return hpAtual;
		}
		return Terreno.Ccentral(terreno, tipo, hpAtual, hpMaximo);
	}
 
	public static int regenerarHPCanteiroCentral11(String terreno, String tipo, int hpAtual, int hpMaximo) {
		if (!terreno.equals("Canteiro Central")) {
			return hpAtual;
		}
		return Terreno.Ccentral(terreno, tipo, hpAtual, hpMaximo);
	}
}
