package edu.cema.safer.model

import java.awt.Point;
import java.util.LinkedList;

import edu.cema.safer.scenarios.SimpleStage;

class World {
	def players= []
	def playerUnits= [:]

	def scenario= new SimpleStage(2)
	
	
	def createNewPlayer(Player p) {
		def createdUnits= scenario.createPlayerUnits(p)
		println "Added ${createdUnits.size()} units for player ${p.color}"
		playerUnits[p]= createdUnits
		players.add p
	}

	def loop(){

		// TODO 1) Let players play.
		players.each { player ->
			player.play(playerUnits[player])
		}

		// TODO 2) Move pieces.
		
		println "${playerUnits.size()} playerUnits"
		playerUnits.values().each { units ->
			units.each { unit -> 
				if(unit instanceof MobileUnit){
					unit.position.move(unit.speed, unit.heading);
				}
			}
		}
		
		fireWorldChangeedEvent();

	}
	
	
	LinkedList<WorldListener> listeners= new LinkedList<WorldListener>(); 
	
	
	public void addWorldChangedListener(WorldListener wl){
		listeners.add wl
	}
	
	public void removeWorldChangedListener(WorldListener w2){
		listeners.remove w2	
	}
	
	public void fireWorldChangeedEvent(){
		listeners.each { listener ->
			listener.worldChanged(this)
		}
	}
	
	Thread myThread= new Thread("") {
		public void run(){
			while(true) {
				loop();
				try{
					Thread.sleep 20
				}
				catch (Exception) {
					e.printStackTrace();	
				}
			}
		}
	};
	
	public void start(){
		myThread.start();
	}
}
