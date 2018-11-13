package ru.cs.ifmo.ligos.db.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "age_category", schema = "public", catalog = "ligos")
public class AgeCategoryEntity {
	private Integer id;
	private Integer from;
	private Integer to;
	private Collection<SectionDetailsEntity> sectionDetailsById;
	private Collection<TournamentDetailsEntity> tournamentDetailsById;

	@Id
	@Column(name = "id", nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Basic
	@Column(name = "FROM", nullable = false)
	public Integer getFrom() {
		return from;
	}

	public void setFrom(Integer from) {
		this.from = from;
	}

	@Basic
	@Column(name = "TO", nullable = false)
	public Integer getTo() {
		return to;
	}

	public void setTo(Integer to) {
		this.to = to;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		AgeCategoryEntity that = (AgeCategoryEntity) o;
		return Objects.equals(id, that.id) &&
				Objects.equals(from, that.from) &&
				Objects.equals(to, that.to);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, from, to);
	}

	@OneToMany(mappedBy = "ageCategoryByAgeCategoryid")
	public Collection<SectionDetailsEntity> getSectionDetailsById() {
		return sectionDetailsById;
	}

	public void setSectionDetailsById(Collection<SectionDetailsEntity> sectionDetailsById) {
		this.sectionDetailsById = sectionDetailsById;
	}

	@OneToMany(mappedBy = "ageCategoryByAgeCategoryid")
	public Collection<TournamentDetailsEntity> getTournamentDetailsById() {
		return tournamentDetailsById;
	}

	public void setTournamentDetailsById(Collection<TournamentDetailsEntity> tournamentDetailsById) {
		this.tournamentDetailsById = tournamentDetailsById;
	}
}
