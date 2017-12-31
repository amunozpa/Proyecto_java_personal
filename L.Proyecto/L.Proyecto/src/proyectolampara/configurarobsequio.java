package proyectolampara;

import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.naming.directory.ModificationItem;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Font;

@SuppressWarnings("unused")
public class configurarobsequio extends JDialog implements ActionListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new Fondo("fondoaplicacion.jpg");
	private JTextField txtCantMin;
	private JTextField txtObsequio;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JComboBox<?> cboModelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			configurarobsequio dialog = new configurarobsequio();
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
	public configurarobsequio() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ProyectoLampara.class.getResource("/proyectolampara/iconolampara.png")));
		addKeyListener(this);
		setModal(true);
		setTitle("Configurar Obsequios");
		setBounds(100, 100, 450, 127);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblModelo = new JLabel("Modelo");
			lblModelo.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblModelo.setBounds(23, 11, 84, 14);
			contentPanel.add(lblModelo);
		}
		{
			JLabel lblCantidadMnima = new JLabel("Cantidad M\u00EDnima");
			lblCantidadMnima.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblCantidadMnima.setBounds(23, 36, 96, 14);
			contentPanel.add(lblCantidadMnima);
		}
		{
			JLabel lblObsequio = new JLabel("Obsequio");
			lblObsequio.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblObsequio.setBounds(23, 61, 84, 14);
			contentPanel.add(lblObsequio);
		}
		{
			cboModelo = new JComboBox();
			cboModelo.addKeyListener(this);
			cboModelo.setToolTipText("");
			cboModelo.addActionListener(this);
			cboModelo.setModel(new DefaultComboBoxModel(new String[] {"[Seleccione Item]", "MEDUSA", "KEFREN", "KASK", "HOT", "LAIA"}));
			cboModelo.setBounds(130, 8, 135, 20);
			contentPanel.add(cboModelo);
		}
		{
			txtCantMin = new JTextField();
			txtCantMin.addKeyListener(this);
			txtCantMin.setBounds(129, 33, 96, 20);
			contentPanel.add(txtCantMin);
			txtCantMin.setColumns(10);
			txtCantMin.setText(""+ProyectoLampara.cantidadMinimaObsequiable);
		}
		{
			txtObsequio = new JTextField();
			txtObsequio.addKeyListener(this);
			txtObsequio.setBounds(129, 58, 96, 20);
			contentPanel.add(txtObsequio);
			txtObsequio.setColumns(10);
			txtObsequio.setText(""+ProyectoLampara.obsequio);
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
		cboModelo.setSelectedIndex(ProyectoLampara.modeloObsequiable);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cboModelo) {
			actionPerformedCboModelo(e);
		}
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
	}
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		dispose();
	}
	protected void actionPerformedCboModelo(ActionEvent e) {
		combo();
	}
	
	protected void actionPerformedBtnAceptar(ActionEvent arg0) {
		String obs;
		int mode,cant;
		
		try {
			
			obs = txtObsequio.getText();
			mode = cboModelo.getSelectedIndex();
			cant = Integer.parseInt(txtCantMin.getText());
			
			if(cant<=0){
				mensaje("Valor inválido","Error");
			}else if(txtObsequio.getText().isEmpty()){
					mensaje("Valor inválido","Aviso");
													
			}else{
				grabar(mode, obs, cant);
				grabarMOD();	
			}
		}catch (NumberFormatException e) {
				mensaje("Valor(es) inválido(s)","Error");
				
				 
			}
	}
	void mensaje(String text1,String text2){
		JOptionPane.showMessageDialog(null,text1,text2,JOptionPane.ERROR_MESSAGE);
	}
	
	//metodo grabar
	
		void grabar(int mode, String obs,int cant){
			switch(mode){
			case 0:
				break;
			case 1:
				ProyectoLampara.modeloObsequiable = 1;
				ProyectoLampara.cantidadMinimaObsequiable = cant;
				ProyectoLampara.obsequio=obs;
				break;
			case 2:
				ProyectoLampara.modeloObsequiable = 2;
				ProyectoLampara.cantidadMinimaObsequiable = cant;
				ProyectoLampara.obsequio=obs;
				break;
			case 3:
				ProyectoLampara.modeloObsequiable = 3;
				ProyectoLampara.cantidadMinimaObsequiable = cant;
				ProyectoLampara.obsequio=obs;
				break;
			default:
				ProyectoLampara.modeloObsequiable = 4;
				ProyectoLampara.cantidadMinimaObsequiable = cant;
				ProyectoLampara.obsequio=obs;	
			}
			JOptionPane.showMessageDialog(null,"Datos guardads con exito","AVISO",JOptionPane.INFORMATION_MESSAGE);
			cboModelo.requestFocus();
			dispose();
		    }
		
		
		// graba los uevos modelos ... No se debe repetir
	void grabarMOD(){
		
		
		if(ProyectoLampara.modeloObsequiable==0){
			ProyectoLampara.cad ="MEDUSA";
		}else if(ProyectoLampara.modeloObsequiable==1){
			ProyectoLampara.cad ="KEFREN";
		}else if(ProyectoLampara.modeloObsequiable==2){
			ProyectoLampara.cad ="KASK";
		}else if(ProyectoLampara.modeloObsequiable==3){
			ProyectoLampara.cad ="HOT";
		}else{
			ProyectoLampara.cad ="LAIA";}
	}
		
	void combo(){
		int modelo;
		modelo = cboModelo.getSelectedIndex();
			if(modelo==ProyectoLampara.modeloObsequiable){
				txtCantMin.setText(ProyectoLampara.cantidadMinimaObsequiable+"");
				txtObsequio.setText(ProyectoLampara.obsequio);
			}else{
				txtCantMin.setText("");
				txtObsequio.setText("");	
			}
		
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
		if (arg0.getSource() == cboModelo) {
			keyTypedCboModelo(arg0);
		}
		if (arg0.getSource() == txtObsequio) {
			keyTypedTxtObsequio(arg0);
		}
		if (arg0.getSource() == txtCantMin) {
			keyTypedTxtCantMin(arg0);
		}
	}
	protected void keyTypedTxtCantMin(KeyEvent e) {
		ProyectoLampara.SoloNumeros(e);
		ProyectoLampara.PresionarCerrar(e, btnCancelar);
		ProyectoLampara.PresionarAcceder(e, btnAceptar);
	}
	protected void keyTypedTxtObsequio(KeyEvent e) {
		ProyectoLampara.SoloLetras(e, txtObsequio);
		ProyectoLampara.PresionarCerrar(e, btnCancelar);
		ProyectoLampara.PresionarAcceder(e, btnAceptar);
	}
	protected void keyTypedCboModelo(KeyEvent e) {
		ProyectoLampara.PresionarCerrar(e, btnCancelar);
		ProyectoLampara.PresionarAcceder(e, btnAceptar);
	}
	protected void keyTypedThis(KeyEvent e) {
		ProyectoLampara.PresionarCerrar(e, btnCancelar);
		ProyectoLampara.PresionarAcceder(e, btnAceptar);
	}
}