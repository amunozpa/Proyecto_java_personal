package proyectolampara;

import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Font;

public class generarreportes extends JDialog implements ActionListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new Fondo("fondoaplicacion.jpg");
	private JComboBox<?> cboReporte;
	private JButton btnCerrar;
	private JScrollPane sclPane;
	private JTextArea txtS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			generarreportes dialog = new generarreportes();
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
	public generarreportes() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ProyectoLampara.class.getResource("/proyectolampara/iconolampara.png")));
		addKeyListener(this);
		setModal(true);
		setTitle("Generar Reporte");
		setBounds(100, 100, 541, 371);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblTipoDeReporte = new JLabel("Tipo de Reporte");
			lblTipoDeReporte.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblTipoDeReporte.setBounds(10, 11, 109, 14);
			contentPanel.add(lblTipoDeReporte);
		}
		{
			cboReporte = new JComboBox();
			cboReporte.addKeyListener(this);
			cboReporte.addActionListener(this);
			cboReporte.setModel(new DefaultComboBoxModel(new String[] {"Ventas por L\u00E1mpara", "L\u00E1mparas con Venta \u00D3ptima", "Precios en Relaci\u00F3n al Promedio", "Promedios, M\u00E1ximos y M\u00EDnimos"}));
			cboReporte.setBounds(117, 8, 230, 20);
			contentPanel.add(cboReporte);
		}
		{
			btnCerrar = new JButton("Cerrar");
			btnCerrar.addActionListener(this);
			btnCerrar.setBounds(426, 7, 89, 23);
			contentPanel.add(btnCerrar);
		}
		
		sclPane = new JScrollPane();
		sclPane.setBounds(10, 47, 505, 274);
		contentPanel.add(sclPane);
		
		txtS = new JTextArea();
		txtS.setEditable(false);
		txtS.addKeyListener(this);
		sclPane.setViewportView(txtS);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(arg0);
		}
		if (arg0.getSource() == cboReporte) {
			actionPerformedComboBox(arg0);
		}
	}
			
	protected void actionPerformedComboBox(ActionEvent arg0) {
		txtS.setText("");
		int gen,promedioPot,potMax,potMin;
		double promedioPre,preMax,preMin;
			gen = cboReporte.getSelectedIndex();
			promedioPre = Promedio(ProyectoLampara.precio0,ProyectoLampara.precio1,ProyectoLampara.precio2,ProyectoLampara.precio3,ProyectoLampara.precio4);
			preMin = ProMin(ProyectoLampara.precio0,ProyectoLampara.precio1,ProyectoLampara.precio2,ProyectoLampara.precio3,ProyectoLampara.precio4);
			preMax = ProMax(ProyectoLampara.precio0,ProyectoLampara.precio1,ProyectoLampara.precio2,ProyectoLampara.precio3,ProyectoLampara.precio4);
			promedioPot = Promedio2(ProyectoLampara.potencia0,ProyectoLampara.potencia1,ProyectoLampara.potencia2,ProyectoLampara.potencia3,ProyectoLampara.potencia4);
			potMin = ProMin2(ProyectoLampara.potencia0,ProyectoLampara.potencia1,ProyectoLampara.potencia2,ProyectoLampara.potencia3,ProyectoLampara.potencia4);
			potMax = PromMax2(ProyectoLampara.potencia0,ProyectoLampara.potencia1,ProyectoLampara.potencia2,ProyectoLampara.potencia3,ProyectoLampara.potencia4);
				if(gen==0){
					//VENTAS POR LAMPARA
					txtS.setText("\n");
					imprimir(ProyectoLampara.modelo0, ProyectoLampara.cantidadVentas0, ProyectoLampara.cantidadUnidades0, ProyectoLampara.importeModelo0);
					imprimir(ProyectoLampara.modelo1, ProyectoLampara.cantidadVentas1, ProyectoLampara.cantidadUnidades1, ProyectoLampara.importeModelo1);
					imprimir(ProyectoLampara.modelo2, ProyectoLampara.cantidadVentas2, ProyectoLampara.cantidadUnidades2, ProyectoLampara.importeModelo2);
					imprimir(ProyectoLampara.modelo3, ProyectoLampara.cantidadVentas3, ProyectoLampara.cantidadUnidades3, ProyectoLampara.importeModelo3);
					imprimir(ProyectoLampara.modelo4, ProyectoLampara.cantidadVentas4, ProyectoLampara.cantidadUnidades4, ProyectoLampara.importeModelo4);
				}else if(gen==1){
					//LÁMPARAS CON VENTA OPTIMA
					txtS.setText("\n");
					imprimir1(ProyectoLampara.modelo0,ProyectoLampara.cantidadUnidades0);
					imprimir1(ProyectoLampara.modelo1,ProyectoLampara.cantidadUnidades1);
					imprimir1(ProyectoLampara.modelo2,ProyectoLampara.cantidadUnidades2);
					imprimir1(ProyectoLampara.modelo3,ProyectoLampara.cantidadUnidades3);
					imprimir1(ProyectoLampara.modelo4,ProyectoLampara.cantidadUnidades4);	
				}else if(gen==2){
					//PRECIOS EN RELACION AL PROMEDIO
					txtS.setText("\n");
					imprimir2(ProyectoLampara.modelo0,ProyectoLampara.precio0,promedioPre);
					imprimir2(ProyectoLampara.modelo1,ProyectoLampara.precio1,promedioPre);
					imprimir2(ProyectoLampara.modelo2,ProyectoLampara.precio2,promedioPre);
					imprimir2(ProyectoLampara.modelo3,ProyectoLampara.precio3,promedioPre);
					imprimir2(ProyectoLampara.modelo4,ProyectoLampara.precio4,promedioPre);
					imprimir("  * Precio promedio    :  S/. "+promedioPre);		
				}else {
					//PROMEDIOS, MÁXIMOS Y MÍNIMOS
					txtS.setText("\n");
					imprimir3(promedioPre,preMin,preMax);
					imprimir4(promedioPot,potMin, potMax);		
				}
				//Scroll vertical hacia arriba
				txtS.setCaretPosition(0);
	}
	
	void imprimir(String s){
		txtS.append(s+"\n");	
	}
	
	// metodo para imprimir (Por lampara)
			void imprimir(String m, int cv, int cu, double ia) {
				imprimir("  Modelo\t\t\t:  " + m);
				imprimir("  Cantidad totalde ventas\t\t:  " + cv+" unidad(es)");
				imprimir("  Cantidad total de unidades vendidos\t:  " + cu+" unidad(es)");
				imprimir("  Importe total acumulado\t\t:  S/. " + ia + "\n");
			}
		
		// metodo para imprimir (Lamparas con venta optima)	
			void imprimir1(String m, int cu){
				if(cu >= ProyectoLampara.cantidadOptima){
					imprimir("  Modelo\t\t\t:  "+m);
					imprimir("  Cantidad total de unidades vendidas\t:  "+cu+" unidad(es)"+"\n");
				}	
				else{
					imprimir("  * El modelo "+ m +" no superó la venta óptima"+"\n");
				}
			}
		//metodo para imprimir(En relacion al promedio)
			void imprimir2(String m, double pre,double pro){
				imprimir("  Modelo\t:  "+m);
				if(pre<pro){
					imprimir("  Precio\t:  S/. "+pre+"  (menor al promedio)\n");
				}else imprimir("  Precio\t:  S/. "+pre+"  (mayor al promedio)\n");	
			}
			
			double Promedio(double a, double b, double c, double d, double e){
				return (a+b+c+d+e)/5;
			}
		//metodo para imprimir(Promedios,máximos,minimos)
			void imprimir3(double pro,double min,double max){
				imprimir("  Precio promedio\t:  S/."+pro);
				imprimir("  Precio mínimo\t	:  S/."+min);
				imprimir("  Precio máximo\t	:  S/."+max+"\n");
			}
			
			void imprimir4(int pro,int min, int max){
				imprimir("  Potencia promedio\t:  "+pro+" watts");
				imprimir("  Potencia mínima\t:  "+min+" watts");
				imprimir("  Potencia máxima\t:  "+max+" watts"+"\n");
			}
		
			double ProMin(double a,double b,double c,double d,double e){
				if(a<=b && a<=c && a<=d && a<=e){
					return a;
				}else if(b<=a && b<=c && b<=d && b<=e){
					return b;
				}else if(c<=a && c<=b && c<=d && c<=e){
					return c;
				}else if(d<=a && d<=b && d<=c && d<=e){
					return d;
				}else return e;
			}
			double ProMax(double a,double b,double c,double d,double e){
				if(a>b && a>=c && a>=d && a>=e){
					return a;
				}else if(b>=a && b>=c && b>=d && b>=e){
					return b;
				}else if(c>=a && c>=b && c>=d && c>=e){
					return c;
				}else if(d>=a && d>=b && d>=c && d>=e){
					return d;
				}else return e;
			}
			
			int Promedio2(int a, int b, int c, int d, int e){
				return (a+b+c+d+e)/5;
			}
			
			int ProMin2(int a, int b, int c, int d, int e){
				if(a<=b && a<=c && a<=d && a<=e){
					return a;
				}else if(b<=a && b<=c && b<=d && b<=e){
					return b;
				}else if(c<=a && c<=b && c<=d && c<=e){
					return c;
				}else if(d<=a && d<=b && d<=c && d<=e){
					return d;
				}else return e;
			}
			
			int PromMax2(int a, int b, int c, int d, int e){
				if(a>=b && a>=c && a>=d && a>=e){
					return a;
				}else if(b>=a && b>=c && b>=d && b>=e){
					return b;
				}else if(c>=a && c>=b && c>=d && c>=e){
					return c;
				}else if(d>=a && d>=b && d>=c && d>=e){
					return d;
				}else return e;
			}
		
		
		
	
	protected void actionPerformedBtnCerrar(ActionEvent arg0) {
		dispose();
	}
	
	//eventos de teclado
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == this) {
			keyTypedThis(e);
		}
		if (e.getSource() == txtS) {
			keyTypedTxtS(e);
		}
		if (e.getSource() == cboReporte) {
			keyTypedCboReporte(e);
		}
	}
	protected void keyTypedCboReporte(KeyEvent e) {
		ProyectoLampara.PresionarCerrar(e, btnCerrar);
		
	}
	protected void keyTypedTxtS(KeyEvent e) {
		ProyectoLampara.PresionarCerrar(e, btnCerrar);
		
	}
	protected void keyTypedThis(KeyEvent e) {
		ProyectoLampara.PresionarCerrar(e, btnCerrar);
		
	}
}
