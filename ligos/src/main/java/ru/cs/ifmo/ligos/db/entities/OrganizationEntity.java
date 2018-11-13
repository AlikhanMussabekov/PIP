package ru.cs.ifmo.ligos.db.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "organization", schema = "public", catalog = "ligos")
public class OrganizationEntity {
	private Integer id;
	private String email;
	private String password;
	private String name;
	private byte[] photo;
	private String type;
	private String iin;
	private String kpp;
	private String ogrn;
	private Timestamp ogrnDate;
	private String ogrnip;
	private Timestamp ogrnipDate;
	private String bik;
	private String bankName;
	private String korrBill;
	private String paymentBill;
	private Integer legalAddress;
	private Integer actualAddress;
	private Collection<CourtEntity> courtsById;
	private AddressEntity addressByLegalAddress;
	private AddressEntity addressByActualAddress;
	private Collection<SectionEntity> sectionsById;
	private Collection<TrainerEntity> trainersById;

	@Id
	@Column(name = "id", nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Basic
	@Column(name = "email", nullable = false, length = 254)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Basic
	@Column(name = "password", nullable = false, length = 255)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Basic
	@Column(name = "name", nullable = true, length = 255)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Basic
	@Column(name = "photo", nullable = true)
	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	@Basic
	@Column(name = "type", nullable = true, length = 4)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Basic
	@Column(name = "iin", nullable = true, length = 10)
	public String getIin() {
		return iin;
	}

	public void setIin(String iin) {
		this.iin = iin;
	}

	@Basic
	@Column(name = "kpp", nullable = true, length = 9)
	public String getKpp() {
		return kpp;
	}

	public void setKpp(String kpp) {
		this.kpp = kpp;
	}

	@Basic
	@Column(name = "ogrn", nullable = true, length = 13)
	public String getOgrn() {
		return ogrn;
	}

	public void setOgrn(String ogrn) {
		this.ogrn = ogrn;
	}

	@Basic
	@Column(name = "ogrn_date", nullable = true)
	public Timestamp getOgrnDate() {
		return ogrnDate;
	}

	public void setOgrnDate(Timestamp ogrnDate) {
		this.ogrnDate = ogrnDate;
	}

	@Basic
	@Column(name = "ogrnip", nullable = true, length = 15)
	public String getOgrnip() {
		return ogrnip;
	}

	public void setOgrnip(String ogrnip) {
		this.ogrnip = ogrnip;
	}

	@Basic
	@Column(name = "ogrnip_date", nullable = true)
	public Timestamp getOgrnipDate() {
		return ogrnipDate;
	}

	public void setOgrnipDate(Timestamp ogrnipDate) {
		this.ogrnipDate = ogrnipDate;
	}

	@Basic
	@Column(name = "bik", nullable = true, length = 9)
	public String getBik() {
		return bik;
	}

	public void setBik(String bik) {
		this.bik = bik;
	}

	@Basic
	@Column(name = "bank_name", nullable = true, length = 255)
	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	@Basic
	@Column(name = "korr_bill", nullable = true, length = 20)
	public String getKorrBill() {
		return korrBill;
	}

	public void setKorrBill(String korrBill) {
		this.korrBill = korrBill;
	}

	@Basic
	@Column(name = "payment_bill", nullable = true, length = 20)
	public String getPaymentBill() {
		return paymentBill;
	}

	public void setPaymentBill(String paymentBill) {
		this.paymentBill = paymentBill;
	}

	@Basic
	@Column(name = "legal_address", nullable = false)
	public Integer getLegalAddress() {
		return legalAddress;
	}

	public void setLegalAddress(Integer legalAddress) {
		this.legalAddress = legalAddress;
	}

	@Basic
	@Column(name = "actual_address", nullable = false)
	public Integer getActualAddress() {
		return actualAddress;
	}

	public void setActualAddress(Integer actualAddress) {
		this.actualAddress = actualAddress;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		OrganizationEntity that = (OrganizationEntity) o;
		return Objects.equals(id, that.id) &&
				Objects.equals(email, that.email) &&
				Objects.equals(password, that.password) &&
				Objects.equals(name, that.name) &&
				Arrays.equals(photo, that.photo) &&
				Objects.equals(type, that.type) &&
				Objects.equals(iin, that.iin) &&
				Objects.equals(kpp, that.kpp) &&
				Objects.equals(ogrn, that.ogrn) &&
				Objects.equals(ogrnDate, that.ogrnDate) &&
				Objects.equals(ogrnip, that.ogrnip) &&
				Objects.equals(ogrnipDate, that.ogrnipDate) &&
				Objects.equals(bik, that.bik) &&
				Objects.equals(bankName, that.bankName) &&
				Objects.equals(korrBill, that.korrBill) &&
				Objects.equals(paymentBill, that.paymentBill) &&
				Objects.equals(legalAddress, that.legalAddress) &&
				Objects.equals(actualAddress, that.actualAddress);
	}

	@Override
	public int hashCode() {
		int result = Objects.hash(id, email, password, name, type, iin, kpp, ogrn, ogrnDate, ogrnip, ogrnipDate, bik, bankName, korrBill, paymentBill, legalAddress, actualAddress);
		result = 31 * result + Arrays.hashCode(photo);
		return result;
	}

	@OneToMany(mappedBy = "organizationByOrganizationid")
	public Collection<CourtEntity> getCourtsById() {
		return courtsById;
	}

	public void setCourtsById(Collection<CourtEntity> courtsById) {
		this.courtsById = courtsById;
	}

	@ManyToOne
	@JoinColumn(name = "legal_address", referencedColumnName = "id", nullable = false)
	public AddressEntity getAddressByLegalAddress() {
		return addressByLegalAddress;
	}

	public void setAddressByLegalAddress(AddressEntity addressByLegalAddress) {
		this.addressByLegalAddress = addressByLegalAddress;
	}

	@ManyToOne
	@JoinColumn(name = "actual_address", referencedColumnName = "id", nullable = false)
	public AddressEntity getAddressByActualAddress() {
		return addressByActualAddress;
	}

	public void setAddressByActualAddress(AddressEntity addressByActualAddress) {
		this.addressByActualAddress = addressByActualAddress;
	}

	@OneToMany(mappedBy = "organizationByOrganizationid")
	public Collection<SectionEntity> getSectionsById() {
		return sectionsById;
	}

	public void setSectionsById(Collection<SectionEntity> sectionsById) {
		this.sectionsById = sectionsById;
	}

	@OneToMany(mappedBy = "organizationByOrganizationid")
	public Collection<TrainerEntity> getTrainersById() {
		return trainersById;
	}

	public void setTrainersById(Collection<TrainerEntity> trainersById) {
		this.trainersById = trainersById;
	}
}
