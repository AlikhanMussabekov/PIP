package ru.cs.ifmo.ligos.db.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tournament_teams", schema = "public", catalog = "ligos")
public class TournamentTeamsEntity {
	private Integer tournamentDetailsid;
	private Integer teamid;
	private TournamentDetailsEntity tournamentDetailsByTournamentDetailsid;
	private TeamEntity teamByTeamid;

	@Id
	@Column(name = "tournament_detailsid", nullable = false)
	public Integer getTournamentDetailsid() {
		return tournamentDetailsid;
	}

	public void setTournamentDetailsid(Integer tournamentDetailsid) {
		this.tournamentDetailsid = tournamentDetailsid;
	}

	@Basic
	@Column(name = "teamid", nullable = false)
	public Integer getTeamid() {
		return teamid;
	}

	public void setTeamid(Integer teamid) {
		this.teamid = teamid;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		TournamentTeamsEntity that = (TournamentTeamsEntity) o;
		return Objects.equals(tournamentDetailsid, that.tournamentDetailsid) &&
				Objects.equals(teamid, that.teamid);
	}

	@Override
	public int hashCode() {
		return Objects.hash(tournamentDetailsid, teamid);
	}

	@OneToOne
	@JoinColumn(name = "tournament_detailsid", referencedColumnName = "id", nullable = false)
	public TournamentDetailsEntity getTournamentDetailsByTournamentDetailsid() {
		return tournamentDetailsByTournamentDetailsid;
	}

	public void setTournamentDetailsByTournamentDetailsid(TournamentDetailsEntity tournamentDetailsByTournamentDetailsid) {
		this.tournamentDetailsByTournamentDetailsid = tournamentDetailsByTournamentDetailsid;
	}

	@ManyToOne
	@JoinColumn(name = "teamid", referencedColumnName = "id", nullable = false)
	public TeamEntity getTeamByTeamid() {
		return teamByTeamid;
	}

	public void setTeamByTeamid(TeamEntity teamByTeamid) {
		this.teamByTeamid = teamByTeamid;
	}
}
