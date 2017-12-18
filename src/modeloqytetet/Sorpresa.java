package modeloqytetet;

public class Sorpresa {

    private final String texto;
    private final TipoSorpresa tipo;
    private final int valor;

    public Sorpresa(String texto, int valor, TipoSorpresa tipo) {
        this.texto = texto;
        this.valor = valor;
        this.tipo = tipo;
    }
    
    public String getTexto() {
        return this.texto;
    }
    
    public TipoSorpresa getTipo() {
        return this.tipo;
    }
    
    public int getValor() {
        return this.valor;
    }

    @Override
    public String toString() {
        String resumen = texto;
        String pagasCobras = valor < 0 ? "Pagas" : "Cobras";
        switch (tipo) {
            case PAGARCOBRAR: resumen += "\n * " + pagasCobras + Math.abs(valor); break;
            case IRACASILLA: resumen += "\n * Vas a la " + (Qytetet.getInstance().getTablero().esCasillaCarcel(valor) ? "cárcel" : "casilla " + valor); break;
            case PORCASAHOTEL: resumen += "\n * " + pagasCobras + " por cada casa y hotel " + Math.abs(valor); break;
            case PORJUGADOR: resumen += "\n * " + pagasCobras + " a cada jugador " + Math.abs(valor); break;
            case SALIRCARCEL: resumen += "\n * Podrás salir de la cárcel"; break;
            case CONVERTIRME: resumen += "\n * Ahora eres un Especulador. Tu fianza ha sido fijada en " + valor; break;
        } 
        
        return resumen;
    }
}
