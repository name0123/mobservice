/**
 *  author: 
 *  
CREATE TABLE valor
(
  valoration_id character varying(30),
  access boolean,
  wc boolean,
  elevator character varying(8),
  detail character varying(250),
	PRIMARY KEY (valoration_id)
)
 * 
 * 
 */
package com.pes.mob.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="valor")
public class Valoration {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String valoration_id;
	@Column
	private boolean access;
	@Column
	private boolean wc;
	@Column
	@Enumerated(EnumType.STRING)
	private Elev elevator;	
	@Column
	private String detail;

	
	@ManyToOne
	@JoinColumn(name="user_id",insertable=false, updatable=false)
	private User user;
	
	@ManyToOne
	@JoinColumn(name="four_id",insertable=false, updatable=false)
	private Place place;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	public enum Elev{
		HAS,HAS_NOT,NO_NEED
	}



	public String getValoration_id() {
		return valoration_id;
	}

	public void setValoration_id(String valoration_id) {
		this.valoration_id = valoration_id;
	}

	public boolean isAccess() {
		return access;
	}

	public void setAccess(boolean access) {
		this.access = access;
	}

	public boolean isWc() {
		return wc;
	}

	public void setWc(boolean wc) {
		this.wc = wc;
	}

	public Elev getElevator() {
		return elevator;
	}

	public void setElevator(Elev elevator) {
		this.elevator = elevator;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	
}
