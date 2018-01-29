package modeloqytetet;

//EXAMEN
public class ExamenP4 {
    
    public static void main(String[] args) {
        Jugador jugador1 = new Jugador("Jake");
        Jugador jugador2 = new Tramposo(jugador1);
        
        System.out.println(jugador1.toString());
        System.out.println(jugador2.toString());
        
        for (int i = 0; i < 8; i++) {
            jugador1.modificarSaldo(-1 * i * 30); //-1 * i * 30 por poner algo negativo
            jugador2.modificarSaldo(-1 * i * 30);
        }
        
        System.out.println(jugador1.toString());
        System.out.println(jugador2.toString());
        
        ((Tramposo) jugador2).perdonar();
        
        System.out.println(jugador2.toString());
    }
}
//FIN EXAMEN