package comandos;

import mensajeria.PaqueteDeMovimientosEnemigos;

public class SetUbEnemigos extends ComandosEscucha{

	@Override
	public void ejecutar() {
		//Dsp seteo sus posiciones
		//Le estoy mandando más posiciones que enemigos para cuando lo quiera usa
		PaqueteDeMovimientosEnemigos pdm = (PaqueteDeMovimientosEnemigos) gson.fromJson(cadenaLeida,PaqueteDeMovimientosEnemigos.class);
		if(pdm.getEnemigos()!=null)
			System.out.println("Recibi el paquete de Ubicacion de enemigos");
		juego.setUbicacionEnemigos(pdm.getEnemigos());
		
	}

}
