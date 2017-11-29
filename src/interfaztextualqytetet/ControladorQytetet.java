package interfaztextualqytetet;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import modeloqytetet.Casilla;
import modeloqytetet.Jugador;
import modeloqytetet.MetodoSalirCarcel;
import modeloqytetet.Qytetet;
import modeloqytetet.TipoCasilla;
import modeloqytetet.TituloPropiedad;

public class ControladorQytetet {

    private Qytetet juego;
    private VistaTextualQytetet vista;
    
    private Jugador jugador;
    private Casilla casilla;
    
    public static void main(String[] args) {
        ControladorQytetet c = new ControladorQytetet();
    }
    
    private ControladorQytetet() {
        inicializacionJuego();
        desarrolloJuego();
    }
    
    private void inicializacionJuego() {
        juego = Qytetet.getInstance();
        vista = new VistaTextualQytetet();
        
        List<String> nombres = vista.obtenerNombreJugadores();
        juego.inicializarJuego(nombres);
        
        jugador = juego.getJugadorActual();
        casilla = jugador.getCasillaActual();
        
        verEstadoJuego();
        vista.pressToContinue();
    }
    
    private void desarrolloJuego() {
        boolean fin = false;

        while (!fin) {
            vista.mostrar("Es el turno de " + jugador.getName() + ", tirando desde la casilla " + casilla.getNumeroCasilla());

            boolean sigueJugando = true;
            
            //si está en la carcel, trato especial
            if (jugador.getEncarcelado()) {
                vista.mostrar("Estás en la cárcel");
                MetodoSalirCarcel metodo = null;
                switch (vista.menuSalirCarcel()) {
                    case 0:
                        metodo = MetodoSalirCarcel.TIRANDODADO;
                        break;
                    case 1:
                        metodo = MetodoSalirCarcel.PAGANDOLIBERTAD;
                        break;
                }

                boolean sale = juego.intentarSalirCarcel(metodo);
                if (sale) {
                    vista.mostrar(" -> Has salido de la cárcel. Ahora puedes seguir jugando");
                } else {
                    vista.mostrar(" -> No has podido salir de la cárcel. Se pasa el turno");
                    sigueJugando = false;
                }
                vista.pressToContinue();
            }
            
            //gestionar movimiento
            if (sigueJugando) {
                boolean tienePropietario = juego.jugar();
                
                vista.mostrar(" -> Te has movido hasta " + jugador.getCasillaActual());
                switch (jugador.getCasillaActual().getTipo()) {
                    case SORPRESA:
                        vista.mostrar(" -> Has caído en una casilla sorpresa");
                        vista.mostrar(juego.getSorpresaActual());
                        boolean nuevaCasillaPropietario = juego.aplicarSorpresa();
                        if (nuevaCasillaPropietario) {
                            vista.mostrar(" -> Has caído en una propiedad con propietario y has pagado su alquiler");
                        }
                        break;
                    case CALLE:
                        if (tienePropietario) {
                            vista.mostrar(" -> Has caído en una casilla con propietario");
                        } else {
                            vista.mostrar(" -> Esta casila no tiene propietario");
                            boolean comprar = vista.elegirQuieroComprar();
                            if (comprar) {
                                boolean puedoComprar = juego.comprarTituloPropiedad();
                                if (puedoComprar) {
                                    vista.mostrar(" -> Has comprado la casilla " + jugador.getCasillaActual().getNumeroCasilla());
                                } else {
                                    vista.mostrar(" -> No puedes comprar la casilla " + jugador.getCasillaActual().getNumeroCasilla());
                                }
                            }
                        }
                        break;
             
                }
            }
            
            if (jugador.tengoPropiedades() && !jugador.getEncarcelado() && jugador.getSaldo() > 0) {
                int gestion = vista.menuGestionInmobiliaria();
                if (gestion != 0) {
                    int numPropiedad = vista.menuElegirPropiedad(jugador.getPropiedades().stream().map(TituloPropiedad::getNombre).collect(Collectors.toList()));
                    Casilla editCasilla = juego.getJugadorActual().getPropiedades().get(numPropiedad).getCasilla();
                    switch (gestion) {
                        case 1: 
                            boolean edificada = juego.edificarCasa(editCasilla);
                            vista.mostrar(" -> " + (edificada ? "Has edificado" : "No has podido edificar") + " una casa");
                            break;
                        case 2: 
                            boolean edificado = juego.edificarHotel(editCasilla); 
                            vista.mostrar(" -> " + (edificado ? "Has edificado" : "No has podido edificar") + " un hotel");
                            break;
                        case 3: 
                            boolean vendido = juego.venderPropiedad(editCasilla);
                            vista.mostrar(" -> " + (vendido ? "Has vendido" : "No has podido vender") + " la casilla");
                            break;
                        case 4: 
                            boolean hipotecada = juego.hipotecarPropiedad(editCasilla);
                            vista.mostrar(" -> " + (hipotecada ? "Has hipotecado" : "No has podido hipotecar") + " la casilla");
                            break;
                        case 5: 
                            boolean cancelada = juego.cancelarHipoteca(editCasilla);
                            vista.mostrar(" -> " + (cancelada ? "Has cancelado" : "No has podido cancelar") + " la hipoteca de la casilla");
                            break;
                    }
                }
            }
            
            if (jugador.getSaldo() <= 0) {
                // bancarrota
                vista.mostrar("Ha terminado el juego porque " + jugador.getName() + " ha caído en bancarrota");
                fin = true;
            } else {
                // gestionar final de turno
                jugador = juego.siguienteJugador();
                casilla = jugador.getCasillaActual();
                verEstadoJuego();
                
                vista.pressToContinue();
            }
        }
        
        // final del juego 
        juego.obtenerRanking().forEach((nombre, saldo) -> vista.mostrar(nombre + " - " + saldo)); 
    }
    
    private void verEstadoJuego() {
        vista.mostrar("Jugadores: ");
        
        juego.getJugadores().forEach(j -> {
            vista.mostrar(j.getName() + " está en la casilla " + j.getCasillaActual().getNumeroCasilla() + " y tiene " + j.getSaldo() + "$ ");
        });

        vista.mostrar("Es el turno de " + jugador.getName() + " tirando desde " + casilla);
    }
    
    public Casilla elegirPropiedad(List<Casilla> propiedades) {
        //este metodo toma una lista de propiedades y genera una lista de strings, con el numero y nombre de las propiedades
        //luego llama a la vista para que el usuario pueda elegir.
        vista.mostrar("\tCasilla\tTitulo");
        int seleccion;
        ArrayList<String> listaPropiedades = new ArrayList<>();
        
        propiedades.forEach(c -> listaPropiedades.add("\t" + c.getNumeroCasilla() + "\t" + c.getTitulo().getNombre()));
        
        seleccion = vista.menuElegirPropiedad(listaPropiedades);
        return propiedades.get(seleccion);
    }

}
