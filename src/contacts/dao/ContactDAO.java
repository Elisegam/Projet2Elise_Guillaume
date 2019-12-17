package contacts.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import contacts.entities.Contact;

/**
 * Classe r�alisant la sauvegarde des donn�es dans la DAO.
 * 
 * 
 * @author GAMASSA Elise et ESPITIA Guillaume
 * @version 1.0
 * 
 */

@Singleton
public class ContactDAO {
	@PersistenceContext(name = "contacts")
	private EntityManager em;

	/**
	 * M�thode pour la sauvegarde des contacts
	 */
	public void save(Contact contact) {
		em.persist(contact);
	}

	/**
	 * M�thode permettant de retrouver un contact � partir de son identifiant
	 * unique.
	 * 
	 */
	public Contact find(long pk) {
		return em.find(Contact.class, pk);
	}

	/**
	 * M�thode permettant de mettre � jour les donn�es enregistr�es sur un contact.
	 */
	public void update(Contact contact) {
		em.merge(contact);
	}

	/**
	 * M�thode permettant de supprimer un contact.
	 */
	public long delete(long pk) {
		Contact c = em.find(Contact.class, pk);
		em.remove(c);
		return c.getPk();
	}

	/**
	 * M�thode afin d'obtenir une liste de tous les contacts enregistr�s.
	 */
	public List<Contact> getAllContact() {
		List<Contact> contacts = new ArrayList<Contact>();
		contacts = em.createNamedQuery("Contact.nom", Contact.class).getResultList();
		return contacts;
	}
}