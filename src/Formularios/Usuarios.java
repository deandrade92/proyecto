package Formularios;

import BaseDeDatos.ConexionMySQL;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Usuarios extends javax.swing.JInternalFrame{
    String[] titulo={"Cedula","Nombres","Apellidos","Id","Nivel"};
    DefaultTableModel modelo;

    public Usuarios() {
        initComponents();
        modelo=new DefaultTableModel(null,titulo);
        tblusuario.setModel(modelo);
        inhabilitariconos();
    }
    
     void habilitarcedula(){
        cbocedula.setEnabled(true);
        txtcedula.setEnabled(true);
    }
     
    void inhabilitarcedula(){
        cbocedula.setEnabled(false);
        txtcedula.setEnabled(false);
    }
    
    void inhabilitariconos(){
        icon1.setVisible(false);
        icon2.setVisible(false);
        icon3.setVisible(false);
        icon4.setVisible(false);
        icon5.setVisible(false);
        icon6.setVisible(false);
        icon7.setVisible(false);
        icon8.setVisible(false);
    }
    public static String getFechaActual() {
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
        return formateador.format(ahora);
    }

    void limpiar(){
        habilitarcedula();
        inhabilitariconos();
        cbocedula.setSelectedItem("Seleccione");
        txtcedula.setText("");
        txtnombres.setText("");
        txtapellidos.setText("");
        txtid.setText("");
        passcontraseña.setText("");
        passrepitacontraseña.setText("");
        cboniveldeacceso.setSelectedItem("Seleccione");
    }
    
    void CargarTablaPacientePorCedula(String cedula) {
        String[] registro= new String[5];
        String status="",sSQL ="";
        
        ConexionMySQL mysql =new ConexionMySQL();
        Connection cn=mysql.Conectar();
        
        sSQL="SELECT usu_tipocedula, usu_cedula, usu_nombres, usu_apellidos, usu_id, usu_nivel, usu_status FROM usuario WHERE CONCAT (usu_tipocedula, usu_cedula) LIKE '%"+cedula+"%'";
         try {
             Statement st=cn.createStatement();
             ResultSet rs = st.executeQuery(sSQL); 
             
             while(rs.next()){
                 registro[0]=rs.getString("usu_tipocedula")+rs.getString("usu_cedula");           
                 registro[1]=rs.getString("usu_nombres");
                 registro[2]=rs.getString("usu_apellidos");
                 registro[3]=rs.getString("usu_id");
                 registro[4]=rs.getString("usu_nivel");
                 status=rs.getString("usu_status");
                 if(status.equals("A")){
                     modelo.addRow(registro);
                     NiveldeAcceso entrada= new NiveldeAcceso();
                     Statement stmt=cn.createStatement();
                     int result=stmt.executeUpdate("INSERT INTO bitacora VALUES (null,'"+entrada.nombre_usuario+"', 'Registro y Consulta de Usuario', 'Consulto Usuario CI: "+cedula+" ', now())");
                 }
                 else{
                     JOptionPane.showMessageDialog(null,"El usuario no se encuentra registrado");
                 } 
             }
         }
         catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, ex);
        } 
    }
    
    void CargarTablaPacientePorNombre(String nombre) {
        String[] registro= new String[5];
        String status="",sSQL ="";
        
        ConexionMySQL mysql =new ConexionMySQL();
        Connection cn=mysql.Conectar();
        
        sSQL="SELECT usu_tipocedula, usu_cedula, usu_nombres, usu_apellidos, usu_id, usu_nivel, usu_status FROM usuario WHERE usu_nombres LIKE '%"+nombre+"%'";
         try {
             Statement st=cn.createStatement();
             ResultSet rs = st.executeQuery(sSQL); 
             
             while(rs.next()){
                 registro[0]=rs.getString("usu_tipocedula")+rs.getString("usu_cedula");           
                 registro[1]=rs.getString("usu_nombres");
                 registro[2]=rs.getString("usu_apellidos");
                 registro[3]=rs.getString("usu_id");
                 registro[4]=rs.getString("usu_nivel");
                 status=rs.getString("usu_status");
                 if(status.equals("A")){
                      modelo.addRow(registro);
                      NiveldeAcceso entrada= new NiveldeAcceso();
                      Statement stmt=cn.createStatement();
                      int result=stmt.executeUpdate("INSERT INTO bitacora VALUES (null,'"+entrada.nombre_usuario+"', 'Registro y Consulta de Usuario', 'Consulto Usuario CI: "+registro[0]+" ', now())");
                 }
                 else{
                     JOptionPane.showMessageDialog(null,"No se encuentra registrado ningun usuario con el Nombre introducido");
                 } 
             } 
         }
         catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, ex);
        } 
    }
    
    void CargarTablaPacientePorApellido(String apellido){
        String[] registro= new String[5];
        String status="",sSQL ="";
        
        ConexionMySQL mysql =new ConexionMySQL();
        Connection cn=mysql.Conectar();
        
        sSQL="SELECT usu_tipocedula, usu_cedula, usu_nombres, usu_apellidos, usu_id, usu_nivel, usu_status FROM usuario WHERE usu_apellidos LIKE '%"+apellido+"%'";
         try {
             Statement st=cn.createStatement();
             ResultSet rs = st.executeQuery(sSQL); 
             
             while(rs.next()){
                 registro[0]=rs.getString("usu_tipocedula")+rs.getString("usu_cedula");           
                 registro[1]=rs.getString("usu_nombres");
                 registro[2]=rs.getString("usu_apellidos");
                 registro[3]=rs.getString("usu_id");
                 registro[4]=rs.getString("usu_nivel");
                 status=rs.getString("usu_status");
                 if(status.equals("A")){
                      modelo.addRow(registro);
                      NiveldeAcceso entrada= new NiveldeAcceso();
                      Statement stmt=cn.createStatement();
                      int result=stmt.executeUpdate("INSERT INTO bitacora VALUES (null,'"+entrada.nombre_usuario+"', 'Registro y Consulta de Usuario', 'Consulto Usuario CI: "+registro[0]+" ', now())");
                      
                 }
                 else{
                     JOptionPane.showMessageDialog(null,"No se encuentra registrado ningun usuario con el Apellido introducido");
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
        btnguardar = new javax.swing.JButton();
        btnlimpiar = new javax.swing.JButton();
        btnbuscar = new javax.swing.JButton();
        btnactualizar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cbocedula = new javax.swing.JComboBox();
        txtcedula = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtnombres = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtapellidos = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        passcontraseña = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        passrepitacontraseña = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        cboniveldeacceso = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblusuario = new javax.swing.JTable();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        icon2 = new javax.swing.JLabel();
        icon1 = new javax.swing.JLabel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        icon4 = new javax.swing.JLabel();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        icon6 = new javax.swing.JLabel();
        jLayeredPane4 = new javax.swing.JLayeredPane();
        icon3 = new javax.swing.JLabel();
        jLayeredPane5 = new javax.swing.JLayeredPane();
        icon5 = new javax.swing.JLabel();
        jLayeredPane6 = new javax.swing.JLayeredPane();
        icon7 = new javax.swing.JLabel();
        jLayeredPane7 = new javax.swing.JLayeredPane();
        icon8 = new javax.swing.JLabel();

        mneditar.setText("Modificar");
        jPopupMenu1.add(mneditar);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registro y Consulta de Usuarios");

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        jPanel1.setForeground(new java.awt.Color(0, 204, 204));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnguardar.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/botones/aceptar2.png"))); // NOI18N
        btnguardar.setToolTipText("Guardar");
        btnguardar.setBorderPainted(false);
        btnguardar.setContentAreaFilled(false);
        btnguardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnguardar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/botones/aceptar3.png"))); // NOI18N
        btnguardar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/botones/aceptar1.png"))); // NOI18N
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btnlimpiar.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        btnlimpiar.setText("Limpiar");
        btnlimpiar.setToolTipText("Limpiar");
        btnlimpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnlimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimpiarActionPerformed(evt);
            }
        });

        btnbuscar.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        btnbuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/botones/buscar2.png"))); // NOI18N
        btnbuscar.setToolTipText("Buscar");
        btnbuscar.setBorderPainted(false);
        btnbuscar.setContentAreaFilled(false);
        btnbuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnbuscar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/botones/buscar3.png"))); // NOI18N
        btnbuscar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/botones/buscar1.png"))); // NOI18N
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        btnactualizar.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        btnactualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/botones/actualizar2.png"))); // NOI18N
        btnactualizar.setToolTipText("Actualizar");
        btnactualizar.setBorderPainted(false);
        btnactualizar.setContentAreaFilled(false);
        btnactualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnactualizar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/botones/actualizar3.png"))); // NOI18N
        btnactualizar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/botones/actualizar1.png"))); // NOI18N
        btnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarActionPerformed(evt);
            }
        });

        btneliminar.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/botones/borrar2.png"))); // NOI18N
        btneliminar.setToolTipText("Eliminar");
        btneliminar.setBorderPainted(false);
        btneliminar.setContentAreaFilled(false);
        btneliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btneliminar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/botones/borrar3.png"))); // NOI18N
        btneliminar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/botones/borrar1.png"))); // NOI18N
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        btncancelar.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        btncancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/botones/cancelar2.png"))); // NOI18N
        btncancelar.setToolTipText("Salir");
        btncancelar.setBorderPainted(false);
        btncancelar.setContentAreaFilled(false);
        btncancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btncancelar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/botones/cancelar3.png"))); // NOI18N
        btncancelar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/botones/cancelar1.png"))); // NOI18N
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnlimpiar)
                .addGap(18, 18, 18)
                .addComponent(btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnactualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btncancelar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btneliminar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnactualizar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnbuscar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnlimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel1.setText("Cedula");

        cbocedula.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        cbocedula.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione", "V-", "E-" }));

        txtcedula.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        txtcedula.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtcedulaFocusLost(evt);
            }
        });
        txtcedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcedulaKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel2.setText("Nombres");

        txtnombres.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        txtnombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombresKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel3.setText("Apellidos");

        txtapellidos.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        txtapellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtapellidosKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel4.setText("Id");

        txtid.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        txtid.setToolTipText("Introduzca el id con el desea ingresar al sistema. Ejemplo: mariaP65");

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel5.setText("Contraseña");

        passcontraseña.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        passcontraseña.setToolTipText("Introduzca la contraseña que permitira su comprobación ante el sistema");

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel6.setText("Repita contraseña");

        passrepitacontraseña.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        passrepitacontraseña.setToolTipText("Repita la contraseña que permitira su comprobación ante el sistema");

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel7.setText("Nivel de acceso");

        cboniveldeacceso.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        cboniveldeacceso.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione", "1", "2" }));
        cboniveldeacceso.setToolTipText("Indique el nivel que poseerá el usuario. Ejemplo: 1");
        cboniveldeacceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboniveldeaccesoActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tblusuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblusuario.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(tblusuario);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        icon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Formularios/triangulo.png"))); // NOI18N
        icon2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                icon2MouseEntered(evt);
            }
        });
        icon2.setBounds(0, 0, 23, 30);
        jLayeredPane1.add(icon2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        icon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Formularios/triangulo.png"))); // NOI18N
        icon1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                icon1MouseEntered(evt);
            }
        });
        icon1.setBounds(0, 0, 23, 30);
        jLayeredPane1.add(icon1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        icon4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Formularios/triangulo.png"))); // NOI18N
        icon4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                icon4MouseEntered(evt);
            }
        });
        icon4.setBounds(0, 0, 23, 20);
        jLayeredPane2.add(icon4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        icon6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Formularios/triangulo.png"))); // NOI18N
        icon6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                icon6MouseEntered(evt);
            }
        });
        icon6.setBounds(0, 0, 23, 20);
        jLayeredPane3.add(icon6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        icon3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Formularios/triangulo.png"))); // NOI18N
        icon3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                icon3MouseEntered(evt);
            }
        });
        icon3.setBounds(0, 0, 23, 20);
        jLayeredPane4.add(icon3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        icon5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Formularios/triangulo.png"))); // NOI18N
        icon5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                icon5MouseEntered(evt);
            }
        });
        icon5.setBounds(0, 0, 23, 20);
        jLayeredPane5.add(icon5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        icon7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Formularios/triangulo.png"))); // NOI18N
        icon7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                icon7MouseEntered(evt);
            }
        });
        icon7.setBounds(0, 0, 23, 20);
        jLayeredPane6.add(icon7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        icon8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Formularios/triangulo.png"))); // NOI18N
        icon8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                icon8MouseEntered(evt);
            }
        });
        icon8.setBounds(0, 0, 23, 20);
        jLayeredPane7.add(icon8, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbocedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtcedula, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtapellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtnombres, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLayeredPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLayeredPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 42, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(passcontraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLayeredPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(passrepitacontraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboniveldeacceso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLayeredPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLayeredPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(cbocedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtnombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLayeredPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(jLabel3)
                        .addComponent(txtapellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLayeredPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(passrepitacontraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLayeredPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(passcontraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLayeredPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cboniveldeacceso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLayeredPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboniveldeaccesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboniveldeaccesoActionPerformed
        
    }//GEN-LAST:event_cboniveldeaccesoActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        String ced1="", ced2="",cedula="", cedula2="", nombres="", apellidos="", id="", contrasena1="", contrasena2="", nivel="", sSQL="", sSQL2="", status="A", status2="";
        
        inhabilitariconos();
        ced1=cbocedula.getSelectedItem().toString();
        ced2=txtcedula.getText();
        cedula=ced1+ced2;
        nombres=txtnombres.getText();
        apellidos=txtapellidos.getText();
        id=txtid.getText();
        contrasena1=passcontraseña.getText();
        contrasena2=passrepitacontraseña.getText();
        nivel=cboniveldeacceso.getSelectedItem().toString();
        
        ConexionMySQL mysql = new ConexionMySQL();
        Connection cn = mysql.Conectar();
        
        if(ced1.equals("Seleccione")){
            icon1.setVisible(true);
        }
        else{
            if(ced2.equals("")){
                icon2.setVisible(true);
            }
            else{
                sSQL2="SELECT usu_tipocedula, usu_cedula, usu_status FROM usuario WHERE CONCAT (usu_tipocedula, usu_cedula) LIKE '%"+cedula+"%'";
                try{
                    Statement st=cn.createStatement();
                    ResultSet rs = st.executeQuery(sSQL2);
                    while(rs.next()){
                        cedula2=rs.getString("usu_tipocedula")+rs.getString("usu_cedula");
                        status2=rs.getString("usu_status");
                    }
                    if(cedula.equals(cedula2) && status2.equals("A")){
                        JOptionPane.showMessageDialog(null,"Ya existe un usuario registrado con este numero de cedula");
                    }
                    else{
                        if(nombres.equals("")){
                            icon3.setVisible(true); 
                        }
                        else{
                            if(apellidos.equals("")){
                                icon4.setVisible(true);
                            }
                            else{
                                 if(id.equals("")){
                                     icon5.setVisible(true);
                                 }
                                 else{
                                      if(contrasena1.equals("")){
                                          icon6.setVisible(true);
                                      }
                                      else{
                                          if(contrasena2.equals("")){
                                              icon7.setVisible(true);
                                          }
                                          else{
                                              if(nivel.equals("Seleccione")){
                                                  icon8.setVisible(true);
                                              }
                                              else{
                                                  if(!contrasena1.equals(contrasena2)){
                                                      JOptionPane.showMessageDialog(null,"Los valores de las contraseñas introducidas no coinciden");
                                                  }
                                                  else{
                                                      sSQL="INSERT INTO usuario (usu_tipocedula, usu_cedula, usu_nombres, usu_apellidos, usu_id, usu_contraseña, usu_nivel, usu_status) VALUES (?,?,?,?,?,?,?,?)";
                                                      try {
                                                          PreparedStatement pst = cn.prepareStatement(sSQL);
                                                          pst.setString(1, ced1);
                                                          pst.setString(2, ced2);
                                                          pst.setString(3, nombres);
                                                          pst.setString(4, apellidos);
                                                          pst.setString(5, id);
                                                          pst.setString(6, contrasena1);
                                                          pst.setString(7, nivel);
                                                          pst.setString(8, status);
                     
                                                          int n = pst.executeUpdate();
                                                          if (n > 0) {
                                                          JOptionPane.showMessageDialog(null,"El usuario fue registrado");
                                                          limpiar();
                                                          NiveldeAcceso entrada= new NiveldeAcceso();
                                                          Statement stmt=cn.createStatement();
                                                          int result=stmt.executeUpdate("INSERT INTO bitacora VALUES (null,'"+entrada.nombre_usuario+"', 'Registro y Consulta de Usuario', 'Guardo Usuario CI: "+cedula+" ', now())");
                                                          }
                                                      }
                                                      catch(SQLException ex){
                                                          JOptionPane.showMessageDialog(null,ex);
                                                      }
                                                  }
                                              }
                                          }
                                      }  
                                 }
                            }
                        }
                    }
                }
                catch (SQLException ex){
                    JOptionPane.showMessageDialog(null, ex);
                }  
            }
        }       
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnlimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_btnlimpiarActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        String ced1="",ced2="", cedula="",nombre="",apellido;
        
        inhabilitarcedula();
        
        ced1=cbocedula.getSelectedItem().toString();
        ced2=txtcedula.getText();
        cedula=ced1+ced2;
        nombre=txtnombres.getText();
        apellido=txtapellidos.getText();
        
        if((!ced1.equals("Seleccine"))&&(!ced2.equals(""))&&(nombre.equals(""))&&(apellido.equals(""))){
            CargarTablaPacientePorCedula(cedula);
            }
        else{
            if((ced1.equals("Seleccione"))&&(ced2.equals(""))&&(!nombre.equals(""))&&(apellido.equals(""))){
                CargarTablaPacientePorNombre(nombre);
            }
            else{
                if((ced1.equals("Seleccione"))&&(ced2.equals(""))&&(nombre.equals(""))&&(!apellido.equals(""))){
                    CargarTablaPacientePorApellido(apellido);
                }
                else{
                    JOptionPane.showMessageDialog(null,"El tipo de busqueda que esta intendo realizar no esta permitida");
                }
            }
        }               
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void btnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarActionPerformed
        String ced1="", ced2="", cedula="", nombres="", apellidos="", id="", contrasena1="", contrasena2="", nivel="", sSQL="";
        
        ced1=cbocedula.getSelectedItem().toString();
        ced2=txtcedula.getText();
        cedula=ced1+ced2;
        nombres=txtnombres.getText();
        apellidos=txtapellidos.getText();
        id=txtid.getText();
        contrasena1=passcontraseña.getText();
        contrasena2=passrepitacontraseña.getText();
        nivel=cboniveldeacceso.getSelectedItem().toString();
        
        ConexionMySQL mysql=new ConexionMySQL();
        Connection cn = mysql.Conectar();
        
        sSQL="UPDATE usuario SET usu_nombres='"+nombres+"', usu_apellidos='"+apellidos+"', usu_id='"+id+"', usu_contraseña='"+contrasena1+"', usu_nivel='"+nivel+"' WHERE CONCAT (usu_tipocedula, usu_cedula) = '"+cedula+"'";
        
        try {
            PreparedStatement pst=cn.prepareStatement(sSQL);
            int n=pst.executeUpdate();
            if(n>0){
                 JOptionPane.showMessageDialog(null,"Actualizacion Satisfactoria");
                 limpiar();
                 NiveldeAcceso entrada= new NiveldeAcceso();
                 Statement stmt=cn.createStatement();
                 int result=stmt.executeUpdate("INSERT INTO bitacora VALUES (null,'"+entrada.nombre_usuario+"', 'Registro y Consulta de Usuario', 'Actualizo Usuario CI: "+cedula+" ', now())");
            }      
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex);
        }
    }//GEN-LAST:event_btnactualizarActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btncancelarActionPerformed

    private void txtcedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcedulaKeyTyped
         char caracter = evt.getKeyChar();//Validacion del campo cedula
        if (caracter >= '0' && caracter <= '9' || caracter == 8 || caracter == KeyEvent.VK_BACK_SPACE || caracter == KeyEvent.VK_CAPS_LOCK || caracter == KeyEvent.VK_SHIFT) {
        } 
        else {
            evt.consume();
        }
        if (txtcedula.getText().length() >= 8){
            evt.consume();
            JOptionPane.showMessageDialog(null, "Solo puede ingresar 8 numeros", "Informacion", 1);
        }
    }//GEN-LAST:event_txtcedulaKeyTyped

    private void txtnombresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombresKeyTyped
        char caracter = evt.getKeyChar();//Validacion del campo nombre
        if (caracter >= 'a' && caracter <= 'z' || caracter >= 'A' && caracter <= 'Z' || caracter == 8 || caracter == ' ' || caracter == KeyEvent.VK_BACK_SPACE || caracter == KeyEvent.VK_CAPS_LOCK || caracter == KeyEvent.VK_SHIFT) {
        } 
        else {
            evt.consume();
            JOptionPane.showMessageDialog(null, "En el campo campo Nombres solo prodra ingresar caracteres", "Informacion", 2);
        }
        if (txtnombres.getText().length() >= 25) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Solo se pueden ingresar 25 caracteres", "Informacion", 1);
        }
    }//GEN-LAST:event_txtnombresKeyTyped

    private void txtapellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtapellidosKeyTyped
        char caracter = evt.getKeyChar();//Validacion del campo apellido
        if (caracter >= 'a' && caracter <= 'z' || caracter >= 'A' && caracter <= 'Z' || caracter == 8 || caracter == ' ' || caracter == KeyEvent.VK_BACK_SPACE || caracter == KeyEvent.VK_CAPS_LOCK || caracter == KeyEvent.VK_SHIFT) {
        } 
        else {
            evt.consume();
            JOptionPane.showMessageDialog(null, "En el campo Apellidos solo podra ingresar caracteres", "Informacion", 2);

        }
        if (txtapellidos.getText().length() >= 25) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Solo se pueden ingresar 25 caracteres", "Informacion", 1);

        }
    }//GEN-LAST:event_txtapellidosKeyTyped

    private void icon1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon1MouseEntered
        JOptionPane.showMessageDialog(null,"No selecciono el tipo de cedula", "informacion", 2);
    }//GEN-LAST:event_icon1MouseEntered

    private void icon2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon2MouseEntered
        JOptionPane.showMessageDialog(null,"El campo CEDULA esta vacio", "informacion", 2);
    }//GEN-LAST:event_icon2MouseEntered

    private void icon3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon3MouseEntered
        JOptionPane.showMessageDialog(null,"El campo NOMBRES esta vacio", "informacion", 2);
    }//GEN-LAST:event_icon3MouseEntered

    private void icon4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon4MouseEntered
        JOptionPane.showMessageDialog(null,"El campo APELLIDOS esta vacio", "informacion", 2);
    }//GEN-LAST:event_icon4MouseEntered

    private void icon5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon5MouseEntered
         JOptionPane.showMessageDialog(null,"El campo ID esta vacio", "informacion", 2);
    }//GEN-LAST:event_icon5MouseEntered

    private void icon6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon6MouseEntered
         JOptionPane.showMessageDialog(null,"El campo CONTRASEÑA esta vacio", "informacion", 2);
    }//GEN-LAST:event_icon6MouseEntered

    private void icon7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon7MouseEntered
        JOptionPane.showMessageDialog(null,"El campo  REPITA CONTRASEÑA esta vacio", "informacion", 2);
    }//GEN-LAST:event_icon7MouseEntered

    private void icon8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon8MouseEntered
        JOptionPane.showMessageDialog(null,"No selecciono el NIVEL del paciente", "informacion", 2);
    }//GEN-LAST:event_icon8MouseEntered

    private void txtcedulaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcedulaFocusLost
        if(txtcedula.getText().length() <7){//Validacio  del campo cedula para valores minimos
            JOptionPane.showMessageDialog(null,"Verifique que al campo cedula no le falten valores", "informacion", 1);
        } 
    }//GEN-LAST:event_txtcedulaFocusLost

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
         String sSQL="";
        
        ConexionMySQL mysql =new ConexionMySQL();
        Connection cn=mysql.Conectar();
        
        int j=tblusuario.getSelectedRow();
        if(j==-1) {
        JOptionPane.showMessageDialog(null,"No se han seleccionado filas");
        }
        else{ 
        modelo = (DefaultTableModel) tblusuario.getModel();
        String id = (String) modelo.getValueAt(j,0);
            
        sSQL="UPDATE usuario SET usu_status='I' WHERE CONCAT (usu_tipocedula, usu_cedula)='"+id+"'";
        try {
            PreparedStatement pst=cn.prepareStatement(sSQL);
            int n=pst.executeUpdate();
            if(n>0){
                 JOptionPane.showMessageDialog(null,"Usuario eliminado Satisfactoriamente");
                 NiveldeAcceso entrada= new NiveldeAcceso();
                 Statement stmt=cn.createStatement();
                 int result=stmt.executeUpdate("INSERT INTO bitacora VALUES (null,'"+entrada.nombre_usuario+"', 'Registro y Consulta de Usuario', 'Elimino Usuario CI: "+id+" ', now())");
            }      
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex);
        }
        }
    }//GEN-LAST:event_btneliminarActionPerformed

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
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Usuarios().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnactualizar;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnlimpiar;
    private javax.swing.JComboBox cbocedula;
    private javax.swing.JComboBox cboniveldeacceso;
    private javax.swing.JLabel icon1;
    private javax.swing.JLabel icon2;
    private javax.swing.JLabel icon3;
    private javax.swing.JLabel icon4;
    private javax.swing.JLabel icon5;
    private javax.swing.JLabel icon6;
    private javax.swing.JLabel icon7;
    private javax.swing.JLabel icon8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JLayeredPane jLayeredPane4;
    private javax.swing.JLayeredPane jLayeredPane5;
    private javax.swing.JLayeredPane jLayeredPane6;
    private javax.swing.JLayeredPane jLayeredPane7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem mneditar;
    private javax.swing.JPasswordField passcontraseña;
    private javax.swing.JPasswordField passrepitacontraseña;
    private javax.swing.JTable tblusuario;
    private javax.swing.JTextField txtapellidos;
    private javax.swing.JTextField txtcedula;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtnombres;
    // End of variables declaration//GEN-END:variables
}
