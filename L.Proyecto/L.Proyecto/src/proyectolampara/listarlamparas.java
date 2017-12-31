package proyectolampara;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;

public class listarlamparas extends JDialog implements ActionListener, KeyListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JTextArea txtS;
	private JButton btnListar;
	private JButton btnCerrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			listarlamparas dialog = new listarlamparas();
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
	public listarlamparas() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ProyectoLampara.class.getResource("/proyectolampara/iconolampara.png")));
		addKeyListener(this);
		setModal(true);
		setTitle("Listar L\u00E1mparas");
		setBounds(100, 100, 515, 512);
		getContentPane().setLayout(null);
		
		panel = new Fondo("fondoaplicacion.jpg");
		panel.setBounds(0, 0, 519, 485);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 104, 458, 366);
		panel.add(scrollPane);
		
		txtS = new JTextArea();
		txtS.addKeyListener(this);
		txtS.setEditable(false);
		scrollPane.setViewportView(txtS);
		
		btnListar = new JButton("Listar");
		btnListar.addKeyListener(this);
		btnListar.addActionListener(this);
		btnListar.setBounds(24, 37, 89, 23);
		panel.add(btnListar);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(393, 37, 89, 23);
		panel.add(btnCerrar);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(arg0);
		}
		if (arg0.getSource() == btnListar) {
			actionPerformedBtnListar(arg0);
		}
		
	}
	protected void actionPerformedBtnListar(ActionEvent arg0) {
		//"LISTADO DE LAMPARAS"
		txtS.setText("\n");
		txtS.append("  Modelo\t:  "+ProyectoLampara.modelo0+"\n");
		txtS.append("  Precio\t:  S/."+ProyectoLampara.precio0+"\n");
		txtS.append("  Potencia\t:  "+ProyectoLampara.potencia0+" watts"+"\n");
		txtS.append("  Color\t:  "+ProyectoLampara.color0+"\n");
		txtS.append("  Luces\t:  "+ProyectoLampara.nluces0+" unidad(es)"+"\n\n");
		
		txtS.append("  Modelo\t:  "+ProyectoLampara.modelo1+"\n");
		txtS.append("  Precio\t:  S/."+ProyectoLampara.precio1+"\n");
		txtS.append("  Potencia\t:  "+ProyectoLampara.potencia1+" watts"+"\n");
		txtS.append("  Color\t:  "+ProyectoLampara.color1+"\n");
		txtS.append("  Luces\t:  "+ProyectoLampara.nluces1+" unidad(es)"+"\n\n");
		
		txtS.append("  Modelo\t:  "+ProyectoLampara.modelo2+"\n");
		txtS.append("  Precio\t:  S/."+ProyectoLampara.precio2+"\n");
		txtS.append("  Potencia\t:  "+ProyectoLampara.potencia2+" watts"+"\n");
		txtS.append("  Color\t:  "+ProyectoLampara.color2+"\n");
		txtS.append("  Luces\t:  "+ProyectoLampara.nluces2+" unidad(es)"+"\n\n");
		
		txtS.append("  Modelo\t:  "+ProyectoLampara.modelo3+"\n");
		txtS.append("  Precio\t:  S/."+ProyectoLampara.precio3+"\n");
		txtS.append("  Potencia\t:  "+ProyectoLampara.potencia3+" watts"+"\n");
		txtS.append("  Color\t:  "+ProyectoLampara.color3+"\n");
		txtS.append("  Luces\t:  "+ProyectoLampara.nluces3+" unidad(es)"+"\n\n");
		
		txtS.append("  Modelo\t:  "+ProyectoLampara.modelo4+"\n");
		txtS.append("  Precio\t:  S/."+ProyectoLampara.precio4+"\n");
		txtS.append("  Potencia\t:  "+ProyectoLampara.potencia4+" watts"+"\n");
		txtS.append("  Color\t:  "+ProyectoLampara.color4+"\n");
		txtS.append("  Luces\t:  "+ProyectoLampara.nluces4+" unidad(es)"+"\n\n");
		
		//Scroll vertical hacia arriba
		txtS.setCaretPosition(0);
		
		
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
		if (e.getSource() == btnListar) {
			keyTypedBtnListar(e);
		}
		if (e.getSource() == txtS) {
			keyTypedTxtS(e);
		}
		if (e.getSource() == this) {
			keyTypedThis(e);
		}
	}
	
	protected void keyTypedThis(KeyEvent e) {
		ProyectoLampara.PresionarCerrar(e, btnCerrar);
		ProyectoLampara.PresionarAcceder(e, btnListar);
	}
	
	protected void keyTypedTxtS(KeyEvent e) {
		ProyectoLampara.PresionarCerrar(e, btnCerrar);
		ProyectoLampara.PresionarAcceder(e, btnListar);
	}
	protected void keyTypedBtnListar(KeyEvent e) {
		ProyectoLampara.PresionarCerrar(e, btnCerrar);
		ProyectoLampara.PresionarAcceder(e, btnListar);
	}
}
