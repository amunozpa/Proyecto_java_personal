package proyectolampara;

import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Font;

public class configurarcantidadoptimadelamparasvendidas extends JDialog implements ActionListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new Fondo("fondoaplicacion.jpg");
	private JTextField txtCantOpt;
	private JButton btnAceptar;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			configurarcantidadoptimadelamparasvendidas dialog = new configurarcantidadoptimadelamparasvendidas();
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
	public configurarcantidadoptimadelamparasvendidas() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ProyectoLampara.class.getResource("/proyectolampara/iconolampara.png")));
		addKeyListener(this);
		setModal(true);
		setTitle("Configurar Cantidad \u00D3ptima de Lamparas Vendidas");
		setBounds(100, 100, 501, 153);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblCantidadptimaDe = new JLabel("Cantidad \u00D3ptima de Lamparas Vendidas");
			lblCantidadptimaDe.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblCantidadptimaDe.setBounds(23, 58, 275, 14);
			contentPanel.add(lblCantidadptimaDe);
		}
		{
			txtCantOpt = new JTextField();
			txtCantOpt.addKeyListener(this);
			txtCantOpt.setText(""+ProyectoLampara.cantidadOptima);
			txtCantOpt.setBounds(273, 55, 86, 20);
			contentPanel.add(txtCantOpt);
			txtCantOpt.setColumns(10);
		}
		{
			btnAceptar = new JButton("Aceptar");
			btnAceptar.addActionListener(this);
			btnAceptar.setBounds(386, 52, 89, 23);
			contentPanel.add(btnAceptar);
		}
		{
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(this);
			btnCancelar.setBounds(386, 80, 89, 23);
			contentPanel.add(btnCancelar);
		}
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(arg0);
		}
		if (arg0.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(arg0);
		}
	}
	protected void actionPerformedBtnAceptar(ActionEvent arg0) {
		int cant;
		try {
			
			cant=Integer.parseInt(txtCantOpt.getText());
			if(cant<=0){
				mensaje("valor inválido","Error");
				//resetearValores();		
			}else{
				Grabar(cant);
			}
		}catch (NumberFormatException e) {
				mensaje("Valor(es) inválido(s)","Error");
				// resetearValores();
				 
			}
	}

	void mensaje(String text1,String text2){
		JOptionPane.showMessageDialog(null,text1,text2,JOptionPane.ERROR_MESSAGE);
	}
	
	//grabar
	void Grabar(int cant1){
		 ProyectoLampara.cantidadOptima= cant1;
		 JOptionPane.showMessageDialog(null,"Datos guardados con exito","Aviso",JOptionPane.INFORMATION_MESSAGE);
		 dispose();
	}
	
	
	protected void actionPerformedBtnCancelar(ActionEvent arg0) {
		dispose();
	}
	
	//validaciones para entrada de datos
	public void keyPressed(KeyEvent arg0) {
	}
	public void keyReleased(KeyEvent arg0) {
	}
	public void keyTyped(KeyEvent arg0) {
		if (arg0.getSource() == this) {
			keyTypedThis(arg0);
		}
		if (arg0.getSource() == txtCantOpt) {
			keyTypedTxtCantOpt(arg0);
		}
	}
	protected void keyTypedTxtCantOpt(KeyEvent e) {
		ProyectoLampara.SoloNumeros(e);
		ProyectoLampara.PresionarCerrar(e, btnCancelar);
		ProyectoLampara.PresionarAcceder(e, btnAceptar);
	}
	protected void keyTypedThis(KeyEvent e) {
		ProyectoLampara.PresionarCerrar(e, btnCancelar);
		ProyectoLampara.PresionarAcceder(e, btnAceptar);
	}
}
