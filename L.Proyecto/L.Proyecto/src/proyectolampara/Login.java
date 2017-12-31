package proyectolampara;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jvnet.substance.SubstanceLookAndFeel;

import proyectolampara.ProyectoLampara;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;


public class Login extends JFrame implements ActionListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel btnIniciarSesion;
	private JLabel lblUsuario;
	private JLabel lblContrasea;
	private JTextField txtUs;
	private JButton btnIngresar;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					JFrame.setDefaultLookAndFeelDecorated(true);
					
					SubstanceLookAndFeel.setSkin(new org.jvnet.substance.api.skin.GeminiSkin());
					
					Login frame = new Login();
					frame.setLocationRelativeTo(null);
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
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ProyectoLampara.class.getResource("/proyectolampara/iconolampara.png")));
		setResizable(false);
		setTitle("Login-Lamp S.A");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 338, 225);
		btnIniciarSesion = new Fondo("fondolamparas.jpg");
		btnIniciarSesion.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(btnIniciarSesion);
		btnIniciarSesion.setLayout(null);
		
		lblUsuario = new JLabel("");
		lblUsuario.setIcon(new ImageIcon(Login.class.getResource("/proyectolampara/Usuario.png")));
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setBounds(58, 32, 45, 41);
		btnIniciarSesion.add(lblUsuario);
		
		lblContrasea = new JLabel("");
		lblContrasea.setIcon(new ImageIcon(Login.class.getResource("/proyectolampara/Contrase\u00F1a.png")));
		lblContrasea.setForeground(Color.WHITE);
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblContrasea.setBounds(58, 84, 45, 41);
		btnIniciarSesion.add(lblContrasea);
		
		txtUs = new JTextField();
		txtUs.addKeyListener(this);
		txtUs.setBounds(134, 40, 109, 20);
		btnIniciarSesion.add(txtUs);
		txtUs.setColumns(10);
		
		btnIngresar = new JButton("Iniciar sesi\u00F3n");
		btnIngresar.addActionListener(this);
		btnIngresar.setBounds(47, 152, 115, 23);
		btnIniciarSesion.add(btnIngresar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(172, 152, 109, 23);
		btnIniciarSesion.add(btnCancelar);
		
		passwordContr = new JPasswordField();
		passwordContr.addKeyListener(this);
		passwordContr.setBounds(134, 95, 109, 20);
		btnIniciarSesion.add(passwordContr);
		
		
	}
	
	
	private JPasswordField passwordContr;
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(arg0);
		}
		if (arg0.getSource() == btnIngresar) {
			actionPerformedBtnIngresar(arg0);
		}
	}
	
		
	@SuppressWarnings("static-access")
	protected void actionPerformedBtnIngresar(ActionEvent arg0) {
		//iniciando sesion
				String Usuario0=LeerUsuario();
				String Contraseña=LeerContraseña();
				if(Usuario0.equals("Administrador")&& Contraseña.equals("1234")){
						this.dispose();
						mensaje("Bienvenido");
						ProyectoLampara pl;
						pl = new ProyectoLampara();
						pl.setLocationRelativeTo(this);
						pl.setVisible(true);	
						pl.Us = "Administrador"; 
						pl.actionPerformed(arg0);
											
						
				}
						else if(Usuario0.equals("Erik")&& Contraseña.equals("1234")){
							this.dispose();
							mensaje("Bienvenido");
							ProyectoLampara pl;
							pl = new ProyectoLampara();
							pl.setLocationRelativeTo(this);
							pl.setVisible(true);	
							pl.Us = "Erik Nolazco"; 
							pl.actionPerformed(arg0);
						}
						else if(Usuario0.equals("Amue")&& Contraseña.equals("1234")){
							this.dispose();
							mensaje("Bienvenido");
							ProyectoLampara pl;
							pl = new ProyectoLampara();
							pl.setLocationRelativeTo(this);
							pl.setVisible(true);	
							pl.Us = "Amue Muñoz"; 
							pl.actionPerformed(arg0);
							
						}
						else if(Usuario0.equals("Yhoni")&& Contraseña.equals("1234")){
							this.dispose();
							mensaje("Bienvenido");
							ProyectoLampara pl;
							pl = new ProyectoLampara();
							pl.setLocationRelativeTo(this);
							pl.setVisible(true);	
							pl.Us = "Yhoni Huamani"; 
							pl.actionPerformed(arg0);
						}else if(Usuario0.equals("Carol")&& Contraseña.equals("1234")){
							this.dispose();
							mensaje("Bienvenido");
							ProyectoLampara pl;
							pl = new ProyectoLampara();
							pl.setLocationRelativeTo(this);
							pl.setVisible(true);	
							pl.Us = "Carol Paco"; 
							pl.actionPerformed(arg0);
						}
						
					else{
						mensaje("Datos incorrectos");
						passwordContr.setText("");
						passwordContr.requestFocus();
						txtUs.setText("");
						txtUs.requestFocus();
					}
				}

			//metodo para leer usuario
			String LeerUsuario(){
				return txtUs.getText().trim();
			}
						
			@SuppressWarnings("deprecation")
			//metodo para leer contraseña, DEPRECATION evita que el texto sea visible
			String LeerContraseña(){
				return new String(passwordContr.getText());
			}
			
			//metodo para mostrar un mensaje
				void mensaje(String s){
					JOptionPane.showMessageDialog(this,s);
				}
	
	protected void actionPerformedBtnCancelar(ActionEvent arg0) {
		System.exit(0);
	}
	public void keyPressed(KeyEvent arg0) {
	}
	public void keyReleased(KeyEvent arg0) {
	}
	public void keyTyped(KeyEvent arg0) {
		if (arg0.getSource() == passwordContr) {
			keyTypedPasswordContr(arg0);
		}
		if (arg0.getSource() == txtUs) {
			keyTypedTxtUs(arg0);
		}
	}
	protected void keyTypedTxtUs(KeyEvent arg0) {
		ProyectoLampara.PresionarAcceder(arg0, btnIngresar);
		ProyectoLampara.PresionarCerrar(arg0, btnCancelar);
		
	}
	protected void keyTypedPasswordContr(KeyEvent arg0) {
		ProyectoLampara.PresionarAcceder(arg0, btnIngresar);
		ProyectoLampara.PresionarCerrar(arg0, btnCancelar);
		
	}
}
