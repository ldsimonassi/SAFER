
package edu.cema.safer.view

import edu.cema.safer.model.Munition;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import edu.cema.safer.model.Position;
import edu.cema.safer.model.Size;
import edu.cema.safer.model.World;
import edu.cema.safer.model.WorldListener;

class GameView extends JPanel implements WorldListener{
	
	World myWorld;
	
	public GameView(World world){
		myWorld= world;
		world.addWorldChangedListener this
	}
	
	public void worldChanged(World w){
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				GameView.this.repaint();
			}
		});
	}
	
	void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2= (Graphics2D)g;
		
		def units= myWorld.viewableUnits
		
		def a= translate(new Position(0, 0), new Size(1, 1))
		g2.setColor Color.DARK_GRAY
		g2.drawRect a.x, a.y, a.width, a.height
		units.each { unit ->
			g2.setColor unit.player.color
			def b= translate(unit.position, unit.size)
			g2.fillRect b.x, b.y, b.width, b.height
			if(!(unit instanceof Munition))
				g2.drawString "${unit.health}", b.x, b.y
		}
	}
	
	def translate(Position p, Size s){
		def ret= [:] 
		def border= 50
		Dimension d= this.getSize();
		d.height-=border*2;
		d.width-=border*2;
		ret["x"]= (int)(p.x*d.width)+border;
		ret["y"]= (int)(p.y*d.height)+border;
		ret["width"]= (int)(s.x*d.width);
		ret["height"]= (int)(s.y*d.height);
		ret
	}

}
