package comandos;

import mensajeria.PaqueteDeMovimientosEnemigos;

public class MovEnemigos extends ComandosEscucha{

	@Override
	public void ejecutar() {
		PaqueteDeMovimientosEnemigos pdm = (PaqueteDeMovimientosEnemigos) gson.fromJson(cadenaLeida,PaqueteDeMovimientosEnemigos.class);
		juego.setUbicacionEnemigos(pdm.getEnemigos());
		
	}

}
