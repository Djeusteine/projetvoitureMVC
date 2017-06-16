package fr.projet.dao;

import java.util.List;

import fr.projet.metier.Personne;
import fr.projet.metier.Voiture;

public interface IDao {

	public int addPersonne(Personne personne) throws Exception;

	public int deletePersonne(Personne personne);

	public List<Personne> findAll();

	public int updatePersonne(Personne personne, String nom, String prenom, int age);

	public int addVoiture(Voiture voiture, Personne personne);

	public int changeProprietaire(Voiture voiture, Personne personne);

	public int destroyVoiture(int vId);

	public Personne getPersonne(int personneId);

	public Voiture getVoiture(int voitureId);

	public List<Voiture> findVoitureOf(int personneId);

	public int deletePersonne(int pId);

	public int updatePersonne(Personne p);

	public List<Voiture> findAllV();

	public int updateVoiture(Voiture v);

	public int addVoiture(Voiture voiture);
}
