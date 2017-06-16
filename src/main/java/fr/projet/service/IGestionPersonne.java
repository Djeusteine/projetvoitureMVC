package fr.projet.service;

import java.util.List;

import fr.projet.metier.Personne;

public interface IGestionPersonne {

	public int addPersonne(Personne personne) throws Exception;

	public int deletePersonne(Personne personne);

	public List<Personne> findAll();

	public int updatePersonne(Personne personne, String nom, String prenom, int age);

	public Personne getPersonne(int personneid);

	public int deletePersonne(int pId);

	public int updatePersonne(Personne p);

}
