package dreidelgame;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ilana on 1/26/2017.
 */
public class DreidelGame {

    /*
    When I commented out all the System.out.println()'s
    and had the code run 1,000,000 times
    with an initial amount in the pot of 4 and 30 rounds played per game,
    I found that the percentage of times that the score for
    player 1 > player 2 > player 3 > player 4
    was 37%. That seems to contradict the hypothesis of the paper you gave us.
    Do you have any idea why that is?
    Also, when the initial amount in the pot is increased,
    the probability increases, and when the number of
    rounds played per game is increased, the probability decreases...
    I am unclear mathematically why that is.
     */

    public static void main(String[] args) {
        //Creating user interface.
        JFrame window = new JFrame();
        window.setSize(640, 480);
        window.setTitle("Dreidel Game");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);

        drawingComponent DC = new drawingComponent();
        window.add(DC);

        //int count = 0;

        //for(int i = 0; i<1000000; i++) {
            Dreidel test = new Dreidel(4, 30);
            Player player1 = new Player();
            Player player2 = new Player();
            Player player3 = new Player();
            Player player4 = new Player();

            test.addPlayer(player1);
            test.addPlayer(player2);
            test.addPlayer(player3);
            test.addPlayer(player4);

            test.play();


            System.out.println("Scores:");
            System.out.println("Player 1: " + player1.getScore());
            System.out.println("Player 2: " + player2.getScore());
            System.out.println("Player 3: " + player3.getScore());
            System.out.println("Player 4: " + player4.getScore());

            /*
            if(player1.getScore()>player2.getScore() && player2.getScore()>player3.getScore() && player3.getScore()>player4.getScore()) {
                count++;
            }
            */


        //}

        //System.out.println("" + (count/1000));
    }
}
