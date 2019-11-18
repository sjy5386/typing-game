import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class EditPanel extends JPanel {
	private JTextField addWord = new JTextField(25);
	private JButton addButton = new JButton("추가");
	private JButton saveButton = new JButton("저장");
	public EditPanel() {
		setBackground(new Color(195, 250, 255));
		setLayout(new FlowLayout());
		add(addWord);
		addWord.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String word = addWord.getText(); //추가와 같은 기능
				addWord.setText("");
			}
		});
		add(addButton);
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String word = addWord.getText(); //단어를 단어장에 추가 저장X
				addWord.setText("");
			}
		});
		add(saveButton);
		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String word = addWord.getText(); //추가된 단어들을 단어장에 저장
				addWord.setText("");
			}
		});
	}
}
