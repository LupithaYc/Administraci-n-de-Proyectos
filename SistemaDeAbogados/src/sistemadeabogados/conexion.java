package sistemadeabogados;

import java.sql.*;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;



/**
 *
 * @author alfredo
 */
public class conexion {
    /*Datos par ala conexión*/
    private String bd = "abogados";
    private String login = "root";
    private String password = "Sigrid2102112521";
    private String url = "jdbc:mysql://localhost/"+bd;
    private Connection conn = null;
    
    public conexion(){
        try{
            //obtenemos el driver
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,login,password);
            if (conn!=null){
                JOptionPane.showMessageDialog(null,"Conexion realizada");
            }
        }catch(SQLException | ClassNotFoundException e){
            System.out.println(e);
        }
    }
    
    public Connection getConnection(){
        return this.conn;
    }
    
    /*Metodo para realizar consulta a la BDD.
    INPUT:
        table: nombre de la tabla a consultar.
        field: String con los nombres de los campos a devolver.
        where: condición par ala consulta.
    output: un objeto[][] con los datos de la consulta, sino retorna NULL.
    */
    public Object[][] select(String table, String fields, String where){
        int registros = 0;
        String colname[] = fields.split(",");
        
        String q= "SELECT" + fields + "FROM " + table;
        String q2= "SELECT count(*) as total FROM " + table;
        if(where!=null){
            q+= " WHERE " + where;
            q2+= " WHERE " + where;
        }
        try{
            PreparedStatement pstm = conn.prepareStatement(q2);
            try (ResultSet res = pstm.executeQuery()) {
                res.next();
                registros = res.getInt("total");
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        
        Object[][] data = new String[registros][fields.split(",").length];
        
        try{
            PreparedStatement pstm = conn.prepareStatement(q);
            try (ResultSet res = pstm.executeQuery()) {
                int i = 0;
                while(res.next()){
                    for(int j=0; j<=fields.split(",").length-1;j++){
                        data[i][j] = res.getString(colname[j].trim());
                    }
                    i++;
                }
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return data;
    }
    
    //Metodo para insertar un registro en la BDD.
    public boolean insert(String table, String fields, String values){
        boolean res=false;
        String q = "INSERT INTO"+table+"("+fields+") VALUES ("+values+")";
        //se ejecuta la consulta.
        try{
            try (PreparedStatement pstm = conn.prepareStatement(q)) {
                pstm.execute();
            }
            res= true;
        }catch(SQLException e){
            System.out.println(e);
        }
        return res;
    }
    
    public void Update(String tabla, String valor, String columna,String condicion){
        String u = " UPDATE "+tabla+ " SET "+columna+ "=" +valor+ "where"+condicion;
        try{
            try (PreparedStatement pstm = conn.prepareStatement(u)) {
                pstm.execute();
            }
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public void desconectar(){
        conn = null;
        JOptionPane.showMessageDialog(null,"La conexion se ha finalizado");
    }
    
    public void eliminar(String tabla, String condicion){
        String d = "DELETE FROM " +tabla+ "where" +condicion;
        try{
            try (PreparedStatement pstm = conn.prepareStatement(d)) {
                pstm.execute();
            }
        }catch(SQLException e){
            System.out.println(e);
        }
    }
}