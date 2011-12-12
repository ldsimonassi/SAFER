package edu.cema.safer.model.vehicles

import edu.cema.safer.model.Position;
import edu.cema.safer.model.Size;
import edu.cema.safer.model.MobileUnit;
import edu.cema.safer.model.Player;
import edu.cema.safer.model.World;
import edu.cema.safer.model.weapons.Bullet;

class AFB extends MobileUnit {
	public AFB(World w, Player player, Position p){
		super(w, player,  p, new Size(0.02, 0.02), 0.01, 0.1, 100, 1)
		periodics["gunfire"]=0
	}
	
	def fire(double heading){
		if(health<=0)
			return;
		if(periodics["gunfire"]<=0){
			//println "Fox 5000!! ${periodics["gunfire"]}"
			def bullet= new Bullet(world, player, this, heading, 10, 0.02, 40);
			periodics["gunfire"]= 5;
		}else{
			//println "Cannot fire! ${periodics["gunfire"]}"
		}
	}
	
	
}
