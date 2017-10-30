package comandos;

import javax.swing.JOptionPane;

import mensajeria.PaquetePersonaje;

/**
 * The Class CrearPersonaje.
 */
public class CrearPersonaje extends ComandosCliente {

    /*
     * (non-Javadoc)
     *
     * @see mensajeria.Comando#ejecutar()
     */
    @Override
    public void ejecutar() {
        JOptionPane.showMessageDialog(null, "Registro exitoso.");
        cliente.setPaquetePersonaje((PaquetePersonaje) getGson()
                .fromJson(getCadenaLeida(), PaquetePersonaje.class));
        cliente.getPaqueteUsuario().setInicioSesion(true);

    }

}
