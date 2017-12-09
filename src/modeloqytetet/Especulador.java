package modeloqytetet;

public class Especulador extends Jugador {

    private final int fianza;
    
    public Especulador(Jugador jugador, Integer fianza) {
        super(jugador);
        this.fianza = fianza;
        this.factorEspeculador = 2;
    }
    /**
     * Un especulador paga impuestos, la mitad que el jugador
     * @param cantidad Cantidad a pagar
     */
    @Override
    protected void pagarImpuestos(int cantidad) {
        modificarSaldo(-1 * cantidad / 2);
    }
    
    @Override
    protected void irACarcel(Casilla casilla) {
        if (!pagarFianza(fianza)) {
            super.irACarcel(casilla);
        }
    }
    
    /**
     * Convertir a un especulador en especulador... o sea, nada
     * @param fianza
     * @return La instancia del especuulador
     */
    @Override
    protected Especulador covertirme(int fianza) {
        return this;
    }
    
    /**
     * Intentar pagar una fianza
     * @param cantidad Cantidad a pagar
     * @return true si puede pagarlo
     */
    private boolean pagarFianza(int cantidad) {
        boolean tengoSaldo = tengoSaldo(cantidad);
        if (tengoSaldo) {
            modificarSaldo(-1 * cantidad);
        }
        return tengoSaldo;
    }
    
}
