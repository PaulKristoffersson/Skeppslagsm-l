package SankaSkepp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Skepp {

	/*
	 * private String [] batett; private String [] battva; private String [] battre;
	 * private String [] batfour; private String [] batfem;
	 */
	public String namn;
	public int storlek;
	static LinkedList<Skepp> skeppar = new LinkedList<Skepp>();
	static ArrayList<String> koordinater = new ArrayList<String>();
	
	public Skepp(int storlek, String namn) {
		this.storlek = storlek;
		this.namn = namn;
	}

	public int getStorlek() {
		return storlek;
	}

	public void setStorlek(int storlek) {
		this.storlek = storlek;
	}

	public String getNamn() {
		return namn;
	}

	public void setNamn(String namn) {
		this.namn = namn;
	}


	public static void addSkepp(Skepp c) {
		skeppar.add(c);
	}
	public static void addKoordinat(String c) {
		koordinater.add(c);
	}

	public static void printSkepp() {
		for (Skepp obj : skeppar) {
			System.out.println(obj);
		}
	}
	
	public static void printKoordinat() {
		for (String obj : koordinater) {
			System.out.println(obj);
		}
	}

	public String toString() {
		return ("Namn:" + this.namn + " Storlek: " + this.storlek + "\n");
	}
	
	/*public void skapaSkepp(Skepp skepp) {
		Scanner scan = new Scanner(System.in);
		System.out.println("H�r kan du skapa ett skepp. Vad ska ditt skepp heta?");
		String namn = scan.nextLine();
		skepp.setNamn(namn);
		System.out.println("V�lj en storlek p� ditt skepp!");
		int storlek = scan.nextInt();
		skepp.setStorlek(storlek);

	}*/
	
	public void placeraSkepp(Skepp c) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Nu ska du placera dina skepp. V�lj koordinater a-j och sedan position 0-9! ");
		for(Skepp obj : skeppar) {
			System.out.println("Vart vill du placera " + getNamn() + "?");
			String koordinat = scan.nextLine();
			for (int i=0; i<getStorlek(); i++) {
				koordinater.add(koordinat);
			}
			
		}
	}

	/*public String[] addaFlotta() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Nu ska du l�gga till pj�ser i flottan!");
		String[] b�tEtt = { "ett", "tv�" };
		String[] b�tTv� = { "ett", "tv�", "tre" };
		String[] b�tTre = { "ett", "tv�", "tre", "fyra" };
		String[] b�tFyra = { "ett", "tv�", "tre", "fyra", "fem" };
		System.out.println("L�gg till b�t 1 som �r av storlek 2! ");
		for (int i = 0; i < b�tEtt.length; i++) {
			System.out.println("Vart ska f�rsta biten sitta? ");
			String indexEtt = scan.nextLine();
			b�tEtt[0] = indexEtt;
			System.out.println("Vart ska andra delen ligga?");
			String indexTva = scan.nextLine();
			b�tEtt[1] = indexTva;
		}
		for (int i = 0; i < b�tTv�.length; i++) {
			System.out.println("Vart ska f�rsta biten sitta? ");
			String indexEtt = scan.nextLine();
			b�tTv�[0] = indexEtt;
			System.out.println("Vart ska andra delen ligga?");
			String indexTva = scan.nextLine();
			b�tEtt[1] = indexTva;
		}
		return b�tTv�;

	}*/


}
