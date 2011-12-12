package edu.cema.safer.model

class Munition extends MobileUnit {
	int lifeCycles

	public Munition(World w, Player player, Unit u, Size s, double speed, double sight, int health, int agressionLevel, int lifeCycles, double heading) {
		super(w, player, new Position(0, 0), s, speed, sight, health, agressionLevel);
		this.heading= heading
		calculateBulletTakeOffPosition(u);
		this.lifeCycles= lifeCycles
		world.addUnit(player, this)
	}
	
	def calculateBulletTakeOffPosition(Unit u){
		def cX= u.position.x+(u.size.x/2)
		def cY= u.position.y+(u.size.y/2)
		
		def maxRadius= Math.sqrt(((u.size.y/2)*(u.size.y/2))+((u.size.x/2)*(u.size.x/2)))
		
		//println "maxRadius $maxRadius"
		
		def dX= Math.cos(heading)*maxRadius
		def dY= Math.sin(heading)*maxRadius
		
		position= new Position(cX+dX, cY+dY)
		//println "Launching bullet $position $heading"
	}

	def onLoop(){
		lifeCycles--;
		if(lifeCycles<=0||health==0)
			world.removeUnit(player, this)
	}
	
	def onBorder() {
		world.removeUnit(player, this)
	}
}