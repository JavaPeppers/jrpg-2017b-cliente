package comandos;

import chat.MiChat;
import chat.VentanaContactos;
import juego.Pantalla;
import mensajeria.PaqueteMensaje;

/**
 * The Class Talk.
 */
public class Talk extends ComandosEscucha {

    /* (non-Javadoc)
     * @see mensajeria.Comando#ejecutar()
     */
    @Override
    public void ejecutar() {
        MiChat chat = null;
        String destino;
        juego.getCliente().setPaqueteMensaje((PaqueteMensaje) getGson()
                .fromJson(getCadenaLeida(), PaqueteMensaje.class));
        if (!(juego.getCliente().getPaqueteMensaje()
                .getUserReceptor() == null)) {
            if (!(juego.getChatsActivos().containsKey(
                    juego.getCliente().getPaqueteMensaje().getUserEmisor()))) {
                chat = new MiChat(juego);

                chat.setTitle(
                        juego.getCliente().getPaqueteMensaje().getUserEmisor());
                chat.setVisible(true);

                juego.getChatsActivos().put(
                        juego.getCliente().getPaqueteMensaje().getUserEmisor(),
                        chat);
            }
            destino = juego.getCliente().getPaqueteMensaje().getUserEmisor();
        } else {
            // ALL
            if (!juego.getChatsActivos().containsKey("Sala")) {
                chat = new MiChat(juego);

                chat.setTitle("Sala");
                chat.setVisible(true);

                juego.getChatsActivos().put("Sala", chat);
                if (Pantalla.getVentContac() != null) {
                    VentanaContactos.getBotonMc().setEnabled(false);
                }
            }
            destino = "Sala";
        }
        juego.getChatsActivos().get(destino).getChat()
                .append(juego.getCliente().getPaqueteMensaje().getUserEmisor()
                        + ": "
                        + juego.getCliente().getPaqueteMensaje().getMensaje()
                        + "\n");
        juego.getChatsActivos().get(destino).getTexto().grabFocus();
    }
}
