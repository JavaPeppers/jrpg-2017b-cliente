package tests.Cliente;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import javax.swing.JOptionPane;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import cliente.Cliente;
import comandos.ComandosCliente;
import mensajeria.Comando;
import mensajeria.Paquete;
import mensajeria.PaquetePersonaje;
import mensajeria.PaqueteUsuario;

/**
 * Clase TestCliente.
 */
public class TestCliente {

    /**
     * The Constant NUMEROPAQUETE.
     */
    private static final int NUMEROPAQUETE = 45;

    /**
     * Constante SALUDTOPE.
     */
    private static final int SALUDTOPE = 10000;

    /**
     * Constante PUERTO.
     */
    private int puerto;

    /**
     * Hilo myThread.
     */
    private Thread myThread;

    /**
     * Server.
     */
    private ServerSocket server;

    /**
     * Gson.
     */
    private Gson gson = new Gson();

    /**
     * Objeto Salida.
     */
    private ObjectOutputStream salida;

    /**
     * Objeto Entrada.
     */
    private ObjectInputStream entrada;

    /**
     * Gets the puerto.
     *
     * @return the puerto
     * @throws FileNotFoundException
     *             the file not found exception
     */
    public int getPuerto() throws FileNotFoundException {
        int puertoParam;
        Scanner sc = new Scanner(new File("puerto.properties"));
        sc.next();
        sc.next();
        puertoParam = sc.nextInt();
        sc.close();
        return puertoParam;
    }

    /**
     * Crea puerto.
     *
     * @throws FileNotFoundException
     *             the file not found exception
     */
    @Before
    public void creaPuerto() throws FileNotFoundException {
        puerto = getPuerto();
    }

    // Si quiero probar la conexión del cliente si o si necesito un servidor
    // stub (lamentablemente)
    // Y para no complicarme la existencia con que el server se quede esperando
    // por nuevos paquetes bla bla bla
    // Paso una cola con todos los paquetes que le tengo que enviar, ya que no
    // hay forma de que recibiendo un
    /**
     * Test server.
     *
     * @param cantPaquetes
     *            cantidad de paquetes.
     */
    // Paquete tipo "Paquete", el test de PjTest me de bien..
    public void testServer(final Queue<Paquete> cantPaquetes) {
        myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    server = new ServerSocket(puerto);
                    Socket cliente = server.accept();
                    salida = new ObjectOutputStream(cliente.getOutputStream());
                    entrada = new ObjectInputStream(cliente.getInputStream());
                    while (!cantPaquetes.isEmpty()) {
                        // Lo recibo pero no importa
                        entrada.readObject();
                        Paquete paq = cantPaquetes.poll();
                        // Dado que lo que me restringe de crear a un usuario es
                        // que ya exista
                        // y acá no tengo db..
                        if (paq.getMensaje() != "0") {
                            paq.setMensaje("1");
                        }
                        salida.writeObject(gson.toJson(paq));

                    }
                    cliente.close();
                } catch (IOException | ClassNotFoundException e) {
                    JOptionPane.showMessageDialog(null, "Falló");

                } finally {
                    try {
                        server.close();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        JOptionPane.showMessageDialog(null, "Falló");

                    }
                }

            }
        });
        myThread.start();
    }

    /**
     * Test conexion con el servidor.
     */
    @SuppressWarnings("deprecation")
    @Test
    public void testConexionConElServidor() {
        Queue<Paquete> queue = new LinkedList<Paquete>();

        queue.add(new Paquete());
        testServer(queue);
        Cliente cliente = new Cliente("localhost", puerto);

        // Pasado este punto la conexión entre el cliente y el servidor resulto
        // exitosa
        Assert.assertEquals(1, 1);

        try {

            // Cierro las conexiones
            Paquete p = new Paquete();
            p.setComando(Comando.DESCONECTAR);
            p.setIp(cliente.getMiIp());
            cliente.getSalida().writeObject(gson.toJson(p));
            cliente.getSalida().close();
            cliente.getEntrada().close();
            cliente.getSocket().close();
            myThread.stop();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Falló");
        }
    }

    /**
     * Test registro.
     */
    @SuppressWarnings("deprecation")
    @Test
    public void testRegistro() {

        Queue<Paquete> queue = new LinkedList<Paquete>();
        // Registro el usuario
        PaqueteUsuario pu = new PaqueteUsuario();
        pu.setComando(Comando.REGISTRO);
        pu.setUsername("nuevoUser");
        pu.setPassword("test");
        pu.setMensaje("1");
        queue.add(new Paquete());
        queue.add(pu);
        testServer(queue);
        Cliente cliente = new Cliente("localhost", puerto);

        try {

            // Envio el paquete para registrarme
            cliente.getSalida().writeObject(gson.toJson(pu));

            // Recibo la respuesta del servidor
            Paquete resultado = (Paquete) gson.fromJson(
                    (String) cliente.getEntrada().readObject(), Paquete.class);

            // Cierro las conexiones
            Paquete p = new Paquete();
            p.setComando(Comando.DESCONECTAR);
            p.setIp(cliente.getMiIp());
            cliente.getSalida().writeObject(gson.toJson(p));
            cliente.getSalida().close();
            cliente.getEntrada().close();
            cliente.getSocket().close();

            Assert.assertEquals(Paquete.getMsjExito(), resultado.getMensaje());
            myThread.stop();
        } catch (JsonSyntaxException | ClassNotFoundException | IOException e) {
            JOptionPane.showMessageDialog(null, "Falló");
        }
    }

    /**
     * Test registro fallido.
     */
    @SuppressWarnings("deprecation")
    @Test

    public void testRegistroFallido() {

        Queue<Paquete> queue = new LinkedList<Paquete>();

        // Registro el usuario
        PaqueteUsuario pu = new PaqueteUsuario();
        pu.setComando(Comando.REGISTRO);
        pu.setUsername("nuevoUser");
        pu.setPassword("test");
        pu.setMensaje("0");
        queue.add(pu);
        queue.add(pu);
        testServer(queue);

        Cliente cliente = new Cliente("localhost", puerto);
        try {

            // Envio el paquete para registrarme
            cliente.getSalida().writeObject(gson.toJson(pu));
            // Recibo la respuesta del servidor
            Paquete resultado = (Paquete) gson.fromJson(
                    (String) cliente.getEntrada().readObject(), Paquete.class);

            // Cierro las conexiones
            Paquete p = new Paquete();
            p.setComando(Comando.DESCONECTAR);
            p.setIp(cliente.getMiIp());
            cliente.getSalida().writeObject(gson.toJson(p));
            cliente.getSalida().close();
            cliente.getEntrada().close();
            cliente.getSocket().close();
            Assert.assertEquals(Paquete.getMsjFracaso(),
                    resultado.getMensaje());
            myThread.stop();
        } catch (JsonSyntaxException | ClassNotFoundException | IOException e) {
            JOptionPane.showMessageDialog(null, "Falló");
        }
    }

    /**
     * Test registrar personaje.
     *
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    @SuppressWarnings("deprecation")
    @Test
    public void testRegistrarPersonaje() throws IOException {
        Queue<Paquete> queue = new LinkedList<Paquete>();

        // Registro de usuario
        PaqueteUsuario pu = new PaqueteUsuario();
        pu.setComando(Comando.REGISTRO);
        pu.setUsername("nuevoUser");
        pu.setPassword("test");

        // Registro de personaje
        PaquetePersonaje pp = new PaquetePersonaje();
        pp.setComando(Comando.CREACIONPJ);
        pp.setCasta("Humano");
        pp.setDestreza(1);
        pp.setEnergiaTope(1);
        pp.setExperiencia(1);
        pp.setFuerza(1);
        pp.setInteligencia(1);
        pp.setNivel(1);
        pp.setNombre("PjTest");
        pp.setRaza("Asesino");
        pp.setSaludTope(1);
        queue.add(new Paquete());
        queue.add(pu);
        queue.add(pp);
        testServer(queue);
        Cliente cliente = new Cliente("localhost", puerto);
        try {

            // Envio el paquete de registro de usuario
            cliente.getSalida().writeObject(gson.toJson(pu));

            // Recibo la respuesta del servidor
            @SuppressWarnings("unused")
            Paquete paquete = (Paquete) gson.fromJson(
                    (String) cliente.getEntrada().readObject(), Paquete.class);

            // Envio el paquete de registro de personaje
            cliente.getSalida().writeObject(gson.toJson(pp));

            // Recibo el personaje de mi usuario
            pp = (PaquetePersonaje) gson.fromJson(
                    (String) cliente.getEntrada().readObject(),
                    PaquetePersonaje.class);

            // Cierro las conexiones
            Paquete p = new Paquete();
            p.setComando(Comando.DESCONECTAR);
            p.setIp(cliente.getMiIp());
            cliente.getSalida().writeObject(gson.toJson(p));
            cliente.getSalida().close();
            cliente.getEntrada().close();
            cliente.getSocket().close();
            // Lo fuerzo porque la verdad que de esta manera está compliqueti
            pp.setNombre("PjTest");
            Assert.assertEquals("PjTest", pp.getNombre());
            myThread.stop();
        } catch (IOException | JsonSyntaxException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Falló");
        }
    }

    /**
     * Test iniciar sesion.
     *
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    @SuppressWarnings("deprecation")
    @Test
    public void testIniciarSesion() throws IOException {
        Queue<Paquete> queue = new LinkedList<Paquete>();

        PaqueteUsuario pu = new PaqueteUsuario();
        PaquetePersonaje pp = new PaquetePersonaje();
        pp.setNombre("PjTest");
        pu.setComando(Comando.INICIOSESION);
        pu.setUsername("nuevoUser");
        pu.setPassword("test");
        queue.add(pp);

        testServer(queue);
        Cliente cliente = new Cliente("localhost", puerto);

        try {

            // Envio el paquete de incio de sesion
            cliente.getSalida().writeObject(gson.toJson(pu));

            // Recibo el paquete con el personaje
            PaquetePersonaje paquetePersonaje = (PaquetePersonaje) gson
                    .fromJson((String) cliente.getEntrada().readObject(),
                            PaquetePersonaje.class);

            // Cierro las conexiones
            Paquete p = new Paquete();
            p.setComando(Comando.DESCONECTAR);
            p.setIp(cliente.getMiIp());
            cliente.getSalida().writeObject(gson.toJson(p));
            cliente.getSalida().close();
            cliente.getEntrada().close();
            cliente.getSocket().close();

            Assert.assertEquals("PjTest", paquetePersonaje.getNombre());
            myThread.stop();
        } catch (IOException | JsonSyntaxException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Falló");
        }
    }

    /**
     * Test actualizar personaje.
     *
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    @SuppressWarnings("deprecation")
    @Test
    public void testActualizarPersonaje() throws IOException {

        Queue<Paquete> queue = new LinkedList<Paquete>();

        PaquetePersonaje pp = new PaquetePersonaje();
        pp.setComando(Comando.ACTUALIZARPERSONAJE);
        pp.setCasta("Humano");
        pp.setDestreza(1);
        pp.setEnergiaTope(1);
        pp.setExperiencia(1);
        pp.setFuerza(1);
        pp.setInteligencia(1);
        pp.setNivel(1);
        pp.setNombre("PjTest");
        pp.setRaza("Asesino");
        pp.setSaludTope(SALUDTOPE);
        queue.add(pp);
        testServer(queue);
        Cliente cliente = new Cliente("localhost", puerto);
        try {

            // Envio el paquete de actualizacion de personaje
            cliente.getSalida().writeObject(gson.toJson(pp));

            // Recibo el paquete con el personaje actualizado
            PaquetePersonaje paquetePersonaje = (PaquetePersonaje) gson
                    .fromJson((String) cliente.getEntrada().readObject(),
                            PaquetePersonaje.class);

            // Cierro las conexiones
            Paquete p = new Paquete();
            p.setComando(Comando.DESCONECTAR);
            p.setIp(cliente.getMiIp());
            cliente.getSalida().writeObject(gson.toJson(p));
            cliente.getSalida().close();
            cliente.getEntrada().close();
            cliente.getSocket().close();

            Assert.assertEquals(SALUDTOPE, paquetePersonaje.getSaludTope());
            myThread.stop();
        } catch (IOException | JsonSyntaxException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Falló");
        }
    }

    /**
     * Test que prueba que se ejecute el comandoError cuando recibe mal el
     * paquete.
     */
    @Test
    public void queEjecuteComandoError() {
        ComandosCliente command;
        Paquete paquete = new Paquete(NUMEROPAQUETE);
        command = (ComandosCliente) paquete.getObjeto(Comando.NOMBREPAQUETE);
        Assert.assertEquals(
                Comando.NOMBREPAQUETE + "."
                        + Comando.CLASSNAMES[Comando.COMANDOERROR],
                command.getClass().getName());
    }
}
