package edu.cema.safer.model;

import java.awt.Color;
import java.util.List;

public abstract class Player {
	public Color color;
	public abstract void play(List<Unit> units);
}
