import javax.swing.JComponent;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Scanner;

public class ModelFrame extends JComponent{
	int height; 
	int width;
	boolean isCompromised = false;
	Rectangle bye = new Rectangle(0,0,10000,1000);
	Color black = new Color(0, 0, 0);
	
	Scanner in = new Scanner(System.in);
	
	public ModelFrame(int h, int w) {
		height = h;
		width = w;
	}
	
	public void paintComponent(Graphics gr) {
		isCompromised = false;
		Graphics2D g = (Graphics2D) gr;
		g.setColor(black);
		g.setFont(new Font("Times New Roman", Font.PLAIN, 50));
		g.drawString("AI Intruder ", 50, 200);
		g.drawString("detection", 50, 300);
		g.drawString("System model", 50, 400);
		
		if(isCompromised) {
			g.draw(bye);
			g.fill(bye);
			g.setColor(black);
			g.drawString("Intruder Detected", 100, 100);
			
		}

	}
	public void reset() {
		isCompromised = false;
	}
	
	
	public void close() {
		isCompromised = true;
	}

}
