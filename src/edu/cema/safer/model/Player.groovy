package edu.cema.safer.model

class Player {
	def name
	def world

	
	def getMyUnits(){
		return world.getUnits(this);
	}	
	
	def getVisibleEnemyUnits(){
		
	}
}
