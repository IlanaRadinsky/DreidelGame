package dreidelgame;

import java.util.Random;

/**
 * Created by ilana on 1/26/2017.
 */
public class Player {

    public static int numPlayers = 0;

    int playerId;

    int score = 15;

    final int N = 0;
    final int G = 1;
    final int H = 2;
    final int S = 3;

    boolean isBankrupt = false;

    public Player() {
        numPlayers++;
        playerId = numPlayers;
        System.out.println("Player " + playerId + " created!");
    }

    public int getScore() {
        return score;
    }

    public boolean isBankrupt() {
        return isBankrupt;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void add(int val) {
        score = score + val;
    }

    public void subtract(int val) {
        score = score - val;

        if(score==0) {
            isBankrupt = true;
            System.out.println("Player " + playerId + " is bankrupt");
        }
    }

    public char spin() {
        Random rnd = new Random();
        int i = rnd.nextInt(4);

        switch(i) {
            case N:
                return 'N';
            case G:
                return 'G';
            case H:
                return 'H';
            case S:
                return 'S';
            default:
                return 'X';
        }
    }
}
