package formularios;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import conexion.conexionBD;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



	
public class usuarios extends javax.swing.JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtPassword;


	
	conexionBD cc=new conexionBD();
	Connection con=cc.conexion();
	private JLabel lblNewLabel;
	
	public void AgregarUsuario() {

		String SQL="insert into usuarios(usuario,pass) values (?,?)";		
		String pass=String.valueOf(txtPassword.getPassword());
		
		try {

			PreparedStatement pst=con.prepareStatement(SQL);
			pst.setString(1, txtUsuario.getText());
			pst.setString(2, pass);
			
			pst.executeUpdate();
			
			JOptionPane.showMessageDialog(null,"Registro realizado");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Error de registro"+e.getMessage());
		}

		
		
		
		
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					usuarios frame = new usuarios();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public usuarios() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLogin.setBounds(61, 65, 55, 24);
		contentPane.add(lblLogin);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(61, 113, 87, 24);
		contentPane.add(lblPassword);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(146, 69, 118, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(146, 117, 118, 20);
		contentPane.add(txtPassword);
		
		JButton btnAgregar = new JButton("Agregar Usuario");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AgregarUsuario();
				
			}
		});
		btnAgregar.setBounds(135, 186, 158, 23);
		contentPane.add(btnAgregar);
		
		lblNewLabel = new JLabel("Registro de Usuarios");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(122, 11, 169, 34);
		contentPane.add(lblNewLabel);
	}
}
