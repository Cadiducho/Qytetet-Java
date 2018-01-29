package modeloqytetet;

//EXAMEN

import java.util.Random;

public class Tramposo extends Jugador {
    
    private int numeroTrampas;
    private long fraude;

    public Tramposo(Jugador jugador) {
        super(jugador);
        this.numeroTrampas = 0;
        this.fraude = 0L;
    }
    
    /**
     * @return Veces que ha hecho trampa
     */
    public int getTrampas() {
        return this.numeroTrampas;
    }
    
    /**
     * @return Cantidad de dinero defraudado
     */
    public long getFraude() {
        return this.fraude;
    }
    
    @Override
    void modificarSaldo(int cantidad) {
        if (cantidad < 0) {
            if (new Random().nextInt(2) == 0) { //50%
                cantidad /= 2;

                fraude += (-1) * cantidad; //-1 para contar el fraude en positivo
                numeroTrampas++;
            }
        }
        super.modificarSaldo(cantidad);
    }
    
    /**
     * Perdonar al tramposo
     */
    public void perdonar() {
        this.numeroTrampas = 0;
        this.fraude = 0L;
    }
    
    @Override
    public String toString() {
        String resumen = super.toString();
        
        resumen += "\n Ha hecho trampas " + numeroTrampas + " veces.";
        resumen += "\n Ha defraudado un total de " + fraude + "$";
        
        return resumen;
    }
}
//FIN EXAMEN
