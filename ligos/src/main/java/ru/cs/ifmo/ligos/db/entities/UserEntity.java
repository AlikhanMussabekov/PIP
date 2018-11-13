package ru.cs.ifmo.ligos.db.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "USER", schema = "public", catalog = "ligos")
public class UserEntity {
	private Integer id;
	private String email;
	private String password;
	private String name;
	private String surname;
	private String patronymic;
	private String phoneNumber;
	private String city;
	private String gender;
	private Timestamp birthday;
	private byte[] photo;
	private Short raiting;
	private Collection<ChatEntity> chatsById;
	private Collection<ChatEntity> chatsById_0;
	private Collection<GoalsListEntity> goalsListsById;
	private SectionReviewsEntity sectionReviewsById;
	private Collection<SectionUsersEntity> sectionUsersById;
	private Collection<TeamEntity> teamsById;
	private Collection<TeamUserEntity> teamUsersById;
	private TrainerEntity trainerById;
	private Collection<TrainerReviewsEntity> trainerReviewsById;

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
	@Column(name = "name", nullable = false, length = 255)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Basic
	@Column(name = "surname", nullable = true, length = 255)
	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Basic
	@Column(name = "patronymic", nullable = true, length = 255)
	public String getPatronymic() {
		return patronymic;
	}

	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}

	@Basic
	@Column(name = "phone_number", nullable = true, length = 11)
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Basic
	@Column(name = "city", nullable = true, length = 255)
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Basic
	@Column(name = "gender", nullable = true, length = 7)
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Basic
	@Column(name = "birthday", nullable = true)
	public Timestamp getBirthday() {
		return birthday;
	}

	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
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
	@Column(name = "raiting", nullable = true)
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
		UserEntity that = (UserEntity) o;
		return Objects.equals(id, that.id) &&
				Objects.equals(email, that.email) &&
				Objects.equals(password, that.password) &&
				Objects.equals(name, that.name) &&
				Objects.equals(surname, that.surname) &&
				Objects.equals(patronymic, that.patronymic) &&
				Objects.equals(phoneNumber, that.phoneNumber) &&
				Objects.equals(city, that.city) &&
				Objects.equals(gender, that.gender) &&
				Objects.equals(birthday, that.birthday) &&
				Arrays.equals(photo, that.photo) &&
				Objects.equals(raiting, that.raiting);
	}

	@Override
	public int hashCode() {
		int result = Objects.hash(id, email, password, name, surname, patronymic, phoneNumber, city, gender, birthday, raiting);
		result = 31 * result + Arrays.hashCode(photo);
		return result;
	}

	@OneToMany(mappedBy = "userByUserid")
	public Collection<ChatEntity> getChatsById() {
		return chatsById;
	}

	public void setChatsById(Collection<ChatEntity> chatsById) {
		this.chatsById = chatsById;
	}

	@OneToMany(mappedBy = "userByUserid2")
	public Collection<ChatEntity> getChatsById_0() {
		return chatsById_0;
	}

	public void setChatsById_0(Collection<ChatEntity> chatsById_0) {
		this.chatsById_0 = chatsById_0;
	}

	@OneToMany(mappedBy = "userByUserid")
	public Collection<GoalsListEntity> getGoalsListsById() {
		return goalsListsById;
	}

	public void setGoalsListsById(Collection<GoalsListEntity> goalsListsById) {
		this.goalsListsById = goalsListsById;
	}

	@OneToOne(mappedBy = "userByUserid")
	public SectionReviewsEntity getSectionReviewsById() {
		return sectionReviewsById;
	}

	public void setSectionReviewsById(SectionReviewsEntity sectionReviewsById) {
		this.sectionReviewsById = sectionReviewsById;
	}

	@OneToMany(mappedBy = "userByUserid")
	public Collection<SectionUsersEntity> getSectionUsersById() {
		return sectionUsersById;
	}

	public void setSectionUsersById(Collection<SectionUsersEntity> sectionUsersById) {
		this.sectionUsersById = sectionUsersById;
	}

	@OneToMany(mappedBy = "userByCaptainid")
	public Collection<TeamEntity> getTeamsById() {
		return teamsById;
	}

	public void setTeamsById(Collection<TeamEntity> teamsById) {
		this.teamsById = teamsById;
	}

	@OneToMany(mappedBy = "userByUserid")
	public Collection<TeamUserEntity> getTeamUsersById() {
		return teamUsersById;
	}

	public void setTeamUsersById(Collection<TeamUserEntity> teamUsersById) {
		this.teamUsersById = teamUsersById;
	}

	@OneToOne(mappedBy = "userByUserid")
	public TrainerEntity getTrainerById() {
		return trainerById;
	}

	public void setTrainerById(TrainerEntity trainerById) {
		this.trainerById = trainerById;
	}

	@OneToMany(mappedBy = "userByUserid")
	public Collection<TrainerReviewsEntity> getTrainerReviewsById() {
		return trainerReviewsById;
	}

	public void setTrainerReviewsById(Collection<TrainerReviewsEntity> trainerReviewsById) {
		this.trainerReviewsById = trainerReviewsById;
	}
}
