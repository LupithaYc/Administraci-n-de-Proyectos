package proyecto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.JTextPane;
import javax.swing.JLabel;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import javax.swing.JComboBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RegistrarClientes extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public RegistrarClientes() {
		setTitle("Registrar Clientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 500, 550, 500);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Regresar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//Principal pc= new Principal();
			//pc.setVisible(true);
				Principal obj= new Principal();
				obj.setVisible(true);
				dispose();
			
			}
		});
		btnNewButton.setBounds(168, 419, 99, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Registrar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			try{conexion con=new conexion();
			con.conectar();
			Statement proceso;
			String insertar="insert into clientes (nombre, apellidopaterno, apellidomaterno, direccion, correo,  CP, idAgenda, Folio, NoCaso)values('" +
					textField.getText()+"','"+textField_1.getText()+"','"+textField_2.getText()+"','"+textField_3.getText()+"','"+textField_4.getText()+"');";
			proceso=(Statement)con.conectar().createStatement();
			}catch(SQLException e){
				System.out.println(e);
			}
			
			}
		});
		btnNewButton_1.setBounds(323, 419, 117, 25);
		contentPane.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(264, 24, 149, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(264, 64, 149, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(264, 95, 149, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(264, 137, 149, 19);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char x=e.getKeyChar();
				if(x<'0' || x>'9'){
					e.consume();
				}
			}
		});
		textField_4.setBounds(264, 185, 149, 19);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(38, 26, 70, 15);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Apellido Paterno");
		lblNewLabel_1.setBounds(38, 66, 138, 15);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Apellido Materno");
		lblNewLabel_2.setBounds(38, 97, 138, 15);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Direccion");
		lblNewLabel_3.setBounds(38, 137, 70, 15);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Correo");
		lblNewLabel_4.setBounds(38, 167, 70, 15);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("C.P");
		lblNewLabel_5.setBounds(38, 187, 70, 15);
		contentPane.add(lblNewLabel_5);
		
		JComboBox comboBox = new JComboBox();
		ArrayList <String>l= new ArrayList();
		try{
			conexion con=new conexion();
			con.conectar();
			PreparedStatement consulta=(PreparedStatement)con.conectar().prepareStatement("select usuario from usuario");
			ResultSet resultado=consulta.executeQuery();
			while(resultado.next()){
				l.add(resultado.getString("usuario"));
			}
		}catch(SQLException e){
			System.out.println(e);
		}
		for(String x:l){
			comboBox.addItem(x);
		}
		comboBox.setBounds(264, 216, 149, 24);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_6 = new JLabel("Agenda");
		lblNewLabel_6.setBounds(38, 221, 70, 15);
		contentPane.add(lblNewLabel_6);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(264, 255, 149, 24);
		contentPane.add(comboBox_1);
		
		JLabel lblNewLabel_7 = new JLabel("Folio");
		lblNewLabel_7.setBounds(38, 260, 70, 15);
		contentPane.add(lblNewLabel_7);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(264, 291, 149, 24);
		contentPane.add(comboBox_2);
		
		JLabel lblNewLabel_8 = new JLabel("caso");
		lblNewLabel_8.setBounds(38, 296, 70, 15);
		contentPane.add(lblNewLabel_8);
	}
	
}
