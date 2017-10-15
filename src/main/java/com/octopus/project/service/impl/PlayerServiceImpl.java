package com.octopus.project.service.impl;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.octopus.project.dao.Dao;
import com.octopus.project.model.Player;
import com.octopus.project.service.PlayerService;


@Service("playerService")
public class PlayerServiceImpl implements PlayerService {
	private static final Logger log = LoggerFactory.getLogger(PlayerServiceImpl.class);

	@Autowired
	Dao dao;
	
	@PostConstruct
	void init () {
		log.info("Prepare Player Service");
	}

	public void create(Player player) {

		dao.createPlayer(player);
	}

	public void update(Player player) {
		dao.updatePlayer(player);

	}

	public void delete(Player player) {
		dao.deletePlayer(player);

	}

	public Player getPlayerById(String playerId) {

		Player player = dao.getPlayerById(playerId);

		return player;
	}

}
