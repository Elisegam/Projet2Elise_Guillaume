package contacts.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import contacts.entities.Contact;

/**
 * Classe réalisant la sauvegarde des données dans la DAO.
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
	 * Méthode pour la sauvegarde des contacts
	 */
	public void save(Contact contact) {
		em.persist(contact);
	}

	/**
	 * Méthode permettant de retrouver un contact à partir de son identifiant
	 * unique.
	 * 
	 */
	public Contact find(long pk) {
		return em.find(Contact.class, pk);
	}

	/**
	 * Méthode permettant de mettre à jour les données enregistrées sur un contact.
	 */
	public void update(Contact contact) {
		em.merge(contact);
	}

	/**
	 * Méthode permettant de supprimer un contact.
	 */
	public long delete(long pk) {
		Contact c = em.find(Contact.class, pk);
		em.remove(c);
		return c.getPk();
	}

	/**
	 * Méthode afin d'obtenir une liste de tous les contacts enregistrés.
	 */
	public List<Contact> getAllContact() {
		List<Contact> contacts = new ArrayList<Contact>();
		contacts = em.createNamedQuery("Contact.nom", Contact.class).getResultList();
		return contacts;
	}
}