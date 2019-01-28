package fr.des69u.graphical;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;

import fr.des69u.game.Constants;
import fr.des69u.game.Settings;
import fr.des69u.main.Game;


public class JCaseBoard extends JButton {

	private static final long serialVersionUID = 1L;
	private Icon Hex_Focus, Hex_Blue, Hex_Red, Hex_Simple;
	
	private MouseListener mouse = new MouseListener() {
		@Override
		public void mouseEntered(MouseEvent arg0) {
			setIcon(Hex_Focus);
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
				setIcon(Hex_Simple);
		}

		@Override
		public void mouseClicked(MouseEvent e) {}

		@Override
		public void mousePressed(MouseEvent e) {
			if(Game.player.getCurrentPlayerColor() == Constants.BLUE) {
				setIcon(Hex_Blue);
			} else {
				setIcon(Hex_Red);
			}
			removeMouseListener(this);
		}

		@Override
		public void mouseReleased(MouseEvent e) {}

	};
	
	
	public JCaseBoard(int x, int y, Icon icon) {
        super();
        setBounds(x, y, 42, 49);
        setSize(42, 49);
        setLayout(null);
        setIcon(icon);
        setBorder(null);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setRolloverEnabled(false);
        setOpaque(false);
        setLocation(x, y);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
       
        
        if(Settings.Animation == 1) {
        	
        	try {
    			Hex_Focus = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/Hex_Focus.png")));
    			Hex_Red = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/Hex_Red.png")));
    			Hex_Blue = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/Hex_Blue.png")));
    			Hex_Simple = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/Hex_Simple.png")));
    		} catch (IOException e1) {
    			e1.printStackTrace();
    		}
            
            this.addMouseListener(mouse);
        }        
        
    }
	
	public void updateCase(Icon icon, boolean locked) {
		setIcon(icon);
		if(Settings.Animation == 1 && locked) {
			this.removeMouseListener(mouse);
		}
	}
	
    
}
