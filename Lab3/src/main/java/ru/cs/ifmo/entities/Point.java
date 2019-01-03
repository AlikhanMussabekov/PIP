package ru.cs.ifmo.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Date;

@Entity
@Table(name = "point")
public class Point implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name="x")
	private double x;

	@Column(name="y")
	private double y;

	@Column(name="r")
	private double r;

	@Column(name="Date")
	private Date date;

	@Column(name="result")
	private String result;

	@Column(name="sessionID")
	private String sessionID;

	public Point(){}

	public String getSessionID() {
		return sessionID;
	}

	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}

	public double getX() {
		DecimalFormat df = new DecimalFormat("#.##");
		return Double.valueOf(df.format(x));
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		DecimalFormat df = new DecimalFormat("#.##");
		return Double.valueOf(df.format(y));
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getR() {
		return r;
	}

	public void setR(double r) {
		this.r = r;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
