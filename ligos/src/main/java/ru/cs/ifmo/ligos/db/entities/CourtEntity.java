package ru.cs.ifmo.ligos.db.entities;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "court", schema = "public", catalog = "ligos")
public class CourtEntity {
	private Integer id;
	private Integer organizationid;
	private String name;
	private String description;
	private byte[] photos;
	private Integer addressid;
	private Short raiting;
	private OrganizationEntity organizationByOrganizationid;
	private AddressEntity addressByAddressid;
	private CourtPaymentEntity courtPaymentById;
	private CourtReviewsEntity courtReviewsById;
	private Collection<MatchesEntity> matchesById;

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
	@Column(name = "photos", nullable = false)
	public byte[] getPhotos() {
		return photos;
	}

	public void setPhotos(byte[] photos) {
		this.photos = photos;
	}

	@Basic
	@Column(name = "addressid", nullable = false)
	public Integer getAddressid() {
		return addressid;
	}

	public void setAddressid(Integer addressid) {
		this.addressid = addressid;
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
		CourtEntity that = (CourtEntity) o;
		return Objects.equals(id, that.id) &&
				Objects.equals(organizationid, that.organizationid) &&
				Objects.equals(name, that.name) &&
				Objects.equals(description, that.description) &&
				Arrays.equals(photos, that.photos) &&
				Objects.equals(addressid, that.addressid) &&
				Objects.equals(raiting, that.raiting);
	}

	@Override
	public int hashCode() {
		int result = Objects.hash(id, organizationid, name, description, addressid, raiting);
		result = 31 * result + Arrays.hashCode(photos);
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

	@OneToOne(mappedBy = "courtByCourtid")
	public CourtPaymentEntity getCourtPaymentById() {
		return courtPaymentById;
	}

	public void setCourtPaymentById(CourtPaymentEntity courtPaymentById) {
		this.courtPaymentById = courtPaymentById;
	}

	@OneToOne(mappedBy = "courtByCourtid")
	public CourtReviewsEntity getCourtReviewsById() {
		return courtReviewsById;
	}

	public void setCourtReviewsById(CourtReviewsEntity courtReviewsById) {
		this.courtReviewsById = courtReviewsById;
	}

	@OneToMany(mappedBy = "courtByCourtid")
	public Collection<MatchesEntity> getMatchesById() {
		return matchesById;
	}

	public void setMatchesById(Collection<MatchesEntity> matchesById) {
		this.matchesById = matchesById;
	}
}
