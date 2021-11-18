package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import JFrames.RegistroDocentes;
import Conexion_BD.conexion;
import JFrames.Administrador;
import JFrames.JDocente;
import JFrames.JEstudiante;
import JFrames.Jlogin;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Samir Rojas
 */
public class ControlDatos {
    
    public Connection con;
    
    public ControlDatos() {
        conexion conectar = new conexion();
        con = conectar.conexion();
        docente = new Docente();
        estudiante = new Estudiante();
    }
    
    Docente docente;
    Estudiante estudiante;
    RegistroDocentes admin;
    Connection cn;
    ResultSet rs;
    Statement stmt;
    
    public void InsertDocentes(String NOMBRE, String APELLIDO, int EDAD, String NUMERO_DOCUMENTO, int TIPO_DOCUMENTO,
            int ASIGNATURA) throws SQLException {
        docente.setNombre(NOMBRE);
        docente.setApellido(APELLIDO);
        docente.setEdad(EDAD);
        docente.setTipoDocumento(TIPO_DOCUMENTO);
        docente.setNumeroDocumento(NUMERO_DOCUMENTO);
        docente.setAsignatura(ASIGNATURA);
        
        cn = DriverManager.getConnection("jdbc:mysql://localhost/conchap1", "root", "");
        PreparedStatement pst = cn.prepareStatement("insert  into docentes "
                + "(NOMBRE,APELLIDO,EDAD,NUMERO_DOCUMENTO,TIPO_DOCUMENTO_ID,ID_ASIGNATURA,USUARIO,CONTRASEÑA) "
                + "values  (?,?,?,?,?,?,?,?)");
        
        pst.setString(1, docente.getNombre());
        pst.setString(2, docente.getApellido());
        pst.setInt(3, docente.getEdad());
        pst.setString(4, docente.getNumeroDocumento());
        pst.setInt(5, docente.getTipoDocumento());
        pst.setInt(6, docente.getAsignatura());
        pst.setString(7, Usuario());
        pst.setString(8, Contraseña());
        
        pst.executeUpdate();
        
    }
    
    public void InsertEstudiantes(String NOMBRE, String APELLIDO, String NUMERO_DOCUMENTO) {
        try {
            estudiante.setNombre(NOMBRE);
            estudiante.setApellido(APELLIDO);
            estudiante.setNumeroDocumento(NUMERO_DOCUMENTO);
            cn = DriverManager.getConnection("jdbc:mysql://localhost/conchap1", "root", "");
            PreparedStatement pst = cn.prepareStatement("insert  into estudiantes "
                    + "(NOMBRE,APELLIDO,NUMERO_DOCUMENTO_ID,USUARIO,CONTRASEÑA) "
                    + "values  (?,?,?,?,?)");
            pst.setString(1, NOMBRE);
            pst.setString(2, APELLIDO);
            pst.setString(3, NUMERO_DOCUMENTO);
            pst.setString(4, UsuarioEs());
            pst.setString(5, ContraseñaEs());
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ControlDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     * MUESTRA LOS DOCENTES DE CADA ASIGNATURA PARA LOS ESTUDIANTESS
     *
     * @param modelo
     * @throws SQLException
     */
    public void ListaDocentes(DefaultTableModel modelo) throws SQLException {
        String[] Registros = new String[5];
        modelo.setRowCount(0);
        cn = DriverManager.getConnection("jdbc:mysql://localhost/conchap1", "root", "");
        PreparedStatement pst = cn.prepareStatement("SELECT docentes.NOMBRE,docentes.APELLIDO,"
                + "asignaturas.NOMBRE_ASIGNATURA FROM\n"
                + "docentes,asignaturas WHERE docentes.ID_ASIGNATURA = asignaturas.ID");
        rs = pst.executeQuery();
        while (rs.next()) {
            Registros[0] = rs.getString("NOMBRE");
            Registros[1] = rs.getString("APELLIDO");
            Registros[2] = rs.getString("NOMBRE_ASIGNATURA");
            modelo.addRow(Registros);
        }
    }

    /**
     * INSERTA NOTAS A ESTUDIANTES
     *
     * @param modelo
     * @param ID
     * @param ID_ASIGNATURA
     * @param NOTA_1
     * @param NOTA_2
     * @param NOTA_3
     * @param NOTA_FINAL
     */
    public void InsertNotas(DefaultTableModel modelo, String ID, int ID_ASIGNATURA, double NOTA_1, double NOTA_2,
            double NOTA_3, double NOTA_FINAL) {
        
        try {
            cn = DriverManager.getConnection("jdbc:mysql://localhost/conchap1", "root", "");
            PreparedStatement pst = cn.prepareStatement("INSERT into notas (notas.NOTA_1,"
                    + "notas.NOTA_2,notas.NOTA_3,notas.NOTA_FINAL,notas.ID_ESTUDIANTE,notas.ID_ASIGNATURA) VALUES\n"
                    + "(?,?,?,?,?,?)");
            
            pst.setDouble(1, NOTA_1);
            pst.setDouble(2, NOTA_2);
            pst.setDouble(3, NOTA_3);
            pst.setDouble(4, NOTA_FINAL);
            pst.setString(5, ID);
            pst.setInt(6, ID_ASIGNATURA);
            
            pst.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(ControlDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     * INSERTAR NOTAS PARA LOS ESTUDIANTES
     *
     * @param modelo
     *
     */
    public void Estudiantes_Notas(DefaultTableModel modelo) {
        try {
            String[] Registros = new String[8];
            modelo.setRowCount(0);
            cn = DriverManager.getConnection("jdbc:mysql://localhost/conchap1", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT estudiantes.NOMBRE,estudiantes.APELLIDO,"
                    + "estudiantes.NUMERO_DOCUMENTO_ID,asignaturas.NOMBRE_ASIGNATURA,\n"
                    + "notas.NOTA_1,notas.NOTA_2,notas.NOTA_3,notas.NOTA_FINAL from notas,asignaturas,estudiantes WHERE\n"
                    + "estudiantes.NUMERO_DOCUMENTO_ID = notas.ID_ESTUDIANTE and asignaturas.ID = notas.ID_ASIGNATURA");
            
            rs = pst.executeQuery();
            if (rs.next()) {
                Registros[0] = rs.getString("NOMBRE");
                Registros[1] = rs.getString("APELLIDO");
                Registros[2] = rs.getString("NUMERO_DOCUMENTO_ID");
                Registros[3] = rs.getString("NOMBRE_ASIGNATURA");
                Registros[4] = rs.getString("NOTA_1");
                Registros[5] = rs.getString("NOTA_2");
                Registros[6] = rs.getString("NOTA_3");
                Registros[7] = rs.getString("NOTA_FINAL");
                modelo.addRow(Registros);
            } else {
                JOptionPane.showMessageDialog(null, "NO EXISTE ESTUDIANTE CON ESE ID");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControlDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * MUESTRA LAS NOTAS A LOS ESTUDIANTES
     *
     * @param modelo
     * @param ID
     */
    public void Estudiantes_Notas(DefaultTableModel modelo, String ID) {
        try {
            String[] Registros = new String[8];
            modelo.setRowCount(0);
            cn = DriverManager.getConnection("jdbc:mysql://localhost/conchap1", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT estudiantes.NOMBRE,estudiantes.APELLIDO,estudiantes.NUMERO_DOCUMENTO_ID,asignaturas.NOMBRE_ASIGNATURA,\n"
                    + "notas.NOTA_1,notas.NOTA_2,notas.NOTA_3,notas.NOTA_FINAL from notas,asignaturas,estudiantes WHERE\n"
                    + "estudiantes.NUMERO_DOCUMENTO_ID = notas.ID_ESTUDIANTE and asignaturas.ID = notas.ID_ASIGNATURA AND notas.ID_ESTUDIANTE = '" + ID + "'");
            rs = pst.executeQuery();
            if (rs.next()) {
                Registros[0] = rs.getString("NOMBRE");
                Registros[1] = rs.getString("APELLIDO");
                Registros[2] = rs.getString("NUMERO_DOCUMENTO_ID");
                Registros[3] = rs.getString("NOMBRE_ASIGNATURA");
                Registros[4] = rs.getString("NOTA_1");
                Registros[5] = rs.getString("NOTA_2");
                Registros[6] = rs.getString("NOTA_3");
                Registros[7] = rs.getString("NOTA_FINAL");
                modelo.addRow(Registros);
            }else{
                JOptionPane.showMessageDialog(null,"NO HAY NOTAS INGRESADAS O ID INCORRECTO/INEXISTENTE");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControlDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void CargarNotas_Estudiantes(DefaultTableModel modelo) throws SQLException {
        String[] Registros = new String[8];
        modelo.setRowCount(0);
        cn = DriverManager.getConnection("jdbc:mysql://localhost/conchap1", "root", "");
        PreparedStatement pst = cn.prepareStatement("SELECT asignaturas.NOMBRE_ASIGNATURA,"
                + "notas.NOTA_1,notas.NOTA_2,notas.NOTA_3,notas.NOTA_FINAL "
                + "FROM estudiantes,asignaturas,notas "
                + "WHERE estudiantes.ID_NOTAS = notas.ID "
                + "and estudiantes.NUMERO_DOCUMENTO_ID = '1002130138'");
        
        rs = pst.executeQuery();
        while (rs.next()) {
            
            Registros[0] = rs.getString("NOMBRE_ASIGNATURA");
            Registros[1] = rs.getString("NOTA_1");
            Registros[2] = rs.getString("NOTA_2");
            Registros[3] = rs.getString("NOTA_3");
            Registros[4] = rs.getString("NOTA_FINAL");
            modelo.addRow(Registros);
        }
    }
    
    public String Contraseña() {
        String password;
        password = docente.getNombre().substring(0, 1) + docente.getApellido().substring(0, 1)
                + docente.getNumeroDocumento().substring(4, docente.getNumeroDocumento().length() - 1);
        return password;
        
    }
    
    public String Usuario() {
        String Usuario;
        Usuario = docente.getNombre().substring(0, 3) + docente.getApellido().substring(0, 3)
                + docente.getNumeroDocumento().substring(0, 3);
        return Usuario;
    }
    
    public String ContraseñaEs() {
        String password;
        password = estudiante.getNombre().substring(0, 1) + estudiante.getApellido().substring(0, 1)
                + estudiante.getNumeroDocumento().substring(0, 3);
        return password;
        
    }
    
    public String UsuarioEs() {
        String Usuario;
        Usuario = estudiante.getNombre().substring(0, 3) + estudiante.getApellido().substring(0, 3)
                + estudiante.getNumeroDocumento().substring(0, 3);
        return Usuario;
    }
    
    public void loginDoc(String Usuario, String pass) {
        try {
            cn = DriverManager.getConnection("jdbc:mysql://localhost/conchap1", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT docentes.USUARIO, docentes.`CONTRASEÑA`\n"
                    + "FROM docentes where '" + Usuario + "'= docentes.USUARIO   and '" + pass + "'=docentes.`CONTRASEÑA`");
            rs = pst.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "BIENVENIDO");
                
                new JDocente().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "usuario o contraseña incorrecta");
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControlDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void loginEst(String Usuario, String pass) {
        try {
            cn = DriverManager.getConnection("jdbc:mysql://localhost/conchap1", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT estudiantes.USUARIO, estudiantes.`CONTRASEÑA` "
                    + "FROM estudiantes WHERE estudiantes.USUARIO = '" + Usuario + "' and  estudiantes.`CONTRASEÑA` = '" + pass + "'");
            rs = pst.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "BIENVENIDO");
                
                new JEstudiante().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "usuario o contraseña incorrecta");
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControlDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void LoginAdmin(String Usuario, String pass) {
        
        if (Usuario.equals("Admin") && pass.equals("0000")) {
            JOptionPane.showMessageDialog(null, "BIENVENIDO");
            
            new Administrador().setVisible(true);
            
        } else {
            if (!Usuario.equals("Admin") && !pass.equals("0000")) {
                JOptionPane.showMessageDialog(null, "usuario o contraseña incorrecta");
            }
            
        }
    }
}
