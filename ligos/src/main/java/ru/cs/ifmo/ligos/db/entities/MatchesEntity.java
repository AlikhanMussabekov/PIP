package ru.cs.ifmo.ligos.db.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "matches", schema = "public", catalog = "ligos")
public class MatchesEntity {
	private Integer id;
	private Integer tournamentid;
	private Integer teamFirst;
	private Integer teamSecond;
	private Integer stageid;
	private Integer courtid;
	private Object date;
	private Integer goalsFirst;
	private Integer goalsSecond;
	private Integer stage;
	private Collection<GoalsListEntity> goalsListsById;
	private TournamentEntity tournamentByTournamentid;
	private TeamEntity teamByTeamFirst;
	private TeamEntity teamByTeamSecond;
	private StagesEntity stagesByStageid;
	private CourtEntity courtByCourtid;

	@Id
	@Column(name = "id", nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Basic
	@Column(name = "tournamentid", nullable = true)
	public Integer getTournamentid() {
		return tournamentid;
	}

	public void setTournamentid(Integer tournamentid) {
		this.tournamentid = tournamentid;
	}

	@Basic
	@Column(name = "team_first", nullable = false)
	public Integer getTeamFirst() {
		return teamFirst;
	}

	public void setTeamFirst(Integer teamFirst) {
		this.teamFirst = teamFirst;
	}

	@Basic
	@Column(name = "team_second", nullable = false)
	public Integer getTeamSecond() {
		return teamSecond;
	}

	public void setTeamSecond(Integer teamSecond) {
		this.teamSecond = teamSecond;
	}

	@Basic
	@Column(name = "stageid", nullable = false)
	public Integer getStageid() {
		return stageid;
	}

	public void setStageid(Integer stageid) {
		this.stageid = stageid;
	}

	@Basic
	@Column(name = "courtid", nullable = false)
	public Integer getCourtid() {
		return courtid;
	}

	public void setCourtid(Integer courtid) {
		this.courtid = courtid;
	}

	@Basic
	@Column(name = "DATE", nullable = false)
	public Object getDate() {
		return date;
	}

	public void setDate(Object date) {
		this.date = date;
	}

	@Basic
	@Column(name = "goals_first", nullable = false)
	public Integer getGoalsFirst() {
		return goalsFirst;
	}

	public void setGoalsFirst(Integer goalsFirst) {
		this.goalsFirst = goalsFirst;
	}

	@Basic
	@Column(name = "goals_second", nullable = false)
	public Integer getGoalsSecond() {
		return goalsSecond;
	}

	public void setGoalsSecond(Integer goalsSecond) {
		this.goalsSecond = goalsSecond;
	}

	@Basic
	@Column(name = "stage", nullable = false)
	public Integer getStage() {
		return stage;
	}

	public void setStage(Integer stage) {
		this.stage = stage;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		MatchesEntity that = (MatchesEntity) o;
		return Objects.equals(id, that.id) &&
				Objects.equals(tournamentid, that.tournamentid) &&
				Objects.equals(teamFirst, that.teamFirst) &&
				Objects.equals(teamSecond, that.teamSecond) &&
				Objects.equals(stageid, that.stageid) &&
				Objects.equals(courtid, that.courtid) &&
				Objects.equals(date, that.date) &&
				Objects.equals(goalsFirst, that.goalsFirst) &&
				Objects.equals(goalsSecond, that.goalsSecond) &&
				Objects.equals(stage, that.stage);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, tournamentid, teamFirst, teamSecond, stageid, courtid, date, goalsFirst, goalsSecond, stage);
	}

	@OneToMany(mappedBy = "matchesByMatcheid")
	public Collection<GoalsListEntity> getGoalsListsById() {
		return goalsListsById;
	}

	public void setGoalsListsById(Collection<GoalsListEntity> goalsListsById) {
		this.goalsListsById = goalsListsById;
	}

	@ManyToOne
	@JoinColumn(name = "tournamentid", referencedColumnName = "id")
	public TournamentEntity getTournamentByTournamentid() {
		return tournamentByTournamentid;
	}

	public void setTournamentByTournamentid(TournamentEntity tournamentByTournamentid) {
		this.tournamentByTournamentid = tournamentByTournamentid;
	}

	@ManyToOne
	@JoinColumn(name = "team_first", referencedColumnName = "id", nullable = false)
	public TeamEntity getTeamByTeamFirst() {
		return teamByTeamFirst;
	}

	public void setTeamByTeamFirst(TeamEntity teamByTeamFirst) {
		this.teamByTeamFirst = teamByTeamFirst;
	}

	@ManyToOne
	@JoinColumn(name = "team_second", referencedColumnName = "id", nullable = false)
	public TeamEntity getTeamByTeamSecond() {
		return teamByTeamSecond;
	}

	public void setTeamByTeamSecond(TeamEntity teamByTeamSecond) {
		this.teamByTeamSecond = teamByTeamSecond;
	}

	@ManyToOne
	@JoinColumn(name = "stageid", referencedColumnName = "id", nullable = false)
	public StagesEntity getStagesByStageid() {
		return stagesByStageid;
	}

	public void setStagesByStageid(StagesEntity stagesByStageid) {
		this.stagesByStageid = stagesByStageid;
	}

	@ManyToOne
	@JoinColumn(name = "courtid", referencedColumnName = "id", nullable = false)
	public CourtEntity getCourtByCourtid() {
		return courtByCourtid;
	}

	public void setCourtByCourtid(CourtEntity courtByCourtid) {
		this.courtByCourtid = courtByCourtid;
	}
}
