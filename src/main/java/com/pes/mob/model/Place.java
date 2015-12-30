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


import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name="place")
@JsonIgnoreProperties(ignoreUnknown = true)
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
	
	@JsonIgnore
	@OneToMany
    private Collection<Valoration> placeValorations = new ArrayList<Valoration>();
	
	public Collection<Valoration> getPlaceValorations() {
		return placeValorations;
	}

	public void setPlaceValorations(Collection<Valoration> placeValorations) {
		this.placeValorations = placeValorations;
	}

	public enum AdaptedLevel {
	    UNKNOWN, UNADAPTED, PARTIAL, TOTAL
	}

	public Place(){}
	
	public Place(String four_id, String name, Double lat, Double lng, String category){
		this.four_id = four_id;
		this.name = name;
		this.latitude = lat;
		this.longitude = lng;
		this.category = category;
		this.adaptedLevel = AdaptedLevel.UNKNOWN;
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
