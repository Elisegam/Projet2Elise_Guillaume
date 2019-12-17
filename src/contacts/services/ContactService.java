package contacts.services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Singleton;

import contacts.dao.ContactDAO;
import contacts.entities.Contact;

/**
 * Classe permettant d'effectuer le lien entre la couche présentation et la
 * couche DAO.
 * 
 * 
 * @author GAMASSA Elise et ESPITIA Guillaume
 * @version 1.0
 * 
 */

@Singleton
public class ContactService {

	@EJB
	private ContactDAO contactDao;

	/**
	 * Méthode permettant de trouver un contact à partir de son identifiant unique.
	 * 
	 * @return
	 */
	public Contact findContactById(long pk) {
		return contactDao.find(pk);
	}

	/**
	 * Méthode permettant d'enregistrer un contact.
	 * 
	 */
	public long save(Contact contact) {
		contactDao.save(contact);
		return contact.getPk();
	}

	/**
	 * Méthode permettant de mettre à jour les informations sur un contact.
	 * 
	 */
	public long update(Contact contact) {
		contactDao.update(contact);
		return contact.getPk();
	}

	/**
	 * Méthode permettant de supprimer un contact
	 */
	public void supprimer(long pk) {
		contactDao.delete(pk);
	}

	/**
	 * Methode permettant d'obtenir une lsite de tous les contacts enregistrés.
	 */
	public List<Contact> getContacts() {
		return contactDao.getAllContact();
	}
}
