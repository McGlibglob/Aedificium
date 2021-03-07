package com.aedificium.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="borrowers")
public class Borrower extends Googler{



	private static final long serialVersionUID = -6164232675981336155L;

	public Borrower() {
		super();
	}
	
	public Borrower(String ldap, String badgeId, String firstName, String lastName) {
		setLdap(ldap); // Try to use "set" methods from super class
		setBadgeId(badgeId);
		setFirstName(firstName);
		setLastName(lastName);
	}

	@Override
	public String toString() {
		return "Borrower [getLdap()=" + getLdap() + ", getBadgeId()=" + getBadgeId() + ", getFirstName()="
				+ getFirstName() + ", getLastName()=" + getLastName() + "]";
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

}
