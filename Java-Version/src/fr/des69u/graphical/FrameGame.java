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
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

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
		setBounds(100, 100, 787, 722);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		PanelBoard panelBoard = new PanelBoard();
		panelBoard.setBounds(10, 11, 753, 574);
		contentPane.add(panelBoard);
		
		JButton btnSettings = new JButton("Settings");
		btnSettings.setBounds(634, 636, 126, 31);
		contentPane.add(btnSettings);
		

		
		JLabel lblTheHexisenGame = new JLabel("The Hex'ISEN Game");
		lblTheHexisenGame.setBounds(10, 627, 361, 31);
		contentPane.add(lblTheHexisenGame);
		lblTheHexisenGame.setFont(new Font("Times New Roman", Font.PLAIN, 39));
		
		JButton button = new JButton("Reload");
		button.setBounds(501, 636, 126, 31);
		contentPane.add(button);
		
		JButton btnReplay = new JButton("Replay");
		btnReplay.setBounds(634, 596, 126, 31);
		contentPane.add(btnReplay);
		btnReplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Game.board.init();
				Game.player.reset();
				panelBoard.reloadBoard();
				repaint();
			}
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelBoard.reloadBoard();
			}
		});
		
		
		
		
		btnSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameSettings frame = new FrameSettings();
				frame.setVisible(true);
				setVisible(false);
				dispose(); 
			}
		});
	}
}
