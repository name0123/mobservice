/***
 *  USER ENTITY
 *  connection to database, 
 *  table = MUSER - user is reserved!
 *  test
 * 
 */
package com.pes.mob.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="fuser")
public class User {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private String user_id; //e-mail o facebook id
	@Column
	private String userN;
	@Column
    private String name;
    @Column
    private String surname;
    @Column
    private String password;
    @Column
    private String photopath;
    
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhotopath() {
		return photopath;
	}
	public void setPhotopath(String photopath) {
		this.photopath = photopath;
	}
    public String getUserN() {
		return userN;
	}
	public void setUserN(String userN) {
		this.userN = userN;
	}
}
