package dreidelgame;

/**
 * Created by ilana on 1/26/2017.
 */
public class Dreidel {
    int pot = 0;
    final int ITERATIONS;
    Player[] ppl = new Player[4];
    int numPlayers = 0;

    public Dreidel(int initialAmt, int numRounds) {
        System.out.println("New Dreidel created!");
        pot = initialAmt;
        ITERATIONS = numRounds;
    }

    public void addPlayer(Player a) {
        ppl[numPlayers] = a;
        numPlayers++;
        System.out.println("Player " + a.getPlayerId() + " added! " + (4-numPlayers) + " spots remaining.");
    }

    public void spinnedNun(int playerNum) {
        //does nothing
        /*
        System.out.println("Player " + (playerNum+1) + " spinned a Nun");
        System.out.println("Player " + (playerNum+1) + " score: " + ppl[playerNum].getScore());
        */
    }

    public void spinnedGimmel(int playerNum) {
        ppl[playerNum].add(pot);
        pot = 0;

        //System.out.println("Player " + (playerNum+1) + " spinned a Gimmel");

        for(int i = 0; i<numPlayers; i++) {
            if(ppl[i].isBankrupt()==false) {
                ppl[i].subtract(1);
                pot++;
                //System.out.println("Player " + (i+1) + " score: " + ppl[i].getScore());
            }
        }
    }

    public void spinnedHey(int playerNum) {
        /* If there is only one piece in the pot,
        the current player will not take anything.
        The current player will take half of what is in the pot,
        rounded down if it is a decimal number.
         */

        ppl[playerNum].add(pot/2);
        pot = pot - (pot/2);

        /*
        System.out.println("Player " + (playerNum+1) + " spinned a Hey");
        System.out.println("Player " + (playerNum+1) + " score: " + ppl[playerNum].getScore());
         */
    }

    public void spinnedShin(int playerNum) {
        ppl[playerNum].subtract(1);
        pot++;
        /*
        System.out.println("Player " + (playerNum+1) + " spinned a Shin");
        System.out.println("Player " + (playerNum+1) + " score: " + ppl[playerNum].getScore());
        */
    }

    public void play() {
        char landedOn;
        if(numPlayers == 4) {
            for(int i = 0; i<ITERATIONS; i++) {
                for(int currentPlayer = 0; currentPlayer<numPlayers; currentPlayer++) {
                    if(ppl[currentPlayer].isBankrupt()==false) {
                        landedOn = ppl[currentPlayer].spin();
                        switch (landedOn) {
                            case 'N':
                                spinnedNun(currentPlayer);
                                break;
                            case 'G':
                                spinnedGimmel(currentPlayer);
                                break;
                            case 'H':
                                spinnedHey(currentPlayer);
                                break;
                            case 'S':
                                spinnedShin(currentPlayer);
                                break;
                        }
                    }
                }
            }

            int highestScore = ppl[0].getScore();
            int id = 0;

            for(int k = 0; k<numPlayers; k++) {
                if(ppl[k].getScore()>highestScore) {
                    highestScore = ppl[k].getScore();
                    id = k;
                }
            }

            System.out.println("Player " + ppl[id].getPlayerId() + " wins!");
        } else {
            System.out.println("4 players needed!\nPlease add another player and try again!");
        }
    }
}
