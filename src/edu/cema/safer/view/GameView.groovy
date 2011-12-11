package edu.cema.safer.view

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import edu.cema.safer.model.World;

class GameView extends JPanel{
	
	World myWorld;
	
	public GameView(World world){
		myWorld= world;
	}
	
	void paint(Graphics g) {
		Graphics2D g2= (Graphics2D)g;
		
	}
}
