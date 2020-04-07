package com.casino.casino.controllers;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casino.casino.helpers.Response;
import com.casino.casino.models.Player;
import com.casino.casino.models.Roll;
import com.casino.casino.repositories.RollRepository;

@RestController
@RequestMapping("/api/rolls")
@CrossOrigin(origins = "http://localhost:3000")
public class RollController {
	
	@Autowired
	RollRepository rollRepository;
	
	@Autowired
	PlayerController playerController;
	
	
	@PostMapping("/{playerID}")
	ResponseEntity<Response> makeDiceRoll (@PathVariable (value="playerID") String playerId){
		
		Optional<Player> activePlayer = playerController.findById(playerId);
		
		if (activePlayer.isPresent())
		{
		Roll newRoll = new Roll(activePlayer.get());
		rollRepository.save(newRoll);
		playerController.setNewSuccessRate(activePlayer.get());
		Response allGood = new Response (newRoll,"New Roll added");
		return ResponseEntity.ok().body(allGood);
		}
		
		Response badRequest = new Response ("Player not found");	
		return ResponseEntity.badRequest().body(badRequest);				
	}
	
	
	@DeleteMapping("/{playerID}")
	ResponseEntity<Response> clearDiceRolls (@PathVariable (value="playerID") String playerId){
		
		Optional<Player> activePlayer = playerController.findById(playerId);
		
		if (activePlayer.isPresent())
		{
    	Collection<Roll> toDelete = rollRepository.findByPlayer(activePlayer.get());
    	rollRepository.deleteAll(toDelete);
		Response allGood = new Response (("All deleted for"+activePlayer.get().getUsername()));
		playerController.clearSuccessRate(activePlayer.get());
		return ResponseEntity.ok().body(allGood);
		}
		
		Response badRequest = new Response ("Player not found");	
		return ResponseEntity.badRequest().body(badRequest);			
	}
	
	@GetMapping("/{playerID}")
	ResponseEntity<Response> getDiceRolls (@PathVariable (value="playerID") String playerId){
		
		Optional<Player> activePlayer = playerController.findById(playerId);
		if (activePlayer.isPresent()) 
		{
			Collection<Roll> allRolls = rollRepository.findByPlayer(activePlayer.get());
			Response allGood = new Response (allRolls, "all Rolls Found ");
			return ResponseEntity.ok().body(allGood);
		}
		
		Response badRequest = new Response ("Player not found");	
		return ResponseEntity.badRequest().body(badRequest);			
	}

}
