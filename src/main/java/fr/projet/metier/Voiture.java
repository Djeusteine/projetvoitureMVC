package fr.projet.metier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Voiture {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String marque;
	private String constructeur;

	@ManyToOne
	private Personne personne;

	public Voiture() {
		super();
	}

	public Voiture(int id, String marque, String constructeur) {
		super();
		this.id = id;
		this.marque = marque;
		this.constructeur = constructeur;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Voiture [id=" + id + ", marque=" + marque + ", constructeur=" + constructeur + "]";
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the marque
	 */
	public String getMarque() {
		return marque;
	}

	/**
	 * @return the constructeur
	 */
	public String getConstructeur() {
		return constructeur;
	}

	/**
	 * @return the personne
	 */
	public Personne getPersonne() {
		return personne;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @param marque
	 *            the marque to set
	 */
	public void setMarque(String marque) {
		this.marque = marque;
	}

	/**
	 * @param constructeur
	 *            the constructeur to set
	 */
	public void setConstructeur(String constructeur) {
		this.constructeur = constructeur;
	}

	/**
	 * @param personne
	 *            the personne to set
	 */
	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

}
