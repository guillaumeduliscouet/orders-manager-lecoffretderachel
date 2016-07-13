package com.lecoffretderachel.ordersmanager.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lecoffretderachel.ordersmanager.model.Tag;

@Repository("tagDAO")
public class TagDAOImpl implements TagDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public void persist(Tag tag) {
		sessionFactory.getCurrentSession().persist(tag);
	}

	public List listAll() {
		return sessionFactory.getCurrentSession().createQuery("from Tag").list();
	}

	public Tag findById(Integer id) {
		return (Tag) sessionFactory.getCurrentSession().get(Tag.class, id);
	}

	public void update(Tag tag) {
		sessionFactory.getCurrentSession().update(tag);
	}
	
	public void delete(Tag tag) {
		sessionFactory.getCurrentSession().delete(tag);
	}
}