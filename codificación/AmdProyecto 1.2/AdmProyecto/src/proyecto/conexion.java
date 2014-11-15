package proyecto;

import java.sql.DriverManager;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;

public class conexion {

public String bd="abogados";
public String url="jdbc:mysql://localhost/abogados";
public String user="abogado";
public String contraseña="abogado1029";

public conexion(){
	
	
}

public Connection conectar(){
	
	Connection link=null;
	try{
		Class.forName("com.mysql.jdbc.Driver");
		link=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/abogados","abogado", "abogado1029");
	}catch(Exception e)
	{
		JOptionPane.showMessageDialog(null, ene);
	}
	return link;
	
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
