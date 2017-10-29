package comandos;

import estados.Estado;
import estados.EstadoBatalla;
import mensajeria.PaqueteBatalla;

/**
 * The Class Batalla.
 */
public class Batalla extends ComandosEscucha {

    /*
     * (non-Javadoc)
     *
     * @see mensajeria.Comando#ejecutar()
     */
    @Override
    public void ejecutar() {
        PaqueteBatalla paqueteBatalla = (PaqueteBatalla) gson
                .fromJson(cadenaLeida, PaqueteBatalla.class);
        juego.getPersonaje().setEstado(Estado.ESTADOBATALLA);
        Estado.setEstado(null);
        juego.setEstadoBatalla(new EstadoBatalla(juego, paqueteBatalla));
        Estado.setEstado(juego.getEstadoBatalla());

    }

}
