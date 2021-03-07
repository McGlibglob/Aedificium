package com.aedificium.model.domain;
/*
 * The class book is an extension of the Item class.  The reason for this is that I might want to add other types of media
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "Book")
@Table(name="books")
public class Book extends Item{

//Attributes
	private static final long serialVersionUID = -5534894777658247569L;
	@Column(name="author")
	private String author = null;
	@Column(name="isbn")
	private String isbn = null;
	
	
//Constructors
	
	//Default
	public Book() {
	}



public Book(String title, int yearPublished, boolean checkedOut, 
		String author, String isbn, String stickerID) {
	super(title, yearPublished, checkedOut, stickerID);
	this.author = author;
	this.isbn = isbn;
}



//Methods

	//Getters
	public String getAuthor() {
		return author;
	}
	public String getIsbn() {
		return isbn;
	}
	
	//Setters
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Book [author=" + author + ", isbn=" + isbn + ", getTitle()=" + getTitle() + ", getYearPublished()="
				+ getYearPublished() + ", isCheckedOut()=" + isCheckedOut() + ", getStickerID()=" + getStickerID()
				+ "]";
	}

	

	
}