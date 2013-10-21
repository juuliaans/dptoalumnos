package dptoalumnos;


public class Prestamo {
    private String nroLegajo;
    private String codRecurso;
    private String fechaPrestamo;
    private String fechaPrevistaDevolucion;
    private String fechaDevolucion;
    
    public Prestamo(){
        nroLegajo = "";
        codRecurso = "";
        fechaPrestamo = "";
        fechaPrevistaDevolucion = "";
        fechaDevolucion = "";
    }

    public String getNroLegajo() {
        return nroLegajo;
    }

    public String getCodRecurso() {
        return codRecurso;
    }

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    public String getFechaPrevistaDevolucion() {
        return fechaPrevistaDevolucion;
    }

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setNroLegajo(String nroLegajo) {
        this.nroLegajo = nroLegajo;
    }

    public void setCodRecurso(String codRecurso) {
        this.codRecurso = codRecurso;
    }

    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public void setFechaPrevistaDevolucion(String fechaPrevistaDevolucion) {
        this.fechaPrevistaDevolucion = fechaPrevistaDevolucion;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
    
    

}
