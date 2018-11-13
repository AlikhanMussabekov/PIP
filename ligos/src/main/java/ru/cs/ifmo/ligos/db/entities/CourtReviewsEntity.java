package ru.cs.ifmo.ligos.db.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "court_reviews", schema = "public", catalog = "ligos")
public class CourtReviewsEntity {
	private Integer courtid;
	private String review;
	private Short raiting;
	private Object date;
	private CourtEntity courtByCourtid;

	@Id
	@Column(name = "courtid", nullable = false)
	public Integer getCourtid() {
		return courtid;
	}

	public void setCourtid(Integer courtid) {
		this.courtid = courtid;
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
		CourtReviewsEntity that = (CourtReviewsEntity) o;
		return Objects.equals(courtid, that.courtid) &&
				Objects.equals(review, that.review) &&
				Objects.equals(raiting, that.raiting) &&
				Objects.equals(date, that.date);
	}

	@Override
	public int hashCode() {
		return Objects.hash(courtid, review, raiting, date);
	}

	@OneToOne
	@JoinColumn(name = "courtid", referencedColumnName = "id", nullable = false)
	public CourtEntity getCourtByCourtid() {
		return courtByCourtid;
	}

	public void setCourtByCourtid(CourtEntity courtByCourtid) {
		this.courtByCourtid = courtByCourtid;
	}
}
