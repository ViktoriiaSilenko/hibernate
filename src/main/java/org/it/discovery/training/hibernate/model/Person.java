package org.it.discovery.training.hibernate.model;

import java.util.List;

/**
 * Person who can write books, for example
 * @author admin
 *
 */
public class Person {
	private int id;
	
	private String name;
	
	/**
	 * Books that person has written
	 */
	private List<Book> books;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
}
