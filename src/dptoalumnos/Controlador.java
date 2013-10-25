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
        addFunciones();
        v.pantallaPrincipal();
        addFunciones();
        
        v.setTxtAlumnosPrincipal(m.getAlumnos());
    }
    
    public void addFunciones(){
        v.mostrarAltaAlumno(new funcionMostrarAltaAlumno());
    }

    private class funcionMostrarAltaAlumno implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            v.pantallaAltaAlumno();
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
            }
        }
        
        private class funcionSendAltaCurso implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent ae) {
                Curso curso = new Curso();
                Boolean validation = true;
                
                String codCurso = v.getTxtFldCursoCodCurso();
                String nombre = v.getTxtFldCursoNombre();
                String prof = v.getTxtFldCursoProf();
                
                if(codCurso.isEmpty()){
                    validation = false;
                }
                if(nombre.isEmpty()){
                    validation = false;
                }
                if(prof.isEmpty()){
                    validation = false;
                }
            }
            
        }
        
    }
    
    
}
