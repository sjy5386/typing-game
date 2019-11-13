import java.awt.*;
import javax.swing.*;

public class GamePanel extends JPanel {
	public GamePanel() {
		setLayout(new BorderLayout());
		add(new JGameGroundPanel(), BorderLayout.CENTER);
		add(new JInputPanel(), BorderLayout.SOUTH);
	}
	
	class JGameGroundPanel extends JPanel {
		public JGameGroundPanel() {
			setLayout(null);
		}
	}
	class JInputPanel extends JPanel {
		public JInputPanel() {
			setLayout(new FlowLayout());
		}
	}
}
