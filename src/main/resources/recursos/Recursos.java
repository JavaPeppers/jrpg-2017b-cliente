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
     * constante posiciones.
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

        ancho = 256;
        alto = 256;
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
            humanoArriba[i] = spriteHumano.getTile(ancho * i, alto * 2, ancho,
                    alto);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < POSICIONES; i++) {
            humanoArribaDer[i] = spriteHumano.getTile(ancho * i, alto * 3,
                    ancho, alto);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < POSICIONES; i++) {
            humanoDer[i] = spriteHumano.getTile(ancho * i, alto * 4, ancho,
                    alto);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < POSICIONES; i++) {
            humanoAbajoDer[i] = spriteHumano.getTile(ancho * i, alto * 5, ancho,
                    alto);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < POSICIONES; i++) {
            humanoAbajo[i] = spriteHumano.getTile(ancho * i, alto * 6, ancho,
                    alto);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < POSICIONES; i++) {
            humanoAbajoIzq[i] = spriteHumano.getTile(ancho * i, alto * 7, ancho,
                    alto);
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
            orcoArriba[i] = spriteOgro.getTile(ancho * i, alto * 2, ancho,
                    alto);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < POSICIONES; i++) {
            orcoArribaDer[i] = spriteOgro.getTile(ancho * i, alto * 3, ancho,
                    alto);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < POSICIONES; i++) {
            orcoDer[i] = spriteOgro.getTile(ancho * i, alto * 4, ancho, alto);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < POSICIONES; i++) {
            orcoAbajoDer[i] = spriteOgro.getTile(ancho * i, alto * 5, ancho,
                    alto);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < POSICIONES; i++) {
            orcoAbajo[i] = spriteOgro.getTile(ancho * i, alto * 6, ancho, alto);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < POSICIONES; i++) {
            orcoAbajoIzq[i] = spriteOgro.getTile(ancho * i, alto * 7, ancho,
                    alto);
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
            elfoArriba[i] = spriteElfo.getTile(ancho * i, alto * 2, ancho,
                    alto);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < POSICIONES; i++) {
            elfoArribaDer[i] = spriteElfo.getTile(ancho * i, alto * 3, ancho,
                    alto);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < POSICIONES; i++) {
            elfoDer[i] = spriteElfo.getTile(ancho * i, alto * 4, ancho, alto);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < POSICIONES; i++) {
            elfoAbajoDer[i] = spriteElfo.getTile(ancho * i, alto * 5, ancho,
                    alto);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < POSICIONES; i++) {
            elfoAbajo[i] = spriteElfo.getTile(ancho * i, alto * 6, ancho, alto);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < POSICIONES; i++) {
            elfoAbajoIzq[i] = spriteElfo.getTile(ancho * i, alto * 7, ancho,
                    alto);
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
            salvajeArriba[i] = spriteSalvaje.getTile(ancho * i, alto * 2, ancho,
                    alto);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < POSICIONES; i++) {
            salvajeArribaDer[i] = spriteSalvaje.getTile(ancho * i, alto * 3,
                    ancho, alto);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < POSICIONES; i++) {
            salvajeDer[i] = spriteSalvaje.getTile(ancho * i, alto * 4, ancho,
                    alto);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < POSICIONES; i++) {
            salvajeAbajoDer[i] = spriteSalvaje.getTile(ancho * i, alto * 5,
                    ancho, alto);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < POSICIONES; i++) {
            salvajeAbajo[i] = spriteSalvaje.getTile(ancho * i, alto * 6, ancho,
                    alto);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < POSICIONES; i++) {
            salvajeAbajoIzq[i] = spriteSalvaje.getTile(ancho * i, alto * 7,
                    ancho, alto);
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
        setGreenTree(trees.getTile(0, 0, 42, 50));
        actualizarBarraDeCarga(++elementosCargados, menuCarga);
        setNievePiso1(CargadorImagen.cargarImagen("/nieve piso.png"));
        actualizarBarraDeCarga(++elementosCargados, menuCarga);
        setIceBlock(CargadorImagen.cargarImagen("/nieve cubo.png"));

        // Mapa
        if (MenuMapas.getNumberMap() == 1) {
            SpriteSheet mapaAubenor = new SpriteSheet(
                    CargadorImagen.cargarImagen("/Aubenor.png"));
            Tile.setAubenor(new Tile[81]);
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
            for (int y = 0; y < 8; y++) {
                for (int x = 0; x < 10; x++) {
                    Tile.getAubenor()[y * 10 + x + 1] = new Tile(
                            mapaAubenor.getTile(x * 64, y * 64, 64, 64),
                            y * 10 + x + 1, solidezAubenor[y][x], 64, 64);
                }
            }
        } else {
            SpriteSheet mapaAris = new SpriteSheet(
                    CargadorImagen.cargarImagen("/Aris.png"));
            Tile.setAris(new Tile[81]);
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
            for (int y = 0; y < 8; y++) {
                for (int x = 0; x < 10; x++) {
                    Tile.getAris()[y * 10 + x + 1] = new Tile(
                            mapaAris.getTile(x * 64, y * 64, 64, 64),
                            y * 10 + x + 1, solidezAris[y][x], 64, 64);
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
