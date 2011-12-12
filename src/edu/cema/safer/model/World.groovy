package edu.cema.safer.model

import java.util.LinkedList;

import edu.cema.safer.scenarios.SimpleStage;

class World {
	def players= []
	def playerUnits= [:]
	def scenario= new SimpleStage(3, 3)
	
	def createNewPlayer(Player p) {
		def createdUnits= scenario.createPlayerUnits(p, this)
		playerUnits[p]= createdUnits
		players.add p
	}
	
	
	def addUnit(Player p, Unit u){
		playerUnits[p].add u
	}
	
	def removeUnit(Player p, Unit u){
		playerUnits[p].remove u
	}
	
	def viewableUnits= []
	
	def loop(){
		players.each { player ->
			def copy= []
			copy.addAll(playerUnits[player]);
			player.play(copy)
		}

		def allUnits= []

		playerUnits.values().each { units ->
			units.each { unit ->
				allUnits.add unit
			}
		}

		allUnits.each { unit -> 
			if(unit instanceof MobileUnit){
				boolean border= unit.position.move(unit.speed, unit.heading);
				if(border)
					unit.onBorder()
			}
		}

		allUnits.each { unit1 ->
			allUnits.each { unit2 ->
				if(isCollision(unit1, unit2)) {
					unit1.doDamage(unit2.agressionLevel)
					unit2.doDamage(unit1.agressionLevel)
				}
			}
			unit1.onLoop()
		}
		
		viewableUnits= []
		
		playerUnits.values().each { units ->
			units.each { unit ->
				viewableUnits.add unit
			}
		}
		
		//println("Currently active units ${viewableUnits.size()}")
		
		fireWorldChangeedEvent();
	}
	
	
	public boolean isCollision(Unit unit1, Unit unit2) {
		if(unit1==unit2)
			return false;
		double left1, left2;
		double right1, right2;
		double top1, top2;
		double bottom1, bottom2;
	
		left1 = unit1.position.x;
		left2 = unit2.position.x;
		right1 = unit1.position.x + unit1.size.x;
		right2 = unit2.position.x + unit2.size.x;
		top1 = unit1.position.y;
		top2 = unit2.position.y;
		bottom1 = unit1.position.y + unit1.size.y;
		bottom2 = unit2.position.y + unit2.size.y;
	
		if (bottom1 < top2) 
			return false;
		if (top1 > bottom2) 
			return false;
	
		if (right1 < left2)
			return false;
		if (left1 > right2)
			return false;
			
		return true;
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
