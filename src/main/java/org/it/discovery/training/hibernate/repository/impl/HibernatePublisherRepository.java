package org.it.discovery.training.hibernate.repository.impl;

import org.hibernate.Session;
import org.it.discovery.training.hibernate.model.Publisher;
import org.it.discovery.training.hibernate.repository.PublisherRepository;
import org.it.discovery.training.hibernate.util.HibernateUtil;

public class HibernatePublisherRepository implements PublisherRepository {

	@Override
	public void save(Publisher publisher) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		session.beginTransaction();
		session.save(publisher);
		session.getTransaction().commit();
		System.out.println(publisher.getId());
		
		//HibernateUtil.getSessionFactory().close(); - in Starter
		
	}

	@Override
	public void delete(int publisherId) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		session.beginTransaction();
		session.delete(session.get(Publisher.class, publisherId));
		//session.update(publisher);
		session.getTransaction().commit();
		
	}

	@Override
	public Publisher findById(int publisher) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		session.beginTransaction();
		Publisher publ = session.get(Publisher.class, publisher);
		
		
		session.getTransaction().commit();
		
		return publ;
	}

}
