package ru.cs.ifmo.ligos.db.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "section_reviews", schema = "public", catalog = "ligos")
public class SectionReviewsEntity {
	private Integer userid;
	private Integer sectionid;
	private String review;
	private Short raiting;
	private Object date;
	private UserEntity userByUserid;
	private SectionEntity sectionBySectionid;

	@Id
	@Column(name = "userid", nullable = false)
	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	@Basic
	@Column(name = "sectionid", nullable = false)
	public Integer getSectionid() {
		return sectionid;
	}

	public void setSectionid(Integer sectionid) {
		this.sectionid = sectionid;
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
		SectionReviewsEntity that = (SectionReviewsEntity) o;
		return Objects.equals(userid, that.userid) &&
				Objects.equals(sectionid, that.sectionid) &&
				Objects.equals(review, that.review) &&
				Objects.equals(raiting, that.raiting) &&
				Objects.equals(date, that.date);
	}

	@Override
	public int hashCode() {
		return Objects.hash(userid, sectionid, review, raiting, date);
	}

	@OneToOne
	@JoinColumn(name = "userid", referencedColumnName = "id", nullable = false)
	public UserEntity getUserByUserid() {
		return userByUserid;
	}

	public void setUserByUserid(UserEntity userByUserid) {
		this.userByUserid = userByUserid;
	}

	@ManyToOne
	@JoinColumn(name = "sectionid", referencedColumnName = "id", nullable = false)
	public SectionEntity getSectionBySectionid() {
		return sectionBySectionid;
	}

	public void setSectionBySectionid(SectionEntity sectionBySectionid) {
		this.sectionBySectionid = sectionBySectionid;
	}
}
