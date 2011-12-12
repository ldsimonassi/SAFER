package edu.cema.safer.scenarios

import edu.cema.safer.model.vehicles.AFB;

import java.util.List;

import edu.cema.safer.model.Player;
import edu.cema.safer.model.Position;
import edu.cema.safer.model.Size;
import edu.cema.safer.model.Unit;
import edu.cema.safer.model.World;



class SimpleStage {
	
	def numberOfPlayers
	int currentPlayer
	def unitsPerPlayer
	
	public SimpleStage(int numberOfPlayers, int unitsPerPlayer){
		this.numberOfPlayers= numberOfPlayers	
		this.unitsPerPlayer= unitsPerPlayer
	}
	
	public List<Unit> createPlayerUnits(Player p, World w){
		def units= []
		
		def x= (1/(2*numberOfPlayers))+(currentPlayer/numberOfPlayers)
		
		def step= 1/unitsPerPlayer;
		def actual= step/2;
		
		unitsPerPlayer.times() { i->
			Position pos= new Position(x, actual)
			def afb= new AFB(w, p, pos)
			units.add(afb)
			actual+= step;
		}
		currentPlayer++
		units
	}
}
