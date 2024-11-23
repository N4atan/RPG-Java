package rpg;

public interface Player {
    //Vida, Força, Mana, Agilidade (opc).
    //atacar, lançar magia, usar item ou fugir.

    void setHp(int hp);
    void setStrength(int strength);
    void setMana(int mana);

    int getHp();
    int getStrenght();
    int getManta();

    boolean checkAlive();

    void attack(Player oponente);
    
    void useItem();    //Implementar Item
    void fugir();
}
