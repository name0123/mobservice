/***
 * 	PLACE ENTITY
 * Table: MPLACE
 * 	
create table mplace (
	id serial,
	name VARCHAR(40),
	latitude decimal,
	longitude decimal,
	stars INT,
	description VARCHAR(200),
	type VARCHAR(20),
	PRIMARY KEY (id)
);
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
@Table(name="place")
public class Place {
	@Id
	@Column
	private String four_id;
	@Column
	private String name;
	@Column
	private Double latitude;
	@Column
	private Double longitude;
	@Column
	private String category;
	@Column
	@Enumerated(EnumType.STRING)
	private AdaptedLevel adaptedLevel;	
	
	public enum AdaptedLevel {
	    UNKNOWN, UNADAPTED, PARTIAL, TOTAL
	}

	public Place(){}
	
	public Place(String four_id, String name, Double lat, Double lng){
		this.four_id = four_id;
		this.name = name;
		this.latitude = lat;
		this.longitude = lng;
	}

	public String getFour_id() {
		return four_id;
	}

	public void setFour_id(String four_id) {
		this.four_id = four_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public AdaptedLevel getAdaptedLevel() {
		return adaptedLevel;
	}

	public void setAdaptedLevel(AdaptedLevel adaptedLevel) {
		this.adaptedLevel = adaptedLevel;
	}
	
}
