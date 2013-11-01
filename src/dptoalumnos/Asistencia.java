package dptoalumnos;


public class Asistencia {

    private String nroLegajo;
    private String codCurso;
    private String nombreApellido;
    private Integer nroClase;
    private Integer asistencia;
    
    public Asistencia(){
        nroLegajo = "";
        codCurso = "";
        nombreApellido = "";
        nroClase = 0;
        asistencia = 0;
    }
    
    // ----- getters
    public String getNroLegajo() {
        return nroLegajo;
    }

    public String getCodCurso() {
        return codCurso;
    }
    
    public String getNombreApellido(){
        return nombreApellido;
    }

    public Integer getNroClase() {
        return nroClase;
    }

    public Integer getAsistencia() {
        return asistencia;
    }
    
    // ----- setters -----
    public void setNroLegajo(String nroLegajo) {
        this.nroLegajo = nroLegajo;
    }

    public void setCodCurso(String codCurso) {
        this.codCurso = codCurso;
    }
    
    public void setNombreApellido(String nombreApellido){
        this.nombreApellido = nombreApellido;
    }

    public void setNroClase(Integer nroClase) {
        this.nroClase = nroClase;
    }

    public void setAsistencia(Integer asistencia) {
        this.asistencia = asistencia;
    }
    
    
    
    
}
