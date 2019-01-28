package fr.des69u.graphical;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fr.des69u.game.Constants;
import fr.des69u.game.Settings;

import java.awt.Canvas;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JDesktopPane;
import javax.swing.JSplitPane;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import java.awt.Insets;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;

public class FrameHome extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public FrameHome() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 756, 578);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButtonHex btnPlay = new JButtonHex("PLAY", 49, Color.RED);
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new FrameGame().setVisible(true);;
				setVisible(false);
				dispose();
			}
		});
		btnPlay.setFont(new FontManager(99).getFont());
		btnPlay.setIcon(null);
		JButtonHex btnSettings = new JButtonHex("settings", "SETTINGS", 49, Color.BLACK);
		btnSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrameSettings().setVisible(true);
				setVisible(false);
				dispose();
			}
		});

		
		
		JButtonHex btnHexgame = new JButtonHex("HexGame", 100, Color.DARK_GRAY);
		
		JLabel lblNewLabel = new JLabel(Constants.VERSION_NAME + " " + Constants.VERSION);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(48)
							.addComponent(btnHexgame, GroupLayout.PREFERRED_SIZE, 639, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(188)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnPlay, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnSettings, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(311)
							.addComponent(lblNewLabel)))
					.addContainerGap(53, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnHexgame, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
					.addGap(47)
					.addComponent(btnPlay, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnSettings, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 151, Short.MAX_VALUE)
					.addComponent(lblNewLabel)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		
		
	}
}
