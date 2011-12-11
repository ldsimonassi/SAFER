package edu.cema.safer.scenarios

import edu.cema.safer.model.vehicles.AFB;

import java.util.List;

import edu.cema.safer.model.Player;
import edu.cema.safer.model.Position;
import edu.cema.safer.model.Size;
import edu.cema.safer.model.Unit;



class SimpleStage {
	
	def numberOfPlayers
	int currentPlayer= 0
	
	public SimpleStage(int numberOfPlayers){
		this.numberOfPlayers= numberOfPlayers	
	}
	
	public List<Unit> createPlayerUnits(Player p){
		def afb= new AFB()
		def units= []
		afb.size= new Size(0.01, 0.01);
		units.add(afb)

		
		if(currentPlayer == 0)
			afb.position= new Position(0.1, 0.1)
		else
			afb.position= new Position(0.9, 0.9)
		currentPlayer++
		units
	}
}
