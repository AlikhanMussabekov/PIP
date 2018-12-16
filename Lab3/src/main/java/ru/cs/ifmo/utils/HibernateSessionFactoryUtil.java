package ru.cs.ifmo.utils;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.cs.ifmo.entities.Point;

public class HibernateSessionFactoryUtil {

	private static final Logger logger = LoggerFactory.getLogger(HibernateSessionFactoryUtil.class);

	private static SessionFactory sessionFactory;

	private HibernateSessionFactoryUtil() {}

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration().configure();
				configuration.addAnnotatedClass(Point.class);
				StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
				sessionFactory = configuration.buildSessionFactory(builder.build());

			} catch (Exception e) {
				//System.out.println("Исключение!" + e);
				logger.error("hibernate error", e);
			}
		}
		return sessionFactory;
	}
}