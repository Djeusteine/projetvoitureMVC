package fr.projet.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import fr.projet.dao.IDao;
import fr.projet.metier.Personne;
import fr.projet.metier.Voiture;

@Transactional
public class ServiceImpl implements IGestionPersonne, IGestionVoiture {

	IDao dao;

	/**
	 * @return the dao
	 */
	public IDao getDao() {
		return dao;
	}

	/**
	 * @param dao
	 *            the dao to set
	 */
	public void setDao(IDao dao) {
		this.dao = dao;
	}

	@Override
	public int addVoiture(Voiture voiture, Personne personne) {
		return dao.addVoiture(voiture, personne);
	}

	@Override
	public int changeProprietaire(Voiture voiture, Personne personne) {
		return dao.changeProprietaire(voiture, personne);
	}

	@Override
	public int destroyVoiture(int vId) {
		return dao.destroyVoiture(vId);
	}

	@Override
	public int addPersonne(Personne personne) throws Exception {
		return dao.addPersonne(personne);
	}

	@Override
	public int deletePersonne(Personne personne) {
		return dao.deletePersonne(personne);
	}

	@Override
	public List<Personne> findAll() {
		return dao.findAll();
	}

	@Override
	public int updatePersonne(Personne personne, String nom, String prenom, int age) {
		return dao.updatePersonne(personne, nom, prenom, age);
	}

	@Override
	public Personne getPersonne(int personneid) {
		return dao.getPersonne(personneid);
	}

	@Override
	public Voiture getVoiture(int voitureid) {
		return dao.getVoiture(voitureid);
	}

	@Override
	public List<Voiture> findVoitureOf(int personneId) {
		return dao.findVoitureOf(personneId);
	}

	@Override
	public int deletePersonne(int pId) {
		return dao.deletePersonne(pId);
	}

	@Override
	public int updatePersonne(Personne p) {
		return dao.updatePersonne(p);
	}

	@Override
	public List<Voiture> findAllV() {
		return dao.findAllV();
	}

	@Override
	public int updateVoiture(Voiture v) {
		return dao.updateVoiture(v);
	}

	@Override
	public int addVoiture(Voiture voiture) {
		return dao.addVoiture(voiture);
	}

}
