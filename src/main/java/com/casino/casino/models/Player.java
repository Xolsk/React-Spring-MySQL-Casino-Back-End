package com.casino.casino.models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Player {
	
	
	@Id @GeneratedValue long id;
	
	@NotNull
	String username;
	String password;
	@OneToMany(mappedBy ="player")
	Set<Roll> rolls;
	int successRate;
	
	public Player() {}
	
	public Player(String username, String password) {
		super();
		this.username = username;
		this.password = password;
		this.successRate=0;
	}


	public long getId() {
		return id;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Roll> getRolls() {
		return rolls;
	}

	public void setRolls(Set<Roll> rolls) {
		this.rolls = rolls;
	}

	public int getSuccessRate() {
		return successRate;
	}

	public void setSuccessRate(int successRate) {
		this.successRate = successRate;
	}

	

	
}
