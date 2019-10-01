package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private Connection cn;

    public void Conexion() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            cn = DriverManager.getConnection("jdbc:oracle:thin:@35.209.230.152:1521:XE", "SYSTEM", "root");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error:" + e);
        }
    }

    public void Cerrar() throws SQLException {
        if (cn != null) {
            if (cn.isClosed() == false) {
                cn.close();
            }
        }
    }

    public static void main(String[] args) {
        Conexion dao = new Conexion();
        dao.Conexion();
        if (dao.getCn()!= null) {
            System.out.println("Conectado");            
        }
    }

    /*GETTER AND SETTER*/
    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }

}
