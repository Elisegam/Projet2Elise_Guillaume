package contacts.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Classe métier regroupant les données sur l'adresse des contacts enregistrés.
 * 
 * 
 * @author GAMASSA Elise et ESPITIA Guillaume
 * @version 1.0
 * 
 */

@Entity
@Table(name = "adresses")
@Access(AccessType.FIELD)
public class Adresse implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long pk;
	private String rue;
	@Column(name = "code_postal")
	private String codePostal;
	private String ville;
	private String pays;

//	@OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
//	@JoinTable(name = "contacts_adresses", joinColumns = @JoinColumn(name = "fk_adresse"), inverseJoinColumns = @JoinColumn(name = "fk_personne"))
//	private List<Contact> contacts;

	/**
	 * Constructeur sans parametre.
	 */
	public Adresse() {
	}

	/**
	 * Construteur avec les parametres.
	 * 
	 * @param rue
	 * @param codePostal
	 * @param ville
	 * @param pays
	 */
	public Adresse(String rue, String codePostal, String ville, String pays) {
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.pays = pays;
	}

	/**
	 * Getter de l'identifiant unique.
	 * 
	 * @return
	 */
	public long getPk() {
		return pk;
	}

	/**
	 * Getter du nom de la rue.
	 */
	public String getRue() {
		return rue;
	}

	/**
	 * Getter du code postal.
	 */
	public String getCodePostal() {
		return codePostal;
	}

	/**
	 * Getter du nom de la ville
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * Getter du pays.
	 */
	public String getPays() {
		return pays;
	}

	/**
	 * Setter de l'identifiant unique.
	 */
	public void setPk(long pk) {
		this.pk = pk;
	}

	/**
	 * Setter du nom de la rue.
	 */
	public void setRue(String rue) {
		this.rue = rue;
	}

	/**
	 * Setter du code postal.
	 */
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	/**
	 * Setter du nom de la ville.
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	/**
	 * Setter du nom du pays.
	 */
	public void setPays(String pays) {
		this.pays = pays;
	}

}
