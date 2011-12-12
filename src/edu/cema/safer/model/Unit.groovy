package edu.cema.safer.model

class Unit {
	def world
	def player
	def position
	def heading= 0
	def sight= 0.1
	def size
	def health= 100
	def agressionLevel= 1

	public Unit(World w, Player player, Position p, Size s, double sight, int health, int agressionLevel){
		this.world= w;
		this.player= player;
		this.position= p;
		this.size= s;
		this.sight= sight;
		this.health= health;
		this.agressionLevel= agressionLevel;
	}

	def doDamage(int agression) {
		health-= agression;
		if(health<0) 
			health= 0
	}

	def periodics= [:]
	
	def onBorder() {
		//Do Nothing
	}
	
	def onLoop() {
		periodics.keySet().each { key ->
			//println "discounting $key, ${periodics[key]}" 
			int cycles= periodics[key];
			cycles--;
			if(cycles<=0) cycles=0;
			periodics[key]= cycles;
		}	
	}

	class VisibleEnemyUnit {
		def position
		def type
	}
	
	def getVisibleUnits(){
		
	}
	
	@Override
	public String toString() {
		return "Unit ${getClass().getName()} Position:$position Size:$size Health:$health heading:$heading"
	}
}