package fr.des69u.graphical;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fr.des69u.main.Game;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;

public class FrameGame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public FrameGame() {
			
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 775, 711);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		PanelBoard panelBoard = new PanelBoard();
		panelBoard.setBounds(10, 11, 749, 574);
		contentPane.add(panelBoard);
		

		
		JLabel lblTheHexisenGame = new JLabel("The Hex'ISEN Game");
		lblTheHexisenGame.setFont(new Font("Times New Roman", Font.PLAIN, 39));
		lblTheHexisenGame.setBounds(10, 640, 361, 31);
		contentPane.add(lblTheHexisenGame);
		
		JButton btnReplay = new JButton("Replay");
		btnReplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Game.board.init();
				panelBoard.reloadBoard();
				repaint();
			}
		});
		btnReplay.setBounds(633, 640, 126, 31);
		contentPane.add(btnReplay);
		
		JButton button = new JButton("Reload");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelBoard.reloadBoard();
			}
		});
		button.setBounds(488, 640, 126, 31);
		contentPane.add(button);
		
		JButton btnSettings = new JButton("Settings");
		btnSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameSettings frame = new FrameSettings();
				frame.setVisible(true);
				setVisible(false);
				dispose(); 
			}
		});
		btnSettings.setBounds(633, 596, 126, 31);
		contentPane.add(btnSettings);
	}
}
