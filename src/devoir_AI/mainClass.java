package devoir_AI;
import model.*;
public class mainClass {

	public static void main(String[] args) {
		GameBoard gBoard = new GameBoard(5,5);
		
		Player playerOne = gBoard.add_player(2,2,Direction.NORTH);
		Player playerTwo = gBoard.add_player(3,1,Direction.SOUTH);
		
		System.out.println(playerOne);
		
		for (int i=0; i< gBoard.get_length(); i++ ){
			for(int j=0; j<gBoard.get_width(); j++){
				System.out.println("x="+i+" y="+j+" -> "+gBoard.get_element(i,j));
			}
		}
		
		playerOne.move(Direction.EAST);
		System.out.println("\ntableau apres deplacement");
		
		System.out.println(playerOne);
		
		/*for (int i=0; i< gBoard.get_length(); i++ ){
			for(int j=0; j<gBoard.get_width(); j++){
				System.out.println("x="+i+" y="+j+" -> "+gBoard.get_element(i,j));
			}
		}*/
		
		
	}

}
