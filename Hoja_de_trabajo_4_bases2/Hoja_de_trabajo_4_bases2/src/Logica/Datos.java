
package Logica;

import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class Datos {
    private final String SQL_INSERT = "INSERT INTO hoja4_bases2.Datos(Nombre,Nacionalidad,Telefono)" + "VALUES(?,?,?)";
    private final String SQL_SELECT = "SELECT * FROM hoja4_bases2.Datos";
    private PreparedStatement PS;
    private DefaultTableModel DT;
    private ResultSet RS;
    private final ConexionBD CN;
    
     public Datos() {
        PS = null;
        CN = new ConexionBD();
    }
     private DefaultTableModel setTitulos() {
        DT = new DefaultTableModel();
        DT.addColumn("ID");
        DT.addColumn("Nombre");
        DT.addColumn("Nacionalidad");
        DT.addColumn("Telefono");
        return DT;
    }
     public int InsertDatos(String nombre, String nacionalidad, int telefono) throws Exception {
        int res = 0;
        try {
            PS = CN.getConnection().prepareStatement(SQL_INSERT);
            PS.setString(1, nombre);
            PS.setString(2, nacionalidad);
            PS.setInt(3, telefono);
            res = PS.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Registro Guardado..........");
                //CN.commit();
            }
        } catch (HeadlessException | SQLException e) {
            System.err.println("Error al guardar los datos en la base de datos: " + e.getMessage());
            //CN.rollback();
        } finally {
            PS = null;
            //CN.close();
        }

        return res;
    }
     public DefaultTableModel getDatos() {
        try {
            setTitulos();
            PS= CN.getConnection().prepareStatement(SQL_SELECT);
            RS = PS.executeQuery();
            Object[] fila = new Object[4];
            while(RS.next())
            {
                fila[0]=RS.getInt(1);
                fila[1]=RS.getString(2);
                fila[2]=RS.getString(3);
                fila[3]=RS.getInt(4);
                DT.addRow(fila);
            }
        } catch (SQLException e) {
           System.out.println("Error al listar los datos..." +e.getMessage()); 
        } finally {
            PS=null;
            RS= null;
            //CN.close();
        }
        return DT;
    }
      public DefaultTableModel getDato(int ctr, String prm) {
        String SQL;
        if(ctr==0)
        {
            SQL="SELECT * FROM hoja4_bases2.Datos WHERE ID="+prm;
        }
        else
        {
            SQL="SELECT * FROM hoja4_bases2.Datos WHERE Codigo like'"+prm+"%'";
        }
        try {
            setTitulos();
            PS= CN.getConnection().prepareStatement(SQL);
            RS = PS.executeQuery();
            Object[] fila = new Object[4];
            while(RS.next())
            {
                fila[0]=RS.getInt(1);
                fila[1]=RS.getString(2);
                fila[2]=RS.getString(3);
                fila[3]=RS.getInt(4);
                DT.addRow(fila);
            }
        } catch (SQLException e) {
           System.out.println("Error al listar los datos..." +e.getMessage()); 
        } finally {
            PS=null;
            RS= null;
            //CN.close();
        }
        return DT;
    }
      
    public ResultSet Commit() {
        try {
            PS= CN.getConnection().prepareStatement("commit;");
            RS = PS.executeQuery();
            CN.commit();
        } catch (SQLException e) {
           System.out.println("Error al listar los datos..." +e.getMessage()); 
        } finally {
            PS=null;
            RS= null;
            CN.close();
        }
        return RS;
    }
    
    public ResultSet Rollback() {
        try {
            PS= CN.getConnection().prepareStatement("rollback;");
            RS = PS.executeQuery();
            CN.rollback();
        } catch (SQLException e) {
           System.out.println("Error al listar los datos..." +e.getMessage()); 
        } finally {
            PS=null;
            RS= null;
            CN.close();
        }
        return RS;
    }
}
