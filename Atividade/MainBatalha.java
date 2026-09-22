package Atividade;

import java.util.Random;
import java.util.Scanner;

public class MainBatalha {

    static Random r = new Random();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] nomesGrama = {"Bulbaucsal", "Chicocsal"};
        String[] nomesFogo  = {"Charmancsal", "Cyndacsal"};
        String[] nomesAgua  = {"Totocsal", "Squircsal"};

        
        System.out.println("Escolha seu Pokésal inicial:");
        System.out.println("1 - Planta   2 - Fogo   3 - Agua");
        int escolha = scanner.nextInt();

        Pokemons jogador = criarPokemon(escolha, nomesGrama, nomesFogo, nomesAgua);

        Atribs atribs = new Atribs();
        System.out.println("Distribua os atributos do seu Pokésal (" + jogador.getNome() + "):");
        atribs.Pstatus(jogador);

       
        Pokemons adversario = criarPokemon(1 + r.nextInt(3), nomesGrama, nomesFogo, nomesAgua);
        int[] statsAdv = distribuirAleatorio(150);
        adversario.setHP(statsAdv[0]);
        adversario.setATK(statsAdv[1]);
        adversario.setDEF(statsAdv[2]);
        adversario.setSPD(statsAdv[3]);

        
        String[] terrenos = {"Asfalto Quente", "Poça de Chuva", "Canteiro Central"};
        String terreno = terrenos[r.nextInt(3)];
        System.out.println("\nTerreno da batalha: " + terreno);
        System.out.println(jogador.getNome() + " (" + jogador.getTipo() + ") VS "
                + adversario.getNome() + " (" + adversario.getTipo() + ")\n");

       
        String primeiro = OrdemDeTurno.Atacanten1(
                jogador.getNome(), jogador.getSPD(),
                adversario.getNome(), adversario.getSPD());
        System.out.println(primeiro + " ataca primeiro!\n");

        
        System.out.println("Quantos turnos a batalha vai durar?");
        int totalTurnos = scanner.nextInt();

        int hpJogador = jogador.getHP();
        int hpAdversario = adversario.getHP();

        for (int turno = 1; turno <= totalTurnos; turno++) {
            System.out.println("--- Turno " + turno + " ---");

            if (primeiro.equals(jogador.getNome())) {
                hpAdversario = atacar(jogador, adversario, hpAdversario, terreno, jogador, scanner);
                if (hpAdversario <= 0) { System.out.println(adversario.getNome() + " foi derrotado!"); break; }
                hpJogador = atacar(adversario, jogador, hpJogador, terreno, jogador, scanner);
                if (hpJogador <= 0) { System.out.println(jogador.getNome() + " foi derrotado!"); break; }
            } else {
                hpJogador = atacar(adversario, jogador, hpJogador, terreno, jogador, scanner);
                if (hpJogador <= 0) { System.out.println(jogador.getNome() + " foi derrotado!"); break; }
                hpAdversario = atacar(jogador, adversario, hpAdversario, terreno, jogador, scanner);
                if (hpAdversario <= 0) { System.out.println(adversario.getNome() + " foi derrotado!"); break; }
            }

            
            hpJogador = Batipos.regenerarHPCanteiroCentral11(terreno, jogador.getTipo(), hpJogador, jogador.getHP());
            hpAdversario = Batipos.regenerarHPCanteiroCentral11(terreno, adversario.getTipo(), hpAdversario, adversario.getHP());

            System.out.println(jogador.getNome() + " HP: " + hpJogador + " | "
                    + adversario.getNome() + " HP: " + hpAdversario + "\n");
        }
    }

    
    private static Pokemons criarPokemon(int escolha, String[] grama, String[] fogo, String[] agua) {
        Pokemons p = new Pokemons();
        if (escolha == 1) {
            p.setNome(grama[r.nextInt(2)]);
            p.setTipo("Grama");
        } else if (escolha == 2) {
            p.setNome(fogo[r.nextInt(2)]);
            p.setTipo("Fogo");
        } else {
            p.setNome(agua[r.nextInt(2)]);
            p.setTipo("Agua");
        }
        return p;
    }

    
    private static int[] distribuirAleatorio(int total) {
        int[] valores = new int[4];
        int restante = total;
        for (int i = 0; i < 3; i++) {
            int max = restante - (3 - i);
            int v = 1 + r.nextInt(Math.max(max, 1));
            valores[i] = v;
            restante -= v;
        }
        valores[3] = restante;
        return valores;
    }

    
    private static Golpe escolherGolpe(Pokemons atacante, Pokemons jogador, Scanner scanner) {
        Golpe opcao1;
        Golpe opcao2;

        if (atacante.getTipo().equals("Fogo")) {
            opcao1 = NGolpes.lancachamas();
            opcao2 = NGolpes.boladefogo();
        } else if (atacante.getTipo().equals("Grama")) {
            opcao1 = NGolpes.povenenoso();
            opcao2 = NGolpes.chicote();
        } else {
            opcao1 = NGolpes.jatodagua();
            opcao2 = NGolpes.correntedeagua();
        }

        if (atacante == jogador) {
            System.out.println(atacante.getNome() + ", escolha seu golpe:");
            System.out.println("1 - " + opcao1.getnome());
            System.out.println("2 - " + opcao2.getnome());
            int escolha = scanner.nextInt();
            return escolha == 1 ? opcao1 : opcao2;
        }

        return r.nextBoolean() ? opcao1 : opcao2;
    }

    
    private static int atacar(Pokemons atacante, Pokemons defensor, int hpDefensorAtual, String terreno,
            Pokemons jogador, Scanner scanner) {
        Golpe golpe = escolherGolpe(atacante, jogador, scanner);

        int dano = Batipos.calcularDano(
                atacante.getATK(), defensor.getDEF(), golpe.getDano(),
                atacante.getTipo(), defensor.getTipo(), terreno, false);

        int novoHP = hpDefensorAtual - dano;

        System.out.println(atacante.getNome() + " usou " + golpe.getnome()
                + " e causou " + dano + " de dano em " + defensor.getNome() + "!");

        return novoHP;
    }
}
