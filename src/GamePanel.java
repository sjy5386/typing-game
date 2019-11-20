import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GamePanel extends JPanel {
	private JTextField inputText = new JTextField(40);
	public GamePanel() {
		setLayout(new BorderLayout());
		add(new JGameGroundPanel(), BorderLayout.CENTER);
		add(new JInputPanel(), BorderLayout.SOUTH);
	}
	
	class JGameGroundPanel extends JPanel {
		public JGameGroundPanel() {
			setBackground(new Color(220, 250, 255));
			setLayout(null);
		}
	}
	class JInputPanel extends JPanel {
		public JInputPanel() {
			setBackground(new Color(220, 250, 255));
			setLayout(new FlowLayout());
			add(inputText);
			inputText.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String word = inputText.getText();
					inputText.setText("");
				}
			});
		}
	}
}
