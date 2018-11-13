package ru.cs.ifmo.ligos.db.entities;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "team", schema = "public", catalog = "ligos")
public class TeamEntity {
	private Integer id;
	private Integer trainerid;
	private Integer captainid;
	private String name;
	private byte[] photo;
	private Collection<MatchesEntity> matchesById;
	private Collection<MatchesEntity> matchesById_0;
	private TrainerEntity trainerByTrainerid;
	private UserEntity userByCaptainid;
	private TeamUserEntity teamUserById;
	private Collection<TournamentTeamsEntity> tournamentTeamsById;

	@Id
	@Column(name = "id", nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Basic
	@Column(name = "trainerid", nullable = true)
	public Integer getTrainerid() {
		return trainerid;
	}

	public void setTrainerid(Integer trainerid) {
		this.trainerid = trainerid;
	}

	@Basic
	@Column(name = "captainid", nullable = false)
	public Integer getCaptainid() {
		return captainid;
	}

	public void setCaptainid(Integer captainid) {
		this.captainid = captainid;
	}

	@Basic
	@Column(name = "name", nullable = false, length = 255)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Basic
	@Column(name = "photo", nullable = true)
	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		TeamEntity that = (TeamEntity) o;
		return Objects.equals(id, that.id) &&
				Objects.equals(trainerid, that.trainerid) &&
				Objects.equals(captainid, that.captainid) &&
				Objects.equals(name, that.name) &&
				Arrays.equals(photo, that.photo);
	}

	@Override
	public int hashCode() {
		int result = Objects.hash(id, trainerid, captainid, name);
		result = 31 * result + Arrays.hashCode(photo);
		return result;
	}

	@OneToMany(mappedBy = "teamByTeamFirst")
	public Collection<MatchesEntity> getMatchesById() {
		return matchesById;
	}

	public void setMatchesById(Collection<MatchesEntity> matchesById) {
		this.matchesById = matchesById;
	}

	@OneToMany(mappedBy = "teamByTeamSecond")
	public Collection<MatchesEntity> getMatchesById_0() {
		return matchesById_0;
	}

	public void setMatchesById_0(Collection<MatchesEntity> matchesById_0) {
		this.matchesById_0 = matchesById_0;
	}

	@ManyToOne
	@JoinColumn(name = "trainerid", referencedColumnName = "userid")
	public TrainerEntity getTrainerByTrainerid() {
		return trainerByTrainerid;
	}

	public void setTrainerByTrainerid(TrainerEntity trainerByTrainerid) {
		this.trainerByTrainerid = trainerByTrainerid;
	}

	@ManyToOne
	@JoinColumn(name = "captainid", referencedColumnName = "id", nullable = false)
	public UserEntity getUserByCaptainid() {
		return userByCaptainid;
	}

	public void setUserByCaptainid(UserEntity userByCaptainid) {
		this.userByCaptainid = userByCaptainid;
	}

	@OneToOne(mappedBy = "teamByTeamid")
	public TeamUserEntity getTeamUserById() {
		return teamUserById;
	}

	public void setTeamUserById(TeamUserEntity teamUserById) {
		this.teamUserById = teamUserById;
	}

	@OneToMany(mappedBy = "teamByTeamid")
	public Collection<TournamentTeamsEntity> getTournamentTeamsById() {
		return tournamentTeamsById;
	}

	public void setTournamentTeamsById(Collection<TournamentTeamsEntity> tournamentTeamsById) {
		this.tournamentTeamsById = tournamentTeamsById;
	}
}
