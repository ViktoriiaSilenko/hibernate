package org.it.discovery.training.hibernate.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Person who can write books, for example
 * @author admin
 *
 */

@Entity 
@Table(name = "PERSON")
public class Person extends BaseEntity {
	
	/**
	 * Books that person has written
	 */
	private List<Book> books;

	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, orphanRemoval = true, mappedBy="author")
	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
}
