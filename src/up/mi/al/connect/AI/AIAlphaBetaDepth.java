package up.mi.al.connect.AI;

import java.util.ArrayList;

public class AIAlphaBetaDepth implements AI {

	private boolean player1;
	private int depth;

	public AIAlphaBetaDepth(boolean player1, int depth) {
		this.player1 = player1;
		this.depth = depth;
	}

	@Override
	public int computePlay(int[][] board, int linkSize) {
		BoardNodeAlphaBeta node = new BoardNodeAlphaBetaDepth(board, linkSize, player1, depth);

		int[] values = node.computePlayValues();
		

		ArrayList<Integer> options = new ArrayList<>();
		boolean emptyCheck = true;
		for (int i = 0; i < values.length; i++) {
			if (node.canPlayIn(i)) {
//				// DO YOU LIKE LOGIC GATES??? I DO!!!
//
//				boolean op = values[i] > 0; 
//				boolean on = values[i] < 0; 
//				boolean vn = values[options.get(0)] < 0; 
//				boolean vp = values[options.get(0)] > 0; 
//				boolean v0 = values[options.get(0)] == 0; 
//				boolean vo = values[i] < values[options.get(0)]; 
//
//				boolean result = emptyCheck || (!op && vp) || (on && v0) || (on && vn && vo) || (vp && vo);

				//
				if(!emptyCheck && values[i] == values[options.get(0)])
					options.add(i);
					//check if either option is empty or if the value of the placement i is batter than those currently stored
				else if (emptyCheck || (!(values[options.get(0)] > 0) && values[i] > 0) ||
						(values[options.get(0)] < 0 && values[i] == 0) || 
						(values[options.get(0)] < 0 && values[i] < values[options.get(0)]) || 
						(values[i] > 0 && values[i] < values[options.get(0)])) {
					emptyCheck = false;
					options.clear();
					options.add(i);
				} 
			}
		}
		
		return options.get((int)(Math.random() * options.size()));
	}

}
