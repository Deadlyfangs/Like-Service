package com.octopus.project.dao.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.octopus.project.dao.Dao;
import com.octopus.project.model.Player;
import com.octopus.project.model.Rating;
import com.octopus.project.util.CustomHibernateDaoSupport;


@Repository("daoImpl")
public class DaoImpl extends CustomHibernateDaoSupport implements Dao {
	private static final Logger log = LoggerFactory.getLogger(DaoImpl.class);
	
	@PostConstruct
	void init () {
		log.info("Prepare DAO");
	}
	
	public Player createPlayer(Player player) {

		getHibernateTemplate().save(player);
		return player;
	}

	public void updatePlayer(Player player) {
		getHibernateTemplate().update(player);

	}

	public void deletePlayer(Player player) {
		getHibernateTemplate().delete(player);

	}

	public Player getPlayerById(String playerId) {

		return getHibernateTemplate().get(Player.class, Integer.valueOf(playerId));
	}

	public Rating createRating(Rating rating) {
		//Rating ratingResult = (Rating) getHibernateTemplate().save(rating);
		getHibernateTemplate().save(rating);
		return rating;
	}

	public List<Rating> getRatingByPlayerId(String playerId) {

		List<Rating> list = (List<Rating>) getHibernateTemplate().find("FROM ratings WHERE player_id = ?", Integer.valueOf(playerId));

		return list;
	}

	public void updateRating(Rating rating) {
		getHibernateTemplate().update(rating);

	}

	public void deleteRating(Rating rating) {
		getHibernateTemplate().delete(rating);

	}
	
}
