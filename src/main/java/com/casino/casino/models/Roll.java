package com.casino.casino.models;

import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Roll {
	
	
	@Id @GeneratedValue
	long id;
	Boolean wasSuccessful;
	Random die= new Random();
	
	@ManyToOne 
	@JoinColumn(name="player_id", nullable=false)
	@JsonIgnore
	Player player;
	
	int[] rollResults = new int[6];

	public Roll() {
		
	}
	
	public Roll (Player player) {
		
		this.player=player;
		
		for (int i=0;i<6; i++)
		{
			this.rollResults[i]=die.nextInt(6)+1;
		}
		this.wasSuccessful=this.checkSuccess();
		
	}
	
	private Boolean checkSuccess() {
		
		int checkSuccess=0;
		
		for (int i=0; i<this.rollResults.length;i++)
		{
			if (this.rollResults[i]>4)
			{
				checkSuccess++;
			}
		}
		if (checkSuccess==6)
		{
			return true;
		}
		return false;
	}

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

