package dptoalumnos;


public class Curso {
    private String cursoCod;
    private String cursoNombre;
    private String cursoProf;
    private String cursoAsist;

    public Curso() {
        cursoCod = "";
        cursoNombre = "";
        cursoProf = "";
        cursoAsist = "";
    }

    public void setCursoCod(String cursoCod) {
        this.cursoCod = cursoCod;
    }

    public void setCursoNombre(String cursoNombre) {
        this.cursoNombre = cursoNombre;
    }

    public void setCursoProf(String cursoProf) {
        this.cursoProf = cursoProf;
    }

    public void setCursoAsist(String cursoAsist) {
        this.cursoAsist = cursoAsist;
    }
    
    public String getCursoCod() {
        return cursoCod;
    }

    public String getCursoNombre() {
        return cursoNombre;
    }

    public String getCursoProf() {
        return cursoProf;
    }

    public String getCursoAsist() {
        return cursoAsist;
    }
    
    
    
    
}
