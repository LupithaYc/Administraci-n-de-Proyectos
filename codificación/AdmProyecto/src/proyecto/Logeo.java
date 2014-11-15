package proyecto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.AbstractButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import javax.swing.JMenuBar;

public class Logeo extends JFrame {
	private JTextField textField;
	private JPasswordField passwordField;
	private final Action action = new SwingAction();
	
   

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Logeo frame = new Logeo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Logeo() {
		setTitle("Logeo");
		getContentPane().setForeground(Color.WHITE);
		getContentPane().setEnabled(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(194, 57, 197, 25);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(194, 139, 197, 25);
		getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			
				conexion con= new conexion();
				Connection cn=con.conectar();
				String usuario,contraseña;
				String sSQL=" ";
				double sall;
				
				
			Principal obj= new Principal();
			obj.setVisible(true);
			
		
			}
		});
		btnNewButton.setBounds(299, 212, 89, 25);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setBounds(36, 62, 89, 15);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contraseña");
		lblNewLabel_1.setBounds(36, 144, 108, 15);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("¿Olvidates tu contraseña?");
		lblNewLabel_2.setBounds(58, 212, 211, 15);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("AbAs");
		lblNewLabel_3.setLabelFor(this);
		lblNewLabel_3.setToolTipText("");
		lblNewLabel_3.setFont(new Font("Droid Sans", Font.BOLD, 24));
		lblNewLabel_3.setBackground(new Color(51, 0, 204));
		lblNewLabel_3.setBounds(194, 12, 98, 26);
		getContentPane().add(lblNewLabel_3);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
