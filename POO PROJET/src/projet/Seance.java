package projet;
import java.util.Scanner;


/**
 * 
 *<b>Seance est la classe représentant une seance.</b>
 * <p>
 * Une seance est caractérisée par les informations suivantes :
 * <ul>
 * <li>Un jour (int).</li>
 * <li>Un horaire (Heure).</li>
 * <li>Un nombre de places vendues au tarif normal nbPlacesVenduesTN (int)</li>
 * </ul>
 * </p>
 * 
 * @see Comparable
 * 
 */
public abstract class Seance implements Comparable<Seance>{
	public static Scanner in = new Scanner (System.in);

	
	/**
	 * Le jour de la seance
	 * @see Seance#Seance()
	 * @see Seance#getJour()
	 * @see Seance#toString()
	 * @see Seance#compareTo(Seance)
	 */
	int jour;
	
	
	/**
	 * L'horaire de la seance
	 * @see Seance#Seance()
	 * @see Seance#getHoraire()
	 * @see Seance#setHoraire(Heure)
	 * @see Seance#toString()
	 */
	Heure horaire;
	
	
	/**
	 * Le nombre de places vendues au tarif normal
	 * @see Seance#Seance()
	 * @see Seance#vendrePlacesTN(int)
	 * @see Seance#getNbPlacesVenduesTn()
	 */
	int nbPlacesVenduesTn;

	
	/**
	 * Constructeur de Seance
	 * @see Seance#jour
	 * @see Seance#horaire
	 * @see Seance#nbPlacesVenduesTn
	 */
	public Seance() {
		System.out.println("Créons une séance !!");
		System.out.print("Veuillez entrer un jour de la semaine pour votre séance (entre 1 et 7) : ");
		while (!in.hasNextInt()) {
			System.out.print("Veuillez entrer un jour de la semaine pour votre séance (entre 1 et 7) : ");
			in.next();
		}
		this.jour = in.nextInt();
		while (jour <= 0 || jour > 7) {
			System.out.print("Veuillez entrer un jour de la semaine pour votre séance (entre 1 et 7) : ");
			while (!in.hasNextInt()) {
				System.out.print("Veuillez entrer un jour de la semaine pour votre séance (entre 1 et 7) : ");
				in.next();
			}
			this.jour = in.nextInt();
		}
		System.out.println("Veuillez séléctionner un horaire pour votre séance : ");
		System.out.print("   Heure : ");
		while (!in.hasNextInt()) {
			System.out.print("Heure : ");
			in.next();			
		}
		int heure = in.nextInt();
		while (heure <=0 || heure >=24) {
			System.out.print("Heure : ");
			while (!in.hasNextInt()) {
				System.out.print("Heure : ");
				in.next();			
			}
			heure = in.nextInt();
		}
		System.out.print("   Minutes : ");
		while (!in.hasNextInt()) {
			System.out.print("Minutes : ");
			in.next();			
		}
		int min = in.nextInt();
		while (heure <=0 || heure >=60) {
			System.out.print("Minutes : ");
			while (!in.hasNextInt()) {
				System.out.print("Minutes : ");
				in.next();			
			}
			min = in.nextInt();
		}
		this.horaire = new Heure (heure, min);
	}

	public abstract int nbPlacesDispo();

	public abstract int totalVendu();

	public abstract double tauxRemplissage();

	
	/**
	 * Incremente le nombre de places vendues a tarif normal (nbPlacesVenduesTN)
	 * 
	 * @param nbre
	 * 		Le nombre de places vendues a tarif normal qui est ajouter au total des plaes vendues a tarif normal
	 * 
	 * @see Seance#nbPlacesVenduesTn
	 */
	public void vendrePlacesTN(int nbre) {
		while (nbre > this.nbPlacesDispo()) {
			System.out.print("le nombre de places que vous voulez vendre est supérieur à la capacité de la salle, ré-essayer : ");
			while (!in.hasNextInt()) {
				System.out.print("vous n'avez pas entrer un entier, ré-essayer : ");
				in.next();
			}
			nbre = in.nextInt();
		}
		this.nbPlacesVenduesTn += nbre;
	}

	
	/**
	 * Retourne le jour de la seance
	 * 
	 * @return le jour de la seance sous forme d'un entier
	 * 
	 * @see Seance#jour
	 */
	public int getJour() {
		return jour;
	}

	
	/**
	 * Associe a jour la valeur en parametre
	 * 
	 * @param jour
	 * 		Le jour de la seance
	 * 
	 * @see Seance#jour
	 */
	public void setJour(int jour) {
		System.out.print("le jour que vous voulez saisir n'est pas compris entre 1 et 7, ré-essayer : ");
		while (!in.hasNextInt()) {
			System.out.print("le jour que vous voulez saisir n'est pas compris entre 1 et 7, ré-essayer : ");
			in.next();
		}
		jour = in.nextInt();
		while (jour <= 0 || jour > 7) {
			System.out.print("le jour que vous voulez saisir n'est pas compris entre 1 et 7, ré-essayer : ");
			while (!in.hasNextInt()) {
				System.out.print("le jour que vous voulez saisir n'est pas compris entre 1 et 7, ré-essayer : ");
				in.next();
			}
			jour = in.nextInt();
		}
		this.jour = jour;
	}

	
	/**
	 * Retourne l'horaire de la seance
	 * 
	 * @return l'horaire de la sance sous forme d'Heure
	 * 
	 * @see Seance#horaire
	 */
	public Heure getHoraire() {
		return horaire;
	}

	
	/**
	 * Associe a horaire l'Heure en parametre
	 * 
	 * @param horaire
	 * 		l'horaire de la seance
	 * 
	 * @see Seance#horaire
	 */
	public void setHoraire(Heure horaire) {
		this.horaire = horaire;
	}

	
	/**
	 * Retourne le nombre de places vendues a tarif normal
	 * 
	 * @return le nombre de places vendues a tarif normal sous forme d'entier
	 * 
	 * @see Seance#nbPlacesVenduesTn
	 */
	public int getNbPlacesVenduesTn() {
		return nbPlacesVenduesTn;
	}

	
	/**
	 * Affiche le jour et l'horaire du film
	 * 
	 * @return le jour et l'horaire du film sous forme de chaine de caractere
	 * 
	 * @see Seance#jour
	 * @see Seance#horaire
	 */
	public String toString() {
		if (jour == 1) {
			return ("lundi à " + this.horaire);
		}
		if (jour == 2) {
			return ("mardi à " + this.horaire);
		}
		if (jour == 3) {
			return ("mercredi à " + this.horaire);
		}
		if (jour == 4) {
			return ("jeudi à " + this.horaire);
		}
		if (jour == 5) {
			return ("vendredi à " + this.horaire);
		}
		if (jour == 6) {
			return ("samedi à " + this.horaire);
		}
		if (jour == 7) {
			return ("dimanche à " + this.horaire);
		}
		return " ";
	}

	
	/**
	 * Compare le jour de la seance au jour en parametre
	 * 
	 * @return le resulatat de la comparaison sous forme d'un entier positif, negatif ou nul
	 * 
	 * @see Seance#jour
	 * @see Seance#horaire
	 */
	public int compareTo(Seance a) {
		if (this.jour > a.jour) {
			return 1;
		}
		if (this.jour < a.jour) {
			return -1;
		}
		if (this.jour == a.jour) {
			if (this.horaire.compareTo(a.horaire) == 1) {
				return 1;
			}
			if (this.horaire.compareTo(a.horaire) == -1) {
				return -1;
			}
		}
		return 0;
	}
}
