package dptoalumnos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        m.cargaArrayAlumno();
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
                    
                    new menuItem_altaPagos(), 
                    new menuItem_bajaPagos(), 
                    new menuItem_modificacionPagos(), 
                    
                    new menuItem_altaPrestamos(), 
                    new menuItem_bajaPrestamos(), 
                    new menuItem_modificacionPrestamos(), 
                    
                    new menuItem_altaRecursos(), 
                    new menuItem_bajaRecursos(), 
                    new menuItem_modificacionRecursos(), 
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
            
            if (m.getCantAlumnos() > 0){
            v.cargaInputsAlumno(m.getAlumno(m.getPosAlumnos()));
            v.addActionListenersModificarAlumno(new funcionUpdateAlumno(),new RetrocederAlumnoHandler(), new AvanzarAlumnoHandler());
            }else{
                v.showErrorMsg("No hay Alumnos cargados en el sistema. Dirigase a la pantalla de alta de Alumnos para cargar alumnos en el sistema.");
            }
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
                v.addActionListenersModificarCurso(null,new RetrocederCursoHandler(), new AvanzarCursoHandler(), null);
            }else{
                v.showErrorMsg("No hay cursos cargados en el sistema. Dirigase a la pantalla de alta de Cursos para cargar cursos en el sistema.");
            }
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
            v.addActionListenersModificarPago(null,new RetrocederPagoHandler(), new AvanzarPagoHandler(), null);
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
            v.addActionListenersModificarPrestamo(null,new RetrocederPrestamoHandler(), new AvanzarPrestamoHandler());
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
            v.addActionListenersModificarRecurso(null,new RetrocederRecursoHandler(), new AvanzarRecursoHandler());
            }else{
                v.showErrorMsg("No hay recursos cargados en el sistema. Dirigase a la pantalla de alta para ingresar nuevos recursos.");
            }
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

            m.cargaArrayAlumno();
        }
        
    }
    
    private class funcionUpdateAlumno implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
            int q = insertarModificarAlumno("UPDATE");
            if (q == 1){
                v.showSuccessMsg("El alumno ha sido modificado.");
                int pos = m.getPosAlumnos();
                m.cargaArrayAlumno();
                m.setPosAlumnos(pos);
                v.cargaInputsAlumno(m.getAlumno(pos));
            }
            else if (q == 0) v.showErrorMsg("Algo ha fallado en la base de datos");

            
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
            
            // validacioens de ingreso de datos . 
            if(nroLegajo.isEmpty()){ 
                validacion = false;
            }
            if(nombre.isEmpty()){ 
                validacion = false;
            }
            if(apellido.isEmpty()){ 
                validacion = false;
            }
            if(fechaNacimiento.isEmpty()){ 
                validacion = false;
            }
            if(nroDoc.isEmpty()){ 
                validacion = false;
            }
            if(calle.isEmpty()){ 
                validacion = false;
            }
            if(nroCalle.isEmpty()){ 
                validacion = false;
            }
            if(piso.isEmpty()){ 
                validacion = false;
            }
            if(dpto.isEmpty()){ 
                validacion = false;
            }
            if(codPostal.isEmpty()){ 
                validacion = false;
            }
            if(localidad.isEmpty()){ 
                validacion = false;
            }
            if(telFijo.isEmpty()){ 
                validacion = false;
            }
            if(telCel.isEmpty()){ 
                validacion = false;
            }
            if(eMail.isEmpty()){ 
                validacion = false;
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
            Curso curso = new Curso();
            Boolean validacion = true;

            String codCurso = v.getTxtFldCursoCodCurso();
            String nombre = v.getTxtFldCursoNombre();
            String prof = v.getTxtFldCursoProf();

            if(codCurso.isEmpty()){
                validacion = false;
            }
            if(nombre.isEmpty()){
                validacion = false;
            }
            if(prof.isEmpty()){
                validacion = false;
            }
            
            if(validacion){
                int q = m.qryAltaCurso(codCurso, nombre, prof);
                
                if (q == 1){
                    v.showSuccessMsg("El curso ha sido agregado.");
                    v.cargaInputsCurso(new Curso());
                }
                else v.showErrorMsg("Algo ha fallado en la base de datos");
                
                m.cargaArrayCurso();
            }else{
                v.showErrorMsg("La validación ha fallado.");
            }
            
        }
            
    }
    
    private class funcionSendAltaRecurso implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
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
            }
            if(categoria.isEmpty()){
                validacion = false;
            }
            if(nombre.isEmpty()){
                validacion = false;
            }
            if(autor.isEmpty()){
                validacion = false;
            }
            if(anio.isEmpty()){
                validacion = false;
            }
            if(cant.isEmpty()){
                validacion = false;
            }
            
            if(validacion){
                int q = m.qryAltaRecurso(codRecurso, nombre, anio, categoria, autor, cant);
                
                if (q == 1){
                    v.showSuccessMsg("El recurso ha sido agregado.");
                    v.cargaInputsRecurso(new Recurso());
                }
                else v.showErrorMsg("Algo ha fallado en la base de datos");
                
                m.cargaArrayRecurso();
            }else{
                v.showErrorMsg("La validación ha fallado.");
            }
            
        }
            
    }
    
    private class funcionSendAltaPrestamo implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            Prestamo prestamo = new Prestamo();
            Boolean validacion = true;

            String nroLegajo = v.getTxtFldPrestamoNroLegajo();
            String codRecurso = v.getTxtFldPrestamoCodRecurso();
            String fechaPrestamo = v.getTxtFldPrestamoFechaPres();
            String fechaPrevistaDevolucion = v.getTxtFldPrestamoFechaPrevDevo();
            String fechaDevolucion = v.getTxtFldPrestamoFechaDevo();
            
            if(nroLegajo.isEmpty()){
                validacion = false;
            }
            if(codRecurso.isEmpty()){
                validacion = false;
            }
            if(fechaPrestamo.isEmpty()){
                validacion = false;
            }
            if(fechaPrevistaDevolucion.isEmpty()){
                validacion = false;
            }
            if(fechaDevolucion.isEmpty()){
                validacion = false;
            }
            
            if(validacion){
               int q = m.qryAltaPrestamo(nroLegajo, codRecurso, fechaPrestamo, fechaDevolucion, fechaPrevistaDevolucion);
               
               if (q == 1){ 
                   v.showSuccessMsg("El prestamo ha sido agregado."); 
                   v.cargaInputsPrestamo(new Prestamo());
               }
               else v.showErrorMsg("Algo ha fallado en la base de datos");
               
               m.cargaArrayPrestamo();
            }else{
                v.showErrorMsg("La validación ha fallado.");
            }
            
        }
            
    }  
    
    private class funcionSendAltaPago implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            Pago pago = new Pago();
            Boolean validacion = true;

            String nroLegajo = v.getTxtFldPagoNroLegajo();
            String codCurso = v.getTxtFldPagoCodCurso();
            String fecha = v.getTxtFldPagoFecha();
            String importe = v.getTxtFldPagoImporte();
            String comprobante = v.getTxtFldPagoComprobante();
            
            if(nroLegajo.isEmpty()){
                validacion = false;
            }
            if(codCurso.isEmpty()){
                validacion = false;
            }
            if(fecha.isEmpty()){
                validacion = false;
            }
            if(importe.isEmpty()){
                validacion = false;
            }
            if(comprobante.isEmpty()){
                validacion = false;
            }
            
            if(validacion){
                int q = m.qryAltaPagos(nroLegajo, codCurso, fecha, importe, comprobante);
                
                if (q == 1){
                    v.showSuccessMsg("El pago ha sido agregado.");
                    v.cargaInputsPago(new Pago());
                }
                else v.showErrorMsg("Algo ha fallado en la base de datos");
                
                m.cargaArrayPago();
            }else{
                v.showErrorMsg("La validación ha fallado.");
            }
            
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
    
    
    
    
    
    
}
