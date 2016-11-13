package org.it.discovery.training.hibernate.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Book publisher
 * @author morenets
 *
 */
@Entity 
@Table(name = "PUBLISHER")
public class Publisher {
	private int id;
	
	private String name;
	
	private List<Book> books;

	@Id
	@Column(insertable=false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(columnDefinition="varchar(100)", nullable=false, insertable=true, updatable=true)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Transient 
	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

}
