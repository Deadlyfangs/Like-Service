package com.octopus.project.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.octopus.project.model.Player;
import com.octopus.project.service.LikeService;
import com.octopus.project.service.PlayerService;
import com.octopus.project.spring.ApplicationContextProvider;


public class Main {
	private static final Logger log = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {

		Main main = new Main();
		main.doWork();
	}

	private void doWork() {

		// ApplicationContext appContext = ApplicationContextProvider.getApplicationContext();
		ApplicationContext appContext = new ClassPathXmlApplicationContext("META-INF/spring/config/app-context.xml");

		LikeService likeService = (LikeService) appContext.getBean("likeService");
		PlayerService playerService = (PlayerService) appContext.getBean("playerService");

		//playerService.create(new Player("Kevin"));	
		// log.info("Created Player: " + player.getName());

		//likeService.like("2");
		
		long likeCount = likeService.getLikes("2");
		log.info("Players likes: " + likeCount);

	}

}
