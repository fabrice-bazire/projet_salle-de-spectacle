package projet;
import java.util.Scanner;

/**
 * 
 *<b>Salle est la classe représentant une salle de spectacle.</b>
 * <p>
 * Une salle est caractérisée par les informations suivantes :
 * <ul>
 * <li>Un nom nomSalle (String).</li>
 * <li>Une capacite (int).</li>
 * <li>Un tarif (double)</li>
 * </ul>
 * </p>
 * 
 * @see SalleTheatre
 * @see Salle Cinema
 * @see Comparable<Salle>
 * 
 */
public class Salle implements Comparable<Salle>{
	public static Scanner in = new Scanner (System.in);
	
	/**
	 * Le nom de la salle
	 * @see Salle#Salle()
	 * @see Salle#Salle(String, int, double)
	 * @see Salle#toString()
	 * @see Salle#compareTo(Salle)
	 */
	String nomSalle;
	/**
	 * La capacite de la salle
	 * @see Salle#Salle()
	 * @see Salle#Salle(String, int, double)
	 * @see Salle#toString()
	 */
	int capacite;
	/**
	 * Le tarif des places normales de la salle
	 * @see Salle#Salle()
	 * @see Salle#Salle(String, int, double)
	 * @see Salle#toString()
	 */
	double tarif;
	
	/**
	 * Constructeur vide de Salle
	 * @see Salle#nomSalle
	 * @see Salle#capacite
	 * @see Salle#tarif
	 */
	public Salle () {
		System.out.print("Veuillez entrer un nom de salle : ");
		this.nomSalle = in.nextLine();
		System.out.print("Veuillez entrer un nombre de places dans la salle " + this.nomSalle + " : ");
		while (!in.hasNextInt()) {
			System.out.print("Veuillez entrer un nombre de places dans la salle \" + this.nomSalle + \" : ");
			in.next();			
		}
		this.capacite = in.nextInt();
		System.out.print("Veuillez entrer un tarif pour une place dans la salle " + this.nomSalle + " : ");
		while (!in.hasNextDouble()) {
			System.out.print("Veuillez entrer un tarif pour une place dans la salle " + this.nomSalle + " : ");
			in.next();			
		}
		this.tarif = in.nextDouble();
	}
	
	/**
	 * Constructeur de Salle
	 * 
	 * @param nomSalle
	 * 		Le nom de la salle
	 * @param capacite
	 * 		La capacite de la salle
	 * @param tarif
	 * 		Le tarif des places dans la salle
	 * 
	 * @see Salle#nomSalle
	 * @see Salle#capacite
	 * @see Salle#tarif
	 */
	public Salle (String nomSalle, int capacite, double tarif) {
		this.nomSalle = nomSalle;
		this.capacite = capacite;
		this.tarif = tarif;
	}
	
	/**
	 * Permet l'affichage d'une description de la salle
	 * 
	 * @return la descriptiion de la salle sous forme d'une chaine de caractere
	 * 
	 * @see Salle#nomSalle
	 * @see Salle#capacite
	 * @see Salle#tarif
	 */
	public String toString () {
		return ("La " + this.nomSalle + " a une capacité de " + this.capacite + " places qui sont au tarif de " + this.tarif + "€ chacunes");
	}

	/**
	 * Compare le nom de la salle a au nom d'une salle placee en parametre
	 * 
	 * @return le resulatat de la comparaison sous forme d'un entier positif, negatif ou nul
	 * 
	 * @see Salle#nomSalle
	 */
	@Override
	public int compareTo(Salle a) {
		return (this.nomSalle.compareTo(a.nomSalle));
	}
}