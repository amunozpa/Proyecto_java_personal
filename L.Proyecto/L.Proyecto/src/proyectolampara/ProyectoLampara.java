package proyectolampara;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.jvnet.substance.SubstanceLookAndFeel;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Font;

public class ProyectoLampara extends JFrame implements ActionListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenu mnMantenimiento;
	private JMenu mnVentas;
	private JMenu mnConfiguracin;
	private JMenu mnAyuda;
	private JMenuItem mntmSalir;
	private JMenuItem mntmConsultarLampara;
	private JMenuItem mntmModificarLampara;
	private JMenuItem mntmListarLamparas;
	private JMenuItem mntmVender;
	private JMenuItem mntmGenerarReportes;
	private JMenuItem mntmConfiDes;
	private JMenuItem mntmConfiObs;
	private JMenuItem mntmConfigurarCantidadptima;
	private JMenuItem mntmConfigurarPremioSorpresa;
	private JMenuItem mntmAcercaDeTienda;

	//declaración de variables globales
	
	// Datos mínimos del primer modelo
	public static String modelo0 = "MEDUSA";
	public static double precio0 = 135.0;
	public static int potencia0 = 60;
	public static String color0 = "Blanco";
	public static int nluces0 = 4;
	public static int cantidadVentas0 = 0; 				//Cantidad total de ventas del primer modelo
	public static int cantidadUnidades0 = 0;			//cantidad total de paquetes vendidos del primer modelo
	public static double importeModelo0 = 0;			//importe total acumulado del primer modelo
	// Datos mínimos del segundo modelo
	public static String modelo1 = "KEFREN";
	public static double precio1 = 150.0;
	public static int potencia1 = 75;
	public static String color1 = "Plata";
	public static int nluces1 = 3;
	public static int cantidadVentas1 = 0; 				//Cantidad total de ventas del primer modelo
	public static int cantidadUnidades1 = 0;			//cantidad total de paquetes vendidos del primer modelo
	public static double importeModelo1 = 0;			//importe total acumulado del primer modelo
	// Datos mínimos del tercer modelo
	public static String modelo2 = "KASK";
	public static double precio2 = 160.0;
	public static int potencia2 = 120;
	public static String color2 = "Negro";
	public static int nluces2 = 4;
	public static int cantidadVentas2 = 0; 				//Cantidad total de ventas del primer modelo
	public static int cantidadUnidades2 = 0;			//cantidad total de paquetes vendidos del primer modelo
	public static double importeModelo2 = 0;			//importe total acumulado del primer modelo
	// Datos mínimos del cuarto modelo
	public static String modelo3 = "HOT";
	public static double precio3 = 250.0;
	public static int potencia3 = 60;
	public static String color3 = "Blanco";
	public static int nluces3 = 5;
	public static int cantidadVentas3 = 0; 				//Cantidad total de ventas del primer modelo
	public static int cantidadUnidades3 = 0;			//cantidad total de paquetes vendidos del primer modelo
	public static double importeModelo3 = 0;			//importe total acumulado del primer modelo
	// Datos mínimos del quinto modelo
	public static String modelo4 = "LAIA";
	public static double precio4 = 89.0;
	public static int potencia4 = 120;
	public static String color4 = "Rojo";
	public static int nluces4 = 3;
	public static int cantidadVentas4 = 0; 				//Cantidad total de ventas del primer modelo
	public static int cantidadUnidades4 = 0;			//cantidad total de paquetes vendidos del primer modelo
	public static double importeModelo4 = 0;			//importe total acumulado del primer modelo
	// Porcentajes de descuento
	public static double porcentaje1 = 4.0;
	public static double porcentaje2 = 5.5;
	public static double porcentaje3 = 7.0;
	public static double porcentaje4 = 8.5;
	// Cantidad óptima de lámparas vendidas
	public static int cantidadOptima = 50;
	// Modelo para el cual se otorga el obsequio
	public static int modeloObsequiable = 2;
	// Cantidad mínima de lámparas adquiridas para obtener el obsequio
	public static int cantidadMinimaObsequiable = 20;
	// Obsequio
	public static String obsequio = "USB";
	// Número de cliente que recibe el premio sorpresa
	public static int numeroClienteSorpresa = 5;
	// Premio sorpresa
	public static String premioSorpresa = "Una agenda";
	//numero de cliente
	public static int numeroCliente = 0;
	//número de venta 
	public static int rotulaciónventadiaria = 0;
	
	
	//Status de conección
	public static String Us ;
	private JLabel lblUs;
	
	//modelo nuevo
	public static String cad="KASK";
	private JLabel label;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					//Uso de libreria Substances para efecto skin en ventana Jframe
					JFrame.setDefaultLookAndFeelDecorated(true);
					
					SubstanceLookAndFeel.setSkin(new org.jvnet.substance.api.skin.GeminiSkin());
					
					
					
					
					ProyectoLampara frame = new ProyectoLampara();
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
	public ProyectoLampara() {
		addKeyListener(this);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ProyectoLampara.class.getResource("/proyectolampara/iconolampara.png")));
		setTitle("Lamp S.A");
		setLocationRelativeTo(null);
		//JFrame maximizado
		setExtendedState(MAXIMIZED_BOTH);
		//fin de maximizar
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 810, 491);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(this);
		mnArchivo.add(mntmSalir);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		menuBar.add(mnMantenimiento);
		
		mntmConsultarLampara = new JMenuItem("Consultar L\u00E1mpara");
		mntmConsultarLampara.addActionListener(this);
		mnMantenimiento.add(mntmConsultarLampara);
		
		mntmModificarLampara = new JMenuItem("Modificar L\u00E1mpara");
		mntmModificarLampara.addActionListener(this);
		mnMantenimiento.add(mntmModificarLampara);
		
		mntmListarLamparas = new JMenuItem("Listar L\u00E1mparas");
		mntmListarLamparas.addActionListener(this);
		mnMantenimiento.add(mntmListarLamparas);
		
		mnVentas = new JMenu("Ventas");
		menuBar.add(mnVentas);
		
		mntmVender = new JMenuItem("Vender");
		mntmVender.addActionListener(this);
		mnVentas.add(mntmVender);
		
		mntmGenerarReportes = new JMenuItem("Generar reportes");
		mntmGenerarReportes.addActionListener(this);
		mnVentas.add(mntmGenerarReportes);
		
		mnConfiguracin = new JMenu("Configuraci\u00F3n");
		menuBar.add(mnConfiguracin);
		
		mntmConfiDes = new JMenuItem("Configurar descuentos");
		mntmConfiDes.addActionListener(this);
		mnConfiguracin.add(mntmConfiDes);
		
		mntmConfiObs = new JMenuItem("Configurar obsequio");
		mntmConfiObs.addActionListener(this);
		mnConfiguracin.add(mntmConfiObs);
		
		mntmConfigurarCantidadptima = new JMenuItem("Configurar cantidad \u00F3ptima de l\u00E1mparas vendidas");
		mntmConfigurarCantidadptima.addActionListener(this);
		mnConfiguracin.add(mntmConfigurarCantidadptima);
		
		mntmConfigurarPremioSorpresa = new JMenuItem("Configurar premio sorpresa");
		mntmConfigurarPremioSorpresa.addActionListener(this);
		mnConfiguracin.add(mntmConfigurarPremioSorpresa);
		
		mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		mntmAcercaDeTienda = new JMenuItem("Acerca de Tienda");
		mntmAcercaDeTienda.addActionListener(this);
		mnAyuda.add(mntmAcercaDeTienda);
		
		//Se invoca el nuevo fondo y se hace igual en todos los fondos en content pane
		contentPane = new Fondo("fondolamparas1.jpg");
		
		contentPane.addKeyListener(this);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblUs = new JLabel("");
		lblUs.setEnabled(false);
		lblUs.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUs.setForeground(Color.WHITE);
		lblUs.setBounds(40, 11, 188, 21);
		contentPane.add(lblUs);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(ProyectoLampara.class.getResource("/proyectolampara/Usuario.png")));
		label.setBounds(0, 0, 46, 42);
		contentPane.add(label);
		
		//Se invoca el metodo para cerrar el frame
		Cerrar();
		
		
		if(Us=="Amue Muñoz"){
			mntmModificarLampara.setEnabled(false);
		}
	}
	
	
	public void actionPerformed(ActionEvent arg0) {
		//Formato de  Status en ventana principal al loguearse
		lblUs.setText(Us);
		
		if (arg0.getSource() == mntmAcercaDeTienda) {
			actionPerformedMntmAcercaDeTienda(arg0);
		}
		if (arg0.getSource() == mntmConfigurarPremioSorpresa) {
			actionPerformedMntmConfigurarPremioSorpresa(arg0);
		}
		if (arg0.getSource() == mntmConfigurarCantidadptima) {
			actionPerformedMntmConfigurarCantidadptima(arg0);
		}
		if (arg0.getSource() == mntmConfiObs) {
			actionPerformedMntmNewMenuItem_2(arg0);
		}
		if (arg0.getSource() == mntmConfiDes) {
			actionPerformedMntmConfigurar(arg0);
		}
		if (arg0.getSource() == mntmGenerarReportes) {
			actionPerformedMntmNewMenuItem_1(arg0);
		}
		if (arg0.getSource() == mntmVender) {
			actionPerformedMntmVender(arg0);
		}
		if (arg0.getSource() == mntmListarLamparas) {
			actionPerformedMntmListarLamparas(arg0);
		}
		if (arg0.getSource() == mntmModificarLampara) {
			actionPerformedMntmNewMenuItem(arg0);
		}
		if (arg0.getSource() == mntmConsultarLampara) {
			actionPerformedMntmConsultarLampara(arg0);
		}
		if (arg0.getSource() == mntmSalir) {
			actionPerformedMntmSalir(arg0);
		}
	}
	
	//Cerrar el JFrame(clik en la "X")
		void Cerrar()
		{
			try 
			{
				this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				addWindowListener(new WindowAdapter()
				{
					public void windowClosing(WindowEvent arg0)
					{
						ConfirmarSalida();
					}
				});this.setVisible(true);
			} catch (Exception arg0) 
			{
				arg0.printStackTrace();
			}
		}
		//fin del cierre
		//Confirmar salida del programa
		void ConfirmarSalida()
		{
			int salida; 
			salida= JOptionPane.showConfirmDialog(null, "¿Desea salir?","Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			if(salida==JOptionPane.YES_OPTION){
				System.exit(0);
		}else{
				requestFocus();
			}
		}	
	
	
	
	protected void actionPerformedMntmSalir(ActionEvent arg0) {
		ConfirmarSalida();
	
	}
	protected void actionPerformedMntmConsultarLampara(ActionEvent arg0) {
		consultarlampara cl;
		cl=new consultarlampara();
		cl.setLocationRelativeTo(this);
		cl.setVisible(true);
		
		
	}
	protected void actionPerformedMntmNewMenuItem(ActionEvent arg0) {
		modificarlampara ml;
		ml=new modificarlampara();
		ml.setLocationRelativeTo(this);
		
		//Control de Acceso
		if(Us=="Amue Muñoz"){
			ml.setEnabled(false);
			ml.setVisible(false);
			JOptionPane.showMessageDialog(null,"Su perfil no tiene permiso de acceso","Aviso",JOptionPane.INFORMATION_MESSAGE);
		}else if(Us=="Yhoni Huamani"){
				ml.setEnabled(false);
				ml.setVisible(false);
				JOptionPane.showMessageDialog(null,"Su perfil no tiene permiso de acceso","Aviso",JOptionPane.INFORMATION_MESSAGE);
		}else if(Us=="Carol Paco"){
			ml.setEnabled(false);
			ml.setVisible(false);
			JOptionPane.showMessageDialog(null,"Su perfil no tiene permiso de acceso","Aviso",JOptionPane.INFORMATION_MESSAGE);
		}else if(Us=="Erik Nolazco"){
			ml.setEnabled(false);
			ml.setVisible(false);
			JOptionPane.showMessageDialog(null,"Su perfil no tiene permiso de acceso","Aviso",JOptionPane.INFORMATION_MESSAGE);
			
		}else{
			ml.setEnabled(true);
			ml.setVisible(true);
		}
		
	}
	protected void actionPerformedMntmListarLamparas(ActionEvent arg0) {
		listarlamparas ll;
		ll=new listarlamparas();
		ll.setLocationRelativeTo(this);
		ll.setVisible(true);
	}
	protected void actionPerformedMntmVender(ActionEvent arg0) {
		vender v;
		v=new vender();
		v.setLocationRelativeTo(this);
		v.setVisible(true);
	}
	protected void actionPerformedMntmNewMenuItem_1(ActionEvent arg0) {
		generarreportes gr;
		gr=new generarreportes();
		gr.setLocationRelativeTo(this);
		gr.setVisible(true);
	}
	protected void actionPerformedMntmConfigurar(ActionEvent arg0) {
		configurardescuentos cd;
		cd=new configurardescuentos();
		cd.setLocationRelativeTo(this);
		
		//Control de Acceso
				if(Us=="Amue Muñoz"){
					cd.setEnabled(false);
					cd.setVisible(false);
					JOptionPane.showMessageDialog(null,"Su perfil no tiene permiso de acceso","Aviso",JOptionPane.INFORMATION_MESSAGE);
				}else if(Us=="Yhoni Huamani"){
					cd.setEnabled(false);
					cd.setVisible(false);
					JOptionPane.showMessageDialog(null,"Su perfil no tiene permiso de acceso","Aviso",JOptionPane.INFORMATION_MESSAGE);
				}else if(Us=="Carol Paco"){
					cd.setEnabled(false);
					cd.setVisible(false);
					JOptionPane.showMessageDialog(null,"Su perfil no tiene permiso de acceso","Aviso",JOptionPane.INFORMATION_MESSAGE);
				}else if(Us=="Erik Nolazco"){
					cd.setEnabled(false);
					cd.setVisible(false);
					JOptionPane.showMessageDialog(null,"Su perfil no tiene permiso de acceso","Aviso",JOptionPane.INFORMATION_MESSAGE);
					
				}else{
					cd.setEnabled(true);
					cd.setVisible(true);
				}
	}
	protected void actionPerformedMntmNewMenuItem_2(ActionEvent arg0) {
		configurarobsequio co;
		co=new configurarobsequio();
		co.setLocationRelativeTo(this);

		//Control de Acceso
				if(Us=="Amue Muñoz"){
					co.setEnabled(false);
					co.setVisible(false);
					JOptionPane.showMessageDialog(null,"Su perfil no tiene permiso de acceso","Aviso",JOptionPane.INFORMATION_MESSAGE);
				}else if(Us=="Yhoni Huamani"){
					co.setEnabled(false);
					co.setVisible(false);
					JOptionPane.showMessageDialog(null,"Su perfil no tiene permiso de acceso","Aviso",JOptionPane.INFORMATION_MESSAGE);
				}else if(Us=="Carol Paco"){
					co.setEnabled(false);
					co.setVisible(false);
					JOptionPane.showMessageDialog(null,"Su perfil no tiene permiso de acceso","Aviso",JOptionPane.INFORMATION_MESSAGE);
				}else if(Us=="Erik Nolazco"){
					co.setEnabled(false);
					co.setVisible(false);
					JOptionPane.showMessageDialog(null,"Su perfil no tiene permiso de acceso","Aviso",JOptionPane.INFORMATION_MESSAGE);
					
				}else{
					co.setEnabled(true);
					co.setVisible(true);
				}
	}
	protected void actionPerformedMntmConfigurarCantidadptima(ActionEvent arg0) {
		configurarcantidadoptimadelamparasvendidas colv;
		colv=new configurarcantidadoptimadelamparasvendidas();
		colv.setLocationRelativeTo(this);

		//Control de Acceso
				if(Us=="Amue Muñoz"){
					colv.setEnabled(false);
					colv.setVisible(false);
					JOptionPane.showMessageDialog(null,"Su perfil no tiene permiso de acceso","Aviso",JOptionPane.INFORMATION_MESSAGE);
				}else if(Us=="Yhoni Huamani"){
					colv.setEnabled(false);
					colv.setVisible(false);
					JOptionPane.showMessageDialog(null,"Su perfil no tiene permiso de acceso","Aviso",JOptionPane.INFORMATION_MESSAGE);
				}else if(Us=="Carol Paco"){
					colv.setEnabled(false);
					colv.setVisible(false);
					JOptionPane.showMessageDialog(null,"Su perfil no tiene permiso de acceso","Aviso",JOptionPane.INFORMATION_MESSAGE);
				}else if(Us=="Erik Nolazco"){
					colv.setEnabled(false);
					colv.setVisible(false);
					JOptionPane.showMessageDialog(null,"Su perfil no tiene permiso de acceso","Aviso",JOptionPane.INFORMATION_MESSAGE);
					
				}else{
					colv.setEnabled(true);
					colv.setVisible(true);
				}
	}
	protected void actionPerformedMntmConfigurarPremioSorpresa(ActionEvent arg0) {
		configurarpremiosorpresa cps;
		cps=new configurarpremiosorpresa();
		cps.setLocationRelativeTo(this);

		//Control de Acceso
				if(Us=="Amue Muñoz"){
					cps.setEnabled(false);
					cps.setVisible(false);
					JOptionPane.showMessageDialog(null,"Su perfil no tiene permiso de acceso","Aviso",JOptionPane.INFORMATION_MESSAGE);
				}else if(Us=="Yhoni Huamani"){
					cps.setEnabled(false);
					cps.setVisible(false);
					JOptionPane.showMessageDialog(null,"Su perfil no tiene permiso de acceso","Aviso",JOptionPane.INFORMATION_MESSAGE);
				}else if(Us=="Carol Paco"){
					cps.setEnabled(false);
					cps.setVisible(false);
					JOptionPane.showMessageDialog(null,"Su perfil no tiene permiso de acceso","Aviso",JOptionPane.INFORMATION_MESSAGE);
				}else if(Us=="Erik Nolazco"){
					cps.setEnabled(false);
					cps.setVisible(false);
					JOptionPane.showMessageDialog(null,"Su perfil no tiene permiso de acceso","Aviso",JOptionPane.INFORMATION_MESSAGE);
					
				}else{
					cps.setEnabled(true);
					cps.setVisible(true);
				}
	}
	protected void actionPerformedMntmAcercaDeTienda(ActionEvent arg0) {
		acercadetienda at;
		at=new acercadetienda();
		at.setLocationRelativeTo(this);
		at.setVisible(true);
	}
	
	
	
	//validacion para solo números
	public  static void SoloNumeros(KeyEvent e){
		char c = e.getKeyChar();
		if ( Character.isLetter(c)){
			
			e.consume();
			JOptionPane.showMessageDialog(null,"Ingrese solo Números");
		}
		
		else if((int)e.getKeyChar() >=32 && (int)e.getKeyChar() <=47 ||  (int)e.getKeyChar() <=0 ||  
				
				(int)e.getKeyChar() >=58 && (int)e.getKeyChar() <=64 || 
				
				(int)e.getKeyChar()>=91 && (int)e.getKeyChar() <=96  ||
				
				(int)e.getKeyChar()>=123 && (int)e.getKeyChar() <=126 ||
				
				(int)e.getKeyChar()>=128 && (int)e.getKeyChar() <=240)
		{
			
			e.consume();
			JOptionPane.showMessageDialog(null,"Ingresar Números enteros");}
		}
	
	//validación de solo reales
	public  static void soloReales(KeyEvent e){
		char c = e.getKeyChar();
		if ( Character.isLetter(c)){
			
			e.consume();
			JOptionPane.showMessageDialog(null,"Ingrese solo Números");
		}
		
				
		else if((int)e.getKeyChar() >=32 && (int)e.getKeyChar() <=45 ||  (int)e.getKeyChar() <=0 || (int)e.getKeyChar() ==47 ||
				
				(int)e.getKeyChar() >=58 && (int)e.getKeyChar() <=64 || 
				
				(int)e.getKeyChar()>=91 && (int)e.getKeyChar() <=96  ||
				
				(int)e.getKeyChar()>=123 && (int)e.getKeyChar() <=126 ||
		
				(int)e.getKeyChar()>=128 && (int)e.getKeyChar() <=240)
		{
			
			e.consume();
			JOptionPane.showMessageDialog(null,"Ingresar solo Números Reales");}
		}
	
	//validación decimales
		public  static void Puntos (KeyEvent e , JTextField txtPuntos){
			if(!Character.isDigit(e.getKeyChar())&& e.getKeyChar()!= '.' && e.getKeyChar()!= 8 && e.getKeyChar()!= 13){
				e.consume();
				//JOptionPane.showMessageDialog(null,"Ingrese valor decimal sin espacios. Ejem:0.0","Aviso",JOptionPane.WARNING_MESSAGE);
				}

			
				
				if(e.getKeyChar()=='.'  && (txtPuntos.getText().contains(".") || txtPuntos.getText().isEmpty())){
					e.consume();
					JOptionPane.showMessageDialog(null,"Ingrese valor decimal sin espacios. Ejem:0.0","Aviso",JOptionPane.WARNING_MESSAGE);
					}			 
		}
	
	//validacion de solo letras
	public static void SoloLetras(KeyEvent arg0, JTextField txtletras ){
		char c = arg0.getKeyChar();
		if(Character.isDigit(c)){
			arg0.consume();
			JOptionPane.showMessageDialog(null,"Ingrese solo Letras","Aviso",JOptionPane.WARNING_MESSAGE);
		}if(arg0.getKeyChar()==' '  && (txtletras.getText().contains(" ") || txtletras.getText().isEmpty())){
			arg0.consume();
			JOptionPane.showMessageDialog(null,"Solo puede usar un espacio. Ejem: un lapiz","Aviso",JOptionPane.WARNING_MESSAGE);
		}
	}
	
	//Metodo para eventos de teclado
	public static void PresionarCerrar(KeyEvent e, JButton escape){
		

		char Cerrar=e.getKeyChar();
							
		//Al presionar Escape actua BtnCerrar
		if (Cerrar==KeyEvent.VK_ESCAPE)
			escape.doClick();
	} 
	
	public static void PresionarAcceder(KeyEvent e, JButton enter){

		char acceder=e.getKeyChar();
			 
		//Al presionar Enter actua BtnListar
		if (acceder==KeyEvent.VK_ENTER){
			enter.doClick();
		}
		
	}
	
	public static void PresionarOpcion(KeyEvent e, JMenu enter1){

		char acceder=e.getKeyChar();
			 
		//Al presionar Enter solo para ventana principal
		if (acceder==KeyEvent.VK_ENTER){
			enter1.doClick();
		}		
	}
		
		
	public void keyPressed(KeyEvent arg0) {
	}
	public void keyReleased(KeyEvent arg0) {
	}
	public void keyTyped(KeyEvent arg0) {
		if (arg0.getSource() == this) {
			keyTypedThis(arg0);
		}
		
	}
	// Con esto se puede acceder al menu archivo con la tecla enter
	protected void keyTypedThis(KeyEvent arg0) {
		PresionarOpcion(arg0, mnArchivo);
	}
}
