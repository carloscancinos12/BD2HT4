
package Logica;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class Datos {
    private final String SQL_INSERT = "INSERT INTO hoja4_bases2.Datos(Nombre,Nacionalidad,Telefono)" + "VALUES(?,?,?)";
    private final String SQL_SELECT = "SELECT * FROM hoja4_bases2.Datos";
    private final String SQL_UPDATE = "UPDATE hoja4_bases2.Datos SET Nombre = ?, Nacionalidad = ?,Telefono = ? WHERE id = ?";
    private final String SQL_SEARCH = "SELECT * FROM hoja4_bases2.Datos WHERE 0 = 0 ";
    private PreparedStatement PS;
    private DefaultTableModel DT;
    private ResultSet RS;
    private final ConexionBD CN;
    private final Connection conect;
    
     public Datos() {
        PS = null;
        CN = new ConexionBD();
        conect = CN.getConnection();
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
            PS = conect.prepareStatement(SQL_INSERT);
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
    
    public int ActualizarDatos(String nombre, String nacionalidad, int telefono, int id) throws Exception {
        int res = 0;
        try {
            PS = conect.prepareStatement(SQL_UPDATE);
            PS.setString(1, nombre);
            PS.setString(2, nacionalidad);
            PS.setInt(3, telefono);
            PS.setInt(4, id);
            res = PS.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Registro Modificado..........");
                //CN.commit();
            }
        } catch (HeadlessException | SQLException e) {
            System.err.println("Error al modificar los datos en la base de datos: " + e.getMessage());
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
            PS= conect.prepareStatement(SQL_SELECT);
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
            PS= conect.prepareStatement(SQL);
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
            PS= conect.prepareStatement("commit;");
            PS.execute();
            //CN.commit();
            JOptionPane.showMessageDialog(null, "Transaccion confirmada");
        } catch (SQLException e) {
           System.out.println("Error al listar los datos..." +e.getMessage()); 
        } finally {
            PS=null;
            RS= null;
            //CN.close();
        }
        return RS;
    }
    
    public ResultSet Rollback() {
        try {
            PS= conect.prepareStatement("rollback;");
            PS.execute();
            //CN.rollback();
            JOptionPane.showMessageDialog(null, "Transaccion abortada");
        } catch (SQLException e) {
           System.out.println("Error al listar los datos..." +e.getMessage()); 
        } finally {
            PS=null;
            RS= null;
            //CN.close();
        }
        return RS;
    }
    
    public void Transaccion() {
        try {
            conect.setAutoCommit(false);
            PS= CN.getConnection().prepareStatement("START TRANSACTION;");
            PS.execute();
            JOptionPane.showMessageDialog(null, "Transaccion iniciada");
        } catch (SQLException e) {
           System.out.println("Error al iniciar transaccion..." +e.getMessage()); 
        } finally {
            PS=null;
            RS= null;
            //CN.close();
        }
    }
    
    public void NivelTran(int nivel)
    {
        String tran = "";
        System.out.printf(tran + "1\n");
        if (nivel == 1)
            {
                tran = "READ UNCOMMITTED";
            }
            else if (nivel == 2)
            {
                tran = "READ COMMITTED";
            }
            else if (nivel == 3)
            {
                tran = "REPEATABLE READ";
                System.out.printf(tran + "2\n");
            }
            else if (nivel == 4)
            {
                tran = "SERIALIZABLE";
            }
        try {
            PS = conect.prepareStatement("SET SESSION TRANSACTION ISOLATION LEVEL " + tran + ";");
            RS = PS.executeQuery();
            System.out.printf(tran + "3\n");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se ha podido actualizar el nivel de transaccion");
        } finally
        {
            PS=null;
            RS= null;
            //CN.close();
        }
    }
    
      public DefaultTableModel BuscarDatos(String nombre, String nacionalidad, String telefono) {
        String SQL = SQL_SEARCH;
        if(nombre.length() > 0)
        {
            SQL = SQL + " AND Nombre = " + nombre;
        }
        if(nacionalidad.length() > 0)
        {
            SQL = SQL + " AND Nacionalidad = " + nacionalidad;
        }
        if(telefono.length() > 0)
        {
            SQL = SQL + " AND Telefono = " + telefono;
        }
        try {
            setTitulos();
            PS= conect.prepareStatement(SQL);
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
}
