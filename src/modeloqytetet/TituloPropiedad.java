package modeloqytetet;

public class TituloPropiedad {
    
    private final String nombre;
    private boolean hipotecada;
    private final int alquilerBase;
    private final float factorRevalorizacion;
    private final int hipotecaBase;
    private final int precioEdificar;
    private Jugador propietario;
    private Casilla casilla;
    
    public TituloPropiedad(String nombre, int alquilerBase, float factorRevalorizacion, int hipotecaBase, int precioEdificar) {
        this.nombre = nombre;
        this.alquilerBase = alquilerBase;
        this.factorRevalorizacion = factorRevalorizacion;
        this.hipotecaBase = hipotecaBase;
        this.precioEdificar = precioEdificar;
        hipotecada = false;
        propietario = null;
        casilla = null;
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
    
    public boolean tengoPropietario() {
        return getPropietario() != null;
    }
    
    public boolean propietaroEncarcelado() {
        return tengoPropietario() ? getPropietario().getEncarcelado() : false;
    }
    
    public Casilla getCasilla() {
        return this.casilla;
    }
    
    public void setCasilla(Casilla casilla) {
        this.casilla = casilla;
    }

    @Override
    public String toString() {
        return "TituloPropiedad{" + "nombre=" + nombre + ", hipotecada=" + hipotecada + ", alquilerBase=" + alquilerBase + ", factorRevalorizacion=" + factorRevalorizacion + ", hipotecaBase=" + hipotecaBase + ", precioEdificar=" + precioEdificar + '}';
    }    
    
}
