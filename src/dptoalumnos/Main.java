package dptoalumnos;

import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        Modelo m = new Modelo();
        Vista v = new Vista();
        Controlador c = new Controlador(m, v);
        c.comenzar();
    }
}
