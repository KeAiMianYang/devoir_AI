//HOW TO: faire une classe Test
package devoir_AI;
//import junit OU crée un fichier JUnit Test Case
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
// import org.junit.*;

import model.*;

/**
 * @author kork
 *
 */
public class BaseModelTest {
	static GameBoard a_gBoard = null;

	// La methode @BeforeClass doit être static car elle est appellée avant que BaseModelTest soit instanciée
	@BeforeClass
	public static void before_class(){
		a_gBoard = new GameBoard(5, 5);
	}
	// La methode @Before est appelée avant chaque appel d'une methode @Test
	@Before
	public void before(){
		// I AM GROOT
	}
	// Une classe de Test
	// Là aucun assert est mit car on s'en fous, mais en théorie mettre des asserts est mieux pour tester
	@Test
	public void test() {
		
		Player playerOne = a_gBoard.add_player(2,2,Direction.NORTH);
		Player playerTwo = a_gBoard.add_player(3,1,Direction.SOUTH);
		
		System.out.println(playerOne);
		
		for (int i=0; i< a_gBoard.get_length(); i++ ){
			for(int j=0; j<a_gBoard.get_width(); j++){
				if(a_gBoard.get_element(i, j) == null) continue; //TOREMOVE
				System.out.println("x="+i+" y="+j+" -> "+a_gBoard.get_element(i,j));
			}
		}
		
		playerOne.move(Direction.EAST);
		System.out.println("\ntableau apres deplacement EAST");
		// 2, 2 -> 2, 3
		
		System.out.println(playerOne);
		
		for (int i=0; i< a_gBoard.get_length(); i++ ){
			for(int j=0; j<a_gBoard.get_width(); j++){
				if(a_gBoard.get_element(i, j) == null) continue; //TOREMOVE
				System.out.println("x="+i+" y="+j+" -> "+a_gBoard.get_element(i,j));
			}
		}
	}
	// Methode executée après chaque appel d'une methode @Test
	@After
	public void after(){
		// RIEN GNEUUUUUUUUUH
	}
	// Dernière méthode executée
	@AfterClass
	public void after_class(){
		// HODOR
	}

}
