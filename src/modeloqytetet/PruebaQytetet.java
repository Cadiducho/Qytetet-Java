package modeloqytetet;

public class PruebaQytetet {

    public static void main(String[] args) {
        Qytetet qytetet = Qytetet.getInstance();
        
        System.out.println("Todas las sorpresas");
        qytetet.getMazo().forEach(s -> System.out.println(s));
        
        System.out.println("Todas las casillas");
        qytetet.getTablero().getCasillas().forEach(c -> System.out.println(c));

    }    
}
