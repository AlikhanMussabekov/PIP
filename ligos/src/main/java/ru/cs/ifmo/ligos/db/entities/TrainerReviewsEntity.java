package ru.cs.ifmo.ligos.db.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "trainer_reviews", schema = "public", catalog = "ligos")
public class TrainerReviewsEntity {
	private Integer traineruserid;
	private Integer userid;
	private String review;
	private Short raiting;
	private Object date;
	private TrainerEntity trainerByTraineruserid;
	private UserEntity userByUserid;

	@Id
	@Column(name = "traineruserid", nullable = false)
	public Integer getTraineruserid() {
		return traineruserid;
	}

	public void setTraineruserid(Integer traineruserid) {
		this.traineruserid = traineruserid;
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
		TrainerReviewsEntity that = (TrainerReviewsEntity) o;
		return Objects.equals(traineruserid, that.traineruserid) &&
				Objects.equals(userid, that.userid) &&
				Objects.equals(review, that.review) &&
				Objects.equals(raiting, that.raiting) &&
				Objects.equals(date, that.date);
	}

	@Override
	public int hashCode() {
		return Objects.hash(traineruserid, userid, review, raiting, date);
	}

	@OneToOne
	@JoinColumn(name = "traineruserid", referencedColumnName = "userid", nullable = false)
	public TrainerEntity getTrainerByTraineruserid() {
		return trainerByTraineruserid;
	}

	public void setTrainerByTraineruserid(TrainerEntity trainerByTraineruserid) {
		this.trainerByTraineruserid = trainerByTraineruserid;
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
