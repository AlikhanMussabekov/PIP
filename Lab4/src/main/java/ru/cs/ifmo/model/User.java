package ru.cs.ifmo.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "point_users"/*, schema = "s247413"*/)
public class User implements Serializable {
	@Id
	@SequenceGenerator(name = "point_users_id_seq" , sequenceName = "point_users_id_seq",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "point_users_id_seq")
	@Column(name = "id")
	private Long userId;

	@Column(name = "login", unique = true)
	private String login;

	@Column(name = "password")
	private String password;

	protected User(){};

	public User(String login, String pass){
		this.login = login;
		//this.password = new PasswordEncryptor().encrypt(pass);
		this.password = String.valueOf(pass.hashCode());
	}
	public String getLogin(){
		return login;
	}
	public String getPassword(){
		return password;
	}

	public Long getId() {
		return userId;
	}

	public void setId(Long userId) {
		this.userId = userId;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}