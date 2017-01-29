package dreidelgame;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ilana on 1/29/2017.
 */
public class drawingComponent extends JComponent {
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        Rectangle rect1 = new Rectangle(5,5,100, 200);
        g2.draw(rect1);
    }
}
