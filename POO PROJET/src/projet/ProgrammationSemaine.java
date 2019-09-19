package projet;
import java.util.*;

/**
 * 
 *<b>ProgrammationSemaine est la classe permettant de programmer des spectacles sur une semaine donnee.</b>
 * <p>
 * La programmation d'une semaine est caractérisée par les informations suivantes :
 * <ul>
 * <li>Une semaine (int).</li>
 * <li>Un ensemble de seances de cinema SeancesCinema (SortedSet<SeanceCinema>).</li>
 * <li>Un ensemble de seances de theatre SeancesTheatre (SortedSet<SeanceTheatre>)</li>
 * </ul>
 * </p>
 * 
 * @see SeanceCinema
 * @see SeanceTheatre
 * 
 * 
 */
public class ProgrammationSemaine {
	public Scanner in = new Scanner (System.in);

	/**
	 * Le numero de la semaine
	 * @see ProgrammationSemaine#ProgrammationSemaine(int)
	 */
	int semaine;
	
	/**
	 * L'ensemble comportant toute les séances de cinéma ainsi que les films associés
	 */
	SortedMap<Film, SortedSet<SeanceCinema>> EnsembleSeancesCinema = new TreeMap<Film, SortedSet<SeanceCinema>>();
	
	/**
	 * L'ensemble comportant toute les séances de théatre ainsi que les pièces associées
	 */
	SortedMap<PieceTheatre, SortedSet<SeanceTheatre>> EnsembleSeancesTheatre = new TreeMap<>();

	/**
	 * Constructeur de ProgrammationSemaine, c'est lui qui crée la programmation d'une semaine donnéee (passée en paramètre)
	 * 
	 * @param semaine
	 * 		c'est le numéro de la semaine pour laquelle on va construire une programmation
	 */	
	public ProgrammationSemaine (int semaine) {
		this.semaine = semaine;
		int nbseance = 0;
		int choix = 1; 
		SortedSet<SeanceCinema> SeancesCinema = new TreeSet<SeanceCinema>();
		SortedSet<SeanceTheatre> SeancesTheatre = new TreeSet<SeanceTheatre>();
		System.out.println("Commençons la programmation de la semaine " + semaine + " !!" + "\n");
		while (choix == 1 || choix == 2) {
			System.out.print("voulez-vous programmer des séances de cinéma(1), des séances de théâtre(2), ou quitter(autre chiffre) : ");
			while (!in.hasNextInt()) {
				System.out.print("Votre choix (1 ou 2): ");
				in.next();			
			}
			choix = in.nextInt();
			if (choix == 1) {
				System.out.println("Création du film !!");
				Film nf = new Film();
				System.out.print("Combien de séances voulez vous créer pour ce film : ");
				while (!in.hasNextInt()) {
					System.out.print("Combien de séances voulez vous créer pour ce film : ");
					in.next();			
				}
				nbseance = in.nextInt();
				for (int i = 0; i < nbseance; i++) {
					SeancesCinema.add(new SeanceCinema ());	
				}
				associerSeanceCinema(SeancesCinema, nf);
			}
			if (choix == 2) {
				System.out.println("Création d'une pièce de théâtre");
				PieceTheatre np = new PieceTheatre();
				System.out.print("Combien de séances voulez vous créer pour cette pièce : ");
				while (!in.hasNextInt()) {
					System.out.print("Combien de séances voulez vous créer pour cette pièce : ");
					in.next();			
				}
				nbseance = in.nextInt();
				for (int i = 0; i < nbseance; i++) {
					SeancesTheatre.add(new SeanceTheatre ());
				}
				associerSeanceTheatre(SeancesTheatre, np);
			}
		}
		System.out.println("");
		System.out.println("Vous avez quitté la programmation de le semaine " + semaine + " !!");
		System.out.println("");
		System.out.println("En voici le programme :");
		System.out.println(this.toString());
	}

	/**
	 * Méthode qui affiche toutes les séances de cinéma figurant dans l'ensemble passé en paramètre
	 * 
	 * @param es
	 * 		c'est l'ensemble des séances de cinéma à afficher
	 * 
	 * @return String
	 * 		La méthode retourne une chaîne de caractère contenant l'affichage de toute les séances de cinéma contenues dans es
	 */	
	public String toStringc(SortedSet<SeanceCinema> es) {
		String s = "    Séances prévues pour ce film : " + "\n";
		for (Seance item: es) {
			s += "      " + item;
			s += "\n";
		}
		return s;
	}

	/**
	 * Méthode qui affiche tout les film figurant dans l'ensemble passé en paramètre
	 * 
	 * @param m
	 * 		c'est l'ensemble comportant les films à afficher mais aussi les séances associés à chaque film
	 * 
	 * @return String
	 * 		La méthode retourne une chaîne de caractère contenant l'affichage de chacun des films contenues dans m
	 */	
	public String toStringc(SortedMap<Film, SortedSet<SeanceCinema>> m) {
		int aff = 0; 
		String s = "Listes des film : " + "\n";
		for (SortedMap.Entry<Film, SortedSet<SeanceCinema>> entree : m.entrySet()) {
			s += " -  " + (entree.getKey().toString()+"\n" + toStringc(entree.getValue()) + "\n");
			s += "\n";
			aff ++ ;
		}
		if (aff == 0) {
			s += "Aucun film programmé cette semaine" + "\n" + "\n";
		}
		return s;
	}

	/**
	 * Méthode qui affiche toutes les séances de théâtre figurant dans l'ensemble passé en paramètre
	 * 
	 * @param es
	 * 		c'est l'ensemble des séances de théâtre à afficher
	 * 
	 * @return String
	 * 		La méthode retourne une chaîne de caractère contenant l'affichage de toute les séances de théâtre contenues dans es
	 */	
	public String toStringt(SortedSet<SeanceTheatre> es) {
		String s = "    Séances prévues pour cette pièce : " + "\n";
		for (Seance item: es) {
			s += "      " + item;
			s += "\n";
		}
		return s;
	}

	/**
	 * Méthode qui affiche toutes les pièces de théâtre figurant dans l'ensemble passé en paramètre
	 * 
	 * @param m
	 * 		c'est l'ensemble comportant les pièces à afficher mais aussi les séances associés à chaque pièce
	 * 
	 * @return String
	 * 		La méthode retourne une chaîne de caractère contenant l'affichage de chacunes des pièces contenues dans m
	 */	
	public String toStringt(SortedMap<PieceTheatre, SortedSet<SeanceTheatre>> m) {
		int aff = 0;
		String s = "Listes des Pièces : " + "\n";
		for (SortedMap.Entry<PieceTheatre, SortedSet<SeanceTheatre>> entree : m.entrySet()) {
			s += " -  " + (entree.getKey().toString()+"\n" + toStringt(entree.getValue()) + "\n");
			s += "\n";
			aff++;
		}
		if (aff == 0) {
			s += "Aucune pièce programmée cette semaine" + "\n";
		}
		return s;
	}

	/**
	 * toString principal de ProgrammationSemaine, il affiche la Programmation d'une semaine, d'abord les films et ses séances associées et ensuite les pièce de théâtre et ses séances associées
	 *
	 * @return String
	 * 		La méthode retourne une chaîne de caractère contenant l'affichage de la programmation d'une semaine
	 */	
	public String toString() {
		return (toStringc(EnsembleSeancesCinema)) + (toStringt(EnsembleSeancesTheatre));

	}

	//cinema
	
	/**
	 * Méthode associant un film à un ensemble de séance 
	 * 
	 * @param EnsembleSeance
	 * 		c'est l'ensemble comportant les séances auquel aucun film n'est associé
	 * 
	 * @param f
	 * 		c'est le film que l'on va associer a l'ensemble de séances
	 */	
	public void associerSeanceCinema(SortedSet<SeanceCinema> EnsembleSeance, Film f) {
		this.EnsembleSeancesCinema.put(f, EnsembleSeance);
	}

	/**
	 * Méthode permettant de recuperer toutes les séances d'un film donné 
	 * 
	 * @param f
	 * 		c'est le film dont on va recupérer les seances 
	 * 
	 * @return SortedSet<SeanceCinema>
	 * 		Ensemble de séance auxquelles étaient associées le film
	 */
	public SortedSet<SeanceCinema> recupererSeancesFilm(Film f) {
		if (this.EnsembleSeancesCinema.containsKey(f)) {
			for (SortedMap.Entry<Film, SortedSet<SeanceCinema>> entree : this.EnsembleSeancesCinema.entrySet()) {
				if (entree.getKey().equals(f)) {
					return entree.getValue();
				}
			}
		}
		return null;
	}

	/**
	 * Méthode permettant de recuperer les séances d'un film donné et un certain jour de la semaine
	 * 
	 * @param f
	 * 		c'est le film dont on va recupérer les seances 
	 * 
	 * @param jour
	 * 		c'est le jour sur lequel on va récuperer les séances du film
	 * 
	 * @return SortedSet<SeanceCinema>
	 * 		Ensemble de séance auxquelles étaient associées le film
	 */
	public SortedSet<SeanceCinema> recupererSeancesFilmJourDonne (Film f, int jour){
		SortedSet<SeanceCinema> e = new TreeSet<SeanceCinema>();
		for (SortedMap.Entry<Film, SortedSet<SeanceCinema>> entree : this.EnsembleSeancesCinema.entrySet()) {
			if (entree.getKey().equals(f)) {
				for (SeanceCinema item: entree.getValue()) {
					if (item.jour == jour) {
						e.add(item);
					}
				}
			}
		}
		return e;
	}

	/**
	 * Méthode permettant de retirer un film de la programmation 
	 * 
	 * @param f
	 * 		c'est le film que l'on va retirer
	 */
	public void retirerFilm(Film f) {
		for (SortedMap.Entry<Film, SortedSet<SeanceCinema>> entree : this.EnsembleSeancesCinema.entrySet()) {
			if (entree.getKey().equals(f)) {
				this.EnsembleSeancesCinema.remove(f);
			}
		}
	}

	/**
	 * Méthode permettant de recuperer tout les films de la semaine, donc tout les films d'une programmation
	 * 
	 * @return SortedSet<Film>
	 * 		Ensemble des films programmés 
	 */
	public SortedSet<Film> recupererFilmsSemaine() {
		SortedSet<Film> e = new TreeSet<Film>();
		for (SortedMap.Entry<Film, SortedSet<SeanceCinema>> entree : this.EnsembleSeancesCinema.entrySet()) {
			e.add(entree.getKey());
		}
		return e;
	}

	/**
	 * Méthode permettant de recuperer le nombre de films de la semaine, donc le nombre de films de la programmation
	 * 
	 * @return int
	 * 		Nombres de films
	 */
	public int nbFilms() {
		return this.EnsembleSeancesCinema.size();
	}

	/**
	 * Méthode qui vérifie si un film est bien programmé dans la semaine courante
	 * 
	 *  * @param f
	 * 		c'est le film que l'on va vérifier
	 * 
	 * @return boolean
	 * 		booléen qui dit si oui ou non le film était programmé
	 */
	public boolean verifierFilm(Film f) {
		return this.EnsembleSeancesCinema.containsKey(f);
	}

	/**
	 * Méthode permettant de supprimer une séance de cinéma ou plusieurs 
	 * 
	 * @param seances
	 * 		Ensemble contenant les séances que l'on va supprimer 
	 */
	public void supprimerSeanceCinema(SortedSet<SeanceCinema> seances) {
		SortedSet<SeanceCinema> seancesasupp = new TreeSet<SeanceCinema>();
		for (SeanceCinema item: seances) {
			System.out.println(item.toString());
			System.out.print("Voulez vous supprimer cette seance (1 = oui et autre chose = non)");
			while (!in.hasNextInt()) {
				System.out.print("Votre choix (1 ou un autre entier): ");
				in.next();			
			}
			int supp = in.nextInt();
			if (supp == 1) {
				seancesasupp.add(item);
				System.out.print("La séance a été supprimée" + "\n");
			}
		}
		seances.removeAll(seancesasupp);
	}

	/**
	 * Méthode affichant un film en particulier, grâce à son heure et jour de diffusion
	 * 
	 * @param f
	 * 		c'est le film dont on va afficher les détails
	 * 
	 * @param j
	 * 		c'est le jour sur lequel on va séléctionner le film
	 * 
	 * @param h 
	 * 		c'est l'heure du film que l'on va séléctionner
	 * 
	 * @return String
	 * 		retourne l'affichage d'un film
	 */
	public String consulterFilm(Film f, int j, Heure h) {
		if (this.EnsembleSeancesCinema.containsKey(f)) {
			for (SortedMap.Entry<Film, SortedSet<SeanceCinema>> entree : this.EnsembleSeancesCinema.entrySet()) {
				if (entree.getKey().equals(f)) {
					for (SeanceCinema item: entree.getValue()) {
						if (item.jour == j && item.horaire.equals(h)) {
							return "jour : " + j + " à " + h.toString() + ", vous verrez " + entree.getKey().toString();
						}
					}
				}
			}
		}
		return "le film demandé n'est pas programmé";
	}


	// theatre

	/**
	 * Méthode associant une pièce de théâtre à un ensemble de séance 
	 * 
	 * @param EnsembleSeance
	 * 		c'est l'ensemble comportant les séances auquel aucun film n'est associé
	 * 
	 * @param p
	 * 		c'est la pièce que l'on va associer a l'ensemble de séances
	 */	
	public void associerSeanceTheatre(SortedSet<SeanceTheatre> EnsembleSeance, PieceTheatre p) {
		this.EnsembleSeancesTheatre.put(p, EnsembleSeance);
	}

	/**
	 * Méthode permettant de recuperer toutes les séances d'une pièce de théâtre donnée
	 * 
	 * @param pt
	 * 		c'est la pièce dont on va recupérer les seances 
	 * 
	 * @return SortedSet<SeanceTheatre>
	 * 		Ensemble de séance auxquelles étaient associées la pièce
	 */
	public SortedSet<SeanceTheatre> recupererSeancesTheatre(PieceTheatre pt) {
		if (this.EnsembleSeancesTheatre.containsKey(pt)) {
			for (SortedMap.Entry<PieceTheatre, SortedSet<SeanceTheatre>> entree : this.EnsembleSeancesTheatre.entrySet()) {
				if (entree.getKey().equals(pt)) {
					return entree.getValue();
				}
			}
		}
		return null;
	}

	/**
	 * Méthode permettant de recuperer les séances d'une pièce de théâtre donnée, cela un certain jour de la semaine
	 * 
	 * @param pt
	 * 		c'est la pièce dont on va recupérer les seances 
	 * 
	 * @param jour
	 * 		c'est le jour sur lequel on va récuperer les séances de la pièce
	 * 
	 * @return SortedSet<SeanceTheatre>
	 * 		Ensemble de séances auxquelles étaient associées la pièce
	 */
	public SortedSet<SeanceTheatre> recupererSeancesTheatreJourDonne (PieceTheatre pt, int jour) {
		SortedSet<SeanceTheatre> e = new TreeSet<SeanceTheatre>();
		for (SortedMap.Entry<PieceTheatre, SortedSet<SeanceTheatre>> entree : this.EnsembleSeancesTheatre.entrySet()) {
			if (entree.getKey().equals(pt)) {
				for (SeanceTheatre item: entree.getValue()) {
					if (item.jour == jour) {
						e.add(item);
					}
				}
			}
		}
		return e;
	}

	/**
	 * Méthode permettant de retirer une pièce de théâtre de la programmation 
	 * 
	 * @param pt
	 * 		c'est la pièce que l'on va retirer
	 */
	public void retirerPiece(PieceTheatre pt) {
		for (SortedMap.Entry<PieceTheatre, SortedSet<SeanceTheatre>> entree : this.EnsembleSeancesTheatre.entrySet()) {
			if (entree.getKey().equals(pt)) {
				this.EnsembleSeancesTheatre.replace(new PieceTheatre ("Par défaut", " ", " ", 0), null);
			}
		}
	}

	/**
	 * Méthode permettant de recuperer toutes les pièce de théâtre de la semaine, donc toutes les pièces d'une programmation
	 * 
	 * @return SortedSet<PieceTheatre>
	 * 		Ensemble des pièces programmées 
	 */
	public SortedSet<PieceTheatre> recupererPiecesSemaine(int semaine) {
		SortedSet<PieceTheatre> e = new TreeSet<PieceTheatre>();
		for (SortedMap.Entry<PieceTheatre, SortedSet<SeanceTheatre>> entree : this.EnsembleSeancesTheatre.entrySet()) {
			e.add(entree.getKey());
		}
		return e;
	}

	/**
	 * Méthode permettant de recuperer le nombre de pièces de la semaine, donc le nombre de pièces de la programmation
	 * 
	 * @return int
	 * 		Nombres de pièces
	 */
	public int nbPieces() {
		return this.EnsembleSeancesTheatre.size();
	}

	/**
	 * Méthode qui vérifie si une pièce est bien programmée dans la semaine courante
	 * 
	 *  * @param pt
	 * 		c'est la pièce que l'on va vérifier
	 * 
	 * @return boolean
	 * 		booléen qui dit si oui ou non la pièce était programmée
	 */
	public boolean verifierPiece(PieceTheatre pt) {
		return this.EnsembleSeancesTheatre.containsKey(pt);
	}

	/**
	 * Méthode permettant de supprimer une ou plusieurs séance 
	 * 
	 * @param seances
	 * 		Ensemble contenant les séances que l'on va supprimer 
	 */
	public void supprimerSeanceTheatre(SortedSet<SeanceTheatre> seances) {
		SortedSet<SeanceTheatre> seancesasupp = new TreeSet<SeanceTheatre>();
		for (SeanceTheatre item: seances) {
			System.out.println(item.toString());
			System.out.print("Voulez vous supprimer cette seance (1 = oui et autre chose = non)");
			while (!in.hasNextInt()) {
				System.out.print("Votre choix (1 ou un autre entier): ");
				in.next();			
			}
			int supp = in.nextInt();
			if (supp == 1) {
				seancesasupp.add(item);
				System.out.print("La séance a été supprimée" + "\n");
			}
		}
		seances.removeAll(seancesasupp);
	}
}
