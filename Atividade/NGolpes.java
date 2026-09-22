package Atividade;

public class NGolpes {

    
    public static Golpe lancachamas() {
        return new Golpe("Lança-chamas", 25, false, "Queimado", 100, -1, 0, 0.15, 0.0);
    }

    public static Golpe investida() {
        return new Golpe("Investida", 15, true, "Nenhum", 0, 0, 0, 0.0, 0.0);
    }

    public static Golpe povenenoso() {
        return new Golpe("Pó Venenoso", 10, false, "Envenenado", 100, 3, 5, 0.0, 0.0);
    }

    public static Golpe laminadefolha() {
        return new Golpe("Lâmina de Folha", 15, true, "Nenhum", 0, 0, 0, 0.0, 0.0);
    }

    
    public static Golpe jatodagua() {
        return new Golpe("Jato d'água", 15, true, "Nenhum", 0, 0, 0, 0.0, 0.0);
    }

    public static Golpe correntedeagua() {
        return new Golpe("Corrente de Água", 10, false, "Paralisia", 30, 3, 0, 0.0, 0.40);
    }

    
    public static Golpe chicote() {
        return new Golpe("Chicote de Vinha", 15, true, "Nenhum", 0, 0, 0, 0.0, 0.0);
    }

    public static Golpe vinha() {
        return new Golpe("Vinha Espinhenta Paralizante", 5, false, "Paralisia", 30, 3, 0, 0.0, 0.40);
    }

   
    public static Golpe soprodefogo() {
        return new Golpe("Sopro de Fogo", 20, false, "Queimado", 100, -1, 0, 0.15, 0.0);
    }

    public static Golpe boladefogo() {
        return new Golpe("Bola de Fogo", 15, true, "Nenhum", 0, 0, 0, 0.0, 0.0);
    }

    // ===================== TOTOLSAL =====================
    public static Golpe canhaodeagua() {
        return new Golpe("Canhão de Água", 15, true, "Nenhum", 0, 0, 0, 0.0, 0.0);
    }

    public static Golpe aguatoxica() {
        return new Golpe("Água Tóxica", 10, false, "Envenenado", 100, 3, 5, 0.0, 0.0);
    }
}