package com.co.prattler.display;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class EntrancePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel westPanel, eastPanel, northPanel, southPanel;
	private int width, height;
	private JTextArea welcomeArea;

	public EntrancePanel() {
		
		width = 500;
		height = 600;
		
		westPanel = new JPanel();
		westPanel.setPreferredSize(new Dimension(width / 6, height / 2));
		westPanel.setBackground(Color.white);
		
		eastPanel = new JPanel();
		eastPanel.setPreferredSize(new Dimension(width / 6, height / 2));
		eastPanel.setBackground(Color.white);
		
		northPanel=new JPanel();
		northPanel.setPreferredSize(new Dimension(width, height / 6));
		northPanel.setBackground(Color.white);
		
		southPanel=new JPanel();
		southPanel.setPreferredSize(new Dimension(width, height / 6));
		southPanel.setBackground(Color.white);
		
		setLayout(new BorderLayout());
		
		this.add(westPanel, BorderLayout.WEST);
		this.add(eastPanel, BorderLayout.EAST);
		this.add(northPanel, BorderLayout.NORTH);
		this.add(southPanel, BorderLayout.SOUTH);
		northPanel = new JPanel();
		southPanel = new JPanel();

		welcomeArea = new JTextArea();
		welcomeArea.setEditable(false);
		
		
		welcomeArea.append("  Hello everyone! this is main page for you\n\n");
		welcomeArea.append("1. You can use File menu to open your file.\n");
		welcomeArea.append("2. You can use Edit menu to modify student information.\n");
		welcomeArea.append("3. You can use Help menu to know who made this program.\n\n");
		welcomeArea.append("  Appreciate for reading and Good Luck to you.");
		
		this.add(welcomeArea);

	}

	@Override
	public String toString() {
		return "EntrancePanel";
	}

	@Override
	public int getWidth() {

		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}
}
