package recursos;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import javax.imageio.ImageIO;

import frames.MenuCarga;
import frames.MenuMapas;
import mundo.Tile;

/**
 * The Class Recursos.
 */
public final class Recursos {

    /**
     * Constante FOR2GETTILE.
     */
    private static final int FOR2GETTILE = 10;

    /**
     * Constante FOR1GETTILE.
     */
    private static final int FOR1GETTILE = 8;

    /**
     * Constante ANCHURAALTURAGETARIS.
     */
    private static final int ANCHURAALTURAGETARIS = 64;

    /**
     * Constante SUMAGETARIS.
     */
    private static final int SUMAGETARIS = 1;

    /**
     * Constante MULTIPLICADORYGETARIS.
     */
    private static final int MULTIPLICADORYGETARIS = 10;

    /**
     * Constante ANCHURAALTURAGETAUBENOR.
     */
    private static final int ANCHURAALTURAGETAUBENOR = 64;

    /**
     * Constante MULTIPLICADORYGETTILE.
     */
    private static final int MULTIPLICADORYGETTILE = 64;

    /**
     * Constante ANCHURAALTURAGETTILE.
     */
    private static final int ANCHURAALTURAGETTILE = 64;

    /**
     * Constante MULTIPLICADORXGETTILE.
     */
    private static final int MULTIPLICADORXGETTILE = 64;

    /**
     * Constante SUMAGETAUBENOR.
     */
    private static final int SUMAGETAUBENOR = 1;

    /**
     * Constante MULTIPLICADORYGETAUBENOR.
     */
    private static final int MULTIPLICADORYGETAUBENOR = 10;

    /**
     * Constante TAMANIOTILE.
     */
    private static final int TAMANIOTILE = 81;

    /**
     * Constante ALTOARBOLES.
     */
    private static final int ALTOARBOLES = 50;

    /**
     * Constante ANCHOARBOLES.
     */
    private static final int ANCHOARBOLES = 42;

    /**
     * Constante MULTIPLICADORSALVAJEABAJOIZQ.
     */
    private static final int MULTIPLICADORSALVAJEABAJOIZQ = 7;

    /**
     * Constante MULTIPLICADORSALVAJEABAJO.
     */
    private static final int MULTIPLICADORSALVAJEABAJO = 6;

    /**
     * Constante MULTIPLICADORSALVAJEABAJODER.
     */
    private static final int MULTIPLICADORSALVAJEABAJODER = 5;

    /**
     * Constante MULTIPLICADORSALVAJEDERECHA.
     */
    private static final int MULTIPLICADORSALVAJEDERECHA = 4;

    /**
     * Constante MULTIPLICADORSALVAJEARRIBADER.
     */
    private static final int MULTIPLICADORSALVAJEARRIBADER = 3;

    /**
     * Constante MULTIPLICADORSALVAJEARRIBA.
     */
    private static final int MULTIPLICADORSALVAJEARRIBA = 2;

    /**
     * Constante MULTIPLICADORELFOABAJOIZQ.
     */
    private static final int MULTIPLICADORELFOABAJOIZQ = 7;

    /**
     * Constante MULTIPLICADORELFOABAJO.
     */
    private static final int MULTIPLICADORELFOABAJO = 6;

    /**
     * Constante MULTIPLICADORELFOABAJODER.
     */
    private static final int MULTIPLICADORELFOABAJODER = 5;

    /**
     * Constante MULTIPLICADORELFODERECHA.
     */
    private static final int MULTIPLICADORELFODERECHA = 4;

    /**
     * Constante MULTIPLICADORELFOARRIBADER.
     */
    private static final int MULTIPLICADORELFOARRIBADER = 3;

    /**
     * Constante MULTIPLICADORELFOARRIBA.
     */
    private static final int MULTIPLICADORELFOARRIBA = 2;

    /**
     * Constante MULTIPLICADORORCOABAJOIZQ.
     */
    private static final int MULTIPLICADORORCOABAJOIZQ = 7;

    /**
     * Constante MULTIPLICADORORCOABAJO.
     */
    private static final int MULTIPLICADORORCOABAJO = 6;

    /**
     * Constante MULTIPLICADORORCOABAJODER.
     */
    private static final int MULTIPLICADORORCOABAJODER = 5;

    /**
     * Constante MULTIPLICADORORCODERECHA.
     */
    private static final int MULTIPLICADORORCODERECHA = 4;

    /**
     * Constante MULTIPLICADORORCOARRIBADER.
     */
    private static final int MULTIPLICADORORCOARRIBADER = 3;

    /**
     * Constante MULTIPLICADORORCOARRIBA.
     */
    private static final int MULTIPLICADORORCOARRIBA = 2;

    /**
     * Constante MULTIPLICADORHUMANOABAJOIZQ.
     */
    private static final int MULTIPLICADORHUMANOABAJOIZQ = 7;

    /**
     * Constante MULTIPLICADORHUMANOABAJO.
     */
    private static final int MULTIPLICADORHUMANOABAJO = 6;

    /**
     * Constante MULTIPLICADORHUMANOABAJODER.
     */
    private static final int MULTIPLICADORHUMANOABAJODER = 5;

    /**
     * Constante MULTIPLICADORHUMANODERECHA.
     */
    private static final int MULTIPLICADORHUMANODERECHA = 4;

    /**
     * Constante MULTIPLICADORHUMANOARRIBADER.
     */
    private static final int MULTIPLICADORHUMANOARRIBADER = 3;

    /**
     * Constante MULTIPLICADORHUMANOARRIBA.
     */
    private static final int MULTIPLICADORHUMANOARRIBA = 2;

    /**
     * Constante ALTO.
     */
    private static final int ALTO = 256;

    /**
     * Constante ANCHO.
     */
    private static final int ANCHO = 256;

    /**
     * Constante posiciones.
     */
    private static final int POSICIONES = 4;

    /**
     * Constructor de Recursos.
     */
    private Recursos() {

    }

    /**
     * constante elementos.
     */
    private static final int ELEMENTOS = 65;

    /**
     * constante anchobarra.
     */
    private static final int ANCHOBARRA = 345;

    /**
     * Ancho del frame a obtener.
     */
    private static int ancho;

    /**
     * Alto del frame a obtener.
     */
    private static int alto;

    // Inicio Personajes

    /**
     * Hash de imagenes para los personajes (humano, ogro, elfo).
     */
    private static Map<String, LinkedList<BufferedImage[]>> personaje
                        = new HashMap<>();

    /**
     * Hash de imagenes para los enemigos (se pueden agregar mas Sprites).
     */
    private static Map<String, LinkedList<BufferedImage[]>> enemigos
                        = new HashMap<>();

    /**
     * El sprite humano.
     */
    private static SpriteSheet spriteHumano;

    /**
     * El humano.
     */
    private static LinkedList<BufferedImage[]> humano = new LinkedList<>();

    /**
     * El humano izq.
     */
    private static BufferedImage[] humanoIzq;

    /**
     * El humano arriba izq.
     */
    private static BufferedImage[] humanoArribaIzq;

    /**
     * El humano arriba.
     */
    private static BufferedImage[] humanoArriba;

    /**
     * El humano arriba der.
     */
    private static BufferedImage[] humanoArribaDer;

    /**
     * El humano der.
     */
    private static BufferedImage[] humanoDer;

    /**
     * El humano abajo der.
     */
    private static BufferedImage[] humanoAbajoDer;

    /**
     * El humano abajo.
     */
    private static BufferedImage[] humanoAbajo;

    /**
     * El humano abajo izq.
     */
    private static BufferedImage[] humanoAbajoIzq;

    /**
     * El sprite ogro.
     */
    private static SpriteSheet spriteOgro;

    /**
     * El orco.
     */
    private static LinkedList<BufferedImage[]> orco = new LinkedList<>();

    /**
     * El orco izq.
     */
    private static BufferedImage[] orcoIzq;

    /**
     * El orco arriba izq.
     */
    private static BufferedImage[] orcoArribaIzq;

    /**
     * El orco arriba.
     */
    private static BufferedImage[] orcoArriba;

    /**
     * El orco arriba der.
     */
    private static BufferedImage[] orcoArribaDer;

    /**
     * El orco der.
     */
    private static BufferedImage[] orcoDer;

    /**
     * El orco abajo der.
     */
    private static BufferedImage[] orcoAbajoDer;

    /**
     * El orco abajo.
     */
    private static BufferedImage[] orcoAbajo;

    /**
     * El orco abajo izq.
     */
    private static BufferedImage[] orcoAbajoIzq;

    /**
     * El sprite elfo.
     */
    private static SpriteSheet spriteElfo;

    /**
     * El elfo.
     */
    private static LinkedList<BufferedImage[]> elfo = new LinkedList<>();

    /**
     * El elfo izq.
     */
    private static BufferedImage[] elfoIzq;

    /**
     * El elfo arriba izq.
     */
    private static BufferedImage[] elfoArribaIzq;

    /**
     * El elfo arriba.
     */
    private static BufferedImage[] elfoArriba;

    /**
     * El elfo arriba der.
     */
    private static BufferedImage[] elfoArribaDer;

    /**
     * El elfo der.
     */
    private static BufferedImage[] elfoDer;

    /**
     * El elfo abajo der.
     */
    private static BufferedImage[] elfoAbajoDer;

    /**
     * El elfo abajo.
     */
    private static BufferedImage[] elfoAbajo;

    /**
     * El elfo abajo izq.
     */
    private static BufferedImage[] elfoAbajoIzq;

    /** Es un Enemigo. */
    private static SpriteSheet spriteSalvaje;

    /**
     * El salvaje.
     */
    private static LinkedList<BufferedImage[]> salvaje = new LinkedList<>();

    /**
     * El salvaje izq.
     */
    private static BufferedImage[] salvajeIzq;

    /**
     * El salvaje arriba izq.
     */
    private static BufferedImage[] salvajeArribaIzq;

    /**
     * El salvaje arriba.
     */
    private static BufferedImage[] salvajeArriba;

    /**
     * El salvaje arriba der.
     */
    private static BufferedImage[] salvajeArribaDer;

    /**
     * El salvaje der.
     */
    private static BufferedImage[] salvajeDer;

    /**
     * El salvaje abajo der.
     */
    private static BufferedImage[] salvajeAbajoDer;

    /**
     * El salvaje abajo.
     */
    private static BufferedImage[] salvajeAbajo;

    /**
     * El salvaje abajo izq.
     */
    private static BufferedImage[] salvajeAbajoIzq;

    // Fin Personajes

    // Entorno

    /**
     * Arboles.
     */

    private static SpriteSheet trees;

    /**
     * Cesped.
     */
    private static BufferedImage cesped;

    /**
     * La roca.
     */
    private static BufferedImage roca;

    /**
     * Fondo.
     */
    private static BufferedImage background;

    /**
     * El marco.
     */
    private static BufferedImage marco;

    /**
     * El boton menu.
     */
    private static BufferedImage botonMenu;

    /**
     * El menu enemigo.
     */
    private static BufferedImage menuEnemigo;

    /**
     * El arbol verde.
     */
    private static BufferedImage greenTree;

    /**
     * La nieve piso 1.
     */
    private static BufferedImage nievePiso1;

    /**
     * El bloque de hielo.
     */
    private static BufferedImage iceBlock;

    // Fin Entorno

    // Batalla

    /**
     * La barra spells.
     */

    private static BufferedImage barraSpells;

    /**
     * El estado personaje.
     */
    private static BufferedImage estadoPersonaje;

    /**
     * El barra salud.
     */
    private static BufferedImage barraSalud;

    /**
     * The barra energia.
     */
    private static BufferedImage barraEnergia;

    /**
     * The barra experiencia.
     */
    private static BufferedImage barraExperiencia;

    /**
     * The menu batalla.
     */
    private static BufferedImage menuBatalla;

    /**
     * The menu batalla deshabilitado.
     */
    private static BufferedImage menuBatallaDeshabilitado;

    /**
     * The no item.
     */
    private static BufferedImage noItem;

    /**
     * The mochila.
     */
    private static BufferedImage mochila;

    /**
     * The menu.
     */
    private static BufferedImage menu;

    /**
     * The chat.
     */
    private static BufferedImage chat;

    /**
     * The habilidades.
     */
    private static Map<String, BufferedImage> habilidades = new HashMap<>();
    // Fin Batalla

    // Se cargan todos los recursos del juego una sola vez al inicio

    /**
     * @return the personaje
     */
    public static Map<String, LinkedList<BufferedImage[]>> getPersonaje() {
        return personaje;
    }

    /**
     * @param personajeParam
     *            the personaje to set
     */
    public static void setPersonaje(
            final Map<String, LinkedList<BufferedImage[]>> personajeParam) {
        Recursos.personaje = personajeParam;
    }

    /**
     * @return the enemigos
     */
    public static Map<String, LinkedList<BufferedImage[]>> getEnemigos() {
        return enemigos;
    }

    /**
     * @param enemigosParam
     *            the enemigos to set
     */
    public static void setEnemigos(
            final Map<String, LinkedList<BufferedImage[]>> enemigosParam) {
        Recursos.enemigos = enemigosParam;
    }

    /**
     * @return the orco
     */
    public static LinkedList<BufferedImage[]> getOrco() {
        return orco;
    }

    /**
     * @param orcoParam
     *            the orco to set
     */
    public static void setOrco(final LinkedList<BufferedImage[]> orcoParam) {
        Recursos.orco = orcoParam;
    }

    /**
     * @return the mochila
     */
    public static BufferedImage getMochila() {
        return mochila;
    }

    /**
     * @param mochilaParam
     *            the mochila to set
     */
    public static void setMochila(final BufferedImage mochilaParam) {
        Recursos.mochila = mochilaParam;
    }

    /**
     * @return the salvaje
     */
    public static LinkedList<BufferedImage[]> getSalvaje() {
        return salvaje;
    }

    /**
     * @param salvajeParam
     *            the salvaje to set
     */
    public static void setSalvaje(
            final LinkedList<BufferedImage[]> salvajeParam) {
        Recursos.salvaje = salvajeParam;
    }

    /**
     * Cargar.
     *
     * @param menuCarga
     *            el menu carga
     * @throws NumberFormatException
     *             the number format exception
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */

    public static void cargar(final MenuCarga menuCarga)
            throws NumberFormatException, IOException {

        int elementosCargados = 0;

        ancho = ANCHO;
        alto = ALTO;
        // Items

        setNoItem(ImageIO.read(new File("recursos//noItem.png")));
        mochila = ImageIO.read(new File("recursos//mochila.png"));
        setMenu(ImageIO.read(new File("recursos//menu.png")));
        setChat(ImageIO.read(new File("recursos//chat.png")));

        // Inicio humano
        spriteHumano = new SpriteSheet(
                CargadorImagen.cargarImagen("/Humano.png"));

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        humanoIzq = new BufferedImage[POSICIONES];
        humanoArribaIzq = new BufferedImage[POSICIONES];
        humanoArriba = new BufferedImage[POSICIONES];
        humanoArribaDer = new BufferedImage[POSICIONES];
        humanoDer = new BufferedImage[POSICIONES];
        humanoAbajoDer = new BufferedImage[POSICIONES];
        humanoAbajo = new BufferedImage[POSICIONES];
        humanoAbajoIzq = new BufferedImage[POSICIONES];

        for (int i = 0; i < POSICIONES; i++) {
            humanoIzq[i] = spriteHumano.getTile(ancho * i, 0, ancho, alto);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < POSICIONES; i++) {
            humanoArribaIzq[i] = spriteHumano.getTile(ancho * i, alto, ancho,
                    alto);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < POSICIONES; i++) {
            humanoArriba[i] = spriteHumano.getTile(ancho * i,
                    alto * MULTIPLICADORHUMANOARRIBA, ancho, alto);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < POSICIONES; i++) {
            humanoArribaDer[i] = spriteHumano.getTile(ancho * i,
                    alto * MULTIPLICADORHUMANOARRIBADER, ancho, alto);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < POSICIONES; i++) {
            humanoDer[i] = spriteHumano.getTile(ancho * i,
                    alto * MULTIPLICADORHUMANODERECHA, ancho, alto);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < POSICIONES; i++) {
            humanoAbajoDer[i] = spriteHumano.getTile(ancho * i,
                    alto * MULTIPLICADORHUMANOABAJODER, ancho, alto);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < POSICIONES; i++) {
            humanoAbajo[i] = spriteHumano.getTile(ancho * i,
                    alto * MULTIPLICADORHUMANOABAJO, ancho, alto);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < POSICIONES; i++) {
            humanoAbajoIzq[i] = spriteHumano.getTile(ancho * i,
                    alto * MULTIPLICADORHUMANOABAJOIZQ, ancho, alto);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        humano.add(humanoIzq);
        humano.add(humanoArribaIzq);
        humano.add(humanoArriba);
        humano.add(humanoArribaDer);
        humano.add(humanoDer);
        humano.add(humanoAbajoDer);
        humano.add(humanoAbajo);
        humano.add(humanoAbajoIzq);
        // Fin humano

        // Inicio Ogro
        spriteOgro = new SpriteSheet(CargadorImagen.cargarImagen("/Ogro.png"));

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        orcoIzq = new BufferedImage[POSICIONES];
        orcoArribaIzq = new BufferedImage[POSICIONES];
        orcoArriba = new BufferedImage[POSICIONES];
        orcoArribaDer = new BufferedImage[POSICIONES];
        orcoDer = new BufferedImage[POSICIONES];
        orcoAbajoDer = new BufferedImage[POSICIONES];
        orcoAbajo = new BufferedImage[POSICIONES];
        orcoAbajoIzq = new BufferedImage[POSICIONES];

        for (int i = 0; i < POSICIONES; i++) {
            orcoIzq[i] = spriteOgro.getTile(ancho * i, 0, ancho, alto);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < POSICIONES; i++) {
            orcoArribaIzq[i] = spriteOgro.getTile(ancho * i, alto, ancho, alto);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < POSICIONES; i++) {
            orcoArriba[i] = spriteOgro.getTile(ancho * i,
                    alto * MULTIPLICADORORCOARRIBA, ancho, alto);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < POSICIONES; i++) {
            orcoArribaDer[i] = spriteOgro.getTile(ancho * i,
                    alto * MULTIPLICADORORCOARRIBADER, ancho, alto);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < POSICIONES; i++) {
            orcoDer[i] = spriteOgro.getTile(ancho * i,
                    alto * MULTIPLICADORORCODERECHA, ancho, alto);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < POSICIONES; i++) {
            orcoAbajoDer[i] = spriteOgro.getTile(ancho * i,
                    alto * MULTIPLICADORORCOABAJODER, ancho, alto);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < POSICIONES; i++) {
            orcoAbajo[i] = spriteOgro.getTile(ancho * i,
                    alto * MULTIPLICADORORCOABAJO, ancho, alto);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < POSICIONES; i++) {
            orcoAbajoIzq[i] = spriteOgro.getTile(ancho * i,
                    alto * MULTIPLICADORORCOABAJOIZQ, ancho, alto);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        orco.add(orcoIzq);
        orco.add(orcoArribaIzq);
        orco.add(orcoArriba);
        orco.add(orcoArribaDer);
        orco.add(orcoDer);
        orco.add(orcoAbajoDer);
        orco.add(orcoAbajo);
        orco.add(orcoAbajoIzq);

        // Fin Ogro

        // Inicio Elfo
        spriteElfo = new SpriteSheet(CargadorImagen.cargarImagen("/elfo2.png"));

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        elfoIzq = new BufferedImage[POSICIONES];
        elfoArribaIzq = new BufferedImage[POSICIONES];
        elfoArriba = new BufferedImage[POSICIONES];
        elfoArribaDer = new BufferedImage[POSICIONES];
        elfoDer = new BufferedImage[POSICIONES];
        elfoAbajoDer = new BufferedImage[POSICIONES];
        elfoAbajo = new BufferedImage[POSICIONES];
        elfoAbajoIzq = new BufferedImage[POSICIONES];

        for (int i = 0; i < POSICIONES; i++) {
            elfoIzq[i] = spriteElfo.getTile(ancho * i, 0, ancho, alto);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < POSICIONES; i++) {
            elfoArribaIzq[i] = spriteElfo.getTile(ancho * i, alto, ancho, alto);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < POSICIONES; i++) {
            elfoArriba[i] = spriteElfo.getTile(ancho * i,
                    alto * MULTIPLICADORELFOARRIBA, ancho, alto);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < POSICIONES; i++) {
            elfoArribaDer[i] = spriteElfo.getTile(ancho * i,
                    alto * MULTIPLICADORELFOARRIBADER, ancho, alto);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < POSICIONES; i++) {
            elfoDer[i] = spriteElfo.getTile(ancho * i,
                    alto * MULTIPLICADORELFODERECHA, ancho, alto);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < POSICIONES; i++) {
            elfoAbajoDer[i] = spriteElfo.getTile(ancho * i,
                    alto * MULTIPLICADORELFOABAJODER, ancho, alto);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < POSICIONES; i++) {
            elfoAbajo[i] = spriteElfo.getTile(ancho * i,
                    alto * MULTIPLICADORELFOABAJO, ancho, alto);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < POSICIONES; i++) {
            elfoAbajoIzq[i] = spriteElfo.getTile(ancho * i,
                    alto * MULTIPLICADORELFOABAJOIZQ, ancho, alto);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        elfo.add(elfoIzq);
        elfo.add(elfoArribaIzq);
        elfo.add(elfoArriba);
        elfo.add(elfoArribaDer);
        elfo.add(elfoDer);
        elfo.add(elfoAbajoDer);
        elfo.add(elfoAbajo);
        elfo.add(elfoAbajoIzq);

        // Fin Elfo

        // Inicio Salvaje

        spriteSalvaje = new SpriteSheet(
                CargadorImagen.cargarImagen("/Salvaje.png"));

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        salvajeIzq = new BufferedImage[POSICIONES];
        salvajeArribaIzq = new BufferedImage[POSICIONES];
        salvajeArriba = new BufferedImage[POSICIONES];
        salvajeArribaDer = new BufferedImage[POSICIONES];
        salvajeDer = new BufferedImage[POSICIONES];
        salvajeAbajoDer = new BufferedImage[POSICIONES];
        salvajeAbajo = new BufferedImage[POSICIONES];
        salvajeAbajoIzq = new BufferedImage[POSICIONES];

        for (int i = 0; i < POSICIONES; i++) {
            salvajeIzq[i] = spriteSalvaje.getTile(ancho * i, 0, ancho, alto);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < POSICIONES; i++) {
            salvajeArribaIzq[i] = spriteSalvaje.getTile(ancho * i, alto, ancho,
                    alto);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < POSICIONES; i++) {
            salvajeArriba[i] = spriteSalvaje.getTile(ancho * i,
                    alto * MULTIPLICADORSALVAJEARRIBA, ancho, alto);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < POSICIONES; i++) {
            salvajeArribaDer[i] = spriteSalvaje.getTile(ancho * i,
                    alto * MULTIPLICADORSALVAJEARRIBADER, ancho, alto);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < POSICIONES; i++) {
            salvajeDer[i] = spriteSalvaje.getTile(ancho * i,
                    alto * MULTIPLICADORSALVAJEDERECHA, ancho, alto);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < POSICIONES; i++) {
            salvajeAbajoDer[i] = spriteSalvaje.getTile(ancho * i,
                    alto * MULTIPLICADORSALVAJEABAJODER, ancho, alto);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < POSICIONES; i++) {
            salvajeAbajo[i] = spriteSalvaje.getTile(ancho * i,
                    alto * MULTIPLICADORSALVAJEABAJO, ancho, alto);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < POSICIONES; i++) {
            salvajeAbajoIzq[i] = spriteSalvaje.getTile(ancho * i,
                    alto * MULTIPLICADORSALVAJEABAJOIZQ, ancho, alto);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        salvaje.add(salvajeIzq);
        salvaje.add(salvajeArribaIzq);
        salvaje.add(salvajeArriba);
        salvaje.add(salvajeArribaDer);
        salvaje.add(salvajeDer);
        salvaje.add(salvajeAbajoDer);
        salvaje.add(salvajeAbajo);
        salvaje.add(salvajeAbajoIzq);

        // Fin Salvaje

        // Agrego los pj al hash
        personaje.put("Humano", humano);
        personaje.put("Orco", orco);
        personaje.put("Elfo", elfo);

        // Agrego los enemigos al hash
        enemigos.put("Salvaje", salvaje);

        // Inicio Entorno
        cesped = CargadorImagen.cargarImagen("/Cesped.png");
        actualizarBarraDeCarga(++elementosCargados, menuCarga);
        roca = CargadorImagen.cargarImagen("/rock.png");
        actualizarBarraDeCarga(++elementosCargados, menuCarga);
        setBackground(CargadorImagen.cargarImagen("/background.jpg"));
        actualizarBarraDeCarga(++elementosCargados, menuCarga);
        setMarco(CargadorImagen.cargarImagen("/marco.png"));
        actualizarBarraDeCarga(++elementosCargados, menuCarga);
        setBotonMenu(CargadorImagen.cargarImagen("/botonMenu.png"));
        actualizarBarraDeCarga(++elementosCargados, menuCarga);
        setMenuEnemigo(CargadorImagen.cargarImagen("/MenuEnemigo.png"));
        actualizarBarraDeCarga(++elementosCargados, menuCarga);
        trees = new SpriteSheet(CargadorImagen.cargarImagen("/trees.png"));
        actualizarBarraDeCarga(++elementosCargados, menuCarga);
        setGreenTree(trees.getTile(0, 0, ANCHOARBOLES, ALTOARBOLES));
        actualizarBarraDeCarga(++elementosCargados, menuCarga);
        setNievePiso1(CargadorImagen.cargarImagen("/nieve piso.png"));
        actualizarBarraDeCarga(++elementosCargados, menuCarga);
        setIceBlock(CargadorImagen.cargarImagen("/nieve cubo.png"));

        // Mapa
        if (MenuMapas.getNumberMap() == 1) {
            SpriteSheet mapaAubenor = new SpriteSheet(
                    CargadorImagen.cargarImagen("/Aubenor.png"));
            Tile.setAubenor(new Tile[TAMANIOTILE]);
            boolean[][] solidezAubenor = {
                    {true, true, false, true, false, true, true, true, true,
                            true },
                    {true, true, true, true, true, true, true, true, true,
                            true },
                    {true, true, true, true, true, true, true, true, true,
                            true },
                    {true, false, false, false, false, false, false, false,
                            true, true },
                    {false, false, false, false, false, false, false, false,
                            true, true },
                    {false, true, true, true, true, true, true, true, true,
                            true },
                    {true, true, true, true, true, true, true, true, true,
                            true },
                    {true, true, true, true, true, true, true, true, true,
                            true } };
            for (int y = 0; y < FOR1GETTILE; y++) {
                for (int x = 0; x < FOR2GETTILE; x++) {
                    Tile.getAubenor()[y * MULTIPLICADORYGETAUBENOR + x
                            + SUMAGETAUBENOR] = new Tile(
                                    mapaAubenor.getTile(
                                            x * MULTIPLICADORXGETTILE,
                                            y * MULTIPLICADORYGETTILE,
                                            ANCHURAALTURAGETTILE,
                                            ANCHURAALTURAGETTILE),
                                    y * MULTIPLICADORYGETAUBENOR + x
                                            + SUMAGETAUBENOR,
                                    solidezAubenor[y][x],
                                    ANCHURAALTURAGETAUBENOR,
                                    ANCHURAALTURAGETAUBENOR);
                }
            }
        } else {
            SpriteSheet mapaAris = new SpriteSheet(
                    CargadorImagen.cargarImagen("/Aris.png"));
            Tile.setAris(new Tile[TAMANIOTILE]);
            boolean[][] solidezAris = {
                    {true, false, false, false, false, false, false, true,
                            true, true },
                    {false, false, false, false, false, false, false, false,
                            true, true },
                    {false, false, false, false, true, true, true, true, true,
                            true },
                    {true, true, true, true, true, true, true, true, true,
                            true },
                    {true, true, true, true, true, true, true, true, true,
                            true },
                    {false, true, true, true, true, true, true, true, true,
                            true },
                    {true, true, true, true, true, true, true, true, true,
                            true },
                    {true, true, true, true, true, true, true, true, true,
                            true } };
            for (int y = 0; y < FOR1GETTILE; y++) {
                for (int x = 0; x < FOR2GETTILE; x++) {
                    Tile.getAris()[y * MULTIPLICADORYGETARIS + x
                            + SUMAGETARIS] = new Tile(
                                    mapaAris.getTile(x * MULTIPLICADORXGETTILE,
                                            y * MULTIPLICADORYGETTILE,
                                            ANCHURAALTURAGETTILE,
                                            ANCHURAALTURAGETTILE),
                                    y * MULTIPLICADORYGETARIS + x + SUMAGETARIS,
                                    solidezAris[y][x], ANCHURAALTURAGETARIS,
                                    ANCHURAALTURAGETARIS);
                }
            }
        }

        // Fin Entorno

        // Inicio Batalla
        setBarraSpells(CargadorImagen.cargarImagen("/BarraSpells.png"));
        actualizarBarraDeCarga(++elementosCargados, menuCarga);
        setEstadoPersonaje(CargadorImagen.cargarImagen("/EstadoPersonaje.png"));
        actualizarBarraDeCarga(++elementosCargados, menuCarga);
        setBarraSalud(CargadorImagen.cargarImagen("/BarraDeSalud.png"));
        actualizarBarraDeCarga(++elementosCargados, menuCarga);
        setBarraEnergia(CargadorImagen.cargarImagen("/BarraDeEnergia.png"));
        actualizarBarraDeCarga(++elementosCargados, menuCarga);
        setBarraExperiencia(
                CargadorImagen.cargarImagen("/BarraDeExperiencia.png"));
        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        habilidades.put("Golpe Level",
                CargadorImagen.cargarImagen("/Golpe Level.png"));
        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        habilidades.put("Ataque Bosque",
                CargadorImagen.cargarImagen("/Ataque Bosque.png"));
        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        habilidades.put("Golpe Defensa",
                CargadorImagen.cargarImagen("/Golpe Defensa.png"));
        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        habilidades.put("Mordisco de Vida",
                CargadorImagen.cargarImagen("/Mordisco de Vida.png"));
        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        habilidades.put("Incentivar",
                CargadorImagen.cargarImagen("/Incentivar.png"));
        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        habilidades.put("Golpe Fatal",
                CargadorImagen.cargarImagen("/Golpe Fatal.png"));
        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        habilidades.put("Ataque Doble",
                CargadorImagen.cargarImagen("/Ataque Doble.png"));
        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        habilidades.put("Aumentar Defensa",
                CargadorImagen.cargarImagen("/Aumentar Defensa.png"));
        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        habilidades.put("Ignorar Defensa",
                CargadorImagen.cargarImagen("/Ignorar Defensa.png"));
        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        habilidades.put("Bola de Fuego",
                CargadorImagen.cargarImagen("/Bola de Fuego.png"));
        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        habilidades.put("Curar Aliado",
                CargadorImagen.cargarImagen("/Curar Aliado.png"));
        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        habilidades.put("Robar Energia y Salud",
                CargadorImagen.cargarImagen("/Robar Energia y Salud.png"));
        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        habilidades.put("Golpe Critico",
                CargadorImagen.cargarImagen("/Golpe Critico.png"));
        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        habilidades.put("Aumentar Evasion",
                CargadorImagen.cargarImagen("/Aumentar Evasion.png"));
        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        habilidades.put("Robar", CargadorImagen.cargarImagen("/Robar.png"));
        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        habilidades.put("Ser Energizado",
                CargadorImagen.cargarImagen("/Ser Energizado.png"));
        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        setMenuBatalla(CargadorImagen.cargarImagen("/MenuBatalla.png"));
        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        setMenuBatallaDeshabilitado(
                CargadorImagen.cargarImagen("/MenuBatallaDeshabilitado.png"));
        actualizarBarraDeCarga(++elementosCargados, menuCarga);
        // Fin Batalla
    }

    /**
     * Actualizar barra de carga.
     *
     * @param elementosCargados
     *            the elementos cargados
     * @param menuCarga
     *            the menu carga
     */
    private static void actualizarBarraDeCarga(final int elementosCargados,
            final MenuCarga menuCarga) {
        menuCarga.setBarraCargando(elementosCargados * ANCHOBARRA / ELEMENTOS);
    }

    /**
     * @return the nievePiso1
     */
    public static BufferedImage getNievePiso1() {
        return nievePiso1;
    }

    /**
     * @param nievePiso1Param
     *            the nievePiso1 to set
     */
    public static void setNievePiso1(final BufferedImage nievePiso1Param) {
        Recursos.nievePiso1 = nievePiso1Param;
    }

    /**
     * @return the background
     */
    public static BufferedImage getBackground() {
        return background;
    }

    /**
     * @param backgroundParam
     *            the background to set
     */
    public static void setBackground(final BufferedImage backgroundParam) {
        Recursos.background = backgroundParam;
    }

    /**
     * @return the marco
     */
    public static BufferedImage getMarco() {
        return marco;
    }

    /**
     * @param marcoParam
     *            the marco to set
     */
    public static void setMarco(final BufferedImage marcoParam) {
        Recursos.marco = marcoParam;
    }

    /**
     * @return the botonMenu
     */
    public static BufferedImage getBotonMenu() {
        return botonMenu;
    }

    /**
     * @param botonMenuParam
     *            the botonMenu to set
     */
    public static void setBotonMenu(final BufferedImage botonMenuParam) {
        Recursos.botonMenu = botonMenuParam;
    }

    /**
     * @return the menuEnemigo
     */
    public static BufferedImage getMenuEnemigo() {
        return menuEnemigo;
    }

    /**
     * @param menuEnemigoParam
     *            the menuEnemigo to set
     */
    public static void setMenuEnemigo(final BufferedImage menuEnemigoParam) {
        Recursos.menuEnemigo = menuEnemigoParam;
    }

    /**
     * @return the greenTree
     */
    public static BufferedImage getGreenTree() {
        return greenTree;
    }

    /**
     * @param greenTreeParam
     *            the greenTree to set
     */
    public static void setGreenTree(final BufferedImage greenTreeParam) {
        Recursos.greenTree = greenTreeParam;
    }

    /**
     * @return the iceBlock
     */
    public static BufferedImage getIceBlock() {
        return iceBlock;
    }

    /**
     * @param iceBlockParam
     *            the iceBlock to set
     */
    public static void setIceBlock(final BufferedImage iceBlockParam) {
        Recursos.iceBlock = iceBlockParam;
    }

    /**
     * @return the estadoPersonaje
     */
    public static BufferedImage getEstadoPersonaje() {
        return estadoPersonaje;
    }

    /**
     * @param estadoPersonajeParam
     *            the estadoPersonaje to set
     */
    public static void setEstadoPersonaje(
            final BufferedImage estadoPersonajeParam) {
        Recursos.estadoPersonaje = estadoPersonajeParam;
    }

    /**
     * @return the barraSpells
     */
    public static BufferedImage getBarraSpells() {
        return barraSpells;
    }

    /**
     * @param barraSpellsParam
     *            the barraSpells to set
     */
    public static void setBarraSpells(final BufferedImage barraSpellsParam) {
        Recursos.barraSpells = barraSpellsParam;
    }

    /**
     * @return the barraSalud
     */
    public static BufferedImage getBarraSalud() {
        return barraSalud;
    }

    /**
     * @param barraSaludParam
     *            the barraSalud to set
     */
    public static void setBarraSalud(final BufferedImage barraSaludParam) {
        Recursos.barraSalud = barraSaludParam;
    }

    /**
     * @return the barraEnergia
     */
    public static BufferedImage getBarraEnergia() {
        return barraEnergia;
    }

    /**
     * @param barraEnergiaParam
     *            the barraEnergia to set
     */
    public static void setBarraEnergia(final BufferedImage barraEnergiaParam) {
        Recursos.barraEnergia = barraEnergiaParam;
    }

    /**
     * @return the barraExperiencia
     */
    public static BufferedImage getBarraExperiencia() {
        return barraExperiencia;
    }

    /**
     * @param barraExperienciaParam
     *            the barraExperiencia to set
     */
    public static void setBarraExperiencia(
            final BufferedImage barraExperienciaParam) {
        Recursos.barraExperiencia = barraExperienciaParam;
    }

    /**
     * @return the menuBatalla
     */
    public static BufferedImage getMenuBatalla() {
        return menuBatalla;
    }

    /**
     * @param menuBatallaParam
     *            the menuBatalla to set
     */
    public static void setMenuBatalla(final BufferedImage menuBatallaParam) {
        Recursos.menuBatalla = menuBatallaParam;
    }

    /**
     * @return the menuBatallaDeshabilitado
     */
    public static BufferedImage getMenuBatallaDeshabilitado() {
        return menuBatallaDeshabilitado;
    }

    /**
     * @param menuBatallaDeshabilitadoParam
     *            the menuBatallaDeshabilitado to set
     */
    public static void setMenuBatallaDeshabilitado(
            final BufferedImage menuBatallaDeshabilitadoParam) {
        Recursos.menuBatallaDeshabilitado = menuBatallaDeshabilitadoParam;
    }

    /**
     * @return the noItem
     */
    public static BufferedImage getNoItem() {
        return noItem;
    }

    /**
     * @param noItemParam
     *            the noItem to set
     */
    public static void setNoItem(final BufferedImage noItemParam) {
        Recursos.noItem = noItemParam;
    }

    /**
     * @return the menu
     */
    public static BufferedImage getMenu() {
        return menu;
    }

    /**
     * @param menuParam
     *            the menu to set
     */
    public static void setMenu(final BufferedImage menuParam) {
        Recursos.menu = menuParam;
    }

    /**
     * @return the chat
     */
    public static BufferedImage getChat() {
        return chat;
    }

    /**
     * @param chatParam
     *            the chat to set
     */
    public static void setChat(final BufferedImage chatParam) {
        Recursos.chat = chatParam;
    }

    /**
     * @return the habilidades
     */
    public static Map<String, BufferedImage> getHabilidades() {
        return habilidades;
    }

    /**
     * @param habilidadesParam
     *            the habilidades to set
     */
    public static void setHabilidades(
            final Map<String, BufferedImage> habilidadesParam) {
        Recursos.habilidades = habilidadesParam;
    }
}
