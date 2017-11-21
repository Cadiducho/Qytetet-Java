package modeloqytetet;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Qytetet {
    
    public int MAX_JUGADORES = 4;
    int MAX_CARTAS = 10;
    int MAX_CASILLAS = 20;
    int PRECIO_LIBERTAD = 200;
    int SALDO_SALIDA = 1000;
    
    private static final Qytetet instance = new Qytetet();
    private final ArrayList<Sorpresa> mazo = new ArrayList<>();
    private final ArrayList<Jugador> jugadores = new ArrayList<>();
    private Jugador jugadorActual = null;
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
        return jugadorActual;
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
        return jugadorActual.obtenerPropiedadesHipotecadas(hipotecadas).stream().map(TituloPropiedad::getCasilla).collect(Collectors.toList());
    }
    
    public List<Jugador> getJugadores() {
        return this.jugadores;
    }
    
    public Jugador siguienteJugador() {
        int nextPlayer = 0;
        if (jugadorActual != null) {
            int index = jugadores.indexOf(jugadorActual);
            if (index > (jugadores.size() - 1)) {
                nextPlayer = index;
            }
        }
        jugadorActual = jugadores.get(nextPlayer);
        return jugadorActual;
    }
    
    public boolean venderPropiedad(Casilla casilla) {
        throw new UnsupportedOperationException("Sin implementar"); 
    }
    
    private void encarcelarJugador() {

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
    
    private void inicializarJugadores(List<String> nombres) {
        nombres.forEach(n -> jugadores.add(new Jugador(n)));
    }
    
    private void inicializarTablero() {
        tablero = new Tablero();
    }
    
    private void salidaJugadores() {
        jugadores.forEach(j -> {
            j.setCasillaActual(tablero.obtenerCasillaNumero(0));
            j.setSaldo(7500);
        });
    }
}
