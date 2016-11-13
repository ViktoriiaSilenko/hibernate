package org.it.discovery.training.hibernate.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.it.discovery.training.hibernate.model.Person;
import org.it.discovery.training.hibernate.repository.PersonRepository;
import org.it.discovery.training.hibernate.util.HibernateUtil;

public class PersonRepositoryImpl implements PersonRepository {

	@Override
	public List<Person> findPersonWithoutBooks() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Person.class);
		criteria.add(Restrictions.isEmpty("books"));
		return criteria.list();
		
		
		/*criteria.setProjection(Projections.projectionList().add(Projections.rowCount())
				.add(Projections.i))*/
	}

	@Override
	public List<Person> findPersonWithBooks(int number) {
		// TODO Auto-generated method stub
		return null;
	}

}
