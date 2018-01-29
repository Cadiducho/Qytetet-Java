package modeloqytetet;

public class OtraCasilla extends Casilla {
    
    public OtraCasilla(TipoCasilla tipo, int numCasilla) {
        super(tipo, numCasilla);
    }
    
    /**
     * Comprobar si se puede edificar en la casilla
     * @return cierto sólo si es una casilla de tipo CALLE.
     */
    @Override
    public boolean soyEdificable() { //Examen -> public
        return false;
    }
    
    
}
