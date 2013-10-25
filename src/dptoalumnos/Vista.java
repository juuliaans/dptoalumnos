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
    
    public void addActionListenerAltaAlumno(ActionListener al){
        btnAlumnoSend.addActionListener(al);
    }
    
    public void showErrorMsg(String err){
        JOptionPane.showMessageDialog(contenedor, err);
    }
   
    
    

}
