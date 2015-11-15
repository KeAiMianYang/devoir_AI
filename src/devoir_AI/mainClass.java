package devoir_AI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import model.*;
import view.*;
public class mainClass {

	public static void main(String[] args) throws InterruptedException {
		if(args.length == 0){
			System.out.println("tron [nombre de lignes] [nombre de colonnes]");
			System.exit(0);
		}
		int sizeX = 0;
		int sizeY = 0;
		try{
			sizeX = Integer.parseInt(args[0]);
			sizeY = Integer.parseInt(args[1]);
			if(sizeX < 3 || sizeY < 3){
				throw new NumberFormatException();
			}
		} catch(NumberFormatException e){
			System.err.println("[nombre de lignes] et [nombre de colonnes] doivent tous deux"
					+ "être des nombres supérieur à 3");
			e.printStackTrace();
			System.exit(-1);
		}
		
		GameBoard gb = new GameBoard(sizeX, sizeY);
		Scanner sc = new Scanner(System.in);
		int playerNumber = 1;
		String strEntry = "";
		String[] position = new String[3];
		ArrayList<Player> listP = new ArrayList<Player>();
		
		// Départ de l'application
		do{
			TextView.text_create_player(playerNumber, sizeX-1, sizeY-1);
			position = TextView.text_enter_player(sc, sizeX-1, sizeY-1);
			if(position != null){
				Player p = gb.add_player(Integer.parseInt(position[0]),
						Integer.parseInt(position[1]),
						Direction.get_dir(position[2]));
				System.out.println("p "+p);
				if(p != null){
					++playerNumber;
					listP.add(p);
				}
				if(playerNumber >= 3){
					strEntry = TextView.choose(sc);
				}
			}
		}while(playerNumber < 3 || !strEntry.equals("s"));
		
		
		System.out.println("Début du jeu");
		Game g = new Game();
		TextView tv = new TextView(gb);
		tv.display();
		Thread.sleep(1000);
		ArrayList<Player> listDead = new ArrayList<Player>();  // la liste des morts
		while(listP.size() != listDead.size()+1){
			for(Player p : listP){
				if(!listDead.contains(p)){
					g.play(p, gb);
					if(!p.get_isAlive()){
						listDead.add(p);
					}
				}
			}
			tv.display();
			Thread.sleep(1000);
			
		}
		int winner = 0;
		for(int i=0 ; i<listP.size()-1 ; ++i){
			Player p = listP.get(i);
			if(!listDead.contains(p)){
				winner = i+1;
				break;
			}
		}
		System.out.println("partie terminée,\nle gagnant est le joueur "+winner);
	/*	GameBoard gNord = gb.copy();
		System.out.println(gNord.getListShips()+" "+gb.getListShips());
		
		TextView tv2 = new TextView(gNord);
		tv2.display();
		
		/*tv.display();
		
		p2.move(Direction.WEST);
		
		tv.display();
		
		p2.move(Direction.SOUTH);
		
		tv.display();
		
		p2.move(Direction.NORTH);
		
		tv.display();*/
		
		
	} // Main(String[])
	

}
