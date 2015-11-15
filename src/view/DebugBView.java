package view;

public class DebugBView {
	public static void array_int_view(int[][] i_board){
		for(int i=0 ; i<i_board.length ; ++i){
			for(int j=0 ; j<i_board[0].length ; ++j){
				System.out.print("["+i_board[i][j]+"]");
			}
			System.out.println();
		}
	}
}
