package fr.projet.service.tests;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.projet.metier.Personne;
import fr.projet.service.IGestionPersonne;
import junit.framework.Assert;

public class TestService {
	ClassPathXmlApplicationContext app;
	IGestionPersonne igp;
	Personne personne;

	@Before
	public void setUp() {
		app = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
		igp = (IGestionPersonne) app.getBean("service");
		personne = (Personne) app.getBean("personne");
	}

	@Test
	public void test() {
		try {
			int nb = igp.findAll().size();
			personne.setAge(25);
			personne.setNom("Jannel");
			personne.setPrenom("Calypso");
			igp.addPersonne(personne);
			Assert.assertEquals("erreur", nb + 1, igp.findAll().size(), 0);
		} catch (Exception e) {
			assertTrue(e.getMessage(), false);
		}
	}

}
