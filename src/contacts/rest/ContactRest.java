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

@Path("/contact")
public class ContactRest {

	@EJB
	private ContactService cs;

	@GET
	@Path("id/{pk}")
	@Produces(MediaType.APPLICATION_JSON)
	public Contact getContact(@PathParam("pk") long pk) {
		return cs.findContactById(pk);
	}

	@POST
	@Path("/new")
	@Consumes(MediaType.APPLICATION_JSON)
	public long save(Contact contact) {
		return cs.save(contact);
	}

	@POST
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public void update(Contact contact) {
		cs.update(contact);
	}

	@POST
	@Path("/delete")
	@Consumes(MediaType.APPLICATION_JSON)
	public void delete(Contact contact) {
		cs.supprimer(contact);
	}

	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> getAllContact() {
		return cs.getContacts();
	}
}
