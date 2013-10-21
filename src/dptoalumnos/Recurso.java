package dptoalumnos;


public class Recurso {

    private String codRecurso;
    private String categoria;
    private String denominacion;
    private String autor;
    private String anio;
    private String cant;
    private String foto;
    
    public Recurso(){
        codRecurso = "";
        categoria = "";
        denominacion = "";
        autor = "";
        anio = "";
        cant = "";
        foto = "";
    }

    public String getCodRecurso() {
        return codRecurso;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public String getAutor() {
        return autor;
    }

    public String getAnio() {
        return anio;
    }

    public String getCant() {
        return cant;
    }

    public String getFoto() {
        return foto;
    }

    public void setCodRecurso(String codRecurso) {
        this.codRecurso = codRecurso;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public void setCant(String cant) {
        this.cant = cant;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
    
    
    
}
