package ru.cs.ifmo.model;

import ru.cs.ifmo.entities.*;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Model {

	{
		model = new ArrayList<Point>();
	}

	private List<Point> model;

	public Model() {}

	public void add(Point point){
		model.add(point);
	}

	public List<Point> getPoints(){
		return model;
	}

	public void setPoints(List<Point> model){
		this.model = model;
	}
}
