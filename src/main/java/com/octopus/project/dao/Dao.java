package com.octopus.project.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.octopus.project.model.Player;
import com.octopus.project.model.Rating;


@Transactional
public interface Dao {
	
	//Players
	Player createPlayer (Player player);
	void updatePlayer (Player player);
	void deletePlayer (Player player);
	Player getPlayerById(String playerId);
	
	//Ratings
	Rating createRating (Rating rating);
	void updateRating (Rating rating);
	void deleteRating (Rating rating);	
	List<Rating> getRatingByPlayerId(String playerId);
	
}
