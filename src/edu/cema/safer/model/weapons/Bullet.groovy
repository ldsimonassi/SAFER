package edu.cema.safer.model.weapons

import edu.cema.safer.model.Munition;
import edu.cema.safer.model.Player;
import edu.cema.safer.model.Position;
import edu.cema.safer.model.Size;
import edu.cema.safer.model.World;

class Bullet extends Munition {
	public Bullet(World world, Player player, unit, double heading, int agressionLevel, double speed, int lifeCycles){
		super(world, player, unit, new Size(0.005, 0.005), speed, 0, 1, agressionLevel, lifeCycles, heading);
	}
}
