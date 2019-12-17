package src.presentation.contact;

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
import contacts.entities.Adresse;
import contacts.entities.Contact;
import contacts.services.ContactService;

/**
 * Classe permettant d'afficher dynamiquement les contacts au sein d'un serveur HTTP.
 * 
 * 
 * @author GAMASSA Elise et ESPITIA Guillaume
 * @version 1.0
 * 
 */

/**
 * Servlet implementation class ContactServlet
 */

@WebServlet("/ContactServlet")
public class ContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private ContactService contactservice;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	/**
	 * Méthode Post de la Servlet
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	/**
	 * Méthode permettant d'effectuer une requete qui permet au client de demander
	 * une ressource.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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

	/**
	 * Méthode pour afficher la liste des contacts enregistrés.
	 * 
	 * @param request
	 * @param response
	 * @throws SQLException
	 * @throws IOException
	 * @throws ServletException
	 */
	private void listContact(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Contact> listContact = contactservice.getContacts();
		request.setAttribute("listContact", listContact);
		RequestDispatcher dispatcher = request.getRequestDispatcher("contact-list.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * Méthode pour afficher un formulaire pour la création d'un nouveau formulaire.
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("contact-form.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * Méthode pour afficher un formulaire afin de modifier un contact.
	 * 
	 * @param request
	 * @param response
	 * @throws SQLException
	 * @throws ServletException
	 * @throws IOException
	 */
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		long pk = Integer.parseInt(request.getParameter("pk"));
		Contact contactUpdate = contactservice.findContactById(pk);
		RequestDispatcher dispatcher = request.getRequestDispatcher("contact-form.jsp");
		request.setAttribute("contact", contactUpdate);
		dispatcher.forward(request, response);

	}

	/**
	 * Méthode pour insérer un nouveau contact.
	 * 
	 * @param request
	 * @param response
	 * @throws SQLException
	 * @throws IOException
	 * @throws ServletException
	 */
	private void insertContact(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		String civilite = request.getParameter("civilite");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		String pays = request.getParameter("pays");
		Adresse adresse = new Adresse(rue, codePostal, ville, pays);
		Contact newContact =  new Contact(civilite, nom, prenom, adresse);
		contactservice.save(newContact);
		request.setAttribute("newContact", newContact);
		request.getRequestDispatcher("contact.jsp").forward(request, response);
	}

	/**
	 * M2thode pour modifier les informations sur un contact.
	 * 
	 * @param request
	 * @param response
	 * @throws SQLException
	 * @throws IOException
	 */
	private void updateContact(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int pk = Integer.parseInt(request.getParameter("pk"));
		String civilite = request.getParameter("civilite");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		Contact oldContact = new Contact(pk, civilite, nom, prenom);
		contactservice.update(oldContact);
		response.sendRedirect("list");
	}

	/**
	 * Méthode pour supprimer un contact.
	 * 
	 * @param request
	 * @param response
	 * @throws SQLException
	 * @throws IOException
	 */
	private void deleteContact(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		long pk = Integer.parseInt(request.getParameter("pk"));
		contactservice.supprimer(pk);
		response.sendRedirect("list");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

}
