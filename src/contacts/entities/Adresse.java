package contacts.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "adresses")
@Access(AccessType.FIELD)
public class Adresse implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long pk;
	private String rue;
	private int codePostal;
	private String ville;
	private String pays;
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "contacts_adresses", joinColumns = @JoinColumn(name = "fk_adresse"), inverseJoinColumns = @JoinColumn(name = "fk_personne"))
	private List<Contact> contacts;

	public Adresse() {
	}

	public Adresse(String rue, int codePostal, String ville, String pays, List<Contact> contacts) {
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.pays = pays;
		this.contacts = contacts;
	}

	public long getPk() {
		return pk;
	}

	public String getRue() {
		return rue;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public String getVille() {
		return ville;
	}

	public String getPays() {
		return pays;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setPk(long pk) {
		this.pk = pk;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	@Override
	public String toString() {
		return "Adresse [pk=" + pk + ", rue=" + rue + ", codePostal=" + codePostal + ", ville=" + ville + ", pays="
				+ pays + ", contacts=" + contacts + "]";
	}

}
