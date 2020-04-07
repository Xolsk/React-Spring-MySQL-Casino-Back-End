package com.casino.casino.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.casino.casino.models.Player;
import com.casino.casino.models.Roll;

public interface RollRepository extends JpaRepository<Roll, Object>{

	Collection<Roll> findByPlayer(Player player);

}
