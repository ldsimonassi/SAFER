package edu.cema.safer.test

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

import edu.cema.safer.model.World;
import edu.cema.safer.scenarios.SimpleStage;
import edu.cema.safer.smartplayer.MockPlayer;
import edu.cema.safer.view.GameView;

def world= new World();

world.scenario= new SimpleStage(5, 5)

def p1= new MockPlayer()
def p2= new MockPlayer()
def p3= new MockPlayer()
def p4= new MockPlayer()
def p5= new MockPlayer()

p1.color= new Color(255, 0, 0);
p2.color= new Color(0, 0, 255);
p3.color= new Color(0, 0, 0);
p4.color= new Color(255, 0, 255);
p5.color= new Color(255, 255, 0);

world.createNewPlayer(p1)
world.createNewPlayer(p2)
world.createNewPlayer(p3)
world.createNewPlayer(p4)
world.createNewPlayer(p5)


def view= new GameView(world)

JFrame frm= new JFrame("Game test")

frm.getContentPane().add(view, BorderLayout.CENTER)
frm.setSize(400, 400);
frm.setVisible true

world.start();