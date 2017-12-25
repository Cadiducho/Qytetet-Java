package modeloqytetet;

public class Calle extends Casilla {
    
    private int numHoteles = 0;
    private int numCasas = 0;
    private TituloPropiedad titulo;
    
    public Calle(int coste, int numCasilla, TituloPropiedad propiedad) {
        super(TipoCasilla.CALLE, numCasilla);
        
        setTitulo(propiedad);
        this.coste = coste;
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
    
    public TituloPropiedad getTitulo() {
        return titulo;
    }

    private void setTitulo(TituloPropiedad titulo) {
        this.titulo = titulo;
        this.titulo.setCalle(this);
    }

    /**
     * Asignar a un jugador como dueño de la casilla
     * @param jugador El jugador dueño
     * @return El Titulo de Propiedad comprado
     */
    TituloPropiedad asignarPropietario(Jugador jugador) {
        titulo.setPropietario(jugador);
        
        return titulo;
    }

    /**
     * El coste de la hipoteca en función de sus casas y hoteles. -1 si no tiene título de propiedad
     * @return  Coste de la hipoteca
     */
    int calcularValorHipoteca() {
        return (int) (getTitulo().getHipotecaBase() + numCasas * 0.5 * getTitulo().getHipotecaBase() + numHoteles * getTitulo().getHipotecaBase());
    }

    int cancelarHipoteca() {
        titulo.setHipotecada(false);
        return (int) (calcularValorHipoteca() * 1.10);
    }

    /**
     * Obtener el coste del alquiler en función de sus casas y hoteles construidos
     * @return Coste del alquiler de la casilla
     */
    int cobrarAlquiler() {
        return (int) (getTitulo().getAlquilerBase() + (numCasas * 0.5 + numHoteles * 2));
    }

    /**
     * Edificar una casa en la casilla
     * @return coste de construcción
     */
    int edificarCasa() {
        numCasas++;
        return getPrecioEdificar();
    }

    int edificarHotel() {
        numHoteles++;
        numCasas -= 4;
        return getPrecioEdificar();
    }

    /**
     * Comprobar si una casilla está hipotecada
     * @return verdadero si el título de propiedad indica que está hipotecado
     */
    boolean estaHipotecada() {
        return titulo.isHipotecada();
    }

    /**
     * Coste por edificar
     * @return coste
     */
    int getPrecioEdificar() {
        return titulo.getPrecioEdificar();
    }

    /**
     * Hipotecar una casilla
     * @return cantidad de dinero recibida por hipotecarla
     */
    int hipotecar() {
        getTitulo().setHipotecada(true);
        return calcularValorHipoteca();
    }
    
        /**
     * Comprobar si tiene propietario encarcelado
     * @return true si tiene propietario y este está encarcelado
     */
    boolean propietarioEncarcelado() {
        return titulo != null ? (tengoPropietario() ? getTitulo().propietaroEncarcelado() : false) : false;
    }

    /**
     * Comprobar si se pueden edificar más casas
     * @return true si numCasas es menor que cuatro * factor especulador
     */
    public boolean sePuedeEdificarCasa() {
        return (numCasas < (4 * getTitulo().getPropietario().getFactorEspeculador()));
    }

    /**
     * Comprobar si se pueden edificar más hoteles
     * @return true si numCasas es igual o mayor que cuatro numHoteles es menor que cuatro * factor especulador
     */
    public boolean sePuedeEdificarHotel() {
        return numHoteles < (4 * getTitulo().getPropietario().getFactorEspeculador()) && numCasas >= 4;
    }
    
    /**
     * Comprobar si la casilla tiene propietario 
     * @return True si tiene un titulo de propiedad y este tiene propietario
     */
    boolean tengoPropietario() {
        return (getTitulo() != null) ? getTitulo().tengoPropietario() : false;
    }

    /**
     * Obtener el precio por el que se va a vender la casilla
     * @return Precio de venta
     */
    int venderTitulo() {
        return (int) (coste + titulo.getFactorRevalorizacion() * (coste + (numCasas + numHoteles) * titulo.getPrecioEdificar()));
    }
    
    /**
     * Comprobar si se puede edificar en la casilla
     * @return cierto sólo si es una casilla de tipo CALLE.
     */
    @Override
    boolean soyEdificable() {
        return true;
    }
    
    @Override
    public String toString() {
        String resumen = "Calle #" + numeroCasilla + ". ";
        if (tengoPropietario()) {
            resumen += "\n * Propietario: " + titulo.getPropietario().getName() + ". Tiene " + numCasas + " casas y " + numHoteles + " hoteles. "
                    + "Alquiler: " + cobrarAlquiler() + "$. Hipoteca: " + calcularValorHipoteca() + "$. Hipotecada: " + estaHipotecada();
            if (propietarioEncarcelado()) {
                resumen += "\n * Su propietario está encarcelado. ";
            }
        } else {
            resumen += "\n * En venta por " + coste + "$: " + titulo;
        }
        return resumen;
    }

}
