package ru.cs.ifmo.ligos.db.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "team_user", schema = "public", catalog = "ligos")
public class TeamUserEntity {
	private Integer teamid;
	private Integer userid;
	private TeamEntity teamByTeamid;
	private UserEntity userByUserid;

	@Id
	@Column(name = "teamid", nullable = false)
	public Integer getTeamid() {
		return teamid;
	}

	public void setTeamid(Integer teamid) {
		this.teamid = teamid;
	}

	@Basic
	@Column(name = "userid", nullable = false)
	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		TeamUserEntity that = (TeamUserEntity) o;
		return Objects.equals(teamid, that.teamid) &&
				Objects.equals(userid, that.userid);
	}

	@Override
	public int hashCode() {
		return Objects.hash(teamid, userid);
	}

	@OneToOne
	@JoinColumn(name = "teamid", referencedColumnName = "id", nullable = false)
	public TeamEntity getTeamByTeamid() {
		return teamByTeamid;
	}

	public void setTeamByTeamid(TeamEntity teamByTeamid) {
		this.teamByTeamid = teamByTeamid;
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
