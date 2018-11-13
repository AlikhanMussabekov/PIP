package ru.cs.ifmo.model;

import ru.cs.ifmo.entities.*;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Model {

	private static Model instance = new Model();

	private List<Point> model;

	public static Model getInstance() {
		return instance;
	}

	private Model() {
		model = new ArrayList<>();
	}

	public void add(Point point){
		model.add(point);
	}

	public List<Point> list(){
		return model;
	}
}
