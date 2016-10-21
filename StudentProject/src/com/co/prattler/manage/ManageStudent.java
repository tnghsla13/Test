package com.co.prattler.manage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.co.prattler.structure.Student;

public class ManageStudent {

	public static final int SORT_BY_RANK = 1;
	public static final int SORT_BY_NAME = 2;

	public static final int SEARCH_WITH_ID = 3;
	public static final int SEARCH_WITH_NAME = 4;

	public static final int DELETE = 5;

	private Map<String, Student> stContainer;

	public ManageStudent() {

		stContainer = new HashMap<>();

	}

	@SuppressWarnings("unchecked")
	public void open(String fileName) {

		ObjectInputStream ois = null;

		try {
			ois = new ObjectInputStream(new FileInputStream(fileName));
			this.stContainer = (HashMap<String, Student>) ois.readObject();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {

			try {
				if (ois != null)
					ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	public void save(String fileName) {

		ObjectOutputStream oos = null;

		try {

			oos = new ObjectOutputStream(new FileOutputStream(fileName));
			oos.writeObject(stContainer);
			oos.flush();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			try {
				if (oos != null)
					oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	public void insert(Student tmpSt) {

		if (!stContainer.containsKey(tmpSt.getID()))
			stContainer.put(tmpSt.getID(), tmpSt);

	}

	public ArrayList<Object> search(int flag, String clue) {

		Student stTemp = null;
		ArrayList<Object> tmpArr = null;

		if (!stContainer.isEmpty()) {

			if (flag == SEARCH_WITH_ID) {

				if ((stTemp = stContainer.get(clue)) != null) {

					tmpArr = new ArrayList<>();
					tmpArr.add(stTemp);

				}

			} else if (flag == SEARCH_WITH_NAME) {

				tmpArr = new ArrayList<>();
				Iterator<Student> itr = stContainer.values().iterator();

				while (itr.hasNext()) {

					if ((stTemp = itr.next()).getName().equals(clue))
						tmpArr.add(stTemp);
				}

				if (tmpArr.isEmpty())
					tmpArr = null;

			} else if (flag == DELETE) {

				if (stContainer.remove(clue) != null) {
					tmpArr = new ArrayList<>();
					tmpArr.add("Delete is successful ~ !");
				}

			}

		}

		return tmpArr;

	}
	

	public ArrayList<Student> print(int flag) {
		
		ArrayList<Student> tmp = null;

		if (!stContainer.isEmpty()) {

			tmp = new ArrayList<>(stContainer.values());

			if (flag == SORT_BY_RANK) {

				Collections.sort(tmp, new Comparator<Student>() {

					@Override
					public int compare(Student o1, Student o2) {

						return ((Double) o2.getSum()).compareTo(o1.getSum());
					}

				});

			} else if (flag == SORT_BY_NAME) {

				Collections.sort(tmp, new Comparator<Student>() {

					@Override
					public int compare(Student o1, Student o2) {

						return o1.getName().compareTo(o2.getName());
					}

				});

			}
		}

		return tmp;
	}
}
