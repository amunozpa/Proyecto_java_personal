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

public class configurardescuentos extends JDialog implements ActionListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new Fondo("fondoaplicacion.jpg");
	private JTextField txtD0;
	private JTextField txtD1;
	private JTextField txtD2;
	private JTextField txtD3;
	private JButton btnAceptar;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			configurardescuentos dialog = new configurardescuentos();
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
	public configurardescuentos() {
		setResizable(false);
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ProyectoLampara.class.getResource("/proyectolampara/iconolampara.png")));
		addKeyListener(this);
		setTitle("Configurar Descuentos");
		setBounds(100, 100, 450, 153);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblA = new JLabel("1 a 5 l\u00E1mparas");
			lblA.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblA.setBounds(10, 11, 96, 14);
			contentPanel.add(lblA);
		}
		{
			JLabel lblA_1 = new JLabel("6 a 10 l\u00E1mparas");
			lblA_1.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblA_1.setBounds(10, 36, 96, 14);
			contentPanel.add(lblA_1);
		}
		{
			JLabel lblA_2 = new JLabel("11 a 15 l\u00E1mparas");
			lblA_2.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblA_2.setBounds(10, 61, 154, 14);
			contentPanel.add(lblA_2);
		}
		{
			JLabel lblA_3 = new JLabel("M\u00E1s de 15 l\u00E1mparas");
			lblA_3.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblA_3.setBounds(10, 86, 154, 14);
			contentPanel.add(lblA_3);
		}
		{
			txtD0 = new JTextField();
			txtD0.addKeyListener(this);
			txtD0.setText(""+ProyectoLampara.porcentaje1);
			txtD0.setBounds(154, 8, 86, 20);
			contentPanel.add(txtD0);
			txtD0.setColumns(10);
		}
		{
			txtD1 = new JTextField();
			txtD1.addKeyListener(this);
			txtD1.setText(""+ProyectoLampara.porcentaje2);
			txtD1.setBounds(154, 33, 86, 20);
			contentPanel.add(txtD1);
			txtD1.setColumns(10);
		}
		{
			txtD2 = new JTextField();
			txtD2.addKeyListener(this);
			txtD2.setText(""+ProyectoLampara.porcentaje3);
			txtD2.setBounds(154, 58, 86, 20);
			contentPanel.add(txtD2);
			txtD2.setColumns(10);
		}
		{
			txtD3 = new JTextField();
			txtD3.addKeyListener(this);
			txtD3.setText(""+ProyectoLampara.porcentaje4);
			txtD3.setBounds(154, 83, 86, 20);
			contentPanel.add(txtD3);
			txtD3.setColumns(10);
		}
		{
			btnAceptar = new JButton("Aceptar");
			btnAceptar.addActionListener(this);
			btnAceptar.setBounds(335, 7, 89, 23);
			contentPanel.add(btnAceptar);
		}
		{
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(this);
			btnCancelar.setBounds(335, 32, 89, 23);
			contentPanel.add(btnCancelar);
		}
		{
			JLabel label = new JLabel("%");
			label.setFont(new Font("Tahoma", Font.BOLD, 11));
			label.setBounds(250, 11, 46, 14);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("%");
			label.setFont(new Font("Tahoma", Font.BOLD, 11));
			label.setBounds(250, 36, 46, 14);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("%");
			label.setFont(new Font("Tahoma", Font.BOLD, 11));
			label.setBounds(250, 61, 46, 14);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("%");
			label.setFont(new Font("Tahoma", Font.BOLD, 11));
			label.setBounds(250, 86, 46, 14);
			contentPanel.add(label);
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
		double p1,p2,p3,p4;
		
		
		try {
			
			p1= Double.parseDouble(txtD0.getText());
			p2= Double.parseDouble(txtD1.getText());
			p3= Double.parseDouble(txtD2.getText());
			p4= Double.parseDouble(txtD3.getText());
			if(p1<0 || p2<0 || p3<0 || p4<0 ){
				mensaje("Valor inválido","Error");
				//resetearValores();		
			}else{
				grabar(p1, p2, p3, p4);	
			}
		}catch (NumberFormatException e) {
				mensaje("Valor(es) inválido(s)","Error");
				// resetearValores();
				 
			}
	}
	
	void mensaje(String text1,String text2){
		JOptionPane.showMessageDialog(null,text1,text2,JOptionPane.ERROR_MESSAGE);
	}		
	
	
	
	//metodo para grabar los porcentajes
	void grabar(double p1,double p2,double p3,double p4){
		ProyectoLampara.porcentaje1=p1;
		ProyectoLampara.porcentaje2=p2;
		ProyectoLampara.porcentaje3=p3;
		ProyectoLampara.porcentaje4=p4;
		JOptionPane.showMessageDialog(null,"Datos guardados con exito","Aviso",JOptionPane.INFORMATION_MESSAGE);
		dispose();
	}
	
	protected void actionPerformedBtnCancelar(ActionEvent arg0) {
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
		if (arg0.getSource() == txtD3) {
			keyTypedTxtD3(arg0);
		}
		if (arg0.getSource() == txtD2) {
			keyTypedTxtD2(arg0);
		}
		if (arg0.getSource() == txtD1) {
			keyTypedTxtD1(arg0);
		}
		if (arg0.getSource() == txtD0) {
			keyTypedTxtD0(arg0);
		}
	}
	protected void keyTypedTxtD0(KeyEvent e) {
		ProyectoLampara.soloReales(e);
		ProyectoLampara.PresionarCerrar(e, btnCancelar);
		ProyectoLampara.PresionarAcceder(e, btnAceptar);
		ProyectoLampara.Puntos(e, txtD0);
		
	}
	protected void keyTypedTxtD1(KeyEvent e) {
		ProyectoLampara.soloReales(e);
		ProyectoLampara.PresionarCerrar(e, btnCancelar);
		ProyectoLampara.PresionarAcceder(e, btnAceptar);
		ProyectoLampara.Puntos(e, txtD1);
	}
	protected void keyTypedTxtD2(KeyEvent e) {
		ProyectoLampara.soloReales(e);
		ProyectoLampara.PresionarCerrar(e, btnCancelar);
		ProyectoLampara.PresionarAcceder(e, btnAceptar);
		ProyectoLampara.Puntos(e, txtD2);
	}
	protected void keyTypedTxtD3(KeyEvent e) {
		ProyectoLampara.soloReales(e);
		ProyectoLampara.PresionarCerrar(e, btnCancelar);
		ProyectoLampara.PresionarAcceder(e, btnAceptar);
		ProyectoLampara.Puntos(e, txtD3);
	}
	protected void keyTypedThis(KeyEvent e) {
		ProyectoLampara.PresionarCerrar(e, btnCancelar);
		ProyectoLampara.PresionarAcceder(e, btnAceptar);
	}
}
