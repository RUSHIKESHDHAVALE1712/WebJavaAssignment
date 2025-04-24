package com.bookshop.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.bookshop.entity.Book;
import com.bookshop.util.HibernateUtils;

import jakarta.persistence.NoResultException;

public class BookDao {

	public boolean save(Book book)
	{
		boolean status = false;
		try(SessionFactory factory = HibernateUtils.getSessionFactory();
				Session session = factory.openSession();) 
		{
			Transaction tx = session.beginTransaction();
			session.persist(book);
			tx.commit();
			status = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return status;
	}

	
	public static List<Book> findAll(){
		List<Book> books = null;
		
			try(SessionFactory factory = HibernateUtils.getSessionFactory();
					Session session = factory.openSession();) 
			{
				String hql = "select b from Book b";
				Query<Book> bookObjects = session.createQuery(hql,Book.class);
				books = bookObjects.list();
				
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return books;
		
	}
	
	public Book findByTitle(String title) {
		Book foundbook = null;
		try(SessionFactory factory = HibernateUtils.getSessionFactory();
				Session session = factory.openSession();) 
		{
			String hql = "select b from Book b where b.title= :bookTitle";
			foundbook= session.createQuery(hql,Book.class)
					.setParameter("bookTitle", title)
					.uniqueResult();
			
		}
		catch (BookNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return foundbook;
	}
}


