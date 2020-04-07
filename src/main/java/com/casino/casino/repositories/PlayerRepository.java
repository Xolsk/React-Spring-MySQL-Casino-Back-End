package com.casino.casino.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.casino.casino.models.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {

	Player findByUsername (String username);
	
	List<Player> findAllByOrderBySuccessRateAsc();

	List<Player> findAllByOrderBySuccessRateDesc();
}
