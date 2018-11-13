package ru.cs.ifmo.ligos.db.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "address", schema = "public", catalog = "ligos")
public class AddressEntity {
	private Integer id;
	private String country;
	private String state;
	private String zipCode;
	private String city;
	private String street;
	private Collection<CourtEntity> courtsById;
	private Collection<OrganizationEntity> organizationsById;
	private Collection<OrganizationEntity> organizationsById_0;
	private Collection<SectionEntity> sectionsById;
	private Collection<TournamentEntity> tournamentsById;

	@Id
	@Column(name = "id", nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Basic
	@Column(name = "country", nullable = false, length = 255)
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Basic
	@Column(name = "state", nullable = false, length = 255)
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Basic
	@Column(name = "zip_code", nullable = false, length = 255)
	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Basic
	@Column(name = "city", nullable = false, length = 255)
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Basic
	@Column(name = "street", nullable = false, length = 255)
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		AddressEntity that = (AddressEntity) o;
		return Objects.equals(id, that.id) &&
				Objects.equals(country, that.country) &&
				Objects.equals(state, that.state) &&
				Objects.equals(zipCode, that.zipCode) &&
				Objects.equals(city, that.city) &&
				Objects.equals(street, that.street);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, country, state, zipCode, city, street);
	}

	@OneToMany(mappedBy = "addressByAddressid")
	public Collection<CourtEntity> getCourtsById() {
		return courtsById;
	}

	public void setCourtsById(Collection<CourtEntity> courtsById) {
		this.courtsById = courtsById;
	}

	@OneToMany(mappedBy = "addressByLegalAddress")
	public Collection<OrganizationEntity> getOrganizationsById() {
		return organizationsById;
	}

	public void setOrganizationsById(Collection<OrganizationEntity> organizationsById) {
		this.organizationsById = organizationsById;
	}

	@OneToMany(mappedBy = "addressByActualAddress")
	public Collection<OrganizationEntity> getOrganizationsById_0() {
		return organizationsById_0;
	}

	public void setOrganizationsById_0(Collection<OrganizationEntity> organizationsById_0) {
		this.organizationsById_0 = organizationsById_0;
	}

	@OneToMany(mappedBy = "addressByAddressid")
	public Collection<SectionEntity> getSectionsById() {
		return sectionsById;
	}

	public void setSectionsById(Collection<SectionEntity> sectionsById) {
		this.sectionsById = sectionsById;
	}

	@OneToMany(mappedBy = "addressByAddressid")
	public Collection<TournamentEntity> getTournamentsById() {
		return tournamentsById;
	}

	public void setTournamentsById(Collection<TournamentEntity> tournamentsById) {
		this.tournamentsById = tournamentsById;
	}
}
