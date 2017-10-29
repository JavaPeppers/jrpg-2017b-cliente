package comandos;

import estados.Estado;
import mensajeria.PaqueteFinalizarBatallaNPC;

/**
 * The Class FinalizarBatallaNPC.
 */
public class FinalizarBatallaNPC extends ComandosEscucha {

    /*
     * (non-Javadoc)
     *
     * @see mensajeria.Comando#ejecutar()
     */
    @Override
    public void ejecutar() {
        PaqueteFinalizarBatallaNPC paqueteFinalizarBatalla
        = (PaqueteFinalizarBatallaNPC) gson.fromJson(
                cadenaLeida, PaqueteFinalizarBatallaNPC.class);
        juego.getPersonaje().setEstado(Estado.ESTADOJUEGO);
        juego.getEnemigos().get(paqueteFinalizarBatalla.getIdEnemigo())
                .setEstado(Estado.ESTADOJUEGO);
        juego.actualizarEnemigo();
        Estado.setEstado(juego.getEstadoJuego());

    }

}
