package dptoalumnos;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public final class Modelo {
    
    private ArrayList<Alumno> arrayAlumnos ; // array de todos los alumnos. 
    private ResultSet rs;
    private String databaseName = "dptoAlumnos";
    
    public Modelo(){
        arrayAlumnos = new ArrayList<Alumno>();
        rs = null;
        cargaArrayAlumno();
        System.out.println(getAlumnos());
    }
    
    public Connection conexionSQL(String ip , String usr , String psw , String bd){
        Connection db = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            db = DriverManager.getConnection("jdbc:mysql://" + ip + "/" + bd, usr, psw);
        } catch (Exception ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return db;
    }
    
    public Statement statementSQL(Connection db){
        Statement statement = null;
        try {
            statement = db.createStatement();
        } catch (Exception ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return statement;
        
    }
    
    public void executeQuery(String strSql){
        Connection db = conexionSQL("localhost" , "root" , "" , databaseName);
        Statement statement = statementSQL(db);
        try {
            this.rs = statement.executeQuery(strSql);
        } catch (Exception ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if (statement != null) {
                statement.close();
            }
            if (db != null) {
                db.close();
            }
        } catch (Exception ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void executeUpdate(String strSql){
        Connection db = conexionSQL("localhost" , "root" , "" , databaseName);
        Statement statement = statementSQL(db);
        try {
            statement.executeUpdate(strSql);
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            if (statement != null) {
                statement.close();
            }
            if (db != null) {
                db.close();
            }
        } catch (Exception ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void cargaArrayAlumno(){ // cargo en un array todos los registros de la tabla alumno.
        String query = "SELECT * FROM alumnos";
        arrayAlumnos = new ArrayList<Alumno>();
        Connection db = conexionSQL("localhost" , "root" , "" , databaseName);
        Statement statement = statementSQL(db);
        try {
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                Alumno a = new Alumno();
                a.setNroLegajo(rs.getString(1));
                a.setNombre(rs.getString(2));
                a.setApellido(rs.getString(3));
                a.setFechaNacimiento(rs.getString(4));
                a.setNroDoc(rs.getString(5));
                a.setCalle(rs.getString(6));
                a.setNroCalle(rs.getString(7));
                a.setPiso(rs.getString(8)); 
                a.setDepartamento(rs.getString(9)); 
                a.setCodPostal(rs.getString(10));
                a.setLocalidad(rs.getString(11));
                a.setTelFijo(rs.getString(12));
                a.setTelCel(rs.getString(13));
                a.seteMail(rs.getString(14));
                
                arrayAlumnos.add(a);
            }

        } catch (Exception ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            if (statement != null) {
                statement.close();
            }
            if (db != null) {
                db.close();
            }
        } catch (Exception ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getAlumnos(){ // levanto un alumno del array list y genero un string por registro para mostrar los datos.
        String rs = "";
        for(int i = 0 ; i < arrayAlumnos.size() ; i++){
            rs += arrayAlumnos.get(i).getNroLegajo();
            rs += arrayAlumnos.get(i).getNombre();
            rs += arrayAlumnos.get(i).getApellido();
            rs += arrayAlumnos.get(i).getFechaNacimiento();
            rs += arrayAlumnos.get(i).getNroDoc();
            rs += arrayAlumnos.get(i).getCalle();
            rs += arrayAlumnos.get(i).getNroCalle();
            rs += arrayAlumnos.get(i).getPiso();
            rs += arrayAlumnos.get(i).getDepartamento();
            rs += arrayAlumnos.get(i).getCodPostal();
            rs += arrayAlumnos.get(i).getLocalidad();
            rs += arrayAlumnos.get(i).getTelFijo();
            rs += arrayAlumnos.get(i).getTelCel();
            rs += arrayAlumnos.get(i).geteMail();
        }
        return rs;
    }

}