package contacts.dao;

import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


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
	
	public void delete(Contact contact) {
		em.remove(contact);
	}
	
	public List<String> getAllContact(){
		return em.createNamedQuery("Contact.nom", String.class).getResultList();
	}
}