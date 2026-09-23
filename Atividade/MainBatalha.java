package Atividade;
 
import java.util.ArrayList;
import java.util.List;
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
        System.out.println("1 - BulbaSal (Planta)");
        System.out.println("2 - ChikoSal (Planta)");
        System.out.println("3 - CharSal (Fogo)");
        System.out.println("4 - CyndaSal (Fogo)");
        System.out.println("5 - TotoSal (Água)");
        System.out.println("6 - SquirtSal (Água)");
     
        int escolha = scanner.nextInt();
 
        Pokemons jogador = criarPokemon(escolha, nomesGrama, nomesFogo, nomesAgua);
 
        Atribs atribs = new Atribs();
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
 
        
        List<Itemnamochila> mochila = new ArrayList<>();
        mochila.add(Itensbatalha.Potion());
        mochila.add(Itensbatalha.Superpotion());
        mochila.add(Itensbatalha.Antidoto());
 
        int hpMaxJogador = jogador.getHP();
        int hpMaxAdversario = adversario.getHP();
 
       
        int[] hp = { jogador.getHP(), adversario.getHP() };
 
        String vencedor = null;
        int turno = 1;
        final int MAX_TURNOS_SEGURANCA = 500; 
        while (turno <= MAX_TURNOS_SEGURANCA) {
            System.out.println("--- Turno " + turno + " ---");
 
            if (primeiro.equals(jogador.getNome())) {
                turnoJogador(jogador, adversario, hp, hpMaxJogador, terreno, scanner, mochila);
                if (hp[1] <= 0) { vencedor = jogador.getNome(); break; }
 
                turnoAdversario(adversario, jogador, hp, terreno);
                if (hp[0] <= 0) { vencedor = adversario.getNome(); break; }
            } else {
                turnoAdversario(adversario, jogador, hp, terreno);
                if (hp[0] <= 0) { vencedor = adversario.getNome(); break; }
 
                turnoJogador(jogador, adversario, hp, hpMaxJogador, terreno, scanner, mochila);
                if (hp[1] <= 0) { vencedor = jogador.getNome(); break; }
            }
 
            hp[0] = Batipos.regenerarHPCanteiroCentral11(terreno, jogador.getTipo(), hp[0], hpMaxJogador);
            hp[1] = Batipos.regenerarHPCanteiroCentral11(terreno, adversario.getTipo(), hp[1], hpMaxAdversario);
 
            System.out.println(jogador.getNome() + " HP: " + hp[0] + " | "
                    + adversario.getNome() + " HP: " + hp[1] + "\n");
 
            turno++;
        }
 
        System.out.println();
        if (vencedor != null) {
            System.out.println( vencedor + " venceu a batalha!!! PARABÉNS ");
        } else {
            
            if (hp[0] > hp[1]) {
                System.out.println(" " + jogador.getNome() + " venceu por ter mais HP! ("
                        + hp[0] + " x " + hp[1] + ") ");
            } else if (hp[1] > hp[0]) {
                System.out.println("*** " + adversario.getNome() + " venceu por ter mais HP! ("
                        + hp[1] + " x " + hp[0] + ") ");
            } else {
                System.out.println("*** A batalha terminou em empate! (" + hp[0] + " x " + hp[1] + ") ***");
            }
        }
 
        scanner.close();
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
 
   
    private static Golpe[] golpesPorTipo(String tipo) {
        if (tipo.equals("Fogo")) {
            return new Golpe[] { NGolpes.lancachamas(), NGolpes.boladefogo() };
        } else if (tipo.equals("Grama")) {
            return new Golpe[] { NGolpes.povenenoso(), NGolpes.chicote() };
        } else {
            return new Golpe[] { NGolpes.jatodagua(), NGolpes.correntedeagua() };
        }
    }
 
    
    private static void turnoJogador(Pokemons jogador, Pokemons adversario, int[] hp, int hpMaxJogador,
            String terreno, Scanner scanner, List<Itemnamochila> mochila) {
 
        System.out.println(jogador.getNome() + ", você deseja:");
        System.out.println("1 - Atacar");
        System.out.println("2 - Usar item");
        int acao = scanner.nextInt();
 
        if (acao == 2) {
            if (mochila.isEmpty()) {
                System.out.println("Sua mochila está sem nada! Ataque.");
            } else {
                System.out.println("Escolha um item:");
                for (int i = 0; i < mochila.size(); i++) {
                    System.out.println((i + 1) + " - " + mochila.get(i).getNome());
                }
                int escolhaItem = scanner.nextInt();
 
                if (escolhaItem >= 1 && escolhaItem <= mochila.size()) {
                    Itemnamochila item = mochila.remove(escolhaItem - 1);
 
                    if (item.getCura() > 0) {
                        hp[0] = Math.min(hp[0] + item.getCura(), hpMaxJogador);
                        System.out.println(jogador.getNome() + " usou " + item.getNome()
                                + " e recuperou HP! HP atual: " + hp[0]);
                    } else if (item.isCurastatus()) {
                        System.out.println(jogador.getNome() + " usou " + item.getNome()
                                + " e foi curado de problemas de status!");
                    } else {
                        System.out.println(jogador.getNome() + " usou " + item.getNome() + "!");
                    }
                    return; 
                } else {
                    System.out.println("Item inválido! O turno foi perdido.");
                    return;
                }
            }
        }
 
        Golpe golpe = escolherGolpeJogador(jogador, scanner);
        int dano = Batipos.calcularDano(jogador.getATK(), adversario.getDEF(), golpe.getDano(),
                jogador.getTipo(), adversario.getTipo(), terreno, false);
        hp[1] -= dano;
        System.out.println(jogador.getNome() + " usou " + golpe.getnome()
                + " e causou " + dano + " de dano em " + adversario.getNome() + "!");
    }
 
    
    private static void turnoAdversario(Pokemons adversario, Pokemons jogador, int[] hp, String terreno) {
        Golpe[] opcoes = golpesPorTipo(adversario.getTipo());
        Golpe golpe = r.nextBoolean() ? opcoes[0] : opcoes[1];
 
        int dano = Batipos.calcularDano(adversario.getATK(), jogador.getDEF(), golpe.getDano(),
                adversario.getTipo(), jogador.getTipo(), terreno, false);
        hp[0] -= dano;
        System.out.println(adversario.getNome() + " usou " + golpe.getnome()
                + " e causou " + dano + " de dano em " + jogador.getNome() + "!");
    }
 
    private static Golpe escolherGolpeJogador(Pokemons jogador, Scanner scanner) {
        Golpe[] opcoes = golpesPorTipo(jogador.getTipo());
        System.out.println(jogador.getNome() + ", escolha seu golpe:");
        System.out.println("1 - " + opcoes[0].getnome());
        System.out.println("2 - " + opcoes[1].getnome());
        int escolha = scanner.nextInt();
        return escolha == 1 ? opcoes[0] : opcoes[1];
    }
}
 
