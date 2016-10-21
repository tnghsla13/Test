package com.co.prattler.display;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.co.prattler.manage.ManageStudent;
import com.co.prattler.structure.Student;

public class InsertPanel extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ManageStudent ms;
	private int width, height;
	private JLabel nameLabel, idLabel, korLabel, engLabel, matLabel;
	private JTextField nameField, idField, korField, engField, matField;
	private JPanel namePanel, idPanel, korPanel, engPanel, matPanel;
	private JButton confirmBtn;

	public InsertPanel() {

	}

	public InsertPanel(ManageStudent ms) {
		this.ms = ms;

		width = 300;
		height = 300;
		this.setLayout(new GridLayout(6, 1));

		confirmBtn = new JButton("Confirm");

		nameLabel = new JLabel("Name  ");
		idLabel = new JLabel("ID  ");
		korLabel = new JLabel("Kor  ");
		engLabel = new JLabel("Eng  ");
		matLabel = new JLabel("Mat  ");

		nameField = new JTextField(8);
		idField = new JTextField(8);
		korField = new JTextField(8);
		engField = new JTextField(8);
		matField = new JTextField(8);

		namePanel = new JPanel();
		namePanel.add(nameLabel);
		namePanel.add(nameField);
		this.add(namePanel);

		idPanel = new JPanel();
		idPanel.add(idLabel);
		idPanel.add(idField);
		this.add(idPanel);

		korPanel = new JPanel();
		korPanel.add(korLabel);
		korPanel.add(korField);
		this.add(korPanel);

		engPanel = new JPanel();
		engPanel.add(engLabel);
		engPanel.add(engField);
		this.add(engPanel);

		matPanel = new JPanel();
		matPanel.add(matLabel);
		matPanel.add(matField);
		this.add(matPanel);

		confirmBtn.addActionListener(this);

		this.add(confirmBtn);

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
		return "InsertPanel";
	}

	public void clear() {

		nameField.setText("");
		idField.setText("");
		korField.setText("");
		engField.setText("");
		matField.setText("");

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(confirmBtn)) {

			Student tmpSt = new Student(nameField.getText(), idField.getText(), Double.parseDouble(korField.getText()),
					Double.parseDouble(engField.getText()), Double.parseDouble(matField.getText()));

			ms.insert(tmpSt);

			clear();
		}

	}
}
