package com.bealdung.cxf.rest.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.bealdung.cxf.repository.PlayersRepository;
import com.bealdung.cxf.rest.domain.Player;

public class PlayerService implements IPlayerService  {

//	private ApplicationContext applicationContext;
//	
//	@Override
//	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//		this.applicationContext = applicationContext;
//	}
//	
	
	private ApplicationContext applicationContext;;
	
	@SuppressWarnings("unused")
	@Autowired
	private PlayersRepository playersRepository;
	
	public PlayerService() {
		
	}
	
	
//	@Autowired
//	public PlayerService(PlayersRepository playersRepository) {
//		this.playersRepository = playersRepository;
//		
//	}


	@Override
	public Player getPlayerInfo(int playerId) {
		return new Player(1,"Sachin",33,75);
	}

	@Override
	public List<Player> getAllPlayers() {
		return playersRepository.getAllPlayers();
		//return applicationContext.getBean(PlayersRepository.class).getAllPlayers();
//		/*
//		 * List<Player> players = new ArrayList<>(); players.add(new
//		 * Player(1,"Jason",30, 60)); players.add(new Player(2,"Peter",40, 75));
//		 * 
//		 * return players;
//		 */
		
		
	}

}
