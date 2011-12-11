package edu.cema.safer.smartplayer

import edu.cema.safer.model.World;

class StatelessPlayer {
	def player

	public play(World w){

		// TODO Generate View DataStructure.
		/**
		 * Recorrer todas las unidades.
		 * Generar un vector de las unidades enemigas visibles.
		 * Coordenadas Class.
		 */

		// TODO Calculate and fire to best targets.
		/**
		 * 1:
		 * Calculamos cuantas miras le apuntan a cada blanco.
		 * Tomamos todos los que tienen uno solo.
		 * Si no hay,
		 * Los que tienen 2 y as’.
		 * Cunando encuentro, agendo ejecuto el disparo y retiro mi unidad y la enemiga de las lista.
		 * GOTO 1
		 */

		// TODO (1) Calcular por unidad una trayectoria evasiva, respecto de las unidades que el ve.
	}
}