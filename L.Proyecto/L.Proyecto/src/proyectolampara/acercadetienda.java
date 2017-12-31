package proyectolampara;

import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Font;

public class acercadetienda extends JDialog implements ActionListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new Fondo("fondoaplicacion.jpg");
	private JButton btnCerrar;
	private JLabel lblErikNolazco;
	private JLabel lblYhoniHuamani;
	private JLabel lblCarolPaco;
	private JLabel lblTienda;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			acercadetienda dialog = new acercadetienda();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public acercadetienda() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ProyectoLampara.class.getResource("/proyectolampara/iconolampara.png")));
		addKeyListener(this);
		setModal(true);
		setTitle("Acerca de Tienda");
		setBounds(100, 100, 388, 351);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.addKeyListener(this);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			lblTienda = new JLabel("Lamp S.A");
			lblTienda.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblTienda.addKeyListener(this);
			lblTienda.setBounds(156, 115, 81, 14);
			contentPanel.add(lblTienda);
		}
		{
			JLabel label = new JLabel("_____________________________________________________________________________________________________________");
			label.setBounds(0, 122, 422, 14);
			contentPanel.add(label);
		}
		{
			JLabel lblAutores = new JLabel("AUTORES");
			lblAutores.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblAutores.setBounds(156, 140, 90, 14);
			contentPanel.add(lblAutores);
		}
		{
			JLabel lblAmueEdinsonMuoz = new JLabel("Amue Edinson Mu\u00F1oz Paredes (Coordinador)");
			lblAmueEdinsonMuoz.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblAmueEdinsonMuoz.setBounds(85, 165, 277, 14);
			contentPanel.add(lblAmueEdinsonMuoz);
		}
		{
			btnCerrar = new JButton("Cerrar");
			btnCerrar.addKeyListener(this);
			btnCerrar.addActionListener(this);
			btnCerrar.setBounds(142, 278, 89, 23);
			contentPanel.add(btnCerrar);
		}
		
		lblErikNolazco = new JLabel("Erik Nolazco");
		lblErikNolazco.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblErikNolazco.setBounds(85, 190, 277, 14);
		contentPanel.add(lblErikNolazco);
		
		lblYhoniHuamani = new JLabel("Yhoni Huamani");
		lblYhoniHuamani.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblYhoniHuamani.setBounds(85, 215, 277, 14);
		contentPanel.add(lblYhoniHuamani);
		
		lblCarolPaco = new JLabel("Carol Paco");
		lblCarolPaco.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCarolPaco.setBounds(85, 240, 277, 14);
		contentPanel.add(lblCarolPaco);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == btnCerrar) {
			keyTypedBtnCerrar(e);
		}
	
	}
	
	protected void keyTypedBtnCerrar(KeyEvent e) {
		ProyectoLampara.PresionarCerrar(e, btnCerrar);
		ProyectoLampara.PresionarAcceder(e, btnCerrar);
	}
}
