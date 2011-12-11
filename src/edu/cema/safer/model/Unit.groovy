package edu.cema.safer.model

class Unit {
	def world
	def position
	def heading= 0
	def sight= 2
	def size

	def armor

	class VisibleEnemyUnit {
		def position
		def type
	}
	
	def getVisibleUnits(){
		
	}
}