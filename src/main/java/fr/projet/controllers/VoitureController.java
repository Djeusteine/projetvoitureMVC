package fr.projet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.projet.metier.Voiture;
import fr.projet.service.IGestionPersonne;
import fr.projet.service.IGestionVoiture;

@Controller
@RequestMapping("/voitures")
public class VoitureController {

	@Autowired
	IGestionPersonne igp;

	@Autowired
	IGestionVoiture igv;

	@RequestMapping("/index")
	public String index(Model model) {
		model.addAttribute("voitures", igv.findAllV());
		model.addAttribute("personnes", igp.findAll());
		model.addAttribute("voiture", new Voiture());
		return "voiture";
	}

	@RequestMapping("/addVoit")
	public String addVoit(Model model, Voiture voiture) {
		if (voiture.getId() == 0) {
			try {
				igv.addVoiture(voiture);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.getMessage();
			}
		} else {
			igv.updateVoiture(voiture);
		}
		model.addAttribute("voitures", igv.findAllV());
		model.addAttribute("personnes", igp.findAll());
		model.addAttribute("voiture", new Voiture());
		return "voiture";
	}

	@RequestMapping("/delVoit")
	public String delVoit(int vId, Model model) {
		igv.destroyVoiture(vId);
		model.addAttribute("voitures", igv.findAllV());
		model.addAttribute("personnes", igp.findAll());
		model.addAttribute("voiture", new Voiture());
		return "voiture";
	}

	@RequestMapping("/updateVoit")
	public String updateVoit(int vId, Model model) {
		model.addAttribute("voitures", igv.findAllV());
		model.addAttribute("personnes", igp.findAll());
		model.addAttribute("voiture", igv.getVoiture(vId));
		return "voiture";
	}

}
