package SankaSkepp;

import java.lang.reflect.Array;
import java.util.Scanner;

public class Spelplan {

	/*public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		final char Tom = '.';
		String[][] Board = new String[10][10];

		String[][] positioner = { { ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ ".", ".", ".", ".", ".", ".", ".", ".", ".", "9" },
				{ ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ ".", ".", ".", ".", ".", ".", ".", ".", ".", "10" },

		};

		for (int row = 0; row < Board.length; row++) {
			for (int column = 0; column < Board[row].length; column++) {
				System.out.print(positioner[row][column] + "\t");
			}
			System.out.println("\n");

		}
		System.out.println(positioner[1][9]);
		System.out.println(positioner[9][9]);
	}*/

	public void printBoard(char[][] a) {

		System.out.print("  0 1 2 3 4 5 6 7 8 9" + "\n");

		char K = 'A';
		for (int b = 0; b < 10; b++) {
			System.out.print(K + " ");
			K++;
			for (int c = 0; c < 10; c++) {
				System.out.print(a[c][b] + " ");

			}
			System.out.println("");
		}

	}

	public char[][] newBoard(char[][] player) {

		for (int y = 0; y < 10; y++) {
			for (int x = 0; x < 10; x++) {
				player[x][y] = '~';

			}
		}
		return player;
	}

	/*
	 * for (int[] a : board) { for (int i : a) { System.out.print("." + "\t"); }
	 * System.out.println("\n"); } }
	 */

	/*
	 * private int numRader = 10;
	 * 
	 * private int numKolumner = 10;
	 * 
	 * public Spelplan(int numRader, int numKolumner) {
	 * 
	 * this.numRader = numRader; this.numKolumner = numKolumner; this.Board = new
	 * char [numKolumner][numRader]; for (int k = 0; k <numKolumner; k++) { for (int
	 * r = 0; r<numRader; r++) { this.Board[k][r] = Spelplan.Tom; } } }
	 * 
	 * void print() { for(int i=0; i<numRader; i++) { System.out.print(i); }
	 * System.out.println(); for (int i = 0; i<=numKolumner; i++) {
	 * System.out.format("%4d  |",i); for(int j=0;j<=numRader;j++) {
	 * System.out.print(j); } System.out.println(); } }
	 * 
	 * public char[][] getBoard() { return Board; }
	 * 
	 * public void setBoard(char[][] board) { Board = board; }
	 * 
	 * public int getNumRader() { return numRader; }
	 * 
	 * public void setNumRader(int numRader) { this.numRader = numRader; }
	 * 
	 * public int getNumKolumner() { return numKolumner; }
	 * 
	 * public void setNumKolumner(int numKolumner) { this.numKolumner = numKolumner;
	 * }
	 * 
	 * public void addaFlotta() {
	 * System.out.println("Nu ska du lägga till pjäser i flottan!"); int [] båtEtt =
	 * {1,2}; int [] båtTvå = {1,2,3}; int [] båtTre = {1,2,3,4}; int [] båtFyra =
	 * {1,2,3,4,5}; System.out.println("Lägg till båt 1 som är av storlek 2! ");
	 * 
	 * 
	 * }
	 * 
	 * public char[][] show() { for (int i=0; i < numRader; i++) { for(int j=0;
	 * j<numKolumner; j++) { System.out.println(Board); } } return Board; }
	 */
}