package ru.cs.ifmo.ligos.db.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "section_details", schema = "public", catalog = "ligos")
public class SectionDetailsEntity {
	private Integer id;
	private Integer ageCategoryid;
	private Integer sectionid;
	private Integer trainerid;
	private Integer price;
	private Object timeStart;
	private Object timeEnd;
	private Integer maxUsersCount;
	private AgeCategoryEntity ageCategoryByAgeCategoryid;
	private SectionEntity sectionBySectionid;
	private TrainerEntity trainerByTrainerid;
	private SectionUsersEntity sectionUsersById;

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
	@Column(name = "sectionid", nullable = false)
	public Integer getSectionid() {
		return sectionid;
	}

	public void setSectionid(Integer sectionid) {
		this.sectionid = sectionid;
	}

	@Basic
	@Column(name = "trainerid", nullable = false)
	public Integer getTrainerid() {
		return trainerid;
	}

	public void setTrainerid(Integer trainerid) {
		this.trainerid = trainerid;
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
	@Column(name = "time_start", nullable = false)
	public Object getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(Object timeStart) {
		this.timeStart = timeStart;
	}

	@Basic
	@Column(name = "time_end", nullable = false)
	public Object getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(Object timeEnd) {
		this.timeEnd = timeEnd;
	}

	@Basic
	@Column(name = "max_users_count", nullable = false)
	public Integer getMaxUsersCount() {
		return maxUsersCount;
	}

	public void setMaxUsersCount(Integer maxUsersCount) {
		this.maxUsersCount = maxUsersCount;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SectionDetailsEntity that = (SectionDetailsEntity) o;
		return Objects.equals(id, that.id) &&
				Objects.equals(ageCategoryid, that.ageCategoryid) &&
				Objects.equals(sectionid, that.sectionid) &&
				Objects.equals(trainerid, that.trainerid) &&
				Objects.equals(price, that.price) &&
				Objects.equals(timeStart, that.timeStart) &&
				Objects.equals(timeEnd, that.timeEnd) &&
				Objects.equals(maxUsersCount, that.maxUsersCount);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, ageCategoryid, sectionid, trainerid, price, timeStart, timeEnd, maxUsersCount);
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
	@JoinColumn(name = "sectionid", referencedColumnName = "id", nullable = false)
	public SectionEntity getSectionBySectionid() {
		return sectionBySectionid;
	}

	public void setSectionBySectionid(SectionEntity sectionBySectionid) {
		this.sectionBySectionid = sectionBySectionid;
	}

	@ManyToOne
	@JoinColumn(name = "trainerid", referencedColumnName = "userid", nullable = false)
	public TrainerEntity getTrainerByTrainerid() {
		return trainerByTrainerid;
	}

	public void setTrainerByTrainerid(TrainerEntity trainerByTrainerid) {
		this.trainerByTrainerid = trainerByTrainerid;
	}

	@OneToOne(mappedBy = "sectionDetailsBySectionDetailsid")
	public SectionUsersEntity getSectionUsersById() {
		return sectionUsersById;
	}

	public void setSectionUsersById(SectionUsersEntity sectionUsersById) {
		this.sectionUsersById = sectionUsersById;
	}
}
