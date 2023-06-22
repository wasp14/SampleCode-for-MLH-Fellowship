package com.sat_results.Controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sat_results.Models.satResults;
import com.sat_results.Service.serviceImp;


@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/")
public class satResultsController {

	@Autowired
	private serviceImp service;
	
	@GetMapping("/getall")
	public ResponseEntity<List<satResults>> getScores()
	{
	List<satResults> list = service.getAll();
	
		if(list!=null)
		{
			return ResponseEntity.ok(list);
		}
		else
			return ResponseEntity.notFound().build();
	}
	
	@PostMapping("/storeResult")
	public ResponseEntity<String> storeResult(@RequestBody @Validated satResults result)
	{
	
		ResponseEntity<String> responseEntity = null ;
		if(result!=null )
		{
			satResults sat = service.saveScore(result);
			if(sat!=null)
			{
				responseEntity =  ResponseEntity.ok("Score stored successfully");
			}
			}
		else
			responseEntity = ResponseEntity.badRequest().body("Error");
		
		return responseEntity;
				
	}
	
	@PutMapping("/updateScore/{name}")
	public ResponseEntity<String> updateScore(@PathVariable("name") @RequestBody String name, @RequestBody int score)
	{	
		
		List<satResults> list = new ArrayList<satResults>();
		satResults result = service.updateScore(name, score);
		if(result!=null)
			return ResponseEntity.ok("Update Successful");
		else
			return ResponseEntity.badRequest().body("Error");
	}
	
	@DeleteMapping("/delete/{name}")
	public ResponseEntity<String> deleteResult(@PathVariable("name") String name)
	{   
		if(name!=null)
		{
		service.deleteScore(name);
		return ResponseEntity.ok("Result Delete Successfully");
		}
		else
			return ResponseEntity.badRequest().build();
	}
	
	@GetMapping("/getRank/{name}")
	public ResponseEntity<?> getRank(@PathVariable("name") String name)
	{
		Integer rank = null;
		if(name!=null)
		{
			 rank = service.getRank(name);
		}
		if(rank == null)
		{
			return ResponseEntity.badRequest().body("error"); 
		}
		else
			return ResponseEntity.ok(rank);
		
		
	}
	
}
