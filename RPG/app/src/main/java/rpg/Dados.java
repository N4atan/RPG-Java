package rpg;

public class Dados {
    public int dado1;
    public int dado2;
    public int dado3;
    public int dado4;

    public void rolarDados() {
        this.dado1 = (int) (Math.random() * 6) + 1;
        this.dado2 = (int) (Math.random() * 6) + 1;
        this.dado3 = (int) (Math.random() * 6) + 1;
        this.dado4 = (int) (Math.random() * 6) + 1;
    }

    public int somaDosDados() {
        return this.dado1 + this.dado2 + this.dado3 + this.dado4;
    }

    public int rolarESomar() {
        this.dado1 = (int) (Math.random() * 6) + 1;
        this.dado2 = (int) (Math.random() * 6) + 1;
        this.dado3 = (int) (Math.random() * 6) + 1;
        this.dado4 = (int) (Math.random() * 6) + 1;
        return this.dado1 + this.dado2 + this.dado3 + this.dado4;
    }
}
