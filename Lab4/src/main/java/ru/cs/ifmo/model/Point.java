package ru.cs.ifmo.model;

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

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public Point(){}

	public Point(double x, double y, double r, Date date, String result, User user) {
		this.x = x;
		this.y = y;
		this.r = r;
		this.date = date;
		this.result = result;
		this.user = user;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
