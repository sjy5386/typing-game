package view;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
	private JMenuBar menuBar = makeMenu();
	private JToolBar toolBar = makeToolBar();
	private GamePanel gamePanel = new GamePanel();
	private WordDialog wordDialog = new WordDialog(this);

	public GameFrame() {
		super("타이핑 게임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,600);
		setResizable(false);
		setJMenuBar(menuBar);
		Container c = getContentPane();
		c.add(toolBar, BorderLayout.NORTH);
		c.add(gamePanel, BorderLayout.CENTER);
		setVisible(true);
		gamePanel.initFocus();
	}

	private JMenuBar makeMenu() {
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(MyColor.DARK);

		JMenu gameMenu = new JMenu("게임");
		JMenuItem newGameClassic = new JMenuItem("새 클래식 게임");
		JMenuItem newGameBrain = new JMenuItem("새 브레인 게임");
		JMenuItem leaderBoard = new JMenuItem("리더보드");
		JMenuItem exit = new JMenuItem("끝내기");
		exit.addActionListener(e -> {
			if (JOptionPane.showConfirmDialog(this, "정말로 종료할까요?", getTitle(), 0) == 0)
				System.exit(0);
		});

		gameMenu.add(newGameClassic);
		gameMenu.add(newGameBrain);
		gameMenu.addSeparator();
		gameMenu.add(leaderBoard);
		gameMenu.addSeparator();
		gameMenu.add(exit);

		JMenu wordMenu = new JMenu("단어");
		JMenuItem wordList = new JMenuItem("단어 목록");
		wordList.addActionListener(e -> {
			if (wordDialog.isVisible())
				wordDialog.requestFocus();
			else
				wordDialog.setVisible(true);
		});

		wordMenu.add(wordList);

		JMenu multiplayerMenu = new JMenu("멀티플레이 ");
		JMenuItem createGame = new JMenuItem("게임 생성");
		JMenuItem joinGame = new JMenuItem("게임 참가");
		JMenuItem exitGame = new JMenuItem("게임 나가기");

		multiplayerMenu.add(createGame);
		multiplayerMenu.add(joinGame);
		multiplayerMenu.addSeparator();
		multiplayerMenu.add(exitGame);

		menuBar.add(gameMenu);
		menuBar.add(wordMenu);
		menuBar.add(multiplayerMenu);
		return menuBar;
	}

	private JToolBar makeToolBar() {
		JToolBar toolBar = new JToolBar();
		toolBar.setBackground(MyColor.BASE);

		JButton newGameClassic = new JButton("새 클래식 게임");
		JButton newGameBrain = new JButton("새 브레인 게임");
		JButton leaderBoard = new JButton("리더보드");
		JButton createGame = new JButton("게임 생성");
		JButton joinGame = new JButton("게임 참가");

		toolBar.add(new JLabel("싱글플레이 "));
		toolBar.add(newGameClassic);
		toolBar.add(newGameBrain);
		toolBar.addSeparator();
		toolBar.add(leaderBoard);
		toolBar.addSeparator();
		toolBar.add(new JLabel("멀티플레이 "));
		toolBar.add(createGame);
		toolBar.add(joinGame);
		toolBar.setFloatable(false);
		return toolBar;
	}
}
