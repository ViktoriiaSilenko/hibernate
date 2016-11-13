package org.it.discovery.training.hibernate.bootstrap;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.it.discovery.training.hibernate.model.Book;
import org.it.discovery.training.hibernate.model.Person;
import org.it.discovery.training.hibernate.model.Publisher;
import org.it.discovery.training.hibernate.repository.PersonRepository;
import org.it.discovery.training.hibernate.repository.PublisherRepository;
import org.it.discovery.training.hibernate.repository.impl.HibernatePublisherRepository;
import org.it.discovery.training.hibernate.repository.impl.PersonRepositoryImpl;
import org.it.discovery.training.hibernate.util.HibernateUtil;

public class HibernateStarter {

	public static void main(String[] args) {
		Session session = null;
		try (SessionFactory factory = HibernateUtil.getSessionFactory()) {
			PublisherRepository repo = new HibernatePublisherRepository();
			Publisher publ = new Publisher();
			publ.setName("author");
			
			Book book = new Book();
			book.setName("aaa");
			publ.addBook(book);
			repo.save(publ);
			
			int publId = publ.getId();
			System.out.println(publId);
			publ = repo.findById(publId);
			
			System.out.println("publ.getBookCount() = " + publ.getBookCount());
			
			
			PersonRepository repo2 = new PersonRepositoryImpl();
			System.out.println("repo2.findPersonWithoutBooks() = " + repo2.findPersonWithoutBooks().size());
			
			/*Person p = new Person();
			p.setName("vika");
			List<Book> books = new ArrayList<>();
			books.add(book);
			p.setBooks(books);*/
			//repo2.s
			
			System.out.println("repo2.findPersonWithBooks(0) = " + repo2.findPersonWithBooks(0).size());
			
		
			
			/*System.out.println(publId);
			repo.delete(publId);
	
			
			publId = publ.getId();
			System.out.println(publId);
			repo.findById(publId);*/
			
			
			factory.close();

		} catch (Exception ex) {
			if (session != null) {
				session.getTransaction().rollback();
				System.out.println(ex.getStackTrace());
			}
		}

	}

}
