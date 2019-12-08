import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
public class Model {

	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;
	//Timer t = new Timer(4, new timerListener() );
	public static void main(String[] args) {
		JFrame frame = new JFrame("Model");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ModelFrame canvas = new ModelFrame(WIDTH, HEIGHT);
		canvas.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		frame.add(canvas);
		frame.pack();
		
		JTextField textField = new JTextField(50);
		textField.setPreferredSize(new Dimension (1100,600));
		
		JPanel panel = new JPanel();
		JButton reset = new JButton("Reset");
		
		//action listeners
		class timerListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				
			}
		}
		
		class textListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				String text = textField.getText();
				
			}
		}
		
		class resetListener implements ActionListener{

			public void actionPerformed(ActionEvent e) {
				canvas.reset();
				textField.setText("");
				canvas.setFocusable(true);
				canvas.requestFocus();
			//canvas.outOfBounds();

				
			}
			
		}
		reset.addActionListener(new resetListener());
		textField.addActionListener(new textListener());
		panel.add(reset);
		frame.add(panel);
		panel.add(textField);
		
		
		
		
		
		frame.setVisible(true);

	}

}
