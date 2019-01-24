package fr.des69u.graphical;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class JButtonHex extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public JButtonHex(String text, int fontSize, Color color) {
		super(text);
		this.setForeground(color);
		this.setRolloverEnabled(false);
		this.setOpaque(false);
		this.setFont(new FontManager(fontSize).getFont());
		this.setContentAreaFilled(false);
		this.setBorderPainted(false);
		this.setBorder(null);
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	
	public JButtonHex(String text, String textFocus, int fontSize, Color color) {
		this(text, fontSize, color);
		
		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseEntered(MouseEvent arg0) {
				setText(textFocus);				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				setText(text);	
				
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

		});
	}
	
	
	
	
}
