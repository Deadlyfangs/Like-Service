package com.octopus.project.service;

import com.octopus.project.model.Player;


public interface PlayerService {

	void create (Player player);
	void update (Player player);
	void delete (Player player);
	Player getPlayerById (String playerId);
	
}
