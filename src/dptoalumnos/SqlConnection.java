/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package myprogramsql;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LA12
 */
public class SqlConnection {
    Connection con = null ;
    public SqlConnection()  {
         try {
              //Cargar clase de controlador de base de datos
            Class.forName("com.mysql.jdbc.Driver");
            //Establecer conexion a la base de datos

             con = DriverManager.getConnection("jdbc:mysql://localhost/Empresa?user=root&password=");
             
         }catch(ClassNotFoundException e){ System.out.println("ERROR " + e);
         }catch(SQLException e){ System.out.println("ERROR " + e); }
    }

    public Connection getConnection(){
        return con;
    }

    public void Close(){
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(SqlConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
