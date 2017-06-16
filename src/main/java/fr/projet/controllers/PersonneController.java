package fr.projet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.projet.metier.Personne;
import fr.projet.service.IGestionPersonne;

@Controller
@RequestMapping("/personnes")
public class PersonneController {
	@Autowired
	IGestionPersonne igp;

	@RequestMapping("/index")
	public String index(Model model) {
		model.addAttribute("personnes", igp.findAll());
		model.addAttribute("personne", new Personne());
		return "personne";
	}

	@RequestMapping("/addPers")
	public String addPers(Model model, Personne p) {
		if (p.getId() == 0) {
			try {
				igp.addPersonne(p);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.getMessage();
			}
		} else {
			igp.updatePersonne(p);
		}
		model.addAttribute("personnes", igp.findAll());
		model.addAttribute("personne", new Personne());
		return "personne";
	}

	@RequestMapping("/delPers")
	public String delPers(int pId, Model model) {
		igp.deletePersonne(pId);
		model.addAttribute("personnes", igp.findAll());
		model.addAttribute("personne", new Personne());
		return "personne";
	}

	@RequestMapping("/updatePers")
	public String updatePers(int pId, Model model) {
		model.addAttribute("personnes", igp.findAll());
		model.addAttribute("personne", igp.getPersonne(pId));
		return "personne";
	}

}
