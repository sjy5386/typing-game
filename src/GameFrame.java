import java.awt.*;
import javax.swing.*;

public class GameFrame extends JFrame {
	private GamePanel gamePanel = new GamePanel();
	private	ScorePanel scorePanel = new ScorePanel();
	private EditPanel editPanel = new EditPanel();

	public GameFrame() {
		super("타이핑 게임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,600);
		setResizable(false);
		splitPane();
		setVisible(true);
	}
	private void splitPane() {
		JSplitPane hPane = new JSplitPane();
		getContentPane().add(hPane, BorderLayout.CENTER);
		
		hPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);		
		hPane.setDividerLocation(500);
		hPane.setEnabled(false); // split bar를 움직일 수 없도록 하기 위해
		hPane.setLeftComponent(gamePanel);
		
		JSplitPane pPane = new JSplitPane();
		hPane.setRightComponent(pPane);
		pPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		pPane.setDividerLocation(70);
		pPane.setTopComponent(scorePanel);
		pPane.setBottomComponent(editPanel);
		pPane.setEnabled(false);
	}
}
