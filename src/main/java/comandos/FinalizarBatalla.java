package comandos;

import estados.Estado;
import mensajeria.PaqueteFinalizarBatalla;

/**
 * The Class FinalizarBatalla.
 */
public class FinalizarBatalla extends ComandosEscucha {

    /*
     * (non-Javadoc)
     *
     * @see mensajeria.Comando#ejecutar()
     */
    @Override
    public void ejecutar() {
        @SuppressWarnings("unused")
        // Creo que esta medio al pedo el paqueteFinalizarBatalla
        PaqueteFinalizarBatalla paqueteFinalizarBatalla
        = (PaqueteFinalizarBatalla) gson.fromJson(
                cadenaLeida, PaqueteFinalizarBatalla.class);
        juego.getPersonaje().setEstado(Estado.ESTADOJUEGO);
        Estado.setEstado(juego.getEstadoJuego());
    }

}
