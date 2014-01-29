
package Formularios;

import BaseDeDatos.ConexionMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Servicios extends javax.swing.JInternalFrame {
    String[] titulo={"Nombre","Precio","Descripcion"};
    DefaultTableModel modelo;

    public Servicios() {
        initComponents();
        modelo=new DefaultTableModel(null,titulo);
        tblservicio.setModel(modelo);
        inhabilitariconos();
    }
    
    void inhabilitariconos(){
        icon1.setVisible(false);
        icon2.setVisible(false);
        icon3.setVisible(false);
    }
    
    void limpiar(){
        txtnombre.setText("");
        txtprecio.setText("");
        txtdescripcion.setText("");
    }
    void CargarTablaServicio() {
        String[] registro= new String[3];
        String status="",sSQL ="";
        
        ConexionMySQL mysql =new ConexionMySQL();
        Connection cn=mysql.Conectar();
        
        sSQL="SELECT ser_nombre, ser_precio, ser_descripcion, ser_status FROM servicio";
        try {
             Statement st=cn.createStatement();
             ResultSet rs = st.executeQuery(sSQL); 
             
             while(rs.next()){
                 registro[0]=rs.getString("ser_nombre");           
                 registro[1]=rs.getString("ser_precio");
                 registro[2]=rs.getString("ser_descripcion");
                 status=rs.getString("ser_status");
                 
                 if(status.equals("A")){
                     modelo.addRow(registro);
                     NiveldeAcceso entrada= new NiveldeAcceso();
                     Statement stmt=cn.createStatement();
                     int result=stmt.executeUpdate("INSERT INTO bitacora VALUES (null,'"+entrada.nombre_usuario+"', 'Registro y Consulta de Servicios', 'Consulto Servicios', now())");
                 }
             } 
         }
         catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, ex);
        } 
    }
    
    void CargarTablaServicioPorNombre(String nombre) {
        String[] registro= new String[3];
        String status="",sSQL ="";
        
        ConexionMySQL mysql =new ConexionMySQL();
        Connection cn=mysql.Conectar();
        
        sSQL="SELECT ser_nombre, ser_precio, ser_descripcion, ser_status FROM servicio WHERE ser_nombre LIKE '%"+nombre+"%'";
         try {
             Statement st=cn.createStatement();
             ResultSet rs = st.executeQuery(sSQL); 
             
             while(rs.next()){
                 registro[0]=rs.getString("ser_nombre");           
                 registro[1]=rs.getString("ser_precio");
                 registro[2]=rs.getString("ser_descripcion");
                 status=rs.getString("ser_status");
                 
                 if(status.equals("A")){
                     modelo.addRow(registro);
                     NiveldeAcceso entrada= new NiveldeAcceso();
                     Statement stmt=cn.createStatement();
                     int result=stmt.executeUpdate("INSERT INTO bitacora VALUES (null,'"+entrada.nombre_usuario+"', 'Registro y Consulta de Servicios', 'Consulto Servicio: "+nombre+"', now())");
                 }
                 else{
                     JOptionPane.showMessageDialog(null,"No se encuentra ningun servicio registrado con el nombre que introdujo");
                 } 
             } 
         }
         catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, ex);
        } 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        mneditar = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnlimpiar = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        btnbuscar = new javax.swing.JButton();
        btnactualizar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtprecio = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtdescripcion = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblservicio = new javax.swing.JTable();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        icon1 = new javax.swing.JLabel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        icon2 = new javax.swing.JLabel();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        icon3 = new javax.swing.JLabel();

        jPopupMenu1.setComponentPopupMenu(jPopupMenu1);

        mneditar.setText("Modificar");
        mneditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mneditarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(mneditar);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registro y Consulta de servicios");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnlimpiar.setText("Limpiar");
        btnlimpiar.setToolTipText("Limpiar");
        btnlimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimpiarActionPerformed(evt);
            }
        });

        btnguardar.setText("Guardar");
        btnguardar.setToolTipText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btnbuscar.setText("Buscar");
        btnbuscar.setToolTipText("Buscar");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        btnactualizar.setText("Actualizar");
        btnactualizar.setToolTipText("Actualizar");
        btnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarActionPerformed(evt);
            }
        });

        btneliminar.setText("Eliminar");
        btneliminar.setToolTipText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        btnsalir.setText("Salir");
        btnsalir.setToolTipText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(btnlimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnactualizar)
                .addGap(14, 14, 14)
                .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(btnguardar)
                    .addContainerGap(491, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnlimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnactualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(btnguardar, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel1.setText("Nombre");

        txtnombre.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        txtnombre.setToolTipText("Introduzca el nombre del nuevo servicio que desea ofrecer. Ejemplo: Limpieza dental");

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel2.setText("Precio");

        txtprecio.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        txtprecio.setToolTipText("Introduzca el costo del  servicio que desea ofrecer. Ejemplo: 9999");

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel4.setText("C/U");

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel5.setText("Descripcion");

        txtdescripcion.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        txtdescripcion.setToolTipText("Introduzca la descripcion del servicio que desea ofrecer");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tblservicio.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        tblservicio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblservicio.setComponentPopupMenu(jPopupMenu1);
        tblservicio.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(tblservicio);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLayeredPane1.add(icon1);
        icon1.setBounds(0, 0, 0, 0);

        jLayeredPane2.add(icon2);
        icon2.setBounds(0, 0, 0, 0);

        jLayeredPane3.add(icon3);
        icon3.setBounds(0, 0, 0, 0);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLayeredPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtprecio, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(txtprecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(txtdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLayeredPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
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

    private void btnlimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_btnlimpiarActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
       String nombre="";
       
       nombre=txtnombre.getText();
       
       if(nombre.equals("")){
           CargarTablaServicio();
       }
       if(!nombre.equals("")){
           CargarTablaServicioPorNombre(nombre);
       }
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void btnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarActionPerformed
         String nombre="", precio="", descripcion="", sSQL="";
         
         nombre=txtnombre.getText();
         precio=txtprecio.getText();
         descripcion=txtdescripcion.getText();
         
         ConexionMySQL mysql=new ConexionMySQL();
         Connection cn = mysql.Conectar();
         
         sSQL="UPDATE servicio SET ser_nombre='"+nombre+"', ser_precio='"+precio+"', ser_descripcion='"+descripcion+"' WHERE ser_nombre= '"+nombre+"'";
         try {
            PreparedStatement pst=cn.prepareStatement(sSQL);
            int n=pst.executeUpdate();
            if(n>0){
                 JOptionPane.showMessageDialog(null,"Actualizacion Satisfactoria");
                 limpiar();
                 NiveldeAcceso entrada= new NiveldeAcceso();
                 Statement stmt=cn.createStatement();
                 int result=stmt.executeUpdate("INSERT INTO bitacora VALUES (null,'"+entrada.nombre_usuario+"', 'Registro y Consulta de Servicios', 'Actualizo servicio: "+nombre+"', now())");
            }      
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex);
        }
    }//GEN-LAST:event_btnactualizarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        String sSQL="";
        
        ConexionMySQL mysql =new ConexionMySQL();
        Connection cn=mysql.Conectar();
        
        int j=tblservicio.getSelectedRow();
        if(j==-1) {
        JOptionPane.showMessageDialog(null,"No se han seleccionado filas");
        }
        else{ 
        modelo = (DefaultTableModel) tblservicio.getModel();
        String id = (String) modelo.getValueAt(j,0);
            
        sSQL="UPDATE servicio SET ser_status='I' WHERE ser_nombre='"+id+"'";
        try {
            PreparedStatement pst=cn.prepareStatement(sSQL);
            int n=pst.executeUpdate();
            if(n>0){
                 JOptionPane.showMessageDialog(null,"Servicio eliminado Satisfactoriamente");
                 NiveldeAcceso entrada= new NiveldeAcceso();
                     Statement stmt=cn.createStatement();
                     int result=stmt.executeUpdate("INSERT INTO bitacora VALUES (null,'"+entrada.nombre_usuario+"', 'Registro y Consulta de Servicios', 'Elimino Servicio: "+id+"', now())");
            }      
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex);
        }
        }
        
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
       String nombre="", precio="", descripcion="", nombrev="", status="A", status2="", sSQL="", sSQL2="";
       
       nombre=txtnombre.getText();
       precio=txtprecio.getText();
       descripcion=txtdescripcion.getText();
       
       ConexionMySQL mysql = new ConexionMySQL();
       Connection cn = mysql.Conectar();
       
       if(nombre.equals("")){
            icon1.setVisible(true);
        }
        else{
           sSQL2="SELECT ser_nombre FROM servicio WHERE ser_nombre LIKE '%"+nombre+"%'";
       }
                try{
                    Statement st=cn.createStatement();
                    ResultSet rs = st.executeQuery(sSQL2);
                    while(rs.next()){
                        nombrev=rs.getString("ser_nombre");
                        status2=rs.getString("ser_status");
                    }
                    if(nombre.equals(nombrev)){
                        JOptionPane.showMessageDialog(null,"Ya existe un servicio registrado con este mismo nombre");
                    }
                    else{
                        if(precio.equals("")){
                            icon2.setVisible(true); 
                        }
                        else{
                            if(descripcion.equals("")){
                                icon3.setVisible(true);
                            }
                            else{
                                sSQL="INSERT INTO servicio (ser_nombre, ser_precio, ser_descripcion, ser_status) VALUES (?,?,?,?)";
                                try {
                                    PreparedStatement pst=cn.prepareStatement(sSQL);
                                    pst.setString(1, nombre);
                                    pst.setString(2, precio);
                                    pst.setString(3, descripcion);
                                    pst.setString(4, status);
                     
                                    int n = pst.executeUpdate();
                                    if (n > 0) {
                                    JOptionPane.showMessageDialog(null,"El servicio fue registrado");
                                    limpiar();
                                    NiveldeAcceso entrada= new NiveldeAcceso();
                                    Statement stmt=cn.createStatement();
                                    int result=stmt.executeUpdate("INSERT INTO bitacora VALUES (null,'"+entrada.nombre_usuario+"', 'Registro y Consulta de Servicios', 'Guardo Servicio: "+nombre+"', now())");
                                    }
                                }
                                catch(SQLException ex){
                                    JOptionPane.showMessageDialog(null,ex);
                                }
                            }
                        }
                    }
                }
                catch(SQLException ex){
                    JOptionPane.showMessageDialog(null,ex);
                }
    }//GEN-LAST:event_btnguardarActionPerformed

    private void mneditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mneditarActionPerformed
        String nombre="", precio="", descripcion="",  sSQL="";
        
        ConexionMySQL mysql =new ConexionMySQL();
        Connection cn=mysql.Conectar();
        int j=tblservicio.getSelectedRow();
        if(j==-1) {
        JOptionPane.showMessageDialog(null,"No se han seleccionado filas");
        }
        else{ 
        modelo = (DefaultTableModel) tblservicio.getModel();
        String id = (String) modelo.getValueAt(j,0);
        sSQL="SELECT ser_nombre, ser_precio, ser_descripcion FROM servicio WHERE ser_nombre='"+id+"'";
        }
         try {
             Statement st=cn.createStatement();
             ResultSet rs = st.executeQuery(sSQL);
             
             while(rs.next()){
                 nombre=rs.getString("ser_nombre");            
                 precio=rs.getString("ser_precio");
                 descripcion=rs.getString("ser_descripcion");
                
                 txtnombre.setText(nombre);
                 txtprecio.setText(precio);
                 txtdescripcion.setText(descripcion);
             }
         }
         catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_mneditarActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        // TODO add your handling code here:
        Maestro.cerrarVentana(this);
    }//GEN-LAST:event_formInternalFrameClosed

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Servicios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Servicios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Servicios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Servicios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Servicios().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnactualizar;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnlimpiar;
    private javax.swing.JButton btnsalir;
    private javax.swing.JLabel icon1;
    private javax.swing.JLabel icon2;
    private javax.swing.JLabel icon3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem mneditar;
    private javax.swing.JTable tblservicio;
    private javax.swing.JTextField txtdescripcion;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtprecio;
    // End of variables declaration//GEN-END:variables
}
