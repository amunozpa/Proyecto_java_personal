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

public class configurarpremiosorpresa extends JDialog implements ActionListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new Fondo("fondoaplicacion.jpg");
	private JLabel lblPremioSorpresa;
	private JTextField txtNumCliente;
	private JTextField txtPremSorp;
	private JButton btnAceptar;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			configurarpremiosorpresa dialog = new configurarpremiosorpresa();
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
	public configurarpremiosorpresa() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ProyectoLampara.class.getResource("/proyectolampara/iconolampara.png")));
		addKeyListener(this);
		setModal(true);
		setTitle("Configurar Premio Sorpresa");
		setBounds(100, 100, 450, 116);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNumeroDeCliente = new JLabel("N\u00FAmero de cliente");
			lblNumeroDeCliente.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNumeroDeCliente.setBounds(20, 27, 137, 14);
			contentPanel.add(lblNumeroDeCliente);
		}
		
		lblPremioSorpresa = new JLabel("Premio sorpresa");
		lblPremioSorpresa.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPremioSorpresa.setBounds(20, 52, 117, 14);
		contentPanel.add(lblPremioSorpresa);
		
		txtNumCliente = new JTextField();
		txtNumCliente.addKeyListener(this);
		txtNumCliente.setText(""+ProyectoLampara.numeroClienteSorpresa);
		txtNumCliente.setBounds(137, 24, 96, 20);
		contentPanel.add(txtNumCliente);
		txtNumCliente.setColumns(10);
		
		txtPremSorp = new JTextField();
		txtPremSorp.addKeyListener(this);
		txtPremSorp.setText(""+ProyectoLampara.premioSorpresa);
		txtPremSorp.setBounds(137, 49, 96, 20);
		contentPanel.add(txtPremSorp);
		txtPremSorp.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(335, 23, 89, 23);
		contentPanel.add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(335, 48, 89, 23);
		contentPanel.add(btnCancelar);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
	}
	protected void actionPerformedBtnAceptar(ActionEvent arg0) {
		String sorp;
		int nc;
		try {
			
			sorp = txtPremSorp.getText();
			nc = Integer.parseInt(txtNumCliente.getText());
			if(nc<=0){
				mensaje("valor inválido","Error");
			}else if(txtPremSorp.getText().isEmpty()){
					mensaje("Valor inválido","Aviso");
						
			}else{
				grabar(sorp, nc);
			}
		}catch (NumberFormatException e) {
				mensaje("Valor(es) inválido(s)","Error");
				// resetearValores();
				 
			}
	}

	void mensaje(String text1,String text2){
		JOptionPane.showMessageDialog(null,text1,text2,JOptionPane.ERROR_MESSAGE);
	}
		
		
		
	
	
	//grabar datos
	void grabar(String sorp,int nc){
		ProyectoLampara.premioSorpresa=sorp;
		ProyectoLampara.numeroClienteSorpresa=nc;
		JOptionPane.showMessageDialog(null,"Datos guardados con exito","Aviso",JOptionPane.CLOSED_OPTION);
		dispose();
	}
	
	protected void actionPerformedBtnCancelar(ActionEvent e) {
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
		if (arg0.getSource() == txtPremSorp) {
			keyTypedTxtPremSorp(arg0);
		}
		if (arg0.getSource() == txtNumCliente) {
			keyTypedTxtNumCliente(arg0);
		}
	}
	protected void keyTypedTxtNumCliente(KeyEvent e) {
		ProyectoLampara.SoloNumeros(e);
		ProyectoLampara.PresionarCerrar(e, btnCancelar);
		ProyectoLampara.PresionarAcceder(e, btnAceptar);
	}
	protected void keyTypedTxtPremSorp(KeyEvent e) {
		ProyectoLampara.SoloLetras(e, txtPremSorp);
		ProyectoLampara.PresionarCerrar(e, btnCancelar);
		ProyectoLampara.PresionarAcceder(e, btnAceptar);
	}
	protected void keyTypedThis(KeyEvent e) {
		ProyectoLampara.PresionarCerrar(e, btnCancelar);
		ProyectoLampara.PresionarAcceder(e, btnAceptar);
	}
}
