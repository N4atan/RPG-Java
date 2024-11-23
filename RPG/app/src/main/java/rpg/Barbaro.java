package rpg;

public class Barbaro implements Player{
    //Vida, Força, Mana, Agilidade (opc).
    private String name;
    private int hp;
    private int strenght;
    private int mana;

    public Barbaro(String name, int hp, int strenght, int mana) {
        this.name = name;
        this.hp = hp;
        this.strenght = strenght;
        this.mana = mana;
    }

    
    public void setHp(int hp)             { this.hp = hp;             }
    public void setStrength(int strength) { this.strenght = strength; }
    public void setMana(int mana)         { this.mana = mana;         }

    public String getName()     { return this.name;     }
    public int getHp()          { return this.hp;       }
    public int getStrenght()    { return this.strenght; }
    public int getManta()       { return this.mana;     }

    public boolean checkAlive() { return this.hp > 0;   }

    public void attack(Player oponente) {
        oponente.setHp( oponente.getHp() - this.getStrenght() );
    }

    public void deffend(Player oponente) {
        this.setHp( oponente.getStrenght() / 2 );
    }

    public void useItem() {

    }    //Implementar Item

    public void usePotion() {
        this.hp += 10;
    }

    public void fugir() {

    }

    public String toString() {
        return "| Nome: " + this.name + "\n" +
               "| HP: " + hp + "\n" +
               "| Strength: " + this.strenght + "\n" +
               "| Mana: " + this.mana;
    }
}
