package projet;
import java.io.*;
import java.util.*;

/**
 * 
 *<b>SeanceCinema est la classe représentant une seance de cinema.</b>
 * <p>
 * Une sance de cinema est caractérisée par les informations suivantes :
 * <ul>
 * <li>Une salle (Salle).</li>
 * <li>Un nombre de places vendues nbPlacesVendues (int).</li>
 * </ul>
 * </p>
 * 
 * @see Seance
 * @see Salle
 * 
 */
public class SeanceCinema extends Seance {

	/**
	 * La salle associee a la seance
	 * @see SeanceCinema#SeanceCinema()
	 * @see SeanceCinema#SeanceCinema(int, Heure, Salle, int)
	 * @see SeanceCinema#nbPlacesDispo()
	 * @see SeanceCinema#tauxRemplissage()
	 * @see SeanceCinema#toString()
	 */
	Salle salle;
	/**
	 * Le nombre de places vendues a tarif reduit
	 * @see SeanceCinema#SeanceCinema()
	 * @see SeanceCinema#SeanceCinema(int, Heure, Salle, int)
	 * @see SeanceCinema#vendrePlacesTR(int)
	 * @see SeanceCinema#nbPlacesDispo()
	 * @see SeanceCinema#totalVendu()
	 */
	int nbPlacesVenduesTR;

	/**
	 * Constructeur vide de SeanceCinema
	 * @see Seance
	 * @see SeanceCinema#salle
	 * @see SeanceCinema#nbPlacesVenduesTR
	 */	
	public SeanceCinema () {
		super();		
		this.salle = choixSalle();
		System.out.print("Veuillez indiquer le nombre de place à tarif normal déjà vendues pour votre séance : ");
		while (!in.hasNextInt()) {
			System.out.print("Veuillez indiquer le nombre de place à tarif normal déjà vendues pour votre séance : ");
			in.next();			
		}
		this.nbPlacesVenduesTn = in.nextInt();
		while (this.nbPlacesVenduesTn <0 || this.nbPlacesVenduesTn > this.nbPlacesDispo()) {
			System.out.print("La salle ne contient pas " + nbPlacesVenduesTn + " places normales, Veuillez indiquer le nombre de place à tarif normal déjà vendues pour votre séance : ");
			while (!in.hasNextInt()) {
				System.out.print("La salle ne contient pas " + nbPlacesVenduesTn + " places normales, Veuillez indiquer le nombre de place à tarif normal déjà vendues pour votre séance : ");
				in.next();			
			}
			this.nbPlacesVenduesTn = in.nextInt();
		}
		System.out.print("Veuillez indiquer le nombre de places à tarif réduit déja vendues pour votre séance de cinéma : ");
		while (!in.hasNextInt()) {
			System.out.print("Veuillez indiquer le nombre de places à tarif réduit déja vendues pour votre séance de cinéma : ");
			in.next();
		}
		this.nbPlacesVenduesTR = in.nextInt();
		while (this.nbPlacesVenduesTR < 0 || this.nbPlacesVenduesTR > this.nbPlacesDispo()) {
			System.out.print("La salle ne contient pas " + nbPlacesVenduesTR + " places normales, Veuillez indiquer le nombre de places à tarif réduit déja vendues pour votre séance de cinéma : ");
			while (!in.hasNextInt()) {
				System.out.print("La salle ne contient pas " + nbPlacesVenduesTR + " places normales, Veuillez indiquer le nombre de places à tarif réduit déja vendues pour votre séance de cinéma : ");
				in.next();
			}
			this.nbPlacesVenduesTR = in.nextInt();
		}
		System.out.println("Votre séance de cinéma a été crée !!!");
	}

	/**
	 * Constructeur de SeanceCinema
	 * 
	 * @param jour
	 * 		Le jour de la seance
	 * @param horaire
	 * 		L'horraire de la seance
	 * @param salle
	 * 		La salle ou sera diffuse le film
	 * @param nbPlacesVenduesTR
	 * 		Le nombre de places vendues a tarif reduit
	 * 
	 * @see Seance#setJour(int)
	 * @see Seance#setHoraire(Heure)
	 * @see SeanceCinema#salle
	 * @see SeanceCinema#nbPlacesVenduesTR
	 */
	public SeanceCinema (int jour, Heure horaire, Salle salle, int nbPlacesVenduesTR) {
		super();
		super.setHoraire(horaire);
		super.setJour(jour);
		this.salle = salle;
		this.nbPlacesVenduesTR = nbPlacesVenduesTR;
	}


	/**
	 * Retourne un ensemble de salles contenues dans le fichier SallesCinema.csv
	 * 
	 * @return un ensemble de salles contenues dans le fichier SallesCinema.csv sous forme d'un SortedSet
	 * 
	 */
	public static SortedSet<Salle> recupsallecinecsv (){
		SortedSet<Salle> EnsembleSallesCinema = new TreeSet<Salle>();
		try {
			FileReader f = new FileReader ("SallesCinema.csv");
			BufferedReader b = new BufferedReader(f);
			String s = " ";
			while((s= b.readLine())!=null){	
				Scanner sc = new Scanner (s);
				sc.useDelimiter(";");
				try {
				EnsembleSallesCinema.add(new Salle(sc.next(), sc.nextInt(), sc.nextDouble()));
				}catch(Exception e) {
					System.out.print("");
				}
				sc.close();
			}
			b.close();
		}catch(IOException e) {
			System.out.println(e);
		}
		return EnsembleSallesCinema;
	}


	/**
	 * Retourne la salle choisie par l'utilisateur
	 * 
	 * @return la salle choisie par l'utilisateur sous forme de Salle
	 */
	public static Salle choixSalle () {
		int i = 0;
		Salle s = null;
		System.out.println("Parmi les salles suivantes : ");
		SortedSet<Salle> salles = recupsallecinecsv();
		System.out.print(toString(salles));
		System.out.print("Laquelle voulez vous séléctionner : ");
		while (!in.hasNextInt()) {
			System.out.print("1Laquelle voulez vous séléctionner : ");
			in.next();
		}
		int salle = in.nextInt();
		while (salle <= 0 || salle > 6) {
			System.out.print("2Laquelle voulez vous séléctionner : ");
			while (in.hasNextInt()) {
				System.out.print("3Laquelle voulez vous séléctionner : ");
				in.next();
			}
			salle = in.nextInt();
		}
		for (Salle item: salles) {
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
	 * 		L'ensemble contenant les salles de cinema
	 * 
	 * @return l'affichage des salles de cinema sous forme d'une chaine de caracteres
	 */
	public static String toString(SortedSet<Salle> a) {
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
	 * Incremente le nombre de places vendues a tarif reduit (nbPlacesVenduesTR)
	 * 
	 * @param nbre
	 * 		Le nombre de places vendues a tarif reduit qui est ajouter au total des plaes vendues a tarif reduit
	 * 
	 * @see SeanceCinema#nbPlacesVenduesTR
	 */
	public void vendrePlacesTR(int nbre) {
		while (nbre > this.nbPlacesDispo()) {
			System.out.print("le nombre de places que vous voulez vendre est supérieur à la capacité de la salle, ré-essayer : ");
			while (!in.hasNextInt()) {
				System.out.print("le nombre de places que vous voulez vendre est supérieur à la capacité de la salle, ré-essayer : ");
				in.next();
			}
			nbre = in.nextInt();
		}
		this.nbPlacesVenduesTR += nbre;
	}

	/**
	 * Indique le nombre de places disponibles
	 * 
	 * @return le nombre de places disponibles sous forme d'entier
	 * 
	 * @see SeanceCinema#salle
	 * @see Salle#capacite
	 * @see Seance#nbPlacesVenduesTn
	 * @see SeanceCinema#nbPlacesVenduesTR
	 */
	@Override
	public int nbPlacesDispo() {
		return (salle.capacite - (this.nbPlacesVenduesTn + this.nbPlacesVenduesTR));
	}

	/**
	 * Retourne le total des places vendues a tarif norml et tarif reduit
	 * 
	 * @return le total des places vendues sous forme d'entier
	 * 
	 * @see Seance#nbPlacesVenduesTn
	 * @see SeanceCinema#nbPlacesVenduesTR
	 */
	@Override
	public int totalVendu() {
		return (this.nbPlacesVenduesTn + this.nbPlacesVenduesTR);
	}

	/**
	 * Retourne le taux de remplissage de la salle
	 * 
	 * @return le taux de remplissage sous forme de reel
	 * 
	 * @see SeanceCinema#totalVendu()
	 * @see SeanceCinema#salle
	 * @see Salle#capacite
	 */
	@Override
	public double tauxRemplissage() {
		return ((this.totalVendu() / salle.capacite) * 100);
	}

	/**
	 * Permet l'affichage d'une description de la Seance de cinema
	 * 
	 * @return la description de la seance sous forme de chaine d'une caracteres
	 * 
	 * @see Seance#toString()
	 * @see SeanceCinema#salle
	 * @see Salle#nomSalle
	 */
	public String toString () {
		return (super.toString() + " dans la salle " + this.salle.nomSalle);
	}


	/**
	 * Retourne un booleen indiquant si l'objet en parametre est egal a la seance de cinema
	 * 
	 * @param obj
	 * 		L'objet a comparer
	 * 
	 * @return le resultat de la comparaison sous forme de booleen
	 * 
	 * @see SeanceCinema#nbPlacesVenduesTR
	 * @see SeanceCinema#salle
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SeanceCinema other = (SeanceCinema) obj;
		if (nbPlacesVenduesTR != other.nbPlacesVenduesTR)
			return false;
		if (salle == null) {
			if (other.salle != null)
				return false;
		} else if (!salle.equals(other.salle))
			return false;
		return true;
	}

	public int getJour () {
		return this.jour;
	}
}
