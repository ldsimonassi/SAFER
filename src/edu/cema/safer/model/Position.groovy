package edu.cema.safer.model

/**
 * Position class
 * Valid values for x & y are between 0 and 1.
 */
class Position {
	def x
	def y
	
	def move(speed, heading) {
		def yInc= Math.sin(heading) * speed;
		def xInc= Math.cos(heading) * speed;
		x+= xInc;
		y+= yInc;

		if(x>1) x= 1;
		if(y>1) y= 1;

		if(x<0) x= 0;
		if(y<0) y= 0;
	}

}
