package projet;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * 
 *<b>SalleTheatre est la classe représentant une salle de theatre.</b>
 * <p>
 * Une salle de theatre est caractérisée par les informations suivantes :
 * <ul>
 * <li>Un nombre de fauteuils nbFauteuils (int).</li>
 * <li>Un prix des fauteuils prixFauteuils (double).</li>
 * <li>Une capacite capaciteSalleTheatre (int)</li>
 * </ul>
 * </p>
 * 
 * @see Salle
 * 
 */
public class SalleTheatre extends Salle{
	
	/**
	 * Le nombre de fauteuils dans la salle
	 * @see SalleTheatre#SalleTheatre()
	 * @see SalleTheatre#SalleTheatre(String, int, double, int, double)
	 * @see SalleTheatre#toString()
	 */
	int nbFauteuils;
	/**
	 * Le prix des fauteuils dans la salle de theatre
	 * @see SalleTheatre#SalleTheatre()
	 * @see SalleTheatre#SalleTheatre(String, int, double, int, double)
	 * @see SalleTheatre#toString()
	 */
	double prixFauteuil;
	/**
	 * Le prix des fauteuils dans la salle de theatre
	 * @see SalleTheatre#SalleTheatre()
	 * @see SalleTheatre#SalleTheatre(String, int, double, int, double)
	 * @see SalleTheatre#toString()
	 */
/**
	 * La capacite de la salle
	 * @see SalleTheatre#SalleTheatre()
	 * @see SalleTheatre#SalleTheatre(String, int, double, int, double)
	 * @see SalleTheatre#toString()
	 */
	int capaciteSalleTheatre;
	
	/**
	 * Constructeur vide de SalleTheatre
	 * @see SalleTheatre#nbFauteuils
	 * @see SalleTheatre#prixFauteuil
	 */
	public SalleTheatre () {
		super();
		System.out.print("Veuillez entrer un nombre de fauteuils dans la salle de théâtre " + this.nomSalle + " : ");
		while(!in.hasNextInt()) {
			System.out.print("Veuillez entrer un nombre de fauteuils dans la salle de théâtre " + this.nomSalle + " : ");
			in.next();
		}
		this.nbFauteuils = in.nextInt();
		while(this.nbFauteuils > this.capacite) {
			System.out.print("Veuillez entrer un nombre de fauteuils dans la salle de théâtre " + this.nomSalle + " : ");
			while(!in.hasNextInt()) {
				System.out.print("Veuillez entrer un nombre de fauteuils dans la salle de théâtre " + this.nomSalle + " : ");
				in.next();
			}
			this.nbFauteuils = in.nextInt();
		}
		System.out.print("Veuillez entrer un prix pour une place en fauteuil : ");
		while(!in.hasNextDouble()) {
			System.out.print("Veuillez entrer un prix pour une place en fauteuil : ");
			in.next();
		}
		this.prixFauteuil = in.nextDouble();
		this.capaciteSalleTheatre = this.capacite + this.nbFauteuils;
	}
	
	/**
	 * Constructeur de SalleTheatre
	 * 
	 * @param nomSalle
	 * 		Le nom de la salle de theatre
	 * @param capacite
	 * 		La capacite de la salle de theatre
	 * @param tarif
	 * 		Le tarif des places dans cette salle de theatre
	 * @param nbFauteuils
	 * 		Le nombre de fauteuils dans cette salle de theatre
	 * @param prixFauteuil
	 * 		Le tarif pour les fauteuils dans cette salle de theatre
	 * 
	 * @see SalleTheatre#nbFauteuils
	 * @see SalleTheatre#prixFauteuil
	 */
	public SalleTheatre (String nomSalle, int capacite, double tarif, int nbFauteuils, double prixFauteuil) {
		super(nomSalle, capacite, tarif);
		this.nbFauteuils = nbFauteuils;
		this.prixFauteuil = prixFauteuil;
	}
	
	/**
	 * Permet l'affichage d'une description de la salle de theatre
	 * 
	 * @return la description de la salle sous forme d'une chaine de caractere
	 * 
	 * @see Salle#toString()
	 * @see SalleTheatre#nbFauteuils
	 * @see SalleTheatre#prixFauteuil
	 */
	public String toString() {
		return (super.toString() + ", elle comporte aussi " + this.nbFauteuils + " fauteuils valant " + this.prixFauteuil + "€ chacuns");
	}
}
