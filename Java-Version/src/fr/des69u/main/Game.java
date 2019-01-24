package fr.des69u.main;

import java.awt.EventQueue;

import javax.swing.JFrame;

import fr.des69u.game.*;
import fr.des69u.graphical.*;

public class Game {

	public static Board board = new Board();
	public static Player player = new Player();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame frame = new FrameHome();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


}
