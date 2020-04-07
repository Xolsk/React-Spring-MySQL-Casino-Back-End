package com.casino.casino.security;



import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.casino.casino.models.Player;
import com.casino.casino.repositories.PlayerRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	PlayerRepository playerRepository;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Player activePlayer = playerRepository.findByUsername(username);
		
		if (activePlayer == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(activePlayer.getUsername(), activePlayer.getPassword(),
				new ArrayList<>());
	}
	
	public Player save(Player player) {
		
		Player newPlayer= new Player();
		
		newPlayer.setUsername(player.getUsername());
		newPlayer.setPassword(bcryptEncoder.encode(player.getPassword()));
		playerRepository.save(newPlayer);
		
		return newPlayer;
	}

	public boolean checkforDuplicates(String username) {
		
		Player activePlayer=playerRepository.findByUsername(username);
		
		if (activePlayer==null)
		{
			return false;
		}
		return true;
	}
}