package projet16_17;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Hashtable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Tournoi {

	static Scanner in = new Scanner(System.in);
	private static Hashtable<Integer, Equipe> equipes = new Hashtable();
	private static Hashtable<Integer, Joueur> joueurs = new Hashtable();
	private static Hashtable<String, Club> clubs = new Hashtable();
	private static Hashtable<Integer, Arbitre> arbitres = new Hashtable();
	private static int nbLicencies = 0;
	private static int nbEquipes = 0;
	private static int nbJoueursTitParEquipe = 9;
	private static int nbJoueursRempParEquipe = 3;

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
		System.out.println(
				"Options avancées :\n   tT. Saisir le nombre de joueurs titulaires par équipe (par défaut, 9)\n   jJ. Saisir le nombre de joueurs remplacants par équipe (par défaut, 3)\n   rR. Lire la configuration depuis un fichier (rR)\n   wW. Ecrire la configuration vers un fichier");
	}

	public static void menuPrincipal() {
		int choiceInt = -1;
		String choice = "";
		boolean one = false, two = false, three = false, four = false, five = false, six = false, choix;

		do {
			afficherStade();
			try {
				do {
					choix = true;
					choice = in.next();
					choiceInt = Integer.parseInt(choice);
					if (choiceInt == 1 && (!three)) {
						System.out.println("Vous devez creer des clubs avant de creer des joueurs");
						choiceInt = 3;
					}
					if (choiceInt == 2 && (!one)) {
						System.out.println("Vous devez creer des joueurs avant de creer des equipes");
						if (!three) {
							System.out.println("Vous devez creer des clubs avant de creer des joueurs");
							choiceInt = 3;
						} else {
							choiceInt = 1;
						}
					}
					if (choiceInt == 4 && (!three)) {
						System.out.println("Vous devez creer des clubs avant de creer des arbitres");
						choiceInt = 3;
					}
					if (choiceInt == 5 && (!one || !two || !three || !four)) {
						System.out.println(
								"Vous devez creer toutes les structures du tournoi avant d'afficher le recapitulatif\nVeuillez entrer une autre option");
						choix = false;
					}
					if (choiceInt == 6 && (!one || !two || !three || !four)) {
						System.out.println(
								"Vous devez creer toutes les structures du tournoi avant de lancer le simulateur de tournoi\nVeuillez entrer une autre option");
						choix = false;
					}
				} while (choiceInt < 1 || choiceInt > 6 || !choix);
				switch (choiceInt) {
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
			} catch (NumberFormatException e) { // l'option saisie netait pas un
												// nombre ;)
				switch (choice) {
				case "t":
					choixNbJoueursTitParEquipe();
					break;
				case "T":
					choixNbJoueursTitParEquipe();
					break;
				case "j":
					choixNbJoueursRempParEquipe();
					break;
				case "J":
					choixNbJoueursRempParEquipe();
					break;
				case "r":
					break;
				case "R":
					break;
				case "w":
					break;
				case "W":
					break;
				}
			}
		} while (!six);
	}

	public static void choixNbJoueursTitParEquipe() {
		boolean choixValide;
		String choice;
		int choiceInt = -1;
		do {
			choixValide = true;
			System.out.println("Combien de joueurs titulaires voulez vous par equipe ?");
			choice = in.next();
			try {
				choiceInt = Integer.parseInt(choice);
			} catch (NumberFormatException e) {
				System.out.println("Saisie incorrecte");
				choixValide = false;
			}
		} while (!choixValide);
		nbJoueursTitParEquipe = choiceInt;
	}

	public static void choixNbJoueursRempParEquipe() {
		boolean choixValide;
		String choice;
		int choiceInt = -1;
		do {
			choixValide = true;
			System.out.println("Combien de joueurs remplacants voulez vous par equipe ?");
			choice = in.next();
			try {
				choiceInt = Integer.parseInt(choice);
			} catch (NumberFormatException e) {
				System.out.println("Saisie incorrecte");
				choixValide = false;
			}
		} while (!choixValide);
		nbJoueursRempParEquipe = choiceInt;
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
		boolean choixValide;
		String c = "";
		int cInt = -1;
		Joueur j;
		Club eClub = null;
		do {
			do {
				choixValide = true;
				System.out.println("Entrez un nom de club pour ce joueur");
				c = in.next();
				if (clubs.containsKey(c)) {
					eClub = clubs.get(c);
				} else {
					System.out.println("Ce club n'existe pas !");
					choixValide = false;
				}
			} while (!choixValide);
			nbEquipes++;
			Equipe e = new Equipe(eClub, nbEquipes, nbJoueursTitParEquipe, nbJoueursRempParEquipe);
			for (int i = 1; i <= nbJoueursTitParEquipe; i++) {
				do {
					choixValide = true;
					try {
						System.out.println("Saisir le numero de licence du joueur a ajouter a l'équipe");
						c = in.next();
						cInt = Integer.parseInt(c);
						if (joueurs.containsKey(cInt)) {
							j = joueurs.get(cInt);
							if (j.getClub().equals(eClub)) {
								try {
									e.ajouterJoueurTitulaire(j);
								} catch (IllegalStateException e3) {
									System.out.println(e3.getMessage());
								}
							}
						}
					} catch (NumberFormatException e2) {
						choixValide = false;
						System.out.println("Saisie incorrecte");
					}
				} while (!choixValide);
			}
			for (int i = 1; i <= nbJoueursRempParEquipe; i++) {
				do {
					choixValide = true;
					try {
						System.out.println("Saisir le numero de licence du joueur a ajouter a l'équipe");
						c = in.next();
						cInt = Integer.parseInt(c);
						if (joueurs.containsKey(cInt)) {
							j = joueurs.get(cInt);
							if (j.getClub().equals(eClub)) {
								try {
									e.ajouterJoueurRemplacant(j);
								} catch (IllegalStateException e3) {
									System.out.println(e3.getMessage());
								}
							}
						}
					} catch (NumberFormatException e2) {
						choixValide = false;
						System.out.println("Saisie incorrecte");
					}
				} while (!choixValide);
			}
			equipes.put(nbEquipes, e);
			System.out.println("\nEntrer une nouvelle equipe ? (*/nN)");
			c = in.next();
		} while (!c.equals("N") && !c.equals("n"));
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
				choixValide = true;
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
			joueurs.put(nbLicencies,
					new Joueur(nbLicencies, jNom, jPrenom, jDateInscription, jClub, jPoste, jNumMaillot));
			System.out.println("\nEntrer un nouveau joueur ? (*/nN)");
			c = in.next();
		} while (!c.equals("N") && !c.equals("n"));
	}

	public static void creerClubs() {
		String c;
		do {
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
		String c, aNom = "", aPrenom = "";
		Calendar aDateInscription = Calendar.getInstance();
		Club aClub = null;
		int aCategorie = -1;
		boolean choixValide = true;
		do {
			/*
			 * numeroDeLicence = licence; nom = nm; prenom = p; dateInscription
			 * =d; club = c;
			 */
			System.out.println("Entrez un nom d'arbitre");
			aNom = in.next();
			System.out.println("Entrez un prenom d'arbitre");
			aPrenom = in.next();
			do {
				choixValide = true;
				System.out.println("Entrez un nom de club pour cet arbitre");
				c = in.next();
				if (clubs.containsKey(c)) {
					aClub = clubs.get(c);
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
					aDateInscription.setLenient(false);
					aDateInscription.setTime(dformat.parse(c));
					aDateInscription.getTime();
				} catch (Exception e) {
					System.out.println("La date entrée est incorrecte, ou entrée de manière incorrecte.");
					choixValide = false;
				}
			} while (!choixValide);
			do {
				choixValide = true;
				System.out.println("Saisissez une catégorie d'arbitre (1/2/3)");
				aCategorie = in.nextInt();
				if (aCategorie < 1 || aCategorie > 3) {
					choixValide = false;
					System.out.println("Categorie incorrecte");
				}
			} while (!choixValide);
			nbLicencies++;
			arbitres.put(nbLicencies, new Arbitre(nbLicencies, aNom, aPrenom, aDateInscription, aClub, aCategorie));
			System.out.println("\nEntrer un nouvel arbitre  ? (*/nN)");
			c = in.next();
		} while (!c.equals("N") && !c.equals("n"));
	}

}
