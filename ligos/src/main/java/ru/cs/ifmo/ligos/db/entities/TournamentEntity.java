package ru.cs.ifmo.ligos.db.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "tournament", schema = "public", catalog = "ligos")
public class TournamentEntity {
	private Integer id;
	private String name;
	private String description;
	private Object date;
	private Integer addressid;
	private Collection<MatchesEntity> matchesById;
	private AddressEntity addressByAddressid;
	private Collection<TournamentDetailsEntity> tournamentDetailsById;
	private TournamentReviewsEntity tournamentReviewsById;

	@Id
	@Column(name = "id", nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
	@Column(name = "description", nullable = false, length = -1)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
	@Column(name = "addressid", nullable = false)
	public Integer getAddressid() {
		return addressid;
	}

	public void setAddressid(Integer addressid) {
		this.addressid = addressid;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		TournamentEntity that = (TournamentEntity) o;
		return Objects.equals(id, that.id) &&
				Objects.equals(name, that.name) &&
				Objects.equals(description, that.description) &&
				Objects.equals(date, that.date) &&
				Objects.equals(addressid, that.addressid);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, description, date, addressid);
	}

	@OneToMany(mappedBy = "tournamentByTournamentid")
	public Collection<MatchesEntity> getMatchesById() {
		return matchesById;
	}

	public void setMatchesById(Collection<MatchesEntity> matchesById) {
		this.matchesById = matchesById;
	}

	@ManyToOne
	@JoinColumn(name = "addressid", referencedColumnName = "id", nullable = false)
	public AddressEntity getAddressByAddressid() {
		return addressByAddressid;
	}

	public void setAddressByAddressid(AddressEntity addressByAddressid) {
		this.addressByAddressid = addressByAddressid;
	}

	@OneToMany(mappedBy = "tournamentByTournamentid")
	public Collection<TournamentDetailsEntity> getTournamentDetailsById() {
		return tournamentDetailsById;
	}

	public void setTournamentDetailsById(Collection<TournamentDetailsEntity> tournamentDetailsById) {
		this.tournamentDetailsById = tournamentDetailsById;
	}

	@OneToOne(mappedBy = "tournamentByTournamentid")
	public TournamentReviewsEntity getTournamentReviewsById() {
		return tournamentReviewsById;
	}

	public void setTournamentReviewsById(TournamentReviewsEntity tournamentReviewsById) {
		this.tournamentReviewsById = tournamentReviewsById;
	}
}
