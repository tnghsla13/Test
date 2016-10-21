package com.co.prattler.main;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.co.prattler.display.EntrancePanel;
import com.co.prattler.display.InsertPanel;
import com.co.prattler.display.PrintPanel;
import com.co.prattler.display.SearchPanel;
import com.co.prattler.manage.ManageStudent;

public class StudentLauncher extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ManageStudent ms;
	private CardLayout cardLayout;
	private JPanel entrancePanel, insertPanel, searchPanel, printPanel;
	private JMenuBar menuBar;
	private JMenu editMenu, fileMenu, helpMenu, searchMenu, printMenu;
	private JMenuItem insertItem, deleteItem, modifyItem, exitItem, helpItem, nameSearchItem, idSearchItem,
			rankSortItem, nameSortItem, openItem, saveItem;

	private JFileChooser chooser;
	private FileNameExtensionFilter filter;

	public StudentLauncher() {

		chooser = new JFileChooser("./");
		filter = new FileNameExtensionFilter("dat", "dat");
		chooser.setFileFilter(filter);

		ms = new ManageStudent();
		setMenuBar();
		this.setJMenuBar(menuBar);
		cardLayout = new CardLayout();
		this.setLayout(cardLayout);
		entrancePanel = new EntrancePanel();
		insertPanel = new InsertPanel(ms);
		searchPanel = new SearchPanel(ms);
		printPanel = new PrintPanel(ms);

		this.add(entrancePanel, entrancePanel.toString());
		this.add(insertPanel, insertPanel.toString());
		this.add(printPanel, printPanel.toString());
		this.add(searchPanel, searchPanel.toString());

		this.changeCard(entrancePanel);
		this.setTitle("Student Management Program"); // title ¼³Á¤
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);

		this.setVisible(true);

	}

	public void changeCard(JPanel p) {
		this.setSize(p.getWidth(), p.getHeight());
		cardLayout.show(this.getContentPane(), p.toString());
	}

	private void setMenuBar() {

		menuBar = new JMenuBar();
		editMenu = new JMenu("Edit");
		fileMenu = new JMenu("File");
		helpMenu = new JMenu("Help");
		searchMenu = new JMenu("Search");
		printMenu = new JMenu("Print");

		nameSearchItem = new JMenuItem("Search with name");
		nameSearchItem.addActionListener(this);

		idSearchItem = new JMenuItem("Search with id");
		idSearchItem.addActionListener(this);

		rankSortItem = new JMenuItem("Print sorted by rank");
		rankSortItem.addActionListener(this);

		nameSortItem = new JMenuItem("Print sorted by name");
		nameSortItem.addActionListener(this);

		insertItem = new JMenuItem("Insert");
		insertItem.addActionListener(this);

		deleteItem = new JMenuItem("Delete");
		deleteItem.addActionListener(this);

		modifyItem = new JMenuItem("Modify");
		modifyItem.addActionListener(this);

		exitItem = new JMenuItem("Exit");
		exitItem.addActionListener(this);

		helpItem = new JMenuItem("Info");
		helpItem.addActionListener(this);

		saveItem = new JMenuItem("Save");
		saveItem.addActionListener(this);

		openItem = new JMenuItem("Open");
		openItem.addActionListener(this);

		searchMenu.add(idSearchItem);
		searchMenu.addSeparator();
		searchMenu.add(nameSearchItem);

		printMenu.add(rankSortItem);
		printMenu.addSeparator();
		printMenu.add(nameSortItem);

		editMenu.add(insertItem);
		editMenu.add(searchMenu);
		editMenu.add(deleteItem);
		editMenu.add(modifyItem);
		editMenu.add(printMenu);

		fileMenu.add(openItem);
		fileMenu.add(saveItem);
		fileMenu.add(exitItem);

		helpMenu.add(helpItem);

		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(helpMenu);

	}

	public static void main(String[] args) {

		new StudentLauncher();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(insertItem)) {

			changeCard(insertPanel);

		} else if (e.getSource().equals(deleteItem)) {

			((SearchPanel) searchPanel).clear();
			changeCard(searchPanel);
			((SearchPanel) searchPanel).setFlag(ManageStudent.DELETE);

		} else if (e.getSource().equals(modifyItem)) {

			System.out.println("modify");

		} else if (e.getSource().equals(idSearchItem)) {

			((SearchPanel) searchPanel).clear();
			changeCard(searchPanel);
			((SearchPanel) searchPanel).setFlag(ManageStudent.SEARCH_WITH_ID);

		} else if (e.getSource().equals(nameSearchItem)) {

			((SearchPanel) searchPanel).clear();
			changeCard(searchPanel);
			((SearchPanel) searchPanel).setFlag(ManageStudent.SEARCH_WITH_NAME);

		} else if (e.getSource().equals(rankSortItem)) {

			changeCard(printPanel);
			((PrintPanel) printPanel).setFlag(ManageStudent.SORT_BY_RANK);

		} else if (e.getSource().equals(nameSortItem)) {

			changeCard(printPanel);
			((PrintPanel) printPanel).setFlag(ManageStudent.SORT_BY_NAME);

		} else if (e.getSource().equals(exitItem)) {

			System.exit(0);

		} else if (e.getSource().equals(helpItem)) {

			JOptionPane.showMessageDialog(this.getContentPane(), "Made by developer Suho");

		} else if (e.getSource().equals(saveItem)) {

			String fileName = null;
			int returnVal = chooser.showSaveDialog(this);

			if (returnVal == JFileChooser.APPROVE_OPTION)

				fileName = chooser.getSelectedFile().getName().trim();

			ms.save(fileName);

		} else if (e.getSource().equals(openItem)) {

			String fileName = null;
			int returnVal = chooser.showOpenDialog(this);

			if (returnVal == JFileChooser.APPROVE_OPTION) {
				fileName = chooser.getSelectedFile().getName().trim();
				System.out.println(fileName);
			}

			ms.open(fileName);

		}
	}
}
