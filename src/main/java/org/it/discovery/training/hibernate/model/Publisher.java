package org.it.discovery.training.hibernate.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;

/**
 * Book publisher
 * @author morenets
 *
 */
@Entity 
@Table(name = "PUBLISHER")
public class Publisher extends BaseEntity {
	
	private List<Book> books;
	private int bookCount;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "publisher") 
	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Formula("(select count(book.id) FROM BOOKS book where book.publisher_id = id)")
	public int getBookCount() {
		return bookCount;
	}

	public void setBookCount(int bookCount) {
		this.bookCount = bookCount;
	}
	
	
	public void addBook(Book book) {
		if(books == null) {
			books = new ArrayList<>();
		}
		books.add(book);
		book.setPublisher(this);
	}
	
	

}
