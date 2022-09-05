package Logica;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexionBD {

    private Connection con;
    private static final String driver="com.mysql.jdbc.Driver";
    private static final String user="root"; //esto no lo toquen, todo va a ser en root supongo, si alguien le colocó otro usuario pues cambienlo
    private static final String pass="Kamado_Tanjiro_12";
    private static final String url="jdbc:mysql://localhost:3306/?user=root/Hoja_de_trabajo_4_bases2?autoReconnect=true&useSSL=false";
    
    public ConexionBD(){
        con=null;
    }
    
    public Connection getConnection() {
        try{
            Class.forName(driver);
            con= (Connection) DriverManager.getConnection(url, user, pass);
            con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement("SET SESSION TRANSACTION ISOLATION LEVEL READ COMMITTED;");
            ps.executeQuery();
            if (con!=null){
                //JOptionPane.showMessageDialog(null, "Si enlazó");//esto pueden volverlo comentario
            }
        }
        catch (ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, "NO CONECTAAA");//pueden volverlo comentario
            System.exit(0);  
        }
        return con;
    }
    
    public void close(){
        try {
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexion");
        }
    }
    
    public void commit()
    {
        try {
            con.commit();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexion");
        }
    }
    
    public void rollback()
    {
        try {
            con.rollback();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexion");
        }
    }
}

