package com.octopus.project.service;


public interface LikeService {

	long like(String playerId, String sourcePlayerId);

	long getLikes(String playerId);
	
}
