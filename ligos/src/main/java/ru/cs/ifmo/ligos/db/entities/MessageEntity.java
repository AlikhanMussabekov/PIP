package ru.cs.ifmo.ligos.db.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "message", schema = "public", catalog = "ligos")
public class MessageEntity {
	private Integer id;
	private Integer chatid;
	private String context;
	private Timestamp time;
	private Boolean type;
	private ChatEntity chatByChatid;

	@Id
	@Column(name = "id", nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Basic
	@Column(name = "chatid", nullable = false)
	public Integer getChatid() {
		return chatid;
	}

	public void setChatid(Integer chatid) {
		this.chatid = chatid;
	}

	@Basic
	@Column(name = "context", nullable = false, length = -1)
	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	@Basic
	@Column(name = "time", nullable = false)
	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	@Basic
	@Column(name = "type", nullable = false)
	public Boolean getType() {
		return type;
	}

	public void setType(Boolean type) {
		this.type = type;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		MessageEntity that = (MessageEntity) o;
		return Objects.equals(id, that.id) &&
				Objects.equals(chatid, that.chatid) &&
				Objects.equals(context, that.context) &&
				Objects.equals(time, that.time) &&
				Objects.equals(type, that.type);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, chatid, context, time, type);
	}

	@ManyToOne
	@JoinColumn(name = "chatid", referencedColumnName = "id", nullable = false)
	public ChatEntity getChatByChatid() {
		return chatByChatid;
	}

	public void setChatByChatid(ChatEntity chatByChatid) {
		this.chatByChatid = chatByChatid;
	}
}
