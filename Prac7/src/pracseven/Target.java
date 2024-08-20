package pracseven;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Target extends JPanel {
	private JPanel drawingPanel = new JPanel();
	private JPanel buttonPanel = new JPanel();
	private int baseDiameter = 30;
	private static final int GAP = 50;

	public Target() {
		setPreferredSize(new Dimension(600, 600));
		setLayout(new BorderLayout());
		
		ActionListener command = new ButtonListener();
		JButton shrinkButton = new JButton("Shrink");
		shrinkButton.addActionListener(command);
		JButton enlargeButton = new JButton("Enlarge");
		enlargeButton.addActionListener(command);
		buttonPanel.setLayout(new GridLayout(2,0));
		buttonPanel.add(shrinkButton);
		buttonPanel.add(enlargeButton);
		
		add(buttonPanel, BorderLayout.WEST);
		add(new drawingPanel(), BorderLayout.CENTER);
	}
	
	class drawingPanel extends JPanel{

		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			draw(g);
		}
		
		public void draw(Graphics g) {
			// Circles
	        int centerX = getWidth() / 2;
	        int centerY = getHeight() / 2;
	        Color[] colors = {Color.RED, Color.BLACK};

	        for (int i = 8; i >= 0; i--) {
	            g.setColor(colors[i % 2]);
	            int circleDiameter = i * baseDiameter;
	            int x = centerX - circleDiameter / 2;
	            int y = centerY - circleDiameter / 2;
	            g.fillOval(x, y, circleDiameter, circleDiameter);
	            circleDiameter -= 30; 
	        }

	        // Target text
	        Font currentFont = g.getFont();
		    Font newFont = currentFont.deriveFont(currentFont.getSize() * 2F); // Increase font size by 2 times
		    g.setFont(newFont);
		    
			 // Draw text at the top
			g.setColor(Color.MAGENTA);
	        g.drawString("Target Practice", 180, 30);
	        
	        g.setColor(Color.BLUE);
	        Graphics2D g2 = (Graphics2D) g;
	        g2.setStroke(new BasicStroke(5)); // Set thickness of the line

	        int x1 = GAP;
	        int y1 = GAP;
	        int x2 = getWidth() - GAP;
	        int y2 = getHeight() - GAP;
	        int x3 = GAP;
	        int y3 = getHeight() - GAP;
	        int x4 = getWidth() - GAP;
	        int y4 = GAP;
	        g2.drawLine(x1, y1, x2, y2);
	        g2.drawLine(x3, y3, x4, y4);
		}
	}
	
	class ButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String op = e.getActionCommand();
			if (op.equals("Shrink") && baseDiameter != 5) {
				baseDiameter -= 5;
				repaint();
			} else if (op.equals("Enlarge") && baseDiameter != 60){
				baseDiameter += 5;
				repaint();
			}
		}
		
	}
}
