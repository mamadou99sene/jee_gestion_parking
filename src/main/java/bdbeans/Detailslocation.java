package bdbeans;
// Generated 2 nov. 2022, 16:22:46 by Hibernate Tools 4.3.6.Final

import java.math.BigInteger;
import java.util.Date;

/**
 * Detailslocation generated by hbm2java
 */
public class Detailslocation implements java.io.Serializable {

	private DetailslocationId id;
	private Place place;
	private Reservation reservation;
	private Date datedebut;
	private Date datefin;
	private BigInteger montant;

	public Detailslocation() {
	}

	public Detailslocation(DetailslocationId id, Place place, Reservation reservation) {
		this.id = id;
		this.place = place;
		this.reservation = reservation;
	}

	public Detailslocation(DetailslocationId id, Place place, Reservation reservation, Date datedebut, Date datefin,
			BigInteger montant) {
		this.id = id;
		this.place = place;
		this.reservation = reservation;
		this.datedebut = datedebut;
		this.datefin = datefin;
		this.montant = montant;
	}

	public DetailslocationId getId() {
		return this.id;
	}

	public void setId(DetailslocationId id) {
		this.id = id;
	}

	public Place getPlace() {
		return this.place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	public Reservation getReservation() {
		return this.reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public Date getDatedebut() {
		return this.datedebut;
	}

	public void setDatedebut(Date datedebut) {
		this.datedebut = datedebut;
	}

	public Date getDatefin() {
		return this.datefin;
	}

	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}

	public BigInteger getMontant() {
		return this.montant;
	}

	public void setMontant(BigInteger montant) {
		this.montant = montant;
	}

}
