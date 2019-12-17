package src.presentation.contact;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import contacts.entities.Contact;
import contacts.services.ContactService;

/**
 * Classe permettant d'obtenir et de lier les informations enregistrées sur un contact avec son pk afin de les modifier.
 * 
 * 
 * @author GAMASSA Elise et ESPITIA Guillaume
 * @version 1.0
 * 
 */
/**
 * Servlet implementation class UpdateButton
 */
@WebServlet("/UpdateButton")
public class UpdateButton extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private ContactService contactservice;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateButton() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	/**
	 * Méthode permettant d'obtenir les informations sur un contact à l'aide de son
	 * identifiant unique.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long pk = Integer.parseInt(request.getParameter("pk"));
		Contact contactUpdate = contactservice.findContactById(pk);
		RequestDispatcher dispatcher = request.getRequestDispatcher("contact-update.jsp");
		request.setAttribute("contact", contactUpdate);
		dispatcher.forward(request, response);
	}

}
