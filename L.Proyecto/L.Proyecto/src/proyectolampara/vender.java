package proyectolampara;

import java.awt.BorderLayout;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.JScrollPane;
import java.awt.Font;

public class vender extends JDialog implements ActionListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new Fondo("fondoaplicacion.jpg");
	private JTextField txtPrecio;
	private JTextField txtCantidad;
	private JButton btnVender;
	private JComboBox<?> cboModelo;
	private JButton btnCerrar;
	private JScrollPane scrollPane;
	private JTextArea txtS;
	
			
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			vender dialog = new vender();
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
	public vender() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ProyectoLampara.class.getResource("/proyectolampara/iconolampara.png")));
		addKeyListener(this);
		setModal(true);
		setTitle("Vender");
		setBounds(100, 100, 506, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblModelo = new JLabel("Modelo");
			lblModelo.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblModelo.setBounds(10, 11, 93, 14);
			contentPanel.add(lblModelo);
		}
		{
			JLabel lblPrecio = new JLabel("Precio (S/.)");
			lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblPrecio.setBounds(10, 36, 93, 14);
			contentPanel.add(lblPrecio);
		}
		{
			JLabel lblCantidad = new JLabel("Cantidad");
			lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblCantidad.setBounds(10, 61, 93, 14);
			contentPanel.add(lblCantidad);
		}
		{
			cboModelo = new JComboBox();
			cboModelo.addKeyListener(this);
			cboModelo.addActionListener(this);
			cboModelo.setModel(new DefaultComboBoxModel(new String[] {"[Seleccione Item]", "MEDUSA", "KEFREN", "KASK", "HOT", "LAIA"}));
			cboModelo.setBounds(113, 8, 125, 20);
			contentPanel.add(cboModelo);
			
		}
		{
			txtPrecio = new JTextField();
			txtPrecio.addKeyListener(this);
			txtPrecio.setEditable(false);
			txtPrecio.setBounds(113, 33, 99, 20);
			contentPanel.add(txtPrecio);
			txtPrecio.setColumns(10);
		}
		{
			txtCantidad = new JTextField();
			txtCantidad.addKeyListener(this);
			txtCantidad.setEditable(false);
			txtCantidad.setBounds(113, 58, 99, 20);
			contentPanel.add(txtCantidad);
			txtCantidad.setColumns(10);
		}
		{
			btnVender = new JButton("Vender");
			btnVender.addActionListener(this);
			btnVender.setBounds(401, 7, 89, 23);
			contentPanel.add(btnVender);
			
		}
		{
			btnCerrar = new JButton("Cerrar");
			btnCerrar.addActionListener(this);
			btnCerrar.setBounds(401, 32, 89, 23);
			contentPanel.add(btnCerrar);
		}
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 86, 480, 174);
		contentPanel.add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
		contentPanel.add(btnVender);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(arg0);
		}
		if (arg0.getSource() == cboModelo) {
			actionPerformedComboBox(arg0);
		}
		if (arg0.getSource() == btnVender) {
			actionPerformedBtnVender(arg0);
		}
	}
	

	protected void actionPerformedComboBox(ActionEvent arg0) {
		//Declaración de datos
		 
		int mode;
		txtPrecio.setBackground(SystemColor.control);
		txtPrecio.setEditable(false);
		txtCantidad.setEditable(true);
		//entrada de datos
		mode=cboModelo.getSelectedIndex();
		//Proceso de calculo
		switch (mode) {
			
		case 1:
			txtPrecio.setText(""+ProyectoLampara.precio0); break;
		case 2:
			txtPrecio.setText(""+ProyectoLampara.precio1); break;
		case 3:
			txtPrecio.setText(""+ProyectoLampara.precio2); break;
		case 4:
			txtPrecio.setText(""+ProyectoLampara.precio3); break;
		case 5:
			txtPrecio.setText(""+ProyectoLampara.precio4); break;
		default:
			txtPrecio.setText("");
			txtPrecio.setEditable(false);
			txtCantidad.setEditable(false);
			
		}
		
	}
	
	protected void actionPerformedBtnVender(ActionEvent arg0) {
		
		//declaracion de variable
		int cant, mode;
		String obs, premio;
		double precio, icom,ides,ipag;
		
		
		try {
			//Entrada de datos
			mode=getModelo(); 
			precio=getPrecio();
			cant=getCantidad();	
		if(cant<=0){
					mensaje("Valor Invalido","Error");
					txtCantidad.setText("");
					txtCantidad.requestFocus();
		}
		else{
			
				
		
		//Proceso
		icom=CalcularImporteDeCompra(precio, cant);
		ides=CalcularImporteDeDescuento(cant, icom);
		ipag=CalcularImportePagar(icom, ides);
		obs = calcularObsequio(mode,cant);
		ProyectoLampara.numeroCliente++;
		ProyectoLampara.rotulaciónventadiaria++;
		premio = calcularPremioSorpresa(ProyectoLampara.numeroCliente);
		MostrarResultados(icom,ides,ipag,cant,obs,premio,mode,precio);
		GuardarDatos(mode, cant, ipag);
		txtCantidad.setText("");
		txtCantidad.requestFocus();
			}
		}catch (NumberFormatException e) {
			 mensaje("Ingresa valores válidos","Error");
			 txtCantidad.setText("");
			 txtCantidad.requestFocus();
		}
		
		//Scroll vertical hacia arriba
				txtS.setCaretPosition(0);
		
		
	}	
	
	
			//metodos para entrada de datos
		int getModelo(){
			return cboModelo.getSelectedIndex();
		}
		double getPrecio(){
			return Double.parseDouble(txtPrecio.getText());
		}
		int getCantidad(){
			return Integer.parseInt(txtCantidad.getText());
		}
		//metodos para proceso de calculo
		
		//metodo de calcularImporteCompra
		double CalcularImporteDeCompra(double precio1, int cant1){
			return precio1*cant1;
		}
		//metodo de calcularDescuento
		double CalcularImporteDeDescuento (int cant2, double icom1){
		if(cant2>15)
			return icom1*(ProyectoLampara.porcentaje4/100);
		else if(cant2>=11)
			return icom1*(ProyectoLampara.porcentaje3/100);
		else if(cant2>=6)
			return icom1*(ProyectoLampara.porcentaje2/100);
		else
			return icom1*(ProyectoLampara.porcentaje1/100);
		}
		//metodo de importe a pagar
		double CalcularImportePagar(double icom2, double ides1){
			return icom2-ides1;
		}
		//metodo Calculo de obsequio
		String calcularObsequio(int mode, int cant3){
		if(mode== ProyectoLampara.modeloObsequiable && cant3>=ProyectoLampara.cantidadMinimaObsequiable)
			return ProyectoLampara.obsequio;
		else
			return "";
			
		}
		//metodo Calculo de Premio sorpresa
		String calcularPremioSorpresa(int nc) {
			
			if (nc == ProyectoLampara.numeroClienteSorpresa)
				return ProyectoLampara.premioSorpresa;
			else
				return "";
		}
				
			//metodo imprimir
			void imprimir(String s){
				txtS.append(s+"\n");
			}
			//metodo control decimal
			String ft(double imp){
				DecimalFormat formatter = new DecimalFormat("0.00");
				return formatter.format(imp);
			}
			//metodo mensaje de control
			void mensaje(String text1,String text2){
				JOptionPane.showMessageDialog(null,text1,text2,JOptionPane.ERROR_MESSAGE);
			}
		
		//metodo Salida de datos
		void MostrarResultados (double icom3,double ides2,double ipag1,int cant4,String obs1,String premio1, int mode1, double precio2){
		imprimir("");
		//Al  usar append en vez de setText se repetira permitiendo tener un registro de venta completo del dia y se sabra el usuario que la efectuo
		
		txtS.setText("  REPORTE DE VENTA"+"\n\n");
		
		int modelo;
		
		modelo = cboModelo.getSelectedIndex();
		
		
		imprimir("  Número de Boleta		:  User-"+ProyectoLampara.Us+ "-2018-0"+ ProyectoLampara.rotulaciónventadiaria);
		switch(modelo){
			case 1:
				imprimir("  Modelo de la lámpara		:   "+ ProyectoLampara.modelo0);
				imprimir("  Precio unitario de la lámpara		:  S/."+ft(precio2));
				imprimir("  Cantidad de unidades adquiridas	:  "+cant4);
				
				break;
			case 2:
				imprimir("  Modelo de la lámpara		:  "+ ProyectoLampara.modelo1);
				imprimir("  Precio unitario de la lámpara		:  S/."+ft(precio2));
				imprimir("  Cantidad de unidades adquiridas	:  "+cant4);
				break;
			case 3:
				imprimir("  Modelo de la lámpara		:  "+ ProyectoLampara.modelo2);
				imprimir("  Precio unitario de la lámpara		:  S/."+ft(precio2));
				imprimir("  Cantidad de unidades adquiridas	:  "+cant4);
				break;
			case 4:
				imprimir("  Modelo de la lámpara		:  "+ ProyectoLampara.modelo3);
				imprimir("  Precio unitario de la lámpara		:  S/."+ft(precio2));
				imprimir("  Cantidad de unidades adquiridas	:  "+cant4);
				break;
			default:
				imprimir("  Modelo de la lámpara		:  "+ ProyectoLampara.modelo4);
				imprimir("  Precio unitario de la lámpara		:  S/."+ft(precio2));
				imprimir("  Cantidad de unidades adquiridas	:  "+cant4);
		}
		
		imprimir("  Importe compra		:  S/."+ft(icom3));
		imprimir("  Importe de descuento		:  S/."+ft(ides2));
		imprimir("  Importe a pagar		:  S/."+ft(ipag1));
		if(obs1!="")		
			imprimir("  Obsequio que corresponde		:  "+obs1);
		if(premio1 !="")
			imprimir("  Premio sorpresa  que corresponde	:  "+premio1);
		
		
		
		
		}
	
		
		
		//guardar datos como imput de generar reportes
		void GuardarDatos(int mode2, int cant5, double ipag2){
			switch(mode2){
				case 1:
					ProyectoLampara.cantidadVentas0++;
					ProyectoLampara.cantidadUnidades0 +=cant5;
					ProyectoLampara.importeModelo0 +=ipag2;
					break;
				case 2:
					ProyectoLampara.cantidadVentas1 ++;
					ProyectoLampara.cantidadUnidades1 +=cant5;
					ProyectoLampara.importeModelo1 +=ipag2;
					break;
				case 3:
					ProyectoLampara.cantidadVentas2 ++;
					ProyectoLampara.cantidadUnidades2 +=cant5;
					ProyectoLampara.importeModelo2 +=ipag2;
					break;
				case 4:
					ProyectoLampara.cantidadVentas3 ++;
					ProyectoLampara.cantidadUnidades3 +=cant5;
					ProyectoLampara.importeModelo3 +=ipag2;
					break;
				case 5:
					ProyectoLampara.cantidadVentas4 ++;
					ProyectoLampara.cantidadUnidades4 +=cant5;
					ProyectoLampara.importeModelo4 +=ipag2;
					break;
				default:
					txtPrecio.setText("");
					
					
			}
		}
	
	protected void actionPerformedBtnCerrar(ActionEvent arg0) {
		dispose();
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
		if (arg0.getSource() == txtPrecio) {
			
		}
		if (arg0.getSource() == txtCantidad) {
			keyTypedTxtCantidad(arg0);
		}
	}
	protected void keyTypedTxtCantidad(KeyEvent e) {
		
		ProyectoLampara.SoloNumeros(e);
		ProyectoLampara.PresionarCerrar(e, btnCerrar);
		ProyectoLampara.PresionarAcceder(e, btnVender);
			
	}
	
	protected void keyTypedCboModelo(KeyEvent e) {
		ProyectoLampara.PresionarCerrar(e, btnCerrar);
		ProyectoLampara.PresionarAcceder(e, btnVender);
		
	}
	
	protected void keyTypedThis(KeyEvent e) {
		ProyectoLampara.PresionarCerrar(e, btnCerrar);
		ProyectoLampara.PresionarAcceder(e, btnVender);
		
	}
}
	

