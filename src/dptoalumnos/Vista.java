package dptoalumnos;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


public final class Vista {
    // Pantalla Principal
    private JFrame contenedor;
    private JPanel pantallaPrincipal;
    private JMenuBar menuBar;
    private JMenu archivo;
    private JMenu item1_1;
    private JMenuItem addItem1_1;
    private JMenuItem delItem1_1;
    private JMenuItem modItem1_1;
    private JMenu item1_2;
    private JMenuItem addItem1_2;
    private JMenuItem delItem1_2;
    private JMenuItem modItem1_2;
    private JMenu item1_3;
    private JMenuItem addItem1_3;
    private JMenuItem delItem1_3;
    private JMenuItem modItem1_3;
    private JMenu item1_4; 
    private JMenuItem addItem1_4;
    private JMenuItem delItem1_4;
    private JMenuItem modItem1_4;
    private JMenu item1_5;
    private JMenuItem addItem1_5;
    private JMenuItem delItem1_5;
    private JMenuItem modItem1_5;
    private JMenuItem item1_6;
    
    //Globals
    private JPanel pantallaActual;
    
    //Pantalla Alta Alumno
    private JPanel panelAltaAlumno;
    private JLabel txtLblAlumnoNroLegajo;
    private JTextField txtFldAlumnoNroLegajo;
    private JLabel txtLblAlumnoNombre;
    private JTextField txtFldAlumnoNombre;
    private JLabel txtLblAlumnoApellido;
    private JTextField txtFldAlumnoApellido;
    private JLabel txtLblAlumnoFechaNacimiento;
    private JTextField txtFldAlumnoFechaNacimiento;
    private JLabel txtLblAlumnoNroDoc;
    private JTextField txtFldAlumnoNroDoc;
    private JLabel txtLblAlumnoCalle;
    private JTextField txtFldAlumnoCalle;
    private JLabel txtLblAlumnoNro;
    private JTextField txtFldAlumnoNro;
    private JLabel txtLblAlumnoPiso;
    private JTextField txtFldAlumnoPiso;
    private JLabel txtLblAlumnoDepartamento;
    private JTextField txtFldAlumnoDepartamento;
    private JLabel txtLblAlumnoCodPostal;
    private JTextField txtFldAlumnoCodPostal;
    private JLabel txtLblAlumnoLocalidad;
    private JTextField txtFldAlumnoLocalidad;
    private JLabel txtLblAlumnoTelFijo;
    private JTextField txtFldAlumnoTelFijo;
    private JLabel txtLblAlumnoTelCel;
    private JTextField txtFldAlumnoTelCel;
    private JLabel txtLblAlumnoMail;
    private JTextField txtFldAlumnoMail;
    private JLabel txtLblAlumnoFoto;
    private JTextField txtFldAlumnoFoto;
    private JButton btnAlumnoSend;

    //Pantalla Alta Curso
    private JPanel panelAltaCurso;
    private JLabel txtLblCursoCodCurso;
    private JTextField txtFldCursoCodCurso;
    private JLabel txtLblCursoNombre;
    private JTextField txtFldCursoNombre;
    private JLabel txtLblCursoProf;
    private JTextField txtFldCursoProf;
    
    //Pantalla Alta Recurso
    private JPanel panelAltaRecurso;
    private JLabel txtLblRecursoCodRec;
    private JTextField txtFldRecursoCodRec;
    private JLabel txtLblRecursoCategoria;
    private JTextField txtFldRecursoCategoria;
    private JLabel txtLblRecursoNombre;
    private JTextField txtFldRecursoNombre;
    private JLabel txtLblRecursoAutor;
    private JTextField txtFldRecursoAutor;
    private JLabel txtLblRecursoAnio;
    private JTextField txtFldRecursoAnio;
    private JLabel txtLblRecursoCant;
    private JTextField txtFldRecursoCant;

    //Pantalla Alta Prestamo
    private JPanel panelAltaPrestamo;
    private JLabel txtLblPrestamoNroLegajo;
    private JTextField txtFldPrestamoNroLegajo;
    private JLabel txtLblPrestamoCodRecurso;
    private JTextField txtFldPrestamoCodRecurso;
    private JLabel txtLblPrestamoFechaPres;
    private JTextField txtFldPrestamoFechaPres;
    private JLabel txtLblPrestamoFechaDevo;
    private JTextField txtFldPrestamoFechaDevo;
    private JLabel txtLblPrestamoFechaPrevDevo;
    private JTextField txtFldPrestamoFechaPrevDevo;

    //Pantalla Alta Pagos
    private JPanel panelAltaPago;
    private JLabel txtLblPagoNroLegajo;
    private JTextField txtFldPagoNroLegajo;
    private JLabel txtLblPagoCodCurso;
    private JTextField txtFldPagoCodCurso;
    private JLabel txtLblPagoFecha;
    private JTextField txtFldPagoFecha;
    private JLabel txtLblPagoImporte;
    private JTextField txtFldPagoImporte;
    private JLabel txtLblPagoComprobante;
    private JTextField txtFldPagoComprobante;

    public void pantallaAltaPago(){
        panelAltaPago = new JPanel();

        txtLblPagoNroLegajo = new JLabel("Nro Legajo : ");
        txtFldPagoNroLegajo = new JTextField(4);
        txtLblPagoCodCurso = new JLabel("Cod Curso : ");
        txtFldPagoCodCurso = new JTextField(4);
        txtLblPagoFecha = new JLabel("Fecha : ");
        txtFldPagoFecha = new JTextField(10);
        txtLblPagoImporte = new JLabel("Importe : ");
        txtFldPagoImporte = new JTextField(6);
        txtLblPagoComprobante = new JLabel("Comprobante : ");
        txtFldPagoComprobante = new JTextField(4);

        panelAltaPago.add(txtLblPagoNroLegajo);
        panelAltaPago.add(txtFldPagoNroLegajo);
        panelAltaPago.add(txtLblPagoCodCurso);
        panelAltaPago.add(txtFldPagoCodCurso);
        panelAltaPago.add(txtLblPagoFecha);
        panelAltaPago.add(txtFldPagoFecha);
        panelAltaPago.add(txtLblPagoImporte);
        panelAltaPago.add(txtFldPagoImporte);
        panelAltaPago.add(txtLblPagoComprobante);
        panelAltaPago.add(txtFldPagoComprobante);

        contenedor.add(panelAltaPago);

    }

    

    public Vista() {
        contenedor = new JFrame();
        contenedor.setTitle("Departamentos de Alumnos");
        contenedor.setResizable(true);
        contenedor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contenedor.setSize(1024 , 768);
    }
    
    public void iniciarVentanaPrincipal(){
        menuBar = new JMenuBar();
        archivo = new JMenu("Archivo");
        
        item1_1 = new JMenu("Alumnos");
        addItem1_1 = new JMenuItem("Alta");
        delItem1_1 = new JMenuItem("Baja");
        modItem1_1 = new JMenuItem("Modificacion");
        item1_1.add(addItem1_1);
        item1_1.add(delItem1_1);
        item1_1.add(modItem1_1);
        archivo.add(item1_1);
        
        item1_2 = new JMenu("Cursos");
        addItem1_2 = new JMenuItem("Alta");
        delItem1_2 = new JMenuItem("Baja");
        modItem1_2 = new JMenuItem("Modificacion");
        item1_2.add(addItem1_2);
        item1_2.add(delItem1_2);
        item1_2.add(modItem1_2);
        archivo.add(item1_2);
        
        item1_3 = new JMenu("Pagos");
        addItem1_3 = new JMenuItem("Alta");
        delItem1_3 = new JMenuItem("Baja");
        modItem1_3 = new JMenuItem("Modificacion");
        item1_3.add(addItem1_3);
        item1_3.add(delItem1_3);
        item1_3.add(modItem1_3);
        archivo.add(item1_3);
        
        item1_4 = new JMenu("Prestamos");
        addItem1_4 = new JMenuItem("Alta");
        delItem1_4 = new JMenuItem("Baja");
        modItem1_4 = new JMenuItem("Modificacion");
        item1_4.add(addItem1_4);
        item1_4.add(delItem1_4);
        item1_4.add(modItem1_4);
        archivo.add(item1_4);
        
        item1_5 = new JMenu("Recursos");
        addItem1_5 = new JMenuItem("Alta");
        delItem1_5 = new JMenuItem("Baja");
        modItem1_5 = new JMenuItem("Modificacion");
        item1_5.add(addItem1_5);
        item1_5.add(delItem1_5);
        item1_5.add(modItem1_5);
        archivo.add(item1_5);
        
        archivo.addSeparator();
        item1_6 = new JMenuItem("Cerrar");
        archivo.add(item1_6);
        
        menuBar.add(archivo);
        contenedor.setJMenuBar(menuBar);
        contenedor.setLocationRelativeTo(null);
        contenedor.setLayout(new BorderLayout());
        contenedor.setVisible(true);
    }
    
    public void addEventsToMenu(ActionListener[] al) {
        addItem1_1.addActionListener(al[0]);
        delItem1_1.addActionListener(al[1]);
        modItem1_1.addActionListener(al[2]);
        
        addItem1_2.addActionListener(al[3]);
        delItem1_2.addActionListener(al[4]);
        modItem1_2.addActionListener(al[5]);
        
        addItem1_3.addActionListener(al[6]);
        delItem1_3.addActionListener(al[7]);
        modItem1_3.addActionListener(al[8]);
        
        addItem1_4.addActionListener(al[9]);
        delItem1_4.addActionListener(al[10]);
        modItem1_4.addActionListener(al[11]);
        
        addItem1_5.addActionListener(al[12]);
        delItem1_5.addActionListener(al[13]);
        modItem1_5.addActionListener(al[14]);
    }
    
    public void addCloseEventToMenuItem(ActionListener al){
        item1_6.addActionListener(al);
    }
    
    public void pantallaAltaAlumno(){
        panelAltaAlumno = new JPanel();
        pantallaActual = panelAltaAlumno;
        
        txtLblAlumnoNroLegajo = new JLabel("Nro Legajo : ");
        txtFldAlumnoNroLegajo = new JTextField(4);
        txtLblAlumnoNombre = new JLabel("Nombre : ");
        txtFldAlumnoNombre = new JTextField(20);
        txtLblAlumnoApellido = new JLabel("Apellido : ");
        txtFldAlumnoApellido = new JTextField(20);
        txtLblAlumnoFechaNacimiento = new JLabel("Fecha Nacimiento : ");
        txtFldAlumnoFechaNacimiento = new JTextField(10);
        txtLblAlumnoNroDoc = new JLabel("Nro Doc : ");
        txtFldAlumnoNroDoc = new JTextField(10);
        txtLblAlumnoCalle = new JLabel("Calle : ");
        txtFldAlumnoCalle = new JTextField(20);
        txtLblAlumnoNro = new JLabel("Nro : ");
        txtFldAlumnoNro = new JTextField(5);
        txtLblAlumnoPiso = new JLabel("Piso : ");
        txtFldAlumnoPiso = new JTextField(2);
        txtLblAlumnoDepartamento = new JLabel("Depto : ");
        txtFldAlumnoDepartamento = new JTextField(1);
        txtLblAlumnoCodPostal = new JLabel("Cod Postal : ");
        txtFldAlumnoCodPostal = new JTextField(5);
        txtLblAlumnoLocalidad = new JLabel("Localidad : ");
        txtFldAlumnoLocalidad = new JTextField(20);
        txtLblAlumnoTelFijo = new JLabel("Tel Fijo : ");
        txtFldAlumnoTelFijo = new JTextField(10);
        txtLblAlumnoTelCel = new JLabel("Tel Cel : ");
        txtFldAlumnoTelCel = new JTextField(10);
        txtLblAlumnoMail = new JLabel("E-Mail : ");
        txtFldAlumnoMail = new JTextField(20);
        btnAlumnoSend = new JButton("Enviar");
        
        panelAltaAlumno.add(txtLblAlumnoNroLegajo);
        panelAltaAlumno.add(txtFldAlumnoNroLegajo);
        panelAltaAlumno.add(txtLblAlumnoNombre);
        panelAltaAlumno.add(txtFldAlumnoNombre);
        panelAltaAlumno.add(txtLblAlumnoApellido);
        panelAltaAlumno.add(txtFldAlumnoApellido);
        panelAltaAlumno.add(txtLblAlumnoFechaNacimiento);
        panelAltaAlumno.add(txtFldAlumnoFechaNacimiento);
        panelAltaAlumno.add(txtLblAlumnoNroDoc);
        panelAltaAlumno.add(txtFldAlumnoNroDoc);
        panelAltaAlumno.add(txtLblAlumnoCalle);
        panelAltaAlumno.add(txtFldAlumnoCalle);
        panelAltaAlumno.add(txtLblAlumnoNro);
        panelAltaAlumno.add(txtFldAlumnoNro);
        panelAltaAlumno.add(txtLblAlumnoPiso);
        panelAltaAlumno.add(txtFldAlumnoPiso);
        panelAltaAlumno.add(txtLblAlumnoDepartamento);
        panelAltaAlumno.add(txtFldAlumnoDepartamento);
        panelAltaAlumno.add(txtLblAlumnoCodPostal);
        panelAltaAlumno.add(txtFldAlumnoCodPostal);
        panelAltaAlumno.add(txtLblAlumnoLocalidad);
        panelAltaAlumno.add(txtFldAlumnoLocalidad);
        panelAltaAlumno.add(txtLblAlumnoTelFijo);
        panelAltaAlumno.add(txtFldAlumnoTelFijo);
        panelAltaAlumno.add(txtLblAlumnoTelCel);
        panelAltaAlumno.add(txtFldAlumnoTelCel);
        panelAltaAlumno.add(txtLblAlumnoMail);
        panelAltaAlumno.add(txtFldAlumnoMail);
        panelAltaAlumno.add(btnAlumnoSend);
        
        contenedor.add(panelAltaAlumno);
    }

    public void pantallaAltaCurso(){
        panelAltaCurso = new JPanel();

        txtLblCursoCodCurso = new JLabel("Nro Curso : ");
        txtFldCursoCodCurso = new JTextField(4);
        txtLblCursoNombre = new JLabel("Nombre : ");
        txtFldCursoNombre = new JTextField(50);
        txtLblCursoProf = new JLabel("Profesor : ");
        txtFldCursoProf = new JTextField(50);
    
        panelAltaCurso.add(txtLblCursoCodCurso);
        panelAltaCurso.add(txtFldCursoCodCurso);
        panelAltaCurso.add(txtLblCursoNombre);
        panelAltaCurso.add(txtFldCursoNombre);
        panelAltaCurso.add(txtLblCursoProf);
        panelAltaCurso.add(txtFldCursoProf);

        contenedor.add(panelAltaCurso);
    }

    public void pantallaAltaRecurso(){
        panelAltaRecurso = new JPanel();

        txtLblRecursoCodRec = new JLabel("Cod Recurso : ");
        txtFldRecursoCodRec = new JTextField(4);
        txtLblRecursoCategoria = new JLabel("Categoría : ");
        txtFldRecursoCategoria = new JTextField(2);
        txtLblRecursoNombre = new JLabel("Nombre : ");
        txtFldRecursoNombre = new JTextField(50);
        txtLblRecursoAutor = new JLabel("Autor : ");
        txtFldRecursoAutor = new JTextField(50);
        txtLblRecursoAnio = new JLabel("Año : ");
        txtFldRecursoAnio = new JTextField(4);
        txtLblRecursoCant = new JLabel("Cant. : ");
        txtFldRecursoCant = new JTextField(3);

        panelAltaRecurso.add(txtLblRecursoCodRec);
        panelAltaRecurso.add(txtFldRecursoCodRec);
        panelAltaRecurso.add(txtLblRecursoCategoria);
        panelAltaRecurso.add(txtFldRecursoCategoria);
        panelAltaRecurso.add(txtLblRecursoNombre);
        panelAltaRecurso.add(txtFldRecursoNombre);
        panelAltaRecurso.add(txtLblRecursoAutor);
        panelAltaRecurso.add(txtFldRecursoAutor);
        panelAltaRecurso.add(txtLblRecursoAnio);
        panelAltaRecurso.add(txtFldRecursoAnio);
        panelAltaRecurso.add(txtLblRecursoCant);
        panelAltaRecurso.add(txtFldRecursoCant);

        contenedor.add(panelAltaRecurso);
    }
    
    public void mostrarPantalla(String pantalla){
        //System.out.println("La pantalla a mostrar es: " + pantalla);
        if (pantallaActual != null){
            contenedor.getContentPane().remove(pantallaActual);
            contenedor.repaint();
            //contenedor.pack();
            pantallaActual = null;
        }
        
        if (pantalla.contains("ALTA")){
            
            if (pantalla.contains("ALUMNO")){
                pantallaAltaAlumno();
            }else if (pantalla.contains("CURSOS")){
                
            }else if (pantalla.contains("PAGOS")){
                
            }else if (pantalla.contains("PRESTAMOS")){
                
            }else if (pantalla.contains("RECURSOS")){
                
            }
            
        }else if (pantalla.contains("BAJA")){
            
            if (pantalla.contains("ALUMNO")){
                
            }else if (pantalla.contains("CURSOS")){
                
            }else if (pantalla.contains("PAGOS")){
                
            }else if (pantalla.contains("PRESTAMOS")){
                
            }else if (pantalla.contains("RECURSOS")){
                
            }
            
        }else if (pantalla.contains("MODIFICACION")){
            
            if (pantalla.contains("ALUMNO")){
                
            }else if (pantalla.contains("CURSOS")){
                
            }else if (pantalla.contains("PAGOS")){
                
            }else if (pantalla.contains("PRESTAMOS")){
                
            }else if (pantalla.contains("RECURSOS")){
                
            }
            
        }
        
        contenedor.setVisible(true);
        
    }
    
    // ----- Getters inputs -----
    public String getTxtFldAlumnoNroLegajo() {
        return txtFldAlumnoNroLegajo.getText();
    }

    public String getTxtFldAlumnoNombre() {
        return txtFldAlumnoNombre.getText();
    }

    public String getTxtFldAlumnoApellido() {
        return txtFldAlumnoApellido.getText();
    }

    public String getTxtFldAlumnoFechaNacimiento() {
        return txtFldAlumnoFechaNacimiento.getText();
    }

    public String getTxtFldAlumnoNroDoc() {
        return txtFldAlumnoNroDoc.getText();
    }

    public String getTxtFldAlumnoCalle() {
        return txtFldAlumnoCalle.getText();
    }

    public String getTxtFldAlumnoNro() {
        return txtFldAlumnoNro.getText();
    }

    public String getTxtFldAlumnoPiso() {
        return txtFldAlumnoPiso.getText();
    }

    public String getTxtFldAlumnoDepartamento() {
        return txtFldAlumnoDepartamento.getText();
    }

    public String getTxtFldAlumnoCodPostal() {
        return txtFldAlumnoCodPostal.getText();
    }

    public String getTxtFldAlumnoLocalidad() {
        return txtFldAlumnoLocalidad.getText();
    }

    public String getTxtFldAlumnoTelFijo() {
        return txtFldAlumnoTelFijo.getText();
    }

    public String getTxtFldAlumnoTelCel() {
        return txtFldAlumnoTelCel.getText();
    }

    public String getTxtFldAlumnoMail() {
        return txtFldAlumnoMail.getText();
    }

    public String getTxtFldAlumnoFoto() {
        return txtFldAlumnoFoto.getText();
    }

    public String getTxtFldCursoCodCurso() {
        return txtFldCursoCodCurso.getText();
    }

    public String getTxtFldCursoNombre() {
        return txtFldCursoNombre.getText();
    }

    public String getTxtFldCursoProf() {
        return txtFldCursoProf.getText();
    }

    public String getTxtFldRecursoCodRec() {
        return txtFldRecursoCodRec.getText();
    }

    public String getTxtFldRecursoCategoria() {
        return txtFldRecursoCategoria.getText();
    }

    public String getTxtFldRecursoNombre() {
        return txtFldRecursoNombre.getText();
    }

    public String getTxtFldRecursoAutor() {
        return txtFldRecursoAutor.getText();
    }

    public String getTxtFldRecursoAnio() {
        return txtFldRecursoAnio.getText();
    }

    public String getTxtFldRecursoCant() {
        return txtFldRecursoCant.getText();
    }

    public String getTxtFldPrestamoNroLegajo() {
        return txtFldPrestamoNroLegajo.getText();
    }

    public String getTxtFldPrestamoCodRecurso() {
        return txtFldPrestamoCodRecurso.getText();
    }

    public String getTxtFldPrestamoFechaPres() {
        return txtFldPrestamoFechaPres.getText();
    }

    public String getTxtFldPrestamoFechaDevo() {
        return txtFldPrestamoFechaDevo.getText();
    }

    public String getTxtFldPrestamoFechaPrevDevo() {
        return txtFldPrestamoFechaPrevDevo.getText();
    }

    public String getTxtFldPagoNroLegajo() {
        return txtFldPagoNroLegajo.getText();
    }

    public String getTxtFldPagoCodCurso() {
        return txtFldPagoCodCurso.getText();
    }

    public String getTxtFldPagoFecha() {
        return txtFldPagoFecha.getText();
    }

    public String getTxtFldPagoImporte() {
        return txtFldPagoImporte.getText();
    }

    public String getTxtFldPagoComprobante() {
        return txtFldPagoComprobante.getText();
    }
    
    // ----- Seters inputs -----
    public void setTxtFldAlumnoNroLegajo(String txtFldAlumnoNroLegajo) {
        this.txtFldAlumnoNroLegajo.setText(txtFldAlumnoNroLegajo);
    }

    public void setTxtFldAlumnoNombre(String txtFldAlumnoNombre) {
        this.txtFldAlumnoNombre.setText(txtFldAlumnoNombre);
    }

    public void setTxtFldAlumnoApellido(String txtFldAlumnoApellido) {
        this.txtFldAlumnoApellido.setText(txtFldAlumnoApellido);
    }

    public void setTxtFldAlumnoFechaNacimiento(String txtFldAlumnoFechaNacimiento) {
        this.txtFldAlumnoFechaNacimiento.setText(txtFldAlumnoFechaNacimiento);
    }

    public void setTxtFldAlumnoNroDoc(String txtFldAlumnoNroDoc) {
        this.txtFldAlumnoNroDoc.setText(txtFldAlumnoNroDoc);
    }

    public void setTxtFldAlumnoCalle(String txtFldAlumnoCalle) {
        this.txtFldAlumnoCalle.setText(txtFldAlumnoCalle);
    }

    public void setTxtFldAlumnoNro(String txtFldAlumnoNro) {
        this.txtFldAlumnoNro.setText(txtFldAlumnoNro);
    }

    public void setTxtFldAlumnoPiso(String txtFldAlumnoPiso) {
        this.txtFldAlumnoPiso.setText(txtFldAlumnoPiso);
    }

    public void setTxtFldAlumnoDepartamento(String txtFldAlumnoDepartamento) {
        this.txtFldAlumnoDepartamento.setText(txtFldAlumnoDepartamento);
    }

    public void setTxtFldAlumnoCodPostal(String txtFldAlumnoCodPostal) {
        this.txtFldAlumnoCodPostal.setText(txtFldAlumnoCodPostal);
    }

    public void setTxtFldAlumnoLocalidad(String txtFldAlumnoLocalidad) {
        this.txtFldAlumnoLocalidad.setText(txtFldAlumnoLocalidad);
    }

    public void setTxtFldAlumnoTelFijo(String txtFldAlumnoTelFijo) {
        this.txtFldAlumnoTelFijo.setText(txtFldAlumnoTelFijo);
    }

    public void setTxtFldAlumnoTelCel(String txtFldAlumnoTelCel) {
        this.txtFldAlumnoTelCel.setText(txtFldAlumnoTelCel);
    }

    public void setTxtFldAlumnoMail(String txtFldAlumnoMail) {
        this.txtFldAlumnoMail.setText(txtFldAlumnoMail);
    }

    public void setTxtFldAlumnoFoto(String txtFldAlumnoFoto) {
        this.txtFldAlumnoFoto.setText(txtFldAlumnoFoto);
    }

    public void setTxtFldCursoCodCurso(String txtFldCursoCodCurso) {
        this.txtFldCursoCodCurso.setText(txtFldCursoCodCurso);
    }

    public void setTxtFldCursoNombre(String txtFldCursoNombre) {
        this.txtFldCursoNombre.setText(txtFldCursoNombre);
    }

    public void setTxtFldCursoProf(String txtFldCursoProf) {
        this.txtFldCursoProf.setText(txtFldCursoProf);
    }

    public void setTxtFldRecursoCodRec(String txtFldRecursoCodRec) {
        this.txtFldRecursoCodRec.setText(txtFldRecursoCodRec);
    }

    public void setTxtFldRecursoCategoria(String txtFldRecursoCategoria) {
        this.txtFldRecursoCategoria.setText(txtFldRecursoCategoria);
    }

    public void setTxtFldRecursoAutor(String txtFldRecursoAutor) {
        this.txtFldRecursoAutor.setText(txtFldRecursoAutor);
    }

    public void setTxtFldRecursoAnio(String txtFldRecursoAnio) {
        this.txtFldRecursoAnio.setText(txtFldRecursoAnio);
    }

    public void setTxtFldRecursoCant(String txtFldRecursoCant) {
        this.txtFldRecursoCant.setText(txtFldRecursoCant);
    }

    public void setTxtFldPrestamoNroLegajo(String txtFldPrestamoNroLegajo) {
        this.txtFldPrestamoNroLegajo.setText(txtFldPrestamoNroLegajo);
    }

    public void setTxtFldPrestamoCodRecurso(String txtFldPrestamoCodRecurso) {
        this.txtFldPrestamoCodRecurso.setText(txtFldPrestamoCodRecurso);
    }

    public void setTxtFldPrestamoFechaPres(String txtFldPrestamoFechaPres) {
        this.txtFldPrestamoFechaPres.setText(txtFldPrestamoFechaPres);
    }

    public void setTxtFldPrestamoFechaDevo(String txtFldPrestamoFechaDevo) {
        this.txtFldPrestamoFechaDevo.setText(txtFldPrestamoFechaDevo);
    }

    public void setTxtFldPrestamoFechaPrevDevo(String txtFldPrestamoFechaPrevDevo) {
        this.txtFldPrestamoFechaPrevDevo.setText(txtFldPrestamoFechaPrevDevo);
    }

    public void setTxtFldPagoNroLegajo(String txtFldPagoNroLegajo) {
        this.txtFldPagoNroLegajo.setText(txtFldPagoNroLegajo);
    }

    public void setTxtFldPagoCodCurso(String txtFldPagoCodCurso) {
        this.txtFldPagoCodCurso.setText(txtFldPagoCodCurso);
    }

    public void setTxtFldPagoFecha(String txtFldPagoFecha) {
        this.txtFldPagoFecha.setText(txtFldPagoFecha);
    }

    public void setTxtFldPagoImporte(String txtFldPagoImporte) {
        this.txtFldPagoImporte.setText(txtFldPagoImporte);
    }

    public void setTxtFldPagoComprobante(String txtFldPagoComprobante) {
        this.txtFldPagoComprobante.setText(txtFldPagoComprobante);
    }
    
        
    // ----- Listeners ----- 
    
    public void mostrarAltaAlumno(ActionListener al) {
        addItem1_1.addActionListener(al);
    }
    
    public void addActionListenerAltaAlumno(ActionListener al){
        btnAlumnoSend.addActionListener(al);
    }
    
    public void showErrorMsg(String err){
        JOptionPane.showMessageDialog(contenedor, err);
    }

}
