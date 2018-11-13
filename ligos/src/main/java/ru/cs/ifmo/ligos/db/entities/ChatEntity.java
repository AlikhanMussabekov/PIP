package ru.cs.ifmo.ligos.db.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "chat", schema = "public", catalog = "ligos")
public class ChatEntity {
	private Integer id;
	private Integer userid;
	private Integer userid2;
	private UserEntity userByUserid;
	private UserEntity userByUserid2;
	private Collection<MessageEntity> messagesById;

	@Id
	@Column(name = "id", nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Basic
	@Column(name = "userid", nullable = false)
	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	@Basic
	@Column(name = "userid2", nullable = false)
	public Integer getUserid2() {
		return userid2;
	}

	public void setUserid2(Integer userid2) {
		this.userid2 = userid2;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ChatEntity that = (ChatEntity) o;
		return Objects.equals(id, that.id) &&
				Objects.equals(userid, that.userid) &&
				Objects.equals(userid2, that.userid2);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, userid, userid2);
	}

	@ManyToOne
	@JoinColumn(name = "userid", referencedColumnName = "id", nullable = false)
	public UserEntity getUserByUserid() {
		return userByUserid;
	}

	public void setUserByUserid(UserEntity userByUserid) {
		this.userByUserid = userByUserid;
	}

	@ManyToOne
	@JoinColumn(name = "userid2", referencedColumnName = "id", nullable = false)
	public UserEntity getUserByUserid2() {
		return userByUserid2;
	}

	public void setUserByUserid2(UserEntity userByUserid2) {
		this.userByUserid2 = userByUserid2;
	}

	@OneToMany(mappedBy = "chatByChatid")
	public Collection<MessageEntity> getMessagesById() {
		return messagesById;
	}

	public void setMessagesById(Collection<MessageEntity> messagesById) {
		this.messagesById = messagesById;
	}
}
