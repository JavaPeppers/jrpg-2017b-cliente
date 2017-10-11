package comandos;

import mensajeria.PaqueteDeEnemigos;

public class SetEnemigos extends ComandosEscucha {

	@Override
	public void ejecutar() {
		PaqueteDeEnemigos paqueteEnemigos = (PaqueteDeEnemigos)gson.fromJson(cadenaLeida,  PaqueteDeEnemigos.class);
		juego.setEnemigos(paqueteEnemigos.getEnemigos());
		//System.out.println("llego set en el cliente");
	}

}
