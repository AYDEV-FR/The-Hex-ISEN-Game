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
	private Icon Hex_Focus, Hex_Blue, Hex_Red;
	
	public JCaseBoard(int x, int y, Icon icon, boolean locked) {
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
        
        
        if(!locked && Settings.Animation == 1) {
        	
        	try {
    			Hex_Focus = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/Hex_Focus.png")));
    			Hex_Red = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/Hex_Red.png")));
    			Hex_Blue = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/Hex_Blue.png")));
    		} catch (IOException e1) {
    			e1.printStackTrace();
    		}
            
            this.addMouseListener(new MouseListener() {

    			@Override
    			public void mouseEntered(MouseEvent arg0) {
    				setIcon(Hex_Focus);
    			}

    			@Override
    			public void mouseExited(MouseEvent arg0) {
    				setIcon(icon);	
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
    			}

    			@Override
    			public void mouseReleased(MouseEvent e) {}

    		});
        }        
        
    }
	
    
}
