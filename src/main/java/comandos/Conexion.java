package comandos;

//import java.util.Iterator;
import java.util.Map;

import javax.swing.DefaultListModel;
import chat.VentanaContactos;
import mensajeria.PaqueteDePersonajes;
import mensajeria.PaquetePersonaje;

/**
 * The Class Conexion.
 */
public class Conexion extends ComandosEscucha {

    /*
     * (non-Javadoc)
     *
     * @see mensajeria.Comando#ejecutar()
     */
    @Override
    public void ejecutar() {
        PaqueteDePersonajes pdp = (PaqueteDePersonajes) getGson()
                .fromJson(getCadenaLeida(), PaqueteDePersonajes.class);
        juego.setPersonajesConectados(pdp.getPersonajes());
        actualizarLista(pdp);
    }

    /**
     * Actualizar lista.
     *
     * @param pdp
     *            the pdp
     */
    private void actualizarLista(final PaqueteDePersonajes pdp) {
        DefaultListModel<String> modelo = new DefaultListModel<String>();
        VentanaContactos.getList().removeAll();
        for (Map.Entry<Integer, PaquetePersonaje> personaje : pdp
                .getPersonajes().entrySet()) {
            modelo.addElement(personaje.getValue().getNombre());
        }
        modelo.removeElement(juego.getPersonaje().getNombre());
        VentanaContactos.getList().setModel(modelo);
    }
}
