package com.co.prattler.display;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Map.Entry;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.co.prattler.manage.ManageStudent;
import com.co.prattler.structure.Student;

public class PrintPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int width, height;
	private JTextArea resultArea;
	private ManageStudent ms;

	public PrintPanel(ManageStudent ms) {
		this.ms = ms;

		width = 500;
		height = 600;

		setLayout(new BorderLayout());
		resultArea = new JTextArea();
		resultArea.setEditable(false);
		this.add(resultArea);
	}

	public void setFlag(int flag) {
		
		resultArea.setText("");

		ArrayList<Student> tmp = null;
		if ((tmp = ms.print(flag)) != null) {

			for (Student s : tmp) {

				resultArea.append(s.toString() + "\n");
			}
		} else {

			resultArea.setText("None..");
		}
	}

	@Override
	public String toString() {
		return "printPanel";
	}

	@Override
	public int getWidth() {
		return this.width;
	}

	@Override
	public int getHeight() {
		return this.height;
	}
}
