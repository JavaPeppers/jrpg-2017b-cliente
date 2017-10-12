package comandos;

import mensajeria.PaqueteDeEnemigos;
import mensajeria.PaquetePersonaje;

public class ActualizarEnemigos extends ComandosEscucha {

	@Override
	public void ejecutar() {
		PaqueteDeEnemigos paqueteDeEnemigos = (PaqueteDeEnemigos) gson.fromJson(cadenaLeida, PaqueteDeEnemigos.class);
		
		System.out.println("Pase por aca");
		juego.setEnemigos(paqueteDeEnemigos.getEnemigos());
	}

}
