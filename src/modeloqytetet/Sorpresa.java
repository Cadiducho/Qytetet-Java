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
        return "Sorpresa{" + "texto=" + texto + ", valor="
                + Integer.toString(valor) + ", tipo=" + tipo + "}";
    }
}
