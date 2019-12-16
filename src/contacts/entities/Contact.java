package contacts.entities;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "personnes")
@Access(AccessType.FIELD)

@NamedQuery(name = "Contact.nom" , query = "SELECT DISTINCT c FROM Contact c")
public class Contact implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long pk;
	private String civilite;
	private String nom;
	private String prenom;
//	private String surnom;

	public Contact() {
	}

	public Contact(String civilite, String nom, String prenom) {
		this.civilite = civilite;
		this.nom = nom;
		this.prenom = prenom;
//		this.surnom = surnom;
	}
	
	public Contact(long pk,String civilite, String nom, String prenom) {
		this.pk =pk;
		this.civilite = civilite;
		this.nom = nom;
		this.prenom = prenom;
//		this.surnom = surnom;
	}

	public String getCivilite() {
		return civilite;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

//	public String getSurnom() {
//		return surnom;
//	}

	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

//	public void setSurnom(String surnom) {
//		this.surnom = surnom;
//	}

	public long getPk() {
		return pk;
	}

	public void setPk(long pk) {
		this.pk = pk;
	}

//	@Override
//	public String toString() {
//		return "Contact [pk=" + pk + ", civilite=" + civilite + ", nom=" + nom + ", prenom=" + prenom + ", surnom="
//				+ surnom + "]";
//	}

}
