package entidades;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

import javax.swing.JOptionPane;

import com.google.gson.Gson;

import chat.VentanaContactos;
import dominio.Enemigo;
import estados.Estado;
import frames.MenuEscape;
import frames.MenuInventario;
import interfaz.MenuInfoPersonaje;
import juego.Juego;
import juego.Pantalla;
import mensajeria.PaqueteBatalla;
import mensajeria.PaqueteBatallaNPC;
import mensajeria.PaqueteComerciar;
import mensajeria.PaqueteEnemigo;
import mensajeria.PaqueteMovimiento;
import mundo.Grafo;
import mundo.Mundo;
import mundo.Nodo;

/**
 * Clase Entidad.
 */
public class Entidad {

    /** The Constant COSTO. */
    private static final double COSTO = 1.5;

	/** The Constant ALTURA. */
	private static final int ALTURA = 10;

	/** The Constant MODIFICOX. */
	private static final int MODIFICOX = 32;

	/** The Constant MODIFICICOY. */
	private static final int MODIFICICOY = 20;

	/** The Constant INCREMENTOY. */
	private static final int INCREMENTOY = 4;

	/** The Constant TAMFONT. */
	private static final int TAMFONT = 15;

	/** The Constant DIFY. */
	private static final int DIFY = 32;

	/** The Constant POSUNOSUP. */
	private static final int POSUNOSUP = 29;

	/** The Constant POSUNOINF. */
	private static final int POSUNOINF = 0;

	/** The Constant POSCEROSUP. */
	private static final int POSCEROSUP = 71;

	/** The Constant POSCEROINF. */
	private static final int POSCEROINF = 44;

	/** The Constant COMERCIOUNO. */
	private static final int COMERCIOUNO = 29;

	/** The Constant LIMCOMERCIOCEROSUP. */
	private static final int LIMCOMERCIOCEROSUP = 71;

	/** The Constant LIMCOMERCIOCEROINF. */
	private static final int LIMCOMERCIOCEROINF = 44;

	/** The Constant LIMCUATROSUP. */
	private static final int LIMCUATROSUP = 559;

	/** The Constant LIMCUATROINF. */
	private static final int LIMCUATROINF = 524;

	/** The Constant LIMTRESSUP. */
	private static final int LIMTRESSUP = 597;

	/** The Constant LIMTRESINF. */
	private static final int LIMTRESINF = 562;

	/** The Constant LIMDOSSUP. */
	private static final int LIMDOSSUP = 105;

	/** The Constant LIMDOSINF. */
	private static final int LIMDOSINF = 3;

	/** The Constant LIMUNOSUP. */
	private static final int LIMUNOSUP = 597;

	/** The Constant LIMUNOINF. */
	private static final int LIMUNOINF = 545;

	/** The Constant LIMCEROSUP. */
	private static final int LIMCEROSUP = 797;

	/** The Constant LIMCEROINF. */
	private static final int LIMCEROINF = 738;

	/** The Constant SEPTIMAANIM. */
	private static final int SEPTIMAANIM = 7;

	/** The Constant SEXTAANIM. */
	private static final int SEXTAANIM = 6;

	/** The Constant QUINTAANIM. */
	private static final int QUINTAANIM = 5;

	/** The Constant CUARTAANIM. */
	private static final int CUARTAANIM = 4;

	/** The Constant TERCERANIM. */
	private static final int TERCERANIM = 3;

	/** The Constant MODIFICADORY. */
	private static final int MODIFICADORY = 32;

	/** The Constant MODIFICADORX. */
	private static final int MODIFICADORX = 64;

	/** The Constant MOVIMIENTOHACIA. */
	private static final int MOVIMIENTOHACIA = 6;

	/**
     * The juego.
     */
    private Juego juego;

    /**
     * The ancho.
     */
    // Tamaño de la entidad
    private int ancho;

    /**
     * The alto.
     */
    private int alto;

    /**
     * The x.
     */
    // Posiciones
    private float x;

    /**
     * The y.
     */
    private float y;

    /**
     * The dx.
     */
    private float dx;

    /**
     * The dy.
     */
    private float dy;

    /**
     * The x inicio.
     */
    private float xInicio;

    /**
     * The y inicio.
     */
    private float yInicio;

    /**
     * The x final.
     */
    private float xFinal;

    /**
     * The y final.
     */
    private float yFinal;

    /**
     * The x offset.
     */
    private int xOffset;

    /**
     * The y offset.
     */
    private int yOffset;

    /**
     * The draw X.
     */
    private int drawX;

    /**
     * The draw Y.
     */
    private int drawY;

    /**
     * The pos mouse recorrido.
     */
    private int[] posMouseRecorrido;

    /**
     * The pos mouse.
     */
    private int[] posMouse;

    /**
     * The tile.
     */
    private int[] tile;

    /**
     * The Constant horizontalIzq.
     */
    private static final int HORIZONTALIZQ = 0;

    /**
     * The Constant diagonalSupIzq.
     */
    private static final int DIAGONALSUPIZQ = 1;

    /**
     * The Constant verticalSup.
     */
    private static final int VERTICALSUP = 2;

    /**
     * The Constant diagonalSupDer.
     */
    private static final int DIAGONALSUPDER = 3;

    /**
     * The Constant horizontalDer.
     */
    // Movimiento Actual
    private static final int HORIZONTALDER = 4;

    /**
     * The Constant diagonalInfDer.
     */
    private static final int DIAGONALINFDER = 5;

    /**
     * The Constant verticalInf.
     */
    private static final int VERTICALINF = 6;

    /**
     * The Constant diagonalInfIzq.
     */
    private static final int DIAGONALINFIZQ = 7;

    /**
     * The movimiento hacia.
     */
    private int movimientoHacia = MOVIMIENTOHACIA;

    /**
     * ArrayList de animaciones que contiene los frames de los personajes.
     */
    private final ArrayList<Animacion> mov;

    /**
     * The en movimiento.
     */
    private boolean enMovimiento;

    /**
     * The gson.
     */
    private final Gson gson = new Gson();

    /**
     * The intervalo envio.
     */
    private int intervaloEnvio = 0;

    /**
     * The pila movimiento.
     */
    // pila de movimiento
    private PilaDeTiles pilaMovimiento;

    /**
     * The tile actual.
     */
    private int[] tileActual;

    /**
     * The tile final.
     */
    private int[] tileFinal;

    /**
     * The tile moverme.
     */
    private int[] tileMoverme;

    /**
     * The mundo.
     */
    private Mundo mundo;

    /**
     * The nombre.
     */
    private String nombre;

    /**
     * The tile personajes.
     */
    private int[] tilePersonajes;

    /**
     * The id enemigo.
     */
    private int idEnemigo;

    /**
     * The x comercio.
     */
    // Ubicacion para abrir comerciar.
    private float xComercio;

    /**
     * The y comercio.
     */
    private float yComercio;

    /**
     * The comercio.
     */
    private float[] comercio;

    /**
     * Constructor de la clase Entidad.
     *
     * @param juegoParam
     *            juego con el que se instancia Entidad
     * @param mundoParam
     *            mundo con el que se instancia Entidad
     * @param anchoParam
     *            ancho
     * @param altoParam
     *            alto
     * @param nombreParam
     *            nombre del personaje
     * @param spawnX
     *            tile X donde spawnea
     * @param spawnY
     *            tile Y donde spawnea
     * @param animaciones
     *            animaciones del personaje
     * @param velAnimacion
     *            velocidad de animacion del personaje
     */
    public Entidad(final Juego juegoParam, final Mundo mundoParam,
            final int anchoParam, final int altoParam, final String nombreParam,
            final float spawnX, final float spawnY,
            final LinkedList<BufferedImage[]> animaciones,
            final int velAnimacion) {
        this.juego = juegoParam;
        this.ancho = anchoParam;
        this.alto = altoParam;
        this.nombre = nombreParam;
        this.mundo = mundoParam;
        xOffset = ancho / 2;
        yOffset = alto / 2;
        x = (int) (spawnX / MODIFICADORX) * MODIFICADORX;
        y = (int) (spawnY / MODIFICADORY) * MODIFICADORY;

        mov = new ArrayList<Animacion>();
        mov.add(new Animacion(velAnimacion, animaciones.get(0)));
        mov.add(new Animacion(velAnimacion, animaciones.get(1)));
        mov.add(new Animacion(velAnimacion, animaciones.get(2)));
        mov.add(new Animacion(velAnimacion, animaciones.get(TERCERANIM)));
        mov.add(new Animacion(velAnimacion, animaciones.get(CUARTAANIM)));
        mov.add(new Animacion(velAnimacion, animaciones.get(QUINTAANIM)));
        mov.add(new Animacion(velAnimacion, animaciones.get(SEXTAANIM)));
        mov.add(new Animacion(velAnimacion, animaciones.get(SEPTIMAANIM)));

        // Informo mi posicion actual
        juego.getUbicacionPersonaje().setPosX(x);
        juego.getUbicacionPersonaje().setPosY(y);
        juego.getUbicacionPersonaje().setDireccion(getDireccion());
        juego.getUbicacionPersonaje().setFrame(getFrame());
    }

    /**
     * Actualiza el personaje.
     */
    public void actualizar() {

        if (enMovimiento) {
            for (int i = 0; i < mov.size(); i++) {
                mov.get(i).actualizar();
            }
        } else {
            for (int i = 0; i < mov.size(); i++) {
                mov.get(i).reset();
            }
        }

        getEntrada();
        mover();

        juego.getCamara().centrar(this);
    }

    /**
     * Devuelve la entrada.
     */
    public void getEntrada() {
        posMouseRecorrido = juego.getHandlerMouse().getPosMouseRecorrido();
        posMouse = juego.getHandlerMouse().getPosMouse();
        if (juego.getHandlerMouse().getNuevoClick() && posMouse[0] >= LIMCEROINF
                && posMouse[0] <= LIMCEROSUP && posMouse[1] >= LIMUNOINF
                && posMouse[1] <= LIMUNOSUP) {
            if (Pantalla.getMenuInventario() == null) {
                Pantalla.setMenuInventario(
                        new MenuInventario(juego.getCliente()));
                Pantalla.getMenuInventario().setVisible(true);
            }
            juego.getHandlerMouse().setNuevoClick(false);
        }
        if (juego.getHandlerMouse().getNuevoClick() && posMouse[0] >= LIMDOSINF
                && posMouse[0] <= LIMDOSSUP && posMouse[1] >= LIMTRESINF
                && posMouse[1] <= LIMTRESSUP) {
            if (Pantalla.getMenuEscp() == null) {
                Pantalla.setMenuEscp(new MenuEscape(juego.getCliente()));
                Pantalla.getMenuEscp().setVisible(true);
            }
            juego.getHandlerMouse().setNuevoClick(false);
        }
        if (juego.getHandlerMouse().getNuevoClick() && posMouse[0] >= LIMDOSINF
                && posMouse[0] <= LIMDOSSUP && posMouse[1] >= LIMCUATROINF
                && posMouse[1] <= LIMCUATROSUP) {
            if (Pantalla.getVentContac() == null) {
                Pantalla.setVentContac(new VentanaContactos(juego));
                Pantalla.getVentContac().setVisible(true);
            }
            juego.getHandlerMouse().setNuevoClick(false);
        }
        // Tomo el click izquierdo
        if (juego.getHandlerMouse().getNuevoClick()) {
            if (juego.getEstadoJuego().getHaySolicitud()) {

                if (juego.getEstadoJuego().getMenuEnemigo()
                        .clickEnMenu(posMouse[0], posMouse[1])) {
                    if (juego.getEstadoJuego().getMenuEnemigo()
                            .clickEnBoton(posMouse[0], posMouse[1])) {
                        // Pregunto si menuBatallar o menuComerciar, sino no me
                        // interesa hacer esto
                        if (juego.getEstadoJuego().getTipoSolicitud()
                                == MenuInfoPersonaje.MENUBATALLAR
                                || juego.getEstadoJuego().getTipoSolicitud()
                                == MenuInfoPersonaje.MENUCOMERCIAR) {
                            // Guardo las poss con el que quiero comerciar
                            xComercio = juego.getUbicacionPersonajes()
                                    .get(idEnemigo).getPosX();
                            yComercio = juego.getUbicacionPersonajes()
                                    .get(idEnemigo).getPosY();
                            comercio = Mundo.isoA2D(xComercio, yComercio);
                        }
                        // pregunto si el menu emergente es de tipo batalla
                        if (juego.getEstadoJuego().getTipoSolicitud()
                                == MenuInfoPersonaje.MENUBATALLAR) {
                            // ME FIJO SI CON EL QUE QUIERO BATALLAR ESTA EN LA
                            // ZONA DE COMERCIO
                            if (!((int) comercio[0] >= LIMCOMERCIOCEROINF
                                    && (int) comercio[0] <= LIMCOMERCIOCEROSUP
                                    && (int) comercio[1] >= 0
                                    && (int) comercio[1] <= COMERCIOUNO)) {
                                juego.getEstadoJuego().setHaySolicitud(false,
                                        null, MenuInfoPersonaje.MENUBATALLAR);
                                PaqueteBatalla pBatalla = new PaqueteBatalla();

                                pBatalla.setId(juego.getPersonaje().getId());
                                pBatalla.setIdEnemigo(idEnemigo);

                                juego.getEstadoJuego().setHaySolicitud(false,
                                        null, MenuInfoPersonaje.MENUBATALLAR);

                                try {
                                    juego.getCliente().getSalida()
                                            .writeObject(gson.toJson(pBatalla));
                                } catch (IOException e) {
                                    JOptionPane.showMessageDialog(null,
                                            "Fallo la conexión "
                                                    + "con el servidor");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null,
                                        "El otro usuario se encuentra"
                                    + "dentro de la zona de comercio");
                            }
                        } else {
                            // PREGUNTO SI EL MENU EMERGENTE ES DE TIPO COMERCIO
                            if (juego.getEstadoJuego().getTipoSolicitud()
                                    == MenuInfoPersonaje.MENUCOMERCIAR) {
                                if ((int) comercio[0] >= LIMCOMERCIOCEROINF
                                    && (int) comercio[0] <= LIMCOMERCIOCEROSUP
                                	&& (int) comercio[1] >= 0
                                	&& (int) comercio[1] <= COMERCIOUNO) {
                                    if (juego.getCliente().getM1() == null) {
                                        juego.getCliente().setPaqueteComercio(
                                                new PaqueteComerciar());
                                        juego.getCliente().getPaqueteComercio()
                                                .setId(juego.getPersonaje()
                                                        .getId());
                                        juego.getCliente().getPaqueteComercio()
                                                .setIdEnemigo(idEnemigo);

                                        try {
                                            juego.getCliente().getSalida()
                                                    .writeObject(gson.toJson(
                                      juego.getCliente().getPaqueteComercio()));
                                        } catch (IOException e) {
                                            JOptionPane.showMessageDialog(null,
                                                    "Fallo la conexión "
                                                    + "con el servidor");
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(null,
                                        "Ya te encuentras comerciando!");
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null,
                                            "El otro usuario no se encuentra "
                                         + "dentro de la zona de comercio");
                                }
                            }
                        }
                        juego.getEstadoJuego().setHaySolicitud(false, null,
                                MenuInfoPersonaje.MENUBATALLAR);

                    } else if (juego.getEstadoJuego().getMenuEnemigo()
                            .clickEnCerrar(posMouse[0], posMouse[1])) {
                        juego.getEstadoJuego().setHaySolicitud(false, null,
                                MenuInfoPersonaje.MENUBATALLAR);
                    }
                } else {
                    juego.getEstadoJuego().setHaySolicitud(false, null,
                            MenuInfoPersonaje.MENUBATALLAR);
                }
            } else {
                Iterator<Integer> it = juego.getUbicacionPersonajes().keySet()
                        .iterator();
                int key;
                int[] tileMoverme = Mundo.mouseATile(
                        posMouse[0] + juego.getCamara().getxOffset() - xOffset,
                        posMouse[1] + juego.getCamara().getyOffset() - yOffset);
                PaqueteMovimiento actual;

                while (it.hasNext()) {
                    key = it.next();
                    actual = juego.getUbicacionPersonajes().get(key);
                    tilePersonajes = Mundo.mouseATile(actual.getPosX(),
                            actual.getPosY());
                    if (actual != null
                            && actual.getIdPersonaje() != juego.getPersonaje()
                                    .getId()
                            && juego.getPersonajesConectados()
                                    .get(actual.getIdPersonaje()) != null
                            && juego.getPersonajesConectados()
                                    .get(actual.getIdPersonaje())
                                    .getEstado() == Estado.ESTADOJUEGO) {

                        if (tileMoverme[0] == tilePersonajes[0]
                                && tileMoverme[1] == tilePersonajes[1]) {
                            idEnemigo = actual.getIdPersonaje();
                            float[] xY = Mundo.isoA2D(x, y);
                            // ESTA ESTE PARA NO MOVERME HASTA EL LUGAR.
                            if (xY[0] >= POSCEROINF && xY[0] <= POSCEROSUP
                            		&& xY[1] >= POSUNOINF
                                    && xY[1] <= POSUNOSUP) {
                                // SI ESTOY DENTRO DE LA ZONA DE COMERCIO SETEO
                                // QUE SE ABRA EL MENU
                                // DE COMERCIO
                                juego.getEstadoJuego().setHaySolicitud(true,
                                        juego.getPersonajesConectados()
                                                .get(idEnemigo),
                                        MenuInfoPersonaje.MENUCOMERCIAR);
                            } else {
                                // SI ESTOY DENTRO DE LA ZONA DE BATALLA SETEO
                                // QUE SE ABRA EL MENU
                                // DE BATALLA
                                juego.getEstadoJuego().setHaySolicitud(true,
                                        juego.getPersonajesConectados()
                                                .get(idEnemigo),
                                        MenuInfoPersonaje.MENUBATALLAR);
                            }
                            juego.getHandlerMouse().setNuevoClick(false);
                        }
                    }
                }
            }
        }

        if (juego.getHandlerMouse().getNuevoRecorrido()
                && !juego.getEstadoJuego().getHaySolicitud()) {

            tileMoverme = Mundo.mouseATile(
                    posMouseRecorrido[0] + juego.getCamara().getxOffset()
                            - xOffset,
                    posMouseRecorrido[1] + juego.getCamara().getyOffset()
                            - yOffset);

            juego.getHandlerMouse().setNuevoRecorrido(false);

            pilaMovimiento = null;

            juego.getEstadoJuego().setHaySolicitud(false, null,
                    MenuInfoPersonaje.MENUBATALLAR);
        }

        if (!enMovimiento && tileMoverme != null) {

            enMovimiento = false;

            setxInicio(x);
            setyInicio(y);

            tileActual = Mundo.mouseATile(x, y);

            if (tileMoverme[0] < 0 || tileMoverme[1] < 0
                    || tileMoverme[0] >= mundo.obtenerAncho()
                    || tileMoverme[1] >= mundo.obtenerAlto()) {
                enMovimiento = false;
                juego.getHandlerMouse().setNuevoRecorrido(false);
                pilaMovimiento = null;
                tileMoverme = null;
                return;
            }

            if (tileMoverme[0] == tileActual[0]
                    && tileMoverme[1] == tileActual[1]
                    || mundo.getTile(tileMoverme[0], tileMoverme[1])
                            .esSolido()) {
                tileMoverme = null;
                enMovimiento = false;
                juego.getHandlerMouse().setNuevoRecorrido(false);
                pilaMovimiento = null;
                return;
            }

            if (pilaMovimiento == null) {
                pilaMovimiento = caminoMasCorto(tileActual[0], tileActual[1],
                        tileMoverme[0], tileMoverme[1]);
            }
            // Me muevo al primero de la pila
            NodoDePila nodoActualTile = pilaMovimiento.pop();

            if (nodoActualTile == null) {
                enMovimiento = false;
                juego.getHandlerMouse().setNuevoRecorrido(false);
                pilaMovimiento = null;
                tileMoverme = null;
                return;
            }

            tileFinal = new int[2];
            tileFinal[0] = nodoActualTile.obtenerX();
            tileFinal[1] = nodoActualTile.obtenerY();

            xFinal = Mundo.dosDaIso(tileFinal[0], tileFinal[1])[0];
            yFinal = Mundo.dosDaIso(tileFinal[0], tileFinal[1])[1];

            if (tileFinal[0] == tileActual[0] - 1
                    && tileFinal[1] == tileActual[1] - 1) {
                movimientoHacia = VERTICALSUP;
            }
            if (tileFinal[0] == tileActual[0] + 1
                    && tileFinal[1] == tileActual[1] + 1) {
                movimientoHacia = VERTICALINF;
            }
            if (tileFinal[0] == tileActual[0] - 1
                    && tileFinal[1] == tileActual[1] + 1) {
                movimientoHacia = HORIZONTALIZQ;
            }
            if (tileFinal[0] == tileActual[0] + 1
                    && tileFinal[1] == tileActual[1] - 1) {
                movimientoHacia = HORIZONTALDER;
            }
            if (tileFinal[0] == tileActual[0] - 1
                    && tileFinal[1] == tileActual[1]) {
                movimientoHacia = DIAGONALSUPIZQ;
            }
            if (tileFinal[0] == tileActual[0] + 1
                    && tileFinal[1] == tileActual[1]) {
                movimientoHacia = DIAGONALINFDER;
            }
            if (tileFinal[0] == tileActual[0]
                    && tileFinal[1] == tileActual[1] - 1) {
                movimientoHacia = DIAGONALSUPDER;
            }
            if (tileFinal[0] == tileActual[0]
                    && tileFinal[1] == tileActual[1] + 1) {
                movimientoHacia = DIAGONALINFIZQ;
            }
            enMovimiento = true;
        }
    }

    /**
     * Mueve el personaje.
     */
    public void mover() {

        dx = 0;
        dy = 0;

        double paso = 1;

        if (enMovimiento && !(x == xFinal && y == yFinal - DIFY)) {
            if (movimientoHacia == VERTICALSUP) {
                dy -= paso;
            } else if (movimientoHacia == VERTICALINF) {
                dy += paso;
            } else if (movimientoHacia == HORIZONTALDER) {
                dx += paso;
            } else if (movimientoHacia == HORIZONTALIZQ) {
                dx -= paso;
            } else if (movimientoHacia == DIAGONALINFDER) {
                dx += paso;
                dy += paso / 2;
            } else if (movimientoHacia == DIAGONALINFIZQ) {
                dx -= paso;
                dy += paso / 2;
            } else if (movimientoHacia == DIAGONALSUPDER) {
                dx += paso;
                dy -= paso / 2;
            } else if (movimientoHacia == DIAGONALSUPIZQ) {
                dx -= paso;
                dy -= paso / 2;
            }

            x += dx;
            y += dy;

            // Le envio la posicion
            if (intervaloEnvio == 2) {
                verificarRangoEnemigo();
                enviarPosicion();
                intervaloEnvio = 0;
            }
            intervaloEnvio++;

            if (x == xFinal && y == yFinal - DIFY) {
                enMovimiento = false;
            }
        }
    }

    /**
     * Verificar rango enemigo.
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    private void verificarRangoEnemigo() {
        if (juego.getEnemigos() != null) {
            Map<Integer, PaqueteEnemigo> enemigos;
            enemigos = new HashMap(juego.getEnemigos());

            Iterator<Integer> it = enemigos.keySet().iterator();
            int key;
            PaqueteEnemigo actual;

            while (it.hasNext()) {
                key = it.next();
                actual = enemigos.get(key);
                if (actual != null
                        && actual.getEstado() == Estado.ESTADOJUEGO) {
                    if (Math.sqrt(Math.pow(actual.getX() - x, 2) + Math
                            .pow(actual.getY() - y, 2)) <= Enemigo.RANGO) {

                        PaqueteBatallaNPC pBatalla = new PaqueteBatallaNPC();
                        pBatalla.setId(juego.getPersonaje().getId());
                        pBatalla.setIdEnemigo(key);

                        try {
                            juego.getCliente().getSalida()
                                    .writeObject(gson.toJson(pBatalla));
                        } catch (IOException e) {
                            System.out.println(
                                    "Error al enviar paquete Batalla NPC");
                        }

                        // esPelea = true;
                        break;
                    }
                }
            }
        }
    }

    /**
     * Grafica el frame del personaje.
     *
     * @param g
     *            se recibe grafico.
     */
    public void graficar(final Graphics g) {
        drawX = (int) (x - juego.getCamara().getxOffset());
        drawY = (int) (y - juego.getCamara().getyOffset());
        g.drawImage(getFrameAnimacionActual(), drawX, drawY + INCREMENTOY,
        		ancho, alto,
                null);
    }

    /**
     * Grafica el nombre.
     *
     * @param g
     *            se recibe el grafico.
     */
    public void graficarNombre(final Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Book Antiqua", Font.BOLD, TAMFONT));
        Pantalla.centerString(g,
                new java.awt.Rectangle(drawX + MODIFICOX, drawY - MODIFICICOY,
                		0, ALTURA), nombre);
    }

    /**
     * Obtiene el frameActual del personaje.
     *
     * @return frameActual
     */
    private BufferedImage getFrameAnimacionActual() {
        return mov.get(movimientoHacia).getFrameActual();
    }

    /**
     * Pide la direccion donde va.
     *
     * @return devuelve el movimiento hacia donde va
     */
    private int getDireccion() {
        return movimientoHacia;
    }

    /**
     * Obtiene el frame donde esta el personaje.
     *
     * @return frame
     */
    private int getFrame() {
        return mov.get(movimientoHacia).getFrame();
    }

    /**
     * Envia la posicion del personaje.
     */
    private void enviarPosicion() {
        juego.getUbicacionPersonaje().setPosX(x);
        juego.getUbicacionPersonaje().setPosY(y);
        juego.getUbicacionPersonaje().setDireccion(getDireccion());
        juego.getUbicacionPersonaje().setFrame(getFrame());
        try {
            juego.getCliente().getSalida().writeObject(gson.toJson(
                    juego.getUbicacionPersonaje(), PaqueteMovimiento.class));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Fallo la conexión con el servidor");
        }
    }

    /**
     * Busca el camino más corto a recorrer para llegar a una posición.
     *
     * @param xInicialParam
     *            ubicacion en X inicial
     * @param yInicialParam
     *            ubicacion en Y inicial
     * @param xFinalParam
     *            ubicacion en X final
     * @param yFinalParam
     *            ubicacion en Y final
     * @return la pila de tiles a recorrer
     */
    private PilaDeTiles caminoMasCorto(final int xInicialParam,
            final int yInicialParam, final int xFinalParam,
            final int yFinalParam) {
        Grafo grafoLibres = mundo.obtenerGrafoDeTilesNoSolidos();
        // Transformo las coordenadas iniciales y finales en indices
        int nodoInicial = (yInicialParam
                - grafoLibres.obtenerNodos()[0].obtenerY())
                * (int) Math.sqrt(grafoLibres.obtenerCantidadDeNodosTotal())
                + xInicialParam - grafoLibres.obtenerNodos()[0].obtenerX();

        int nodoFinal = (yFinalParam - grafoLibres.obtenerNodos()[0].obtenerY())
                * (int) Math.sqrt(grafoLibres.obtenerCantidadDeNodosTotal())
                + xFinalParam - grafoLibres.obtenerNodos()[0].obtenerX();

        // Hago todo
        double[] vecCostos = new double[grafoLibres
                .obtenerCantidadDeNodosTotal()];
        int[] vecPredecesores = new int[grafoLibres
                .obtenerCantidadDeNodosTotal()];
        boolean[] conjSolucion = new boolean[grafoLibres
                .obtenerCantidadDeNodosTotal()];
        int cantSolucion = 0;
        // Lleno la matriz de costos de numeros grandes
        for (int i = 0; i < grafoLibres.obtenerCantidadDeNodosTotal(); i++) {
            vecCostos[i] = Double.MAX_VALUE;
        }
        // Adyacentes al nodo inicial
        conjSolucion[nodoInicial] = true;
        cantSolucion++;
        vecCostos[nodoInicial] = 0;
        Nodo[] adyacentes = grafoLibres.obtenerNodos()[nodoInicial]
                .obtenerNodosAdyacentes();
        for (int i = 0; i < grafoLibres.obtenerNodos()[nodoInicial]
                .obtenerCantidadDeAdyacentes(); i++) {
            if (estanEnDiagonal(grafoLibres.obtenerNodos()[nodoInicial],
                    grafoLibres.obtenerNodos()[adyacentes[i]
                            .obtenerIndice()])) {
                vecCostos[adyacentes[i].obtenerIndice()] = COSTO;
            } else {
                vecCostos[adyacentes[i].obtenerIndice()] = 1;
            }
            vecPredecesores[adyacentes[i].obtenerIndice()] = nodoInicial;
        }
        // Aplico Dijkstra
        while (cantSolucion < grafoLibres.obtenerCantidadDeNodosTotal()) {
            // Elijo W perteneciente al conjunto restante tal que el costo de W
            // sea minimo
            double minimo = Double.MAX_VALUE;
            int indiceMinimo = 0;
            @SuppressWarnings("unused")
            Nodo nodoW = null;
            for (int i = 0; i < grafoLibres
                    .obtenerCantidadDeNodosTotal(); i++) {
                if (!conjSolucion[i] && vecCostos[i] < minimo) {
                    nodoW = grafoLibres.obtenerNodos()[i];
                    minimo = vecCostos[i];
                    indiceMinimo = i;
                }
            }
            // Pongo a W en el conj solucion
            conjSolucion[indiceMinimo] = true;
            cantSolucion++;
            // Por cada nodo I adyacente a W del conj restante
            // Le sumo 1 al costo de ir hasta W y luego ir hasta su adyacente
            adyacentes = grafoLibres.obtenerNodos()[indiceMinimo]
                    .obtenerNodosAdyacentes();
            for (int i = 0; i < grafoLibres.obtenerNodos()[indiceMinimo]
                    .obtenerCantidadDeAdyacentes(); i++) {
                double valorASumar = 1;
                if (estanEnDiagonal(grafoLibres.obtenerNodos()[indiceMinimo],
                        grafoLibres.obtenerNodos()[adyacentes[i]
                                .obtenerIndice()])) {
                    valorASumar = COSTO;
                }
                if (vecCostos[indiceMinimo]
                        + valorASumar < vecCostos[adyacentes[i]
                                .obtenerIndice()]) {
                    vecCostos[adyacentes[i]
                            .obtenerIndice()] = vecCostos[indiceMinimo]
                                    + valorASumar;
                    vecPredecesores[adyacentes[i]
                            .obtenerIndice()] = indiceMinimo;
                }
            }
        }
        // Creo el vector de nodos hasta donde quiere llegar
        PilaDeTiles camino = new PilaDeTiles();
        while (nodoFinal != nodoInicial) {
            camino.push(new NodoDePila(
                    grafoLibres.obtenerNodos()[nodoFinal].obtenerX(),
                    grafoLibres.obtenerNodos()[nodoFinal].obtenerY()));
            nodoFinal = vecPredecesores[nodoFinal];
        }

        return camino;
    }

    /**
     * Pregunta si los personajes estan en diagonal.
     *
     * @param nodoUno
     *            personaje 1
     * @param nodoDos
     *            personaje 2
     * @return true or false
     */
    private boolean estanEnDiagonal(final Nodo nodoUno, final Nodo nodoDos) {
        if (nodoUno.obtenerX() == nodoDos.obtenerX()
                || nodoUno.obtenerY() == nodoDos.obtenerY()) {
            return false;
        }
        return true;
    }

    /**
     * Pide el valor de X.
     *
     * @return devuelve la ubicacion en X
     */
    public float getX() {
        return x;
    }

    /**
     * Setea el valor de X.
     *
     * @param xParam
     *            valor nuevo de la ubicacion en X.
     */

    public void setX(final float xParam) {
        this.x = xParam;
    }

    /**
     * Pide el valor de Y.
     *
     * @return devuelve la ubicacion en Y
     */

    public float getY() {
        return y;
    }

    /**
     * Setea el valor de Y.
     *
     * @param yParam
     *            valor nuevo de la ubicacion en Y.
     */

    public void setY(final float yParam) {
        this.y = yParam;
    }

    /**
     * Pide el ancho.
     *
     * @return devuelve el ancho
     */

    public int getAncho() {
        return ancho;
    }

    /**
     * Setea el ancho.
     *
     * @param anchoParam
     *            nuevo ancho a setear.
     */
    public void setAncho(final int anchoParam) {
        this.ancho = anchoParam;
    }

    /**
     * Pide el alto.
     *
     * @return devuelve el alto
     */
    public int getAlto() {
        return alto;
    }

    /**
     * Setea el alto.
     *
     * @param altoParam
     *            nuevo alto a setear.
     */
    public void setAlto(final int altoParam) {
        this.alto = altoParam;
    }

    /**
     * Pide el offset de X.
     *
     * @return devuelve el offset de X
     */
    public int getxOffset() {
        return xOffset;
    }

    /**
     * Pide el offset de Y.
     *
     * @return devuelve el offset de Y
     */
    public int getYOffset() {
        return yOffset;
    }

    /**
     * Gets the x inicio.
     *
     * @return the x inicio
     */
    public float getxInicio() {
        return xInicio;
    }

    /**
     * Sets the x inicio.
     *
     * @param xInicioParam
     *            the new x inicio
     */
    public void setxInicio(final float xInicioParam) {
        this.xInicio = xInicioParam;
    }

    /**
     * Gets the y inicio.
     *
     * @return the y inicio
     */
    public float getyInicio() {
        return yInicio;
    }

    /**
     * Sets the y inicio.
     *
     * @param yInicioParam
     *            the new y inicio
     */
    public void setyInicio(final float yInicioParam) {
        this.yInicio = yInicioParam;
    }

    /**
     * Gets the tile.
     *
     * @return the tile
     */
    public int[] getTile() {
        return tile;
    }

    /**
     * Sets the tile.
     *
     * @param tileParam
     *            the new tile
     */
    public void setTile(final int[] tileParam) {
        this.tile = tileParam;
    }
}
