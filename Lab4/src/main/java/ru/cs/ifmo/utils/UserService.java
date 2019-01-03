package ru.cs.ifmo.utils;

import ru.cs.ifmo.model.User;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.*;
import javax.transaction.Transactional;

@Stateless
public class UserService {

	@EJB
	private PasswordEncryptor encryptor;

	private EntityManagerFactory fact = Persistence.createEntityManagerFactory("JPAUNIT");
	private EntityManager em = fact.createEntityManager();

	@Transactional
    public boolean saveUsr(User user){

    	em.getTransaction().begin();
    	try {
			em.persist(user);
			em.getTransaction().commit();
			return true;
		}catch (Exception e){
			System.out.println("User exists");
			return false;
		}
    }

    public User assertUser(String login, String password) throws NoResultException {
			try {
				User user = (User) em.createQuery(" from User where login = :login").setParameter("login", login).getSingleResult();
				if (!(user == null)) {
					if (encryptor.encrypt(password).equals(user.getPassword())) {
						return user;
					}
				}
				return null;
			}catch (NoResultException e){
				return null;
			}
	}

}
