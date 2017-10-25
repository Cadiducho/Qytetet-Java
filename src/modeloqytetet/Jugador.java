package modeloqytetet;

import java.util.List;

public class Jugador {

    private boolean encarcelado;
    private final String nombre;
    private int saldo;
    private Casilla casillaActual;
    private Sorpresa cartaLibertad;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.encarcelado = false;
        this.saldo = 7500;
    }

    public Casilla getCasillaActual() {
        return this.casillaActual;
    }

    public boolean getEncarcelado() {
        return encarcelado;
    }

    public boolean tengoPropiedades() {
        throw new UnsupportedOperationException("Sin implementar");
    }

    boolean actualizarPosicion(Casilla casilla) {
        this.casillaActual = casilla;
        throw new UnsupportedOperationException("Sin implementar");
    }

    boolean comprarTitulo() {
        throw new UnsupportedOperationException("Sin implementar");
    }

    Sorpresa devolverCartaLibertad() {
        throw new UnsupportedOperationException("Sin implementar");
    }

    void irACarcel(Casilla casilla) {
        throw new UnsupportedOperationException("Sin implementar");
    }

    void modificarSaldo(int cantidad) {
        this.saldo += cantidad;
    }

    int obtenerCapital() {
        return this.saldo;
    }

    List<TituloPropiedad> obtenerPropiedadesHipotecadas(boolean hipotecada) {
        throw new UnsupportedOperationException("Sin implementar");
    }

    void pagarCobrarPorCasaYHotel(int cantidad) {
        throw new UnsupportedOperationException("Sin implementar");
    }

    boolean pagarLibertad(int cantidad /*: int = PrecioLibertad*/) {
        throw new UnsupportedOperationException("Sin implementar");
    }

    boolean puedoEdificarCasa(Casilla casilla) {
        throw new UnsupportedOperationException("Sin implementar");
    }

    boolean puedoEdificarHotel(Casilla casilla) {
        throw new UnsupportedOperationException("Sin implementar");
    }

    boolean puedoHipotecar(Casilla casilla) {
        throw new UnsupportedOperationException("Sin implementar");
    }

    boolean puedoPagarHipoteca(Casilla casilla) {
        throw new UnsupportedOperationException("Sin implementar");
    }

    boolean puedoVenderPropiedad(Casilla casilla) {
        throw new UnsupportedOperationException("Sin implementar");
    }

    void setCartaLibertad(Sorpresa carta) {
        this.cartaLibertad = carta;
    }

    void setCasillaActual(Casilla casilla) {
        this.casillaActual = casilla;
    }

    void setEncarcelado(boolean encarcelado) {
        this.encarcelado = encarcelado;
    }

    boolean tengoCartaLibertad() {
        throw new UnsupportedOperationException("Sin implementar");
    }

    void venderPropiedad(Casilla casilla) {
        throw new UnsupportedOperationException("Sin implementar");
    }

    private int cuantasCasasHotelesTengo() {
        throw new UnsupportedOperationException("Sin implementar");
    }

    private void eliminarDeMisPropiedades(Casilla casilla) {
        throw new UnsupportedOperationException("Sin implementar");
    }

    private boolean esDeMipropiedad(Casilla casilla) {
        throw new UnsupportedOperationException("Sin implementar");
    }

    private boolean tengoSaldo(int cantidad) {
        return (cantidad <= this.saldo);
    }
    
    @Override
    public String toString() {
        return "Jugador{" + "nombre=" + nombre + ", encarcelado=" + encarcelado + ", saldo=" + saldo
                + ", casillaActual=" + casillaActual + ", cartaLibertad=" + cartaLibertad + "}";
    }

}
