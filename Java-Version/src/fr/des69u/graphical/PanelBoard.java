package fr.des69u.graphical;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import fr.des69u.game.Constants;
import fr.des69u.game.IA;
import fr.des69u.game.Location;
import fr.des69u.game.MinMax;
import fr.des69u.game.Settings;
import fr.des69u.main.Game;

public class PanelBoard extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;

	private Icon Hex_Blue, Hex_Red, Hex_Ok, Hex_Simple, Hex_Contour;
	private JCaseBoard[][] gameBoard = new JCaseBoard[Settings.Size][Settings.Size];
	JLabel lblGameInfo = new JLabel("Game Info");
	
	public PanelBoard() {
		try {
			this.Hex_Ok = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/Hex_Ok.png")));
			this.Hex_Red = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/Hex_Red.png")));
			this.Hex_Blue = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/Hex_Blue.png")));
			this.Hex_Simple = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/Hex_Simple.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		setLayout(null);
		setOpaque(false);
		
		lblGameInfo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGameInfo.setBounds(25, 525, 225, 22);
		add(lblGameInfo);
		lblGameInfo.setText(Game.player.getCurrentPlayerName());
		
		this.setGameBoard();
		this.displayBoard();
		this.reloadBoard();
	}
	
	public void paintComponent(Graphics g) {
		Image img = null;
		try {
			if(Settings.Size == 11) {
				img = ImageIO.read(getClass().getResourceAsStream("/Hex_Contour11.png"));
			} else {
				img = ImageIO.read(getClass().getResourceAsStream("/Hex_Contour9.png"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		g.drawImage(img, Constants.OFFSET_X() - 5, Constants.OFFSET_Y() - 4, this);
		
	}


	private void setGameBoard() {
		for(int i = 0; i < Settings.Size; i++) {
			for(int j = 0; j < Settings.Size; j++) {
				int pos_x = 42*i + 21*j + 2*i + Constants.OFFSET_X();
				int pos_y = 49*j - 11*j +  Constants.OFFSET_Y();
				switch (Game.board.getBoard()[i][j]) {
					case Constants.EMPTY :
						gameBoard[i][j] = new JCaseBoard(pos_x, pos_y, Hex_Simple);
						break;
					case Constants.BLUE :
						gameBoard[i][j] = new JCaseBoard(pos_x, pos_y, Hex_Blue);
						break;
					case Constants.RED :
						gameBoard[i][j] = new JCaseBoard(pos_x, pos_y, Hex_Red);
						break;
					case Constants.WIN_RED:
					case Constants.WIN_BLUE:
						gameBoard[i][j] = new JCaseBoard(pos_x, pos_y, Hex_Ok);
						break;
					
				}
				gameBoard[i][j].addActionListener(this);
			}
		}
	}
	
	private void displayBoard() {
		for(int i = 0; i < Settings.Size; i++) {
			for(int j = 0; j < Settings.Size; j++) {
				this.add(gameBoard[i][j]);
			}
		}
	}
	
	public void removeBoard() {
		for(int i = 0; i < Settings.Size; i++) {
			for(int j = 0; j < Settings.Size; j++) {
				this.remove(gameBoard[i][j]);
			}
		}
	}

	public void reloadBoard() {
		lblGameInfo.setText(Game.player.getCurrentPlayerName());
		Game.board.isWin();	
		
		for(int i = 0; i < Settings.Size; i++) {
			for(int j = 0; j < Settings.Size; j++) {
				switch (Game.board.getBoard()[i][j]) {
					case Constants.EMPTY :
						gameBoard[i][j].updateCase(Hex_Simple, false);
						break;
					case Constants.BLUE :
						gameBoard[i][j].updateCase(Hex_Blue, true);
						break;
					case Constants.RED :
						gameBoard[i][j].updateCase(Hex_Red, true);
						break;
					case Constants.WIN_RED:
					case Constants.WIN_BLUE:
						gameBoard[i][j].updateCase(Hex_Ok, true);
						break;
				}
			}
		}
		
		repaint();
		
		if(Game.winner == Constants.BLUE) {
			lblGameInfo.setText("(BLUE) " + Settings.Player2_Name + " WIN");
			winFrame();
		} else if (Game.winner == Constants.RED) {
			lblGameInfo.setText("(RED) " + Settings.Player1_Name + " WIN");
			winFrame();
		}
	}
	
	
	private void winFrame() {
		
		String sentence = "";
		ImageIcon icon = null;
		try {
			icon = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/Win.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(Game.winner == Constants.BLUE) {
			sentence = "(BLUE) " + Settings.Player2_Name;
		} else {
			sentence = "(RED) " + Settings.Player1_Name;
		}
		
		JLabel labelWin = new JLabel("<html> Congratulation ! <br/>" + sentence + " has WON </html>");
		labelWin.setFont(new Font("Arial", Font.BOLD, 18));
		
		int option = JOptionPane.showConfirmDialog(null,
		labelWin, "Winner", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, icon);
    	if(option == JOptionPane.OK_OPTION){
    		Game.board.init();
    		Game.player.reset();
			reloadBoard();
			repaint();
    	}
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i = 0; i < Settings.Size; i++) {
			for(int j = 0; j < Settings.Size; j++) {
				if(e.getSource() == gameBoard[i][j] && Game.board.getBoard()[i][j] == Constants.EMPTY) {
					System.out.println(i + "," + j);
					Game.board.setBoard(i, j, Game.player.getCurrentPlayerColor());
					Game.player.nextPlayer();
					this.reloadBoard();
					
					if(Settings.GameMode == Constants.GAMEMODE_IA && Game.winner == 0) {
						Game.player.nextPlayerIAFake(i, j);
						/*Location IA = MinMax.getMove(Game.board, Constants.BLUE, 4);
						Game.board.setBoard(IA.i, IA.j, Constants.BLUE);
						System.out.println(IA.toString());
						Game.player.nextPlayer();*/
						//Game.player.nextPlayerIA();
						this.reloadBoard();
						
					}
				}
			}
		}
	}
		
}
	

