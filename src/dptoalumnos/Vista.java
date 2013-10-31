package dptoalumnos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
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
    private JPanel panelAlumno;
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
    private JButton btnAlumnoNext;
    private JButton btnAlumnoPrev;
    private JButton btnAlumnoSave;
    private JButton btnAlumnoDelete;

    //Pantalla Alta Curso
    private JPanel panelCurso;
    private JLabel txtLblCursoCodCurso;
    private JTextField txtFldCursoCodCurso;
    private JLabel txtLblCursoNombre;
    private JTextField txtFldCursoNombre;
    private JLabel txtLblCursoProf;
    private JTextField txtFldCursoProf;
    private JButton btnCursoSend;
    private JButton btnCursoNext;
    private JButton btnCursoPrev;
    private JButton btnCursoSave;
    private JButton btnCursoDelete;
    
    //Pantalla Alta Recurso
    private JPanel panelRecurso;
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
    private JButton btnRecursoSend;
    private JButton btnRecursoNext;
    private JButton btnRecursoPrev;
    private JButton btnRecursoSave;
    private JButton btnRecursoDelete;

    //Pantalla Alta Prestamo
    private JPanel panelPrestamo;
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
    private JButton btnPrestamoSend;
    private JButton btnPrestamoNext;
    private JButton btnPrestamoPrev;
    private JButton btnPrestamoSave;
    private JButton btnPrestamoDelete;

    //Pantalla Alta Pagos
    private JPanel panelPago;
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
    private JButton btnPagoSend;
    private JButton btnPagoNext;
    private JButton btnPagoPrev;
    private JButton btnPagoSave;
    private JButton btnPagoDelete;

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
        
        
        //disabling some items
        delItem1_1.setVisible(false);
        delItem1_4.setVisible(false);
        delItem1_5.setVisible(false);
        delItem1_2.setVisible(false);
        delItem1_3.setVisible(false);
        
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
        panelAlumno = new JPanel(new BorderLayout());
        pantallaActual = panelAlumno;
        
        JPanel formContainer = new JPanel(new BorderLayout());
        
        JPanel izquierda = new JPanel();
        JPanel derecha = new JPanel();
        
        izquierda.setLayout(new GridLayout(14, 1));
        derecha.setLayout(new GridLayout(14, 1));
        
        formContainer.add(izquierda, BorderLayout.WEST);
        formContainer.add(derecha, BorderLayout.CENTER);
        
        txtLblAlumnoNroLegajo = new JLabel("Nro Legajo : ", JLabel.RIGHT);
        txtFldAlumnoNroLegajo = new JTextField(4);
        txtLblAlumnoNombre = new JLabel("Nombre : ", JLabel.RIGHT);
        txtFldAlumnoNombre = new JTextField(20);
        txtLblAlumnoApellido = new JLabel("Apellido : ", JLabel.RIGHT);
        txtFldAlumnoApellido = new JTextField(20);
        txtLblAlumnoFechaNacimiento = new JLabel("Fecha Nacimiento : ", JLabel.RIGHT);
        txtFldAlumnoFechaNacimiento = new JTextField(10);
        txtLblAlumnoNroDoc = new JLabel("Nro Doc : ", JLabel.RIGHT);
        txtFldAlumnoNroDoc = new JTextField(10);
        txtLblAlumnoCalle = new JLabel("Calle : ", JLabel.RIGHT);
        txtFldAlumnoCalle = new JTextField(20);
        txtLblAlumnoNro = new JLabel("Nro : ", JLabel.RIGHT);
        txtFldAlumnoNro = new JTextField(5);
        txtLblAlumnoPiso = new JLabel("Piso : ", JLabel.RIGHT);
        txtFldAlumnoPiso = new JTextField(2);
        txtLblAlumnoDepartamento = new JLabel("Depto : ", JLabel.RIGHT);
        txtFldAlumnoDepartamento = new JTextField(1);
        txtLblAlumnoCodPostal = new JLabel("Cod Postal : ", JLabel.RIGHT);
        txtFldAlumnoCodPostal = new JTextField(5);
        txtLblAlumnoLocalidad = new JLabel("Localidad : ", JLabel.RIGHT);
        txtFldAlumnoLocalidad = new JTextField(20);
        txtLblAlumnoTelFijo = new JLabel("Tel Fijo : ", JLabel.RIGHT);
        txtFldAlumnoTelFijo = new JTextField(10);
        txtLblAlumnoTelCel = new JLabel("Tel Cel : ", JLabel.RIGHT);
        txtFldAlumnoTelCel = new JTextField(10);
        txtLblAlumnoMail = new JLabel("E-Mail : ", JLabel.RIGHT);
        txtFldAlumnoMail = new JTextField(20);
        btnAlumnoSend = new JButton("Enviar");
        
        izquierda.add(txtLblAlumnoNroLegajo);
        JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p1.add(txtFldAlumnoNroLegajo);
        derecha.add(p1);
        
        izquierda.add(txtLblAlumnoNombre);
        JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p2.add(txtFldAlumnoNombre);
        derecha.add(p2);
        
        izquierda.add(txtLblAlumnoApellido);
        JPanel p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p3.add(txtFldAlumnoApellido);
        derecha.add(p3);
        izquierda.add(txtLblAlumnoFechaNacimiento);
        
        JPanel p4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p4.add(txtFldAlumnoFechaNacimiento);
        derecha.add(p4);
        
        izquierda.add(txtLblAlumnoNroDoc);
        
        JPanel p5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p5.add(txtFldAlumnoNroDoc);
        derecha.add(p5);
        
        izquierda.add(txtLblAlumnoCalle);
        
        JPanel p6 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p6.add(txtFldAlumnoCalle);
        derecha.add(p6);
        
        izquierda.add(txtLblAlumnoNro);
        
        JPanel p7 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p7.add(txtFldAlumnoNro);
        derecha.add(p7);
        
        izquierda.add(txtLblAlumnoPiso);
        
        JPanel p8 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p8.add(txtFldAlumnoPiso);
        derecha.add(p8);
        
        izquierda.add(txtLblAlumnoDepartamento);
        
        JPanel p9 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p9.add(txtFldAlumnoDepartamento);
        derecha.add(p9);
        
        izquierda.add(txtLblAlumnoCodPostal);
        
        JPanel p10 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p10.add(txtFldAlumnoCodPostal);
        derecha.add(p10);
        
        izquierda.add(txtLblAlumnoLocalidad);
        
        JPanel p11 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p11.add(txtFldAlumnoLocalidad);
        derecha.add(p11);
        
        izquierda.add(txtLblAlumnoTelFijo);
        
        JPanel p12 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p12.add(txtFldAlumnoTelFijo);
        derecha.add(p12);
        
        izquierda.add(txtLblAlumnoTelCel);
        
        JPanel p13 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p13.add(txtFldAlumnoTelCel);
        derecha.add(p13);
        
        izquierda.add(txtLblAlumnoMail);
        
        JPanel p14 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p14.add(txtFldAlumnoMail);
        derecha.add(p14);
        
        JPanel submitButton = new JPanel();
        submitButton.add(btnAlumnoSend);
        
        panelAlumno.add(formContainer, BorderLayout.NORTH);
        panelAlumno.add(submitButton, BorderLayout.SOUTH);
        
        contenedor.add(panelAlumno);
    }
    
    public void pantallaModificarAlumno(){
        panelAlumno = new JPanel(new BorderLayout());
        pantallaActual = panelAlumno;
        
        //JPanel controlsContainer = new JPanel();
        
        
        JPanel formContainer = new JPanel(new BorderLayout());
        
        JPanel izquierda = new JPanel();
        JPanel derecha = new JPanel();
        
        izquierda.setLayout(new GridLayout(14, 1));
        derecha.setLayout(new GridLayout(14, 1));
        
        formContainer.add(izquierda, BorderLayout.WEST);
        formContainer.add(derecha, BorderLayout.CENTER);
        
        txtLblAlumnoNroLegajo = new JLabel("Nro Legajo : ", JLabel.RIGHT);
        txtFldAlumnoNroLegajo = new JTextField(4);
        txtLblAlumnoNombre = new JLabel("Nombre : ", JLabel.RIGHT);
        txtFldAlumnoNombre = new JTextField(20);
        txtLblAlumnoApellido = new JLabel("Apellido : ", JLabel.RIGHT);
        txtFldAlumnoApellido = new JTextField(20);
        txtLblAlumnoFechaNacimiento = new JLabel("Fecha Nacimiento : ", JLabel.RIGHT);
        txtFldAlumnoFechaNacimiento = new JTextField(10);
        txtLblAlumnoNroDoc = new JLabel("Nro Doc : ", JLabel.RIGHT);
        txtFldAlumnoNroDoc = new JTextField(10);
        txtLblAlumnoCalle = new JLabel("Calle : ", JLabel.RIGHT);
        txtFldAlumnoCalle = new JTextField(20);
        txtLblAlumnoNro = new JLabel("Nro : ", JLabel.RIGHT);
        txtFldAlumnoNro = new JTextField(5);
        txtLblAlumnoPiso = new JLabel("Piso : ", JLabel.RIGHT);
        txtFldAlumnoPiso = new JTextField(2);
        txtLblAlumnoDepartamento = new JLabel("Depto : ", JLabel.RIGHT);
        txtFldAlumnoDepartamento = new JTextField(1);
        txtLblAlumnoCodPostal = new JLabel("Cod Postal : ", JLabel.RIGHT);
        txtFldAlumnoCodPostal = new JTextField(5);
        txtLblAlumnoLocalidad = new JLabel("Localidad : ", JLabel.RIGHT);
        txtFldAlumnoLocalidad = new JTextField(20);
        txtLblAlumnoTelFijo = new JLabel("Tel Fijo : ", JLabel.RIGHT);
        txtFldAlumnoTelFijo = new JTextField(10);
        txtLblAlumnoTelCel = new JLabel("Tel Cel : ", JLabel.RIGHT);
        txtFldAlumnoTelCel = new JTextField(10);
        txtLblAlumnoMail = new JLabel("E-Mail : ", JLabel.RIGHT);
        txtFldAlumnoMail = new JTextField(20);
        
        
        izquierda.add(txtLblAlumnoNroLegajo);
        JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p1.add(txtFldAlumnoNroLegajo);
        derecha.add(p1);
        
        izquierda.add(txtLblAlumnoNombre);
        JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p2.add(txtFldAlumnoNombre);
        derecha.add(p2);
        
        izquierda.add(txtLblAlumnoApellido);
        JPanel p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p3.add(txtFldAlumnoApellido);
        derecha.add(p3);
        izquierda.add(txtLblAlumnoFechaNacimiento);
        
        JPanel p4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p4.add(txtFldAlumnoFechaNacimiento);
        derecha.add(p4);
        
        izquierda.add(txtLblAlumnoNroDoc);
        
        JPanel p5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p5.add(txtFldAlumnoNroDoc);
        derecha.add(p5);
        
        izquierda.add(txtLblAlumnoCalle);
        
        JPanel p6 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p6.add(txtFldAlumnoCalle);
        derecha.add(p6);
        
        izquierda.add(txtLblAlumnoNro);
        
        JPanel p7 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p7.add(txtFldAlumnoNro);
        derecha.add(p7);
        
        izquierda.add(txtLblAlumnoPiso);
        
        JPanel p8 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p8.add(txtFldAlumnoPiso);
        derecha.add(p8);
        
        izquierda.add(txtLblAlumnoDepartamento);
        
        JPanel p9 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p9.add(txtFldAlumnoDepartamento);
        derecha.add(p9);
        
        izquierda.add(txtLblAlumnoCodPostal);
        
        JPanel p10 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p10.add(txtFldAlumnoCodPostal);
        derecha.add(p10);
        
        izquierda.add(txtLblAlumnoLocalidad);
        
        JPanel p11 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p11.add(txtFldAlumnoLocalidad);
        derecha.add(p11);
        
        izquierda.add(txtLblAlumnoTelFijo);
        
        JPanel p12 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p12.add(txtFldAlumnoTelFijo);
        derecha.add(p12);
        
        izquierda.add(txtLblAlumnoTelCel);
        
        JPanel p13 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p13.add(txtFldAlumnoTelCel);
        derecha.add(p13);
        
        izquierda.add(txtLblAlumnoMail);
        
        JPanel p14 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p14.add(txtFldAlumnoMail);
        derecha.add(p14);
        
        JPanel actionsContainer = new JPanel();
        btnAlumnoSave = new JButton("Guardar");
        btnAlumnoDelete = new JButton("Eliminar");
        btnAlumnoPrev = new JButton("Anterior");
        btnAlumnoNext = new JButton("Siguiente");
        //actionsContainer.add(btnAlumnoDelete);
        actionsContainer.add(btnAlumnoSave);
        actionsContainer.add(btnAlumnoPrev);
        actionsContainer.add(btnAlumnoNext);
        
        //panelAlumno.add(controlsContainer, BorderLayout.NORTH);
        panelAlumno.add(formContainer, BorderLayout.NORTH);
        panelAlumno.add(actionsContainer, BorderLayout.SOUTH);
        
        contenedor.add(panelAlumno);
    }
    
    public void pantallaAltaCurso(){
        panelCurso = new JPanel(new BorderLayout());
        pantallaActual = panelCurso;
        
        JPanel formContainer = new JPanel(new BorderLayout());
        
        JPanel izquierda = new JPanel();
        JPanel derecha = new JPanel();
        
        izquierda.setLayout(new GridLayout(3, 1));
        derecha.setLayout(new GridLayout(3, 1));
        
        formContainer.add(izquierda, BorderLayout.WEST);
        formContainer.add(derecha, BorderLayout.CENTER);
        
        txtLblCursoCodCurso = new JLabel("Nro Curso : ", JLabel.RIGHT);
        txtFldCursoCodCurso = new JTextField(4);
        txtLblCursoNombre = new JLabel("Nombre : ", JLabel.RIGHT);
        txtFldCursoNombre = new JTextField(50);
        txtLblCursoProf = new JLabel("Profesor : ", JLabel.RIGHT);
        txtFldCursoProf = new JTextField(50);
        btnCursoSend = new JButton("Enviar");
        
        izquierda.add(txtLblCursoCodCurso);
        
        JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p1.add(txtFldCursoCodCurso);
        derecha.add(p1);
        
        izquierda.add(txtLblCursoNombre);
        
        JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p2.add(txtFldCursoNombre);
        derecha.add(p2);
        
        izquierda.add(txtLblCursoProf);
        
        JPanel p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p3.add(txtFldCursoProf);
        derecha.add(p3);
        
        JPanel submitButton = new JPanel();
        submitButton.add(btnCursoSend);
        
        panelCurso.add(formContainer, BorderLayout.NORTH);
        panelCurso.add(submitButton, BorderLayout.SOUTH);

        contenedor.add(panelCurso);
    }
    
    public void pantallaModificarCurso(){
        panelCurso = new JPanel(new BorderLayout());
        pantallaActual = panelCurso;

        //JPanel controlsContainer = new JPanel();
        

        //controlsContainer.add(btnCursoPrev);
        //controlsContainer.add(btnCursoNext);
        
        JPanel formContainer = new JPanel(new BorderLayout());
        
        JPanel izquierda = new JPanel();
        JPanel derecha = new JPanel();
        
        izquierda.setLayout(new GridLayout(3, 1));
        derecha.setLayout(new GridLayout(3, 1));
        
        formContainer.add(izquierda, BorderLayout.WEST);
        formContainer.add(derecha, BorderLayout.CENTER);
        
        txtLblCursoCodCurso = new JLabel("Nro Curso : ", JLabel.RIGHT);
        txtFldCursoCodCurso = new JTextField(4);
        txtLblCursoNombre = new JLabel("Nombre : ", JLabel.RIGHT);
        txtFldCursoNombre = new JTextField(20);
        txtLblCursoProf = new JLabel("Profesor : ", JLabel.RIGHT);
        txtFldCursoProf = new JTextField(20);
        
        izquierda.add(txtLblCursoCodCurso);
        
        JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p1.add(txtFldCursoCodCurso);
        derecha.add(p1);
        
        izquierda.add(txtLblCursoNombre);
        
        JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p2.add(txtFldCursoNombre);
        derecha.add(p2);
        
        izquierda.add(txtLblCursoProf);
        
        JPanel p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p3.add(txtFldCursoProf);
        derecha.add(p3);
        
        JPanel actionsContainer = new JPanel();
        btnCursoSave = new JButton("Guardar");
        btnCursoDelete = new JButton("Eliminar");
        btnCursoPrev = new JButton("Anterior");
        btnCursoNext = new JButton("Siguiente");
        
        actionsContainer.add(btnCursoSave);
        actionsContainer.add(btnCursoDelete);
        actionsContainer.add(btnCursoPrev);
        actionsContainer.add(btnCursoNext);
        
        panelCurso.add(formContainer, BorderLayout.NORTH);
        panelCurso.add(actionsContainer, BorderLayout.SOUTH);

        contenedor.add(panelCurso);
    }
    
    public void pantallaAltaPago(){
        panelPago = new JPanel(new BorderLayout());
        pantallaActual = panelPago;

        JPanel formContainer = new JPanel(new BorderLayout());
        
        JPanel izquierda = new JPanel();
        JPanel derecha = new JPanel();
        
        izquierda.setLayout(new GridLayout(5, 1));
        derecha.setLayout(new GridLayout(5, 1));
        
        formContainer.add(izquierda, BorderLayout.WEST);
        formContainer.add(derecha, BorderLayout.CENTER);
        
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
        btnPagoSend = new JButton("Enviar");
        
        izquierda.add(txtLblPagoNroLegajo);
        
        JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p1.add(txtFldPagoNroLegajo);
        derecha.add(p1);
        
        izquierda.add(txtLblPagoCodCurso);
        
        JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p2.add(txtFldPagoCodCurso);
        derecha.add(p2);
        
        izquierda.add(txtLblPagoFecha);
        
        JPanel p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p3.add(txtFldPagoFecha);
        derecha.add(p3);
        
        izquierda.add(txtLblPagoImporte);
        
        JPanel p4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p4.add(txtFldPagoImporte);
        derecha.add(p4);
        
        izquierda.add(txtLblPagoComprobante);
        
        JPanel p5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p5.add(txtFldPagoComprobante);
        derecha.add(p5);
        
        JPanel submitButton = new JPanel();
        submitButton.add(btnPagoSend);
        
        panelPago.add(formContainer, BorderLayout.NORTH);
        panelPago.add(submitButton, BorderLayout.SOUTH);
        
        contenedor.add(panelPago);

    }
    
    public void pantallaModificarPago(){
        panelPago = new JPanel(new BorderLayout());
        pantallaActual = panelPago;

        JPanel formContainer = new JPanel(new BorderLayout());
        
        JPanel izquierda = new JPanel();
        JPanel derecha = new JPanel();
        
        izquierda.setLayout(new GridLayout(5, 1));
        derecha.setLayout(new GridLayout(5, 1));
        
        formContainer.add(izquierda, BorderLayout.WEST);
        formContainer.add(derecha, BorderLayout.CENTER);
        
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
        btnPagoSend = new JButton("Enviar");
        
        izquierda.add(txtLblPagoNroLegajo);
        
        JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p1.add(txtFldPagoNroLegajo);
        derecha.add(p1);
        
        izquierda.add(txtLblPagoCodCurso);
        
        JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p2.add(txtFldPagoCodCurso);
        derecha.add(p2);
        
        izquierda.add(txtLblPagoFecha);
        
        JPanel p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p3.add(txtFldPagoFecha);
        derecha.add(p3);
        
        izquierda.add(txtLblPagoImporte);
        
        JPanel p4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p4.add(txtFldPagoImporte);
        derecha.add(p4);
        
        izquierda.add(txtLblPagoComprobante);
        
        JPanel p5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p5.add(txtFldPagoComprobante);
        derecha.add(p5);
        
        JPanel actionsContainer = new JPanel();
        btnPagoNext = new JButton("Siguiente");
        btnPagoPrev = new JButton("Anterior");
        btnPagoSave = new JButton("Guardar");
        btnPagoDelete = new JButton("Eliminar");
        
        actionsContainer.add(btnPagoSave);
        actionsContainer.add(btnPagoDelete);
        actionsContainer.add(btnPagoPrev);
        actionsContainer.add(btnPagoNext);
        
        panelPago.add(formContainer, BorderLayout.NORTH);
        panelPago.add(actionsContainer, BorderLayout.SOUTH);
        
        contenedor.add(panelPago);

    }
    
    public void pantallaAltaPrestamo(){
        panelPrestamo = new JPanel(new BorderLayout());
        
        pantallaActual = panelPrestamo;

        JPanel formContainer = new JPanel(new BorderLayout());
        
        JPanel izquierda = new JPanel();
        JPanel derecha = new JPanel();
        
        izquierda.setLayout(new GridLayout(6, 1));
        derecha.setLayout(new GridLayout(6, 1));
        
        formContainer.add(izquierda, BorderLayout.WEST);
        formContainer.add(derecha, BorderLayout.CENTER);
        
        txtLblPrestamoNroLegajo = new JLabel("Nro Legajo: ", JLabel.RIGHT);
        txtFldPrestamoNroLegajo = new JTextField(4);
        txtLblPrestamoCodRecurso = new JLabel("Cod Recurso: ", JLabel.RIGHT);
        txtFldPrestamoCodRecurso = new JTextField(4);
        txtLblPrestamoFechaPres = new JLabel("Fecha de préstamo: ", JLabel.RIGHT);
        txtFldPrestamoFechaPres = new JTextField(10);
        txtLblPrestamoFechaPrevDevo = new JLabel("Fecha prevista de devolución: ", JLabel.RIGHT);
        txtFldPrestamoFechaPrevDevo = new JTextField(10);
        txtLblPrestamoFechaDevo = new JLabel("Fecha de devolución: ", JLabel.RIGHT);
        txtFldPrestamoFechaDevo = new JTextField(10);
        btnPrestamoSend = new JButton("Enviar");
        
        izquierda.add(txtLblPrestamoNroLegajo);
                
        JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p1.add(txtFldPrestamoNroLegajo);
        derecha.add(p1);
        
        izquierda.add(txtLblPrestamoCodRecurso);
        
        JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p2.add(txtFldPrestamoCodRecurso);
        derecha.add(p2);
        izquierda.add(txtLblPrestamoFechaPres);
        
        JPanel p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p3.add(txtFldPrestamoFechaPres);
        derecha.add(p3);
                
        izquierda.add(txtLblPrestamoFechaPrevDevo);
        
        JPanel p4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p4.add(txtFldPrestamoFechaPrevDevo);
        derecha.add(p4);
                
        izquierda.add(txtLblPrestamoFechaDevo);
        
        JPanel p5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p5.add(txtFldPrestamoFechaDevo);
        derecha.add(p5);
        
        JPanel submitButton = new JPanel();
        submitButton.add(btnPrestamoSend);
        
        panelPrestamo.add(formContainer, BorderLayout.NORTH);
        panelPrestamo.add(submitButton, BorderLayout.SOUTH);
        
        contenedor.add(panelPrestamo);
    }
    
    public void pantallaModificarPrestamo(){
        panelPrestamo = new JPanel(new BorderLayout());
        
        pantallaActual = panelPrestamo;

        JPanel formContainer = new JPanel(new BorderLayout());
        
        JPanel izquierda = new JPanel();
        JPanel derecha = new JPanel();
        
        izquierda.setLayout(new GridLayout(6, 1));
        derecha.setLayout(new GridLayout(6, 1));
        
        formContainer.add(izquierda, BorderLayout.WEST);
        formContainer.add(derecha, BorderLayout.CENTER);
        
        txtLblPrestamoNroLegajo = new JLabel("Nro Legajo: ", JLabel.RIGHT);
        txtFldPrestamoNroLegajo = new JTextField(4);
        txtLblPrestamoCodRecurso = new JLabel("Cod Recurso: ", JLabel.RIGHT);
        txtFldPrestamoCodRecurso = new JTextField(4);
        txtLblPrestamoFechaPres = new JLabel("Fecha de préstamo: ", JLabel.RIGHT);
        txtFldPrestamoFechaPres = new JTextField(10);
        txtLblPrestamoFechaPrevDevo = new JLabel("Fecha prevista de devolución: ", JLabel.RIGHT);
        txtFldPrestamoFechaPrevDevo = new JTextField(10);
        txtLblPrestamoFechaDevo = new JLabel("Fecha de devolución: ", JLabel.RIGHT);
        txtFldPrestamoFechaDevo = new JTextField(10);
        btnPrestamoSend = new JButton("Enviar");
        
        izquierda.add(txtLblPrestamoNroLegajo);
                
        JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p1.add(txtFldPrestamoNroLegajo);
        derecha.add(p1);
        
        izquierda.add(txtLblPrestamoCodRecurso);
        
        JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p2.add(txtFldPrestamoCodRecurso);
        derecha.add(p2);
        izquierda.add(txtLblPrestamoFechaPres);
        
        JPanel p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p3.add(txtFldPrestamoFechaPres);
        derecha.add(p3);
                
        izquierda.add(txtLblPrestamoFechaPrevDevo);
        
        JPanel p4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p4.add(txtFldPrestamoFechaPrevDevo);
        derecha.add(p4);
                
        izquierda.add(txtLblPrestamoFechaDevo);
        
        JPanel p5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p5.add(txtFldPrestamoFechaDevo);
        derecha.add(p5);
        
        JPanel actionsContainer = new JPanel();
        btnPrestamoNext = new JButton("Siguiente");
        btnPrestamoPrev = new JButton("Anterior");
        btnPrestamoSave = new JButton("Guardar");
        //btnPrestamoDelete = new JButton("Eliminar");
        
        actionsContainer.add(btnPrestamoSave);
        //actionsContainer.add(btnPrestamoDelete);
        actionsContainer.add(btnPrestamoPrev);
        actionsContainer.add(btnPrestamoNext);
        
        panelPrestamo.add(formContainer, BorderLayout.NORTH);
        panelPrestamo.add(actionsContainer, BorderLayout.SOUTH);
        
        contenedor.add(panelPrestamo);
    }
    
    public void pantallaAltaRecurso(){
        panelRecurso = new JPanel(new BorderLayout());
        
        pantallaActual = panelRecurso;

        JPanel formContainer = new JPanel(new BorderLayout());
        
        JPanel izquierda = new JPanel();
        JPanel derecha = new JPanel();
        
        izquierda.setLayout(new GridLayout(6, 1));
        derecha.setLayout(new GridLayout(6, 1));
        
        formContainer.add(izquierda, BorderLayout.WEST);
        formContainer.add(derecha, BorderLayout.CENTER);

        txtLblRecursoCodRec = new JLabel("Cod Recurso : ", JLabel.RIGHT);
        txtFldRecursoCodRec = new JTextField(4);
        txtLblRecursoCategoria = new JLabel("Categoría : ", JLabel.RIGHT);
        txtFldRecursoCategoria = new JTextField(2);
        txtLblRecursoNombre = new JLabel("Nombre : ", JLabel.RIGHT);
        txtFldRecursoNombre = new JTextField(50);
        txtLblRecursoAutor = new JLabel("Autor : ", JLabel.RIGHT);
        txtFldRecursoAutor = new JTextField(50);
        txtLblRecursoAnio = new JLabel("Año : ", JLabel.RIGHT);
        txtFldRecursoAnio = new JTextField(4);
        txtLblRecursoCant = new JLabel("Cant. : ", JLabel.RIGHT);
        txtFldRecursoCant = new JTextField(3);
        btnRecursoSend = new JButton("Enviar");

        izquierda.add(txtLblRecursoCodRec);
        
        JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p1.add(txtFldRecursoCodRec);
        derecha.add(p1);
        
        izquierda.add(txtLblRecursoCategoria);
        
        JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p2.add(txtFldRecursoCategoria);
        derecha.add(p2);

        izquierda.add(txtLblRecursoNombre);
        
        JPanel p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p3.add(txtFldRecursoNombre);
        derecha.add(p3);
        
        izquierda.add(txtLblRecursoAutor);
        
        JPanel p4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p4.add(txtFldRecursoAutor);
        derecha.add(p4);
        
        izquierda.add(txtLblRecursoAnio);
        
        JPanel p5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p5.add(txtFldRecursoAnio);
        derecha.add(p5);
        
        izquierda.add(txtLblRecursoCant);
        
        JPanel p6 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p6.add(txtFldRecursoCant);
        derecha.add(p6);
        
        JPanel submitButton = new JPanel();
        submitButton.add(btnRecursoSend);
        
        panelRecurso.add(formContainer, BorderLayout.NORTH);
        panelRecurso.add(submitButton, BorderLayout.SOUTH);

        contenedor.add(panelRecurso);
    }
    
    public void pantallaModificarRecurso(){
        panelRecurso = new JPanel(new BorderLayout());
        
        pantallaActual = panelRecurso;

        JPanel formContainer = new JPanel(new BorderLayout());
        
        JPanel izquierda = new JPanel();
        JPanel derecha = new JPanel();
        
        izquierda.setLayout(new GridLayout(6, 1));
        derecha.setLayout(new GridLayout(6, 1));
        
        formContainer.add(izquierda, BorderLayout.WEST);
        formContainer.add(derecha, BorderLayout.CENTER);

        txtLblRecursoCodRec = new JLabel("Cod Recurso : ", JLabel.RIGHT);
        txtFldRecursoCodRec = new JTextField(4);
        txtLblRecursoCategoria = new JLabel("Categoría : ", JLabel.RIGHT);
        txtFldRecursoCategoria = new JTextField(2);
        txtLblRecursoNombre = new JLabel("Nombre : ", JLabel.RIGHT);
        txtFldRecursoNombre = new JTextField(50);
        txtLblRecursoAutor = new JLabel("Autor : ", JLabel.RIGHT);
        txtFldRecursoAutor = new JTextField(50);
        txtLblRecursoAnio = new JLabel("Año : ", JLabel.RIGHT);
        txtFldRecursoAnio = new JTextField(4);
        txtLblRecursoCant = new JLabel("Cant. : ", JLabel.RIGHT);
        txtFldRecursoCant = new JTextField(3);
        btnRecursoSend = new JButton("Enviar");

        izquierda.add(txtLblRecursoCodRec);
        
        JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p1.add(txtFldRecursoCodRec);
        derecha.add(p1);
        
        izquierda.add(txtLblRecursoCategoria);
        
        JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p2.add(txtFldRecursoCategoria);
        derecha.add(p2);

        izquierda.add(txtLblRecursoNombre);
        
        JPanel p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p3.add(txtFldRecursoNombre);
        derecha.add(p3);
        
        izquierda.add(txtLblRecursoAutor);
        
        JPanel p4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p4.add(txtFldRecursoAutor);
        derecha.add(p4);
        
        izquierda.add(txtLblRecursoAnio);
        
        JPanel p5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p5.add(txtFldRecursoAnio);
        derecha.add(p5);
        
        izquierda.add(txtLblRecursoCant);
        
        JPanel p6 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p6.add(txtFldRecursoCant);
        derecha.add(p6);
        
        JPanel actionsContainer = new JPanel();
        btnRecursoNext = new JButton("Siguiente");
        btnRecursoPrev = new JButton("Anterior");
        btnRecursoSave = new JButton("Guardar");
        //btnRecursoDelete = new JButton("Eliminar");
        
        actionsContainer.add(btnRecursoSave);
        //actionsContainer.add(btnRecursoDelete);
        actionsContainer.add(btnRecursoPrev);
        actionsContainer.add(btnRecursoNext);
        
        panelRecurso.add(formContainer, BorderLayout.NORTH);
        panelRecurso.add(actionsContainer, BorderLayout.SOUTH);

        contenedor.add(panelRecurso);
    }
    
    public void mostrarPantalla(String pantalla){
        //System.out.println("La pantalla a mostrar es: " + pantalla);
        if (pantallaActual != null){
            contenedor.getContentPane().remove(pantallaActual);
            contenedor.repaint();
            //contenedor.pack();
            pantallaActual = null;
        }
        
        if (pantalla.startsWith("ALTA")){
            pantalla = pantalla.replace("ALTA_", "");
            if (pantalla.equals("ALUMNO")){
                pantallaAltaAlumno();
            }else if (pantalla.equals("CURSOS")){
                pantallaAltaCurso();
            }else if (pantalla.equals("PAGOS")){
                pantallaAltaPago();
            }else if (pantalla.equals("PRESTAMOS")){
                pantallaAltaPrestamo();
            }else if (pantalla.equals("RECURSOS")){
                pantallaAltaRecurso();
            }
        }else if (pantalla.startsWith("MODIFICACION")){
            pantalla = pantalla.replace("MODIFICACION_", "");
            
            if (pantalla.equals("ALUMNO")){
                pantallaModificarAlumno();
            }else if (pantalla.equals("CURSOS")){
                pantallaModificarCurso();
            }else if (pantalla.equals("PAGOS")){
                pantallaModificarPago();
            }else if (pantalla.equals("PRESTAMOS")){
                pantallaModificarPrestamo();
            }else if (pantalla.equals("RECURSOS")){
                pantallaModificarRecurso();
            }
        }
        
        contenedor.setVisible(true);
        
    }
    
    // ----- Setea inputs para form modificación -----
    
    public void cargaInputsAlumno(Alumno alumno){
        setTxtFldAlumnoApellido(alumno.getApellido());
        setTxtFldAlumnoCalle(alumno.getCalle());
        setTxtFldAlumnoCodPostal(alumno.getCodPostal());
        setTxtFldAlumnoDepartamento(alumno.getDepartamento());
        setTxtFldAlumnoFechaNacimiento(alumno.getFechaNacimiento());
        setTxtFldAlumnoLocalidad(alumno.getLocalidad());
        setTxtFldAlumnoMail(alumno.geteMail());
        setTxtFldAlumnoNombre(alumno.getNombre());
        setTxtFldAlumnoNro(alumno.getNroCalle());
        setTxtFldAlumnoNroDoc(alumno.getNroDoc());
        setTxtFldAlumnoNroLegajo(alumno.getNroLegajo());
        setTxtFldAlumnoPiso(alumno.getPiso());
        setTxtFldAlumnoTelCel(alumno.getTelCel());
        setTxtFldAlumnoTelFijo(alumno.getTelFijo());
    }
    
    public void cargaInputsCurso(Curso curso){
        setTxtFldCursoCodCurso(curso.getCursoCod());
        setTxtFldCursoNombre(curso.getCursoNombre());
        setTxtFldCursoProf(curso.getCursoProf());
    }
    
    public void cargaInputsPago(Pago pago){
        setTxtFldPagoCodCurso(pago.getPagoCodCurso());
        setTxtFldPagoComprobante(pago.getPagoComprobante());
        setTxtFldPagoFecha(pago.getPagoFecha());
        setTxtFldPagoImporte(Float.toString(pago.getPagoImporte()));
        setTxtFldPagoNroLegajo(pago.getPagoNroLegajo());        
    }
    
    public void cargaInputsPrestamo(Prestamo prestamo){
        setTxtFldPrestamoCodRecurso(prestamo.getCodRecurso());
        setTxtFldPrestamoFechaDevo(prestamo.getFechaDevolucion());
        setTxtFldPrestamoFechaPres(prestamo.getFechaPrestamo());
        setTxtFldPrestamoFechaPrevDevo(prestamo.getFechaPrevistaDevolucion());
        setTxtFldPrestamoNroLegajo(prestamo.getNroLegajo());
    }
    
    public void cargaInputsRecurso(Recurso recurso){
        setTxtFldRecursoAnio(recurso.getAnio());
        setTxtFldRecursoNombre(recurso.getNombre());
        setTxtFldRecursoAutor(recurso.getAutor());
        setTxtFldRecursoCant(recurso.getCant());
        setTxtFldRecursoCategoria(recurso.getCategoria());
        setTxtFldRecursoCodRec(recurso.getCodRecurso());
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
    
    public void setTxtFldRecursoNombre(String txtFldRecursoNombre) {
        this.txtFldRecursoNombre.setText(txtFldRecursoNombre);
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
    
    public void addActionListenerAltaAlumnoSend(ActionListener al){
        btnAlumnoSend.addActionListener(al);
    }
    
    public void addActionListenerAltaCursoSend(ActionListener al){
        btnCursoSend.addActionListener(al);
    }
    
    public void addActionListenerAltaRecursoSend(ActionListener al){
        btnRecursoSend.addActionListener(al);
    }
    
    public void addActionListenerAltaPrestamoSend(ActionListener al){
        btnPrestamoSend.addActionListener(al);
    }
    
    public void addActionListenerAltaPagoSend(ActionListener al){
        btnPagoSend.addActionListener(al);
    }
    
    public void addActionListenersModificarAlumno(ActionListener save, ActionListener prev, ActionListener next){
        btnAlumnoSave.addActionListener(save);
        btnAlumnoNext.addActionListener(next);
        btnAlumnoPrev.addActionListener(prev);
    }
    
    public void addActionListenersModificarCurso(ActionListener save, ActionListener prev, ActionListener next, ActionListener delete){
        btnCursoSave.addActionListener(save);
        btnCursoNext.addActionListener(next);
        btnCursoPrev.addActionListener(prev);
        btnCursoDelete.addActionListener(delete);
    }
    
    public void addActionListenersModificarRecurso(ActionListener save, ActionListener prev, ActionListener next){
        btnRecursoSave.addActionListener(save);
        btnRecursoNext.addActionListener(next);
        btnRecursoPrev.addActionListener(prev);
    }
    
    public void addActionListenersModificarPrestamo(ActionListener save, ActionListener prev, ActionListener next){
        btnPrestamoSave.addActionListener(save);
        btnPrestamoNext.addActionListener(next);
        btnPrestamoPrev.addActionListener(prev);
    }
    
    public void addActionListenersModificarPago(ActionListener save, ActionListener prev, ActionListener next, ActionListener delete){
        btnPagoSave.addActionListener(save);
        btnPagoNext.addActionListener(next);
        btnPagoPrev.addActionListener(prev);
        btnPagoDelete.addActionListener(delete);
    }
    
    public void showErrorMsg(String err){
        JOptionPane.showMessageDialog(contenedor, err);
    }
    
    public void showSuccessMsg(String msg){
        JOptionPane.showMessageDialog(contenedor, msg);
    }

}
