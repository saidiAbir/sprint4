package com.abir.bijoux.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.abir.bijoux.entities.Bijoux;
import com.abir.bijoux.service.BijouxService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class BijouxRESTController {
	@Autowired
	BijouxService bijouxService;
	
	@RequestMapping(method= RequestMethod.GET)
	List<Bijoux> getAllBijoux()
	{
		return BijouxService.getAllBijoux();
	}
	@RequestMapping(method = RequestMethod.PUT) 
	public Bijoux updateBijoux(@RequestBody Bijoux bijoux) { 
	return bijouxService.updateBijoux(bijoux); 
	} 
	
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE) 
	public void deleteBijoux(@PathVariable("id") Long id) 
	{ 
		bijouxService.deleteBijouxById(id); 
	} 
	
	
	@RequestMapping(value="/prodscat/{idMar}",method = RequestMethod.GET) 
	public List<Bijoux> getBijouxByMarId(@PathVariable("idMar") Long idMar) { 
	return bijouxService.findByMarqueIdCat(idMar); 
	} 
	
	@RequestMapping(method = RequestMethod.POST) 
	public Bijoux createBijoux(@RequestBody Bijoux bijoux) { 
	return bijouxService.saveBijoux(bijoux); 
	} 
}
