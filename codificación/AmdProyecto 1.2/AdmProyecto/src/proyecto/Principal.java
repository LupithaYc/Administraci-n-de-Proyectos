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
import java.awt.Scrollbar;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Principal extends JFrame {

	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public Principal() {
		setTitle("Principal AbAs");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 400, 650, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		JButton btnNewButton = new JButton("RegistrarClientes");
		btnNewButton.setBackground(new Color(204, 153, 102));
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			
				RegistrarClientes rc= new RegistrarClientes();
				rc.setVisible(true);
				setVisible(false);
				dispose();
				
				//BajaClientes bc= new BajaClientes();
				//bc.setVisible(true);
			}
		});
		btnNewButton.setBounds(67, 377, 158, 117);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("/home/lupitha/Imágenes/visual.jpg"));
		lblNewLabel.setBounds(22, -36, 605, 400);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Baja Clientes");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				BajaClientes bc= new BajaClientes();
				bc.setVisible(true);
			
			}
		});
		btnNewButton_1.setBackground(new Color(204, 153, 102));
		btnNewButton_1.setForeground(new Color(51, 51, 51));
		btnNewButton_1.setBounds(412, 377, 158, 117);
		contentPane.add(btnNewButton_1);
		
		
	}
}
