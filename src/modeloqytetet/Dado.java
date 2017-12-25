package modeloqytetet;

import java.util.Random;

public class Dado {
    
    private static final Dado instance = new Dado();
    private final Random rnd; 
    
    private Dado() { 
        rnd = new Random();
    }
    /*
    public static Dado getInstance() {
        return instance;
    }*/
    
    /**
     * @return Devuelve un número aleatorio entre 1 y 6.
     */
    int tirar() {
        return rnd.nextInt(6) + 1;
    }
}
