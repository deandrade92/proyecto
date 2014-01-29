package Formularios;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;


public class reporte {

     Connection con;
     
    
    
    public reporte(){
        try {
               Class.forName("com.mysql.jdbc.Driver");       
               con = DriverManager.getConnection("jdbc:mysql://localhost/centroodontologico","root","");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(reporte.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(reporte.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    //EstadoCobranza
      public void estadoCobranza(String cedula_cliente){
        try {
            String master= System.getProperty("user.dir") +
                    "/src/Reportes/cedula.jasper";
           
            System.out.println("master" +master);
            if (master==null){
                System.out.println("No encuentro el archivo del reporte");
                System.exit(2);
                        
            }
                    
            JasperReport masterReport = null;
            try {
            masterReport = (JasperReport) JRLoader.loadObject(master); 
            } catch (Exception e) {
                System.out.println("Error al cargar el reporte AQUIx  "+e.getMessage());
                System.exit(3);
            }
            
            Map parametro = new HashMap();
            parametro.put("cedula_cliente", cedula_cliente);
           
            
            JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport,parametro,con);
            JasperViewer jviewer = new JasperViewer(jasperPrint,false);
            jviewer.setTitle("Estado de Cobranza");
            jviewer.setVisible(true);
        } catch (Exception e) {
            System.out.println("Mensaje de ERROR "+e.getMessage());
        }
    }
      public void retporteDia(String cedula_cliente){
        try {
            String master= "reportediario.jasper";
           
            System.out.println("master" +master);
            if (master==null){
                System.out.println("No encuentro el archivo del reporte");
                System.exit(2);
                        
            }
                    
            JasperReport masterReport = null;
            try {
            masterReport = (JasperReport) JRLoader.loadObject(master); 
            } catch (Exception e) {
                System.out.println("Error al cargar el reporte AQUIx  "+e.getMessage());
                System.exit(3);
            }
            
            Map parametro = new HashMap();
            parametro.put("cedula_cliente", cedula_cliente);
           
            
            JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport,parametro,con);
            JasperViewer jviewer = new JasperViewer(jasperPrint,false);
            jviewer.setTitle("Estado de Cobranza");
            jviewer.setVisible(true);
        } catch (Exception e) {
            System.out.println("Mensaje de ERROR "+e.getMessage());
        }
    }

       
   public void runListadoGeneral(){
        try {
            String master= System.getProperty("user.dir") +
                    "/src/Reportes/listado.jasper";
        
            
            System.out.println("master" +master);
            if (master==null){
                System.out.println("No encuentro el archivo del reporte");
                System.exit(2);
                        
            }
                    
            JasperReport masterReport = null;
            try {
            masterReport = (JasperReport) JRLoader.loadObject(master); 
            } catch (Exception ex) {
                System.out.println("Error al cargar el reporte AQUI   "+ex.getMessage());
                System.exit(3);
            }
            
            Map parametro = new HashMap();
            
            JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport,parametro,con);
            JasperViewer jviewer = new JasperViewer(jasperPrint,false);
            jviewer.setTitle("Listado General de Deudores");
            jviewer.setVisible(true);
        } catch (Exception e) {
            System.out.println("Mensaje de ERROR "+e.getMessage());
        }
        
    }
    
          
}
