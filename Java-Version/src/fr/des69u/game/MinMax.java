package fr.des69u.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MinMax {

	
	
	
	
	public static int basicEval(Board board, int player) {
		int score = 0;
		int h_score, l_score, m_score;
		ArrayList<Location> coords = getPossibleMoves(board, player);
		
		if(player == Constants.RED) {
			h_score = 7;
			m_score = 2;
			l_score = 1;
		}else {
			 h_score = 1;
			 m_score = 2;
			 l_score = 7;
		}
		
		
		while(coords.size() > 0) {
			Location point = coords.remove(0);
			ArrayList<Location> contact_points_v = new ArrayList<>(
					Arrays.asList(
						new Location(point.i, point.j + 1),
						new Location(point.i, point.j - 1)
						));
			ArrayList<Location> contact_points_m = new ArrayList<>(
					Arrays.asList(
						new Location(point.i - 1, point.j + 1),
						new Location(point.i + 1, point.j - 1)
						));
			ArrayList<Location> contact_points_h = new ArrayList<>(
					Arrays.asList(
						new Location(point.i - 1, point.j),
						new Location(point.i + 1, point.j)
						));
			
			for(Location pts : coords) {
				for(Location cpv : contact_points_v) {
					if(cpv.isEquals(pts)) {
						score += l_score;
					}
				}
				for(Location cpl : contact_points_h) {
					if(cpl.isEquals(pts)) {
						score += h_score;
					}
				}
				for(Location cpm : contact_points_m) {
					if(cpm.isEquals(pts)) {
						score += m_score;
					}
				}
			}
		}
		
		return score;
	}
	
	
	private static ArrayList<Location> getPossibleMoves(Board board, int player) {
		ArrayList<Location> possibleMove = new ArrayList<>();
		for(int i = 0; i < Settings.Size; i++) {
			for(int j = 0; j < Settings.Size; j++) {
				if(board.getBoard(i,j) == player) possibleMove.add(new Location(i, j));
			}
		}
		return possibleMove;
	}
	
	private static Board playMove(Board board, int player, Location move) {
		Board new_board = new Board(board);
	    new_board.setBoard(move.i, move.j, player);
	    //new_board.displayBoard();
	    return new_board;
	}
	
	public static Location getMove(Board board, int player, int depth_max) {
		ArrayList<Location> possibleMoves = getPossibleMoves(board, 0);
		ArrayList<Integer> scores = new ArrayList<>();
		ArrayList<Integer> index_best_move = new ArrayList<>();
		
		for(Location move : possibleMoves) {
			int score = minimaxRec(playMove(board, player, move), player, 1, depth_max);
			scores.add(score);
		}
		
		System.out.println(scores.toString());
		
		int max_score = Collections.max(scores);
		for(int i = 0; i < scores.size(); i++) {
			if(scores.get(i) == max_score) index_best_move.add(i);
		}
		int random = (int)(Math.random() * index_best_move.size());
		return possibleMoves.get(index_best_move.get(random));
	}	


	private static Integer minimaxRec(Board board, int player, int depth, int depth_max) {
		ArrayList<Integer> scores = new ArrayList<>();
		
				
		if(depth == depth_max) return basicEval(board, player);
		int new_depth = depth + 1;
		
		for(Location move : getPossibleMoves(board, 0)) {
			scores.add(minimaxRec(playMove(board, player, move), player, new_depth, depth_max));
		}

		// GAME OVER
	    if(scores.size() == 0) {
	    	return basicEval(board, player);
	    } 

	    if (depth % 2 == 1) {
	        return Collections.max(scores);
	    } else {
	        return Collections.min(scores);
		}
	}
		
	
	private int alpha_beta_negamax(Board board, int player, int depth, int alpha, int beta) {
		if(depth == 1) return basicEval(board, player);
		ArrayList<Location> possibleMoves = getPossibleMoves(board, 0);
		if(possibleMoves.size() == 0) return basicEval(board, player);
		
		int best = -1000000;
		for(Location move : possibleMoves) {
			int v = -alpha_beta_negamax(playMove(board, player, move), player, depth - 1, -beta, -alpha);
			if(v > best) {
				best = v;
				if(best > alpha) {
					alpha = best;
					if(alpha >= beta) {
						return best;
					}
				}
			}
		}
		
		return best;
		
	}	
	
}
