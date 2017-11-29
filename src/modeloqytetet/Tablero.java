package modeloqytetet;

import java.util.ArrayList;

public class Tablero {
    private ArrayList<Casilla> casillas;
    private Casilla carcel;
    
    public Tablero() {
        inicializar();
    }
    
    private void inicializar() {
        casillas = new ArrayList<>();
        
        Casilla salida = new Casilla(TipoCasilla.SALIDA, 0);
        Casilla sorpresa1 = new Casilla(TipoCasilla.SORPRESA, 3);
        Casilla sorpresa2 = new Casilla(TipoCasilla.SORPRESA, 8);
        Casilla sorpresa3 = new Casilla(TipoCasilla.SORPRESA, 14);
        this.carcel = new Casilla(TipoCasilla.CARCEL, 15);
        Casilla juez = new Casilla(TipoCasilla.JUEZ, 5);
        Casilla parking = new Casilla(TipoCasilla.PARKING, 10);
        Casilla impuesto = new Casilla(TipoCasilla.IMPUESTO, 18);
        
        Casilla breakingBad = new Casilla(2000, 19, new TituloPropiedad("Breaking Bad", 100, 20, 1000, 750)); 
        Casilla narcos = new Casilla(1900, 17, new TituloPropiedad("Narcos", 100, 19, 950, 750));   
        Casilla strangerThings = new Casilla(1600, 16, new TituloPropiedad("Stranger Things", 95, 18, 875, 650));  
        Casilla thirteenrw = new Casilla(1500, 13, new TituloPropiedad("Thirteen Reasons Why", 90, 17, 800, 600));
        Casilla theCrown = new Casilla(1350, 12, new TituloPropiedad("The Crown", 85, 16, 650, 500));
        Casilla oitnb = new Casilla(1300, 11, new TituloPropiedad("Orange is the new Black", 80, 15, 500, 425)); 
        Casilla houseOfCards = new Casilla(1100, 9, new TituloPropiedad("House of Cards", 75, 14, 450, 350));
        Casilla jessica = new Casilla(1000, 7, new TituloPropiedad("Jessica Jones", 70, 13, 350, 350));
        Casilla gilmoregirls = new Casilla(950, 6, new TituloPropiedad("Girlmore Girls", 65, 12, 300, 300));
        Casilla senseeight = new Casilla(900, 4, new TituloPropiedad("Sense8", 60, 11, 250, 300)); 
        Casilla daredevil = new Casilla(800, 2, new TituloPropiedad("Daredevil", 55, 10, 200, 250));
        Casilla shadowhunters = new Casilla(700, 1, new TituloPropiedad("ShadowHunters", 50, 10, 150, 250));
        
        //agregar casillas especiales
        addCasilla(salida);
        addCasilla(sorpresa1);
        addCasilla(sorpresa2);
        addCasilla(sorpresa3);
        addCasilla(juez);
        addCasilla(carcel);
        addCasilla(parking);
        addCasilla(impuesto);
        
        //agregar series
        addCasilla(breakingBad);
        addCasilla(narcos);
        addCasilla(strangerThings);
        addCasilla(thirteenrw);
        addCasilla(theCrown);
        addCasilla(oitnb);
        addCasilla(houseOfCards);
        addCasilla(jessica);
        addCasilla(senseeight);
        addCasilla(gilmoregirls);
        addCasilla(daredevil);
        addCasilla(shadowhunters);
        
    }
    
    private void addCasilla(Casilla insertar) {
        for (Casilla agregada : casillas) {
            if (insertar.getNumeroCasilla() == agregada.getNumeroCasilla()) {
                System.out.println("La casilla nº: " + insertar.getNumeroCasilla() + " ya está ocupada!");
                return;
            }
        }
        casillas.add(insertar);
    }
    
    public Casilla getCarcel() {
        return this.carcel;
    }
    
    public ArrayList<Casilla> getCasillas() {
        return this.casillas;
    }
    
    boolean esCasillaCarcel(int numeroCasilla) {
        return numeroCasilla == getCarcel().getNumeroCasilla();
    }
    
    public Casilla obtenerCasillaNumero(int numero) {
        for (Casilla casilla : casillas) {
            if (casilla.getNumeroCasilla() == numero) {
                return casilla;
            }
        }
        return null;
    }
    
    Casilla obtenerNuevaCasilla(Casilla origen, int desplazamiento) {
        return obtenerCasillaNumero((origen.getNumeroCasilla() + desplazamiento) % Qytetet.getInstance().MAX_CASILLAS);
    }

    @Override
    public String toString() {
        return "Tablero{" + "casillas=" + casillas + ", carcel=" + carcel + '}';
    }
    
}
