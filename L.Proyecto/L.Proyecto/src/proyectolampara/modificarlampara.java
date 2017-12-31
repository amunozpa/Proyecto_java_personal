package proyectolampara;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Font;

public class modificarlampara extends JDialog implements ActionListener, KeyListener {

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
	private JButton btnGrabar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			modificarlampara dialog = new modificarlampara();
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
	public modificarlampara() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ProyectoLampara.class.getResource("/proyectolampara/iconolampara.png")));
		addKeyListener(this);
		setModal(true);
		setTitle("Modificar L\u00E1mpara");
		setBounds(100, 100, 416, 189);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblModelo = new JLabel("Modelo");
		lblModelo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblModelo.setBounds(10, 22, 101, 14);
		contentPanel.add(lblModelo);
		
		lblPrecio = new JLabel("Precio (S/.)");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrecio.setBounds(10, 47, 101, 14);
		contentPanel.add(lblPrecio);
		
		lblPotencia = new JLabel("Potencia");
		lblPotencia.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPotencia.setBounds(10, 72, 101, 14);
		contentPanel.add(lblPotencia);
		
		lblColor = new JLabel("Color");
		lblColor.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblColor.setBounds(10, 97, 113, 14);
		contentPanel.add(lblColor);
		
		lblNumeroDeLuces = new JLabel("N\u00FAmero de luces");
		lblNumeroDeLuces.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNumeroDeLuces.setBounds(10, 122, 113, 14);
		contentPanel.add(lblNumeroDeLuces);
		
		cboModelo = new JComboBox();
		cboModelo.addKeyListener(this);
		cboModelo.addActionListener(this);
		cboModelo.setModel(new DefaultComboBoxModel(new String[] {"[Selecione Item]", "MEDUSA", "KEFREN", "KASK", "HOT", "LAIA"}));
		cboModelo.setBounds(121, 19, 124, 20);
		contentPanel.add(cboModelo);
		
		txtPrecio = new JTextField();
		txtPrecio.addKeyListener(this);
		txtPrecio.setBounds(121, 44, 102, 20);
		contentPanel.add(txtPrecio);
		txtPrecio.setEditable(false);
		txtPrecio.setColumns(10);
		
		txtPotencia = new JTextField();
		txtPotencia.addKeyListener(this);
		txtPotencia.setBounds(121, 69, 102, 20);
		contentPanel.add(txtPotencia);
		txtPotencia.setEditable(false);
		txtPotencia.setColumns(10);
		
		txtColor = new JTextField();
		txtColor.addKeyListener(this);
		txtColor.setBounds(121, 94, 102, 20);
		contentPanel.add(txtColor);
		txtColor.setEditable(false);
		txtColor.setColumns(10);
		
		txtNumero = new JTextField();
		txtNumero.addKeyListener(this);
		txtNumero.setBounds(121, 119, 102, 20);
		contentPanel.add(txtNumero);
		txtNumero.setEditable(false);
		txtNumero.setColumns(10);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(290, 18, 89, 23);
		contentPanel.add(btnCerrar);
		
		btnGrabar = new JButton("Grabar");
		btnGrabar.addActionListener(this);
		btnGrabar.setBounds(290, 43, 89, 23);
		contentPanel.add(btnGrabar);
		
	
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnGrabar) {
			actionPerformedBtnGrabar(arg0);
		}
		if (arg0.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(arg0);
		}
		if (arg0.getSource() == cboModelo) {
			actionPerformedComboBox(arg0);
		}
	}
	
	//Programar opción comboboxModelo
	protected void actionPerformedComboBox(ActionEvent arg0) {
		int mode1;
		
		//entrada de datos
		mode1=getModelo();
		if(mode1==0){
			resetearValores();		
		}
		else{
		//Salida de resultados
		mostrarResultados1(mode1);
		}			
	}
		//metodos para entrada de datos
		int getModelo(){
			return cboModelo.getSelectedIndex();
		}
		
		//metodos para salida de resultados
			
				
		void resetearValores(){
			txtPrecio.setText("");
			txtPotencia.setText("");
			txtColor.setText("");
			txtNumero.setText("");
			txtPrecio.setBackground(SystemColor.control);
			txtPotencia.setBackground(SystemColor.control);
			txtColor.setBackground(SystemColor.control);
			txtNumero.setBackground(SystemColor.control);
			txtPrecio.setEditable(false);
			txtPotencia.setEditable(false);
			txtColor.setEditable(false);
			txtNumero.setEditable(false);
			cboModelo.setSelectedIndex(0);
		}
		
		void mostrarResultados1 (int modelo1){
			txtPrecio.setBackground(Color.WHITE);
			txtPotencia.setBackground(Color.WHITE);
			txtColor.setBackground(Color.WHITE);
			txtNumero.setBackground(Color.WHITE);
			txtPrecio.setEditable(true);
			txtPotencia.setEditable(true);
			txtColor.setEditable(true);
			txtNumero.setEditable(true);
			switch (modelo1) {
			
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
				txtPrecio.setEditable(false);
				txtPotencia.setEditable(false);
				txtColor.setEditable(false);
				txtNumero.setEditable(false);
				break;
			}
		
		}
	//Programar boton cerrar
	protected void actionPerformedBtnCerrar(ActionEvent arg0) {
		dispose();
	}
	//Programar boton grabar
	protected void actionPerformedBtnGrabar(ActionEvent arg0) {
		
		//Para el boton grabar se declaro la variable global como variable local y se le dio getText para que se 
		//pueda ingresar asignando tal valor a la variable señalada  en tanto el programa quede abierto
		int mode2, npotencia=0, nnluces=0;
		double nprecio;
		
		try {
			
		mode2=getModelo();
		nprecio=getNprecio();
		if(mode2==0){
			mensaje("Seleccione una opcion","Aviso");
			resetearValores();	
		}else if(txtColor.getText().isEmpty()){
			mensaje("Valor inválido","Aviso");
			resetearValores();
		}else if(nprecio<=0){
				mensaje("Valor invalido","Aviso");
				resetearValores();
		}else if(npotencia<=0){
			mensaje("Valor invalido","Aviso");
			resetearValores();
		}else if(nnluces<=0){
		mensaje("Valor invalido","Aviso");
		resetearValores();
		}else{
		//Salida de resultados
		mostrarResultadosgrabar(mode2);
		
		mensajeConfirmacion("Datos grabados","Aviso");
		dispose();
		resetearValores();
		}
		}catch (NumberFormatException e) {
			mensaje("Valor(es) inválido(s)","Error");
			 resetearValores();
			 
		}
	}
	
	double getNprecio (){
		return Double.parseDouble(txtPrecio.getText());
	}
	int getNpotencia (){
		return Integer.parseInt(txtPotencia.getText());
	}
	int getNnluces (){
		return Integer.parseInt(txtNumero.getText());
	}
	
		
		//Se utiliza metodos usado para combo box en "getmodelo","resetearValores"
	
		//metodos para salida de resultados
		
				void mensaje(String text1,String text2){
					JOptionPane.showMessageDialog(this,text1,text2,JOptionPane.ERROR_MESSAGE);
				}
				
				void mensajeConfirmacion(String text1,String text2){
					JOptionPane.showMessageDialog(null,text1,text2,JOptionPane.CLOSED_OPTION);
				}
				
								
				void mostrarResultadosgrabar (int modelo2){
					txtPrecio.setBackground(Color.WHITE);
					txtPotencia.setBackground(Color.WHITE);
					txtColor.setBackground(Color.WHITE);
					txtNumero.setBackground(Color.WHITE);
					txtPrecio.setEditable(true);
					txtPotencia.setEditable(true);
					txtColor.setEditable(true);
					txtNumero.setEditable(true);
					
					switch (modelo2) {
					case 1:
						ProyectoLampara.precio0=Double.parseDouble(txtPrecio.getText());
						ProyectoLampara.potencia0=Integer.parseInt(txtPotencia.getText());
						ProyectoLampara.color0=txtColor.getText();
						ProyectoLampara.nluces0=Integer.parseInt(txtNumero.getText());
					
					case 2:
						ProyectoLampara.precio1=Double.parseDouble(txtPrecio.getText());
						ProyectoLampara.potencia1=Integer.parseInt(txtPotencia.getText());
						ProyectoLampara.color1=txtColor.getText();
						ProyectoLampara.nluces1=Integer.parseInt(txtNumero.getText());
						break;
					case 3:
						ProyectoLampara.precio2=Double.parseDouble(txtPrecio.getText());
						ProyectoLampara.potencia2=Integer.parseInt(txtPotencia.getText());
						ProyectoLampara.color2=txtColor.getText();
						ProyectoLampara.nluces2=Integer.parseInt(txtNumero.getText());
						break;
					case 4:
						ProyectoLampara.precio3=Double.parseDouble(txtPrecio.getText());
						ProyectoLampara.potencia3=Integer.parseInt(txtPotencia.getText());
						ProyectoLampara.color3=txtColor.getText();
						ProyectoLampara.nluces3=Integer.parseInt(txtNumero.getText());
						break;
					case 5:
						ProyectoLampara.precio4=Double.parseDouble(txtPrecio.getText());
						ProyectoLampara.potencia4=Integer.parseInt(txtPotencia.getText());
						ProyectoLampara.color4=txtColor.getText();
						ProyectoLampara.nluces4=Integer.parseInt(txtNumero.getText());
						break;
					default:
						txtPrecio.setText("");
						txtPotencia.setText("");
						txtColor.setText("");
						txtNumero.setText("");
						
						break;
					}		
		
			
			
		}
	//eventos de teclado 
	public void keyPressed(KeyEvent arg0) {
	}
	public void keyReleased(KeyEvent arg0) {
	}
	public void keyTyped(KeyEvent arg0) {
		if (arg0.getSource() == this) {
			keyTypedThis(arg0);
		}
		if (arg0.getSource() == cboModelo) {
			keyTypedCboModelo(arg0);
		}
		if (arg0.getSource() == txtPotencia) {
			keyTypedTxtPotencia(arg0);
		}
		if (arg0.getSource() == txtPrecio) {
			keyTypedTxtPrecio(arg0);
		}
		if (arg0.getSource() == txtColor) {
			keyTypedTxtColor(arg0);
		}
		if (arg0.getSource() == txtNumero) {
			keyTypedTxtNumero(arg0);
		}
	}
	
	protected void keyTypedTxtNumero(KeyEvent arg0) {
		
		ProyectoLampara.SoloNumeros(arg0);
		ProyectoLampara.PresionarCerrar(arg0, btnCerrar);
		ProyectoLampara.PresionarAcceder(arg0, btnGrabar);
		
	}
	protected void keyTypedTxtColor(KeyEvent arg0) {
		ProyectoLampara.SoloLetras(arg0, txtColor);
		ProyectoLampara.PresionarCerrar(arg0, btnCerrar);
		ProyectoLampara.PresionarAcceder(arg0, btnGrabar);
	}
	protected void keyTypedTxtPrecio(KeyEvent arg0) {
		ProyectoLampara.soloReales(arg0);
		ProyectoLampara.PresionarCerrar(arg0, btnCerrar);
		ProyectoLampara.PresionarAcceder(arg0, btnGrabar);
		ProyectoLampara.Puntos(arg0, txtPrecio);
	}
	protected void keyTypedTxtPotencia(KeyEvent arg0) {
		ProyectoLampara.SoloNumeros(arg0);
		ProyectoLampara.PresionarCerrar(arg0, btnCerrar);
		ProyectoLampara.PresionarAcceder(arg0, btnGrabar);
		
	}
	protected void keyTypedCboModelo(KeyEvent arg0) {
		
		ProyectoLampara.PresionarCerrar(arg0, btnCerrar);
		ProyectoLampara.PresionarAcceder(arg0, btnGrabar);		
	}
	protected void keyTypedThis(KeyEvent arg0) {
		ProyectoLampara.PresionarCerrar(arg0, btnCerrar);
		ProyectoLampara.PresionarAcceder(arg0, btnGrabar);
	}
}
