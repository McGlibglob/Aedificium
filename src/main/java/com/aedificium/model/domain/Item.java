package com.aedificium.model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Item implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8759761986788593955L;
	@Column(name="title")
	private String title = null;
	@Column(name="yearPublished")
	private int yearPublished = 0;
	@Column(name="checkedOut")
	private boolean checkedOut = false;
	@Id
	@Column(name="stickerID")
	private String stickerID = null;

	
	//Default Constructor
	public Item() {
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (checkedOut ? 1231 : 1237);
		result = prime * result + ((stickerID == null) ? 0 : stickerID.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + yearPublished;
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
		Item other = (Item) obj;
		if (checkedOut != other.checkedOut)
			return false;
		if (stickerID == null) {
			if (other.stickerID != null)
				return false;
		} else if (!stickerID.equals(other.stickerID))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (yearPublished != other.yearPublished)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Item [title=" + title + ", yearPublished=" + yearPublished + ", checkedOut=" + checkedOut
				+ ", stickerID=" + stickerID + "]";
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public String getTitle() {
		return title;
	}


	public int getYearPublished() {
		return yearPublished;
	}


	public boolean isCheckedOut() {
		return checkedOut;
	}


	public String getStickerID() {
		return stickerID;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public void setYearPublished(int yearPublished) {
		this.yearPublished = yearPublished;
	}


	public void setCheckedOut(boolean checkedOut) {
		this.checkedOut = checkedOut;
	}


	public void setStickerID(String stickerID) {
		this.stickerID = stickerID;
	}


	public Item(String title, int yearPublished, boolean checkedOut, String stickerID) {
		super();
		this.title = title;
		this.yearPublished = yearPublished;
		this.checkedOut = checkedOut;
		this.stickerID = stickerID;
	}


	//Validate Method
	public boolean validate() {
		if (title == null || yearPublished == 0 || stickerID == null)
			return false;
		else
			return true;
	}

	
}
