package dptoalumnos;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public final class Modelo {
    
    private ArrayList<Alumno> arrayAlumnos ; // array de todos los alumnos. 
    private ArrayList<Curso> arrayCursos; // array de todos los cursos
    private ArrayList<Pago> arrayPagos; // array de todos los pagos
    private ArrayList<Prestamo> arrayPrestamos; // array de todos los prestamos
    private ResultSet rs;
    private String databaseName;
    
    // ----- CONSTRUCTOR -----
    public Modelo(){
        databaseName = "dptoAlumnos";
        arrayAlumnos = new ArrayList<Alumno>();
        arrayCursos = new ArrayList<Curso>();
        arrayPagos = new ArrayList<Pago>();
        arrayPrestamos = new ArrayList<Prestamo>();
        rs = null;
        cargaArrayAlumno();
        System.out.println(getAlumnos());
    }
    
    // ----- CONEXION BASE DE DATOS -----
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
    
    // ----- LEVANTA DATOS -----
    public void cargaArrayAlumno(){ // cargo en un array todos los registros de la tabla alumno.
        String qry = "SELECT * FROM alumnos";
        try {
            this.executeQuery(qry);
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
            if (this.rs != null) {
                rs.close();
            }
        } catch (Exception ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void cargaArrayCurso(){ // cargo en un array todos los registros de la tabla Cursos.
        String qry = "SELECT * FROM cursos";
        try {
            this.executeQuery(qry);
            while (rs.next()) {
                Curso a = new Curso();
                a.setCursoCod(rs.getString(1));                
                a.setCursoNombre(rs.getString(2));
                a.setCursoProf(rs.getString(3));
              
                arrayCursos.add(a);
            }
        } catch (Exception ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if (this.rs != null) {
                rs.close();
            }
        } catch (Exception ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void cargaArrayPago(){ // cargo en un array todos los registros de la tabla Pagos.
        String qry = "SELECT * FROM pagos";
        try {
            this.executeQuery(qry);
            while (rs.next()) {
                Pago a = new Pago();
                a.setPagoNroLegajo(rs.getString(1));
                a.setPagoCodCurso(rs.getString(2));
                a.setPagoFecha(rs.getString(3));
                a.setPagoImporte(rs.getFloat(4));
                a.setPagoComprobante(rs.getString(5));
              
                arrayPagos.add(a);
            }
        } catch (Exception ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if (this.rs != null) {
                rs.close();
            }
        } catch (Exception ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void cargaArrayPrestamo(){ // cargo en un array todos los registros de la tabla Prestamos.
        String qry = "SELECT * FROM prestamos";
        try {
            this.executeQuery(qry);
            while (rs.next()) {
                Prestamo a = new Prestamo();
                a.setNroLegajo(rs.getString(1));
                a.setCodRecurso(rs.getString(2));
                a.setFechaPrestamo(rs.getString(3));
                a.setFechaDevolucion(rs.getString(4));
                a.setFechaPrevistaDevolucion(rs.getString(5));
                
                arrayPrestamos.add(a);
            }
        } catch (Exception ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if (this.rs != null) {
                rs.close();
            }
        } catch (Exception ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    
    // ----- MUESTRA DATOS -----
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
    
    public String getCursos(){ // levanto un alumno del array list y genero un string por registro para mostrar los datos.
        String rs = "";
        for(int i = 0 ; i < arrayCursos.size() ; i++){
            rs += arrayCursos.get(i).getCursoCod();
            rs += arrayCursos.get(i).getCursoNombre();
            rs += arrayCursos.get(i).getCursoProf();
        }
        return rs;
    }
    
    public String getPagos(){ // levanto un alumno del array list y genero un string por registro para mostrar los datos.
        String rs = "";
        for(int i = 0 ; i < arrayPagos.size() ; i++){
            rs += arrayPagos.get(i).getPagoCodCurso();
            rs += arrayPagos.get(i).getPagoNroLegajo();
            rs += arrayPagos.get(i).getPagoFecha();
            rs += arrayPagos.get(i).getPagoComprobante();
        }
        return rs;
    }
    
    public String getPrestamos(){ // levanto un alumno del array list y genero un string por registro para mostrar los datos.
        String rs = "";
        for(int i = 0 ; i < arrayPagos.size() ; i++){
            rs += arrayPagos.get(i).getPagoCodCurso();
            rs += arrayPagos.get(i).getPagoNroLegajo();
            rs += arrayPagos.get(i).getPagoFecha();
            rs += arrayPagos.get(i).getPagoComprobante();
        }
        return rs;
    }
    
    // ------ CONSULTAS -------
    public void qryAltaAlumno(String nroLegajo , String nombre , String apellido , String fechaNacimiento , String nroDoc , String calle , String nroCalle , String piso , String dpto , String codPostal , String localidad , String telFijo , String telCel , String eMail){
        String qry;
        qry = "INSERT INTO alumnos (nroLegajo , nombre , apellido , fechaNacimiento , nroDoc , calle , nro , piso , depto , codPostal , localidad , telFijo , telCel , eMail) ";
        qry+= "VALUES ("+nroLegajo+",'"+nombre+"','"+apellido+"','"+fechaNacimiento+"','"+nroDoc+"','"+calle+"','"+nroCalle+"','"+piso+"','"+dpto+"','"+codPostal+"','"+localidad+"','"+telFijo+"','"+telCel+"','"+eMail+"');";
        
        executeUpdate(qry);
    }
    
    public void qryAltaCurso(String codCurso , String nombre , String prof){
        String qry; // revisar los campos de la tabla
        qry = "INSERT INTO cursos (codCurso , nombre , prof)";
        qry+= "VALUES ("+ codCurso +" , '"+ nombre +"' , '"+ prof +"');";
        
        executeUpdate(qry);
    }
    
    public void qryAltaRecurso(String codRecurso , String nombre , String anio , String categoria , String autor , String cant){
        String qry; // revisar los campos de la tabla 
        qry = "INSERT INTO recursos (codRec , nombre , anio , categoria , autor , cantidad)";
        qry+= "VALUES ("+codRecurso+" , '"+nombre+"' , '"+anio+"' , '"+categoria+"' , '"+autor+"' , '"+cant+"');";
        
        executeUpdate(qry);
    }   
    
    public void qryAltaPrestamo(String nroLegajo , String codRecurso , String fechaPrestamo , String fechaPrevistaDevolucion , String fechaDevolucion ){
        String qry; // revisar los campos de la tabla 
        qry = "INSERT INTO prestamos (nroLegajo , codRecurso , fechaPres , fechaDevo , fechaPrevDevo) ";
        qry+= "VALUES ("+nroLegajo+" , "+codRecurso+" , '"+fechaPrestamo+"' , '"+fechaDevolucion+"' , '"+fechaPrevistaDevolucion+"');";
        
        executeUpdate(qry);
    }
    
    public void aryAltaPagos(String nroLegajo , String codRecurso , String fecha , String importe , String comprobante){
        String qry; // revisar los campos de la tabla 
        qry = "INSERT INTO prestamo (nroLegajo , codRecurso , fecha , importe , comprobante) ";
        qry+= "VALUES ("+nroLegajo+" , "+codRecurso+" , '"+fecha+"' , "+importe+" , '"+comprobante+"' );";
    }
}