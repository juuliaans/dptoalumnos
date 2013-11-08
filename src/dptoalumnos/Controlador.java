package dptoalumnos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.sql.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Controlador {

    private Modelo m;
    private Vista v;

    public Controlador(Modelo m, Vista v) {
        this.m = m;
        this.v = v;
    }
    
    public void comenzar(){
        v.iniciarVentanaPrincipal();
        addFunciones();
        m.cargaArrayAlumno(null , null , null , null);
        m.cargaArrayCurso();
        m.cargaArrayPago();
        m.cargaArrayPrestamo();
        m.cargaArrayRecurso();
    }
    
    public void addFunciones(){
        v.addEventsToMenu(
                new ActionListener[]{
                    new menuItem_altaAlumno(), 
                    new menuItem_bajaAlumno(), 
                    new menuItem_modificacionAlumno(), 
                        
                    new menuItem_altaCursos(), 
                    new menuItem_bajaCursos(), 
                    new menuItem_modificacionCursos(),
                    new menuItem_altaAsistencias(), 
                    new menuItem_modificacionAsistencias(), 
                    
                    new menuItem_altaPagos(), 
                    new menuItem_bajaPagos(), 
                    new menuItem_modificacionPagos(), 
                    
                    new menuItem_altaPrestamos(), 
                    new menuItem_bajaPrestamos(), 
                    new menuItem_modificacionPrestamos(), 
                    
                    new menuItem_altaRecursos(), 
                    new menuItem_bajaRecursos(), 
                    new menuItem_modificacionRecursos(), 
                    new funcionGenerarListado1(), 
                    new funcionGenerarListado2(), 
                    new funcionGenerarListado3(), 
                    new funcionGenerarListado4(), 
                    new menuItem_consultaAlumno()
                }
                );
        v.addCloseEventToMenuItem(new menuItem_close());
    }
    
    private class menuItem_close implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            System.exit(0);
        }
    }
    
    private class menuItem_altaAlumno implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            v.mostrarPantalla("ALTA_ALUMNO");
            v.addActionListenerAltaAlumnoSend(new funcionSendAltaAlumno());
        }
    }
    
    private class menuItem_bajaAlumno implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            v.mostrarPantalla("BAJA_ALUMNO");
        }
    }
    
    private class menuItem_modificacionAlumno implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            v.mostrarPantalla("MODIFICACION_ALUMNO");
            
            m.cargaArrayAlumno(null , null , null , null);
            if (m.getCantAlumnos() > 0){
            v.cargaInputsAlumno(m.getAlumno(m.getPosAlumnos()));
            v.addActionListenersModificarAlumno(new funcionUpdateAlumno(),new RetrocederAlumnoHandler(), new AvanzarAlumnoHandler(), new funcionBuscarAlumno());
            }else{
                v.showErrorMsg("No hay Alumnos cargados en el sistema. Dirigase a la pantalla de alta de Alumnos para cargar alumnos en el sistema.");
            }
        }
    }
    
    private class menuItem_consultaAlumno implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            v.mostrarPantalla("CONSULTA_ALUMNO");
            
            
            v.addActionListenerConsultaAlumno(new funcionBuscarAlumno());
            
        }
    }
    
    private class menuItem_altaCursos implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            v.mostrarPantalla("ALTA_CURSOS");
            v.addActionListenerAltaCursoSend(new funcionSendAltaCurso());
        }
    }
    
    private class menuItem_bajaCursos implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            v.mostrarPantalla("BAJA_CURSOS");
        }
    }
    
    private class menuItem_modificacionCursos implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            v.mostrarPantalla("MODIFICACION_CURSOS");
            
            if (m.getCantCursos() > 0){
                v.cargaInputsCurso(m.getCurso(m.getPosCursos()));
                v.addActionListenersModificarCurso(
                        new funcionUpdateCurso()
                        ,new RetrocederCursoHandler()
                        , new AvanzarCursoHandler()
                        , new funcionEliminarCurso()
                        , new agregarAlumnoACurso()
                );
            }else{
                v.showErrorMsg("No hay cursos cargados en el sistema. Dirigase a la pantalla de alta de Cursos para cargar cursos en el sistema.");
            }
        }
    }
    
    private class menuItem_altaAsistencias implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            v.mostrarPantalla("ALTA_ASISTENCIAS");
            v.addActionListenerAsistencias(new funcionCargarAsistencias(), new funcionSendAltaAsistencia());
            //v.cargaInputsAsistencia(m.getArrayAsistencias());
            
        }
    }
    
    private class menuItem_modificacionAsistencias implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            v.mostrarPantalla("MODIFICACION_ASISTENCIAS");
            
        }
    }
    
    private class menuItem_altaPagos implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            v.mostrarPantalla("ALTA_PAGOS");
            v.addActionListenerAltaPagoSend(new funcionSendAltaPago());
        }
    }
    
    private class menuItem_bajaPagos implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            v.mostrarPantalla("BAJA_PAGOS");
        }
    }
    
    private class menuItem_modificacionPagos implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            v.mostrarPantalla("MODIFICACION_PAGOS");
            
            if (m.getCantPagos() > 0){
            v.cargaInputsPago(m.getPago(m.getPosPagos()));
            v.addActionListenersModificarPago(new funcionUpdatePago(),new RetrocederPagoHandler(), new AvanzarPagoHandler(), new funcionEliminarPago());
            }else{
                v.showErrorMsg("No hay pagos cargados en el sistema. Dirigase a la pantalla de alta de pagos para insertar pagos en el sistema.");
            }
        }
    }
    
    private class menuItem_altaPrestamos implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            v.mostrarPantalla("ALTA_PRESTAMOS");
            v.addActionListenerAltaPrestamoSend(new funcionSendAltaPrestamo());
        }
    }
    
    private class menuItem_bajaPrestamos implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            v.mostrarPantalla("BAJA_PRESTAMOS");
        }
    }
    
    private class menuItem_modificacionPrestamos implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            v.mostrarPantalla("MODIFICACION_PRESTAMOS");
            
            if (m.getCantPrestamos() > 0){
            v.cargaInputsPrestamo(m.getPrestamo(m.getPosPrestamos()));
            v.addActionListenersModificarPrestamo(new funcionUpdatePrestamo(),new RetrocederPrestamoHandler(), new AvanzarPrestamoHandler());
            }else{
                v.showErrorMsg("No hay prestamos cargados en el sistema. Dirigase a la pantalla de alta para insertar nuevos prestamos");
            }
        }
    }
    
    private class menuItem_altaRecursos implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            v.mostrarPantalla("ALTA_RECURSOS");
            v.addActionListenerAltaRecursoSend(new funcionSendAltaRecurso());
        }
    }
    
    private class menuItem_bajaRecursos implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            v.mostrarPantalla("BAJA_RECURSOS");
        }
    }
    
    private class menuItem_modificacionRecursos implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            v.mostrarPantalla("MODIFICACION_RECURSOS");
            
            if (m.getCantRecursos() > 0){
            v.cargaInputsRecurso(m.getRecurso(m.getPosRecursos()));
            v.addActionListenersModificarRecurso(new funcionUpdateRecurso(),new RetrocederRecursoHandler(), new AvanzarRecursoHandler());
            }else{
                v.showErrorMsg("No hay recursos cargados en el sistema. Dirigase a la pantalla de alta para ingresar nuevos recursos.");
            }
        }
    }
    
    // ----- funciones de validacion -----
    public static boolean isNumeric(String str){
        for (char c : str.toCharArray())
        {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }
    
    public boolean isAlpha(String name) {
        //return name.matches("[a-zA-Z ]+");
        return name.matches("[a-zA-Zäáàëéèíìöóòúùñç  .]+");
    }
    
    public boolean validateDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            sdf.parse(date);
            return true;
        }
        catch(ParseException ex) {
            return false;
    }
}



    // ----- Levanta datos form , envía a armado de Query -----
    
    
    
    private class funcionSendAltaAlumno implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
            int q = insertarModificarAlumno("INSERT");
            if (q == 1){
                v.showSuccessMsg("El alumno ha sido agregado.");
                v.cargaInputsAlumno(new Alumno());
            }
            else if (q == 0) v.showErrorMsg("Algo ha fallado en la base de datos");

            m.cargaArrayAlumno(null , null , null , null );
        }
        
    }
    
    private class funcionUpdateAlumno implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
            int q = insertarModificarAlumno("UPDATE");
            if (q == 1){
                v.showSuccessMsg("El alumno ha sido modificado.");
                int pos = m.getPosAlumnos();
                m.cargaArrayAlumno(null , null , null , null);
                m.setPosAlumnos(pos);
                v.cargaInputsAlumno(m.getAlumno(pos));
            }
            else if (q == 0) v.showErrorMsg("Algo ha fallado en la base de datos");

            
        }
        
    }
    
    private class funcionBuscarAlumno implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
            String nroLegajo = v.getTxtFldAlumnoBusqueda();
            
            m.cargaArrayAlumno(nroLegajo , null , null , null);
            v.cargaInputsAlumno(m.getAlumno(0));

            
        }
        
    }
    
    private int insertarModificarAlumno(String modo){
            Alumno alumno = new Alumno();
            Boolean validacion = true;
            
            String nroLegajo = v.getTxtFldAlumnoNroLegajo();
            String nombre = v.getTxtFldAlumnoNombre();
            String apellido = v.getTxtFldAlumnoApellido();
            String fechaNacimiento = v.getTxtFldAlumnoFechaNacimiento();
            String nroDoc = v.getTxtFldAlumnoNroDoc();  
            String calle = v.getTxtFldAlumnoCalle();
            String nroCalle = v.getTxtFldAlumnoNro();
            String piso = v.getTxtFldAlumnoPiso();
            String dpto = v.getTxtFldAlumnoDepartamento();
            String codPostal = v.getTxtFldAlumnoCodPostal();
            String localidad = v.getTxtFldAlumnoLocalidad();
            String telFijo = v.getTxtFldAlumnoTelFijo();
            String telCel = v.getTxtFldAlumnoTelCel();
            String eMail = v.getTxtFldAlumnoMail();
            
            // ----- VALIDACION ------. 
            if(nroLegajo.isEmpty()){ 
                validacion = false;
                v.showErrorMsg("Nro. Legajo : Campo Vacío.");
            }else{
                if(nroLegajo.length() > 10){
                    validacion = false;
                    v.showErrorMsg("Nro Legajo : Cant de dígitos necesarios = 4");
                }else{
                    if(!isNumeric(nroLegajo)){
                        validacion = false;
                        v.showErrorMsg("Nro Legajo : Inserte solo dígitos numéricos.");
                    }
                }
            }
            if(nombre.isEmpty()){ 
                validacion = false;
                v.showErrorMsg("Nombre : Campo Vacío.");
            }else{
                if(nombre.length()> 50){
                    validacion = false;
                    v.showErrorMsg("Nombre : Máxima cant de dígitos = 50.");
                }else{
                    if(!isAlpha(nombre)){
                        validacion = false;
                        v.showErrorMsg("Nombre : Ingrese solo letras.");
                    }
                }
            }
            if(apellido.isEmpty()){ 
                validacion = false;
                v.showErrorMsg("Apellido : Campo Vacío.");
            }else{
                if(apellido.length()> 50){
                    validacion = false;
                    v.showErrorMsg("Apellido : Máxima cant de dígitos = 50");
                }else{
                    if(!isAlpha(apellido)){
                        validacion = false;
                        v.showErrorMsg("Apellido : Ingrese solo letras.");
                    }
                }
            }
            if(fechaNacimiento.isEmpty()){ 
                validacion = false;
                v.showErrorMsg("Fecha Nacimiento : Campo Vacío.");
            }else{
                if(!validateDate(fechaNacimiento)){
                    validacion = false;
                    v.showErrorMsg("Fecha Nacimiento: Formato Incorrecto.");
                }
            }
            if(nroDoc.isEmpty()){ 
                validacion = false;
                v.showErrorMsg("Nro Doc : Campo Vacío");
            }else{
                if(nroDoc.length() < 8){
                    validacion = false;
                    v.showErrorMsg("Nro Doc : Cant de dígitos necesarios = 8");
                }else{
                    if(!isNumeric(nroDoc.replace(".", ""))){
                        validacion = false;
                        v.showErrorMsg("Nro Doc : Ingrese solo nros.");
                    }
                }
            }
            if(calle.isEmpty()){ 
                validacion = false;
                v.showErrorMsg("Calle : Campo vacío");
            }else{
                if(calle.length() > 50){
                    validacion = false;
                    v.showErrorMsg("Calle : Máxima cant de caracteres = 50");
                }
            }
            if(nroCalle.isEmpty()){ 
                validacion = false;
                v.showErrorMsg("Nro Calle : Campo vacío");
            }else{
                if(!isNumeric(nroCalle)){
                    validacion = false;
                    v.showErrorMsg("Nro Calle : Ingrese solo nros.");
                }
            }
            /*if(isAlpha(piso)){
                validacion = false;
                v.showErrorMsg("Piso : Ingrese solo nros.");                    
            }*/

            if(!isAlpha(dpto) && !isNumeric(dpto)){
                validacion = false;
                v.showErrorMsg("Departamento : Ingrese solo nros o solo letras.");                    
            }

            if(codPostal.isEmpty()){ 
                validacion = false;
                v.showErrorMsg("Cod Postal : Campo vacío.");               
            }else{
                if(isAlpha(codPostal)){
                    validacion = false;
                    v.showErrorMsg("Cod Postal : Ingrese solo nros.");                    
                }
            }
            if(localidad.isEmpty()){ 
                validacion = false;
                v.showErrorMsg("Localidad : Campo vacío.");         
            }else{
                if(localidad.length() > 50){
                    validacion = false;
                    v.showErrorMsg("Localidad : Máxima cant de caracteres = 50");
                }
            }
            if(telFijo.isEmpty()){ 
                validacion = false;
                v.showErrorMsg("Tel Fijo : Campo vacío.");         
            }else{
                if(!isNumeric(telFijo)){
                    validacion = false;
                    v.showErrorMsg("Tel Fijo : Ingrese solo nros. ");
                }
            }
            if(telCel.isEmpty()){ 
                validacion = false;
                v.showErrorMsg("Tel Cel : Campo vacío.");         
            }else{
                if(!isNumeric(telCel)){
                    validacion = false;
                    v.showErrorMsg("Tel Cel : Ingrese solo nros.");
                }
            }
            if(eMail.isEmpty()){ 
                validacion = false;
                v.showErrorMsg("E-Mail : Campo vacío.");         
            }else{
                String emailreg = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
                Boolean b = eMail.matches(emailreg);
                if(!b){
                    validacion = false;
                    v.showErrorMsg("E-Mail : Ingrese un E-Mail válido");
                }
            }
            
            if(validacion){
                if (modo.equals("INSERT")){
                    return m.qryAltaAlumno(nroLegajo, nombre, apellido, fechaNacimiento, nroDoc, calle, nroCalle, piso, dpto, codPostal, localidad, telFijo, telCel, eMail);
                }else if (modo.equals("UPDATE")){
                    return m.qryModificarAlumno(nroLegajo, nombre, apellido, fechaNacimiento, nroDoc, calle, nroCalle, piso, dpto, codPostal, localidad, telFijo, telCel, eMail);
                }
                return 0;
            }else{
                v.showErrorMsg("La validación ha fallado.");
                return -2;
            }
    }
    
    private class funcionSendAltaCurso implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
            int q = insertarModificarCurso("INSERT");
            if (q == 1){
                v.showSuccessMsg("El curso ha sido agregado.");
                v.cargaInputsCurso(new Curso());
            }
            else if (q == 0) v.showErrorMsg("Algo ha fallado en la base de datos");

            m.cargaArrayCurso();
        }
        
    }
    
    private class funcionUpdateCurso implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
            int q = insertarModificarCurso("UPDATE");
            if (q == 1){
                v.showSuccessMsg("El curso ha sido modificado.");
                int pos = m.getPosCursos();
                m.cargaArrayCurso();
                m.setPosCursos(pos);
                v.cargaInputsCurso(m.getCurso(pos));
            }
            else if (q == 0) v.showErrorMsg("Algo ha fallado en la base de datos");

            
        }
        
    }
    
    private class funcionEliminarCurso implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
            String codCurso = v.getTxtFldCursoCodCurso();
            int q = m.qryEliminarCurso(codCurso);
            if (q == 1){
                v.showSuccessMsg("El curso ha sido eliminado.");
                m.cargaArrayCurso();
                v.cargaInputsCurso(m.getCurso(m.getPosCursos()));
            }
            else if (q == 0) v.showErrorMsg("Algo ha fallado en la base de datos");

            
        }
        
    }
    
    private class agregarAlumnoACurso implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
            String codCurso = v.getTxtFldCursoCodCurso();
            String nroLegajo = v.showInputDialog("Ingrese el nroLegajo del alumno a agregar: ");
            
            int q = m.qryAgregarAlumnoACurso(codCurso, nroLegajo);
            if (q == 1){
                v.showSuccessMsg("El alumno ha sido agregado.");
            }else if (q == 2){
                v.showErrorMsg("El nro de legajo no corresponde a un alumno válido");
            }
            else if (q == 0) v.showErrorMsg("Algo ha fallado en la base de datos");

            
        }
        
    }
    
    private int insertarModificarCurso(String modo){
        Curso curso = new Curso();
        Boolean validacion = true;

        String codCurso = v.getTxtFldCursoCodCurso();
        String nombre = v.getTxtFldCursoNombre();
        String prof = v.getTxtFldCursoProf();
        String cantClases = v.getTxtFldCursoCantClases();

        if(codCurso.isEmpty()){ 
            validacion = false;
            v.showErrorMsg("Cod Curso : Campo Vacío.");
        }else{
            if(codCurso.length() > 8){
                validacion = false;
                v.showErrorMsg("Cod Curso : Cant de dígitos necesarios = 4");
            }else{
                if(!isNumeric(codCurso)){
                    validacion = false;
                    v.showErrorMsg("Cod Curso : Inserte solo dígitos numéricos.");
                }
            }
        }
        if(nombre.isEmpty()){ 
            validacion = false;
            v.showErrorMsg("Nombre : Campo Vacío.");
        }else{
            if(nombre.length()> 50){
                validacion = false;
                v.showErrorMsg("Nombre : Máxima cant de dígitos = 50.");
            }
        }
        if(prof.isEmpty()){ 
            validacion = false;
            v.showErrorMsg("Profesor : Campo Vacío.");
        }else{
            if(prof.length()> 50){
                validacion = false;
                v.showErrorMsg("Profesor : Máxima cant de dígitos = 50.");
            }else{
                if(!isAlpha(prof)){
                    validacion = false;
                    v.showErrorMsg("Profesor : Ingrese solo letras.");
                }
            }
        }
        
        if (Integer.parseInt(cantClases) > 32){
            validacion = false;
            v.showErrorMsg("Maximo numero de clases permitido: 32");
        }

        if(validacion){
            if (modo.equals("INSERT")){
                return m.qryAltaCurso(codCurso, nombre, prof, cantClases);
            }else if (modo.equals("UPDATE")){
                return m.qryModificarCurso(codCurso , nombre , prof, cantClases);
            }
            return 0;
        }else{
            v.showErrorMsg("La validación ha fallado.");
            return -2;
        }
    }

    private class funcionSendAltaRecurso implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
            int q = insertarModificarRecurso("INSERT");
            if (q == 1){
                v.showSuccessMsg("El recurso ha sido agregado.");
                v.cargaInputsRecurso(new Recurso());
            }
            else if (q == 0) v.showErrorMsg("Algo ha fallado en la base de datos");

            m.cargaArrayRecurso();
        }
        
    }
    
    private class funcionUpdateRecurso implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
            int q = insertarModificarRecurso("UPDATE");
            if (q == 1){
                v.showSuccessMsg("El recurso ha sido modificado.");
                int pos = m.getPosRecursos();
                m.cargaArrayRecurso();
                m.setPosRecursos(pos);
                v.cargaInputsRecurso(m.getRecurso(pos));
            }
            else if (q == 0) v.showErrorMsg("Algo ha fallado en la base de datos");

            
        }
        
    }
    
    private int insertarModificarRecurso(String modo){

            Recurso recurso = new Recurso();
            Boolean validacion = true;

            String codRecurso = v.getTxtFldRecursoCodRec();
            String categoria = v.getTxtFldRecursoCategoria();
            String nombre = v.getTxtFldRecursoNombre();
            String autor = v.getTxtFldRecursoAutor();
            String anio = v.getTxtFldRecursoAnio();
            String cant = v.getTxtFldRecursoCant();

            if(codRecurso.isEmpty()){ 
                validacion = false;
                v.showErrorMsg("Cod Recurso : Campo Vacío.");
            }else{
                
            }
            if(categoria.isEmpty()){ 
                validacion = false;
                v.showErrorMsg("Categoría : Campo Vacío.");
            }else{
                if(categoria.length()> 50){
                    validacion = false;
                    v.showErrorMsg("Categoría : Máxima cant de dígitos = 50.");
                }else{
                    if(!isAlpha(categoria)){
                        validacion = false;
                        v.showErrorMsg("Categoría : Ingrese solo letras.");
                    }
                }
            }
            if(nombre.isEmpty()){ 
                validacion = false;
                v.showErrorMsg("Nombre : Campo Vacío.");
            }else{
                if(nombre.length()> 50){
                    validacion = false;
                    v.showErrorMsg("Nombre : Máxima cant de dígitos = 50.");
                }
            }
            if(autor.isEmpty()){ 
                validacion = false;
                v.showErrorMsg("Autor : Campo Vacío.");
            }else{
                if(autor.length()> 50){
                    validacion = false;
                    v.showErrorMsg("Autor : Máxima cant de dígitos = 50.");
                }else{
                    if(!isAlpha(autor)){
                        validacion = false;
                        v.showErrorMsg("Autor : Ingrese solo letras.");
                    }
                }
            }
            if(isAlpha(anio)){
                validacion = false;
                v.showErrorMsg("Año : Ingrese solo nros.");                    
            }else{
                if(anio.length() > 4){
                    validacion = false;
                    v.showErrorMsg("Año : Ingrese un año válido");
                }
            }
            if(cant.isEmpty()){
                validacion = false;
                v.showErrorMsg("Cantidad : Campo vacío.");
            }else{
                if(isAlpha(cant)){
                    validacion = false;
                    v.showErrorMsg("Cantidad : Ingrese solo nros.");                    
                }
            }
            
            if(validacion){
                if (modo.equals("INSERT")){
                    return m.qryAltaRecurso(codRecurso , nombre , anio , categoria , autor , cant);
                }else if (modo.equals("UPDATE")){
                    return m.qryModificarRecurso(codRecurso , nombre , anio , categoria , autor , cant);
                }
                return 0;
            }else{
                v.showErrorMsg("La validación ha fallado.");
                return -2;
            }
                
    }
    
    private class funcionSendAltaPrestamo implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
            int q = insertarModificarPrestamo("INSERT");
            if (q == 1){
                v.showSuccessMsg("El prestamo ha sido agregado.");
                v.cargaInputsPrestamo(new Prestamo());
            }
            else if (q == 0) v.showErrorMsg("Algo ha fallado en la base de datos");

            m.cargaArrayPrestamo();
        }
        
    }
    
    private class funcionUpdatePrestamo implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
            int q = insertarModificarPrestamo("UPDATE");
            if (q == 1){
                v.showSuccessMsg("El prestamo ha sido modificado.");
                int pos = m.getPosPrestamos();
                m.cargaArrayPrestamo();
                m.setPosPrestamos(pos);
                v.cargaInputsPrestamo(m.getPrestamo(pos));
            }
            else if (q == 0) v.showErrorMsg("Algo ha fallado en la base de datos");
        }
    }
    
    private int insertarModificarPrestamo(String modo){

        Prestamo prestamo = new Prestamo();
        Boolean validacion = true;

        String nroLegajo = v.getTxtFldPrestamoNroLegajo();
        String codRecurso = v.getTxtFldPrestamoCodRecurso();
        String fechaPrestamo = v.getTxtFldPrestamoFechaPres();
        String fechaPrevistaDevolucion = v.getTxtFldPrestamoFechaPrevDevo();
        String fechaDevolucion = v.getTxtFldPrestamoFechaDevo();

        if(nroLegajo.isEmpty()){ 
                validacion = false;
                v.showErrorMsg("Nro Legajo : Campo Vacío.");
        }else{
            if(nroLegajo.length() > 10){
                validacion = false;
                v.showErrorMsg("Nro Legajo : Cant de dígitos necesarios = 4");
            }else{
                if(!isNumeric(nroLegajo)){
                    validacion = false;
                    v.showErrorMsg("Nro Legajo : Inserte solo dígitos numéricos.");
                }
            }
        }
        if(codRecurso.isEmpty()){ 
                validacion = false;
                v.showErrorMsg("Cod Recurso : Campo Vacío.");
        }else{
            
        }
        if(fechaPrestamo.isEmpty()){ 
                validacion = false;
                v.showErrorMsg("Fecha Prestamo : Campo Vacío.");
        }else{
            if(!validateDate(fechaPrestamo)){
                validacion = false;
                v.showErrorMsg("Fecha Prestamo: Formato Incorrecto.");
            }
        }
        if(fechaPrevistaDevolucion.isEmpty()){ 
                validacion = false;
                v.showErrorMsg("Fecha Prevista Devolución : Campo Vacío.");
        }else{
            if(!validateDate(fechaPrevistaDevolucion)){
                validacion = false;
                v.showErrorMsg("Fecha Prevista Devolución: Formato Incorrecto.");
            }
        }
        
        if (!fechaDevolucion.isEmpty()){
            if(!validateDate(fechaDevolucion)){
                validacion = false;
                v.showErrorMsg("Fecha Devolucion: Formato Incorrecto.");
            }
        }else{
            fechaDevolucion = null;
        }
        
        //if(fechaDevolucion.isEmpty()){
        //    validacion = false;
        //}

        if(validacion){
                if (modo.equals("INSERT")){
                    return m.qryAltaPrestamo(nroLegajo , codRecurso , fechaPrestamo , fechaPrevistaDevolucion , fechaDevolucion);
                }else if (modo.equals("UPDATE")){
                    return m.qryModificarPrestamo(nroLegajo , codRecurso , fechaPrestamo , fechaPrevistaDevolucion , fechaDevolucion);
                }
                return 0;
            }else{
                v.showErrorMsg("La validación ha fallado.");
                return -2;
            }
            
    }  
    
    private class funcionSendAltaPago implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
            int q = insertarModificarPago("INSERT");
            if (q == 1){
                v.showSuccessMsg("El pago ha sido agregado.");
                v.cargaInputsPago(new Pago());
            }
            else if (q == 0) v.showErrorMsg("Algo ha fallado en la base de datos");

            m.cargaArrayPago();
        }
        
    }
    
    private class funcionUpdatePago implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
            int q = insertarModificarPago("UPDATE");
            if (q == 1){
                v.showSuccessMsg("El pago ha sido modificado.");
                int pos = m.getPosPagos();
                m.cargaArrayPago();
                m.setPosPagos(pos);
                v.cargaInputsPago(m.getPago(pos));
            }
            else if (q == 0) v.showErrorMsg("Algo ha fallado en la base de datos");
        }
    }
    
    private class funcionEliminarPago implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
            
            String nroLegajo = v.getTxtFldPagoNroLegajo();
            String codCurso = v.getTxtFldPagoCodCurso();
            
            int q = m.qryEliminarPago(nroLegajo, codCurso);
            if (q == 1){
                v.showSuccessMsg("El pago ha sido eliminado.");
                m.cargaArrayPago();
                v.cargaInputsPago(m.getPago(m.getPosPagos()));
            }
            else if (q == 0) v.showErrorMsg("Algo ha fallado en la base de datos");
        }
    }
    
    private int insertarModificarPago(String modo){

            Pago pago = new Pago();
            Boolean validacion = true;

            String nroLegajo = v.getTxtFldPagoNroLegajo();
            String codCurso = v.getTxtFldPagoCodCurso();
            String fecha = v.getTxtFldPagoFecha();
            String importe = v.getTxtFldPagoImporte();
            String comprobante = v.getTxtFldPagoComprobante();
            
            if(nroLegajo.isEmpty()){ 
                validacion = false;
                v.showErrorMsg("Nro Legajo : Campo Vacío.");
            }else{
                if(nroLegajo.length() > 10){
                    validacion = false;
                    v.showErrorMsg("Nro Legajo : Cant de dígitos necesarios = 4");
                }else{
                    if(!isNumeric(nroLegajo)){
                        validacion = false;
                        v.showErrorMsg("Nro Legajo : Inserte solo dígitos numéricos.");
                    }
                }
            }
            if(codCurso.isEmpty()){ 
                validacion = false;
                v.showErrorMsg("Cod Curso : Campo Vacío.");
            }else{
                if(codCurso.length() > 8){
                    validacion = false;
                    v.showErrorMsg("Cod Curso : Cant de dígitos necesarios = 4");
                }else{
                    if(!isNumeric(codCurso)){
                        validacion = false;
                        v.showErrorMsg("Cod Curso : Inserte solo dígitos numéricos.");
                    }
                }
            }
            if(fecha.isEmpty()){ 
                validacion = false;
                v.showErrorMsg("Fecha : Campo Vacío.");
            }else{
                if(!validateDate(fecha)){
                    validacion = false;
                    v.showErrorMsg("Fecha : Formato Incorrecto.");
                }
            }
            if(importe.isEmpty()){
                validacion = false;
            }
            if(comprobante.isEmpty()){ 
                validacion = false;
                v.showErrorMsg("Comprobante : Campo Vacío.");
            }else{
            }
            
            if(validacion){
                if (modo.equals("INSERT")){
                    return m.qryAltaPago(nroLegajo , codCurso , fecha , importe , comprobante);
                }else if (modo.equals("UPDATE")){
                    return m.qryModificarPago(nroLegajo , codCurso , fecha , importe , comprobante);
                }
                return 0;
            }else{
                v.showErrorMsg("La validación ha fallado.");
                return -2;
            }            
    }  
    
    class funcionGenerarListado1 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            String t = v.showInputDialog("Ingrese codigo de curso a buscar regularidades: ");
            if (t == null) return;
            
            int codCurso = Integer.parseInt(t);
            
            int response = m.generateAlumnosRegularesPorCurso(codCurso);
            if (response == 1) v.showSuccessMsg("El listado ha sido generado."); 
            
        }
    }
    
    class funcionGenerarListado2 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int response = m.generatePrestamosNoDevueltos();
            if (response == 1) v.showSuccessMsg("El listado ha sido generado."); 
        }
    }
    
    class funcionGenerarListado3 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Object[] options = {"Cancelar",
                    "Todos los alumnos",
                    "Un alumno en particular"};
            
            int opc = v.showOptionDialog("Desea generar listado de un alumno en particular o de todos los alumnos al mismo tiempo?"
                    , "Listado de prestamos", JOptionPane.YES_NO_CANCEL_OPTION
                    , options , 2);
            
            int nroLegajo = -1;
            if (opc != 0){
                if (opc == 2){
                    String t = v.showInputDialog("Nro legajo de Alumno a generar listado: ");
                    if (t == null) return;
                    
                    nroLegajo = Integer.parseInt(t);
                }else if (opc == 1){
                    nroLegajo = -1;
                }
                
                int response = m.generatePrestamosPorAlumno(nroLegajo);
                if (response == 1) v.showSuccessMsg("El listado ha sido generado");
                
            }
            
        }
    }
    
    class funcionGenerarListado4 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String mnumber = v.showInputDialog("Numero de mes a generar listado: ");
            if (mnumber == null) return;
            int monthnumber = Integer.parseInt(mnumber);
            
            String ynumber = v.showInputDialog("Numero de año a generar listado: ");
            if (ynumber == null) return;
            int yearnumber = Integer.parseInt(ynumber);
            
            int response = m.generatePagosPorMes(monthnumber, yearnumber);
            if (response == 1) v.showSuccessMsg("El listado ha sido generado."); 
        }
    }

    private class funcionSendAltaAsistencia implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
            int q = insertarModificarAsistencia();
            if (q == 1){
                v.showSuccessMsg("El registro de asistencias ha sido cargado.");
            }
            else if (q == 0) v.showErrorMsg("Algo ha fallado en la base de datos");
            
            String codCurso = v.getTxtFldAsistCodCurso();
            String nroClase = v.getTxtFldAsistNroClase();
            
            m.cargaArrayAsistencia(codCurso, Integer.valueOf(nroClase), 0);
            v.cargaInputsAsistencia(m.getArrayAsistencias());
        }
        
    }
    
    private class funcionCargarAsistencias implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
            
            String codCurso = v.getTxtFldAsistCodCurso();
            String nroClase = v.getTxtFldAsistNroClase();
            
            Curso a = m.getCursoWithCode(codCurso);
            if (a != null){
                if (Integer.valueOf(nroClase) > 0 && Integer.valueOf(nroClase) < (Integer.valueOf(a.getCursoCantClases()) + 1)){
                    m.cargaArrayAsistencia(codCurso, Integer.valueOf(nroClase), 0);
                    m.setPosAsistencias(0);
                    v.limpiarInputsAsistencia();
                    v.cargaInputsAsistencia(m.getArrayAsistencias());
                }else{
                    v.limpiarInputsAsistencia();
                    v.showErrorMsg("Nro de clase no permitido");
                }
            }else{
                v.limpiarInputsAsistencia();
                v.showErrorMsg("Cod curso inexistente");
            }
            
        }
    }
    
    private int insertarModificarAsistencia(){

            Asistencia asistencia = new Asistencia();
            Boolean validacion = true;
            
            boolean[] arrayAsistencias = new boolean[16];
            String[] arrayNroLegajo = new String[16];
            
            String codCurso = v.getTxtFldAsistCodCurso();
            String nroClase = v.getTxtFldAsistNroClase();
            
            for(int i = 0 ; i<16 ; i++){
                arrayAsistencias[i] = v.getTxtFldAsistValue(i);
                arrayNroLegajo[i] = v.getTxtFldAsistNroLegajo(i);
            }
            
            
            if(validacion){
                for(int i=0;i<16;i++){
                    if(!(arrayNroLegajo[i].toString().equals(""))){
                        m.qryUpsertAsistencia(arrayNroLegajo[i] , codCurso , nroClase , arrayAsistencias[i]);
                    }
                }
                return 1;
            }else{
                v.showErrorMsg("La validación ha fallado.");
                return -2;
            }            
    }  
    
    // ----- Handlers botones avanzar / retroceder -----
      // ALUMNO
    class RetrocederAlumnoHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (m.getCantAlumnos()> 0) {
                m.setPosAlumnos(m.getPosAlumnos()- 1);
                if (m.getPosAlumnos()== -1) {
                    m.setPosAlumnos(0);
                }
                v.cargaInputsAlumno(m.getAlumno(m.getPosAlumnos()));
            }
        }
    }
    
    class AvanzarAlumnoHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (m.getCantAlumnos() > 0) {
                m.setPosAlumnos(m.getPosAlumnos()+ 1);
                if (m.getPosAlumnos()== m.getCantAlumnos()) {
                    m.setPosAlumnos(m.getCantAlumnos()- 1);
                }
                v.cargaInputsAlumno(m.getAlumno(m.getPosAlumnos()));
            }
        }
    }
    
      // CURSO
    class RetrocederCursoHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (m.getCantCursos()> 0) {
                m.setPosCursos(m.getPosCursos()- 1);
                if (m.getPosCursos()== -1) {
                    m.setPosCursos(0);
                }
                v.cargaInputsCurso(m.getCurso(m.getPosCursos()));
            }
        }
    }
    
    class AvanzarCursoHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (m.getCantCursos() > 0) {
                m.setPosCursos(m.getPosCursos()+ 1);
                if (m.getPosCursos()== m.getCantCursos()) {
                    m.setPosCursos(m.getCantCursos()- 1);
                }
                v.cargaInputsCurso(m.getCurso(m.getPosCursos()));
            }
        }
    }
    
     // PAGO 
    class RetrocederPagoHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (m.getCantPagos()> 0) {
                m.setPosPagos(m.getPosPagos()- 1);
                if (m.getPosPagos()== -1) {
                    m.setPosPagos(0);
                }
                v.cargaInputsPago(m.getPago(m.getPosPagos()));
            }
        }
    }
    
    class AvanzarPagoHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (m.getCantPagos() > 0) {
                m.setPosPagos(m.getPosPagos()+ 1);
                if (m.getPosPagos()== m.getCantPagos()) {
                    m.setPosPagos(m.getCantPagos()- 1);
                }
                v.cargaInputsPago(m.getPago(m.getPosPagos()));
            }
        }
    }
    
      // PRESTAMO
    class RetrocederPrestamoHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (m.getCantPrestamos()> 0) {
                m.setPosPrestamos(m.getPosPrestamos()- 1);
                if (m.getPosPrestamos()== -1) {
                    m.setPosPrestamos(0);
                }
                v.cargaInputsPrestamo(m.getPrestamo(m.getPosPrestamos()));
            }
        }
    }
    
    class AvanzarPrestamoHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (m.getCantPrestamos() > 0) {
                m.setPosPrestamos(m.getPosPrestamos()+ 1);
                if (m.getPosPrestamos()== m.getCantPrestamos()) {
                    m.setPosPrestamos(m.getCantPrestamos()- 1);
                }
                v.cargaInputsPrestamo(m.getPrestamo(m.getPosPrestamos()));
            }
        }
    }
    
      // RECURSO
    class RetrocederRecursoHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (m.getCantRecursos()> 0) {
                m.setPosRecursos(m.getPosRecursos()- 1);
                if (m.getPosRecursos()== -1) {
                    m.setPosRecursos(0);
                }
                v.cargaInputsRecurso(m.getRecurso(m.getPosRecursos()));
            }
        }
    }
    
    class AvanzarRecursoHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (m.getCantRecursos() > 0) {
                m.setPosRecursos(m.getPosRecursos()+ 1);
                if (m.getPosRecursos()== m.getCantRecursos()) {
                    m.setPosRecursos(m.getCantRecursos()- 1);
                }
                v.cargaInputsRecurso(m.getRecurso(m.getPosRecursos()));
            }
        }
    }
    
      // ASISTENCIA
    class RetrocederAsistenciaHandler implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            int cantClases = m.qryCantAsistCurso(v.getTxtFldAsistCodCurso());
            //qry que calcula la cant de clases que tiene cargada la materia
        
            if (cantClases > 0) {
                m.setPosAsistencias(m.getPosAsistencias()- 1);
                if (m.getPosAsistencias()== -1) {
                    m.setPosAsistencias(0);
                }
                m.cargaArrayAsistencia(v.getTxtFldAsistCodCurso(), m.getPosAsistencias(), 0);
                v.cargaInputsAsistencia(m.getArrayAsistencias());
            }
        }
    }
    
    class AvanzarAsistenciaHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int cantClases = m.qryCantAsistCurso(v.getTxtFldAsistCodCurso());
            //qry que calcula la cant de clases que tiene cargada la materia
        
            if (cantClases > 0) {
                m.setPosAsistencias(m.getPosAsistencias()+ 1);
                if (m.getPosAsistencias()== cantClases) {
                    m.setPosAsistencias(cantClases- 1);
                }
                m.cargaArrayAsistencia(v.getTxtFldAsistCodCurso(), m.getPosAsistencias(), 0);
                v.cargaInputsAsistencia(m.getArrayAsistencias());
            }
        }
    }
    
    
    
    
    
    
}
