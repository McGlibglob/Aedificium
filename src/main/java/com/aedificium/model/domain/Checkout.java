package com.aedificium.model.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity(name="Checkout")
@Table(name="checkouts")
public class Checkout implements Serializable{


	private static final long serialVersionUID = -1318943891286157477L;
	
	private Book book;
	private Borrower borrower;
	
	@Column(name="dueDate")
	private LocalDate dueDate;
	
	@Column(name="overdue")
	private boolean overdue;
	
	@Column(name="bookTitle")
	private String bookTitle;
	
	@Id
	@Column(name="bookSticker")
	private String bookSticker;
	
	@Column(name="borrowerLdap")
	private String borrowerLdap;
	
	
	//Default constructor
	public Checkout() {
		
	}
	
	//Constructor with arguments
	public Checkout(Book book, Borrower borrower, LocalDate dueDate, boolean overdue) {
		this.book = book;
		this.borrower = borrower;
		this.dueDate = dueDate;
		this.overdue = overdue;
		this.bookTitle = book.getTitle();
		this.setBookSticker(book.getStickerID());
		this.setBorrowerLdap(borrower.getLdap());
	}

	public boolean isOverdue() {
		return overdue;
	}

	public void setOverdue(boolean overdue) {
		this.overdue = overdue;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Borrower getBorrower() {
		return borrower;
	}

	public void setBorrower(Borrower borrower) {
		this.borrower = borrower;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	
	public String getBookSticker() {
		return bookSticker;
	}

	public void setBookSticker(String bookSticker) {
		this.bookSticker = bookSticker;
	}
	
	
	public String getBorrowerLdap() {
		return borrowerLdap;
	}

	public void setBorrowerLdap(String borrowerLdap) {
		this.borrowerLdap = borrowerLdap;
	}

	public boolean validate() {
		if (book == null || borrower == null ||  dueDate == null)
			return false;
		else
			return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((book == null) ? 0 : book.hashCode());
		result = prime * result + ((bookSticker == null) ? 0 : bookSticker.hashCode());
		result = prime * result + ((bookTitle == null) ? 0 : bookTitle.hashCode());
		result = prime * result + ((borrower == null) ? 0 : borrower.hashCode());
		result = prime * result + ((borrowerLdap == null) ? 0 : borrowerLdap.hashCode());
		result = prime * result + ((dueDate == null) ? 0 : dueDate.hashCode());
		result = prime * result + (overdue ? 1231 : 1237);
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
		Checkout other = (Checkout) obj;
		if (book == null) {
			if (other.book != null)
				return false;
		} else if (!book.equals(other.book))
			return false;
		if (bookSticker == null) {
			if (other.bookSticker != null)
				return false;
		} else if (!bookSticker.equals(other.bookSticker))
			return false;
		if (bookTitle == null) {
			if (other.bookTitle != null)
				return false;
		} else if (!bookTitle.equals(other.bookTitle))
			return false;
		if (borrower == null) {
			if (other.borrower != null)
				return false;
		} else if (!borrower.equals(other.borrower))
			return false;
		if (borrowerLdap == null) {
			if (other.borrowerLdap != null)
				return false;
		} else if (!borrowerLdap.equals(other.borrowerLdap))
			return false;
		if (dueDate == null) {
			if (other.dueDate != null)
				return false;
		} else if (!dueDate.equals(other.dueDate))
			return false;
		if (overdue != other.overdue)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Checkout [book=" + book + ", borrower=" + borrower + ", dueDate=" + dueDate + ", overdue=" + overdue
				+ ", bookTitle=" + bookTitle + ", bookSticker=" + bookSticker + ", borrowerLdap=" + borrowerLdap + "]";
	}





}
