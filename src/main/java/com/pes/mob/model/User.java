/***
 *  USER ENTITY
 *  connection to database, 
 *  table = MUSER - user is reserved!
 *  test
 * 
 */
package com.pes.mob.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
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
    
    @OneToMany
    @JoinTable(name="user_valoration",joinColumns=@JoinColumn(name="user_id"),
    			inverseJoinColumns=@JoinColumn(name="valoration_id")
    		)
    private Collection<Valoration> userValorations = new ArrayList<Valoration>();
    
    

	public Collection<Valoration> getUserValorations() {
		return userValorations;
	}
	public void setUserValorations(Collection<Valoration> userValorations) {
		this.userValorations = userValorations;
	}
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
