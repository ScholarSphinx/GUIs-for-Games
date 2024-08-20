package pracseven;
import java.awt.*;
import javax.swing.*;

public class TicTacToe extends JPanel {
    public TicTacToe() {
        setPreferredSize(new Dimension(400, 400));
        setLayout(new GridLayout(3, 3)); // Set layout for 3x3 grid

        // Create and add 9 custom panels to the grid
        for (int i = 0; i < 9; i++) {
            add(new Cell());
        }
    }

    class Cell extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int choice = (int) (Math.random() * 3); // Randomly choose 0, 1, or 2

            // Set the drawing color
            g.setColor(Color.BLACK);

            // Draw X, O, or nothing based on the random choice
            if (choice == 0) {
                // Draw X
                g.drawLine(10, 10, getWidth() - 10, getHeight() - 10);
                g.drawLine(getWidth() - 10, 10, 10, getHeight() - 10);
            } else if (choice == 1) {
                // Draw O
                g.drawOval(10, 10, getWidth() - 20, getHeight() - 20);
            }
            // If choice is 2, do not draw anything
        }
    }

    
}
