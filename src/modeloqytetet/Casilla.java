package modeloqytetet;

public abstract class Casilla {

    protected final int numeroCasilla;
    protected int coste = 0;
    protected final TipoCasilla tipo;

    public Casilla(TipoCasilla tipo, int numCasilla) {
        this.tipo = tipo;
        this.numeroCasilla = numCasilla;
    }

    public int getNumeroCasilla() {
        return numeroCasilla;
    }

    public int getCoste() {
        return coste;
    }
    
    public void setCoste(int coste) {
        this.coste = coste;
    }
    
    public TipoCasilla getTipo() {
        return tipo;
    }
    
    /**
     * Comprobar si se puede edificar en la casilla
     * @return cierto sólo si es una casilla de tipo CALLE.
     */
    abstract boolean soyEdificable();

    @Override
    public String toString() {
        return "Casilla #" + numeroCasilla + " (" + tipo.name() + "). ";
    }

}
