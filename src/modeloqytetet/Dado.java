package modeloqytetet;

import java.util.Random;

public class Dado {
    
    private static final Dado instance = new Dado();
    private final Random rnd; 
    
    private Dado() { 
        rnd = new Random();
    }
    
    public static Dado getInstance() {
        return instance;
    }
    
    int tirar() {
        return rnd.nextInt(6) + 1;
    }
}
