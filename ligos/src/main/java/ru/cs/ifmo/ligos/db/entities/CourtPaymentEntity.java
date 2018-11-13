package ru.cs.ifmo.ligos.db.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "court_payment", schema = "public", catalog = "ligos")
public class CourtPaymentEntity {
	private Integer courtid;
	private Integer price;
	private Object from;
	private Object to;
	private Boolean status;
	private CourtEntity courtByCourtid;

	@Id
	@Column(name = "courtid", nullable = false)
	public Integer getCourtid() {
		return courtid;
	}

	public void setCourtid(Integer courtid) {
		this.courtid = courtid;
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
	@Column(name = "FROM", nullable = false)
	public Object getFrom() {
		return from;
	}

	public void setFrom(Object from) {
		this.from = from;
	}

	@Basic
	@Column(name = "TO", nullable = false)
	public Object getTo() {
		return to;
	}

	public void setTo(Object to) {
		this.to = to;
	}

	@Basic
	@Column(name = "status", nullable = false)
	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CourtPaymentEntity that = (CourtPaymentEntity) o;
		return Objects.equals(courtid, that.courtid) &&
				Objects.equals(price, that.price) &&
				Objects.equals(from, that.from) &&
				Objects.equals(to, that.to) &&
				Objects.equals(status, that.status);
	}

	@Override
	public int hashCode() {
		return Objects.hash(courtid, price, from, to, status);
	}

	@OneToOne
	@JoinColumn(name = "courtid", referencedColumnName = "id", nullable = false)
	public CourtEntity getCourtByCourtid() {
		return courtByCourtid;
	}

	public void setCourtByCourtid(CourtEntity courtByCourtid) {
		this.courtByCourtid = courtByCourtid;
	}
}
