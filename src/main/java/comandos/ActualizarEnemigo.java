package comandos;

import mensajeria.PaqueteEnemigo;

public class ActualizarEnemigo extends ComandosEscucha{

	@Override
	public void ejecutar() {
		PaqueteEnemigo PaqueteEnemigo = (PaqueteEnemigo) gson.fromJson(cadenaLeida, PaqueteEnemigo.class);

		juego.getEnemigos().remove(PaqueteEnemigo.getId());
		juego.getEnemigos().put(PaqueteEnemigo.getId(), PaqueteEnemigo);

		if (juego.getEnemigo().getId() == PaqueteEnemigo.getId()) {
			juego.actualizarEnemigo();
			//VERIFICAR DSP
			juego.getEstadoJuego().actualizarEnemigo();
			juego.getCliente().actualizarEnemigo(juego.getEnemigos().get(PaqueteEnemigo.getId()));

		}
	}	

}
