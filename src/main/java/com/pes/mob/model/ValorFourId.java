package com.pes.mob.model;


import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import com.pes.mob.model.Valoration.Elev;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ValorFourId {

		private String uid;
		private String four_id;
		private Boolean ac;
		private Boolean wc;
		private Elev el;
		
		public ValorFourId() {
		}
	
		public String getFour_id() {
			return four_id;
		}

		public void setFour_id(String four_id) {
			this.four_id = four_id;
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

