import java.awt.Dimension;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class Model {

	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;
	public static double keyPressedMillis = 0;
	public static double keyPressLength;

	// Timer t = new Timer(4, new timerListener() );
	public static void main(String[] args) {
		JFrame frame = new JFrame("Model");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ModelFrame canvas = new ModelFrame(WIDTH, HEIGHT);
		canvas.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		frame.add(canvas);
		frame.pack();

		JTextField textField = new JTextField(50);
		textField.setPreferredSize(new Dimension(1100, 600));
		JPanel panel = new JPanel();

		JButton reset = new JButton("Reset");

		// action listeners
		class thisKeyListener implements KeyListener {

			public void keyTyped(KeyEvent e) {
				if (e.getKeyChar() == 'p') {
					canvas.reset();
				}

			}

			int lastKey = -1;

			public void keyPressed(KeyEvent e) {
				
				int x = e.getKeyCode();
				if(e.getKeyChar() == 'r') {
					canvas.reset();
					panel.setVisible(true);
				}
				if (x != lastKey) {
					lastKey = x;

						keyPressedMillis = System.currentTimeMillis();
					
				}

			}

			public void keyReleased(KeyEvent e) {
				int x = e.getKeyCode();

						keyPressLength = System.currentTimeMillis() - keyPressedMillis;

						if (keyPressLength < 100) {
							canvas.close();
							System.out.println("test");
							panel.setVisible(false);
						}
			}
		}

		class textListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				String text = textField.getText();

			}
		}

		class keyListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {

			}
		}

		class resetListener implements ActionListener {

			public void actionPerformed(ActionEvent e) {
				canvas.reset();
				textField.setText("");
				canvas.setFocusable(true);
				canvas.requestFocus();
				panel.setVisible(true);
				// canvas.outOfBounds();

			}

		}
		

		reset.addActionListener(new resetListener());
		textField.addActionListener(new textListener());
		textField.addKeyListener(new thisKeyListener());
		panel.add(reset);
		frame.add(panel);

		panel.add(textField);

		frame.setVisible(true);


	}

}
