package projet;
import java.util.*;

/**
 * 
 *<b>ProgrammationSemaine est la classe permettant de programmer des spectacles sur une semaine donnee.</b>
 * <p>
 * La programmation d'une semaine est caract�ris�e par les informations suivantes :
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
	 * L'ensemble comportant toute les s�ances de cin�ma ainsi que les films associ�s
	 */
	SortedMap<Film, SortedSet<SeanceCinema>> EnsembleSeancesCinema = new TreeMap<Film, SortedSet<SeanceCinema>>();
	
	/**
	 * L'ensemble comportant toute les s�ances de th�atre ainsi que les pi�ces associ�es
	 */
	SortedMap<PieceTheatre, SortedSet<SeanceTheatre>> EnsembleSeancesTheatre = new TreeMap<>();

	/**
	 * Constructeur de ProgrammationSemaine, c'est lui qui cr�e la programmation d'une semaine donn�ee (pass�e en param�tre)
	 * 
	 * @param semaine
	 * 		c'est le num�ro de la semaine pour laquelle on va construire une programmation
	 */	
	public ProgrammationSemaine (int semaine) {
		this.semaine = semaine;
		int nbseance = 0;
		int choix = 1; 
		SortedSet<SeanceCinema> SeancesCinema = new TreeSet<SeanceCinema>();
		SortedSet<SeanceTheatre> SeancesTheatre = new TreeSet<SeanceTheatre>();
		System.out.println("Commen�ons la programmation de la semaine " + semaine + " !!" + "\n");
		while (choix == 1 || choix == 2) {
			System.out.print("voulez-vous programmer des s�ances de cin�ma(1), des s�ances de th��tre(2), ou quitter(autre chiffre) : ");
			while (!in.hasNextInt()) {
				System.out.print("Votre choix (1 ou 2): ");
				in.next();			
			}
			choix = in.nextInt();
			if (choix == 1) {
				System.out.println("Cr�ation du film !!");
				Film nf = new Film();
				System.out.print("Combien de s�ances voulez vous cr�er pour ce film : ");
				while (!in.hasNextInt()) {
					System.out.print("Combien de s�ances voulez vous cr�er pour ce film : ");
					in.next();			
				}
				nbseance = in.nextInt();
				for (int i = 0; i < nbseance; i++) {
					SeancesCinema.add(new SeanceCinema ());	
				}
				associerSeanceCinema(SeancesCinema, nf);
			}
			if (choix == 2) {
				System.out.println("Cr�ation d'une pi�ce de th��tre");
				PieceTheatre np = new PieceTheatre();
				System.out.print("Combien de s�ances voulez vous cr�er pour cette pi�ce : ");
				while (!in.hasNextInt()) {
					System.out.print("Combien de s�ances voulez vous cr�er pour cette pi�ce : ");
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
		System.out.println("Vous avez quitt� la programmation de le semaine " + semaine + " !!");
		System.out.println("");
		System.out.println("En voici le programme :");
		System.out.println(this.toString());
	}

	/**
	 * M�thode qui affiche toutes les s�ances de cin�ma figurant dans l'ensemble pass� en param�tre
	 * 
	 * @param es
	 * 		c'est l'ensemble des s�ances de cin�ma � afficher
	 * 
	 * @return String
	 * 		La m�thode retourne une cha�ne de caract�re contenant l'affichage de toute les s�ances de cin�ma contenues dans es
	 */	
	public String toStringc(SortedSet<SeanceCinema> es) {
		String s = "    S�ances pr�vues pour ce film : " + "\n";
		for (Seance item: es) {
			s += "      " + item;
			s += "\n";
		}
		return s;
	}

	/**
	 * M�thode qui affiche tout les film figurant dans l'ensemble pass� en param�tre
	 * 
	 * @param m
	 * 		c'est l'ensemble comportant les films � afficher mais aussi les s�ances associ�s � chaque film
	 * 
	 * @return String
	 * 		La m�thode retourne une cha�ne de caract�re contenant l'affichage de chacun des films contenues dans m
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
			s += "Aucun film programm� cette semaine" + "\n" + "\n";
		}
		return s;
	}

	/**
	 * M�thode qui affiche toutes les s�ances de th��tre figurant dans l'ensemble pass� en param�tre
	 * 
	 * @param es
	 * 		c'est l'ensemble des s�ances de th��tre � afficher
	 * 
	 * @return String
	 * 		La m�thode retourne une cha�ne de caract�re contenant l'affichage de toute les s�ances de th��tre contenues dans es
	 */	
	public String toStringt(SortedSet<SeanceTheatre> es) {
		String s = "    S�ances pr�vues pour cette pi�ce : " + "\n";
		for (Seance item: es) {
			s += "      " + item;
			s += "\n";
		}
		return s;
	}

	/**
	 * M�thode qui affiche toutes les pi�ces de th��tre figurant dans l'ensemble pass� en param�tre
	 * 
	 * @param m
	 * 		c'est l'ensemble comportant les pi�ces � afficher mais aussi les s�ances associ�s � chaque pi�ce
	 * 
	 * @return String
	 * 		La m�thode retourne une cha�ne de caract�re contenant l'affichage de chacunes des pi�ces contenues dans m
	 */	
	public String toStringt(SortedMap<PieceTheatre, SortedSet<SeanceTheatre>> m) {
		int aff = 0;
		String s = "Listes des Pi�ces : " + "\n";
		for (SortedMap.Entry<PieceTheatre, SortedSet<SeanceTheatre>> entree : m.entrySet()) {
			s += " -  " + (entree.getKey().toString()+"\n" + toStringt(entree.getValue()) + "\n");
			s += "\n";
			aff++;
		}
		if (aff == 0) {
			s += "Aucune pi�ce programm�e cette semaine" + "\n";
		}
		return s;
	}

	/**
	 * toString principal de ProgrammationSemaine, il affiche la Programmation d'une semaine, d'abord les films et ses s�ances associ�es et ensuite les pi�ce de th��tre et ses s�ances associ�es
	 *
	 * @return String
	 * 		La m�thode retourne une cha�ne de caract�re contenant l'affichage de la programmation d'une semaine
	 */	
	public String toString() {
		return (toStringc(EnsembleSeancesCinema)) + (toStringt(EnsembleSeancesTheatre));

	}

	//cinema
	
	/**
	 * M�thode associant un film � un ensemble de s�ance 
	 * 
	 * @param EnsembleSeance
	 * 		c'est l'ensemble comportant les s�ances auquel aucun film n'est associ�
	 * 
	 * @param f
	 * 		c'est le film que l'on va associer a l'ensemble de s�ances
	 */	
	public void associerSeanceCinema(SortedSet<SeanceCinema> EnsembleSeance, Film f) {
		this.EnsembleSeancesCinema.put(f, EnsembleSeance);
	}

	/**
	 * M�thode permettant de recuperer toutes les s�ances d'un film donn� 
	 * 
	 * @param f
	 * 		c'est le film dont on va recup�rer les seances 
	 * 
	 * @return SortedSet<SeanceCinema>
	 * 		Ensemble de s�ance auxquelles �taient associ�es le film
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
	 * M�thode permettant de recuperer les s�ances d'un film donn� et un certain jour de la semaine
	 * 
	 * @param f
	 * 		c'est le film dont on va recup�rer les seances 
	 * 
	 * @param jour
	 * 		c'est le jour sur lequel on va r�cuperer les s�ances du film
	 * 
	 * @return SortedSet<SeanceCinema>
	 * 		Ensemble de s�ance auxquelles �taient associ�es le film
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
	 * M�thode permettant de retirer un film de la programmation 
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
	 * M�thode permettant de recuperer tout les films de la semaine, donc tout les films d'une programmation
	 * 
	 * @return SortedSet<Film>
	 * 		Ensemble des films programm�s 
	 */
	public SortedSet<Film> recupererFilmsSemaine() {
		SortedSet<Film> e = new TreeSet<Film>();
		for (SortedMap.Entry<Film, SortedSet<SeanceCinema>> entree : this.EnsembleSeancesCinema.entrySet()) {
			e.add(entree.getKey());
		}
		return e;
	}

	/**
	 * M�thode permettant de recuperer le nombre de films de la semaine, donc le nombre de films de la programmation
	 * 
	 * @return int
	 * 		Nombres de films
	 */
	public int nbFilms() {
		return this.EnsembleSeancesCinema.size();
	}

	/**
	 * M�thode qui v�rifie si un film est bien programm� dans la semaine courante
	 * 
	 *  * @param f
	 * 		c'est le film que l'on va v�rifier
	 * 
	 * @return boolean
	 * 		bool�en qui dit si oui ou non le film �tait programm�
	 */
	public boolean verifierFilm(Film f) {
		return this.EnsembleSeancesCinema.containsKey(f);
	}

	/**
	 * M�thode permettant de supprimer une s�ance de cin�ma ou plusieurs 
	 * 
	 * @param seances
	 * 		Ensemble contenant les s�ances que l'on va supprimer 
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
				System.out.print("La s�ance a �t� supprim�e" + "\n");
			}
		}
		seances.removeAll(seancesasupp);
	}

	/**
	 * M�thode affichant un film en particulier, gr�ce � son heure et jour de diffusion
	 * 
	 * @param f
	 * 		c'est le film dont on va afficher les d�tails
	 * 
	 * @param j
	 * 		c'est le jour sur lequel on va s�l�ctionner le film
	 * 
	 * @param h 
	 * 		c'est l'heure du film que l'on va s�l�ctionner
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
							return "jour : " + j + " � " + h.toString() + ", vous verrez " + entree.getKey().toString();
						}
					}
				}
			}
		}
		return "le film demand� n'est pas programm�";
	}


	// theatre

	/**
	 * M�thode associant une pi�ce de th��tre � un ensemble de s�ance 
	 * 
	 * @param EnsembleSeance
	 * 		c'est l'ensemble comportant les s�ances auquel aucun film n'est associ�
	 * 
	 * @param p
	 * 		c'est la pi�ce que l'on va associer a l'ensemble de s�ances
	 */	
	public void associerSeanceTheatre(SortedSet<SeanceTheatre> EnsembleSeance, PieceTheatre p) {
		this.EnsembleSeancesTheatre.put(p, EnsembleSeance);
	}

	/**
	 * M�thode permettant de recuperer toutes les s�ances d'une pi�ce de th��tre donn�e
	 * 
	 * @param pt
	 * 		c'est la pi�ce dont on va recup�rer les seances 
	 * 
	 * @return SortedSet<SeanceTheatre>
	 * 		Ensemble de s�ance auxquelles �taient associ�es la pi�ce
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
	 * M�thode permettant de recuperer les s�ances d'une pi�ce de th��tre donn�e, cela un certain jour de la semaine
	 * 
	 * @param pt
	 * 		c'est la pi�ce dont on va recup�rer les seances 
	 * 
	 * @param jour
	 * 		c'est le jour sur lequel on va r�cuperer les s�ances de la pi�ce
	 * 
	 * @return SortedSet<SeanceTheatre>
	 * 		Ensemble de s�ances auxquelles �taient associ�es la pi�ce
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
	 * M�thode permettant de retirer une pi�ce de th��tre de la programmation 
	 * 
	 * @param pt
	 * 		c'est la pi�ce que l'on va retirer
	 */
	public void retirerPiece(PieceTheatre pt) {
		for (SortedMap.Entry<PieceTheatre, SortedSet<SeanceTheatre>> entree : this.EnsembleSeancesTheatre.entrySet()) {
			if (entree.getKey().equals(pt)) {
				this.EnsembleSeancesTheatre.replace(new PieceTheatre ("Par d�faut", " ", " ", 0), null);
			}
		}
	}

	/**
	 * M�thode permettant de recuperer toutes les pi�ce de th��tre de la semaine, donc toutes les pi�ces d'une programmation
	 * 
	 * @return SortedSet<PieceTheatre>
	 * 		Ensemble des pi�ces programm�es 
	 */
	public SortedSet<PieceTheatre> recupererPiecesSemaine(int semaine) {
		SortedSet<PieceTheatre> e = new TreeSet<PieceTheatre>();
		for (SortedMap.Entry<PieceTheatre, SortedSet<SeanceTheatre>> entree : this.EnsembleSeancesTheatre.entrySet()) {
			e.add(entree.getKey());
		}
		return e;
	}

	/**
	 * M�thode permettant de recuperer le nombre de pi�ces de la semaine, donc le nombre de pi�ces de la programmation
	 * 
	 * @return int
	 * 		Nombres de pi�ces
	 */
	public int nbPieces() {
		return this.EnsembleSeancesTheatre.size();
	}

	/**
	 * M�thode qui v�rifie si une pi�ce est bien programm�e dans la semaine courante
	 * 
	 *  * @param pt
	 * 		c'est la pi�ce que l'on va v�rifier
	 * 
	 * @return boolean
	 * 		bool�en qui dit si oui ou non la pi�ce �tait programm�e
	 */
	public boolean verifierPiece(PieceTheatre pt) {
		return this.EnsembleSeancesTheatre.containsKey(pt);
	}

	/**
	 * M�thode permettant de supprimer une ou plusieurs s�ance 
	 * 
	 * @param seances
	 * 		Ensemble contenant les s�ances que l'on va supprimer 
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
				System.out.print("La s�ance a �t� supprim�e" + "\n");
			}
		}
		seances.removeAll(seancesasupp);
	}
}
