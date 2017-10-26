package comandos;

import estados.Estado;
import estados.EstadoBatallaNPC;
import mensajeria.PaqueteBatallaNPC;

public class BatallaNPC extends ComandosEscucha{
	
	@Override
	public void ejecutar() {
		//Recibo el paquete Batalla del servidor y seteo el estado Batalla NPC para que se borren del mapa
		PaqueteBatallaNPC paqueteBatalla = (PaqueteBatallaNPC) gson.fromJson(cadenaLeida, PaqueteBatallaNPC.class);
		juego.getPersonaje().setEstado(Estado.estadoBatallaNPC);
		Estado.setEstado(null);
		juego.getEnemigos().get(paqueteBatalla.getIdEnemigo()).setEstado(Estado.estadoBatallaNPC);
		juego.setEstadoBatallaNPC(new EstadoBatallaNPC(juego, paqueteBatalla));
		Estado.setEstado(juego.getEstadoBatallaNPC());
		
	}

}
