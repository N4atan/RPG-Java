package rpg;

public class Villa extends Scene{
    public boolean liderDerrotado = false;
    public boolean recuaram = false;
    public boolean aldeosSalvos = false;
    public boolean vilaDestruida = false;
    public boolean batedoresEliminados = false;
    public boolean goblinsConfusos = false;
    public boolean ladinoDescoberto = false;
    public boolean armadilhasAtivas = false;


    public Villa(Player player){
        super(player);
        globalText = "\tO jogo começa em uma pequena vila chamada Erindale, que foi atacada por um grupo de goblins saqueadores. A fumaça sobe das casas em chamas, e você ouve gritos desesperados enquanto os moradores tentam se defender. Como herói, você precisa agir rapidamente.";

        barbaroText = "\tVocê sente a fúria correr em suas veias ao ver a destruição. Sua força é sua maior arma, e com um rugido de guerra, você avança sem medo, atacando os goblins que ameaçam os moradores. Sua abordagem é direta, preferindo esmagar seus inimigos com força bruta.\n";

        ladinoText = "\tVocê se esconde nas sombras, observando o caos. Sabendo que um ataque direto seria insensato, você procura a oportunidade perfeita para eliminar os goblins sem chamar atenção. Sua abordagem é furtiva e silenciosa.\n";

        hunterText = "\tVocê está acostumado a rastrear criaturas e entender o terreno. No caos da vila, você analisa rapidamente a situação e posiciona suas armadilhas para conter o avanço dos goblins. Sua abordagem é estratégica. \n"; 

        barbaroChoises = new String[] {
            "Investir contra o líder dos goblins", 
            "Defender os aldeões próximos"
        };

        ladinoChoises = new String[] {
            "Eliminar os batedores silenciosamente",
            "Encontrar uma rota de fuga para os aldeões"
        };

        hunterChoises = new String[] {
            "Colocar armadilhas na entrada da vila",
            "Usar sua furtividade para rastrear o chefe dos goblins"
        };

        afterBarbaroChoises = new String[] {
            //Ambos os casos inicia batalha.
            //Lider derrotado --> Recuam --> Aldeos Salvos
            "\tVocê avança em direção ao líder dos goblins, um guerreiro musculoso empunhando uma enorme clava. Com um grito que faz até mesmo alguns goblins recuarem, você ergue sua arma e desfere um golpe poderoso. O líder tenta bloquear, mas sua força supera a dele, lançando-o para trás. Ele se levanta cambaleante, pronto para um segundo round, mas você percebe que o restante do bando hesita, vendo sua determinação."
            ,
            //Aldeos Salvos --> Vila destruida
            //Depois da batalha, os goblins destroem a villa e saiem da villa.
            "\tVocê usa sua força para erguer uma carroça virada e colocá-la como uma barricada. Os aldeões se abrigam atrás dela enquanto você enfrenta qualquer goblin que se aproxima. O combate será intenso, mas a barreira temporária permite que os moradores se organizem para contra-atacar ou fugir."
        };

        afterLadinoChoises = new String[] {
            //Inicia batalha, 2 vezes.
            //Batedores Eliminados --> Goblins Confusos --> Recuam --> Aldeos Salvos
            "\tVocê se move pelas sombras, sua adaga brilhando sob a luz das chamas. Voce deve eliminar os goblins batedores que estão distraídos observando a vila e coordenando o ataque. Cada morte reduz a eficácia dos goblins, para que começem a parecer desorganizados."
            ,
            //50% de Ladino descoberto. Caso não, Aldeos Salvos --> Vila destruida.
            "\tVocê analisa o terreno e identifica um caminho seguro para os aldeões. Usando gestos silenciosos e instruções rápidas, você guia pequenos grupos para fora da vila. Pelo caminho, você desarma armadilhas e evita patrulhas goblins."
        };

        afterHunterChoises = new String[] {
            //Inicia batalha com chefe goblin
            //Lider derrotado --> Recuam --> Aldeos Salvos
            "\tVocê segue os rastros do líder goblin, mantendo uma distância segura. Ele parece mais astuto do que os outros, comandando os ataques com precisão. Porem, em determinado momento ele fica isolado, você se prepara e parte pra cima dele."
            ,
            //Armadilhas Ativas --> Goblins Confusos --> Recuam --> Aldeos Salvos
            "\tCom movimentos ágeis, você prepara armadilhas ao longo da entrada principal da vila. Redes, cordas e estacas escondidas são posicionadas estrategicamente. Os goblins avançam confiantes, mas logo encontram suas fileiras desorganizadas enquanto são capturados ou feridos pelas armadilhas."
        };
    }

    @Override
    public void exibirChoises() {
        if (player instanceof Barbaro) {
            System.out.println(barbaroText);
            for (int i = 0; i < barbaroChoises.length; i++) {
                System.out.println((i + 1) + ")" + barbaroChoises[i]);
            }
        } else if (player instanceof Ladino) {
            System.out.println(ladinoText);
            for (int i = 0; i < ladinoChoises.length; i++) {
                System.out.println((i + 1) + ")" + ladinoChoises[i]);
            }
        } else if (player instanceof Hunter) {
            System.out.println(hunterText);
            for (int i = 0; i < hunterChoises.length; i++) {
                System.out.println((i + 1) + ")" + hunterChoises[i]);
            }
        }
    }
    
    @Override
    public void processChoise(int choise) {
        choise--;

        if(player instanceof Barbaro){
                System.out.println(afterBarbaroChoises[choise]);

                if(choise == 0) {
                    //Chamar funcao de batalha
                    //Lider derrotado --> Recuam --> Aldeos Salvos
                    liderDerrotado = true;
                    recuaram = true;
                    aldeosSalvos = true;
                } else {
                    //Aldeos Salvos.
                    //Depois da batalha, os goblins destroem a villa e saiem da villa.
                    aldeosSalvos = true;
                    vilaDestruida = true;
                }

        } else if(player instanceof Ladino) {
                System.out.println(afterLadinoChoises[choise]);

                if(choise == 0) {
                    //Inicia batalha, 2 vezes.
                    //Batedores Eliminados --> Goblins Confusos --> Recuam --> Aldeos Salvos

                    batedoresEliminados = true;
                    goblinsConfusos = true;
                    recuaram = true;
                    aldeosSalvos = true;
                } else {
                    //50% de Ladino descoberto. Caso não, Aldeos Salvos --> Vila destruida.
                    if(ladinoDescoberto = Math.random() < 0.5) {
                        //Batalha contra o chefe
                        liderDerrotado = true;
                        recuaram = true;
                        aldeosSalvos = true;
                    } else {
                        aldeosSalvos = true;
                        vilaDestruida = true;
                    }

                }

        } else if(player instanceof Hunter) {

                System.out.println(afterHunterChoises[choise]);

                if(choise == 0) {
                    //Inicia batalha com chefe goblin
                    //Lider derrotado --> Recuam --> Aldeos Salvos
                } else {
                    //Armadilhas Ativas --> Goblins Confusos --> Recuam --> Aldeos Salvos
                    armadilhasAtivas = true;
                    goblinsConfusos = true;
                    recuaram = true;
                    aldeosSalvos = true;
                }

        }
    }

    
}

