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
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import conexion.conexionBD;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;



public class login extends javax.swing.JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtPassword;


	conexionBD cc=new conexionBD();
	Connection con=cc.conexion();	
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	
	
	
	public void BuscarUsuario() {
		
		int resultado=0;
		
		String pass=String.valueOf(txtPassword.getPassword());
		String usuario=txtUsuario.getText();
		String SQL="select * from usuarios where usuario='"+usuario+"' and pass='"+pass+"'";		
		
		
		
		try {

			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(SQL);
			
			if (rs.next()) {
				resultado=1;
				
				if (resultado==1) {
				
					sistema form = new sistema();
					form.setVisible(true);
					this.dispose();
				}
				
				
			}else {
				JOptionPane.showMessageDialog(null,"Error de acceso, Usuario o password no existe");
			}
			
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Error"+e.getMessage());
		}

		
		
		
		
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 380, 337);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLogin.setBounds(184, 61, 55, 17);
		contentPane.add(lblLogin);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(181, 129, 89, 17);
		contentPane.add(lblPassword);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(138, 89, 141, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(138, 166, 141, 20);
		contentPane.add(txtPassword);
		
		JButton btnIngresar = new JButton("Ingresar");
		
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BuscarUsuario();
				
			}
		});
		
		
		btnIngresar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnIngresar.setBounds(170, 216, 89, 23);
		contentPane.add(btnIngresar);
		
		lblNewLabel = new JLabel("Acceso al Sistema");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(137, 11, 153, 28);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\windows10\\eclipse-workspace\\login\\usuario.png"));
		lblNewLabel_1.setBounds(10, 11, 153, 186);
		contentPane.add(lblNewLabel_1);
	}
}
