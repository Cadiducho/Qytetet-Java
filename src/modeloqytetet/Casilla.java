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

    public Casilla(int coste, int numCasilla) {
        this.numeroCasilla = numCasilla;
        this.coste = coste;
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

    public void setTitulo(TituloPropiedad titulo) {
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

    int estaHipotecada() {
        throw new UnsupportedOperationException("Sin implementar");
    }

    int getCosteHipoteca() {
        throw new UnsupportedOperationException("Sin implementar");
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

    boolean propietarioEncarcelado() {
        throw new UnsupportedOperationException("Sin implementar");
    }

    boolean sePuedeEdificarCasa() {
        throw new UnsupportedOperationException("Sin implementar");
    }

    boolean sePuedeEdificarHotel() {
        throw new UnsupportedOperationException("Sin implementar");
    }

    boolean soyEdificable() {
        throw new UnsupportedOperationException("Sin implementar");
    }

    boolean tengoPropietario() {
        throw new UnsupportedOperationException("Sin implementar");
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
