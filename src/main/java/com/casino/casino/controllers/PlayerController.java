package com.casino.casino.controllers;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casino.casino.helpers.Response;
import com.casino.casino.models.Player;
import com.casino.casino.models.Roll;
import com.casino.casino.repositories.PlayerRepository;


@RestController
@RequestMapping("/api/players")
@CrossOrigin(origins = "http://localhost:3000")
public class PlayerController {

	
	@Autowired
	PlayerRepository playerRepository;
	
	@GetMapping("/{username}")
	ResponseEntity<Response> getcurrentPlayer(@PathVariable (value="username") String username){
		
		Player activePlayer = playerRepository.findByUsername(username);
		Response allGood =new Response(activePlayer,"Here you have it.");
		return ResponseEntity.ok().body(allGood);	
	}
	

	@GetMapping("/")
	ResponseEntity<Response> getPlayers(){	
		Response allGood =new Response(null,"Here you have it.");
		return ResponseEntity.ok().body(allGood);	
	}
	

	@PutMapping("/") 
	ResponseEntity<Response>modifyPlayer(@RequestBody @Valid String username, String newuserName)
	{
		Player activePlayer = playerRepository.findByUsername(username);
		activePlayer.setUsername(newuserName);
		playerRepository.save(activePlayer);
		Response allGood = new Response(activePlayer,"username modified");
		
		return ResponseEntity.ok().body(allGood);
		
	}

	
	@GetMapping("/ranking")
	ResponseEntity<Response> getPlayerRanking (){
		
		List<Player> players = playerRepository.findAll();
		Map<String,Double> playerRanking = new HashMap<String,Double>();
		String name;
		Double success;
		
		for (Player player: players)
		{	
			name=player.getUsername();
			success=new Double(player.getSuccessRate());
			playerRanking.put(name, success);
		}
		
		Response allGood = new Response (playerRanking,"Player rankings");
		return ResponseEntity.ok().body(allGood);
				
	}
	
	@GetMapping("/ranking/worst")
	ResponseEntity<Response> getWorstPlayer (){
		
		List<Player>players = playerRepository.findAllByOrderBySuccessRateAsc();

		Player worstPlayer = (Player) players.get(0);
		Response allGood = new Response(worstPlayer,"Worst Player");
		return ResponseEntity.ok().body(allGood);
				
	}
	
	@GetMapping("/ranking/best")
	ResponseEntity<Response> getBestPlayer (){
		
		List<Player> players = playerRepository.findAllByOrderBySuccessRateDesc();

		Player bestPlayer = (Player) players.get(0);
		Response allGood = new Response(bestPlayer,"BestPlayer");
		return ResponseEntity.ok().body(allGood);
				
	}
	
	Optional<Player> findById(String playerId)
	{
		Optional<Player> activePlayer = playerRepository.findById(Long.parseLong(playerId));
		
		return activePlayer;
	}
	
	void setNewSuccessRate(Player player)
	{
		double successes=0;
		for (Roll roll :player.getRolls()) 
		{
			if (roll.getWasSuccessful()==true)
			{
			successes++;
			}
		}
		player.setSuccessRate(successes/player.getRolls().size()*100);
		playerRepository.save(player);
	}
	
	void clearSuccessRate(Player player)
	{
		player.setSuccessRate(0);
		playerRepository.save(player);
	}
}
