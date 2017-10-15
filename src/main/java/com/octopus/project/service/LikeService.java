package com.octopus.project.service;


public interface LikeService {

	void like(String playerId);

	long getLikes(String playerId);
	
}
