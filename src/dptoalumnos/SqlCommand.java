/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package SqlCommands;


import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author LA12
 */
public class SqlCommand {
    Statement instruccion;

    public SqlCommand(Connection sqlCon) {
        try {
            instruccion = sqlCon.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(SqlCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void showQuery(ResultSet rs , DefaultTableModel table){
        try {
            
            ResultSetMetaData metaDatos = rs.getMetaData();
            int numeroDeColumnas = metaDatos.getColumnCount();

            for (int i = 1; i <= numeroDeColumnas-1; i++) {
               table.addColumn(metaDatos.getColumnLabel(i));
            }
          
            while (rs.next()) {
                Object[] fila = new Object[numeroDeColumnas];
                for (int i = 1; i <= numeroDeColumnas-1; i++) {
                     fila[i]=rs.getObject(i+1);
                }
                table.addRow(fila);
            }
          
        } catch (SQLException ex) {
            Logger.getLogger(SqlCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void sotck_Mayor_a( int x , DefaultTableModel table){
        try {
           ResultSet rs= instruccion.executeQuery("Select * FROM producto Where stock > " + x + ";");
           showQuery(rs , table);
        } catch (SQLException ex) {
            Logger.getLogger(SqlCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void nombre_Empieza_Con( String x , DefaultTableModel table){
        try {
           ResultSet rs= instruccion.executeQuery("Select * FROM proveedor Where apellido Like '" + x + "%';");
           showQuery(rs  , table);
        } catch (SQLException ex) {
            Logger.getLogger(SqlCommand.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

 
}
