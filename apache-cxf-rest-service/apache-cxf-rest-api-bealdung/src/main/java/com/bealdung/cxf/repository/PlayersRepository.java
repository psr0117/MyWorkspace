package com.bealdung.cxf.repository;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.bealdung.cxf.rest.domain.Player;

//@Path("/players")
@Repository
public class PlayersRepository{
	
	public PlayersRepository() {
		
	}
	
	//http://localhost:8083/players/all
	//@GET
	//@Produces("application/json")
	//@Path("/all")
	public List<Player> getAllPlayers() {
		List<Player> players = new ArrayList<>();
		players.add(new Player(1,"Jason",30, 60));
		players.add(new Player(2,"Peter",40, 75));
		
		return players;
		
	}

	

}
