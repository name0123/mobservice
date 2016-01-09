/***
 * 	PLACE ENTITY
 * Table: PLACE
 * 	
create table place (
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
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
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
	
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy="place", cascade=CascadeType.ALL)
    private List<Valoration> placeValorations = new ArrayList<Valoration>();
	
	@JsonIgnore
	public List<Valoration> getPlaceValorations() {
		return placeValorations;
	}

	public void setPlaceValorations(List<Valoration> placeValorations) {
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
	
	/**
	 * Returns de adapted level of a place
	 * @return
	 */
	public AdaptedLevel getAdaptedLevel() {
		return adaptedLevel;
	}
	/**
	 * Sets adaptedLevel of a place after a new valoration of the place!
	 */
	public void setAdaptedLevel(){
        int iIsAccess = 0;
        int iIsNotAccess = 0;
        int iIsWc = 0;
        int iIsNotWc = 0;
        int iElevHas = 0;
        int iElevHasNot = 0;
        int iElevNoNeed = 0;
        for (int i = 0; i < placeValorations.size(); ++i){
            if (placeValorations.get(i).isAccess()) ++iIsAccess;
            else ++iIsNotAccess;
            if (placeValorations.get(i).isWc()) ++iIsWc;
            else ++iIsNotWc;
            if (placeValorations.get(i).getElevator().equals("HAS")) ++iElevHas;
            else if (placeValorations.get(i).getElevator().equals("HAS_NOT")) ++iElevHasNot;
            else ++iElevNoNeed;
        }
        if (iIsAccess > iIsNotAccess && iIsWc > iIsNotWc && ((iElevHas > iElevHasNot && iElevHas > iElevNoNeed) || (iElevNoNeed > iElevHas && iElevHasNot <= iElevNoNeed))) adaptedLevel = AdaptedLevel.TOTAL;
        else if (iIsAccess == iIsNotAccess || iIsWc == iIsNotWc || (iElevHas == iElevHasNot && iElevHas == iElevNoNeed)) adaptedLevel = AdaptedLevel.UNKNOWN;
        else if (iIsAccess < iIsNotAccess && iIsWc < iIsNotWc && ((iElevHasNot > iElevHas && iElevHasNot > iElevNoNeed))) adaptedLevel =AdaptedLevel.UNADAPTED;
        else adaptedLevel = AdaptedLevel.PARTIAL;
    }
}
