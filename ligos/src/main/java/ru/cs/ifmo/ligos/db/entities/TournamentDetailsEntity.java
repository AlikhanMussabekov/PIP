package ru.cs.ifmo.ligos.db.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tournament_details", schema = "public", catalog = "ligos")
public class TournamentDetailsEntity {
	private Integer id;
	private Integer ageCategoryid;
	private Integer tournamentid;
	private Integer price;
	private Integer maxTeamsCount;
	private AgeCategoryEntity ageCategoryByAgeCategoryid;
	private TournamentEntity tournamentByTournamentid;
	private TournamentTeamsEntity tournamentTeamsById;

	@Id
	@Column(name = "id", nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Basic
	@Column(name = "age_categoryid", nullable = false)
	public Integer getAgeCategoryid() {
		return ageCategoryid;
	}

	public void setAgeCategoryid(Integer ageCategoryid) {
		this.ageCategoryid = ageCategoryid;
	}

	@Basic
	@Column(name = "tournamentid", nullable = false)
	public Integer getTournamentid() {
		return tournamentid;
	}

	public void setTournamentid(Integer tournamentid) {
		this.tournamentid = tournamentid;
	}

	@Basic
	@Column(name = "price", nullable = false)
	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	@Basic
	@Column(name = "max_teams_count", nullable = false)
	public Integer getMaxTeamsCount() {
		return maxTeamsCount;
	}

	public void setMaxTeamsCount(Integer maxTeamsCount) {
		this.maxTeamsCount = maxTeamsCount;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		TournamentDetailsEntity that = (TournamentDetailsEntity) o;
		return Objects.equals(id, that.id) &&
				Objects.equals(ageCategoryid, that.ageCategoryid) &&
				Objects.equals(tournamentid, that.tournamentid) &&
				Objects.equals(price, that.price) &&
				Objects.equals(maxTeamsCount, that.maxTeamsCount);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, ageCategoryid, tournamentid, price, maxTeamsCount);
	}

	@ManyToOne
	@JoinColumn(name = "age_categoryid", referencedColumnName = "id", nullable = false)
	public AgeCategoryEntity getAgeCategoryByAgeCategoryid() {
		return ageCategoryByAgeCategoryid;
	}

	public void setAgeCategoryByAgeCategoryid(AgeCategoryEntity ageCategoryByAgeCategoryid) {
		this.ageCategoryByAgeCategoryid = ageCategoryByAgeCategoryid;
	}

	@ManyToOne
	@JoinColumn(name = "tournamentid", referencedColumnName = "id", nullable = false)
	public TournamentEntity getTournamentByTournamentid() {
		return tournamentByTournamentid;
	}

	public void setTournamentByTournamentid(TournamentEntity tournamentByTournamentid) {
		this.tournamentByTournamentid = tournamentByTournamentid;
	}

	@OneToOne(mappedBy = "tournamentDetailsByTournamentDetailsid")
	public TournamentTeamsEntity getTournamentTeamsById() {
		return tournamentTeamsById;
	}

	public void setTournamentTeamsById(TournamentTeamsEntity tournamentTeamsById) {
		this.tournamentTeamsById = tournamentTeamsById;
	}
}
