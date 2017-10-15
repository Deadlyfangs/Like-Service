package com.octopus.project.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.octopus.project.dao.Dao;
import com.octopus.project.model.Player;
import com.octopus.project.model.Rating;
import com.octopus.project.service.LikeService;


@Service("likeService")
public class LikeServiceImpl implements LikeService {
	private static final Logger log = LoggerFactory.getLogger(LikeServiceImpl.class);

	@Autowired
	Dao dao;

	@PostConstruct
	void init() {
		log.info("Prepare Like Service");
	}

	// This method could potentially take sourcePlayerId (from whom a player get a like)
	public void like(String playerId) {

		Rating rating = new Rating("like", new Date());

		Player player = dao.getPlayerById(playerId);
		Player sourcePlayer = dao.getPlayerById("1"); // placeholder

		rating.setPlayer(player);
		rating.setSourcePlayer(sourcePlayer);

		dao.createRating(rating);
	}

	public long getLikes(String playerId) {

		List<Rating> ratingsList = dao.getRatingByPlayerId(playerId);

		return countLikes(ratingsList);
	}

	// This method is public for the sake of JUnit testing
	public long countLikes(List<Rating> ratingsList) {

		int likeCount = 0;
		for (Rating rating : ratingsList) {

			if (rating.getRating().equals("like")) {
				likeCount++;
			}
		}
		
		return likeCount;
	}
	
}
