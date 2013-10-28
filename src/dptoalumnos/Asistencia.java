package dptoalumnos;


public class Asistencia {

    private String nroLegajo;
    private String codCurso;
    private Integer nroClase;
    private Integer asistencia;
    
    public Asistencia(){
        nroLegajo = "";
        codCurso = "";
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

    public void setNroClase(Integer nroClase) {
        this.nroClase = nroClase;
    }

    public void setAsistencia(Integer asistencia) {
        this.asistencia = asistencia;
    }
    
    
    
    
}
