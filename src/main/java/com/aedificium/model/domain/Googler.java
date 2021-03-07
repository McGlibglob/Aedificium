package com.aedificium.model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

import javax.persistence.MappedSuperclass;


@MappedSuperclass
public abstract class Googler implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 97349436887009667L;
	
	@Id
	@Column(name="badgeId")
	private String badgeId = null;  //this will be a string that is retrieved from a badge id scanner.  I think it is hexadecimal.
	@Column(name="ldap")
	private String ldap = null;
	@Column(name="firstName")
	private String firstName = null;
	@Column(name="lastName")
	private String lastName = null;
	
	//Default Constructor 
	public Googler() {
	}
	
	
	//Constructor with attributes
	public Googler(String ldap, String badgeId, String firstName, String lastName) {
		this.ldap = ldap;
		this.badgeId = badgeId;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	
	/*  All the getters
	 * 
	 */
	public String getLdap() {
		return ldap;
	}

	public String getBadgeId() {
		return badgeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	/*
	 * All the setters
	 */
	public void setLdap(String ldap) {
		this.ldap = ldap;
	}

	public void setBadgeId(String badgeId) {
		this.badgeId = badgeId;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	
	
	//Create a validate method.  Make it boolean.  Only returns true if data is validated.
	
	public boolean validate() {
		// Create a check for each attribute which returns a false if the value is no null (All strings).  If all the 'If' statements fail, true is returned.
		if (ldap == null || badgeId == null || firstName == null || lastName == null) return false;
		
		else
			return true;
	}


	@Override
	public String toString() {
		return "Googler [ldap=" + ldap + ", badgeId=" + 
				badgeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((badgeId == null) ? 0 : badgeId.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((ldap == null) ? 0 : ldap.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Googler other = (Googler) obj;
		if (badgeId == null) {
			if (other.badgeId != null)
				return false;
		} else if (!badgeId.equals(other.badgeId))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (ldap == null) {
			if (other.ldap != null)
				return false;
		} else if (!ldap.equals(other.ldap))
			return false;
		return true;
	}
	
	
}
