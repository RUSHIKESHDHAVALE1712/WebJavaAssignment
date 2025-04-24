package com.bookshop.service;

import java.util.Optional;

import com.bookshop.dao.AuthorDao;
import com.bookshop.dao.BookDao;
import com.bookshop.dao.BookNotFoundException;
import com.bookshop.entity.Author;
import com.bookshop.entity.Book;
import com.bookshop.exception.resourceAlreadyExistException;

public class BookService {

	private BookDao bookDao;
	private AuthorDao authorDao; 
	
	public BookService() {
		bookDao = new BookDao();
		authorDao = new AuthorDao();
	}

	public boolean addBook(Book newBook,String authorName, String authorEmail, String authorCountry)
	{
		//1.Validate Book with same name.
		
		Optional<Book> foundBook = BookDao.findAll().stream()
		.filter(book -> book.getTitle().equalsIgnoreCase(newBook.getTitle()))
		.findFirst();
		
		if(foundBook.isPresent())
		{
			throw new resourceAlreadyExistException("Book Already exist with same title");
		}
		
		//2.Search for author if author is new then save or author already exist in then link.
		
		Author foundAuthor = authorDao.findByNameAndEmail(authorName, authorEmail);
		if(foundAuthor == null)
		{
			Author newAuthor = new Author(0, authorName, authorEmail, authorCountry);
			boolean isSaved = authorDao.save(newAuthor);
			if(isSaved)
			{
				newBook.setAuthor(newAuthor);
			}
		}
		else
		{
			newBook.setAuthor(foundAuthor);
		}
		
		//3.save the book with author
		
		
		
		return bookDao.save(newBook);
	}
	public Book getBookByTitle(String title) {
		Book foundBook = bookDao.findByTitle(title);
		if(foundBook == null)
		{
			throw new BookNotFoundException("Book not found of Name");
		}
		return foundBook;
	}
}
