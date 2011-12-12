package edu.cema.safer.model

class MobileUnit extends Unit {
	
	public MobileUnit(World w, Player player, Position p, Size s, double speed, double sight, int health, int agressionLevel) {
		super(w, player, p, s, sight, health, agressionLevel);
		this.speed= speed;
	}
	
	def speed= 0.01
	
	def doDamage(int agression) {
		super.doDamage(agression)
		speed*=0.99
		if(health<=0)
			speed= 0;
	}
}