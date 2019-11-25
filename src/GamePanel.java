import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel {
	private JTextField inputText = new JTextField(40);
	public GamePanel() {
		setLayout(new BorderLayout());
		add(new JGameGroundPanel(), BorderLayout.CENTER);
		add(new JInputPanel(), BorderLayout.SOUTH);
	}
	
	class JGameGroundPanel extends JPanel {
		public JGameGroundPanel() {
			setBackground(MyColor.LIGHT);
			setLayout(null);
		}
	}
	class JInputPanel extends JPanel {
		public JInputPanel() {
			setBackground(MyColor.LIGHT);
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
