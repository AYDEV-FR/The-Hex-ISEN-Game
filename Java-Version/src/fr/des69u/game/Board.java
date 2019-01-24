package fr.des69u.game;


public class Board {

	private int[][] board; 
		
	public Board() {
		this.init();
		System.out.println("Board Initialisé avec succés");
	}
	
	public Board(Board cboard) {
		this.init();
		for(int i = 0; i < Settings.Size ; i++) {
			for(int j = 0; j < Settings.Size ; j++) {
				this.board[j][i] = cboard.getBoard()[j][i];
			}
		}
		System.out.println("Board Initialisé avec succés");
	}
	
	public void displayBoard(){
		for(int i = 0; i < Settings.Size ; i++) {
			for(int j = 0; j < Settings.Size ; j++) {
				System.out.print(board[j][i]);
			}
			System.out.println("");
		}
		System.out.println("===================");
	}
	
	public int[][] getBoard(){
		return this.board;
	}
	
	public int getBoard(int i, int j) {
		return this.board[i][j];
	}
	
	public void init() {
		this.board = new int[Settings.Size][Settings.Size];
	}
	
	public void setBoard(int x, int y, int a) {
		this.board[y][x] = a;
	}
	
	public boolean isEmpty(int i, int j) {
		return this.board[i][j] == Constants.EMPTY;
	}
	
	public int isWin() {
		for (int i = 0; i < Settings.Size; i++) {
		    if(this.board[0][i] == Constants.RED && findPath(0, i, 1)){
		      return Constants.RED;
		    }
		  }
		  for (int i = 0; i < Settings.Size; i++) {
		    if(this.board[i][0] == Constants.BLUE && findPath( i, 0, 2)){
		      return Constants.BLUE;
		    }
		  }
		  return 0;
	}
	
	public boolean findPath(int x, int y, int n) {
		    if(n == Constants.RED) this.board[x][y] = Constants.WIN_RED;
		    if(n == 2) this.board[x][y] = Constants.WIN_BLUE;

		    if (n == Constants.RED && x == Settings.Size - 1) {
		        return true;
		    }
		    if (n == Constants.BLUE && y == Settings.Size - 1) {
		        return true;
		    }
		    if (x + 1 < Settings.Size && this.board[x + 1][y] == n) {
		        if (findPath(x + 1, y, n)) {
		            return true;
		        }
		    }
		    if (x - 1 >= 0 && this.board[x - 1][y] == n) {
		        if (findPath(x - 1, y, n)) {
		            return true;
		        }
		    }
		    if (y + 1 < Settings.Size && this.board[x][y + 1] == n) {
		        if (findPath(x, y + 1, n)) {
		            return true;
		        }
		    }
		    if (y - 1 >= 0 && this.board[x][y - 1] == n) {
		        if (findPath(x, y - 1, n)) {
		            return true;
		        }
		    }
		    if (y - 1 >= 0 && x + 1 < Settings.Size && this.board[x + 1][y - 1] == n) {
		        if (findPath(x + 1, y - 1, n)) {
		            return true;
		        }
		    }
		    if (y + 1 < Settings.Size && x - 1 >= 0 && this.board[x - 1][y + 1] == n) {
		        if (findPath(x - 1, y + 1, n)) {
		            return true;
		        }
		    }
		    this.board[x][y] = n;
		    return false;
		}
	
	
	
	
	
	}




