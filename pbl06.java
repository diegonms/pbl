class Pizza {
    private String sabor;

    public Pizza(String sabor) {
        this.sabor = sabor;
    }

    public void mostrarMensagem() {
        System.out.println("Pizza sabor: " + sabor);
    }
}

class Carne {
    private String corte;

    public Carne(String corte) {
        this.corte = corte;
    }

    public void mostrarMensagem() {
        System.out.println("Carne de corte: " + corte);
    }
}

class Pao {
    private String tipo;

    public Pao(String tipo) {
        this.tipo = tipo;
    }

    public void mostrarMensagem() {
        System.out.println("Pao de tipo: " + tipo);
    }
}

public class pbl06 {
    public static void main(String[] args) {
        Carne c1 = new Carne("Mignon");
        Carne c2 = new Carne("Picanha");
        Pizza p1 = new Pizza("Quatro queijos");
        Pizza p2 = new Pizza("Margherita");
        Pao pa1 = new Pao("de queijo");
        Pao pa2 = new Pao("francês");
        assar(p1);
        assar(pa2);
        assar(c1);
        assar(c2);
        assar(pa1);
        assar(p2);
    }

    public static void assar(Pizza pi) {
        pi.mostrarMensagem();
        System.out.println("Assando pizza");
    }

    public static void assar(Carne c) {
        c.mostrarMensagem();
        System.out.println("Assando carne");
    }

    public static void assar(Pao pa) {
        pa.mostrarMensagem();
        System.out.println("Assando pao");
    }
}
