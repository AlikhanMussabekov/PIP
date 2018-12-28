package ru.cs.ifmo.utils;

import ru.cs.ifmo.model.Point;
import ru.cs.ifmo.model.User;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import java.util.List;

@Stateful
public class PointService {

	private EntityManagerFactory fact = Persistence.createEntityManagerFactory("JPAUNIT");
	private EntityManager em = fact.createEntityManager();

	public void addPoint(Point point){

		em.getTransaction().begin();
		em.persist(point);
		em.getTransaction().commit();
	}


	public List<Point> getAllShots(@Context HttpServletRequest req){

		User user = (User)req.getSession().getAttribute("user");

		return  em.createQuery("from Point where user = user").getResultList();
	}

}
