/**
 *  author: 
 *  
	create table valor(
	  valoration_id serial PRIMARY KEY,
	  user_id character varying(30) references fuser(user_id),
	  four_id character varying(30) references place(four_id),
	  access boolean,
	  wc boolean,
	  elevator character varying(8)
	  );
	 * 
 * 
 */
package com.pes.mob.model;

import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name="valor")
@JsonIgnoreProperties(ignoreUnknown = true) 
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
	
	
	private String user_id;
	private String four_id;
	
	@ManyToOne
	@JoinColumn(name="user_id",insertable=false, updatable=false)
	private User user;
	
	@ManyToOne
	@JoinColumn(name="four_id",insertable=false, updatable=false)
	private Place place;
	public Valoration(){}
	

	public Valoration(boolean access, boolean wc, Elev elevator, String user_id, String four_id) {
		super();
		this.access = access;
		this.wc = wc;
		this.elevator = elevator;
		this.user_id = user_id;
		this.four_id = four_id;
	}

	public enum Elev{
		HAS,HAS_NOT,NO_NEED
	}
	
	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public String getFour_id() {
		return four_id;
	}

	public void setFour_id(String four_id) {
		this.four_id = four_id;
	}
	
	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
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

	@Override
	public String toString(){
		return "valoration: id = " +valoration_id+ " user_id:"+"nouseryet"+" place:" + four_id;
	}
	
}
