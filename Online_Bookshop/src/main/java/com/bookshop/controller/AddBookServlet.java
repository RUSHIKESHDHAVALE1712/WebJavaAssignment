package com.bookshop.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.bookshop.entity.Book;
import com.bookshop.service.BookService;

/**
 * Servlet implementation class AddBookServlet
 */
@WebServlet("/addBook")
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String title = request.getParameter("title");
		double price = Double.parseDouble(request.getParameter("price"));
		int pubYear = Integer.parseInt(request.getParameter("year"));
		
		String authName = request.getParameter("name");
		String authEmail = request.getParameter("email");
		String authCountry = request.getParameter("country");
		
		try {
			Book newBook = new Book(0, title, price, pubYear, null);
			boolean isAdded = new BookService().addBook(newBook, authName, authEmail, authCountry);
			if(isAdded)
			{
				out.println("<h1 style='color:green'>Book Added Successfully!!</h1>");
			}
			else
			{
				out.println("<h1 style='color:red'>Unable to Add Book!!</h1>");
			}
			
		} catch (Exception e) {
			out.println("<h1 style='color:red'>"+e.getMessage()+"</h1>");
		}
		
	}

}
