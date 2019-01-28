package fr.des69u.game;

import fr.des69u.main.Game;

public class IA {

	private final int profondeur = 2;
	private int max_i, max_j, max = -1000, tmp_profondeur;
	private Board cboard;
	
	public IA() {
		this.cboard = new Board(Game.board);
		this.cboard.displayBoard();
	}
	
	public void IA_Play() {
		for(int i = 0; i < Settings.Size ; i++) {
			for(int j = 0; j < Settings.Size ; j++) {
				if(this.cboard.isEmpty(j, i)) {
					this.cboard.setBoard(i, j, Constants.BLUE);
					this.tmp_profondeur = this.profondeur;
					int tmp = min();
					System.out.println(tmp);
					if(tmp > max){
                          max = tmp;
                          this.max_i = i;
                          this.max_j = j;
                    }
					
					this.cboard.setBoard(i, j, Constants.EMPTY);
				}
			}
		}
		System.out.println("Last Max : " + max);
		this.cboard.setBoard(max_i, max_j, Constants.BLUE);
		Game.board.setBoard(max_j, max_i, Constants.BLUE);
		this.cboard.displayBoard();
	}

	
	private int min() {
		if(this.tmp_profondeur == 0 || this.cboard.isWin() != 0){
			return MinMax.basicEval(this.cboard, 1);
	     }
		 this.tmp_profondeur--;
		 System.out.println("==============================" + this.tmp_profondeur);
		 int min = 1000;
		 for(int i = 0; i < Settings.Size ; i++) {
				for(int j = 0; j < Settings.Size ; j++) {
					if(this.cboard.isEmpty(j, i)) {
						this.cboard.setBoard(i, j, Constants.RED);
						//this.cboard.displayBoard();
						int tmp = max();
						System.out.println("MIN : " + tmp);
						 if(tmp < min){
	                            min = tmp;
	                      }
						 this.cboard.setBoard(i, j, Constants.EMPTY);
					}
				}
		 }
		 return min;
	}
	
	private int max() {
		
		if(this.tmp_profondeur == 0 || this.cboard.isWin() != 0){
	          return MinMax.basicEval(this.cboard, 2);
	     }
		 this.tmp_profondeur--;
		 System.out.println("==============================" + this.tmp_profondeur);
		 int max = -1000;
		 for(int i = 0; i < Settings.Size ; i++) {
				for(int j = 0; j < Settings.Size ; j++) {
					if(this.cboard.isEmpty(j, i)) {
						this.cboard.setBoard(i, j, Constants.BLUE);
						//this.cboard.displayBoard();
						int tmp = min();
						System.out.println("MAX : " + tmp);
						 if(tmp > max){
	                            max = tmp;
	                      }
						 this.cboard.setBoard(i, j, Constants.EMPTY);
					}
				}
		 }
		 return max;
	}
	
	
	private int eval() {
		int random = (int) (-1000 + Math.random() * (1000 + 1000));
		return random;
	}
	
	
	
	
	public int getMax_i() {
		return max_i;
	}


	public int getMax_j() {
		return max_j;
	}
	
}
