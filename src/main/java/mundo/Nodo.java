package mundo;

/**
 * The Class Nodo.
 */
public class Nodo {

    /**
     * The x.
     */
    private int x;

    /**
     * The y.
     */
    private int y;

    /**
     * The indice.
     */
    private int indice;

    /**
     * The cantidad de adyacentes.
     */
    private int cantidadDeAdyacentes;

    /**
     * The nodos adyacentes.
     */
    private Nodo[] nodosAdyacentes;

    /**
     * Instantiates a new nodo.
     *
     * @param indiceParam
     *            the indice
     * @param xParam
     *            the x
     * @param yParam
     *            the y
     */
    public Nodo(final int indiceParam, final int xParam, final int yParam) {
        this.x = xParam;
        this.y = yParam;
        this.indice = indiceParam;
        cantidadDeAdyacentes = 0;
        nodosAdyacentes = new Nodo[8];
    }

    /**
     * Obtener X.
     *
     * @return the int
     */
    public int obtenerX() {
        return x;
    }

    /**
     * Obtener Y.
     *
     * @return the int
     */
    public int obtenerY() {
        return y;
    }

    /**
     * Obtener indice.
     *
     * @return the int
     */
    public int obtenerIndice() {
        return indice;
    }

    /**
     * Obtener nodos adyacentes.
     *
     * @return the nodo[]
     */
    public Nodo[] obtenerNodosAdyacentes() {
        return nodosAdyacentes;
    }

    /**
     * Agregar adyacente.
     *
     * @param nodo
     *            the nodo
     */
    public void agregarAdyacente(final Nodo nodo) {
        nodosAdyacentes[cantidadDeAdyacentes++] = nodo;
    }

    /**
     * Obtener cantidad de adyacentes.
     *
     * @return the int
     */
    public int obtenerCantidadDeAdyacentes() {
        return cantidadDeAdyacentes;
    }
}
