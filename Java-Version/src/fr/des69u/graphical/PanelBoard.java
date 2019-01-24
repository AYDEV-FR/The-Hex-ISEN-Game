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
import javax.swing.JPanel;

import fr.des69u.game.Constants;
import fr.des69u.game.IA;
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
	}
	
	public void paintComponent(Graphics g) {
		Image img = null;
		try {
			img = ImageIO.read(getClass().getResourceAsStream("/Hex_Contour.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		g.drawImage(img, Constants.OFFSET_X - 5, Constants.OFFSET_Y - 4, this);
	}


	private void setGameBoard() {
		for(int i = 0; i < Settings.Size; i++) {
			for(int j = 0; j < Settings.Size; j++) {
				int pos_x = 42*i + 21*j + 2*i + Constants.OFFSET_X;
				int pos_y = 49*j - 11*j +  Constants.OFFSET_Y;
				switch (Game.board.getBoard()[i][j]) {
					case Constants.EMPTY :
						gameBoard[i][j] = new JCaseBoard(pos_x, pos_y, Hex_Simple, false);
						break;
					case Constants.BLUE :
						gameBoard[i][j] = new JCaseBoard(pos_x, pos_y, Hex_Blue, true);
						break;
					case Constants.RED :
						gameBoard[i][j] = new JCaseBoard(pos_x, pos_y, Hex_Red, true);
						break;
					case Constants.WIN_RED:
					case Constants.WIN_BLUE:
						gameBoard[i][j] = new JCaseBoard(pos_x, pos_y, Hex_Ok, true);
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
		removeBoard();
		setGameBoard();
		
		if(Game.board.isWin() == 3) {
			lblGameInfo.setText(Game.player.getCurrentPlayerName() + " WIN");
		} else if (Game.board.isWin() == 4)  {
			lblGameInfo.setText(Game.player.getCurrentPlayerName() + " WIN");
		}
		
		displayBoard();
		//System.out.println("=> " + Game.board.nbSeries(0, 0, Constants.BLUE, 0));
		//Game.board.displayBoard();
		repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i = 0; i < Settings.Size; i++) {
			for(int j = 0; j < Settings.Size; j++) {
				if(e.getSource() == gameBoard[i][j] && Game.board.getBoard()[i][j] == Constants.EMPTY) {
					System.out.println(i + "," + j);
					Game.board.setBoard(j, i, Game.player.getCurrentPlayerColor());
					Game.player.nextPlayer();
					this.reloadBoard();
					if(Settings.GameMode == Constants.GAMEMODE_IA) {
						Game.player.nextPlayerIAFake(i, j);
					}
					this.reloadBoard();
				}
			}
		}
	}
		
}
	

