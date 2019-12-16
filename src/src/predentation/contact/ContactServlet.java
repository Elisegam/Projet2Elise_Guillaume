package src.predentation.contact;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import contacts.dao.ContactDAO;
import contacts.entities.Contact;
import contacts.services.ContactService;

/**
 * Servlet implementation class ContactServlet
 */
@WebServlet("/ContactServlet")
public class ContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      @EJB private ContactService contactservice;
    /**
     * @see HttpServlet#HttpServlet()
     */
      
       
   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   			doGet(request, response);
   		}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertContact(request, response);
				break;
			case "/delete":
				deleteContact(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateContact(request, response);
				break;
			default:
				listContact(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	
	
	private void listContact(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Contact>  listContact = contactservice.getContacts();
		request.setAttribute("listContact", listContact);
		RequestDispatcher dispatcher = request.getRequestDispatcher("contact-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("contact-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		long pk = Integer.parseInt(request.getParameter("pk"));
		Contact contactUpdate = contactservice.findContactById(pk);
		RequestDispatcher dispatcher = request.getRequestDispatcher("contact-form.jsp");
		request.setAttribute("contact", contactUpdate);
		dispatcher.forward(request, response);

	}

	private void insertContact(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String civilite = request.getParameter("civilite");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		Contact newContact = new Contact(civilite, nom, prenom);
		contactservice.save(newContact);
		response.sendRedirect("contact-list.jsp");
	}

	private void updateContact(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int pk = Integer.parseInt(request.getParameter("p"));
		String civilite = request.getParameter("civilite");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		Contact oldContact = new Contact(pk,civilite, nom, prenom);
		contactservice.update(oldContact);
		response.sendRedirect("list");
	}

	private void deleteContact(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		long pk = Integer.parseInt(request.getParameter("pk"));
		contactservice.supprimer(pk);
		response.sendRedirect("list");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */


}
