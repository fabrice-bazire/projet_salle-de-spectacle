package projet;
import java.util.*;
import java.io.*;


/**
 * 
 *<b>GestionSpectacles est la classe permetant de gerer les Spectacles.</b>
 * 
 */
public class GestionSpectacles {
	static Scanner in = new Scanner (System.in);
	/**
	 * Retourne l'affichage des salles de cinema
	 * 
	 * @param a
	 * 		L'ensemble contenant les salles de cinema
	 * 
	 * @return l'affichage des salles de cinema sous forme d'une chaine de caracteres
	 */
	public static String toString(SortedSet<Salle> a) {
		String s = " ";
		for (Salle item: a) {
			s += item ;
		}
		return s;
	}


	/**
	 * Retourne l'affichage des salles de theatre
	 * 
	 * @param a
	 * 		L'ensemble contenant les salles de theatre
	 * 
	 * @return l'affichage des salles de theatre sous forme d'une chaine de caracteres
	 */
	public static String toStringt(SortedSet<SalleTheatre> a) {
		String s = " ";
		for (Salle item: a) {
			s += item;
			s += "\n";
		}
		return s;
	}

	/**
	 * Permets de vendre des places de cinéma 
	 * 
	 * @param lesProgrammations
	 * 		L'ensemble contenant les programmations de chacune des semaines
	 * 
	 * @param semaine
	 * 		Le numéro de la semaine pour laquelle on va vendre des places
	 */
	public static void vendreplacescinéma (List<ProgrammationSemaine> lesProgrammations, int semaine) {
		Film f = null;
		SeanceCinema s = null;
		SortedSet<Film> lesfilms = lesProgrammations.get(semaine).recupererFilmsSemaine();
		int i = 0;
		for (Film item: lesfilms) {
			i++;
			System.out.print(i + ") " + item.toString());
		}
		System.out.print("\n" + "Pour lequel de ces films voulez vous vendre des places : " + "\n");
		while (!in.hasNextInt()) {
			System.out.print("Pour lequel de ces films voulez vous vendre des places : " + "\n");
			in.next();			
		}
		int film = in.nextInt();
		while (film <= 0 || film > i) {
			System.out.print("Pour lequel de ces films voulez vous vendre des places : " + "\n");
			while (!in.hasNextInt()) {
				System.out.print("Pour lequel de ces films voulez vous vendre des places : " + "\n");
				in.next();			
			}
			film = in.nextInt();
		}
		i = 0;
		for (Film item: lesfilms) {
			i++;
			if (i == film) {
				f = item;
			}
		}
		SortedSet<SeanceCinema> lesseances = lesProgrammations.get(semaine).recupererSeancesFilm(f);
		i = 0;
		for (SeanceCinema item: lesseances) {
			i++;
			System.out.print(i + ") " + item.toString() + "\n");
		}
		System.out.print("\n" + "Pour laquelle de ces séances voulez vous vendre des places : " + "\n");
		while (!in.hasNextInt()) {
			System.out.print("Pour laquelle de ces séances voulez vous vendre des places : " + "\n");
			in.next();			
		}
		int seance = in.nextInt();
		while (seance <= 0 || seance > i) {
			System.out.print("Pour laquelle de ces séances voulez vous vendre des places : " + "\n");
			while (!in.hasNextInt()) {
				System.out.print("Pour laquelle de ces séances voulez vous vendre des places : " + "\n");
				in.next();			
			}
			seance = in.nextInt();
		}
		i = 0;
		for (SeanceCinema item: lesseances) {
			i++;
			if (i == seance) {
				s = item;
			}
		}
		System.out.println("Pour cette Seance il reste " + s.nbPlacesDispo() + " places disponibles");
		System.out.print("Voulez vous vendre des places à tarif normal(1) ou à tarif réduit(2) : ");
		while (!in.hasNextInt()) {
			System.out.print("Voulez vous vendre des places à tarif normal(1) ou à tarif réduit(2) : ");
		}
		int tar = in.nextInt();
		System.out.print("Combien de places voulez vous vendre : ");
		while (!in.hasNextInt()) {
			System.out.print("Combien de places voulez vous vendre : ");
		}
		int nbplaces = in.nextInt();
		if (nbplaces <= s.nbPlacesDispo()) {
			if (tar == 1) {
				s.vendrePlacesTN(nbplaces);
			}
			if (tar == 2) {
				s.vendrePlacesTR(nbplaces);;
			}
		}else {
			System.out.print("aucunes places vendues car vous avez voulu vendre plus de places qu'il n'y en avais de disponilbes");
		}
	}

	/**
	 * Permets de vendre des places de théatre 
	 * 
	 * @param lesProgrammations
	 * 		L'ensemble contenant les programmations de chacune des semaines
	 * 
	 * @param semaine
	 * 		Le numéro de la semaine pour laquelle on va vendre des places
	 */
	public static void vendreplacestheatre (List<ProgrammationSemaine> lesProgrammations, int semaine) {
		PieceTheatre p = null;
		SeanceTheatre s = null;
		SortedSet<PieceTheatre> lespieces = lesProgrammations.get(semaine).recupererPiecesSemaine(semaine);
		int i = 0;
		for (PieceTheatre item: lespieces) {
			i++;
			System.out.print(i + ") " + item.toString());
		}
		System.out.print("\n" + "Pour laquelle de ces pièces voulez vous vendre des places : " + "\n");
		while (!in.hasNextInt()) {
			System.out.print("Pour laquelle de ces pièces voulez vous vendre des places : " + "\n");
			in.next();			
		}
		int piece = in.nextInt();
		while (piece <=0 || piece > i) {
			System.out.print("\n" + "Pour laquelle de ces pièces voulez vous vendre des places : " + "\n");
			while (!in.hasNextInt()) {
				System.out.print("Pour laquelle de ces pièces voulez vous vendre des places : " + "\n");
				in.next();			
			}
			piece = in.nextInt();
		}
		i = 0;
		for (PieceTheatre item: lespieces) {
			i++;
			if (i == piece) {
				p = item;
			}
		}
		SortedSet<SeanceTheatre> lesseances = lesProgrammations.get(semaine).recupererSeancesTheatre(p);
		i = 0;
		for (SeanceTheatre item: lesseances) {
			i++;
			System.out.print(i + ") " + item.toString());
		}
		System.out.print("\n" + "Pour laquelle de ces séances voulez vous vendre des places : " + "\n");
		while (!in.hasNextInt()) {
			System.out.print("Pour laquelle de ces séances voulez vous vendre des places : " + "\n");
			in.next();			
		}
		int seance = in.nextInt();
		while (seance <= 0 || seance > i) {
			System.out.print("\n" + "Pour laquelle de ces séances voulez vous vendre des places : " + "\n");
			while (!in.hasNextInt()) {
				System.out.print("Pour laquelle de ces séances voulez vous vendre des places : " + "\n");
				in.next();			
			}
			seance = in.nextInt();
		}
		i = 0;
		for (SeanceTheatre item: lesseances) {
			i++;
			if (i == seance) {
				s = item;
			}
		}
		System.out.println("Pour cette Seance il reste " + s.nbPlacesDispo() + " places disponibles");
		System.out.print("Voulez vous vendre des places normal(1) ou en fauteuil(2) : ");
		while (!in.hasNextInt()) {
			System.out.print("Voulez vous vendre des places normal(1) ou en fauteuil(2) : ");
		}
		int tar = in.nextInt();
		System.out.print("Combien de places voulez vous vendre : ");
		while (!in.hasNextInt()) {
			System.out.print("Combien de places voulez vous vendre : ");
		}
		int nbplaces = in.nextInt();
		if (nbplaces <= s.nbPlacesDispo()) {
			if (tar == 1) {
				s.vendrePlacesTN(nbplaces);
			}
			if (tar == 2) {
				s.vendrePlacesFauteuil(nbplaces);
			}
		}else {
			System.out.print("aucunes places vendues car vous avez voulu vendre plus de places qu'il n'y en avais de disponilbes");
		}
	}

	/**
	 * Main du projet, c'est lui qui gère le menu de l'application et qui va appeler les méthodes qui conviennent en fonction des choix de l'utilisateur 
	 */
	public static void main(String[] args) {
	//	SortedSet<Salle> a = recupsallecinecsv();
	//	SortedSet<SalleTheatre> b = recupsalletheatrecsv();
		List<ProgrammationSemaine> lesProgrammations = new ArrayList<ProgrammationSemaine>();
		for (int i = 0; i < 52; i++) {
			lesProgrammations.add(null);
		}
		int choixmenu = 4;
		System.out.println("Bienvenue dans l'application de gestion de la salle de spectacle de la ville d'Arles !");
		System.out.println("--------------------------------------------------------------------------------------");
		System.out.println("");
		while (choixmenu==1 || choixmenu==2 || choixmenu==3 || choixmenu==4) {
			System.out.println("Menu :");
			System.out.println("  1) Créer la programmation de la semaine suivante");
			System.out.println("  2) Modifier la programmation deja existante d'une certaine semaine");
			System.out.println("  3) Vendre des places pour une programmation");
			System.out.println("  4) Consulter les informations concernant les vente de place (taux de remplissage et chiffre d'affaire)");
			System.out.println("  Autre chiffre : Quitter");
			System.out.println(" ");
			System.out.print("Votre choix : ");
			while (!in.hasNextInt()) {
				System.out.print("Votre choix (entre 1 et 6): ");
				in.next();			
			}	
			choixmenu = in.nextInt();
			if (choixmenu == 1) {				
				System.out.print("Veuillez saisir le numéro de la semaine courante (entre 1 et 51, car vous ne pouvez pas créer de programmation en semaine 53) : ");
				while (!in.hasNextInt()) {
					System.out.print("Saisissez le numéro de la semaine courante (entier entre 1 et 51) : ");
					in.next();			
				}
				int semaine = in.nextInt();
				while (semaine <= 0 || semaine > 51) {
					System.out.print("Saisissez le numéro de la semaine courante (entier entre 1 et 51) : ");
					while (!in.hasNextInt()) {
						System.out.print("Saisissez le numéro de la semaine courante (entier entre 1 et 51) : ");
						in.next();
					}
					semaine = in.nextInt();
				}
				lesProgrammations.add(semaine+1, new ProgrammationSemaine(semaine+1));
			}
			if (choixmenu == 2) {
				int act = 0;
				System.out.print("Pour quelle semaine voulez vous modifier la programmation : ");
				while (!in.hasNextInt()) {
					System.out.print("Pour quelle semaine voulez vous modifier la programmation : ");
					in.next();			
				}
				int semaine = in.nextInt();
				if (lesProgrammations.get(semaine)  == null) {
					System.out.print("Il n'y a pas de programmation cette semaine la" + "\n" + "\n");
				}else {
					System.out.print(lesProgrammations.get(semaine).toString());
					System.out.println("");
					System.out.print("Entrer le nom du spectacle que voulez modifier : ");
					String nom = in.next();
					System.out.println("");
					for (SortedMap.Entry<Film, SortedSet<SeanceCinema>> entree : lesProgrammations.get(semaine).EnsembleSeancesCinema.entrySet()) {
						if (entree.getKey().titre.equals(nom)){
							act++;
							System.out.println("Il y a un film portant ce nom ");
							System.out.print("Voulez vous ajouter(1) ou supprimer(2) une séance : ");
							int ajout_sup = in.nextInt();
							if (ajout_sup == 1) {
								entree.getValue().add(new SeanceCinema());
							}
							if (ajout_sup == 2) {
								//ne fonctionne pas
								lesProgrammations.get(semaine).supprimerSeanceCinema(entree.getValue());
							}
						}
					}
					for (SortedMap.Entry<PieceTheatre, SortedSet<SeanceTheatre>> entree : lesProgrammations.get(semaine).EnsembleSeancesTheatre.entrySet()) {
						if (entree.getKey().titre.equals(nom)){
							act++;
							System.out.println("Il y a une pièce portant ce nom ");
							System.out.print("Voulez vous ajouter(1) ou supprimer(2) une séance : ");
							int ajout_sup = in.nextInt();
							if (ajout_sup == 1) {
								entree.getValue().add(new SeanceTheatre());
							}
							if (ajout_sup == 2) {
								lesProgrammations.get(semaine).supprimerSeanceTheatre(entree.getValue());
							}
						}
					}
					if (act == 0) {
						System.out.print("le nom que vous avez saisi ne correspond à aucun film et à aucune pièce de théatre)" + "\n" + "\n");
					}
				}
			}
			if (choixmenu == 3) {
				System.out.print("Pour quelle semaine voulez vous vendre des places : ");
				while (!in.hasNextInt()) {
					System.out.print("Pour quelle semaine voulez vous vendre des places : ");
					in.next();			
				}
				int semaine = in.nextInt();
				if (lesProgrammations.get(semaine)  == null) {
					System.out.print("Il n'y a pas de programmation cette semaine la" + "\n");
				}else {
					System.out.print("Voulez vous vendre des places de théatre(1) ou de cinema(2) : ");
					while (!in.hasNextInt()) {
						System.out.print("Voulez vous vendre des places de théatre(1) ou de cinema(2) : ");
						in.next();			
					}
					int the_cine = in.nextInt();
					if (the_cine == 1) {
						if (lesProgrammations.get(semaine).EnsembleSeancesTheatre.isEmpty()) {
							System.out.print("Pas de séances de théatre programmées cette semaine" + "\n");
						}else {
							vendreplacestheatre(lesProgrammations, semaine);
						}
					}
					if (the_cine == 2) {
						if (lesProgrammations.get(semaine).EnsembleSeancesCinema.isEmpty()) {
							System.out.print("Pas de séances de cinéma programmées cette semaine" + "\n");
						}else {
							vendreplacescinéma(lesProgrammations, semaine);
						}
					}
				}
			}
			if (choixmenu == 4) {
				System.out.print("Pour quelle semaine voulez vous consulter des informations : ");
				while (!in.hasNextInt()) {
					System.out.print("Pour quelle semaine voulez vous consulter des informations : ");
					in.next();			
				}
				int semaine = in.nextInt();
				if (lesProgrammations.get(semaine)  == null) {
					System.out.print("Il n'y a pas de programmation cette semaine la" + "\n");
				}else {
					System.out.print("Voulez vous consulter les informations d'un film(1) ou d'une pièce de théâtre(2) : ");
					while (!in.hasNextInt()) {
						System.out.print("Voulez vous consulter les informations d'un film(1) ou d'une pièce de théâtre(2) : ");
						in.next();			
					}
					int choixinfo = in.nextInt();
					while (choixinfo != 1 && choixinfo != 2) {
						System.out.print("Saisissez un entier entre 1 et 2, Voulez vous consulter les informations d'un film(1) ou d'une pièce de théâtre(2) : ");
						while (!in.hasNextInt()) {
							System.out.print("Saisissez un entier entre 1 et 2, Voulez vous consulter les informations d'un film(1) ou d'une pièce de théâtre(2) : ");
							in.next();
						}
						choixinfo = in.nextInt();
					}
					if (choixinfo == 1) {
						Film f = null;
						SeanceCinema s = null;
						SortedSet<Film> lesfilms = lesProgrammations.get(semaine).recupererFilmsSemaine();
						int i = 0;
						for (Film item: lesfilms) {
							i++;
							System.out.print(i + ") " + item.toString());
						}
						System.out.print("\n" + "Pour lequel de ces films voulez vous consulter les infos : " + "\n");
						while (!in.hasNextInt()) {
							System.out.print("Pour lequel de ces films voulez vous consulter les infos : " + "\n");
							in.next();			
						}
						int film = in.nextInt();
						while (film <= 0 || film > i) {
							System.out.print("Pour lequel de ces films voulez vous consulter des infos : " + "\n");
							while (!in.hasNextInt()) {
								System.out.print("Pour lequel de ces films voulez vous consulter des infos : " + "\n");
								in.next();			
							}
							film = in.nextInt();
						}
						i = 0;
						for (Film item: lesfilms) {
							i++;
							if (i == film) {
								f = item;
							}
						}
						double tauxremplissage = 0;
						double ca = 0;
						SortedSet<SeanceCinema> lesseances = lesProgrammations.get(semaine).recupererSeancesFilm(f);
						i = 0;
						for (SeanceCinema item: lesseances) {
							i++;
							tauxremplissage += item.tauxRemplissage();
							ca += (item.nbPlacesVenduesTn * item.salle.tarif) + (item.nbPlacesVenduesTR * (item.salle.tarif * 0.6));
						}
						tauxremplissage = tauxremplissage/i;
						System.out.print("Vous avez séléctionné le film : " + f.titre + "\n" + "Il génère un chiffre d'affaires de " + ca + "€ et rempli les salles en moyennes à " + tauxremplissage + "%" + "\n");
					}
					if (choixinfo == 2) {
						PieceTheatre p = null;
						SeanceTheatre s = null;
						SortedSet<PieceTheatre> lespieces = lesProgrammations.get(semaine).recupererPiecesSemaine(semaine);
						int i = 0;
						for (PieceTheatre item: lespieces) {
							i++;
							System.out.print(i + ") " + item.toString());
						}
						System.out.print("\n" + "Pour laquelle de ces pièces voulez vous consulter les infos : " + "\n");
						while (!in.hasNextInt()) {
							System.out.print("Pour laquelle de ces pièces voulez vous consulter les infos : " + "\n");
							in.next();			
						}
						int piece = in.nextInt();
						while (piece <=0 || piece > i) {
							System.out.print("\n" + "Pour laquelle de ces pièces voulez vous consulter les infos : " + "\n");
							while (!in.hasNextInt()) {
								System.out.print("Pour laquelle de ces pièces voulez vous consulter les infos : " + "\n");
								in.next();			
							}
							piece = in.nextInt();
						}
						i = 0;
						for (PieceTheatre item: lespieces) {
							i++;
							if (i == piece) {
								p = item;
							}
						}
						double tauxremplissage = 0;
						double ca = 0;
						SortedSet<SeanceTheatre> lesseancesdetheatre = lesProgrammations.get(semaine).recupererSeancesTheatre(p);
						i = 0;
						for (SeanceTheatre item: lesseancesdetheatre) {
							i++;
							tauxremplissage += item.tauxRemplissage();
							ca += (item.nbPlacesVenduesTn * item.salleTheatre.tarif) + (item.nbFauteuilsVendus * item.salleTheatre.prixFauteuil);
						}
						tauxremplissage = tauxremplissage/i;
						System.out.print("Vous avez séléctionné la pièce : " + p.titre + "\n" + "Elle génère un chiffre d'affaires de " + ca + "€ et rempli les salles en moyennes à " + tauxremplissage + "%" + "\n");
					}
				}
			}
		}
		System.out.println("Vous avez décidé de quitter l'application, bonne journée");
	}
}
