package Atividade;

import java.util.Scanner;

public class Atribs {
	public void Pstatus(Pokemons pokemon) {
	

Scanner s = new Scanner(System.in);
		System.out.println("Distribua os atributos do seu Pokésal (" + pokemon.getNome() + "):");
		System.out.println("Por favor distrubua até 400 pontos nesses 4 atributos");
		System.out.println("Nenhum atributo deve passar dos 125 pontos");

		int total = 0;

		System.out.println("Primeiro o HP");
		int hp = s.nextInt();

		if (hp > 125) {
			System.out.println("Nenhum atributo pode passar de 125");
			return;
		}
		total += hp;
		if (total > 400) {
			System.out.println("Você estourou o limite! Distribua no máximo 400 pontos");
			return;
		}
		System.out.println("Você usou: " + total + "/400 | Você ainda tem: " + (400 - total));

		System.out.println("Agora o Ataque");
		int atk = s.nextInt();

		if (atk > 125) {
			System.out.println("Nenhum atributo pode passar de 125");
			return;
		}
		total += atk;
		if (total > 400) {
			System.out.println("Você estourou o limite! Distribua no máximo 400 pontos");
			return;
		}
		System.out.println("Você usou: " + total + "/400 | Você ainda tem: " + (400 - total));

		System.out.println("Não se esqueça da Defesa");
		int def = s.nextInt();

		if (def > 125) {
			System.out.println("Nenhum atributo pode passar de 125");
			return;
		}
		total += def;
		if (total > 400) {
			System.out.println("Você estourou o limite! Distribua no máximo 400 pontos");
			return;
		}
		System.out.println("Você usou: " + total + "/400 | Você ainda tem: " + (400 - total));

		System.out.println("E agora quão rápido você será?");
		int spd = s.nextInt();

		if (spd > 125) {
			System.out.println("Nenhum atributo pode passar de 125");
			return;
		}
		total += spd;
		if (total > 400) {
			System.out.println("Você estourou o limite! Distribua no máximo 400 pontos");
			return;
		}
		System.out.println("Você usou: " + total + "/400 | Você ainda tem: " + (400 - total));

		pokemon.setATK(atk);
		pokemon.setDEF(def);
		pokemon.setHP(hp);
		pokemon.setSPD(spd);

		System.out.println("Distribuição concluída com sucesso!");
	}
}
  
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
	
