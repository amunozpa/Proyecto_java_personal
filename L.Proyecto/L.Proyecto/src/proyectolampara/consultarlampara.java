package proyectolampara;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.shaper.StandardButtonShaper;
import org.omg.CORBA.INITIALIZE;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.naming.InitialContext;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Font;

@SuppressWarnings("unused")
public class consultarlampara extends JDialog implements ActionListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new Fondo("fondoaplicacion.jpg");
	private JLabel lblModelo;
	private JLabel lblPrecio;
	private JLabel lblPotencia;
	private JLabel lblColor;
	private JLabel lblNumeroDeLuces;
	private JComboBox<?> cboModelo;
	private JTextField txtPrecio;
	private JTextField txtPotencia;
	private JTextField txtColor;
	private JTextField txtNumero;
	private JButton btnCerrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			
			
			consultarlampara dialog = new consultarlampara();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setLocationRelativeTo(null);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public consultarlampara() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ProyectoLampara.class.getResource("/proyectolampara/iconolampara.png")));
		addKeyListener(this);
		setModal(true);
		setTitle("Consulta L\u00E1mpara");
		setBounds(100, 100, 416, 189);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblModelo = new JLabel("M\u00F3delo");
		lblModelo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblModelo.setBounds(20, 21, 46, 14);
		contentPanel.add(lblModelo);
		
		lblPrecio = new JLabel("Precio (S/.)");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrecio.setBounds(20, 46, 87, 14);
		contentPanel.add(lblPrecio);
		
		lblPotencia = new JLabel("Potencia");
		lblPotencia.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPotencia.setBounds(20, 71, 87, 14);
		contentPanel.add(lblPotencia);
		
		lblColor = new JLabel("Color");
		lblColor.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblColor.setBounds(20, 96, 87, 14);
		contentPanel.add(lblColor);
		
		lblNumeroDeLuces = new JLabel("N\u00FAmero de luces");
		lblNumeroDeLuces.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNumeroDeLuces.setBounds(20, 121, 151, 14);
		contentPanel.add(lblNumeroDeLuces);
		
		cboModelo = new JComboBox();
		cboModelo.addKeyListener(this);
		cboModelo.addActionListener(this);
		cboModelo.setModel(new DefaultComboBoxModel(new String[] {"[Seleccione Item]", "MEDUSA", "KEFREN", "KASK", "HOT", "LAIA"}));
		cboModelo.setBounds(128, 18, 136, 20);
		contentPanel.add(cboModelo);
		
		txtPrecio = new JTextField();
		txtPrecio.addKeyListener(this);
		txtPrecio.setBackground(SystemColor.control);
		txtPrecio.setEditable(false);
		txtPrecio.setBounds(127, 43, 107, 20);
		contentPanel.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		txtPotencia = new JTextField();
		txtPotencia.addKeyListener(this);
		txtPotencia.setEditable(false);
		txtPotencia.setBounds(127, 68, 107, 20);
		contentPanel.add(txtPotencia);
		txtPotencia.setColumns(10);
		
		txtColor = new JTextField();
		txtColor.addKeyListener(this);
		txtColor.setEditable(false);
		txtColor.setBounds(127, 93, 107, 20);
		contentPanel.add(txtColor);
		txtColor.setColumns(10);
		
		txtNumero = new JTextField();
		txtNumero.addKeyListener(this);
		txtNumero.setEditable(false);
		txtNumero.setBounds(127, 118, 107, 20);
		contentPanel.add(txtNumero);
		txtNumero.setColumns(10);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(301, 17, 89, 23);
		contentPanel.add(btnCerrar);
	}
	

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == cboModelo) {
			actionPerformedComboBox(arg0);
		}
		if (arg0.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(arg0);
		}
	}
	//programar el boton borrar
	protected void actionPerformedBtnCerrar(ActionEvent arg0) {
		dispose();
		
	}
	
	//programar la seleccion combobox
	protected void actionPerformedComboBox(ActionEvent arg0) {
		int mode;
		
		//entrada de datos
		mode=getModelo();
		if(mode==0){
			
			resetearValores();
			//mensaje("Seleccione una opcion","Aviso");
					
		}
		else{
			
		//Salida de resultados
			
		mostrarResultados(mode);
		}			
	}
	
	//metodos para entrada de datos
	int getModelo(){
		return cboModelo.getSelectedIndex();
	}
	
	//metodos para salida de resultados
		
	void mensaje(String text1,String text2){
		JOptionPane.showMessageDialog(null,text1,text2,JOptionPane.ERROR_MESSAGE);
	}
	
	void resetearValores(){
		txtPrecio.setText("");
		txtPotencia.setText("");
		txtColor.setText("");
		txtNumero.setText("");
		txtPrecio.setBackground(SystemColor.control);
		txtPotencia.setBackground(SystemColor.control);
		txtColor.setBackground(SystemColor.control);
		txtNumero.setBackground(SystemColor.control);
	}
	
	void mostrarResultados (int mode1){
		txtPrecio.setBackground(Color.WHITE);
		txtPotencia.setBackground(Color.WHITE);
		txtColor.setBackground(Color.WHITE);
		txtNumero.setBackground(Color.WHITE);
		switch (mode1) {
		case 1:
			txtPrecio.setText(""+ProyectoLampara.precio0);
			txtPotencia.setText(""+ProyectoLampara.potencia0);
			txtColor.setText(""+ProyectoLampara.color0);
			txtNumero.setText(""+ProyectoLampara.nluces0);
			break;
		case 2:
			txtPrecio.setText(""+ProyectoLampara.precio1);
			txtPotencia.setText(""+ProyectoLampara.potencia1);
			txtColor.setText(""+ProyectoLampara.color1);
			txtNumero.setText(""+ProyectoLampara.nluces1);
			break;
		case 3:
			txtPrecio.setText(""+ProyectoLampara.precio2);
			txtPotencia.setText(""+ProyectoLampara.potencia2);
			txtColor.setText(""+ProyectoLampara.color2);
			txtNumero.setText(""+ProyectoLampara.nluces2);
			break;
		case 4:
			txtPrecio.setText(""+ProyectoLampara.precio3);
			txtPotencia.setText(""+ProyectoLampara.potencia3);
			txtColor.setText(""+ProyectoLampara.color3);
			txtNumero.setText(""+ProyectoLampara.nluces3);
			break;
		case 5:
			txtPrecio.setText(""+ProyectoLampara.precio4);
			txtPotencia.setText(""+ProyectoLampara.potencia4);
			txtColor.setText(""+ProyectoLampara.color4);
			txtNumero.setText(""+ProyectoLampara.nluces4);
			break;
		default:
			txtPrecio.setText("");
			txtPotencia.setText("");
			txtColor.setText("");
			txtNumero.setText("");
			txtPrecio.setBackground(SystemColor.control);
			txtPotencia.setBackground(SystemColor.control);
			txtColor.setBackground(SystemColor.control);
			txtNumero.setBackground(SystemColor.control);
			
			break;
		}
}
	
	//eventos de teclado 
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtNumero) {
			keyTypedTxtNumero(e);
		}
		if (e.getSource() == txtColor) {
			keyTypedTxtColor(e);
		}
		if (e.getSource() == txtPotencia) {
			keyTypedTxtPotencia(e);
		}
		if (e.getSource() == txtPrecio) {
			keyTypedTxtPrecio(e);
		}
		if (e.getSource() == cboModelo) {
			keyTypedCboModelo(e);
		}
		if (e.getSource() == this) {
			keyTypedThis(e);
		}
	}
	protected void keyTypedThis(KeyEvent e) {
		ProyectoLampara.PresionarCerrar(e, btnCerrar);
	}
		
	protected void keyTypedCboModelo(KeyEvent e) {
		ProyectoLampara.PresionarCerrar(e, btnCerrar);
	}
	protected void keyTypedTxtPrecio(KeyEvent e) {
		ProyectoLampara.PresionarCerrar(e, btnCerrar);
	}
	protected void keyTypedTxtPotencia(KeyEvent e) {
		ProyectoLampara.PresionarCerrar(e, btnCerrar);
	}
	protected void keyTypedTxtColor(KeyEvent e) {
		ProyectoLampara.PresionarCerrar(e, btnCerrar);
	}
	protected void keyTypedTxtNumero(KeyEvent e) {
		ProyectoLampara.PresionarCerrar(e, btnCerrar);
	}
}