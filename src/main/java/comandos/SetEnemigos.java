package comandos;

import mensajeria.PaqueteDeEnemigos;

public class SetEnemigos extends ComandosEscucha {

	@Override
	public void ejecutar() {
		//Primero seteo en el juego los enemigos
		PaqueteDeEnemigos paqueteEnemigos = (PaqueteDeEnemigos) gson.fromJson(cadenaLeida, PaqueteDeEnemigos.class);
		if(paqueteEnemigos.getEnemigos()!=null)
				System.out.println("Recibi el paquete de enemigos");
		juego.setEnemigos(paqueteEnemigos.getEnemigos());
	}
}
