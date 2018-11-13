package ru.cs.ifmo.ligos.db.entities;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "section", schema = "public", catalog = "ligos")
public class SectionEntity {
	private Integer id;
	private Integer organizationid;
	private String name;
	private String description;
	private byte[] photo;
	private Integer addressid;
	private OrganizationEntity organizationByOrganizationid;
	private AddressEntity addressByAddressid;
	private Collection<SectionDetailsEntity> sectionDetailsById;
	private Collection<SectionReviewsEntity> sectionReviewsById;

	@Id
	@Column(name = "id", nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
	@Column(name = "photo", nullable = false)
	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
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
		SectionEntity that = (SectionEntity) o;
		return Objects.equals(id, that.id) &&
				Objects.equals(organizationid, that.organizationid) &&
				Objects.equals(name, that.name) &&
				Objects.equals(description, that.description) &&
				Arrays.equals(photo, that.photo) &&
				Objects.equals(addressid, that.addressid);
	}

	@Override
	public int hashCode() {
		int result = Objects.hash(id, organizationid, name, description, addressid);
		result = 31 * result + Arrays.hashCode(photo);
		return result;
	}

	@ManyToOne
	@JoinColumn(name = "organizationid", referencedColumnName = "id", nullable = false)
	public OrganizationEntity getOrganizationByOrganizationid() {
		return organizationByOrganizationid;
	}

	public void setOrganizationByOrganizationid(OrganizationEntity organizationByOrganizationid) {
		this.organizationByOrganizationid = organizationByOrganizationid;
	}

	@ManyToOne
	@JoinColumn(name = "addressid", referencedColumnName = "id", nullable = false)
	public AddressEntity getAddressByAddressid() {
		return addressByAddressid;
	}

	public void setAddressByAddressid(AddressEntity addressByAddressid) {
		this.addressByAddressid = addressByAddressid;
	}

	@OneToMany(mappedBy = "sectionBySectionid")
	public Collection<SectionDetailsEntity> getSectionDetailsById() {
		return sectionDetailsById;
	}

	public void setSectionDetailsById(Collection<SectionDetailsEntity> sectionDetailsById) {
		this.sectionDetailsById = sectionDetailsById;
	}

	@OneToMany(mappedBy = "sectionBySectionid")
	public Collection<SectionReviewsEntity> getSectionReviewsById() {
		return sectionReviewsById;
	}

	public void setSectionReviewsById(Collection<SectionReviewsEntity> sectionReviewsById) {
		this.sectionReviewsById = sectionReviewsById;
	}
}
