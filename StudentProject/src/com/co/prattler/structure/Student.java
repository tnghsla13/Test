package com.co.prattler.structure;

import java.io.Serializable;

public class Student implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5924612475277384803L;
	
	private String name;
	private String ID;
	private double kor;
	private double eng;
	private double mat;
	private double sum;

	public Student() {

	}

	public Student(String name, String iD, double kor, double eng, double mat) {
		this.name = name;
		this.ID = iD;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.sum = (kor + eng + mat) / 3.0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public double getKor() {
		return kor;
	}

	public void setKor(double kor) {
		this.kor = kor;
	}

	public double getEng() {
		return eng;
	}

	public void setEng(double eng) {
		this.eng = eng;
	}

	public double getMat() {
		return mat;
	}

	public void setMat(double mat) {
		this.mat = mat;
	}

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ID == null) ? 0 : ID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (ID == null) {
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
		return true;
	}

	@Override
	public String toString() {

		StringBuffer strBuf = new StringBuffer();
		strBuf.append("Name : " + this.name + "\n");
		strBuf.append("ID : " + this.ID + "\n");
		strBuf.append("Kor : " + this.kor + "\n");
		strBuf.append("Eng : " + this.eng + "\n");
		strBuf.append("Mat : " + this.mat + "\n");
		// strBuf.append("Rank : " + this.name+"\n");

		return strBuf.toString();
	}

}
