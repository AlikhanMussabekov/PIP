package ru.cs.ifmo.utils;

import ru.cs.ifmo.model.Point;
import ru.cs.ifmo.model.User;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import java.util.List;

@Stateless
public class PointService {

	private EntityManagerFactory fact = Persistence.createEntityManagerFactory("JPAUNIT");
	private EntityManager em = fact.createEntityManager();

	public void addPoint(Point point){

		em.getTransaction().begin();
		em.persist(point);
		em.getTransaction().commit();
	}


	public List<Point> getAllShots(User user){

		return  em.createQuery("select p from Point p where p.user = :user").setParameter("user", user).getResultList();
		//return em.createQuery("select * from Point where user = :user")
	}

	public void delete(Integer id) {
		em.getTransaction().begin();
		em.createQuery("delete Point p where p.id = :id").setParameter("id", id).executeUpdate();
		em.getTransaction().commit();
	}
}
