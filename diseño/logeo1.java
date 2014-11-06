import java.awt.Container;
import java.awt.FlowLayout;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;


public class logeo extends JFrame  {
   
	
	
	JLabel lusuario,lcontraseña;
	static JTextField txtusuario;
	static JTextField txtcontraseña;
	
	JButton btguardar;
	int usuario,contraseña;
	
	
	static String url="jdbc:mysql://localhost/abogados";
	private static String driver="com.mysql.jdbc.Driver";
	private static   java.sql.Connection conn=null;
	
	
	
	public logeo(){
		super("abogados");
		Container contenedor=super.getContentPane();
		setLocationRelativeTo(null);
		contenedor.setLayout(new FlowLayout());
        lusuario=new JLabel("usuario");
        lcontraseña=new JLabel("contraseña");
        
        txtusuario=new JTextField(30);
        txtcontraseña=new JTextField(30);
        
        btguardar=new JButton("guardar");
        
        contenedor.add(lusuario);
        contenedor.add(txtusuario);
        contenedor.add(lcontraseña);
        contenedor.add(txtcontraseña);
        contenedor.add(btguardar);
        
        super.setSize(350,300);
        super.setVisible(true);
        
	
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       logeo inicio=new logeo();
       
       try{
           Class.forName(driver);
          
           conn=DriverManager.getConnection("jdbc:mysql://localhost/abogados","root", "");
         if (conn!= null)  
         {
         	System.out.println("conexion a bd exitosa");
         	Statement comando=(Statement) conn.createStatement();
         	comando.executeUpdate("insert into usuario (default,usuario,contraseña)values ('"+txtusuario.getText()+"','"+txtcontraseña.getText()+")" );
         	conn.close();
         	txtusuario.setText("");
         	txtcontraseña.setText("");
         	
		 JOptionPane.showInputDialog("se guerdo correctamente el usuario");
         }
 		}catch(SQLException e)
 		{
 			System.out.println("hubo un problema");
 		}
 		catch(ClassNotFoundException e)
 		{
 			System.out.println(e);
 		}
 	}
 	
 }
