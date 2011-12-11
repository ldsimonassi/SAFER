package edu.cema.safer.test

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

import edu.cema.safer.model.World;
import edu.cema.safer.smartplayer.MockPlayer;
import edu.cema.safer.view.GameView;

def world= new World();

def p1= new MockPlayer()

def p2= new MockPlayer()

p1.color= new Color(255, 0, 0);
p2.color= new Color(0, 0, 255);

world.createNewPlayer(p1)
world.createNewPlayer(p2)

def view= new GameView(world)

JFrame frm= new JFrame("Game test")

frm.getContentPane().add(view, BorderLayout.CENTER)
frm.setSize(400, 400);
frm.setVisible true

world.start();