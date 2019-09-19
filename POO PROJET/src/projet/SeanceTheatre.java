package projet;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * 
 *<b>SeanceTheatre est la classe représentant une seance de theatre.</b>
 * <p>
 * Une sance de theatre est caractérisée par les informations suivantes :
 * <ul>
 * <li>Une salle de theatre salleTheatre (SalleTheatre).</li>
 * <li>Un nombre de fauteuil vendus nbFauteuilsVendus (int).</li>
 * </ul>
 * </p>
 * 
 * @see Seance
 * @see SalleTheatre
 * 
 */
public class SeanceTheatre extends Seance {
	
	/**
	 * La salle de theatre associee a la seance
	 * @see SeanceTheatre#SeanceTheatre()
	 * @see SeanceTheatre#SeanceTheatre(int, Heure, SalleTheatre, int)
	 * @see SeanceTheatre#nbFauteuilsDispo()
	 * @see SeanceTheatre#nbPlacesDispo()
	 * @see SeanceTheatre#tauxRemplissage()
	 * @see SeanceTheatre#toString()
	 */
	SalleTheatre salleTheatre;
	/**
	 * Le nombre de faurteuils vendus
	 * @see SeanceTheatre#SeanceTheatre()
	 * @see SeanceTheatre#SeanceTheatre(int, Heure, SalleTheatre, int)
	 * @see SeanceTheatre#nbFauteuilsDispo()
	 * @see SeanceTheatre#vendrePlacesFauteuil(int)
	 */
	int nbFauteuilsVendus;
	
	/**
	 * Constructeur vide de SeanceTheatre
	 * @see Seance
	 * @see SeanceTheatre#salleTheatre
	 * @see SeanceTheatre#nbFauteuilsVendus
	 */
	public SeanceTheatre () {
		super();
		this.salleTheatre = choixSalle();
		System.out.print("Veuillez indiquer le nombre de places normales déjà vendues pour votre séance : ");
		while (!in.hasNextInt()) {
			System.out.print("Veuillez indiquer le nombre de places normales déjà vendues pour votre séance : ");
			in.next();			
		}
		this.nbPlacesVenduesTn = in.nextInt();
		while (this.nbPlacesVenduesTn <0 || this.nbPlacesVenduesTn > this.nbPlacesnormalesDispo()) {
			System.out.print("La salle ne contient pas " + nbPlacesVenduesTn + " places normales, Veuillez indiquer le nombre de places normales déjà vendues pour votre séance : ");
			while (!in.hasNextInt()) {
				System.out.print("La salle ne contient pas " + nbPlacesVenduesTn + " places normales, Veuillez indiquer le nombre de places normales déjà vendues pour votre séance : ");
				in.next();			
			}
			this.nbPlacesVenduesTn = in.nextInt();
		}
		System.out.print("Veuillez indiquer le nombre de places en fauteuils déja vendues pour votre séance de théâtre : ");
		while (!in.hasNextInt()) {
			System.out.print("Veuillez indiquer le nombre de places en fauteuils déja vendues pour votre séance de théâtre : ");
			in.next();
		}
		this.nbFauteuilsVendus = in.nextInt();
		while (this.nbFauteuilsVendus < 0 || this.nbFauteuilsVendus > this.salleTheatre.nbFauteuils) {
			System.out.print("La salle ne contient pas " + nbFauteuilsVendus + " places en fauteuil, Veuillez indiquer le nombre de places en fauteuils déja vendues pour votre séance de théâtre : ");
			while (!in.hasNextInt()) {
				System.out.print("La salle ne contient pas \" + nbFauteuilsVendus + \" places en fauteuil, Veuillez indiquer le nombre de places en fauteuils déja vendues pour votre séance de théâtre : ");
				in.next();
			}
			this.nbFauteuilsVendus = in.nextInt();
		}
		System.out.println("Votre séance de Théâtre a été crée !!!");
	}
	
	/**
	 * Constructeur de SeanceTheatre
	 * 
	 * @param jour
	 * 		Le jour de la seance
	 * @param horaire
	 * 		L'horraire de la seance
	 * @param SalleTheatre
	 * 		La salle de theatre ou a lieu la piece
	 * @param nbFauteuilsVendus
	 * 		Le nombre de fauteuils vendus
	 * 
	 * @see Seance#setJour(int)
	 * @see Seance#setHoraire(Heure)
	 * @see SeanceTheatre#salleTheatre
	 * @see SeanceTheatre#nbFauteuilsVendus
	 */
	public SeanceTheatre (int jour, Heure horaire, SalleTheatre SalleTheatre, int nbFauteuilsVendus) {
		super();
		super.setHoraire(horaire);
		super.setJour(jour);
		this.salleTheatre = SalleTheatre;
		this.nbFauteuilsVendus = nbFauteuilsVendus;
	}
	
	
	/**
	 * Retourne un ensemble de salles contenues dans le fichier SallesTheatre.csv
	 * 
	 * @return un ensemble de salles contenues dans le fichier SallesTheatre.csv sous forme d'un SortedSet
	 * 
	 */
	public static SortedSet<SalleTheatre> recupsalletheatrecsv (){
		SortedSet<SalleTheatre> EnsembleSallesTheatre = new TreeSet<SalleTheatre>();
		try {
			FileReader f = new FileReader ("SallesTheatre.csv");
			BufferedReader b = new BufferedReader(f);
			String s = " ";
			while((s= b.readLine())!=null){	
				Scanner sc = new Scanner (s);
				sc.useDelimiter(";");
				try {
				EnsembleSallesTheatre.add(new SalleTheatre(sc.next(), sc.nextInt(), sc.nextDouble(), sc.nextInt(), sc.nextDouble()));
				}catch(Exception e) {
					System.out.print("");
				}
				sc.close();
			}
			b.close();
		}catch(IOException e) {
			System.out.println(e);
		}
		return EnsembleSallesTheatre;
	}
	
	

	/**
	 * Retourne la salle choisie par l'utilisateur
	 * 
	 * @return la salle choisie par l'utilisateur sous forme de SalleTheatre
	 */
	public static SalleTheatre choixSalle () {
		int i = 0;
		SalleTheatre s = null;
		System.out.println("Parmi les salles suivantes : ");
		SortedSet<SalleTheatre> salles = recupsalletheatrecsv();
		System.out.print(toString(salles));
		System.out.print("Laquelle voulez vous séléctionner : ");
		while (!in.hasNextInt()) {
			System.out.print("Laquelle voulez vous séléctionner : ");
			in.next();
		}
		int salle = in.nextInt();
		while (salle <= 0 || salle > 6) {
			System.out.print("Laquelle voulez vous séléctionner : ");
			while (in.hasNextInt()) {
				System.out.print("Laquelle voulez vous séléctionner : ");
				in.next();
			}
			salle = in.nextInt();
		}
		for (SalleTheatre item: salles) {
			i++;
			if (i == salle) {
				s = item;
			}
		}
		return s;
	}
	
	
	/**
	 * Retourne l'affichage des salles de l'ensemble a
	 * 
	 * @param a
	 * 		L'ensemble contenant les salles de theatre
	 * 
	 * @return l'affichage des salles de theatre sous forme d'une chaine de caracteres
	 */
	public static String toString(SortedSet<SalleTheatre> a) {
		String s = " ";
		int i = 0;
		for (Salle item: a) {
			i++;
			s += i;
			s += ") ";
			s += item;
			s += "\n";
		}
		return s;
	}
	
	/**
	 * retourne le nombre de fauteuils disponibles
	 * 
	 * @return le nombre de fauteuils disponibles sous forme d'entier
	 * 
	 * @see SeanceTheatre#salleTheatre
	 * @see SalleTheatre#nbFauteuils
	 * @see SeanceTheatre#nbFauteuilsVendus
	 */
	public int nbFauteuilsDispo() {
		return (salleTheatre.nbFauteuils - this.nbFauteuilsVendus);
	}
	
	/**
	 * Incremente le nombre de fauteuils vendus (nbFauteuilsVendus)
	 * 
	 * @param nbre
	 * 		Le nombre de fauteuils vendus qui est ajoute au nombre total de fauteuils vendus
	 * 
	 * @see SeanceTheatre#nbFauteuilsVendus
	 */
	public void vendrePlacesFauteuil(int nbre) {
		while (nbre > this.nbFauteuilsDispo()) {
			System.out.print("le nombre de places que vous voulez vendre est supérieur au nombre de fauteuils, ré-essayer : ");
			while (!in.hasNextInt()) {
				System.out.print("le nombre de places que vous voulez vendre est supérieur au nombre de fauteuils, ré-essayer : ");
				in.next();
			}
			nbre = in.nextInt();
		}
		nbFauteuilsVendus += nbre;
	}

	/**
	 * Indique le nombre de places disponibles
	 * 
	 * @return le nombre de places disponibles sous forme d'entier
	 * 
	 * @see SeanceTheatre#salleTheatre
	 * @see SalleTheatre#capaciteSalleTheatre
	 */
	@Override
	public int nbPlacesDispo() {
		return salleTheatre.capacite;
	}
	
	public int nbPlacesnormalesDispo() {
		return (this.nbPlacesDispo() - this.nbFauteuilsDispo());
	}

	/**
	 * Indique le nombre total de places vendues
	 * 
	 * @return le nombre total de places et de fauteuils vendus sous forme d'entier
	 * 
	 * @see Seance#nbPlacesVenduesTn
	 * @see SeanceTheatre#nbFauteuilsVendus
	 */
	@Override
	public int totalVendu() {
		return (this.nbPlacesVenduesTn + this.nbFauteuilsVendus);
	}

	/**
	 * Indique le taux de remplissage de a salle
	 * 
	 * @return le taux de remplissage de la salle sous la forme d'un reel
	 * 
	 * @see SeanceTheatre#totalVendu()
	 * @see SeanceTheatre#salleTheatre
	 * @see SalleTheatre#capaciteSalleTheatre
	 */
	@Override
	public double tauxRemplissage() {
		return ((this.totalVendu() / salleTheatre.capaciteSalleTheatre) * 100);
	}
	
	/**
	 * Permet l'affichage d'une description de la seance de theatre
	 * 
	 * @return la description de la seance sous forme d'une chaine de caracteres
	 * 
	 * @see Seance#toString()
	 * @see SeanceTheatre#salleTheatre
	 * @see Salle#nomSalle
	 */
	public String toString() {
		return (super.toString() + " dans la salle " + this.salleTheatre.nomSalle);
	}
}
