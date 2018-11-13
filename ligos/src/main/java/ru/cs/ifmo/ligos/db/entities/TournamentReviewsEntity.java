package ru.cs.ifmo.ligos.db.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tournament_reviews", schema = "public", catalog = "ligos")
public class TournamentReviewsEntity {
	private Integer tournamentid;
	private String review;
	private Short raiting;
	private Object date;
	private TournamentEntity tournamentByTournamentid;

	@Id
	@Column(name = "tournamentid", nullable = false)
	public Integer getTournamentid() {
		return tournamentid;
	}

	public void setTournamentid(Integer tournamentid) {
		this.tournamentid = tournamentid;
	}

	@Basic
	@Column(name = "review", nullable = false, length = -1)
	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	@Basic
	@Column(name = "raiting", nullable = false)
	public Short getRaiting() {
		return raiting;
	}

	public void setRaiting(Short raiting) {
		this.raiting = raiting;
	}

	@Basic
	@Column(name = "DATE", nullable = false)
	public Object getDate() {
		return date;
	}

	public void setDate(Object date) {
		this.date = date;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		TournamentReviewsEntity that = (TournamentReviewsEntity) o;
		return Objects.equals(tournamentid, that.tournamentid) &&
				Objects.equals(review, that.review) &&
				Objects.equals(raiting, that.raiting) &&
				Objects.equals(date, that.date);
	}

	@Override
	public int hashCode() {
		return Objects.hash(tournamentid, review, raiting, date);
	}

	@OneToOne
	@JoinColumn(name = "tournamentid", referencedColumnName = "id", nullable = false)
	public TournamentEntity getTournamentByTournamentid() {
		return tournamentByTournamentid;
	}

	public void setTournamentByTournamentid(TournamentEntity tournamentByTournamentid) {
		this.tournamentByTournamentid = tournamentByTournamentid;
	}
}
