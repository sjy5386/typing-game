import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
	private GamePanel gamePanel = new GamePanel();

	public GameFrame() {
		super("타이핑 게임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,600);
		setResizable(false);
		setJMenuBar(makeMenu());
		add(makeToolBar(), BorderLayout.NORTH);
		add(gamePanel);
		setVisible(true);
		gamePanel.inputText.requestFocus();
	}

	private JMenuBar makeMenu() {
		JMenuBar menuBar = new JMenuBar();

		JMenu gameMenu = new JMenu("게임");
		gameMenu.add(new JMenuItem("새 클래식 게임"));
		gameMenu.add(new JMenuItem("새 브레인 게임"));
		gameMenu.addSeparator();
		gameMenu.add(new JMenuItem("리더보드"));
		gameMenu.addSeparator();
		gameMenu.add(new JMenuItem("끝내기"));

		JMenu wordMenu = new JMenu("단어");
		wordMenu.add(new JMenuItem("단어 목록"));
		wordMenu.addSeparator();
		wordMenu.add(new JMenuItem("단어 파일 열기"));
		wordMenu.add(new JMenuItem("단어 파일 저장"));

		JMenu multiplayerMenu = new JMenu("멀티플레이 ");
		multiplayerMenu.add(new JMenuItem("게임 생성"));
		multiplayerMenu.add(new JMenuItem("게임 참가"));
		multiplayerMenu.addSeparator();
		multiplayerMenu.add(new JMenuItem("게임 나가기"));

		menuBar.add(gameMenu);
		menuBar.add(wordMenu);
		menuBar.add(multiplayerMenu);
		return menuBar;
	}

	private JToolBar makeToolBar() {
		JToolBar toolBar = new JToolBar();
		toolBar.add(new JLabel("싱글플레이 "));
		toolBar.add(new JButton("새 클래식 게임"));
		toolBar.add(new JButton("새 브레인 게임"));
		toolBar.addSeparator();
		toolBar.add(new JButton("리더보드"));
		toolBar.addSeparator();
		toolBar.add(new JLabel("멀티플레이 "));
		toolBar.add(new JButton("게임 생성"));
		toolBar.add(new JButton("게임 참가"));
		toolBar.setFloatable(false);
		return toolBar;
	}
}
