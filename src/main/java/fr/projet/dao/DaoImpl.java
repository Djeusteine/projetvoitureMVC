package fr.projet.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.projet.metier.Personne;
import fr.projet.metier.Voiture;

public class DaoImpl implements IDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public int addPersonne(Personne personne) throws Exception {
		// persist fait un insert into
		em.persist(personne);
		return personne.getId();
	}

	@Override
	public int deletePersonne(Personne personne) {
		em.remove(personne);
		return personne.getId();
	}

	@Override
	public List<Personne> findAll() {
		Query query = em.createQuery("select p from Personne p");
		return query.getResultList();
	}

	@Override
	public int updatePersonne(Personne personne, String nom, String prenom, int age) {
		personne.setNom(nom);
		personne.setPrenom(prenom);
		personne.setAge(age);
		em.merge(personne);
		return personne.getId();
	}

	@Override
	public int addVoiture(Voiture voiture, Personne personne) {
		voiture.setPersonne(personne);
		em.persist(voiture);
		return voiture.getId();
	}

	@Override
	public int changeProprietaire(Voiture voiture, Personne personne) {
		voiture.setPersonne(personne);
		em.merge(voiture);
		return voiture.getId();
	}

	@Override
	public int destroyVoiture(int vId) {
		Voiture voiture = this.getVoiture(vId);
		em.remove(voiture);
		return voiture.getId();
	}

	@Override
	public Personne getPersonne(int personneId) {
		Personne personne = em.find(Personne.class, personneId);
		return personne;
	}

	@Override
	public Voiture getVoiture(int voitureId) {
		Voiture voiture = em.find(Voiture.class, voitureId);
		return voiture;
	}

	@Override
	public List<Voiture> findVoitureOf(int personneId) {
		Query query = em.createQuery("select v from Voiture v where v.personne.id = :personneId")
				.setParameter("personneId", personneId);
		return query.getResultList();
	}

	@Override
	public int deletePersonne(int pId) {
		Personne personne = this.getPersonne(pId);
		em.remove(personne);
		return personne.getId();
	}

	@Override
	public int updatePersonne(Personne p) {
		em.merge(p);
		return p.getId();
	}

	@Override
	public List<Voiture> findAllV() {
		Query query = em.createQuery("select v from Voiture v");
		return query.getResultList();
	}

	@Override
	public int updateVoiture(Voiture v) {
		em.merge(v);
		return v.getId();
	}

	@Override
	public int addVoiture(Voiture voiture) {
		em.persist(voiture);
		return voiture.getId();
	}

}
