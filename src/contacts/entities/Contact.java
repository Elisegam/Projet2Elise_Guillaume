package contacts.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Classe métier regroupant les données sur les contacts enregistrés.
 * 
 * 
 * @author GAMASSA Elise et ESPITIA Guillaume
 * @version 1.0
 * 
 */

@Entity
@Table(name = "personnes")
@Access(AccessType.FIELD)

@NamedQuery(name = "Contact.nom", query = "SELECT DISTINCT c FROM Contact c")
public class Contact implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long pk;
	private String civilite;
	private String nom;
	private String prenom;
//	private String surnom;

	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE }, fetch = FetchType.EAGER)
	@JoinTable(name = "contacts_adresses", joinColumns = @JoinColumn(name = "fk_adresse"), inverseJoinColumns = @JoinColumn(name = "fk_personne"))
	private Adresse adresse;

	/**
	 * Constructeur sans défaut.
	 */
	public Contact() {
	}

	/**
	 * Constructeur avec des parametres.
	 * 
	 * @param civilite
	 * @param nom
	 * @param prenom
	 */
	public Contact(String civilite, String nom, String prenom, Adresse adresse) {
		this.civilite = civilite;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
//		this.surnom = surnom;
	}

	/**
	 * Constructeur avec des parametres.
	 * 
	 * @param pk
	 * @param civilite
	 * @param nom
	 * @param prenom
	 */
	public Contact(long pk, String civilite, String nom, String prenom) {
		this.pk = pk;
		this.civilite = civilite;
		this.nom = nom;
		this.prenom = prenom;
//		this.surnom = surnom;
	}

	/**
	 * Getter de la civilité.
	 */
	public String getCivilite() {
		return civilite;
	}

	/**
	 * Getter du nom.
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Getter du prenom.
	 */
	public String getPrenom() {
		return prenom;
	}

//	public String getSurnom() {
//		return surnom;
//	}

	/**
	 * Setter de la civilité.
	 */
	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}

	/**
	 * Setter du nom du contact.
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Setter du prenom.
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

//	public void setSurnom(String surnom) {
//		this.surnom = surnom;
//	}

	/**
	 * Getter de l'identifiant unique.
	 */
	public long getPk() {
		return pk;
	}

	/**
	 * Setter de l'identifiant unique.
	 */
	public void setPk(long pk) {
		this.pk = pk;
	}

	/**
	 * Getter de l'adresse du contact.
	 */
	public Adresse getAdresse() {
		return adresse;
	}

	/**
	 * Setter de l'adresse du contact.
	 */
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Contact(long pk, String civilite, String nom, String prenom, Adresse adresse) {
		super();
		this.pk = pk;
		this.civilite = civilite;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
	}

//	@Override
//	public String toString() {
//		return "Contact [pk=" + pk + ", civilite=" + civilite + ", nom=" + nom + ", prenom=" + prenom + ", surnom="
//				+ surnom + "]";
//	}

}
