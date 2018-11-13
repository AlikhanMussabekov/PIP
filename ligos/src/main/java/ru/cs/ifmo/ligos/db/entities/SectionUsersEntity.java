package ru.cs.ifmo.ligos.db.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "section_users", schema = "public", catalog = "ligos")
public class SectionUsersEntity {
	private Integer sectionDetailsid;
	private Integer userid;
	private Boolean present;
	private SectionDetailsEntity sectionDetailsBySectionDetailsid;
	private UserEntity userByUserid;

	@Id
	@Column(name = "section_detailsid", nullable = false)
	public Integer getSectionDetailsid() {
		return sectionDetailsid;
	}

	public void setSectionDetailsid(Integer sectionDetailsid) {
		this.sectionDetailsid = sectionDetailsid;
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
	@Column(name = "present", nullable = false)
	public Boolean getPresent() {
		return present;
	}

	public void setPresent(Boolean present) {
		this.present = present;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SectionUsersEntity that = (SectionUsersEntity) o;
		return Objects.equals(sectionDetailsid, that.sectionDetailsid) &&
				Objects.equals(userid, that.userid) &&
				Objects.equals(present, that.present);
	}

	@Override
	public int hashCode() {
		return Objects.hash(sectionDetailsid, userid, present);
	}

	@OneToOne
	@JoinColumn(name = "section_detailsid", referencedColumnName = "id", nullable = false)
	public SectionDetailsEntity getSectionDetailsBySectionDetailsid() {
		return sectionDetailsBySectionDetailsid;
	}

	public void setSectionDetailsBySectionDetailsid(SectionDetailsEntity sectionDetailsBySectionDetailsid) {
		this.sectionDetailsBySectionDetailsid = sectionDetailsBySectionDetailsid;
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
