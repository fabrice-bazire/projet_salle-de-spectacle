package projet;
import java.util.Scanner;

/**
 * 
 *<b>Film est la classe représentant un  Film.</b>
 * <p>
 * Un Film est caractérisé par les informations suivantes :
 * <ul>
 * <li>Un realisateur (String).</li>
 * <li>Une duree (Heure).</li>
 * </ul>
 * </p>
 * 
 * @see Spectacle
 * 
 */
public class Film extends Spectacle implements Comparable <Film>{
	public static Scanner in = new Scanner (System.in);
	
	/**
	 * Le nom du realisateur
	 * @see Film#Film()
	 * @see Film#Film(String, String, String, Heure)
	 * @see Film#toString()
	 */
	String realisateur;
	/**
	 * La duree du film
	 * @see Film#Film()
	 * @see Film#Film(String, String, String, Heure)
	 * @see Film#toString()
	 */
	Heure duree;
	
	/**
	 * Constructeur de Film
	 * @see Film#realisateur
	 * @see Film#duree
	 * @see Spectacle#interpretes
	 * @see Spectacle#titre
	 */
	public Film() {
		System.out.print("Quel est le titre du film : ");
		this.titre = in.next();
		System.out.print("Quels sont le ou les interpretes du film : ");
		this.interpretes = in.next();
		System.out.print("Quel est le réalisateur du film : ");
		this.realisateur = in.next();
		System.out.println("Quelle est la duréedu film : ");
		System.out.print("Heure(s) : ");
		while (!in.hasNextInt()) {
			System.out.print("Heure(s) : ");
			in.next();			
		}
		int heure = in.nextInt();
		while (heure <=0 || heure >=24) {
			System.out.print("Heure(s) : ");
			while (!in.hasNextInt()) {
				System.out.print("Heure(s) : ");
				in.next();			
			}
			heure = in.nextInt();
		}
		System.out.print("Minutes : ");
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
		this.duree = new Heure(heure,min);
	}
	
	/**
	 * Constructeur de Film
	 * 
	 * @param titre
	 * 		Le titre du film
	 * @param interprete
	 * 		Les interpretes du film
	 * @param realisateur
	 * 		Le realisateur du film
	 * @param duree
	 * 		La duree du film
	 * 
	 * @see Spectacle#setTitre(String)
	 * @see Spectacle#setInterprete(String)
	 * @see Film#realisateur
	 * @see Film#duree
	 * 
	 */
	public Film(String titre, String interprete, String realisateur, Heure duree) {
		super();
		super.setTitre(titre);
		super.setInterprete(interprete);
		this.realisateur = realisateur;
		this.duree = duree;
	}
	
	/**
	 * Permet l'affichage d'une description du film
	 * 
	 * @return la description du film sous forme de chaine de caractere
	 * 
	 * @see Spectacle#toString()
	 * @see Film#realisateur
	 * @see Film#duree
	 */
	public String toString() {
		return (super.toString() + ", réalisé par " + this.realisateur + " et dure " + this.duree);
	}

	
	/**
	 * Compare le titre du film au titre du film en parametre
	 * 
	 * @return le resulatat de la comparaison sous forme d'un entier positif, negatif ou nul
	 * 
	 * @see Spectacle#titre
	 */
	@Override
	public int compareTo(Film f) {
		return this.titre.compareTo(f.titre);
	}
}
