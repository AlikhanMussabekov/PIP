package ru.cs.ifmo.ligos.db.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "trainer", schema = "public", catalog = "ligos")
public class TrainerEntity {
	private Integer userid;
	private Integer organizationid;
	private Short raiting;
	private Collection<SectionDetailsEntity> sectionDetailsByUserid;
	private Collection<TeamEntity> teamsByUserid;
	private UserEntity userByUserid;
	private OrganizationEntity organizationByOrganizationid;
	private TrainerReviewsEntity trainerReviewsByUserid;

	@Id
	@Column(name = "userid", nullable = false)
	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	@Basic
	@Column(name = "organizationid", nullable = false)
	public Integer getOrganizationid() {
		return organizationid;
	}

	public void setOrganizationid(Integer organizationid) {
		this.organizationid = organizationid;
	}

	@Basic
	@Column(name = "raiting", nullable = false)
	public Short getRaiting() {
		return raiting;
	}

	public void setRaiting(Short raiting) {
		this.raiting = raiting;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		TrainerEntity that = (TrainerEntity) o;
		return Objects.equals(userid, that.userid) &&
				Objects.equals(organizationid, that.organizationid) &&
				Objects.equals(raiting, that.raiting);
	}

	@Override
	public int hashCode() {
		return Objects.hash(userid, organizationid, raiting);
	}

	@OneToMany(mappedBy = "trainerByTrainerid")
	public Collection<SectionDetailsEntity> getSectionDetailsByUserid() {
		return sectionDetailsByUserid;
	}

	public void setSectionDetailsByUserid(Collection<SectionDetailsEntity> sectionDetailsByUserid) {
		this.sectionDetailsByUserid = sectionDetailsByUserid;
	}

	@OneToMany(mappedBy = "trainerByTrainerid")
	public Collection<TeamEntity> getTeamsByUserid() {
		return teamsByUserid;
	}

	public void setTeamsByUserid(Collection<TeamEntity> teamsByUserid) {
		this.teamsByUserid = teamsByUserid;
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
	@JoinColumn(name = "organizationid", referencedColumnName = "id", nullable = false)
	public OrganizationEntity getOrganizationByOrganizationid() {
		return organizationByOrganizationid;
	}

	public void setOrganizationByOrganizationid(OrganizationEntity organizationByOrganizationid) {
		this.organizationByOrganizationid = organizationByOrganizationid;
	}

	@OneToOne(mappedBy = "trainerByTraineruserid")
	public TrainerReviewsEntity getTrainerReviewsByUserid() {
		return trainerReviewsByUserid;
	}

	public void setTrainerReviewsByUserid(TrainerReviewsEntity trainerReviewsByUserid) {
		this.trainerReviewsByUserid = trainerReviewsByUserid;
	}
}
