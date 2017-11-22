package modeloqytetet;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Jugador {

    private boolean encarcelado;
    private final String nombre;
    private int saldo;
    private Casilla casillaActual;
    private Sorpresa cartaLibertad;
    private List<TituloPropiedad> propiedades;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.encarcelado = false;
        this.saldo = 7500;
        propiedades = new ArrayList<>();
    }
    
    public String getName() {
        return nombre;
    }

    public Casilla getCasillaActual() {
        return this.casillaActual;
    }

    public boolean getEncarcelado() {
        return encarcelado;
    }

    /**
     * Comprobar si el jugador tiene propiedades
     * @return verdadero cuando el jugador es propietario de algún título de propiedad
     */
    public boolean tengoPropiedades() {
        return !propiedades.isEmpty();
    }
    
    public List<TituloPropiedad> getPropiedades() {
        return this.propiedades;
    }

    /**
     * Actualizar la posición de un jugador
     * @param casilla Casilla a donde va
     * @return true si la casilla destino tiene propietario
     */
    boolean actualizarPosicion(Casilla casilla) {
        //Si pasa por la casilla de salida, dar saldo
        if (casilla.getNumeroCasilla() < casillaActual.getNumeroCasilla()) {
            modificarSaldo(Qytetet.getInstance().SALDO_SALIDA);
        }
        
        boolean tienePropietario = false;
        setCasillaActual(casilla);
        if (casilla.soyEdificable()) {
            tienePropietario = casilla.tengoPropietario();
            if (tienePropietario) {
                if (!casilla.propietarioEncarcelado()) {
                    int costeAlquiler = casilla.cobrarAlquiler();
                    modificarSaldo(-1 * costeAlquiler);
                }
            }
        } else if (casilla.getTipo() == TipoCasilla.IMPUESTO) {
            int coste = casilla.getCoste();
            modificarSaldo(-1 * coste);
        }
        
        return tienePropietario;
    }

    /**
     * El jugador intenta comprar un titulo de propiedad
     * @return true si la compra ha sido correcta
     */
    boolean comprarTitulo() {
        boolean puedoComprar = false;
        
        if (casillaActual.soyEdificable()) {
            if (!casillaActual.tengoPropietario()) {
                int costeCompra = casillaActual.getCoste();
                if (costeCompra <= saldo) {
                    TituloPropiedad titulo = casillaActual.asignarPropietario(this);
                    propiedades.add(titulo);
                    modificarSaldo(-1 * costeCompra);
                    
                    puedoComprar = false;
                }
            }
        }
        return puedoComprar;
    }

    /**
     * Quitar la carta de libertad de un jugador
     * @return La carta
     */
    Sorpresa devolverCartaLibertad() {
        Sorpresa old = cartaLibertad;
        Qytetet.getInstance().getMazo().add(old);
        cartaLibertad = null;
        return old;
    }

    /**
     * Mandar a un jugador a la cárcel
     * @param casilla La cárcel
     */
    void irACarcel(Casilla casilla) {
        setCasillaActual(casilla);
        setEncarcelado(true);
    }

    /**
     * Añade al saldo la cantidad del argumento.
     * Si el argumento es negativo, el saldo quedará reducido. 
     * @param cantidad Cantidad que modificará el saldo
     */
    void modificarSaldo(int cantidad) {
        this.saldo += cantidad;
    }
    
    void setSaldo(int cantidad) {
        this.saldo = cantidad;
    }

    /**
     * Devuelve el capital del que dispone el jugador, que es igual a su saldo más la suma de los valores de todas sus propiedades.
     * El valor de una propiedad es la suma de su coste más el número de casas y hoteles que haya construidos por el precio de edificación.
     * Si la propiedad estuviese hipotecada, se le restará el valor de la hipoteca base. 
     * @return Capital del usuario
     */
    int obtenerCapital() {
        return propiedades.stream()
                .map(t -> t.getCasilla().getCoste() + t.getPrecioEdificar() * (t.getCasilla().getNumCasas() + t.getCasilla().getNumHoteles()))
                .reduce(saldo, Integer::sum);
    }

    /**
     * Devuelve los títulos de propiedad del jugadorActual que estén hipotecados (cuando el parámetro hipotecada sea true) 
     * o que no estén hipotecados (cuando el parámetro hipotecada sea false).
     * @param hipotecada Si las propiedaes están hipotecadas o no
     * @return Propiedades que estén en propiedad y estén o no hipotecadas en función del parámetro
     */
    List<TituloPropiedad> obtenerPropiedadesHipotecadas(boolean hipotecada) {        
        return getPropiedades().stream().filter(t -> t.isHipotecada() == hipotecada).collect(Collectors.toList());
    }

    /**
     * Se resta al jugador una cantidad de dinero tantas casas y hoteles como tenga
     * @param cantidad Cantidad a pagar por cada casa u hotel
     */
    void pagarCobrarPorCasaYHotel(int cantidad) {       
        modificarSaldo(-1 * cantidad * cuantasCasasHotelesTengo());
    }

    /**
     * Pagar la libertad para salir de la cárcel
     * @param precioLibertad Precio de salida de la cárcel
     * @return true si puede pagarlo
     */
    boolean pagarLibertad(int precioLibertad) {
        boolean tengoSaldo = tengoSaldo(precioLibertad);
        if (tengoSaldo) {
            modificarSaldo(-1 * precioLibertad);
        }
        return tengoSaldo;
    }

    /**
     * Comprobar si puedo edificar una casa en una casilla
     * @param casilla La casilla a edificar
     * @return true si es mía y puedo pagarlo
     */
    boolean puedoEdificarCasa(Casilla casilla) {
        return esDeMiPropiedad(casilla) && tengoSaldo(casilla.getPrecioEdificar());
    }

    boolean puedoEdificarHotel(Casilla casilla) {
        return esDeMiPropiedad(casilla) && tengoSaldo(casilla.getPrecioEdificar());
    }

    /**
     * Un jugador puede hipotecar una casilla siempre y cuando sea de su propiedad y esté en su turno
     * @param casilla Casilla a comprobar
     * @return 
     */
    boolean puedoHipotecar(Casilla casilla) {
        return esDeMiPropiedad(casilla);
    }

    /**
     * Un jugador va a poder pagar la hipoteca de una casilla cuando sea de su propiedad y pueda pagar el coste de hipoteca más un 10%
     * @param casilla Casilla a comprobar
     * @return 
     */
    boolean puedoPagarHipoteca(Casilla casilla) {
        return (esDeMiPropiedad(casilla) && (casilla.calcularValorHipoteca() * 1.10) <= saldo);
    }

    /**
     * Comprobar si una casilla puede ser vendida o no
     * @param casilla Casilla que se quiere vender
     * @return Cierto sólo si la casilla no está hipotecada.
     */
    boolean puedoVenderPropiedad(Casilla casilla) {
        return casilla.estaHipotecada() && casilla.getTitulo().getPropietario().equals(this);
    }

    void setCartaLibertad(Sorpresa carta) {
        this.cartaLibertad = carta;
    }

    void setCasillaActual(Casilla casilla) {
        this.casillaActual = casilla;
    }

    void setEncarcelado(boolean encarcelado) {
        this.encarcelado = encarcelado;
    }

    /**
     * Comprobar si el jugador tiene sorpresa carta de libertad
     * @return True sólo si cartaLibertad no es nula
     */
    boolean tengoCartaLibertad() {
        return cartaLibertad != null;
    }

    /**
     * El jugador vende una propiedad
     * @param casilla Casilla a vender
     */
    void venderPropiedad(Casilla casilla) {
        int precioVenta = casilla.venderTitulo();
        casilla.getTitulo().setPropietario(null);
        casilla.setNumCasas(0);
        casilla.setNumHoteles(0);
        modificarSaldo(precioVenta);
        eliminarDeMisPropiedades(casilla);
    }

    /**
     * Devuelve el total de casas y hoteles que tiene ese jugador en todas sus propiedades. 
     * @return total de casas y hoteles
     */
    private int cuantasCasasHotelesTengo() {
        return propiedades.stream().map(TituloPropiedad::getCasilla).map(c -> c.getNumHoteles() + c.getNumCasas()).reduce(0, Integer::sum);
    }

    /**
     * Elimina el titulo de propiedad de esa casilla de su lista de propiedades
     * @param casilla Casilla a eliminar
     */
    private void eliminarDeMisPropiedades(Casilla casilla) {
        propiedades.remove(casilla.getTitulo());
    }

    /**
     * Comprobar si el jugador tiene en propiedad una cierta casilla
     * @param casilla Casilla a comprobar
     * @return Cierto si el jugador tiene entre sus propiedades el título de propiedad de esa casilla.
     */
    private boolean esDeMiPropiedad(Casilla casilla) {
        return propiedades.stream().map(TituloPropiedad::getCasilla).anyMatch(c -> c.getNumeroCasilla() == casilla.getNumeroCasilla());
    }

    /**
     * Comprobar saldo de un jugador en función de una cantidad
     * @param cantidad Cantidad a comprobar
     * @return verdadero si el saldo del jugador es superior o igual a cantidad.
     */
    private boolean tengoSaldo(int cantidad) {
        return (cantidad <= this.saldo);
    }
    
    @Override
    public String toString() {
        return "Jugador{" + "nombre=" + nombre + ", encarcelado=" + encarcelado + ", saldo=" + saldo
                + ", casillaActual=" + casillaActual + ", cartaLibertad=" + cartaLibertad + "}";
    }

}
