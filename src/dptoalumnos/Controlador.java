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
        }
    }
    
    private class funcionSendAltaAlumno implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
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
                m.qryAltaAlumno(nroLegajo, nombre, apellido, fechaNacimiento, nroDoc, calle, nroCalle, piso, dpto, codPostal, localidad, telFijo, telCel, eMail);
            }else{
                v.showErrorMsg("La validación ha fallado.");
            }
            
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
                m.qryAltaCurso(codCurso, nombre, prof);
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
                m.qryAltaRecurso(codRecurso, nombre, anio, categoria, autor, cant);
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
            
            if(validacion){
                m.qryAltaPrestamo(nroLegajo, codRecurso, fechaPrestamo, fechaDevolucion, fechaPrevistaDevolucion);
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
                m.qryAltaPagos(nroLegajo, codCurso, fecha, importe, comprobante);
            }else{
                v.showErrorMsg("La validación ha fallado.");
            }
            
        }
            
    }  
    
    
    
    
    
}
