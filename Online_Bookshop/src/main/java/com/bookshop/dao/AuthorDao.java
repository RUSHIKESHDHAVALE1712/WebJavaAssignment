package com.bookshop.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.bookshop.entity.Author;
import com.bookshop.util.HibernateUtils;

public class AuthorDao {

	public boolean save(Author author)
	{
		boolean status = false;
		try(SessionFactory factory = HibernateUtils.getSessionFactory();
				Session session = factory.openSession();) 
		{
			Transaction tx = session.beginTransaction();
			session.persist(author);
			tx.commit();
			status = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return status;
	}
	public Author findByNameAndEmail(String name,String email){
		Author foundAuthor = null;
			try(SessionFactory factory = HibernateUtils.getSessionFactory();
					Session session = factory.openSession();) 
			{
				String hql = "select a from Author a where a.name = :authName and a.email = :authEmail";
				foundAuthor = session.createQuery(hql,Author.class)
						.setParameter("authName", name)
						.setParameter("authEmail", email)
						.uniqueResult();
				
				
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return foundAuthor;
		
	}
}
