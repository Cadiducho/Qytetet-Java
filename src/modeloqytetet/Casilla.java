package modeloqytetet;

public class Casilla {

    private final int numeroCasilla;
    private int coste = 0;
    private int numHoteles = 0;
    private int numCasas = 0;
    private final TipoCasilla tipo;
    private TituloPropiedad titulo;

    public Casilla(TipoCasilla tipo, int numCasilla) {
        this.tipo = tipo;
        this.numeroCasilla = numCasilla;
    }

    public Casilla(int coste, int numCasilla, TituloPropiedad propiedad) {
        this.numeroCasilla = numCasilla;
        this.coste = coste;
        setTitulo(propiedad);
        tipo = TipoCasilla.CALLE;
    }

    public int getNumeroCasilla() {
        return numeroCasilla;
    }

    public int getCoste() {
        return coste;
    }

    public int getNumHoteles() {
        return numHoteles;
    }

    public void setNumHoteles(int num) {
        this.numHoteles = num;
    }

    public int getNumCasas() {
        return numCasas;
    }

    public void setNumCasas(int num) {
        this.numCasas = num;
    }

    public TipoCasilla getTipo() {
        return tipo;
    }

    public TituloPropiedad getTitulo() {
        return titulo;
    }

    private void setTitulo(TituloPropiedad titulo) {
        this.titulo = titulo;
        this.titulo.setCasilla(this);
    }

    TituloPropiedad asignarPropietario(Jugador jugador) {
        throw new UnsupportedOperationException("Sin implementar");
    }

    int calcularValorHipoteca() {
        throw new UnsupportedOperationException("Sin implementar");
    }

    int cancelarHipoteca() {
        throw new UnsupportedOperationException("Sin implementar");
    }

    int cobrarAlquiler() {
        throw new UnsupportedOperationException("Sin implementar");
    }

    int edificarCasa() {
        throw new UnsupportedOperationException("Sin implementar");
    }

    int edificarHotel() {
        throw new UnsupportedOperationException("Sin implementar");
    }

    /**
     * Comprobar si una casilla está hipotecada
     * @return verdadero si el título de propiedad indica que está hipotecado
     */
    boolean estaHipotecada() {
        return titulo.isHipotecada();
    }

    /**
     * El coste de la hipoteca en función de sus casas y hoteles. -1 si no tiene título de propiedad
     * @return  Coste de la hipoteca
     */
    int getCosteHipoteca() {
        if (getTitulo() == null) return -1;
        
        Double cantidadRecibida = getTitulo().getHipotecaBase() + numCasas * 0.5 * getTitulo().getHipotecaBase() + numHoteles * getTitulo().getHipotecaBase();
        return cantidadRecibida.intValue();
    }

    int getPrecioEdificar() {
        throw new UnsupportedOperationException("Sin implementar");
    }

    int hipotecar() {
        throw new UnsupportedOperationException("Sin implementar");
    }

    int precioTotalComprar() {
        throw new UnsupportedOperationException("Sin implementar");
    }

    /**
     * Verdadero si tiene propietario y este está en carcelado
     * @return 
     */
    boolean propietarioEncarcelado() {
        if (!tengoPropietario()) return false;
        
        return getTitulo().getPropietario().getEncarcelado();
    }

    boolean sePuedeEdificarCasa() {
        throw new UnsupportedOperationException("Sin implementar");
    }

    boolean sePuedeEdificarHotel() {
        throw new UnsupportedOperationException("Sin implementar");
    }

    /**
     * Comprobar si se puede edificar en la casilla
     * @return cierto sólo si es una casilla de tipo CALLE.
     */
    boolean soyEdificable() {
        return this.tipo == TipoCasilla.CALLE;
    }

    /**
     * Verdadero si tiene un titulo de propiedad y este tiene propietario
     * @return True or false
     */
    boolean tengoPropietario() {
        if (getTitulo() == null) return false;
        
        return getTitulo().tengoPropietario();
    }

    int venderTitulo() {
        throw new UnsupportedOperationException("Sin implementar");
    }

    @Override
    public String toString() {
        return "Casilla{" + "numeroCasilla=" + numeroCasilla + ", coste=" + coste + ", numHoteles=" + numHoteles
                + ", numCasas=" + numCasas + ", tipo=" + tipo + (titulo != null ? (", titulo=" + titulo) : "") + '}';
    }


}
