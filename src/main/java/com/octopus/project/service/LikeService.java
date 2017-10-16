package com.octopus.project.service;


public interface LikeService {

	void like(String playerId, String sourcePlayerId);

	long getLikes(String playerId);
	
}
