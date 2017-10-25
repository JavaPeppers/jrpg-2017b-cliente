package comandos;

import mensajeria.PaqueteDeEnemigos;

public class SetEnemigos extends ComandosEscucha {

	@Override
	public void ejecutar() {
		//Primero seteo en el juego los enemigos
		PaqueteDeEnemigos paqueteEnemigos = (PaqueteDeEnemigos) gson.fromJson(cadenaLeida, PaqueteDeEnemigos.class);
		for(int i=-1;i>=-10;i--) {
			paqueteEnemigos.getEnemigos().get(i).setMapa(juego.getCliente().getPaquetePersonaje().getMapa());
		}
		juego.setEnemigos(paqueteEnemigos.getEnemigos());
	}
}
