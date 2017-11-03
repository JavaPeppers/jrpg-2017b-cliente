package comandos;

import estados.Estado;
import mensajeria.PaqueteEnemigo;

public class DesaparecerEnemigo extends ComandosEscucha {

	@Override
	public void ejecutar() {
		PaqueteEnemigo paqueteEnemigo = (PaqueteEnemigo) 
				getGson().fromJson(getCadenaLeida(), PaqueteEnemigo.class);
		juego.getEnemigos().get(paqueteEnemigo.getId()).setEstado(Estado.ESTADOBATALLANPC);
	}

}
