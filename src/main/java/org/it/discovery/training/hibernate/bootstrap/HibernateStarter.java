package org.it.discovery.training.hibernate.bootstrap;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.it.discovery.training.hibernate.model.Publisher;
import org.it.discovery.training.hibernate.repository.PublisherRepository;
import org.it.discovery.training.hibernate.repository.impl.HibernatePublisherRepository;
import org.it.discovery.training.hibernate.util.HibernateUtil;

public class HibernateStarter {

	public static void main(String[] args) {
		Session session = null;
		try (SessionFactory factory = HibernateUtil.getSessionFactory()) {
			PublisherRepository repo = new HibernatePublisherRepository();
			Publisher publ = new Publisher();
			publ.setName("author");
			repo.save(publ);
			
			int publId = publ.getId();
			System.out.println(publId);
			repo.findById(publId);
			
			System.out.println(publId);
			repo.delete(publId);
	
			
			publId = publ.getId();
			System.out.println(publId);
			repo.findById(publId);
			
			
			factory.close();

		} catch (Exception ex) {
			if (session != null) {
				session.getTransaction().rollback();
			}
		}

	}

}