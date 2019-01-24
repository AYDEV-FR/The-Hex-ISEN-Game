package fr.des69u.graphical;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import fr.des69u.game.Constants;
import fr.des69u.game.Settings;
import fr.des69u.main.Game;

import javax.swing.JButton;
import java.awt.Font;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class FrameSettings extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private Map<String, Object> tmpSettings = new HashMap<>();
	
	/**
	 * Create the frame.
	 * @param panelBoard 
	 * @param actionListener 
	 */
	public FrameSettings() {
		
		System.out.println("Loading Settings...");
		tmpSettings = this.loadSettings();
		System.out.println(tmpSettings.toString());
		
		setResizable(false);
		setBounds(100, 100, 595, 535);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		JPanel panel = new JPanel();
		JPanel panel_1 = new JPanel();
		JPanel panel_2 = new JPanel();
		
		JLabel lblModeDeJeu = new JLabel("Game Mode");
		JLabel lblSizeOfGame = new JLabel("Size of Game");
		JButtonHex btnx = new JButtonHex("11X11", 64, this.getColor().get("11"));
		JButtonHex btnx_1 = new JButtonHex("9X9", 64, this.getColor().get("9"));
		JButtonHex btnIa = new JButtonHex("i.a", 64, this.getColor().get("I.A"));
		JButtonHex btnv = new JButtonHex("1V1", 64, this.getColor().get("1V1"));
		
		JButton btnOn = new JButtonHex("on", 32, this.getColor().get("AnimationOn"));
		JButton btnOff = new JButtonHex("off", 32, this.getColor().get("AnimationOff"));
		
		
		JLabel lblPlayerName = new JLabel("Player Name");
		JLabel lblPlayer = new JLabel("(RED) Name Player 1");
		JTextField txtPlayer1 = new JTextField();
		JLabel lblPlayer_1 = new JLabel("(Blue) Name Player 2");
		JTextField txtPlayer2 = new JTextField();
		txtPlayer1.setText(Settings.Player1_Name);
		txtPlayer2.setText(Settings.Player2_Name);
		
		
		txtPlayer1.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent arg0) {}
			public void insertUpdate(DocumentEvent arg0) {tmpSettings.put("Player1_Name", txtPlayer1.getText());}
			public void removeUpdate(DocumentEvent arg0) {tmpSettings.put("Player1_Name", txtPlayer1.getText());}
		});
		
		txtPlayer2.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent arg0) {}
			public void insertUpdate(DocumentEvent arg0) {tmpSettings.put("Player2_Name", txtPlayer2.getText());}
			public void removeUpdate(DocumentEvent arg0) {tmpSettings.put("Player2_Name", txtPlayer2.getText());}
		});
		
		btnOff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tmpSettings.put("Animation", 0);
				btnOn.setForeground(Color.BLACK);
				btnOff.setForeground(Color.BLUE);
			}
		});
		btnOn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tmpSettings.put("Animation", 1);
				btnOff.setForeground(Color.BLACK);
				btnOn.setForeground(Color.BLUE);
			}
		});
		
		
		btnx_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tmpSettings.put("Size", 9);
				btnx_1.setForeground(Color.BLUE);
				btnx.setForeground(Color.BLACK);
			}
		});
		btnx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tmpSettings.put("Size", 11);
				btnx_1.setForeground(Color.BLACK);
				btnx.setForeground(Color.BLUE);
			}
		});
		btnIa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tmpSettings.put("GameMode", Constants.GAMEMODE_IA);
				btnv.setForeground(Color.BLACK);
				btnIa.setForeground(Color.BLUE);
			}
		});
		btnv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tmpSettings.put("GameMode", Constants.GAMEMODE_1V1);
				btnIa.setForeground(Color.BLACK);
				btnv.setForeground(Color.BLUE);
			}
		});
		
	
		panel.setBounds(10, 235, 283, 214);
		contentPane.add(panel);
		lblSizeOfGame.setFont(new Font("Tahoma", Font.PLAIN, 38));
		lblModeDeJeu.setFont(new Font("Tahoma", Font.PLAIN, 38));
		panel.add(lblSizeOfGame);
		panel.add(btnx);
		panel.add(btnx_1);
		
		
		panel_1.setBounds(10, 11, 283, 213);		
		contentPane.add(panel_1);
		panel_1.add(lblModeDeJeu);
		panel_1.add(btnIa);
		panel_1.add(btnv);
		
		
		JButton btnSaveChanges = new JButton("Save Changes");
		btnSaveChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveSettings();
				new FrameGame().setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		btnSaveChanges.setBounds(452, 460, 116, 35);
		contentPane.add(btnSaveChanges);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrameGame().setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		btnBack.setBounds(10, 460, 116, 35);
		contentPane.add(btnBack);
		
		
		
		
		panel_2.setBounds(303, 11, 276, 213);
		contentPane.add(panel_2);
		
		
		lblPlayerName.setFont(new Font("Tahoma", Font.PLAIN, 38));
		panel_2.add(lblPlayerName);
		
		
		lblPlayer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_2.add(lblPlayer);
		
		
		txtPlayer1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_2.add(txtPlayer1);
		txtPlayer1.setColumns(15);
		
		
		lblPlayer_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_2.add(lblPlayer_1);
		
		txtPlayer2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtPlayer2.setColumns(15);
		panel_2.add(txtPlayer2);
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(303, 235, 276, 214);
		contentPane.add(panel_3);
		
		JLabel lblOthersSettings = new JLabel("Others settings");
		lblOthersSettings.setFont(new Font("Tahoma", Font.PLAIN, 38));
		panel_3.add(lblOthersSettings);
		
		JLabel lblAnimation = new JLabel("Animation :");
		lblAnimation.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_3.add(lblAnimation);
		
		
		panel_3.add(btnOn);
		panel_3.add(btnOff);

		
		
		
		
		
		
		
		
		
		addWindowListener(new WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		    	int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to close this window without saving change ?", "Saving Change ?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		    	if(option == JOptionPane.OK_OPTION){
		    		new FrameGame().setVisible(true);
					setVisible(false);
					dispose();
		    	}
		    }
		});
		
	}



	private Map<String, Object> loadSettings() {
		Map<String, Object> tab = new HashMap<>();
		tab.put("GameMode", Settings.GameMode);
		tab.put("Size", Settings.Size);
		tab.put("Animation", Settings.Animation);
		tab.put("Player1_Name", Settings.Player1_Name);
		tab.put("Player2_Name", Settings.Player2_Name);
		return tab;
	}


	private Map<String, Color> getColor() {
		Map<String, Color> tab = new HashMap<>();
		if(Settings.GameMode == Constants.GAMEMODE_IA) {
			tab.put("I.A", Color.BLUE);
			tab.put("1V1", Color.BLACK);
		} else {
			tab.put("I.A", Color.BLACK);
			tab.put("1V1", Color.BLUE);
		}
		
		if(Settings.Size == 11) {
			tab.put("11", Color.BLUE);
			tab.put("9", Color.BLACK);
		} else {
			tab.put("11", Color.BLACK);
			tab.put("9", Color.BLUE);
		}
		
		if(Settings.Animation == 1) {
			tab.put("AnimationOn", Color.BLUE);
			tab.put("AnimationOff", Color.BLACK);
		} else {
			tab.put("AnimationOn", Color.BLACK);
			tab.put("AnimationOff", Color.BLUE);
		}
		return tab;
	}
	
	private void saveSettings() {
		
		if(!tmpSettings.get("GameMode").equals(Settings.GameMode) || !tmpSettings.get("Size").equals(Settings.Size)) {
			
			Settings.GameMode = (int) tmpSettings.get("GameMode");
			Settings.Size = (int) tmpSettings.get("Size");
			
			Game.board.init();
			
		}
		
		Settings.Player1_Name = (String) tmpSettings.get("Player1_Name");
		Settings.Player2_Name = (String) tmpSettings.get("Player2_Name");
		Settings.Animation = (Integer) tmpSettings.get("Animation");
		
	}
}
