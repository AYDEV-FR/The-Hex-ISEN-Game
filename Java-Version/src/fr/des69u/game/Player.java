package fr.des69u.game;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.swing.text.Position;
import javax.tools.DocumentationTool.Location;

import fr.des69u.main.Game;

public class Player {

	private int currentPlayerColor = Constants.RED;
	
	public Player() {
		
	}
	
	public int getCurrentPlayerColor() {
		return this.currentPlayerColor;
	}
	
	public String getCurrentPlayerName() {
		String name;
		if(currentPlayerColor == Constants.RED) {
			name = "(RED) " + Settings.Player1_Name;
		} else {
			name = "(BLUE) " + Settings.Player2_Name;
		}
		return name;
	}


	public void nextPlayer() {
		if(currentPlayerColor == Constants.RED) {
			currentPlayerColor = Constants.BLUE;
		} else {
			currentPlayerColor = Constants.RED;
		}
	}

	public void nextPlayerIA() {
	
		IA ia = new IA();
		ia.IA_Play();
		System.out.println(ia.getMax_i());
		System.out.println(ia.getMax_j());
		this.nextPlayer();
	}
	
	
	public void reset() {
		this.currentPlayerColor = Constants.RED;
		Game.winner = 0;
	}
	
	
	public void nextPlayerIAFake(int i, int j) {
		int rnd = 0;
		int rnd_i = 0;
		int rnd_j = 0;
		int nb = 0;
		
		ArrayList<int[]> coup = new ArrayList<>();
		coup.add(new int[] {-1, 2});
		coup.add(new int[] {-1, 2});
		coup.add(new int[] {-1, 2});
		coup.add(new int[] {0, 2});
		coup.add(new int[] {0, 1});
		coup.add(new int[] {0, 1});
		coup.add(new int[] {-1, -1});
		coup.add(new int[] {-1, 0});
		coup.add(new int[] {1, 1});
		
		
		do {
			 rnd = (int) (Math.random() * ( 9 ));
			 nb++;
			 if(nb > 10) {
				 System.out.println("Reel Random");
				 break;
			 }
		} while(
			i + coup.get(rnd)[1] < 0
			|| j + coup.get(rnd)[0] < 0
			|| i + coup.get(rnd)[1] >= Settings.Size
			|| j + coup.get(rnd)[0] >= Settings.Size
			|| !Game.board.isEmpty(i + coup.get(rnd)[1], j + coup.get(rnd)[0])
		);
		
		
		if(nb <= 10) {
			System.out.println(coup.get(rnd)[0] + ";" + coup.get(rnd)[1]);
			Game.board.setBoard(i + coup.get(rnd)[1], j + coup.get(rnd)[0], Constants.BLUE);
		} else {
			
			do {
				 rnd_i = (int) (Math.random() * ( Settings.Size-1 ));
				 rnd_j = (int) (Math.random() * ( Settings.Size-1 ));
			} while(!Game.board.isEmpty(rnd_i, rnd_j));
			System.out.println(rnd_i + "-" + rnd_j);
			Game.board.setBoard(rnd_i, rnd_j, Constants.BLUE);
		}
		
		
		this.nextPlayer();
	}
}
