package edu.cema.safer.smartplayer

import edu.cema.safer.model.MobileUnit;
import edu.cema.safer.model.Player;

import java.util.List;
import edu.cema.safer.model.Unit;

class MockPlayer extends Player {
	public void play(List<Unit> units){
		units.each { unit ->
			if(unit instanceof MobileUnit) {
				unit.heading+= (Math.PI/50);
			}
		}	
	}
}
