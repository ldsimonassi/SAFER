package edu.cema.safer.view

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
				println "Repainting..."
				GameView.this.repaint();
			}
		});
	}
	
	void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2= (Graphics2D)g;
		myWorld.players.each { player ->
			myWorld.playerUnits[player].each { unit ->
				g2.setColor player.color
				def b= translate(unit.position, unit.size)
				g2.drawRect(b.x, b.y, b.width, b.height)
			}
		}
	}
	
	def translate(Position p, Size s){
		def ret= [:] 
		Dimension d= this.getSize();
		ret["x"]= (int)(p.x*d.width);
		ret["y"]= (int)(p.y*d.height);
		ret["width"]= (int)(s.x*d.width);
		ret["height"]= (int)(s.y*d.height);
		ret
	}

}
