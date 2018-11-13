package ru.cs.ifmo.ligos.db.entities;

import javax.persistence.*;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "goals_list", schema = "public", catalog = "ligos")
public class GoalsListEntity {
	private Integer id;
	private Integer matcheid;
	private Integer userid;
	private Time time;
	private MatchesEntity matchesByMatcheid;
	private UserEntity userByUserid;

	@Id
	@Column(name = "id", nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Basic
	@Column(name = "matcheid", nullable = false)
	public Integer getMatcheid() {
		return matcheid;
	}

	public void setMatcheid(Integer matcheid) {
		this.matcheid = matcheid;
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
	@Column(name = "time", nullable = false)
	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		GoalsListEntity that = (GoalsListEntity) o;
		return Objects.equals(id, that.id) &&
				Objects.equals(matcheid, that.matcheid) &&
				Objects.equals(userid, that.userid) &&
				Objects.equals(time, that.time);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, matcheid, userid, time);
	}

	@ManyToOne
	@JoinColumn(name = "matcheid", referencedColumnName = "id", nullable = false)
	public MatchesEntity getMatchesByMatcheid() {
		return matchesByMatcheid;
	}

	public void setMatchesByMatcheid(MatchesEntity matchesByMatcheid) {
		this.matchesByMatcheid = matchesByMatcheid;
	}

	@ManyToOne
	@JoinColumn(name = "userid", referencedColumnName = "id", nullable = false)
	public UserEntity getUserByUserid() {
		return userByUserid;
	}

	public void setUserByUserid(UserEntity userByUserid) {
		this.userByUserid = userByUserid;
	}
}
