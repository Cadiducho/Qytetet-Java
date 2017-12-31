/**
 * Captura de los nombres de los jugadores de Qytetet
 */

package GUIQytetet;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * @author Ana Anaya
 * @author Cadiducho - Modificación para insertar varios jugador (no especificar el numero, detectarlo)
 */
public class CapturaNombreJugadores extends javax.swing.JDialog {

    private final ArrayList<String> nombres = new ArrayList<>();
    
    public CapturaNombreJugadores(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();       
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing (WindowEvent e) {
                    System.exit(0);
            }
        });
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        nombreJ1 = new javax.swing.JTextField();
        nombreJ2 = new javax.swing.JTextField();
        nombreJ3 = new javax.swing.JTextField();
        nombreJ4 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        labelJ1 = new javax.swing.JLabel();
        labelJ2 = new javax.swing.JLabel();
        labelJ3 = new javax.swing.JLabel();
        labelJ4 = new javax.swing.JLabel();
        jbJugar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nombre de los jugadores");

        nombreJ1.setText("");
        nombreJ2.setText("");
        nombreJ3.setText("");
        nombreJ4.setText("");

        jLabel1.setText("Indica el número de jugadores y pulsa enter:");

        labelJ1.setText("Jugador 1");
        labelJ2.setText("Jugador 2");
        labelJ3.setText("Jugador 3");
        labelJ4.setText("Jugador 4");

        jbJugar.setText("¡ JUGAR !");
        jbJugar.addActionListener(this::jbJugarActionPerformed);


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelJ1)
                            .addComponent(labelJ2)
                            .addComponent(labelJ3)
                            .addComponent(labelJ4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nombreJ4, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nombreJ3, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nombreJ2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nombreJ1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(jbJugar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(38, 38, 38))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nombreJ1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelJ1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nombreJ2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelJ2))
                        .addGap(18, 18, 18)
                        .addComponent(nombreJ3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labelJ3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nombreJ4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelJ4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jbJugar)
                .addContainerGap())
        );

        pack();
    }

    private void jbJugarActionPerformed(java.awt.event.ActionEvent evt) {
        if (!nombreJ1.getText().trim().isEmpty()) nombres.add(nombreJ1.getText());
        if (!nombreJ2.getText().trim().isEmpty()) nombres.add(nombreJ2.getText());
        if (!nombreJ3.getText().trim().isEmpty()) nombres.add(nombreJ3.getText());
        if (!nombreJ4.getText().trim().isEmpty()) nombres.add(nombreJ4.getText());
        
        if (nombres.size() < 2) {
            JOptionPane.showMessageDialog(null, "Debes introducir dos o más jugadores", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        this.dispose();
    }

    public List<String> obtenerNombres() {
        this.setVisible(true);
        return nombres;
        //return Arrays.asList("Jugador 1", "Jugador 2");
    }

    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jbJugar;
    private javax.swing.JLabel labelJ1;
    private javax.swing.JLabel labelJ2;
    private javax.swing.JLabel labelJ3;
    private javax.swing.JLabel labelJ4;
    private javax.swing.JTextField nombreJ1;
    private javax.swing.JTextField nombreJ2;
    private javax.swing.JTextField nombreJ3;
    private javax.swing.JTextField nombreJ4;
}
