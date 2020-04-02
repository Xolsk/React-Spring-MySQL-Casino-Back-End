package com.casino.casino.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casino.casino.helpers.Response;
import com.casino.casino.models.Player;
import com.casino.casino.repositories.PlayerRepository;

@RestController
@RequestMapping("/api/players")
@CrossOrigin(origins = "http://localhost:3000")
public class PlayerController {

	
	@Autowired
	PlayerRepository playerRepository;
	

	@GetMapping("/")
	ResponseEntity<Response> getPlayers(){	
		Response allGood =new Response(null,"Here you have it.");
		return ResponseEntity.ok().body(allGood);	
	}
	
	
	@PutMapping("/") 
	ResponseEntity<Response>modifyPlayer(@RequestBody @Valid Player player){
		return null;
		
	}
	
	
	@PostMapping("/players/{playerID}/games")
	ResponseEntity<Response> makeDiceRoll (@PathVariable (value="playerID") String playerId){
		return null;
				
	}
	
	@DeleteMapping("/players/{playerID}/games")
	ResponseEntity<Response> clearDiceRolls (@PathVariable (value="playerID") String playerId){
		return null;
				
	}
	
	@GetMapping("/players/{playerID}/games")
	ResponseEntity<Response> getDiceRolls (@PathVariable (value="playerID") String playerId){
		return null;
				
	}
	
	@GetMapping("/players/ranking")
	ResponseEntity<Response> getPlayerRanking (@PathVariable (value="playerID") String playerId){
		return null;
				
	}
	
	@GetMapping("/players/ranking/worst")
	ResponseEntity<Response> getWorstPlayer (@PathVariable (value="playerID") String playerId){
		return null;
				
	}
	
	@GetMapping("/players/ranking/best")
	ResponseEntity<Response> getBestPlayer (@PathVariable (value="playerID") String playerId){
		return null;
				
	}
	
}
