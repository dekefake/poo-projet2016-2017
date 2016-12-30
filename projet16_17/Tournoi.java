package projet16_17;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Hashtable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Tournoi {

	static Scanner in = new Scanner(System.in);
	public static Hashtable<String, Equipe> equipes = new Hashtable();
	public static Hashtable<Integer, Joueur> joueurs = new Hashtable();
	public static Hashtable<String, Club> clubs = new Hashtable();
	public static Hashtable<String, Arbitre> arbitres = new Hashtable();
	public static int nbLicencies = 0;

	public static void afficherStade() {
		System.out.println(
				" --------------------------------GESTIONNAIRE DE TOURNOI DE FOOTBALL--------------------------------\n\n");
		System.out.println("                                  Selectionnez une option ( [1;6] )");
		System.out.println(
				" --------------------------------------------------------------------------------------------------- ");
		System.out.println(
				"|                                                 |                                                 |");
		System.out.println(
				"|----------------                                 |                                 ----------------|");
		System.out.println(
				"|                |      1. Creer des joueurs      |      2. Creer des equipes      |                |");
		System.out.println(
				"|                |                                |                                |                |");
		System.out.println(
				"|--------        |                                |                                |        --------|");
		System.out.println(
				"|        |       |                               -|-                               |       |        |");
		System.out.println(
				"|        |       |                           /    |    \\                           |       |        |");
		System.out.println(
				"||       |       |\\                         /     |     \\                         /|       |       ||");
		System.out.println(
				"||       |   ,   | |                       |      |      |                       | |   ,   |       ||");
		System.out.println(
				"||       |   '   | |   3. Creer des clubs  |      |      |   4. Creer arbitres   | |   '   |       ||");
		System.out.println(
				"||       |       |/                         \\     |     /                         \\|       |       ||");
		System.out.println(
				"|        |       |                           \\    |    /                           |       |        |");
		System.out.println(
				"|        |       |                               -|-                               |       |        |");
		System.out.println(
				"|--------        |                                |                                |        --------|");
		System.out.println(
				"|                |                                |                                |                |");
		System.out.println(
				"|                |       5. Recapitulatif         |     6. Executer le tournoi     |                |");
		System.out.println(
				"|----------------                                 |                                 ----------------|");
		System.out.println(
				"|                                                 |                                                 |");
		System.out.println(
				" ---------------------------------------------------------------------------------------------------\n\n");
	}

	public static void menuPrincipal() {
		int choice = -1;
		boolean one = false, two = false, three = false, four = false, five = false, six = false, choix;

		do {
			afficherStade();
			do {
				choix = true;
				choice = in.nextInt();
				if (choice == 1 && (!three)) {
					System.out.println("Vous devez creer des clubs avant de creer des joueurs");
					choice = 3;
				}
				if (choice == 2 && (!one)) {
					System.out.println("Vous devez creer des joueurs avant de creer des equipes");
					if (!three) {
						System.out.println("Vous devez creer des clubs avant de creer des joueurs");
						choice = 3;
					} else {
						choice = 1;
					}
				}
				if (choice == 4 && (!three)) {
					System.out.println("Vous devez creer des clubs avant de creer des arbitres");
					choice = 3;
				}
				if (choice == 5 && (!one || !two || !three || !four)) {
					System.out.println(
							"Vous devez creer toutes les structures du tournoi avant d'afficher le recapitulatif\nVeuillez entrer une autre option");
					choix = false;
				}
				if (choice == 6 && (!one || !two || !three || !four)) {
					System.out.println(
							"Vous devez creer toutes les structures du tournoi avant de lancer le simulateur de tournoi\nVeuillez entrer une autre option");
					choix = false;
				}
			} while (choice < 1 || choice > 6 || !choix);
			switch (choice) {
			case 1:
				creerJoueurs();
				one = true;
				break;
			case 2:
				creerEquipes();
				two = true;
				break;
			case 3:
				creerClubs();
				three = true;
				break;
			case 4:
				creerArbitres();
				four = true;
				break;
			case 5:
				recap();
				five = true;
				break;
			case 6:
				System.out.println("six");
				six = true;
				break;
			}
		} while (!six);
	}

	public static void main(String[] args) {
		menuPrincipal();
		System.out.println("FIN");
	}

	public static void recap() {
		System.out.println("Methode recap()");
	}

	public static void creerEquipes() {
		System.out.println("Methode creerEquipes()");
	}

	public static void creerJoueurs() {
		String c, jNom = "", jPrenom = "";
		Calendar jDateInscription = Calendar.getInstance();
		Club jClub = null;
		Poste jPoste = Poste.ATTAQUANT;
		int jNumMaillot = -1;
		boolean choixValide = true;
		do {
			/*
			 * numeroDeLicence = licence; nom = nm; prenom = p; dateInscription
			 * =d; club = c;
			 */
			System.out.println("Entrez un nom de joueur");
			jNom = in.next();
			System.out.println("Entrez un prenom de joueur");
			jPrenom = in.next();
			do {
				choixValide=true;
				System.out.println("Entrez un nom de club pour ce joueur");
				c = in.next();
				if (clubs.containsKey(c)) {
					jClub = clubs.get(c);
				} else {
					System.out.println("Ce club n'existe pas !");
					choixValide = false;
				}
			} while (!choixValide);
			do {
				choixValide = true;
				System.out.println("Entrez une date sous le format JJ/MM/AAAA");
				try {
					c = in.next();
					DateFormat dformat = new SimpleDateFormat("dd/MM/yyyy");
					jDateInscription.setLenient(false);
					jDateInscription.setTime(dformat.parse(c));
					jDateInscription.getTime();
				} catch (Exception e) {
					System.out.println("La date entrée est incorrecte, ou entrée de manière incorrecte.");
					choixValide = false;
				}
				System.out.println(Licencie.CalendarToString(jDateInscription));
			} while (!choixValide);
			do {
				choixValide = true;
				System.out.println("A quel poste joue ce joueur ?\n(Gardien/Attaquant/Defenseur/Milieu)");
				c = in.next();
				if (jPoste.isPoste(c)) {
					switch (c) {
					case "Gardien":
						jPoste = Poste.GARDIEN;
					case "Attaquant":
						jPoste = Poste.ATTAQUANT;
					case "Defenseur":
						jPoste = Poste.DEFENSEUR;
					case "Milieu":
						jPoste = Poste.MILIEU;
					}
				} else {
					System.out.println("Ce poste saisi n'est pas valable");
					choixValide = false;
				}
			} while (!choixValide);
			do {
				choixValide = true;
				System.out.println("Saisissez un numero de maillot");
				jNumMaillot = in.nextInt();
				if (joueurs.containsKey(jNumMaillot)) {
					choixValide = false;
					System.out.println("Un joueur portant le meme numero de maillot existe déjà !");
				}
			} while (!choixValide);
			nbLicencies++;
			joueurs.put(jNumMaillot,
					new Joueur(nbLicencies, jNom, jPrenom, jDateInscription, jClub, jPoste, jNumMaillot));
			System.out.println("\nEntrer un nouveau joueur ? (*/nN)");
			c = in.next();
		} while (!c.equals("N") && !c.equals("n"));
	}

	public static void creerClubs() {
		String c;
		do {
			System.out.println("Methode creerClubs()");
			String cNom, cVille;
			System.out.println("Entrez un nom de club");
			cNom = in.next();
			System.out.println("Entrez la ville d'origine du club");
			cVille = in.next();
			clubs.put(cNom, new Club(cNom, cVille));
			System.out.println("\nEntrer un nouveau club ? (*/nN)");
			c = in.next();
		} while (!c.equals("N") && !c.equals("n"));
	}

	public static void creerArbitres() {
		System.out.println("Methode creerArbitres()");
	}

}
