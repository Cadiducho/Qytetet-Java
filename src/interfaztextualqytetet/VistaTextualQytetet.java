package interfaztextualqytetet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class VistaTextualQytetet {

    private static final Scanner in = new Scanner(System.in);

    public int menuGestionInmobiliaria() {
        mostrar("Elige la gestion inmobiliaria que deseas hacer");
        Map<Integer, String> menuGI = new TreeMap<>();
        menuGI.put(0, "Siguiente Jugador");
        menuGI.put(1, "Edificar casa");
        menuGI.put(2, "Edificar Hotel");
        menuGI.put(3, "Vender propiedad ");
        menuGI.put(4, "Hipotecar Propiedad");
        menuGI.put(5, "Cancelar Hipoteca");
        int salida = seleccionMenu(menuGI); // Método para controlar la elección correcta en el menú 
        return salida;
    }

    public int menuSalirCarcel() {
        mostrar("Elige el metodo para salir de la carcel");
        Map<Integer, String> menuSO = new TreeMap<>();
        menuSO.put(0, "Tirando el dado");
        menuSO.put(1, "Pagando mi libertad");
        int salida = seleccionMenu(menuSO);
        return salida;
    }

    public boolean elegirQuieroComprar() {
        mostrar("Elige si quieres comprar la casilla");
        Map<Integer, String> menuSO = new TreeMap<>();
        menuSO.put(0, "No");
        menuSO.put(1, "Sí");
        int salida = seleccionMenu(menuSO);
        return salida != 0;
    }
    
    public int menuElegirPropiedad(List<String> listaPropiedades) {          
        Map<Integer, String> menuEP = new TreeMap<>();
        int numeroOpcion = 0;
        for (String prop : listaPropiedades) {
            menuEP.put(numeroOpcion, prop); //opcion de menu, numero y nombre de propiedad
            numeroOpcion = numeroOpcion + 1;
        }
        int salida = seleccionMenu(menuEP); // Método para controlar la elección correcta en el menú 
        return salida;

    }

    private int seleccionMenu(Map<Integer, String> menu) { //Método para controlar la elección correcta de una opción en el menú que recibe como argumento   
        boolean valido;
        int numero;
        String lectura;
        do { // Hasta que se hace una selección válida
            for (Map.Entry<Integer, String> fila : menu.entrySet()) {
                numero = fila.getKey();
                String texto = fila.getValue();
                this.mostrar(numero + " : " + texto);  // número de opción y texto
            }
            this.mostrar("\nElige una opción: ");
            lectura = in.nextLine();  //lectura de teclado
            valido = comprobarOpcion(lectura, 0, menu.size() - 1); //método para comprobar la elección correcta
        } while (!valido);
        return Integer.parseInt(lectura);
    }

    public ArrayList<String> obtenerNombreJugadores() { //método para pedir el nombre de los jugadores
        boolean valido;
        String lectura;
        ArrayList<String> nombres = new ArrayList();
        do { //repetir mientras que el usuario no escriba un número correcto 
            this.mostrar("Escribe el número de jugadores: (de 2 a 4):");
            lectura = in.nextLine();  //lectura de teclado
            valido = comprobarOpcion(lectura, 2, 4); //método para comprobar la elección correcta
        } while (!valido);

        for (int i = 1; i <= Integer.parseInt(lectura); i++) { //solicitud del nombre de cada jugador
            this.mostrar("Nombre del jugador " + i + ": ");
            nombres.add(in.nextLine());
        }
        return nombres;
    }

    private boolean comprobarOpcion(String lectura, int min, int max) {
        //método para comprobar que se introduce un entero correcto, usado por seleccion_menu
        boolean valido = true;
        int opcion;
        try {
            opcion = Integer.parseInt(lectura);
            if (opcion < min || opcion > max) { // No es un entero entre los válidos
                mostrar("el numero debe estar entre min y max");
                valido = false;
            }

        } catch (NumberFormatException e) { // No se ha introducido un entero
            mostrar("debes introducir un numero");
            valido = false;
        }
        if (!valido) {
            mostrar("\n\n Seleccion erronea. Intentalo de nuevo.\n\n");
        }
        return valido;
    }

    public void mostrar(Object texto) {
        System.out.println(texto);
    }
    
    public void pressToContinue() {
        System.out.println("Pulse una tecla para continuar");
        try {
            System.in.read();
        } catch (IOException e) {}
        mostrar("            \r");
    }
}
