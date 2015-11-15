package devoir_AI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import model.*;
import view.*;
public class mainClass {

	public static void main(String[] args) throws InterruptedException {
/*
		if(args.length == 0){
			System.out.println(" veuillez entrer:\ntron [nombre de lignes] [nombre de colonnes]");
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
	*/	
		Scanner sc = new Scanner(System.in);
		int sizeX=0;
		int sizeY=0;
		while(sizeX < 3 && sizeY < 3){
			System.out.println("Veuillez entrer les dimmensions de votre plateau "
					+ "de la façon suivante:\n'nombre de lignes nombre de colonnes'\n"
					+ "le tableau doit être au minimum un 3x3");
			sizeX = sc.nextInt();
			sizeY = sc.nextInt();
		}
		
		
		GameBoard gb = new GameBoard(sizeX, sizeY);
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
		Thread.sleep(500);
		ArrayList<Player> listDead = new ArrayList<Player>();  // la liste des morts
		while(listP.size() > listDead.size()+1){
			for(Player p : listP){
				if(!listDead.contains(p)){
					g.play(p, gb);
					if(!p.get_isAlive()){
						listDead.add(p);
					}
				}
			}
			tv.display();
			Thread.sleep(500);
			
		}
		int winner = 0;
		for(int i=0 ; i<listP.size()-1 ; ++i){
			Player p = listP.get(i);
			if(!listDead.contains(p)){
				winner = i+1;
				break;
			}
		}
		System.out.println("Partie terminée,");
		if(winner > 0)
			System.out.println("Le gagnant est le joueur "+winner);
		else
			System.out.println("match null");
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
