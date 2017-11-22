package modeloqytetet;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
    private Sorpresa cartaActual = null;
    private Tablero tablero;
    
    private Qytetet() {
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
    
    /**
     * 
     * @return true si tiene propietario
     */
    public boolean aplicarSorpresa() {
        boolean tienePropietario = false;
        
        switch (cartaActual.getTipo()) {
            case PAGARCOBRAR:
                jugadorActual.modificarSaldo(cartaActual.getValor());
                break;
            case IRACASILLA:
                if (tablero.esCasillaCarcel(cartaActual.getValor())) {
                    encarcelarJugador();
                } else {
                    Casilla nuevaCasilla = tablero.obtenerCasillaNumero(cartaActual.getValor());
                    tienePropietario = jugadorActual.actualizarPosicion(nuevaCasilla);
                }
                break;
            case PORCASAHOTEL:
                jugadorActual.pagarCobrarPorCasaYHotel(cartaActual.getValor());
                break;
            case PORJUGADOR:
                for (Jugador j : jugadores) {
                    if (j != jugadorActual) {
                        j.modificarSaldo(cartaActual.getValor());
                    }
                    jugadorActual.modificarSaldo(-1 * cartaActual.getValor());
                    
                }
                break;
        }
        if (cartaActual.getTipo() == TipoSorpresa.SALIRCARCEL) {
            jugadorActual.setCartaLibertad(cartaActual);
        } else {
            mazo.add(mazo.size(), cartaActual);
        }
        return tienePropietario;
    }
    
    /**
     * Cancelar una hipoteca
     * @param casilla La casilla hipotecada
     * @return true si se ha cancelado la hipoteca
     */
    public boolean cancelarHipoteca(Casilla casilla) {
        boolean cancelada = jugadorActual.puedoPagarHipoteca(casilla);
        if (cancelada) {
            int aPagar = casilla.cancelarHipoteca();
            jugadorActual.modificarSaldo(-1 * aPagar);
        }
        return cancelada;
    }
    
    /**
     * Intentar comprar un título de propiedad
     * @return True si se ha comprado el título
     */
    public boolean comprarTituloPropiedad() {
        return jugadorActual.comprarTitulo();
    }
    
    /**
     * Intentar edificar una casa en la casilla
     * @param casilla Casilla a edificar
     * @return true si se ha edificado
     */
    public boolean edificarCasa(Casilla casilla) {
        boolean puedoEdificar = false;
        if (casilla.soyEdificable()) {
            if (casilla.sePuedeEdificarCasa()) {
                puedoEdificar = jugadorActual.puedoEdificarCasa(casilla);
                if (puedoEdificar) {
                    int costeEdificarCasa = casilla.edificarCasa();                
                    jugadorActual.modificarSaldo(-1 * costeEdificarCasa);
                }
            }
        }
        
        return puedoEdificar;
    }
    
    public boolean edificarHotel(Casilla casilla) {
        boolean puedoEdificar = false;
        if (casilla.soyEdificable()) {
            if (casilla.sePuedeEdificarHotel()) {
                puedoEdificar = jugadorActual.puedoEdificarHotel(casilla);
                if (puedoEdificar) {
                    int costeEdificarHotel = casilla.edificarHotel();
                    jugadorActual.modificarSaldo(-1 * costeEdificarHotel);
                }
            }
        }
        
        return puedoEdificar;
    }
    
    public Sorpresa getSorpresaActual() {
        return cartaActual;
    }
    
    public Jugador getJugadorActual() {
        return jugadorActual;
    }
    
    /**
     * Intentar hipotecar una casilla
     * @param casilla La casilla
     * @return true si se ha hipotecado
     */
    public boolean hipotecarPropiedad(Casilla casilla) {
        boolean puedoHipotecar = false;
        
        if (casilla.soyEdificable()) {
            boolean sePuedeHipotecar = !casilla.estaHipotecada();
            if (sePuedeHipotecar) {
                puedoHipotecar = jugadorActual.puedoHipotecar(casilla);
                if (puedoHipotecar) {
                    int cantidadRecibida = casilla.hipotecar();
                    jugadorActual.modificarSaldo(cantidadRecibida);
                }
            }
        }
        return puedoHipotecar;
    }
    
    public void inicializarJuego(List<String> nombres) {
        inicializarJugadores(nombres);
        inicializarCartasSorpresa();
        inicializarTablero();
        salidaJugadores();
    }
    
    /**
     * Intentar salir de la cárcel
     * @param metodo cómo va a intentar salir
     * @return verdadero si sale y es libre
     */
    public boolean intentarSalirCarcel(MetodoSalirCarcel metodo) {
        boolean libre = false;
        
        if (metodo == MetodoSalirCarcel.TIRANDODADO) {
            int dado = Dado.getInstance().tirar();
            libre = dado > 5;
        } else if (metodo == MetodoSalirCarcel.PAGANDOLIBERTAD) {
            libre = jugadorActual.pagarLibertad(PRECIO_LIBERTAD);
        }
        
        if (libre) {
            jugadorActual.setEncarcelado(false);
        }
        return libre;
    }
    
    /**
     * El jugador tira el dado y juega
     * @return true si la casilla en la que cae tiene propietario
     */
    public boolean jugar() {
        boolean tienePropietario = false;
        
        int valorDado = Dado.getInstance().tirar();
        Casilla casillaPosicion = jugadorActual.getCasillaActual();
        Casilla nuevaCasilla = tablero.obtenerNuevaCasilla(casillaPosicion, valorDado);
        tienePropietario = jugadorActual.actualizarPosicion(nuevaCasilla);
        
        if (!nuevaCasilla.soyEdificable()) {
            if (nuevaCasilla.getTipo() == TipoCasilla.JUEZ) {
                encarcelarJugador();
            } else if (nuevaCasilla.getTipo() == TipoCasilla.SORPRESA) {
                cartaActual = mazo.remove(0);
            }
        }
        return tienePropietario;
    }
    
    public Map<String, Integer> obtenerRanking() {
        return jugadores.stream().collect(Collectors.toMap(Jugador::getName, Jugador::obtenerCapital));
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
    
    /**
     * Intentar vender una propiedad
     * @param casilla La casilla a vender
     * @return true si la has vendido
     */
    public boolean venderPropiedad(Casilla casilla) {
        boolean puedoVender = jugadorActual.puedoVenderPropiedad(casilla);
        if (puedoVender) {
            jugadorActual.venderPropiedad(casilla);
        }
        return puedoVender;
    }
    
    /**
     * Encarcelar a un jugador siempre ycuando no tenga una carta de libertad
     */
    private void encarcelarJugador() {
        if (!jugadorActual.tengoCartaLibertad()) {
            jugadorActual.irACarcel(tablero.getCarcel());
        } else {
            
            Sorpresa carta = jugadorActual.devolverCartaLibertad();
            mazo.add(mazo.size(), carta);
        }
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
