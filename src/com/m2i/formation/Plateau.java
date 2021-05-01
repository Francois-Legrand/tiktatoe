package com.m2i.formation;

public class Plateau {
	public Case[][] cases = new Case[3][3];
	
	public void afficher() {
		for(Case[] ligne : cases) {
			for(Case c : ligne) {
				System.out.print("|");
				if(c != null) {
					System.out.print(" " + c.contenu + " ");
				} else {
					System.out.print("   ");
				}
			}
			System.out.println("|");
			System.out.println("-------------");
		}
	}
	
	public boolean estPlein() {
		for(Case[] ligne : cases) {
			for(Case c : ligne) {
				if(c == null) {
					return false;
				}
			}
		}
		return true;
	}
}
