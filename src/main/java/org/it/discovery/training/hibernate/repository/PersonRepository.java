package org.it.discovery.training.hibernate.repository;

import java.util.List;

import org.it.discovery.training.hibernate.model.Person;

public interface PersonRepository {
	
	/**
	 * Returns all the persons that haven't written books
	 * @return
	 */
	List<Person> findPersonWithoutBooks();
	
	/**
	 * Returns all the persons that have written exactly number of books
	 * @param number
	 * @return
	 */
	List<Person> findPersonWithBooks(int number);
	

}
