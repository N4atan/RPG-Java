package rpg;

public abstract class Scene {
    public Player player;
    public String globalText;

    public String barbaroText;
    public String ladinoText;
    public String hunterText;

    public String[] barbaroChoises;
    public String[] ladinoChoises;
    public String[] hunterChoises;

    public String[] afterBarbaroChoises;
    public String[] afterLadinoChoises;
    public String[] afterHunterChoises;

    public Scene(Player player) {
        this.player = player;
    }


    public void exibirCena() {
        System.out.println(globalText);
    }
    
    public void exibirChoises() {
        switch (player) {
            case Barbaro player:
                System.out.println(barbaroText);

                for(int i = 0; i < barbaroChoises.length; i++) {
                    System.out.println((i+1) + ")" + barbaroChoises[i]);
                }

                break;
            
            case Ladino player:
                System.out.println(ladinoText);

                for(int i = 0; i < ladinoChoises.length; i++) {
                    System.out.println((i+1) + ")" + ladinoChoises[i]);
                }

                break;

            case Hunter player:
                System.out.println(hunterText);

                for(int i = 0; i < hunterChoises.length; i++) {
                    System.out.println((i+1) + ")" + hunterChoises[i]);
                }

                break;

            default:
                break;
        }
    } 

    public void processChoise(int choise) {
        choise--;
        switch (player) {
            case Barbaro player:
                System.out.println(afterBarbaroChoises[choise]);
                break;
            
            case Ladino player:
                System.out.println(afterLadinoChoises[choise]);
                break;
            
            case Hunter player:
                System.out.println(afterHunterChoises[choise]);
                break;
            default:
                break;
        }
    }
}