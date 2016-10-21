package com.co.prattler.display;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.co.prattler.manage.ManageStudent;

public class SearchPanel extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int flag;
	private ManageStudent ms;
	private int width, height;
	private JTextField clueField;
	private JLabel clueLabel;
	private JButton searchBtn;
	private JTextArea resultArea;
	private JPanel cluePanel;

	public SearchPanel(ManageStudent ms) {

		width = 500;
		height = 600;

		this.ms = ms;
		this.setLayout(new BorderLayout());
		cluePanel = new JPanel();
		clueField = new JTextField(8);
		clueLabel = new JLabel("Clue");
		searchBtn = new JButton("Search");

		searchBtn.addActionListener(this);

		cluePanel.add(clueLabel);
		cluePanel.add(clueField);
		cluePanel.add(searchBtn);

		resultArea = new JTextArea();

		this.add(cluePanel, "North");
		this.add(resultArea);

	}

	@Override
	public int getWidth() {
		return this.width;
	}

	@Override
	public int getHeight() {
		return this.height;
	}

	@Override
	public String toString() {
		return "SearchPanel";
	}

	public void setFlag(int flag) {

		this.flag = flag;

		if (flag == ManageStudent.SEARCH_WITH_ID || flag == ManageStudent.DELETE)
			clueLabel.setText("Clue (ID) ");
		else if (flag == ManageStudent.SEARCH_WITH_NAME)
			clueLabel.setText("Clue (Name) ");

	}

	public void clear() {

		clueField.setText("");
		resultArea.setText("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(searchBtn)) {

			resultArea.setText("");
			ArrayList<Object> tmp = null;
			if ((tmp = ms.search(flag, clueField.getText())) != null) {

				for (Object s : tmp) {

					resultArea.append(s.toString() + "\n");
				}

			} else {

				resultArea.setText("None...");
			}

			clueField.setText("");

		}

	}
}
