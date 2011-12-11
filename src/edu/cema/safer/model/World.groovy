package edu.cema.safer.model

import java.awt.Point;

import edu.cema.safer.scenarios.SimpleStage;

class World {
	def players= []
	def playerUnits= [:]

	def scenario= new SimpleStage()

	def createNewPlayer(Player p) {
		def createdUnits= scenario.createPlayerUnits(p)
		playerUnits[p]= createdUnits
		players.add p
	}

	def loop(){

		// TODO 1) Let players play.
		players.each { player ->
			player.play(playerUnits[player])
		}

		// TODO 2) Move pieces.
		playerUnits.each { units ->
			units.each { unit -> 
				if(unit instanceof MobileUnit){
					unit.position.move(unit.speed, unit.heading);
				}
			}
		}

	}
}
