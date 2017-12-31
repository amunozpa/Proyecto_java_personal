package proyectolampara;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



@SuppressWarnings({ "unused", "serial" })
public class Fondo extends JPanel {

	ImageIcon imagen;
	/**
	 * Create the panel.
	 */
	public Fondo(String nombre) {
		super();
		
		imagen=new ImageIcon(getClass().getResource(nombre));
		setSize(imagen.getIconWidth(),imagen.getIconHeight());
		

	}
	
	protected void paintComponent (Graphics g){
		Dimension d=getSize();
		g.drawImage(imagen.getImage(),0,0,d.width,d.height,null);
		this.setOpaque(false);
		super.paintComponent(g);
		
	}

}
