package pracseven;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class Dice extends JPanel {
    private int value;
    private JButton rollButton;

    public Dice() {
        setPreferredSize(new Dimension(250, 250));
        value = new Random().nextInt(6) + 1;
        
        rollButton = new JButton("Roll");
        rollButton.addActionListener(new ActionListener() {
            @Override  
            public void actionPerformed(ActionEvent e) {
                value = new Random().nextInt(6) + 1;
                repaint();
            }
        });
        
        setLayout(new BorderLayout());
        add(rollButton, BorderLayout.SOUTH);
    }

    private void draw(Graphics g, int x, int y) {
        // Draw the square for the dice
        g.setColor(Color.WHITE);
        g.fillRect(x, y, 50, 50);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, 50, 50);
        
        // Draw the dots for the dice
        g.setColor(Color.BLACK);
        switch (value) {
            case 1:
                g.fillOval(x + 20, y + 20, 10, 10);
                break;
            case 2:
                g.fillOval(x + 10, y + 10, 10, 10);
                g.fillOval(x + 30, y + 30, 10, 10);
                break;
            case 3:
                g.fillOval(x + 10, y + 10, 10, 10);
                g.fillOval(x + 20, y + 20, 10, 10);
                g.fillOval(x + 30, y + 30, 10, 10);
                break;
            case 4:
                g.fillOval(x + 10, y + 10, 10, 10);
                g.fillOval(x + 30, y + 10, 10, 10);
                g.fillOval(x + 10, y + 30, 10, 10);
                g.fillOval(x + 30, y + 30, 10, 10);
                break;
            case 5:
                g.fillOval(x + 10, y + 10, 10, 10);
                g.fillOval(x + 30, y + 10, 10, 10);
                g.fillOval(x + 20, y + 20, 10, 10);
                g.fillOval(x + 10, y + 30, 10, 10);
                g.fillOval(x + 30, y + 30, 10, 10);
                break;
            case 6:
                g.fillOval(x + 10, y + 10, 10, 10);
                g.fillOval(x + 30, y + 10, 10, 10);
                g.fillOval(x + 10, y + 20, 10, 10);
                g.fillOval(x + 30, y + 20, 10, 10);
                g.fillOval(x + 10, y + 30, 10, 10);
                g.fillOval(x + 30, y + 30, 10, 10);
                break;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g, 25, 25);
    }

}
