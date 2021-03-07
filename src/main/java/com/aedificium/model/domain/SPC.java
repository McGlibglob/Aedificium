package com.aedificium.model.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SPC implements Serializable {


	private static final long serialVersionUID = -966969311534458760L;
	
	Logger logger = LogManager.getLogger();
	
	//ATTRIBUTES
	
	// Collections
	
	private Map<String, Borrower> borrowers = new HashMap<String, Borrower>();
	
	private Map<String, Book> books = new HashMap<String, Book>();
	
	private Map<String, Librarian> librarians = new HashMap<String, Librarian>();
	
	private Map<String, Checkout> checkouts = new HashMap <String, Checkout>();
	
	//Default Constructor
	
	public SPC() {
		
		//A librarian is required for things to work down the road.
		Librarian initialLibrarian = new Librarian("initial", "123456", "Stand", "In");
		if (librarians == null)
			addLibrarian(initialLibrarian);
	}
	
	//METHODS
	
	//Add Methods
	
	public void addBook (Book book) {
		books.put(book.getStickerID(), book);
		logger.trace(book.getTitle() + " added to books collection.");
	}
	
	public void addBorrower (Borrower borrower) {
		borrowers.put(borrower.getBadgeId(), borrower);
		logger.trace(borrower.getLdap() + " added to borrowers collection.");
	}
	
	public void addLibrarian (Librarian librarian) {
		librarians.put(librarian.getBadgeId(), librarian);
		logger.trace(librarian.getLdap() + " added to librarians collection.");
	}
	
	public void addCheckout (Checkout checkout) {
		checkouts.put(checkout.getBookSticker(), checkout);
		logger.trace(checkout.getBorrower().getLdap() + " checkout of " +
				checkout.getBookTitle() + " added to checkouts collection.");
	}
	
	//Exists Methods
	
	public boolean bookExists (Book book) {
		boolean exists = books.containsKey(book.getStickerID());
		return exists;
	}
	
	public boolean borrowerExists (Borrower borrower) {
		boolean exists = borrowers.containsKey(borrower.getBadgeId());
		return exists;
	}
	
	public boolean librarianExists (Librarian librarian) {
		boolean exists = librarians.containsKey(librarian.getBadgeId());
		return exists;
	}
	
	public boolean checkoutExists (Book book) {
		boolean exists = checkouts.containsKey(book.getStickerID());
		return exists;
	}
	
	//Get Methods
	
	public Book getBook(String stickerID) {
		Book book = books.get(stickerID);
		return book;
	}
	
	public Borrower getBorrower(String badgeID) {
		Borrower borrower = borrowers.get(badgeID);
		return borrower;
	}
	
	public Librarian getLibrarian(String badgeID) {
		Librarian librarian = librarians.get(badgeID);
		return librarian;
	}
	
	public Checkout getCheckout(String stickerID) {
		Checkout checkout = checkouts.get(stickerID);
		return checkout;
	}
	
	//Remove Methods
	
	public void removeBook(String stickerID) {
		books.remove(stickerID);
	}
	
	public void removeBorrower(String borrowerId) {
		borrowers.remove(borrowerId);
	}
	
	public void removeLibrarian(String librarianId) {
		librarians.remove(librarianId);
	}
	
	public void removeCheckout(String stickerID) {
		checkouts.remove(stickerID);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((books == null) ? 0 : books.hashCode());
		result = prime * result + ((borrowers == null) ? 0 : borrowers.hashCode());
		result = prime * result + ((checkouts == null) ? 0 : checkouts.hashCode());
		result = prime * result + ((librarians == null) ? 0 : librarians.hashCode());
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
		SPC other = (SPC) obj;
		if (books == null) {
			if (other.books != null)
				return false;
		} else if (!books.equals(other.books))
			return false;
		if (borrowers == null) {
			if (other.borrowers != null)
				return false;
		} else if (!borrowers.equals(other.borrowers))
			return false;
		if (checkouts == null) {
			if (other.checkouts != null)
				return false;
		} else if (!checkouts.equals(other.checkouts))
			return false;
		if (librarians == null) {
			if (other.librarians != null)
				return false;
		} else if (!librarians.equals(other.librarians))
			return false;
		return true;
	}
	
	//Librarians are required to function down the line.
	public boolean validate() {
		if (librarians == null)
			return false;
		else
			return true;
	}

}
