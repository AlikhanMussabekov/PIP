package ru.cs.ifmo.services;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.*;

@ManagedBean(name = "checkBox")
@RequestScoped
public class CheckBoxService implements Serializable {


	private Map<Integer,Integer> values;

	private Integer[] valueLabels;

	{
		values = new LinkedHashMap<Integer, Integer>();
		values.put(-4,-4);
		values.put(-3,-3);
		values.put(-2,-2);
		values.put(-1,-1);
		values.put(0,0);
		values.put(1,1);
		values.put(2,2);
		values.put(3,3);
		values.put(4,4);

	}

	public Integer[] getValueLabels(){
		return valueLabels;
	}

	public Map<Integer,Integer> getValues() {

		return values;
	}

	public void setValues(Map<Integer, Integer> values) {
		this.values = values;
	}

	public void setValueLabels(Integer[] valueLabels) {
		valueLabels = valueLabels;
	}
}
