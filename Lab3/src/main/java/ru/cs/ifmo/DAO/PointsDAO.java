package ru.cs.ifmo.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.cs.ifmo.entities.Point;
import ru.cs.ifmo.utils.HibernateSessionFactoryUtil;

import java.util.List;

public class PointsDAO {


	public Point findById(int id) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
		Point point = session.get(Point.class, id);
		session.close();
		return point;
	}

	public void save(Point point) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
		Transaction tx1 = session.beginTransaction();
		session.save(point);
		tx1.commit();
		session.close();
	}

	public List<Point> findAll(String sessionID) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();

		String query = "from ru.cs.ifmo.entities.Point p where p.sessionID = " + "'" +  sessionID + "'";

		List<Point> points = (List<Point>) session.createQuery(query).list();

		session.close();
		return points;
	}

}
