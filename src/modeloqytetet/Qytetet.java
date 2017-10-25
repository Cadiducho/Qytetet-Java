package modeloqytetet;

import java.util.ArrayList;
import java.util.List;

public class Qytetet {
    
    public int MAX_JUGADORES = 4;
    int MAX_CARTAS = 10;
    int MAX_CASILLAS = 20;
    int PRECIO_LIBERTAD = 200;
    int SALDO_SALIDA = 1000;
    
    private static final Qytetet instance = new Qytetet();
    private final ArrayList<Sorpresa> mazo = new ArrayList();
    private Tablero tablero;
    
    private Qytetet() {
        inicializarTablero();
        inicializarCartasSorpresa();      
    }
    
    public static Qytetet getInstance() {
        return instance;
    }
    
    public ArrayList<Sorpresa> getMazo() {
        return this.mazo;
    }
    
    public Tablero getTablero() {
        return this.tablero;
    }
    
    public boolean aplicarSorpresa() {
        throw new UnsupportedOperationException("Sin implementar"); 
    }
    
    public boolean cancelarHipoteca(Casilla casilla) {
        throw new UnsupportedOperationException("Sin implementar"); 
    }
    
    public boolean comprarTituloPropiedad() {
        throw new UnsupportedOperationException("Sin implementar"); 
    }
    
    public boolean edificarCasa(Casilla casilla) {
        throw new UnsupportedOperationException("Sin implementar"); 
    }
    
    public boolean edificarHotel(Casilla casilla) {
        throw new UnsupportedOperationException("Sin implementar"); 
    }
    
    public Sorpresa getSorpresaActual() {
        throw new UnsupportedOperationException("Sin implementar"); 
    }
    
    public Jugador getJugadorActual() {
        throw new UnsupportedOperationException("Sin implementar"); 
    }
    
    public boolean hipotecarPropiedad(Casilla casilla) {
        throw new UnsupportedOperationException("Sin implementar"); 
    }
    
    public void inicializarJuego(String... nombres) {
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public boolean intentarSalirCarcel(MetodoSalirCarcel metodo) {
        throw new UnsupportedOperationException("Sin implementar"); 
    }
    
    public boolean jugar() {
        throw new UnsupportedOperationException("Sin implementar"); 
    }
    
    public List<Jugador> obtenerRanking() {
        throw new UnsupportedOperationException("Sin implementar"); 
    }
    
    public List<Casilla> propiedadesHipotecadasJugador(boolean hipotecadas) {
        throw new UnsupportedOperationException("Sin implementar"); 
    }
    
    public Jugador siguienteJugador() {
        throw new UnsupportedOperationException("Sin implementar"); 
    }
    
    public boolean venderPropiedad(Casilla casilla) {
        throw new UnsupportedOperationException("Sin implementar"); 
    }
    
    private void encarcelarJugador() {
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    private void inicializarCartasSorpresa() {
        mazo.add(new Sorpresa("La DEA te ha pillado con cocaína y pasarás un tiempo en Litchfield", tablero.getCarcel().getNumeroCasilla(), TipoSorpresa.IRACASILLA));
        mazo.add(new Sorpresa("Encuentras un acceso al Upside Down y te lleva directo a Jackson", 16, TipoSorpresa.IRACASILLA));
        mazo.add(new Sorpresa("Te han invitado a una fiesta por la noche en casa de Jessica", 13, TipoSorpresa.IRACASILLA));
        mazo.add(new Sorpresa("Los otros jugadores han probado tu producto azul y te pagan unos cuantos gramos", 500, TipoSorpresa.PORJUGADOR));
        mazo.add(new Sorpresa("Jessica Jones ha expuesto tus secretos y pagas a los testigos para que nadie hable", -400, TipoSorpresa.PORJUGADOR));
        mazo.add(new Sorpresa("Cada celda de pabellón te pagan por tus servicios al protegerles", 300, TipoSorpresa.PORCASAHOTEL));
        mazo.add(new Sorpresa("Taylor ha decidido que tu hotel está contruido en un lugar histórico de Stars Hollow", -400, TipoSorpresa.PORCASAHOTEL));
        mazo.add(new Sorpresa("El Presidente te otorga un presupuesto solicitado", 600, TipoSorpresa.PAGARCOBRAR));
        mazo.add(new Sorpresa("Matt Murdock te ha defendido en un juicio y debes pagar sus honorarios", -700, TipoSorpresa.PAGARCOBRAR));
        mazo.add(new Sorpresa("Elisabeth II te ha dado un indulto y puedes abandonar la prisión", 0, TipoSorpresa.SALIRCARCEL));
    }
    
    private void inicializarJugadores(String... nombres) {
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    private void inicializarTablero() {
        tablero = new Tablero();
    }
    
    private void salidaJugadores() {
        throw new UnsupportedOperationException("Sin implementar");
    }
}
