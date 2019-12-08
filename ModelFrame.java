import javax.swing.JComponent;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Scanner;

public class ModelFrame extends JComponent{
	int height; 
	int width;
	Color black = new Color(0, 0, 0);
	
	Scanner in = new Scanner(System.in);
	
	public ModelFrame(int h, int w) {
		height = h;
		width = w;
	}
	
	public void paintComponent(Graphics gr) {
		Graphics2D g = (Graphics2D) gr;
		g.setColor(black);
		g.setFont(new Font("Comic Sans MS", Font.PLAIN, 50));
		g.drawString("AI Intruder ", 50, 200);
		g.drawString("detection", 50, 300);
		g.drawString("System model", 50, 400);

	}
	public void reset() {
		
	}

}
