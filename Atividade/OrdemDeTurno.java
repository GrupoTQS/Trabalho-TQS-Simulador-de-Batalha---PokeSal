package Atividade;

import java.util.Random;

public class OrdemDeTurno {
	public static String Atacanten1 (String nomeA, int SPDA, String nomeB, int SPDB) {
		
		if (SPDA > SPDB) {
			return nomeA;
			
			
		}
		if (SPDB > SPDA) {
			return nomeB;
		}
		Random r = new Random();
				if(r.nextInt(2)==0) {
					return nomeA;
				}
				else{
					return nomeB;
		
	}

}
		

