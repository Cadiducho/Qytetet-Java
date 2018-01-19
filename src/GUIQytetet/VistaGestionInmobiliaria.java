package GUIQytetet;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import modeloqytetet.Qytetet;
import modeloqytetet.TituloPropiedad;

public class VistaGestionInmobiliaria extends javax.swing.JPanel {
    
    /**
     * Creates new form VistaGestionInmobiliaria
     */
    public VistaGestionInmobiliaria() {
        initComponents();
    }
    
    public void actualizar(List<TituloPropiedad> titulos) {
        jComboBox.setModel(new DefaultComboBoxModel(titulos.toArray()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator7 = new javax.swing.JSeparator();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jbEdificarCasa = new javax.swing.JButton();
        jbEdificarHotel = new javax.swing.JButton();
        jbVender = new javax.swing.JButton();
        jbHipotecar = new javax.swing.JButton();
        jbCancelarHipo = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jComboBox = new javax.swing.JComboBox<>();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        setBackground(new java.awt.Color(204, 153, 255));

        jbEdificarCasa.setText("Edificar Casa");
        jbEdificarCasa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEdificarCasaActionPerformed(evt);
            }
        });

        jbEdificarHotel.setText("Edificar Hotel");
        jbEdificarHotel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEdificarHotelActionPerformed(evt);
            }
        });

        jbVender.setText("Vender propiedad");
        jbVender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVenderActionPerformed(evt);
            }
        });

        jbHipotecar.setText("Hipotecar propiedad");
        jbHipotecar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbHipotecarActionPerformed(evt);
            }
        });

        jbCancelarHipo.setText("Cancelar hipoteca");
        jbCancelarHipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarHipoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Escoge el título inmobiliario");

        jComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jSeparator1)
                .addGap(12, 12, 12))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 703, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbEdificarCasa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator3)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jbVender, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbCancelarHipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbHipotecar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator2)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbEdificarHotel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbEdificarCasa, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbEdificarHotel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jbHipotecar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbCancelarHipo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbVender, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbEdificarHotelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEdificarHotelActionPerformed
        handleGestion(2);
    }//GEN-LAST:event_jbEdificarHotelActionPerformed

    private void jComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxActionPerformed

    }//GEN-LAST:event_jComboBoxActionPerformed

    private void jbEdificarCasaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEdificarCasaActionPerformed
        handleGestion(1);
    }//GEN-LAST:event_jbEdificarCasaActionPerformed

    private void jbVenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVenderActionPerformed
        handleGestion(3);
    }//GEN-LAST:event_jbVenderActionPerformed

    private void jbHipotecarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbHipotecarActionPerformed
        handleGestion(4);
    }//GEN-LAST:event_jbHipotecarActionPerformed

    private void jbCancelarHipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarHipoActionPerformed
        handleGestion(5);
    }//GEN-LAST:event_jbCancelarHipoActionPerformed

    private void handleGestion(int type) {
        Qytetet juego = Qytetet.getInstance();
        TituloPropiedad propiedad = juego.getJugadorActual().getPropiedades().get(jComboBox.getSelectedIndex());
        switch (type) {
            case 1:
                boolean edificada = Qytetet.getInstance().edificarCasa(propiedad.getCalle());
                ControladorQytetet.mostrar((edificada ? "Has edificado" : "No has podido edificar") + " una casa");
                break;
            case 2:
                boolean edificado = juego.edificarHotel(propiedad.getCalle());
                ControladorQytetet.mostrar((edificado ? "Has edificado" : "No has podido edificar") + " un hotel");
                break;
            case 3:
                boolean vendido = juego.venderPropiedad(propiedad.getCalle());
                ControladorQytetet.mostrar((vendido ? "Has vendido" : "No has podido vender") + " la casilla");
                break;
            case 4:
                boolean hipotecada = juego.hipotecarPropiedad(propiedad.getCalle());
                ControladorQytetet.mostrar((hipotecada ? "Has hipotecado" : "No has podido hipotecar") + " la casilla");
                break;
            case 5:
                boolean cancelada = juego.cancelarHipoteca(propiedad.getCalle());
                ControladorQytetet.mostrar((cancelada ? "Has cancelado" : "No has podido cancelar") + " la hipoteca de la casilla");
        }
        ControladorQytetet.getInstance().actualizar(juego); //actualizar interfaz con las gestiones hechas
        
        if (juego.getJugadorActual().getPropiedades().isEmpty()) { //si ha vendido sus propiedades ya no se puede gestionar más
            ControladorQytetet.getInstance().finGestion();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JButton jbCancelarHipo;
    private javax.swing.JButton jbEdificarCasa;
    private javax.swing.JButton jbEdificarHotel;
    private javax.swing.JButton jbHipotecar;
    private javax.swing.JButton jbVender;
    // End of variables declaration//GEN-END:variables
}
