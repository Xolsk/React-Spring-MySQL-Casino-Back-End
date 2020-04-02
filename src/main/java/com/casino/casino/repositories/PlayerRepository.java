package com.casino.casino.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.casino.casino.models.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {

	Player findByUsername (String username);
}
