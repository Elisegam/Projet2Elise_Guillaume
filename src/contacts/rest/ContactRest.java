package contacts.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import contacts.entities.Contact;
import contacts.services.ContactService;

/**
 * Classe permettant de mettre en place l'architecture REST permettant de
 * construire des applications.
 * 
 * 
 * @author GAMASSA Elise et ESPITIA Guillaume
 * @version 1.0
 * 
 */

@Path("/contact")
public class ContactRest {

	@EJB
	private ContactService cs;

	/**
	 * Méthode permettant d'obtenir un contact à partir de son identifiant unique.
	 * 
	 * @return
	 */
	@GET
	@Path("id/{pk}")
	@Produces(MediaType.APPLICATION_JSON)
	public Contact getContact(@PathParam("pk") long pk) {
		return cs.findContactById(pk);
	}

	/**
	 * Méthode permettant de sauvegarder un contact.
	 * 
	 * @return
	 */
	@POST
	@Path("/new")
	@Consumes(MediaType.APPLICATION_JSON)
	public long save(Contact contact) {
		return cs.save(contact);
	}

	/**
	 * Méthode permettant de mettre à jour des informations sur un contact.
	 */
	@POST
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public void update(Contact contact) {
		cs.update(contact);
	}

	/**
	 * Méthode permettant de supprimer un contact.
	 */
	@POST
	@Path("/delete")
	@Consumes(MediaType.APPLICATION_JSON)
	public void delete(long pk) {
		cs.supprimer(pk);
	}

	/**
	 * Méthode permettant d'afficher tous les contacts enregistrés.
	 */
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Contact> getAllContact() {
		return cs.getContacts();
	}
}
