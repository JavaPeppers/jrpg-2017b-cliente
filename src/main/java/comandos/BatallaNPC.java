package comandos;

import estados.Estado;
import estados.EstadoBatallaNPC;
import mensajeria.PaqueteBatallaNPC;

public class BatallaNPC extends ComandosEscucha{
	
	@Override
	public void ejecutar() {
		System.out.println("Recibi paquete batalla");
		PaqueteBatallaNPC paqueteBatalla = (PaqueteBatallaNPC) gson.fromJson(cadenaLeida, PaqueteBatallaNPC.class);
		juego.getPersonaje().setEstado(Estado.estadoBatallaNPC);
		Estado.setEstado(null);
		//Hago desaparecer npc del mapa
		System.out.println("Hago desaparecer el npc del mapa?");
		juego.getEnemigos().get(paqueteBatalla.getIdEnemigo()).setEstado(Estado.estadoBatallaNPC);
		juego.setEstadoBatallaNPC(new EstadoBatallaNPC(juego, paqueteBatalla));
		Estado.setEstado(juego.getEstadoBatallaNPC());
		
	}

}
