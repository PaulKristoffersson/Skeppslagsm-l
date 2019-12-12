package SankaSkepp;

import java.util.*;

import java.io.*;

public class Main {
	static int size = 10;
	static String source = "defaultFleet.txt";
	static int antalSpelare = 0;
	static int computerSkill = 0;

	public static void main(String[] args) {
		int storlek = 0;
		String namn = null;
		Skepp skepp = new Skepp(storlek, namn);
		Spelplan spelplan = null;
		int result = 0;
		while (!(result == -1)) {
			printMenu();
			try {
				Scanner scan = new Scanner(System.in);
				int val = scan.nextInt();
				switch (val) {
				case 1:
					Spelplan plan = new Spelplan();
					char[][] playerOneBoard = new char[10][10];
					playerOneBoard = plan.newBoard(playerOneBoard);
					plan.printBoard(playerOneBoard);
					Skepp.placeraSkepp(skepp);
					Skepp.printKoordinat();
					break;
				case 2:
					try {
						BufferedReader br = new BufferedReader(new FileReader("highscore.txt"));
						// String line = br.readLine();

						// br.close();
						System.out.println(br.readLine());
						System.out.println(br.readLine());
					} catch (IOException e) {
						System.out.println("Hittade ingen fil");
					}

					break;

				case 4:

					System.out.println("H�r skapar du fler skepp!");
					System.out.println("H�r kan du skapa ett skepp. Vilken storlek vill du ha?");
					int storlek2 = scan.nextInt();
					skepp.setStorlek(storlek2);
					scan.nextLine();
					System.out.println("Vad ska skeppet heta?");
					String namn2 = scan.nextLine();
					skepp.setNamn(namn2);
					Skepp.addSkepp(skepp);
					Skepp.printSkepp();
				//	System.out.println(skepp.get(0));
					break;
				case 0:
					System.exit(0);
					break;

				default:
					System.out.println("Ange r�tt siffra!");
				}
			} catch (InputMismatchException e) {
				System.out.println("Ange siffra!");
			}
			// TODO Auto-generated method stub

		}
	}

	private static void printMenu() {
		System.out.println();
		System.out.println("V�lkommen till S�nka Skepp!");
		System.out.println("===========================");
		System.out.println("Skapad av Martin och Paul");
		System.out.println("===========================");
		System.out.println("Meny:");
		// System.out.println("1. �ndra storlek p� spelplan. Nuvarande: " + size);
		// System.out.println("2. �ndra antal m�nskliga spelare. Nuvarande: "+
		// nofHumanPlayers);
		// System.out.println("3. V�lj flotta. Nuvarande:" + source);
		System.out.println("1. Lista skepp i flottan");
		System.out.println("2. Se highscore");
		System.out.println("3. Starta spelet!");
		System.out.println("4. Skapa en egen flotta ");
		System.out.println("0. Avsluta");
		// System.out.println("Ange ditt val som ett heltal, bekr�fta med enter:");
	}

}
