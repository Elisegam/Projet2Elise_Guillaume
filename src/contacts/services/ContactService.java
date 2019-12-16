package contacts.services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Singleton;

import contacts.dao.ContactDAO;
import contacts.entities.Contact;

@Singleton
public class ContactService {

	@EJB
	private ContactDAO contactDao;
	
	public Contact findContactById(long pk) {
		return contactDao.find(pk);
	}
	
	public long save(Contact contact) {
		contactDao.save(contact);
		return contact.getPk();
	}
	
	public long update(Contact contact) {
		contactDao.update(contact);
		return contact.getPk();
	}
	
	public void supprimer(Contact contact) {
		contactDao.delete(contact);
	}
	
	public List<String> getContacts(){
		return contactDao.getAllContact();
	}
}

