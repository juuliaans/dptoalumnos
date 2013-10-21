package dptoalumnos;


public class Alumno {
    
    private String nroLegajo;
    private String nombre;
    private String apellido;
    private String fechaNacimiento;
    private String nroDoc;
    private String calle;
    private String nroCalle;
    private String piso;
    private String departamento;
    private String codPostal;
    private String localidad;
    private String telFijo;
    private String telCel;
    private String eMail;

    public Alumno() {
        nroLegajo = "";
        nombre = "";
        apellido = "";
        fechaNacimiento = "";
        nroDoc = "";
        calle = "";
        nroCalle = "";
        piso = "";
        departamento = "";
        codPostal = "";
        localidad = "";
        telFijo = "";
        telCel = "";
        eMail = "";
    }


    public String getNroLegajo() {
        return nroLegajo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getNroDoc() {
        return nroDoc;
    }

    public String getCalle() {
        return calle;
    }

    public String getNroCalle() {
        return nroCalle;
    }

    public String getPiso() {
        return piso;
    }

    public String getDepartamento() {
        return departamento;
    }

    public String getCodPostal() {
        return codPostal;
    }

    public String getLocalidad() {
        return localidad;
    }

    public String getTelFijo() {
        return telFijo;
    }

    public String getTelCel() {
        return telCel;
    }

    public String geteMail() {
        return eMail;
    }

    public void setNroLegajo(String nroLegajo) {
        this.nroLegajo = nroLegajo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setNroDoc(String nroDoc) {
        this.nroDoc = nroDoc;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public void setNroCalle(String nroCalle) {
        this.nroCalle = nroCalle;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public void setTelFijo(String telFijo) {
        this.telFijo = telFijo;
    }

    public void setTelCel(String telCel) {
        this.telCel = telCel;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }
    
    

}
