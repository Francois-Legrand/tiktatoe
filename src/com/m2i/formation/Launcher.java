package com.m2i.formation;

public class Launcher {
	// Le lancement.
	// - Un jeu
	public static void main(String[] args) {
		// Programme de TicTacToe (Morpion)
		// - Deux joueurs :
		// 	- Un avec la croix
		//  - L'autre avec le rond
		// - Un plateau de 3x3 cases
		// - Chaque joueur joue l'un après l'autre
		// 	- Si une ligne ou diagonale est entièrement
		// 	  croix ou rond, c'est gagné pour le joueur
		// - Dès qu'un joueur a gagné, c'est fini
		Jeu jeu = new Jeu();
		Joueur j1 = new Joueur();
		j1.forme = "x";
		
		Joueur j2 = new Joueur();
		j2.forme = "o";
		
		Plateau plateau = new Plateau();
		jeu.joueur1 = j1;
		jeu.joueur2 = j2;
		jeu.plateau = plateau;
		
		jeu.demarrer();

	}

}
