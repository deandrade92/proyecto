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

public class IngreseCedula extends javax.swing.JFrame {

    public IngreseCedula() {

        initComponents();
        habilitar();

    }

    void habilitar() {
        txtcedulapaciente.setEnabled(true);
        txtnombres.setEnabled(false);
        txtapellidos.setEnabled(false);
        txtsexo.setEnabled(false);
        txtedad.setEnabled(false);
        txtdireccion.setEnabled(false);
        txtnummovil.setEnabled(false);
        txtnumfijo.setEnabled(false);
        txtcorreoc.setEnabled(false);
    }

    void inhabilitar() {

        txtcedulapaciente.setEnabled(false);
        txtnombres.setEnabled(false);
        txtapellidos.setEnabled(false);
        txtsexo.setEnabled(false);
        txtedad.setEnabled(false);
        txtdireccion.setEnabled(false);
        txtnummovil.setEnabled(false);
        txtnumfijo.setEnabled(false);
        txtcorreoc.setEnabled(false);
    }

    void limpiar() { //Declaracion del metodo que permite limpiar los campos

        habilitar();
        txtcedulapaciente.setText("");
        txtnombres.setText("");
        txtapellidos.setText("");
        txtsexo.setText("");
        txtedad.setText("");
        txtdireccion.setText("");
        txtnummovil.setText("");
        txtnumfijo.setText("");
        txtcorreoc.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnBuscar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtcedulapaciente = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtcorreo = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtedad = new javax.swing.JTextField();
        txtsexo = new javax.swing.JTextField();
        txtnombres = new javax.swing.JTextField();
        txtapellidos = new javax.swing.JTextField();
        txtdireccion = new javax.swing.JTextField();
        txtnummovil = new javax.swing.JTextField();
        txtnumfijo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        clrfecha = new org.gui.JCalendarCombo();
        btnGuardar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtcorreoc = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        clrfecha1 = new org.gui.JCalendarCombo();
        btnGuardar1 = new javax.swing.JButton();
        btnModificar1 = new javax.swing.JButton();
        btnEliminar1 = new javax.swing.JButton();
        btnCancelar1 = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        btnBuscar.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel2.setText("Ingrese el Numero de Cedula del Paciente");

        txtcedulapaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcedulapacienteActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Paciente"));

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel3.setText("Nombres");

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel4.setText("Apellidos");

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel5.setText("Direccion");

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel6.setText("Telefono Movil");

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel7.setText("Telefono Fijo ");

        txtcorreo.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        txtcorreo.setText("Correo Electronico");

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel8.setText("Edad");

        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel9.setText("Sexo");

        txtnombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombresActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel10.setText("Fecha de Cita");

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnModificar)
                                .addGap(28, 28, 28)
                                .addComponent(btnEliminar))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(clrfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)
                        .addGap(24, 24, 24)
                        .addComponent(txtdireccion)))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(29, 29, 29)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtnombres, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtedad, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(txtsexo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtapellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(btnGuardar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCancelar)
                                .addGap(34, 34, 34))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtnummovil, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtnumfijo))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtcorreo)
                                .addGap(6, 6, 6)
                                .addComponent(txtcorreoc)))
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtedad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtsexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtnombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtapellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtnummovil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtnumfijo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcorreo)
                    .addComponent(txtcorreoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(124, 124, 124)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clrfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel11.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel11.setText("Fecha de Cita");

        clrfecha1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clrfecha1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                clrfecha1MousePressed(evt);
            }
        });
        clrfecha1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                clrfecha1FocusLost(evt);
            }
        });
        clrfecha1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                clrfecha1KeyPressed(evt);
            }
        });

        btnGuardar1.setText("Guardar");
        btnGuardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardar1ActionPerformed(evt);
            }
        });

        btnModificar1.setText("Modificar");
        btnModificar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificar1ActionPerformed(evt);
            }
        });

        btnEliminar1.setText("Eliminar");
        btnEliminar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar1ActionPerformed(evt);
            }
        });

        btnCancelar1.setText("Cancelar");
        btnCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelar1ActionPerformed(evt);
            }
        });

        btnLimpiar.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnGuardar1)
                                .addGap(18, 18, 18)
                                .addComponent(btnModificar1)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(clrfecha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminar1)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelar1))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtcedulapaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcedulapaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(btnLimpiar))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clrfecha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificar1)
                    .addComponent(btnGuardar1)
                    .addComponent(btnEliminar1)
                    .addComponent(btnCancelar1))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String sSQL = "", cedula = "", status = "", nombres = "", apellidos = "", edad = "", sexo = "", direccion = "", codtmovil = "", numtmovil = "", codtfijo = "", numtfijo = "", correo1 = "", correo2 = "", correo3 = "";
        cedula = txtcedulapaciente.getText();
        if ((txtcedulapaciente.getText().isEmpty()) || (txtcedulapaciente.equals('0'))) {
            JOptionPane.showMessageDialog(null, "No ha introducido ningun valor");
        }
        ConexionMySQL mysql = new ConexionMySQL();
        Connection cn = mysql.Conectar();

        sSQL = "SELECT pac_nombres, pac_apellidos, pac_sexo, pac_fecha, pac_edad, pac_direccion, pac_nombrespm, pac_apellidospm, pac_codtmovil, pac_numtmovil, pac_codtfijo, pac_numtfijo, pac_usuariocorreo, pac_tipocorreo,  pac_extensioncorreo, pac_status FROM paciente WHERE CONCAT (pac_cedula) = '" + cedula + "'";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {

                nombres = rs.getString("pac_nombres");
                apellidos = rs.getString("pac_apellidos");
                sexo = rs.getString("pac_sexo");
                edad = rs.getString("pac_edad");
                direccion = rs.getString("pac_direccion");
                codtmovil = rs.getString("pac_codtmovil");
                numtmovil = rs.getString("pac_numtmovil");
                codtfijo = rs.getString("pac_codtfijo");
                numtfijo = rs.getString("pac_numtfijo");
                correo1 = rs.getString("pac_usuariocorreo");
                correo2 = rs.getString("pac_tipocorreo");
                correo3 = rs.getString("pac_extensioncorreo");
                status = rs.getString("pac_status");
            }
            if (status.equals("A")) {
                inhabilitar();
                txtnombres.setText(nombres);
                txtapellidos.setText(apellidos);
                txtsexo.setText(sexo);
                txtedad.setText(edad);
                txtdireccion.setText(direccion);
                txtnummovil.setText(codtmovil + numtmovil);
                txtnumfijo.setText(codtfijo + numtfijo);
                txtcorreoc.setText(correo1 + correo2 + correo3);
            } else {
                JOptionPane.showMessageDialog(null, "Paciente no registrado");
                this.dispose();
                Paciente frmpaciente = new Paciente();
                Maestro.mostarUnavez(null, frmpaciente);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }//GEN-LAST:event_btnBuscarActionPerformed

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
        String dia = "", mes = "", ano = "", fecha = "";
        dia = clrfecha.getSelectedDay();
        mes = clrfecha.getSelectedMonth();
        ano = clrfecha.getSelectedYear();
        fecha = ano + "/" + mes + "/" + dia;
        //Conexion a la base de datos
        ConexionMySQL mysql = new ConexionMySQL();
        Connection cn = mysql.Conectar();
        String sSQL = "";
        String mensaje = "";
        sSQL = "INSERT INTO citas(fecha_cita) VALUES (?)";
        mensaje = "Cita Guardada";
        this.dispose();
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, fecha);
            int n = pst.executeUpdate();
            if (n > 0) {
                JOptionPane.showMessageDialog(null, mensaje);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
    }//GEN-LAST:event_btnModificarActionPerformed

    private void clrfecha1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clrfecha1MouseClicked
        //    JOptionPane.showMessageDialog(this, evt);
    }//GEN-LAST:event_clrfecha1MouseClicked

    private void clrfecha1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clrfecha1MousePressed
        //JOptionPane.showMessageDialog(this, evt);
    }//GEN-LAST:event_clrfecha1MousePressed

    private void clrfecha1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_clrfecha1FocusLost
    }//GEN-LAST:event_clrfecha1FocusLost

    private void clrfecha1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_clrfecha1KeyPressed
    }//GEN-LAST:event_clrfecha1KeyPressed

    private void btnGuardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardar1ActionPerformed
        String dia = "", mes = "", ano = "", fecha = "", nombres = "", apellidos = "", cedula = "", nombrecom = "";
        dia = clrfecha1.getSelectedDay();
        mes = clrfecha1.getSelectedMonth();
        ano = clrfecha1.getSelectedYear();
        fecha = ano + "/" + mes + "/" + dia;
        
        nombres = txtnombres.getText();
        apellidos = txtapellidos.getText();
        nombrecom = nombres + apellidos;
        cedula = txtcedulapaciente.getText();

        //Conexion a la base de datos
        ConexionMySQL mysql = new ConexionMySQL();
        Connection cn = mysql.Conectar();
        String sSQL = "";
        String mensaje = "";
        sSQL = "INSERT INTO citas (pac_cedula, pac_nombre, fecha_cita) VALUES (?,?,?)";
        mensaje = "Cita Guardada";
        
        this.dispose();
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, cedula);
            pst.setString(2, nombrecom);
            pst.setString(3, fecha);
            int n = pst.executeUpdate();
            if (n > 0) {
                JOptionPane.showMessageDialog(null, mensaje);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_btnGuardar1ActionPerformed

    private void btnModificar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar1ActionPerformed
     String dia = "", mes = "", ano = "", fecha = "", nombres = "", apellidos = "", cedula = "", nombrecom = "";
        dia = clrfecha1.getSelectedDay();
        mes = clrfecha1.getSelectedMonth();
        ano = clrfecha1.getSelectedYear();
        fecha = ano + "/" + mes + "/" + dia;
        
        nombres = txtnombres.getText();
        apellidos = txtapellidos.getText();
        nombrecom = nombres + apellidos;
        cedula = txtcedulapaciente.getText();

        //Conexion a la base de datos
        ConexionMySQL mysql = new ConexionMySQL();
        Connection cn = mysql.Conectar();
        String sSQL = "";
        String mensaje = "";
        sSQL="UPDATE citas SET fecha_cita= '"+fecha+"' WHERE CONCAT (pac_cedula) = '"+cedula+"'";
        
        try {
            PreparedStatement pst=cn.prepareStatement(sSQL);
            int n=pst.executeUpdate();
            if(n>0){
                 JOptionPane.showMessageDialog(null,"Actualizacion Satisfactoria");
                 limpiar();
            }      
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex);
        }
    }//GEN-LAST:event_btnModificar1ActionPerformed

    private void txtnombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombresActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelar1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelar1ActionPerformed

    private void btnEliminar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar1ActionPerformed
    String dia = "", mes = "", ano = "", fecha = "", nombres = "", apellidos = "", cedula = "", nombrecom = "";
        dia = clrfecha1.getSelectedDay();
        mes = clrfecha1.getSelectedMonth();
        ano = clrfecha1.getSelectedYear();
        fecha = ano + "/" + mes + "/" + dia;
        
        nombres = txtnombres.getText();
        apellidos = txtapellidos.getText();
        nombrecom = nombres + apellidos;
        cedula = txtcedulapaciente.getText();

        //Conexion a la base de datos
        ConexionMySQL mysql = new ConexionMySQL();
        Connection cn = mysql.Conectar();
        String sSQL = "";
        String mensaje = "";
            
        sSQL="DELETE FROM citas WHERE pac_cedula='"+cedula+"'";
        try {
            PreparedStatement pst=cn.prepareStatement(sSQL);
            int n=pst.executeUpdate();
            if(n>0){
                 JOptionPane.showMessageDialog(null,"Paciente eliminado Satisfactoriamente");
                  limpiar();
            }      
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex);
        }
    
    }//GEN-LAST:event_btnEliminar1ActionPerformed

    private void txtcedulapacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcedulapacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcedulapacienteActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IngreseCedula().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCancelar1;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEliminar1;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnGuardar1;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnModificar1;
    private org.gui.JCalendarCombo clrfecha;
    private org.gui.JCalendarCombo clrfecha1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txtapellidos;
    private javax.swing.JTextField txtcedulapaciente;
    private javax.swing.JLabel txtcorreo;
    private javax.swing.JTextField txtcorreoc;
    private javax.swing.JTextField txtdireccion;
    private javax.swing.JTextField txtedad;
    private javax.swing.JTextField txtnombres;
    private javax.swing.JTextField txtnumfijo;
    private javax.swing.JTextField txtnummovil;
    private javax.swing.JTextField txtsexo;
    // End of variables declaration//GEN-END:variables
}
