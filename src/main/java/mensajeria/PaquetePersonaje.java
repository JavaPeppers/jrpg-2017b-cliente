package mensajeria;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import dominio.Item;
import estados.Estado;

/**
 * The Class PaquetePersonaje.
 */
@SuppressWarnings("serial")
public class PaquetePersonaje extends Paquete
        implements Serializable, Cloneable {
	
	private static final int DADDY = 2;

    /**
     * The id.
     */
    private int id;

    /**
     * The id mapa.
     */
    private int idMapa;

    /**
     * The estado.
     */
    private int estado;

    /**
     * The casta.
     */
    private String casta;

    /**
     * The nombre.
     */
    private String nombre;

    /**
     * The raza.
     */
    private String raza;

    /**
     * The salud tope.
     */
    private int saludTope;

    /**
     * The energia tope.
     */
    private int energiaTope;

    /**
     * The fuerza.
     */
    private int fuerza;

    /**
     * The destreza.
     */
    private int destreza;

    /**
     * The inteligencia.
     */
    private int inteligencia;

    /**
     * The nivel.
     */
    private int nivel = 1;

    /**
     * The experiencia.
     */
    private int experiencia;

    /**
     * The puntos skills disponibles.
     */
    private int puntosSkillsDisponibles;

    /**
     * The fuerza skill.
     */
    private int fuerzaSkill;

    /**
     * The destreza skill.
     */
    private int destrezaSkill;

    /**
     * The inteligencia skill.
     */
    private int inteligenciaSkill;
    
	private boolean modoDios;
    
    private boolean modoInvisible;
    
    private boolean modoAtravesarParedes;

	/**
     * The items.
     */
    private ArrayList<Item> items = new ArrayList<Item>();

    /**
     * Instantiates a new paquete personaje.
     *
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public PaquetePersonaje() throws IOException {
        estado = Estado.ESTADOOFFLINE;
    }

    /**
     * Gets the estado.
     *
     * @return the estado
     */
    public int getEstado() {
        return estado;
    }

    /**
     * Sets the estado.
     *
     * @param estadoParam
     *            the new estado
     */
    public void setEstado(final int estadoParam) {
        this.estado = estadoParam;
    }

    /**
     * Gets the mapa.
     *
     * @return the mapa
     */
    public int getMapa() {
        return idMapa;
    }

    /**
     * Sets the mapa.
     *
     * @param mapaParam
     *            the new mapa
     */
    public void setMapa(final int mapaParam) {
        idMapa = mapaParam;
    }

    /**
     * Gets the nivel.
     *
     * @return the nivel
     */
    public int getNivel() {
        return nivel;
    }

    /**
     * Sets the nivel.
     *
     * @param nivelParam
     *            the new nivel
     */
    public void setNivel(final int nivelParam) {
        this.nivel = nivelParam;
    }

    /**
     * Gets the experiencia.
     *
     * @return the experiencia
     */
    public int getExperiencia() {
        return experiencia;
    }

    /**
     * Sets the experiencia.
     *
     * @param experienciaParam
     *            the new experiencia
     */
    public void setExperiencia(final int experienciaParam) {
        this.experiencia = experienciaParam;
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param idParam
     *            the new id
     */
    public void setId(final int idParam) {
        this.id = idParam;
    }

    /**
     * Gets the casta.
     *
     * @return the casta
     */
    public String getCasta() {
        return casta;
    }

    /**
     * Sets the casta.
     *
     * @param castaParam
     *            the new casta
     */
    public void setCasta(final String castaParam) {
        this.casta = castaParam;
    }

    /**
     * Gets the nombre.
     *
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Sets the nombre.
     *
     * @param nombreParam
     *            the new nombre
     */
    public void setNombre(final String nombreParam) {
        this.nombre = nombreParam;
    }

    /**
     * Gets the raza.
     *
     * @return the raza
     */
    public String getRaza() {
        return raza;
    }

    /**
     * Sets the raza.
     *
     * @param razaParam
     *            the new raza
     */
    public void setRaza(final String razaParam) {
        this.raza = razaParam;
    }

    /**
     * Gets the salud tope.
     *
     * @return the salud tope
     */
    public int getSaludTope() {
        return saludTope;
    }

    /**
     * Sets the salud tope.
     *
     * @param saludTopeParam
     *            the new salud tope
     */
    public void setSaludTope(final int saludTopeParam) {
        this.saludTope = saludTopeParam;
    }

    /**
     * Gets the energia tope.
     *
     * @return the energia tope
     */
    public int getEnergiaTope() {
        return energiaTope;
    }

    /**
     * Sets the energia tope.
     *
     * @param energiaTopeParam
     *            the new energia tope
     */
    public void setEnergiaTope(final int energiaTopeParam) {
        this.energiaTope = energiaTopeParam;
    }

    /**
     * Gets the fuerza.
     *
     * @return the fuerza
     */
    public int getFuerza() {
        return fuerza;
    }

    /**
     * Sets the fuerza.
     *
     * @param fuerzaParam
     *            the new fuerza
     */
    public void setFuerza(final int fuerzaParam) {
        this.fuerza = fuerzaParam;
    }

    /**
     * Gets the destreza.
     *
     * @return the destreza
     */
    public int getDestreza() {
        return destreza;
    }

    /**
     * Sets the destreza.
     *
     * @param destrezaParam
     *            the new destreza
     */
    public void setDestreza(final int destrezaParam) {
        this.destreza = destrezaParam;
    }

    /**
     * Gets the inteligencia.
     *
     * @return the inteligencia
     */
    public int getInteligencia() {
        return inteligencia;
    }

    /**
     * Sets the inteligencia.
     *
     * @param inteligenciaParam
     *            the new inteligencia
     */
    public void setInteligencia(final int inteligenciaParam) {
        this.inteligencia = inteligenciaParam;
    }

    /*
     * (non-Javadoc)
     *
     * @see mensajeria.Paquete#clone()
     */
    @Override
    public Object clone() {
        Object obj = null;
        obj = super.clone();
        return obj;
    }

    /**
     * Anadir item.
     *
     * @param i
     *            the i
     */
    public final void anadirItem(final Item i) {
        items.add(i);
    }

    /**
     * Remover item.
     *
     * @param i
     *            the i
     */
    public final void removerItem(final Item i) {
        items.remove(i);
    }

    /**
     * Gets the items.
     *
     * @return the items
     */
    public ArrayList<Item> getItems() {
        return new ArrayList<Item>(items);
    }

    /**
     * Sets the items.
     *
     * @param itemsParam
     *            the new items
     */
    public final void setItems(final ArrayList<Item> itemsParam) {
        this.items = itemsParam;
    }

    /**
     * Gets the item ID.
     *
     * @param index
     *            the index
     * @return the item ID
     */
    public final int getItemID(final int index) {
        return items.get(index).getIdItem();
    }

    /**
     * Anadir item.
     *
     * @param idItem
     *            the id item
     * @param nombreParam
     *            the nombre
     * @param wearLocation
     *            the wear location
     * @param bonusSalud
     *            the bonus salud
     * @param bonusEnergia
     *            the bonus energia
     * @param bonusAtaque
     *            the bonus ataque
     * @param bonusDefensa
     *            the bonus defensa
     * @param bonusMagia
     *            the bonus magia
     * @param foto
     *            the foto
     * @param fotoEquipado
     *            the foto equipado
     */
    public final void anadirItem(final int idItem, final String nombreParam,
            final int wearLocation, final int bonusSalud,
            final int bonusEnergia, final int bonusAtaque,
            final int bonusDefensa, final int bonusMagia, final String foto,
            final String fotoEquipado) {
        try {
            items.add(new Item(idItem, nombreParam, wearLocation, bonusSalud,
                    bonusEnergia, bonusAtaque, bonusDefensa, bonusMagia, foto,
                    fotoEquipado));
            useBonus(bonusSalud, bonusEnergia, bonusAtaque, bonusDefensa,
                    bonusMagia);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Falló al añadir item");

        }
    }

    /**
     * Remover bonus.
     */
    public final void removerBonus() {
        // Intente usar un iterator y por alguna razón no andaba..
        int i = 0;
        while (i < items.size()) {
            sacarBonus(items.get(i).getBonusSalud(),
                    items.get(i).getBonusEnergia(),
                    items.get(i).getBonusFuerza(),
                    items.get(i).getBonusDestreza(),
                    items.get(i).getBonusInteligencia());
            i++;
        }
    }

    /**
     * Sacar bonus.
     *
     * @param bonusSalud
     *            the bonus salud
     * @param bonusEnergia
     *            the bonus energia
     * @param bonusAtaque
     *            the bonus ataque
     * @param bonusDefensa
     *            the bonus defensa
     * @param bonusMagia
     *            the bonus magia
     */
    public final void sacarBonus(final int bonusSalud, final int bonusEnergia,
            final int bonusAtaque, final int bonusDefensa,
            final int bonusMagia) {
        saludTope -= bonusSalud;
        energiaTope -= bonusEnergia;
        fuerza -= bonusAtaque;
        destreza -= bonusDefensa;
        inteligencia -= bonusMagia;
    }

    /**
     * Poner bonus.
     */
    public final void ponerBonus() {
        // Intente usar un iterator y por alguna razón no andaba..
        int i = 0;
        while (i < items.size()) {
            useBonus(items.get(i).getBonusSalud(),
                    items.get(i).getBonusEnergia(),
                    items.get(i).getBonusFuerza(),
                    items.get(i).getBonusDestreza(),
                    items.get(i).getBonusInteligencia());
            i++;
        }
    }

    /**
     * Use bonus.
     *
     * @param bonusSalud
     *            the bonus salud
     * @param bonusEnergia
     *            the bonus energia
     * @param bonusAtaque
     *            the bonus ataque
     * @param bonusDefensa
     *            the bonus defensa
     * @param bonusMagia
     *            the bonus magia
     */
    public void useBonus(final int bonusSalud, final int bonusEnergia,
            final int bonusAtaque, final int bonusDefensa,
            final int bonusMagia) {
        saludTope += bonusSalud;
        energiaTope += bonusEnergia;
        fuerza += bonusAtaque;
        destreza += bonusDefensa;
        inteligencia += bonusMagia;
    }

    /**
     * Gets the cant items.
     *
     * @return the cant items
     */
    public int getCantItems() {
        return items.size();
    }

    /**
     * Anadir item.
     *
     * @param idItem
     *            the id item
     */
    public void anadirItem(final int idItem) {
        try {
            items.add(new Item(idItem, null, 0, 0, 0, 0, 0, 0, null, null));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Falló al añadir item");
        }

    }

    /**
     * Gets the iterator.
     *
     * @return the iterator
     */
    public Iterator<Item> getIterator() {
        return items.iterator();
    }

    /**
     * Remover ultimo item.
     */
    public void removerUltimoItem() {
        items.remove(items.size() - 1);

    }

    /**
     * Nuevo item.
     *
     * @return true, if successful
     */
    public boolean nuevoItem() {
        return items.get(items.size() - 1).getNombre() == null;
    }

    /**
     * Poner bonus.
     *
     * @param cantItems
     *            the cant items
     */
    public void ponerBonus(final int cantItems) {
        int i = 0;
        while (i < cantItems) {
            useBonus(items.get(i).getBonusSalud(),
                    items.get(i).getBonusEnergia(),
                    items.get(i).getBonusFuerza(),
                    items.get(i).getBonusDestreza(),
                    items.get(i).getBonusInteligencia());
            i++;
        }
    }

    /**
     * Sacar ultimo item.
     */
    public void sacarUltimoItem() {
        int i = items.size() - 1;
        if (i >= 0) {
            sacarBonus(items.get(i).getBonusSalud(),
                    items.get(i).getBonusEnergia(),
                    items.get(i).getBonusFuerza(),
                    items.get(i).getBonusDestreza(),
                    items.get(i).getBonusInteligencia());
        }
    }

    /**
     * Poner ultimo item.
     */
    public void ponerUltimoItem() {
        int i = items.size() - 1;
        if (i >= 0) {
            useBonus(items.get(i).getBonusSalud(),
                    items.get(i).getBonusEnergia(),
                    items.get(i).getBonusFuerza(),
                    items.get(i).getBonusDestreza(),
                    items.get(i).getBonusInteligencia());
        }
    }

    /**
     * Eliminar items.
     */
    public void eliminarItems() {
        items.removeAll(items);
    }

    /**
     * Actualizar trueque.
     *
     * @param itemsParam
     *            the items
     */
    public void actualizarTrueque(final ArrayList<Item> itemsParam) {
        this.items.removeAll(this.items);
        for (Item item : itemsParam) {
            this.items.add(item);
        }
    }

    /**
     * Sets the skills.
     *
     * @param salud
     *            the salud
     * @param energia
     *            the energia
     * @param ataque
     *            the ataque
     * @param defensa
     *            the defensa
     * @param intelig
     *            the intelig
     */
    public void setSkills(final int salud, final int energia, final int ataque,
            final int defensa, final int intelig) {
        fuerza = ataque;
        destreza = defensa;
        inteligencia = intelig;
        saludTope = salud;
        energiaTope = energia;

    }

    /**
     * Gets the puntos skills disponibles.
     *
     * @return the puntos skills disponibles
     */
    public int getPuntosSkillsDisponibles() {
        return puntosSkillsDisponibles;
    }

    /**
     * Actualizar puntos skills disponibles.
     *
     * @param puntosSkillsDisponiblesParam
     *            the puntos skills disponibles
     */
    public void actualizarPuntosSkillsDisponibles(
            final int puntosSkillsDisponiblesParam) {
        this.puntosSkillsDisponibles += puntosSkillsDisponiblesParam;
    }

    /**
     * Sets the puntos skills disponibles.
     *
     * @param puntosSkillsDisponiblesParam
     *            the new puntos skills disponibles
     */
    public void setPuntosSkillsDisponibles(
            final int puntosSkillsDisponiblesParam) {
        this.puntosSkillsDisponibles = puntosSkillsDisponiblesParam;
    }

    /**
     * Gets the fuerza skill.
     *
     * @return the fuerza skill
     */
    public int getFuerzaSkill() {
        return fuerzaSkill;
    }

    /**
     * Sets the fuerza skill.
     *
     * @param fuerzaSkillParam
     *            the new fuerza skill
     */
    public void setFuerzaSkill(final int fuerzaSkillParam) {
        this.fuerzaSkill = fuerzaSkillParam;
    }

    /**
     * Gets the destreza skill.
     *
     * @return the destreza skill
     */
    public int getDestrezaSkill() {
        return destrezaSkill;
    }

    /**
     * Sets the destreza skill.
     *
     * @param destrezaSkillParam
     *            the new destreza skill
     */
    public void setDestrezaSkill(final int destrezaSkillParam) {
        this.destrezaSkill = destrezaSkillParam;
    }

    /**
     * Gets the inteligencia skill.
     *
     * @return the inteligencia skill
     */
    public int getInteligenciaSkill() {
        return inteligenciaSkill;
    }

    /**
     * Sets the inteligencia skill.
     *
     * @param inteligenciaSkillParam
     *            the new inteligencia skill
     */
    public void setInteligenciaSkill(final int inteligenciaSkillParam) {
        this.inteligenciaSkill = inteligenciaSkillParam;
    }
    
    public int getIdMapa() {
		return idMapa;
	}

	public void setIdMapa(int idMapa) {
		this.idMapa = idMapa;
	}

	public boolean isModoDios() {
		return this.modoDios;
	}

	public void setModoDios() {
		this.modoDios = !(this.modoDios);
	}

	public void setTinyDaddy() {
		this.fuerza /= DADDY;
	}

	public void setBigDaddy() {
		if(this.fuerza == 0)
			this.fuerza = 1;
		else
			this.fuerza *= DADDY;
	}
	
	public void setAtravesarParedes() {
		this.modoAtravesarParedes = !(this.modoAtravesarParedes);
	}
	
	
	public void setModoInvisible() {
		this.modoInvisible = !(this.modoInvisible);
	}

	public boolean isModoInvisible() {
		return this.modoInvisible;
	}

}
