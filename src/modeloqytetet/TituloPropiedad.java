package modeloqytetet;

public class TituloPropiedad {
    
    private final String nombre;
    private boolean hipotecada;
    private final int alquilerBase;
    private final float factorRevalorizacion;
    private final int hipotecaBase;
    private final int precioEdificar;
    private Jugador propietario;
    private Calle calle;
    
    public TituloPropiedad(String nombre, int alquilerBase, float factorRevalorizacion, int hipotecaBase, int precioEdificar) {
        this.nombre = nombre;
        this.alquilerBase = alquilerBase;
        this.factorRevalorizacion = factorRevalorizacion;
        this.hipotecaBase = hipotecaBase;
        this.precioEdificar = precioEdificar;
        hipotecada = false;
        propietario = null;
        calle = null;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isHipotecada() {
        return hipotecada;
    }
    
    public void setHipotecada(boolean hipotecada) {
        this.hipotecada = hipotecada;
    }

    public int getAlquilerBase() {
        return alquilerBase;
    }

    public float getFactorRevalorizacion() {
        return factorRevalorizacion;
    }

    public int getHipotecaBase() {
        return hipotecaBase;
    }

    public int getPrecioEdificar() {
        return precioEdificar;
    }
    
    public Jugador getPropietario() {
        return this.propietario;
    }
    
    public void setPropietario(Jugador jugador) {
        this.propietario = jugador;
    }
    
    /**
     * Comprobar si el Titulo tiene dueño
     * @return true si propietario no es nulo.
     */
    public boolean tengoPropietario() {
        return getPropietario() != null;
    }
    
    /**
     * Comprobar si tiene propietario encarcelado
     * @return true si tiene propietario y este está encarcelado
     */
    public boolean propietaroEncarcelado() {
        return tengoPropietario() ? getPropietario().getEncarcelado() : false;
    }
    
    public Calle getCalle() {
        return this.calle;
    }
    
    public void setCalle(Calle casilla) {
        this.calle = casilla;
    }

    @Override
    public String toString() {
        return nombre + ". Alquiler base: " + alquilerBase + "$. Factor de Revalorizacion " + factorRevalorizacion + ". Hipoteca Base: " + hipotecaBase + "$. "
                + "Precio Edificar " + precioEdificar + "$";
    }    
    
}
