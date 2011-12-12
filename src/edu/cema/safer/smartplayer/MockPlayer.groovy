package edu.cema.safer.smartplayer

import edu.cema.safer.model.MobileUnit;
import edu.cema.safer.model.Player;

import java.util.List;
import java.util.Random;

import edu.cema.safer.model.Unit;
import edu.cema.safer.model.vehicles.AFB;

class MockPlayer extends Player {
	public void play(List<Unit> units){
		Random r= new Random(System.currentTimeMillis());
		units.each { unit ->
			if(unit instanceof AFB){
				unit.heading+= (Math.PI/50)+(r.nextDouble()-0.5)*0.3;
				((AFB)unit).fire(unit.heading)
			}
		}	
	}
}