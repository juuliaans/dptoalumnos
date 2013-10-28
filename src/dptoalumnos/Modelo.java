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
    private ArrayList<Recurso> arrayRecursos; // arrayde todos los recursos
    private ArrayList<Asistencia> arrayAsistencias; // array de todos las asistencias
    private int posAlumnos; // posición actual del array de registro 
    private int posCursos; // posición actual del array de registro 
    private int posPagos; // posición actual del array de registro 
    private int posPrestamos; // posición actual del array de registro 
    private int posRecursos; // posición actual del array de recurso 
    private int posAsistencias;
    private Connection db;
    private Statement statement;
    private String databaseName;
    
    // ----- CONSTRUCTOR -----
    public Modelo(){
        databaseName = "dptoAlumnos";
        arrayAlumnos = new ArrayList<Alumno>();
        arrayCursos = new ArrayList<Curso>();
        arrayPagos = new ArrayList<Pago>();
        arrayPrestamos = new ArrayList<Prestamo>();
        arrayRecursos = new ArrayList<Recurso>();
        arrayAsistencias = new ArrayList<Asistencia>();
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
    
    private void openDBConnection(){
        db = conexionSQL("localhost" , "root" , "" , databaseName);
        statement = statementSQL(db);
    }
    
    private void closeDBConnection(){
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
    
    public ResultSet executeQuery(String strSql){
        try {
            return statement.executeQuery(strSql);
        } catch (Exception ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public int executeUpdate(String strSql){
        try {
            return statement.executeUpdate(strSql);
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    // ----- LEVANTA DATOS -----
    public void cargaArrayAlumno(){ // cargo en un array todos los registros de la tabla alumno.
        String qry = "SELECT * FROM alumnos";
        ResultSet rs = null;
        this.arrayAlumnos.clear(); // borro el array para despues cargarlo denuevo . 
        this.openDBConnection();
        try {
            rs = this.executeQuery(qry);
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
            if (rs != null) {
                rs.close();
            }
        } catch (Exception ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.closeDBConnection();
    }

    public void cargaArrayCurso(){ // cargo en un array todos los registros de la tabla Cursos.
        String qry = "SELECT * FROM cursos";
        ResultSet rs = null;
        this.arrayCursos.clear(); // borro el array para despues cargarlo denuevo . 
        this.openDBConnection();
        try {
            rs = this.executeQuery(qry);
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
            if (rs != null) {
                rs.close();
            }
        } catch (Exception ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.closeDBConnection();
    }
    
    public void cargaArrayPago(){ // cargo en un array todos los registros de la tabla Pagos.
        String qry = "SELECT * FROM pagos";
        ResultSet rs = null;
        this.arrayPagos.clear(); // borro el array para despues cargarlo denuevo . 
        this.openDBConnection();
        try {
            rs = this.executeQuery(qry);
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
            if (rs != null) {
                rs.close();
            }
        } catch (Exception ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.closeDBConnection();
    }
    
    public void cargaArrayPrestamo(){ // cargo en un array todos los registros de la tabla Prestamos.
        String qry = "SELECT * FROM prestamos";
        ResultSet rs = null;
        this.arrayPrestamos.clear(); // borro el array para despues cargarlo denuevo . 
        this.openDBConnection();
        try {
            rs = this.executeQuery(qry);
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
            if (rs != null) {
                rs.close();
            }
        } catch (Exception ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.closeDBConnection();
    }

    public void cargaArrayAsistencia(String codCurso , Integer nroClase , int mode){ // cargo en un array los datos requeridos de la tabla Asistencia.
        // mode = 0 -> Levanta una sola fecha para volcar en los inputs
        // mode = 1 -> Levanta todas las fechas para realizar el informe de asistencias
        String qry;
        if(mode == 0){
            qry = "SELECT * FROM asistencia WHERE codCurso = '"+codCurso+"' and nroClase = "+Integer.toString(nroClase)+" ORDER BY nroLegajo;";    
        }else{
            qry = "SELECT * FROM asistencia WHERE codCurso = '"+codCurso+"' ORDER BY nroLegajo , nroClase;";
        }
        ResultSet rs = null;
        this.arrayAsistencias.clear(); // borro el array para despues cargarlo denuevo . 
        this.openDBConnection();
        try {
            rs = this.executeQuery(qry);
            while (rs.next()) {
                Asistencia a = new Asistencia();
                a.setNroLegajo(rs.getString(1));
                a.setCodCurso(rs.getString(2));
                a.setNroClase(rs.getInt(3));
                a.setAsistencia(rs.getInt(4));
                
                arrayAsistencias.add(a);
            }
        } catch (Exception ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (Exception ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.closeDBConnection();
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
            rs += arrayAlumnos.get(i).geteMail() + "\n";
        }
        return rs;
    }
    
    public String getCursos(){ // levanto un alumno del array list y genero un string por registro para mostrar los datos.
        String rs = "";
        for(int i = 0 ; i < arrayCursos.size() ; i++){
            rs += arrayCursos.get(i).getCursoCod();
            rs += arrayCursos.get(i).getCursoNombre();
            rs += arrayCursos.get(i).getCursoProf() + "\n";
        }
        return rs;
    }
    
    public String getPagos(){ // levanto un alumno del array list y genero un string por registro para mostrar los datos.
        String rs = "";
        for(int i = 0 ; i < arrayPagos.size() ; i++){
            rs += arrayPagos.get(i).getPagoCodCurso();
            rs += arrayPagos.get(i).getPagoNroLegajo();
            rs += arrayPagos.get(i).getPagoFecha();
            rs += arrayPagos.get(i).getPagoComprobante() + "\n";
        }
        return rs;
    }
    
    public String getPrestamos(){ // levanto un alumno del array list y genero un string por registro para mostrar los datos.
        String rs = "";
        for(int i = 0 ; i < arrayPagos.size() ; i++){
            rs += arrayPagos.get(i).getPagoCodCurso();
            rs += arrayPagos.get(i).getPagoNroLegajo();
            rs += arrayPagos.get(i).getPagoFecha();
            rs += arrayPagos.get(i).getPagoComprobante() + "\n";
        }
        return rs;
    }
    
    public String getAsistencias(){ // levanto un alumno del array list y genero un string por registro para mostrar los datos.
        String rs = "";
        for(int i = 0 ; i < arrayAsistencias.size() ; i++){
            rs += arrayAsistencias.get(i).getNroLegajo();
            rs += arrayAsistencias.get(i).getCodCurso();
            rs += arrayAsistencias.get(i).getNroClase();
            rs += arrayAsistencias.get(i).getAsistencia() + "\n";
        }
        return rs;
    }
    
    // ------ CONSULTAS -------
    public void qryAltaAlumno(String nroLegajo , String nombre , String apellido , String fechaNacimiento , String nroDoc , String calle , String nroCalle , String piso , String dpto , String codPostal , String localidad , String telFijo , String telCel , String eMail){
        String qry;
        qry = "INSERT INTO alumnos (nroLegajo , nombre , apellido , fechaNacimiento , nroDoc , calle , nro , piso , depto , codPostal , localidad , telFijo , telCel , eMail) ";
        qry+= "VALUES ("+nroLegajo+",'"+nombre+"','"+apellido+"','"+fechaNacimiento+"','"+nroDoc+"','"+calle+"','"+nroCalle+"','"+piso+"','"+dpto+"','"+codPostal+"','"+localidad+"','"+telFijo+"','"+telCel+"','"+eMail+"');";
        
        openDBConnection();
        executeUpdate(qry);
        closeDBConnection();
    }
    
    public void qryAltaCurso(String codCurso , String nombre , String prof){
        String qry; // revisar los campos de la tabla
        qry = "INSERT INTO cursos (codCurso , nombre , prof)";
        qry+= "VALUES ("+ codCurso +" , '"+ nombre +"' , '"+ prof +"');";
        
        openDBConnection();
        executeUpdate(qry);
        closeDBConnection();
    }
    
    public void qryAltaRecurso(String codRecurso , String nombre , String anio , String categoria , String autor , String cant){
        String qry; // revisar los campos de la tabla 
        qry = "INSERT INTO recursos (codRec , nombre , anio , categoria , autor , cant)";
        qry+= "VALUES ("+codRecurso+" , '"+nombre+"' , '"+anio+"' , '"+categoria+"' , '"+autor+"' , '"+cant+"');";
        
        openDBConnection();
        executeUpdate(qry);
        closeDBConnection();
    }   
    
    public void qryAltaPagos(String nroLegajo , String codCurso , String fecha , String importe , String comprobante){
        String qry; // revisar los campos de la tabla 
        qry = "INSERT INTO pagos (nroLegajo , codCurso , fecha , importe , comprobante) ";
        qry+= "VALUES ("+nroLegajo+" , "+codCurso+" , '"+fecha+"' , "+importe+" , '"+comprobante+"' );";
        
        openDBConnection();
        executeUpdate(qry);
        closeDBConnection();
    }
    
    public void qryAltaPrestamo(String nroLegajo , String codRecurso , String fechaPrestamo , String fechaPrevistaDevolucion , String fechaDevolucion ){
        String qry; // revisar los campos de la tabla 
        qry = "INSERT INTO prestamos (nroLegajo , codRecurso , fechaPres , fechaDevo , fechaPrevDevo) ";
        qry+= "VALUES ("+nroLegajo+" , "+codRecurso+" , '"+fechaPrestamo+"' , '"+fechaDevolucion+"' , '"+fechaPrevistaDevolucion+"');";
        
        openDBConnection();
        executeUpdate(qry);
        closeDBConnection();
    }
    
    public void aryAltaPagos(String nroLegajo , String codRecurso , String fecha , String importe , String comprobante){
        String qry; // revisar los campos de la tabla 
        qry = "INSERT INTO prestamo (nroLegajo , codRecurso , fecha , importe , comprobante) ";
        qry+= "VALUES ("+nroLegajo+" , "+codRecurso+" , '"+fecha+"' , "+importe+" , '"+comprobante+"' );";
    }
    
    // ----- Getters -----
      // Levanta objetos de array
    public Alumno getAlumno(int i) { 
        return arrayAlumnos.get(i);
    }
    
    public Prestamo getPrestamo(int i) { 
        return arrayPrestamos.get(i);
    }
    
    public Recurso getRecurso(int i) { 
        return arrayRecursos.get(i);
    }
    
    public Curso getCurso(int i) { 
        return arrayCursos.get(i);
    }
    
    public Pago getPago(int i) { 
        return arrayPagos.get(i);
    }
      // Devuelve tamaño de array 
    public int getCantAlumnos() {
        return arrayAlumnos.size();
    }
    
    public int getCantPrestamos() {
        return arrayPrestamos.size();
    }
    
    public int getCantRecursos() {
        return arrayRecursos.size();
    }
    
    public int getCantCursos() {
        return arrayCursos.size();
    }
    
    public int getCantPagos() {
        return arrayPagos.size();
    }
    
    public int getCantAsistencias(){
        return arrayAsistencias.size();
    }
    
      // Devuelve posicion actual del array de registros 
    public int getPosAlumnos() {
        return posAlumnos;
    }

    public int getPosCursos() {
        return posCursos;
    }

    public int getPosPagos() {
        return posPagos;
    }

    public int getPosPrestamos() {
        return posPrestamos;
    }

    public int getPosRecursos() {
        return posRecursos;
    }
    
    public int getPosAsistencias(){
        return posAsistencias;
    }
    
    
    
    
    // ----- Setters -----
      // Setea posición actual del array de registros 
    public void setPosAlumnos(int posAlumnos) {
        this.posAlumnos = posAlumnos;
    }
    
    public void setPosPrestamos(int posPrestamos) {
        this.posPrestamos = posPrestamos;
    }
    
    public void setPosRecursos(int posRecursos) {
        this.posRecursos = posRecursos;
    }
    
    public void setPosCursos(int posCursos) {
        this.posCursos = posCursos;
    }
    
    public void setPosPagos(int posPagos) {
        this.posPagos = posPagos;
    }
    
    public void setPosAsistencias(int posAsistencias){
        this.posAsistencias = posAsistencias;
    }
    
}