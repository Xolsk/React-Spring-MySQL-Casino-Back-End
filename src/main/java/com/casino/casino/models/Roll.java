package com.casino.casino.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Roll {
	
	
	@Id @GeneratedValue long id;
	Boolean wasSuccessful;
	
	@ManyToOne 
	@JoinColumn(name="player_id", nullable=false)
	Player player;
	
	int[] rollResults = new int[5];

	public Boolean getWasSuccessful() {
		return wasSuccessful;
	}

	public void setWasSuccessful(Boolean wasSuccessful) {
		this.wasSuccessful = wasSuccessful;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public int[] getRollResults() {
		return rollResults;
	}

	public void setRollResults(int[] rollResults) {
		this.rollResults = rollResults;
	}

	public long getId() {
		return id;
	}
	
	
	

}

