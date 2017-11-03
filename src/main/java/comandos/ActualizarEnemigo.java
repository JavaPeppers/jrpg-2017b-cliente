package comandos;

import mensajeria.PaqueteEnemigo;

public class ActualizarEnemigo extends ComandosEscucha {

	@Override
	public void ejecutar() {
		PaqueteEnemigo paqueteEnemigo = (PaqueteEnemigo) 
				getGson().fromJson(getCadenaLeida(), PaqueteEnemigo.class);
	
		juego.getEnemigos().get(paqueteEnemigo.getId()).setX(paqueteEnemigo.getX());
		juego.getEnemigos().get(paqueteEnemigo.getId()).setY(paqueteEnemigo.getY());
		juego.getEnemigos().get(paqueteEnemigo.getId()).setEstado(paqueteEnemigo.getEstado());
	}

}
