package com.bealdung.cxf.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bealdung.cxf.rest.domain.Player;


public class PlayersRepository{
	
	public PlayersRepository() {
		
	}
	
	
	public List<Player> getAllPlayers() {
		List<Player> players = new ArrayList<>();
		players.add(new Player(1,"Jason",30, 60));
		players.add(new Player(2,"Peter",40, 75));
		
		return players;
		
	}

	

}
