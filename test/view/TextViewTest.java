package view;

import model.*;
import view.*;
import static org.junit.Assert.*;

import org.junit.Test;
/**
 * classe testant le bon fonctionnement des methodes d'affichage
 * @author kork
 *
 */
public class TextViewTest {

	@Test
	public void test() {
		
		GameBoard gb = new GameBoard(3, 6);
		TextView tv = new TextView(gb);
		
		
		Player p = gb.add_player(2, 3, Direction.NORTH);
		tv.display_simple();
		System.out.println("\nAffichage visuel:");
//		display(gb);
		tv.display();
		
		p.move(Direction.NORTH);
		
//		display(gb);
		tv.display();
		
		p.move(Direction.EAST);
		
//		display(gb);
		tv.display();
		
	}

}
