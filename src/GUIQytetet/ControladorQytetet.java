package GUIQytetet;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import modeloqytetet.Casilla;
import modeloqytetet.Jugador;
import modeloqytetet.MetodoSalirCarcel;
import modeloqytetet.Qytetet;

/**
 *
 * @author cadid
 */
public class ControladorQytetet extends javax.swing.JFrame {

    private Qytetet juego;
    private Jugador jugador;
    private Casilla casilla;
    
    /**
     * Creates new form ControladorQytetet
     */
    public ControladorQytetet() {
        initComponents();
        juego = Qytetet.getInstance();
        
        CapturaNombreJugadores capturaNombres = new CapturaNombreJugadores(this, true);
        ArrayList<String> nombres = capturaNombres.obtenerNombres();
        
        juego.inicializarJuego(nombres);
        Dado.createInstance(this);
        
        actualizar(juego);
    }
    
    private void mostrar(String str) {
        JOptionPane.showMessageDialog(null, str, "Qytetet info", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void actualizar(Qytetet qytetet) {
        juego = qytetet;
        
        jugador = juego.getJugadorActual();
        casilla = jugador.getCasillaActual();
        
        vistaQytetet.actualizar(jugador.toString(), casilla.toString(), juego.getSorpresaActual() != null ? juego.getSorpresaActual().toString() : null);
        
        if (jugador.getEncarcelado()) {
            this.jbSalirDado.setEnabled(true);
            this.jbSalirPagando.setEnabled(true);
            this.jbJugar.setEnabled(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbSalirDado = new javax.swing.JButton();
        jbSalirPagando = new javax.swing.JButton();
        jbSiguienteJugador = new javax.swing.JButton();
        jbAplicarSorpresa = new javax.swing.JButton();
        jbComprarPropiedad = new javax.swing.JButton();
        jbJugar = new javax.swing.JButton();
        vistaQytetet = new GUIQytetet.VistaQytetet();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jbSalirDado.setText("Salir cárcel con dado");
        jbSalirDado.setEnabled(false);
        jbSalirDado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirDadoActionPerformed(evt);
            }
        });

        jbSalirPagando.setText("Salir cárcel pagando");
        jbSalirPagando.setEnabled(false);
        jbSalirPagando.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirPagandoActionPerformed(evt);
            }
        });

        jbSiguienteJugador.setText("Siguiente Jugador");
        jbSiguienteJugador.setEnabled(false);
        jbSiguienteJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSiguienteJugadorActionPerformed(evt);
            }
        });

        jbAplicarSorpresa.setText("Aplicar Sorpresa");
        jbAplicarSorpresa.setEnabled(false);
        jbAplicarSorpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAplicarSorpresaActionPerformed(evt);
            }
        });

        jbComprarPropiedad.setText("Comprar Propiedad");
        jbComprarPropiedad.setEnabled(false);
        jbComprarPropiedad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbComprarPropiedadActionPerformed(evt);
            }
        });

        jbJugar.setText("Jugar");
        jbJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbJugarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbSalirDado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbSalirPagando, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbJugar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbComprarPropiedad)
                .addGap(18, 18, 18)
                .addComponent(jbAplicarSorpresa)
                .addGap(18, 18, 18)
                .addComponent(jbSiguienteJugador)
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(vistaQytetet, javax.swing.GroupLayout.DEFAULT_SIZE, 773, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(vistaQytetet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbAplicarSorpresa)
                            .addComponent(jbComprarPropiedad)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbJugar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbSalirDado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbSalirPagando))))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbSiguienteJugador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void jbSalirDadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirDadoActionPerformed
        intentarSalirCarcel(MetodoSalirCarcel.TIRANDODADO);
    }//GEN-LAST:event_jbSalirDadoActionPerformed

    private void intentarSalirCarcel(MetodoSalirCarcel metodo) {
        this.jbSalirDado.setEnabled(true);
        this.jbSalirPagando.setEnabled(true);

        boolean sale = juego.intentarSalirCarcel(metodo);
        if (sale) {
            mostrar("Has salido de la cárcel. Ahora puedes seguir jugando");
            this.jbJugar.setEnabled(true);
        } else {
            mostrar("No has podido salir de la cárcel. Se pasa el turno");
            this.jbSiguienteJugador.setEnabled(true);
        }
    }
    
    private void jbJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbJugarActionPerformed
        this.jbJugar.setEnabled(false);
        boolean tienePropietario = juego.jugar();
        
        this.actualizar(juego);
        this.jbSiguienteJugador.setEnabled(true);
        
        switch (jugador.getCasillaActual().getTipo()) {
            case SORPRESA:
                mostrar(juego.getSorpresaActual().toString());
                
                this.jbAplicarSorpresa.setEnabled(true);     
                break;
            case CALLE:
                if (tienePropietario) {
                    mostrar("Has caído en una casilla con propietario");
                } else {
                    mostrar("Esta casila no tiene propietario");
                    this.jbComprarPropiedad.setEnabled(true);
                }
                break;

        }
    }//GEN-LAST:event_jbJugarActionPerformed

    private void jbAplicarSorpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAplicarSorpresaActionPerformed
        this.jbAplicarSorpresa.setEnabled(false);
        boolean nuevaCasillaPropietario = juego.aplicarSorpresa();
        if (nuevaCasillaPropietario) {
            mostrar("Has caído en una propiedad con propietario y has pagado su alquiler");
        }
        this.jbSiguienteJugador.setEnabled(true);
        this.actualizar(juego);
    }//GEN-LAST:event_jbAplicarSorpresaActionPerformed

    private void jbComprarPropiedadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbComprarPropiedadActionPerformed
        this.jbComprarPropiedad.setEnabled(false);
        boolean puedoComprar = juego.comprarTituloPropiedad();
        if (puedoComprar) {
            mostrar("Has comprado la casilla " + jugador.getCasillaActual().getNumeroCasilla());
        } else {
            mostrar("No puedes comprar la casilla " + jugador.getCasillaActual().getNumeroCasilla());
        }
        this.actualizar(juego);
    }//GEN-LAST:event_jbComprarPropiedadActionPerformed

    private void jbSiguienteJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSiguienteJugadorActionPerformed
        this.jbSiguienteJugador.setEnabled(false);
        if (jugador.getSaldo() <= 0) {
            // bancarrota
            mostrar("Ha terminado el juego porque " + jugador.getName() + " ha caído en bancarrota");
            
            this.jbJugar.setEnabled(false);
            this.jbSiguienteJugador.setEnabled(false);
        } else {
            // gestionar final de turno
            jugador = juego.siguienteJugador();
            casilla = jugador.getCasillaActual();
            
            this.jbJugar.setEnabled(true);
            this.jbComprarPropiedad.setEnabled(false);
            this.jbAplicarSorpresa.setEnabled(false);
            this.jbSalirDado.setEnabled(false);
            this.jbSalirPagando.setEnabled(false);
        }
        this.actualizar(juego);
    }//GEN-LAST:event_jbSiguienteJugadorActionPerformed

    private void jbSalirPagandoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirPagandoActionPerformed
        intentarSalirCarcel(MetodoSalirCarcel.PAGANDOLIBERTAD);
    }//GEN-LAST:event_jbSalirPagandoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        ControladorQytetet controladorQytetet = new ControladorQytetet();
        controladorQytetet.setTitle("Qytetet");
        controladorQytetet.setVisible(true);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbAplicarSorpresa;
    private javax.swing.JButton jbComprarPropiedad;
    private javax.swing.JButton jbJugar;
    private javax.swing.JButton jbSalirDado;
    private javax.swing.JButton jbSalirPagando;
    private javax.swing.JButton jbSiguienteJugador;
    private GUIQytetet.VistaQytetet vistaQytetet;
    // End of variables declaration//GEN-END:variables
}