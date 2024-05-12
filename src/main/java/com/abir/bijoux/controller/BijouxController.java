package com.abir.bijoux.controller;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.abir.bijoux.entities.Bijoux;
import com.abir.bijoux.entities.Marque;
import com.abir.bijoux.service.BijouxService;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BijouxController {

	@Autowired
	BijouxService bijouxService;

	@GetMapping("/accessDenied")
	public String error() {
		return "accessDenied";
	}

	@RequestMapping("/ListeBijoux")
	public String listeBijoux(ModelMap modelMap, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		Page<Bijoux> bijx = bijouxService.getAllBijouxParPage(page, size);
		modelMap.addAttribute("bijoux", bijx);
		modelMap.addAttribute("pages", new int[bijx.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);

		return "listeBijoux";
	}

	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap) {
		List<Marque> Mars = bijouxService.getAllMarque();
		modelMap.addAttribute("bijoux", new Bijoux());
		modelMap.addAttribute("mode", "new");
		modelMap.addAttribute("marques", Mars);

		return "formBijoux";
	}

	@RequestMapping("/saveBijoux")
	public String saveProduit(@Valid Bijoux bijoux, BindingResult bindingResult,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		int currentPage;
		boolean isNew = false;
		if (bindingResult.hasErrors())
			return "formBijoux";
		if (bijoux.getIdBijoux() == null) // ajout
			isNew = true;
		bijouxService.saveBijoux(bijoux);
		if (isNew) // ajout
		{
			Page<Bijoux> prods = bijouxService.getAllBijouxParPage(page, size);
			currentPage = prods.getTotalPages() - 1;
		} else // modif
			currentPage = page;
		return ("redirect:/ListeBijoux?page=" + currentPage + "&size=" + size);
	}

	@RequestMapping("/supprimerBijoux")
	public String supprimerBijoux(@RequestParam("id") Long id, ModelMap modelMap,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size)

	{
		bijouxService.deleteBijouxById(id);
		Page<Bijoux> bijx = bijouxService.getAllBijouxParPage(page, size);
		modelMap.addAttribute("bijoux", bijx);
		modelMap.addAttribute("pages", new int[bijx.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "listeBijoux";
	}

	@RequestMapping("/modifierBijoux")
	public String editerBijoux(@RequestParam("id") Long id, ModelMap modelMap) {
		Bijoux b = bijouxService.getBijoux(id);
		List<Marque> Mars = bijouxService.getAllMarque();

		modelMap.addAttribute("bijoux", b);
		modelMap.addAttribute("mode", "edit");
		modelMap.addAttribute("marques", Mars);

		return "editerBijoux";
	}

	@RequestMapping("/updateBijoux")
	public String updateBijoux(@ModelAttribute("bijoux") Bijoux bijoux, @RequestParam("date") String date,
			ModelMap modelMap) throws ParseException {
		// conversion de la date
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateCreation = dateformat.parse(String.valueOf(date));
		bijoux.setDateCreation(dateCreation);

		bijouxService.updateBijoux(bijoux);
		List<Bijoux> bijx = BijouxService.getAllBijoux();
		modelMap.addAttribute("bijoux", bijx);
		return "listeBijoux";
	}

	@GetMapping(value = "/")
	public String welcome() {
		return "index";
	}

}