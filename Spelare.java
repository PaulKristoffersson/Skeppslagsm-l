package SankaSkepp;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Spelare {
	private int lengd = 0;
	private String namn = null;
	private int storlek = 10;
	private int index = 0;
	private int liv = 0;
	LinkedList<Koordinater> skeppKoordinater = new LinkedList<Koordinater>();
	Skepp skepp = new Skepp(lengd, namn, skeppKoordinater);
	private static LinkedList<Skepp> skeppar = new LinkedList<Skepp>();
	Spelplan plan = new Spelplan();
	Scanner scan = new Scanner(System.in);
	LinkedHashMap<Koordinater, Bitar> map = new LinkedHashMap<Koordinater, Bitar>();
	LinkedHashMap<Koordinater, Bitar> map2 = new LinkedHashMap<Koordinater, Bitar>();
	
	
	/*public int spelareLiv(int c) {
		return c;
	}
	
	public boolean leverSpelare(int c) {
		if ( c !=0) {
			return true;
		}
		else {
			return false;
		}
	}*/
	
	public void printSkepp() {
		for (Skepp obj : skeppar) {
			System.out.println(obj);
		}
	}
	
	public static void addSkepp(Skepp c) {
		skeppar.add(c);
//		index++;
	}
	
	public void skapaSkepp() {
		Skepp skepp = new Skepp(lengd, namn,skeppKoordinater);
		System.out.println("Här skapar du fler skepp!");
		System.out.println("Här kan du skapa ett skepp. Vilken storlek vill du ha?");
		int storlek2 = scan.nextInt();
		skepp.setStorlek(storlek2);
		//spelareLiv(storlek2);
		scan.nextLine();
		System.out.println("Vad ska skeppet heta?");
		String namn2 = scan.nextLine();
		skepp.setNamn(namn2);
		skepp.setSkeppKoordinater(null);
		Spelare.addSkepp(skepp);
		printSkepp();
	}	
	
	public String toString() {
		if (this.skeppKoordinater == null) {
			return ("Namn:" + this.namn + " Storlek: " + this.storlek + "\n");
		}
		else {
			return ("Namn:" + this.namn + " Storlek: " + this.storlek + "\n" + "Koordinater " + this.skeppKoordinater);
		}
	}
	
	public void printBoard() {
		System.out.println("  | 0 1 2 3 4 5 6 7 8 9");
		System.out.println("--+--------------------");
		char K = 'A';
		for (Koordinater nycklar : map.keySet()) {

			if (nycklar.toString().charAt(1) == '0') {
				System.out.print(K + " | ");
				K++;
			}

			System.out.print(map.get(nycklar) + " ");

			if (nycklar.toString().charAt(1) == '9') {
				System.out.println("");
			}

			System.out.print("");
		}
	}
	
	public Bitar lookup(Koordinater nyckel) {
		return map.get(nyckel);
	}

	public void newBoard() {
		int storlek = 10;
		char temp = 'A';
		String nycklar = "";
		for (int y = 0; y < storlek; y++) {
			for (int x = 0; x < storlek; x++) {
				nycklar = "" + temp + x;
				map.put(new Koordinater(nycklar), new Bitar('~'));
			}
			temp++;
		}
		// printBoard();
	}
	
	public void newEnemyBoard() {
		int storlek = 10;
		char temp = 'A';
		String nycklar = "";
		for (int y = 0; y < storlek; y++) {
			for (int x = 0; x < storlek; x++) {
				nycklar = "" + temp + x;
				map2.put(new Koordinater(nycklar), new Bitar('~'));
			}
			temp++;
		}
	}
	
	public void printEnemyBoard() {
		System.out.println("  | 0 1 2 3 4 5 6 7 8 9");
		System.out.println("--+--------------------");
		char K = 'A';
		for (Koordinater nycklar : map2.keySet()) {

			if (nycklar.toString().charAt(1) == '0') {
				System.out.print(K + " | ");
				K++;
			}

			System.out.print(map2.get(nycklar) + " ");

			if (nycklar.toString().charAt(1) == '9') {
				System.out.println("");
			}

			System.out.print("");
		}
	}

	public boolean riktning() {
		System.out.println("Ange h för horisontellt eller v för vertikalt: ");
		Scanner scan = new Scanner(System.in);
		String val = scan.nextLine();
		if (val.equals("h")) {
			return true;
		}else {
			return false;
		}
	}
	
	/*public void markeraSkott() {
		Scanner scan = new Scanner(System.in);
		String koordinater = scan.nextLine();
		skjutSkepp(koordinater);
		while (skjutSkepp(koordinater)!=true) {
			System.out.println("Du har redan skjutit här. Skriv en annan koordinat: ");
			koordinater = scan.nextLine();
			skjutSkepp(koordinater);
		}
		
		printBoard();
	}*/
	
	/*public void markeraSkott(boolean e) {
 
		if (e == true) {
			skjutSkepp();
		}
		printBoard();
	}*/
	
	/*public void skjutSkepp() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Vart vill du skjuta? ");
        String koordinater = scan.nextLine();
        char yLed = koordinater.charAt(0);
        int xLed = koordinater.charAt(1)-48;
        
        char hashtag = '#';
        char miss = '0';
        char träff = '1';
        
        boolean miss1 = true;
        boolean hit1 = true;
        boolean redan = false;
        
        Bitar boatpiece = new Bitar(hashtag);
        Bitar boatpiece2 = new Bitar(miss);
        Bitar boatpiece3 = new Bitar(träff);
        
        for (Koordinater nycklar : map.keySet()) {
            String kollaNyckel = "" + yLed + xLed;
            //System.out.println(kollaNyckel);
            if(kollaNyckel.equals(nycklar.toString())) {
            	Koordinater replaceCoords = new Koordinater(kollaNyckel);
            	
            	if(lookup(nycklar).toString().contains("#")) {
            		System.out.println("Du träffade!");
            		map.put(replaceCoords, boatpiece3);
            		boolean e = false;
            		markeraSkott(e);
            	}
            	else if(lookup(nycklar).toString().contains("~")) {
            		System.out.println("Du missade!");
            		map.put(replaceCoords, boatpiece2);
            		boolean e = false;
            		markeraSkott(e);
            	}
            	else {
            		System.out.println("Du har redan skjutit här");
            		boolean e = true;
            		markeraSkott(e);
            	}
            	
            	
            }
        }
        
       // printBoard();

    }*/
	public void markeraSkott(boolean c , boolean d, boolean e, Koordinater replaceCoords) {
        char hashtag = '#';
        char miss = '0';
        char träff = '1';
        
        Bitar boatpiece = new Bitar(hashtag);
        Bitar boatpiece2 = new Bitar(miss);
        Bitar boatpiece3 = new Bitar(träff);
        
		if (c == true) {
			System.out.println("Du träffade!");
			map.put(replaceCoords, boatpiece3);
			map2.put(replaceCoords, boatpiece3);
		}
		
		if (d == true) {
			System.out.println("Du missade!");
			map.put(replaceCoords, boatpiece2);
			map2.put(replaceCoords, boatpiece2);
		}
		
		if (e == true) {
			System.out.println("Du har redan skjutit här. Skjut igen");
			String koordinater = scan.nextLine();
			skjutSkepp(koordinater);
		}
		printEnemyBoard();
	}
	
	public void skjutKoordinat() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Ange vart du vill skjuta");
		String koordinat = scan.nextLine();
		skjutSkepp(koordinat);
	}
	
	public static void clearScreen() {  
	    System.out.print("\033[H\033[2J");  
	    System.out.flush();  
	} 
	
	public void skjutSkepp(String koordinater) {
        char yLed = koordinater.charAt(0);
        int xLed = koordinater.charAt(1)-48;
        
        char hashtag = '#';
        char miss = '0';
        char träff = '1';
        
        boolean miss1 = true;
        boolean hit1 = true;
        boolean redan = false;
        
        Bitar boatpiece = new Bitar(hashtag);
        Bitar boatpiece2 = new Bitar(miss);
        Bitar boatpiece3 = new Bitar(träff);
        
        for (Koordinater nycklar : map.keySet()) {
            String kollaNyckel = "" + yLed + xLed;
            //System.out.println(kollaNyckel);
            if(kollaNyckel.equals(nycklar.toString())) {
            	Koordinater replaceCoords = new Koordinater(kollaNyckel);
            	
            	if(lookup(nycklar).toString().contains("#")) {
            	//	System.out.println("Du träffade!");
            		//map.put(replaceCoords, boatpiece3);
            		boolean c = true;
            		boolean d = false;
            		boolean e = false;
            		markeraSkott(c,d,e, replaceCoords);
            		
            	}
            	else if(lookup(nycklar).toString().contains("~")) {
            		System.out.println("Du missade!");
            		map.put(replaceCoords, boatpiece2);
            		boolean c = false;
            		boolean d = true;
            		boolean e = false;
            		markeraSkott(c,d,e, replaceCoords);
            	}
            	else {
            		boolean c = false;
            		boolean d = false;
            		boolean e = true;
            		markeraSkott(c,d,e, replaceCoords);
            	}	
            }
        }
	
        
       // printBoard();

    }

	public boolean kollaBoard(String koordinater, boolean val, int storlek) {
		char yLed = koordinater.charAt(0);
		char yBak = (char) (koordinater.charAt(0) - 1);
		char xLed = koordinater.charAt(1);
		char xBak = (char) (koordinater.charAt(1) - 1);
		
		if (koordinater.toString().charAt(0) == 'A') {
			yBak = 'A';
		}
		
		if (koordinater.toString().charAt(1) == '0') {
			xBak = '0';
		}
		
		if (val == true) {
			if (xLed + storlek -48 > 10) {
				System.out.println("Båten är för stor");
				return false;
			}
			for (Koordinater nycklar : map.keySet()) {
				String kollaYled = "" + yBak + xBak;
				System.out.println(kollaYled);
				if (kollaYled.equals(nycklar.toString())) {
					if (lookup(nycklar).toString().contains("#")) {
						System.out.println("Du har närliggande båtar. Båtarna måste ha minst 1 ruta emellan varandra");
						return false;
					}
					xBak++;
					if (xBak == storlek + 1 + xLed) {
						yBak++;
						for (int i = 0; i < storlek; i++) {
							xBak--;
						}
					}
				}
			}
		}

		else {
			if (storlek + yLed - 65 > 10) {
				System.out.println("Please place the boats on the board");
				return false;
			}
			for (Koordinater nycklar : map.keySet()) {
				String kollaXled = "" + yBak + xBak;

				if (kollaXled.equals(nycklar.toString())) {
					if (lookup(nycklar).toString().contains("#")) {
						System.out.println("Please place the boat further away from the other boats");
						return false;
					}

					xBak++;

					if (xBak == (char) (xLed + 2)) {
						yBak++;
						for (int i = 0; i < 3; i++) {
							if (xBak == '0') {
								break;
							}
							xBak--;
						}
					}

				}

				if (yBak == (char) (yLed + storlek + 1)) {
					break;
				}
			}

		}

		return true;

	}

	public void addBoat(String namn, String koordinater, boolean riktning, int storlek) {
		char yLed = koordinater.charAt(0);
		int xLed = koordinater.charAt(1);
		LinkedList<Koordinater> skeppKoordinater = new LinkedList<Koordinater>();
		
		char hashtag = '#';
		Bitar boatPiece = new Bitar(hashtag);
		
		if (riktning == true) { 
			int boatLength = storlek + xLed; 
				for(Koordinater nycklar : map.keySet()) {
				
					if (xLed == boatLength) {
						break;
					}
					
					String kollaNycklar = nycklar.toString();
					
					if((kollaNycklar.charAt(0) == yLed) && (nycklar.toString().charAt(1) == xLed)) {
						Koordinater replaceCoords = new Koordinater(kollaNycklar);
						map.put(replaceCoords, boatPiece);
						skeppKoordinater.add(new Koordinater(kollaNycklar));
						System.out.println(skeppKoordinater);
						xLed++;
					}
					
					kollaNycklar = "";	
				}
			
		}else { 
			int lengthCounter = 0;
			
			for(Koordinater nycklar : map.keySet()) {
			
				if (storlek == lengthCounter) {
					break;
				}
				
				String kollaNycklar = nycklar.toString();
				
				if((kollaNycklar.charAt(0) == yLed) && (nycklar.toString().charAt(1) == xLed)) {
					Koordinater replaceCoords = new Koordinater(kollaNycklar);
					map.put(replaceCoords, boatPiece);
					skeppKoordinater.add(new Koordinater(kollaNycklar));
					yLed++;
					lengthCounter++;
				}
				
				kollaNycklar = "";	
			}
		
		}
		skeppar.add(new Skepp(storlek, namn, skeppKoordinater));
		printSkepp();
		
	}
	
	public void placeraSkepp(){
		printBoard();
		Scanner scan = new Scanner(System.in);
		for(Skepp obj: skeppar) {
			System.out.println("Vart vill du placera " + obj.getNamn() + "?");
			String koordinat = scan.nextLine();
			boolean riktning = riktning();
			while (kollaBoard(koordinat, riktning,obj.getStorlek())!=true) {
				System.out.println("Placera om " + obj.getNamn());
				koordinat = scan.nextLine();
				riktning = riktning();
			 
			}
			addBoat(obj.getNamn(),koordinat, riktning, obj.getStorlek());
			printBoard();
		}
	}
}
