/**
 *  author: 
 *  
 * create table valor (
 * 	valoration_id varchar(30)
	user_id varchar(30) references fuser(user_id),
	four_id varchar(30) references place(four_id),
	access boolean,
	wc boolean,
	elevator VARCHAR(8),
	detail VARCHAR(250),
	PRIMARY KEY (user_id, four_id)
);
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
import javax.persistence.Table;

@Entity
@Table(name="valor")
public class Valoration {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String valoration_id;
	@Column
	private String user_id;
	@Column
	private String four_id;
	@Column
	private boolean access;
	@Column
	private boolean wc;
	@Column
	@Enumerated(EnumType.STRING)
	private Elev elevator;	
	@Column
	private String detail;
	
	public enum Elev{
		HAS,HAS_NOT,NO_NEED
	}



	public String getValoration_id() {
		return valoration_id;
	}

	public void setValoration_id(String valoration_id) {
		this.valoration_id = valoration_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getFour_id() {
		return four_id;
	}

	public void setFour_id(String four_id) {
		this.four_id = four_id;
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
