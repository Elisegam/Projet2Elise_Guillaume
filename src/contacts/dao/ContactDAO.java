package contacts.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import contacts.entities.Contact;

@Singleton
public class ContactDAO {
	@PersistenceContext(name = "contacts") private EntityManager em;
	
	public void save(Contact contact) {
		em.persist(contact);
	}
	
	public Contact find(long pk) {
		return em.find(Contact.class, pk);
	}
	
	public void update(Contact contact) {
		em.merge(contact);
	}
	
	public long delete(long pk) {
		Contact c = em.find(Contact.class,pk);
		em.remove(c);
		return c.getPk(); 
	}
	
	public List<Contact> getAllContact(){
		List<Contact> contacts = new ArrayList<Contact>();
		contacts = em.createNamedQuery("Contact.nom", Contact.class).getResultList();
		return contacts;
	}
}