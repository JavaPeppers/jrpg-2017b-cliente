package cliente;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.sun.xml.internal.fastinfoset.sax.Properties;

import comandos.ComandosCliente;
import frames.MenuCarga;
import frames.MenuComerciar;
import frames.MenuJugar;
import frames.MenuMapas;
import juego.Juego;
import mensajeria.Comando;
import mensajeria.Paquete;
import mensajeria.PaqueteComerciar;
import mensajeria.PaqueteMensaje;
import mensajeria.PaquetePersonaje;
import mensajeria.PaqueteUsuario;

/**
 * La clase Cliente tiene como función. ejecutar el cliente.
 */
public class Cliente extends Thread {

    /**
     * constante alto.
     */
    private static final int ALTO = 600;

    /**
     * constante ancho.
     */
    private static final int ANCHO = 800;

    /**
     * The cliente.
     */
    private Socket cliente;

    /**
     * The mi ip.
     */
    private String miIp;

    /**
     * The entrada.
     */
    private ObjectInputStream entrada;

    /**
     * The salida.
     */
    private ObjectOutputStream salida;

    /**
     * The gson.
     */
    // Objeto gson
    private final Gson gson = new Gson();

    /**
     * The paquete usuario.
     */
    // Paquete usuario y paquete personaje
    private PaqueteUsuario paqueteUsuario;

    /**
     * The paquete personaje.
     */
    private PaquetePersonaje paquetePersonaje;

    /**
     * The paquete comercio.
     */
    private PaqueteComerciar paqueteComercio;

    /**
     * The paquete mensaje.
     */
    private PaqueteMensaje paqueteMensaje = new PaqueteMensaje();

    /**
     * The accion.
     */
    // Acciones que realiza el usuario
    private int accion;

    /**
     * The m 1.
     */
    // MENU COMERCIAR
    private MenuComerciar m1;

    /**
     * The ip.
     */
    // Ip y puerto
    private String ip;

    /**
     * The puerto.
     */
    private int puerto;

    /**
     * Pide la accion.
     *
     * @return Devuelve la accion
     */
    public int getAccion() {
        return accion;
    }

    /**
     * Setea la accion.
     *
     * @param accionParam
     *            accion a setear
     */
    public void setAccion(final int accionParam) {
        this.accion = accionParam;
    }

    /**
     * The wome.
     */
    private Juego wome;

    /**
     * The menu carga.
     */
    private MenuCarga menuCarga;

    /**
     * Constructor del Cliente.
     * @throws FileNotFoundException 
     */
    public Cliente() throws FileNotFoundException {

        puerto = getPuerto();
        ip = JOptionPane.showInputDialog(
                "Ingrese IP del servidor: (default localhost)");
        if (ip == null) {
            ip = "localhost";
        }
        try {
            cliente = new Socket(ip, puerto);
            miIp = cliente.getInetAddress().getHostAddress();
            entrada = new ObjectInputStream(cliente.getInputStream());
            salida = new ObjectOutputStream(cliente.getOutputStream());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Fallo al iniciar la aplicación. "
                            + "Revise la conexión con el servidor.");
            System.exit(1);
        }
    }

    /**
     * Instantiates a new cliente.
     *
     * @param ipParam
     *            the ip param
     * @param puertoParam
     *            the puerto param
     */
    public Cliente(final String ipParam, final int puertoParam) {
        try {
            cliente = new Socket(ipParam, puertoParam);
            miIp = cliente.getInetAddress().getHostAddress();
            entrada = new ObjectInputStream(cliente.getInputStream());
            salida = new ObjectOutputStream(cliente.getOutputStream());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Fallo al iniciar la aplicación. "
                            + "Revise la conexión con el servidor.");
            System.exit(1);
        }
    }
    

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Thread#run()
     */
    @Override
    public void run() {
        synchronized (this) {
            try {
                ComandosCliente comand;
                // Creo el paquete que le voy a enviar al servidor
                paqueteUsuario = new PaqueteUsuario();
                MenuJugar menuJugar = null;
                while (!paqueteUsuario.isInicioSesion()) {

                    // Muestro el menú principal
                    if (menuJugar == null) {
                        menuJugar = new MenuJugar(this);
                        menuJugar.setVisible(true);

                        // Creo los paquetes que le voy a enviar al servidor
                        paqueteUsuario = new PaqueteUsuario();
                        paquetePersonaje = new PaquetePersonaje();

                        // Espero a que el usuario seleccione alguna accion
                        wait();

                        comand = (ComandosCliente) Paquete.getObjetoSet(
                        		Comando.NOMBREPAQUETE, getAccion());
                        comand.setCadena(null);
                        comand.setCliente(this);
                        comand.ejecutar();

                        // Le envio el paquete al servidor
                        salida.writeObject(gson.toJson(paqueteUsuario));
                    }
                    // Recibo el paquete desde el servidor
                    String cadenaLeida = (String) entrada.readObject();
                    Paquete paquete = gson.fromJson(cadenaLeida, Paquete.class);

                    comand = (ComandosCliente) paquete.getObjeto(Comando.NOMBREPAQUETE);
                    comand.setCadena(cadenaLeida);
                    comand.setCliente(this);
                    comand.ejecutar();
                }

                // Creo un paquete con el comando mostrar mapas
                paquetePersonaje.setComando(Comando.MOSTRARMAPAS);

                // Abro el menu de eleccion del mapa
                MenuMapas menuElegirMapa = new MenuMapas(this);
                menuElegirMapa.setVisible(true);

                // Espero a que el usuario elija el mapa
                wait();

                // Si clickeo en la Cruz al Seleccionar mapas
                if (paquetePersonaje.getMapa() == 0) {
                    paquetePersonaje.setComando(Comando.DESCONECTAR);
                    salida.writeObject(gson.toJson(paquetePersonaje));
                } else {
                    // Establezco el mapa en el paquete personaje
                    paquetePersonaje.setIp(miIp);

                    // Le envio el paquete con el mapa seleccionado
                    salida.writeObject(gson.toJson(paquetePersonaje));

                    // Cargo NPCS
                    paquetePersonaje.setComando(Comando.SETENEMIGOS);

                    // Le envio el paquete con los enemigos ya cargados
                    salida.writeObject(gson.toJson(paquetePersonaje));

                    // Instancio el juego y cargo los recursos
                    wome = new Juego("World Of the Middle Earth", ANCHO, ALTO,
                            this, paquetePersonaje);

                    // Muestro el menu de carga
                    menuCarga = new MenuCarga(this);
                    menuCarga.setVisible(true);

                    // Espero que se carguen todos los recursos
                    wait();

                    // Inicio el juego
                    wome.start();

                    // Finalizo el menu de carga
                    menuCarga.dispose();
                }
            } catch (IOException | InterruptedException
                    | ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null,
                        "Fallo la conexión con el servidor"
                                + "durante el inicio de sesión.");
                System.exit(1);
            }
        }

    }

    /**
     * Pide el cliente.
     *
     * @return Devuelve el cliente
     */
    public Socket getSocket() {
        return cliente;
    }

    /**
     * Setea el cliente.
     *
     * @param clienteParam
     *            cliente a setear
     */
    public void setSocket(final Socket clienteParam) {
        this.cliente = clienteParam;
    }

    /**
     * Pide la ip.
     *
     * @return Devuelve la ip
     */
    public String getMiIp() {
        return miIp;
    }

    /**
     * Setea la ip.
     *
     * @param miIpParam
     *            ip a setear
     */
    public void setMiIp(final String miIpParam) {
        this.miIp = miIpParam;
    }

    /**
     * Pide la entrada.
     *
     * @return Devuelve la entrada
     */
    public ObjectInputStream getEntrada() {
        return entrada;
    }

    /**
     * Setea la entrada.
     *
     * @param entradaParam
     *            entrada a setear
     */
    public void setEntrada(final ObjectInputStream entradaParam) {
        this.entrada = entradaParam;
    }

    /**
     * Pide la salida.
     *
     * @return Devuelve la salida
     */
    public ObjectOutputStream getSalida() {
        return salida;
    }

    /**
     * Setea la salida.
     *
     * @param salidaParam
     *            salida a setear
     */
    public void setSalida(final ObjectOutputStream salidaParam) {
        this.salida = salidaParam;
    }

    /**
     * Pide el paquete usuario.
     *
     * @return Devuelve el paquete usuario
     */
    public PaqueteUsuario getPaqueteUsuario() {
        return paqueteUsuario;
    }

    /**
     * Pide el paquete personaje.
     *
     * @return Devuelve el paquete personaje
     */
    public PaquetePersonaje getPaquetePersonaje() {
        return paquetePersonaje;
    }

    /**
     * Pide el juego.
     *
     * @return Devuelve el juego.
     */
    public Juego getJuego() {
        return wome;
    }

    /**
     * Pide el menu de carga.
     *
     * @return Devuelve el menu de carga.
     */
    public MenuCarga getMenuCarga() {
        return menuCarga;
    }

    /**
     * Actualizar items.
     *
     * @param paqueteActualizado
     *            the paquete actualizado
     */
    public void actualizarItems(final PaquetePersonaje paqueteActualizado) {
        if (paquetePersonaje.getCantItems() != 0 && paquetePersonaje
                .getCantItems() != paqueteActualizado.getCantItems()) {
            paquetePersonaje.anadirItem(paqueteActualizado.getItems()
                    .get(paqueteActualizado.getItems().size() - 1));
        }
    }

    /**
     * Gets the ip.
     *
     * @return the ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * Actualizar personaje.
     *
     * @param pP
     *            the p P
     */
    public void actualizarPersonaje(final PaquetePersonaje pP) {
        paquetePersonaje = pP;
    }

    /**
     * Gets the wome.
     *
     * @return the wome
     */
    public Juego getWome() {
        return wome;
    }

    /**
     * Sets the wome.
     *
     * @param womeParam
     *            the new wome
     */
    public void setWome(final Juego womeParam) {
        this.wome = womeParam;
    }

    /**
     * Gets the puerto.
     *
     * @return the puerto
     * @throws FileNotFoundException 
     */
    public int getPuerto() throws FileNotFoundException {
        int puerto;
        Scanner sc = new Scanner(new File("puerto.properties"));
        sc.next();
        sc.next();
        puerto = sc.nextInt();
        sc.close();
        return puerto;
    }

    /**
     * Sets the paquete usuario.
     *
     * @param paqueteUsuarioParam
     *            the new paquete usuario
     */
    public void setPaqueteUsuario(final PaqueteUsuario paqueteUsuarioParam) {
        this.paqueteUsuario = paqueteUsuarioParam;
    }

    /**
     * Sets the paquete personaje.
     *
     * @param paquetePersonajeParam
     *            the new paquete personaje
     */
    public void setPaquetePersonaje(
            final PaquetePersonaje paquetePersonajeParam) {
        this.paquetePersonaje = paquetePersonajeParam;
    }

    /**
     * Sets the ip.
     *
     * @param ipParam
     *            the new ip
     */
    public void setIp(final String ipParam) {
        this.ip = ipParam;
    }

    /**
     * Sets the menu carga.
     *
     * @param menuCargaParam
     *            the new menu carga
     */
    public void setMenuCarga(final MenuCarga menuCargaParam) {
        this.menuCarga = menuCargaParam;
    }

    /**
     * Gets the m1.
     *
     * @return the m1
     */
    public MenuComerciar getM1() {
        return m1;
    }

    /**
     * Sets the m1.
     *
     * @param m1Param
     *            the new m1
     */
    public void setM1(final MenuComerciar m1Param) {
        this.m1 = m1Param;
    }

    /**
     * Gets the paquete comercio.
     *
     * @return the paquete comercio
     */
    public PaqueteComerciar getPaqueteComercio() {
        return paqueteComercio;
    }

    /**
     * Sets the paquete comercio.
     *
     * @param paqueteComercioParam
     *            the new paquete comercio
     */
    public void setPaqueteComercio(
            final PaqueteComerciar paqueteComercioParam) {
        this.paqueteComercio = paqueteComercioParam;
    }

    /**
     * Gets the paquete mensaje.
     *
     * @return the paquete mensaje
     */
    public PaqueteMensaje getPaqueteMensaje() {
        return paqueteMensaje;
    }

    /**
     * Sets the paquete mensaje.
     *
     * @param paqueteMensajeParam
     *            the new paquete mensaje
     */
    public void setPaqueteMensaje(final PaqueteMensaje paqueteMensajeParam) {
        this.paqueteMensaje = paqueteMensajeParam;
    }
}
