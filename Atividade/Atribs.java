package Atividade;

import java.util.Scanner;

public class Atribs {
	public void Pstatus(Pokemons pokemon) {
	

	Scanner s =new Scanner(System.in);
	System.out.println("Por favor distrubua até 400 pontos nesses 4 atributos");
	System.out.println("Nenhum atributo deve passar dos 125 pontos");
	
	System.out.println("Primeiro o HP");
	int hp = s.nextInt();
	System.out.println("Agora o Ataque");
	int atk = s.nextInt();
	System.out.println("Não se esqueça da Defesa");
	int def = s.nextInt();
	System.out.println("E agora  quão rapido vc será?");
	int spd = s.nextInt();
	
    int total = hp + atk + def + spd;
  
//    if(total != 400) {
//    	System.out.println("Voce deve distribuir extamente 500 pontos");
//		return;
//    }
//    	
//	
//	if (hp > 125 || atk > 125 || def > 125 || spd > 125) { System.out.println("nenhum atributo deve passar de 125");
//		
//		return;
//  
//  
//  
//  }
	pokemon.setATK(atk);
	pokemon.setDEF(def);
	pokemon.setHP(hp);
	pokemon.setSPD(spd);
	}
}