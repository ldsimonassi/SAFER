package edu.cema.safer.model

class Size {
	
	public Size(double x, double y){
		this.x= x;
		this.y= y;
	}
	
	def x
	def y
	
	@Override
	public String toString() {
		return "($x, $y)"
	}
}
