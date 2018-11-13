package ru.cs.ifmo.entities;

import java.io.Serializable;
import java.util.Date;

public class Point implements Serializable {

	private double x;
	private double y;
	private int r;
	private Date date;
	private long workTime;
	private String result;

	public Point(){}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public long getWorkTime() {
		return workTime;
	}

	public void setWorkTime(long workTime) {
		this.workTime = workTime;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
