package com.m2i.formation;

import java.util.Random;
import java.util.Scanner;

public class Jeu {
	
	// Le jeu, il a...
	// - Deux joueurs
	// - Un plateau
	public Joueur joueur1;
	public Joueur joueur2;
	public Plateau plateau;
	
	Scanner scanner = new Scanner(System.in);
	
	public void demarrer() {
		if(joueur1 == null || joueur2 == null || plateau == null) {
			System.out.println("Il y a une erreur");
			return;
		}
		
		int alea = new Random().nextInt(2);
		// Tant que personne n'a gagn�, on continue
		while(!joueur1.gagne && !joueur2.gagne && !plateau.estPlein()) {
			plateau.afficher();
			if(alea == 0) {
				System.out.println("Au joueur 1 !");
				demander(joueur1);
				alea = (alea + 1) % 2;
			} else {
				System.out.println("Au joueur 2 !");
				demander(joueur2);
				alea = (alea + 1) % 2;
			}
			verifier(joueur1);
			verifier(joueur2);
		}
		fin();
	}
	
	public void demander(Joueur joueur) {
		
		int col = -1;
		int lig = -1;
		
		while(col < 0) {
			System.out.println("Quelle colonne ?");
			String colStr = scanner.nextLine();
			
			try {
				col = Integer.parseInt(colStr);
				if(col > 2 || col < 0) {
					throw new NumberFormatException();
				}
			} catch(NumberFormatException e) {
				System.out.println("Non, c'est pas un nombre valable");
				col = -1;
			}
		}

		while(lig < 0) {
			System.out.println("Quelle ligne ?");
			String ligStr = scanner.nextLine();
			try {
				lig = Integer.parseInt(ligStr);
				if(lig > 2 || lig < 0) {
					throw new NumberFormatException();
				}
			} catch(NumberFormatException e) {
				lig = -1;
				System.out.println("Non, c'est pas un nombre valable");
			}
		}
		
		
		// Ici, on a col et lig qui sont des nombres, normalement
		// entre 0 et 2.
		if(plateau.cases[lig][col] != null) {
			System.out.println("La case existe d�j� !");
			demander(joueur);
			return;
		}
		plateau.cases[lig][col] = new Case();
		plateau.cases[lig][col].contenu = joueur.forme;
	}
	
	public void verifier(Joueur joueur) {
		if(
				plateau.cases[0][0] != null && plateau.cases[0][0].contenu == joueur.forme &&
				plateau.cases[0][1] != null && plateau.cases[0][1].contenu == joueur.forme && 
				plateau.cases[0][2] != null && plateau.cases[0][2].contenu == joueur.forme
		) {
			joueur.gagne = true;
		} else if(
				plateau.cases[1][0] != null && plateau.cases[1][0].contenu == joueur.forme &&
				plateau.cases[1][1] != null && plateau.cases[1][1].contenu == joueur.forme &&
				plateau.cases[1][2] != null && plateau.cases[1][2].contenu == joueur.forme) {
			joueur.gagne = true;
		} else if(
				plateau.cases[2][0] != null && plateau.cases[2][0].contenu == joueur.forme &&
				plateau.cases[2][1] != null && plateau.cases[2][1].contenu == joueur.forme &&
				plateau.cases[2][2] != null && plateau.cases[2][2].contenu == joueur.forme) {
			joueur.gagne = true;
		} else if(
				plateau.cases[0][0] != null && plateau.cases[0][0].contenu == joueur.forme &&
				plateau.cases[1][0] != null && plateau.cases[1][0].contenu == joueur.forme &&
				plateau.cases[2][0] != null && plateau.cases[2][0].contenu == joueur.forme) {
			joueur.gagne = true;
		} else if(
				plateau.cases[0][1] != null && plateau.cases[0][1].contenu == joueur.forme &&
				plateau.cases[1][1] != null && plateau.cases[1][1].contenu == joueur.forme &&
				plateau.cases[2][1] != null && plateau.cases[2][1].contenu == joueur.forme) {
			joueur.gagne = true;
		} else if(
				plateau.cases[0][2] != null && plateau.cases[0][2].contenu == joueur.forme &&
				plateau.cases[1][2] != null && plateau.cases[1][2].contenu == joueur.forme && 
				plateau.cases[2][2] != null && plateau.cases[2][2].contenu == joueur.forme) {
			joueur.gagne = true;
		} else if(
				plateau.cases[0][0] != null && plateau.cases[0][0].contenu == joueur.forme && 
				plateau.cases[1][1] != null && plateau.cases[1][1].contenu == joueur.forme && 
				plateau.cases[2][2] != null && plateau.cases[2][2].contenu == joueur.forme) {
			joueur.gagne = true;
		} else if(
				plateau.cases[0][2] != null && plateau.cases[0][2].contenu == joueur.forme && 
				plateau.cases[1][1] != null && plateau.cases[1][1].contenu == joueur.forme && 
				plateau.cases[2][0] != null && plateau.cases[2][0].contenu == joueur.forme) {
			joueur.gagne = true;
		}
	}
	
	public void fin() {
		// Quand on arrive ici :
		// - Soit le joueur1 a gagn�
		// - Soit le joueur2 a gagn�
		// - Soit le plateau est plein
		if(joueur1.gagne) {
			System.out.println("Le joueur 1 a gagn� !");
		} else if(joueur2.gagne) {
			System.out.println("Le joueur 2 a gagn� !");
		} else {
			System.out.println("Egalit� !");
		}
		scanner.close();
	}
	
}
