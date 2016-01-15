package com.pes.mob.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.pes.mob.model.Valoration.Elev;

@JsonIgnoreProperties(ignoreUnknown = true) 
public class ValorLatLong{
	private String uid;
	private Double lat;
	private Double lng;
	private Boolean ac;
	private Boolean wc;
	private Elev el;
	
	public ValorLatLong(){}
	public Double getLat() {
		return lat;
	}
	public void setLat(Double lat) {
		this.lat = lat;
	}
	public Double getLng() {
		return lng;
	}
	public void setLng(Double lng) {
		this.lng = lng;
	}
	public Boolean getAc() {
		return ac;
	}
	public void setAc(Boolean ac) {
		this.ac = ac;
	}
	public Boolean getWc() {
		return wc;
	}
	public void setWc(Boolean wc) {
		this.wc = wc;
	}
	public Elev getEl() {
		return el;
	}
	public void setEl(Elev el) {
		this.el = el;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
}
