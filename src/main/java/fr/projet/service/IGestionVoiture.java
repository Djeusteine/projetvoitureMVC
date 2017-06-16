package fr.projet.service;

import java.util.List;

import fr.projet.metier.Personne;
import fr.projet.metier.Voiture;

public interface IGestionVoiture {

	public int addVoiture(Voiture voiture, Personne personne);

	public int changeProprietaire(Voiture voiture, Personne personne);

	public int destroyVoiture(int vId);

	public Voiture getVoiture(int voitureid);

	public List<Voiture> findVoitureOf(int personneId);

	public List<Voiture> findAllV();

	public int updateVoiture(Voiture v);

	public int addVoiture(Voiture voiture);
}
