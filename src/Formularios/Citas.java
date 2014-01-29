
package Formularios;

import BaseDeDatos.ConexionMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class Citas extends javax.swing.JFrame {

  
    public Citas() {
        initComponents();
    }
    
    
    void MostrarPaciente(String ced) {
        String cedula = "", edad="", sexo="", nombres="", apellidos="", direccion ="", nummovil="", numfijo="" ,correo=""; 
        String sSQL = "";
        ConexionMySQL mysql = new ConexionMySQL();
        Connection cn = mysql.Conectar();
        
      
        sSQL = "SELECT pac_cedula, pac_edad, pac_sexo, pac_nombres, pac_apellidos, pac_direccion, pac_nummovil, pac_numfijo, pac_usuariocorreo genero FROM paciente"
                + "WHERE pac_cedula= "+ced;
        try {
            Statement st = cn.prepareStatement(sSQL);
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                 
                cedula = rs.getString("pac_cedula");
                edad= rs.getString("pac_edad");
                sexo = rs.getString("pac_sexo");
                nombres  = rs.getString("pac_nombres");
                apellidos = rs.getString("pac_apellidos");
                direccion = rs.getString("pac_direccion");
                nummovil = rs.getString("pac_nummovil");
                numfijo = rs.getString("pac_numfijo");
                correo = rs.getString("pac_usuariocorreo");
            }
                txtcedula.setText(cedula);
                txtedad.setText(edad);
                txtsexo.setText(sexo);
                txtnombres.setText(nombres);
                txtapellidos.setText(apellidos);
                txtdireccion.setText(direccion);
                txtnummovil.setText(nummovil);
                txtnumfijo.setText(numfijo);
                txtcorreo.setText(correo);
                
                
        

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtcorreo = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtcedula = new javax.swing.JTextField();
        txtedad = new javax.swing.JTextField();
        txtsexo = new javax.swing.JTextField();
        txtnombres = new javax.swing.JTextField();
        txtapellidos = new javax.swing.JTextField();
        txtdireccion = new javax.swing.JTextField();
        txtnummovil = new javax.swing.JTextField();
        txtnumfijo = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        clrfecha = new org.gui.JCalendarCombo();
        btnGuardar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Paciente"));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel1.setText("Cedula");

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel2.setText("Nombres");

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel3.setText("Apellidos");

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel4.setText("Direccion");

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel5.setText("Telefono Movil");

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel6.setText("Telefono Fijo ");

        txtcorreo.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        txtcorreo.setText("Correo Electronico");

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel8.setText("Edad");

        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel9.setText("Sexo");

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel7.setText("Fecha de Cita");

        clrfecha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clrfechaMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                clrfechaMousePressed(evt);
            }
        });
        clrfecha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                clrfechaFocusLost(evt);
            }
        });
        clrfecha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                clrfechaKeyPressed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");

        btnCancelar.setText("Cancelar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtcedula, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtedad, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(txtsexo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtnombres, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtnummovil, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtnumfijo))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnGuardar)
                                    .addComponent(txtcorreo))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField1)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(btnCancelar)
                                        .addGap(34, 34, 34)))))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtapellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtdireccion)
                                .addContainerGap())))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnModificar)
                        .addGap(28, 28, 28)
                        .addComponent(btnEliminar))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(clrfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 148, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtcedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtedad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtsexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtnombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtapellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtnummovil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtnumfijo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcorreo)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clrfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnCancelar))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clrfechaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clrfechaMouseClicked
        //    JOptionPane.showMessageDialog(this, evt);
    }//GEN-LAST:event_clrfechaMouseClicked

    private void clrfechaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clrfechaMousePressed
        //JOptionPane.showMessageDialog(this, evt);
    }//GEN-LAST:event_clrfechaMousePressed

    private void clrfechaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_clrfechaFocusLost

    }//GEN-LAST:event_clrfechaFocusLost

    private void clrfechaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_clrfechaKeyPressed

    }//GEN-LAST:event_clrfechaKeyPressed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
    String dia="", mes="", ano="", fecha="";
        dia=clrfecha.getSelectedDay();
        mes=clrfecha.getSelectedMonth();
        ano=clrfecha.getSelectedYear();
        fecha=ano+"/"+mes+"/"+dia; 
        //Conexion a la base de datos
        ConexionMySQL mysql = new ConexionMySQL();
        Connection cn = mysql.Conectar();
        String sSQL = "";
        String mensaje = "";
        sSQL="INSERT INTO cita(fecha_cita) VALUES (?)";
        mensaje="Cita Guardada";
        this.dispose();
        try {
        PreparedStatement pst = cn.prepareStatement(sSQL);
        pst.setString(1, fecha);
        int n = pst.executeUpdate();
        if (n > 0) {
        JOptionPane.showMessageDialog(null, mensaje);
        }
        }
        catch(SQLException ex){
        JOptionPane.showMessageDialog(null,ex);
        }                                         

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
 String dia="", mes="", ano="", fecha="";
        dia=clrfecha.getSelectedDay();
        mes=clrfecha.getSelectedMonth();
        ano=clrfecha.getSelectedYear();
        fecha=ano+"/"+mes+"/"+dia; 
        //Conexion a la base de datos
        ConexionMySQL mysql = new ConexionMySQL();
        Connection cn = mysql.Conectar();
        String sSQL = "";
        String mensaje = "";
        sSQL="UPDATE citas SET (fecha_cita) VALUES (?)";
        mensaje="Cita Guardada";
        this.dispose();
        try {
        PreparedStatement pst = cn.prepareStatement(sSQL);
        pst.setString(1, fecha);
        int n = pst.executeUpdate();
        if (n > 0) {
        JOptionPane.showMessageDialog(null, mensaje);
        }
        }
        catch(SQLException ex){
        JOptionPane.showMessageDialog(null,ex);
        }   
    }//GEN-LAST:event_btnModificarActionPerformed

    
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Citas().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private org.gui.JCalendarCombo clrfecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField txtapellidos;
    private javax.swing.JTextField txtcedula;
    private javax.swing.JLabel txtcorreo;
    private javax.swing.JTextField txtdireccion;
    private javax.swing.JTextField txtedad;
    private javax.swing.JTextField txtnombres;
    private javax.swing.JTextField txtnumfijo;
    private javax.swing.JTextField txtnummovil;
    private javax.swing.JTextField txtsexo;
    // End of variables declaration//GEN-END:variables
   
 }

