package projet;
import java.util.Scanner;

/**
 * 
 *<b>PieceTheatre est la classe représentant une piece de theatre.</b>
 * <p>
 * Une piece de theatre est caractérisée par les informations suivantes :
 * <ul>
 * <li>Un metteur en scene (String).</li>
 * <li>Un nombre d'entractes (Heure).</li>
 * </ul>
 * </p>
 * 
 * @see Spectacle
 * 
 */
public class PieceTheatre extends Spectacle implements Comparable<PieceTheatre>{
	public static Scanner in = new Scanner (System.in);
	

	/**
	 * Le nom du metteur en scene
	 * @see PieceTheatre#PieceTheatre()
	 * @see PieceTheatre#PieceTheatre(String, String, String, int)
	 * @see PieceTheatre#toString()
	 */
	String metteurEnScene;
	/**
	 * Le nombre d'entractes
	 * @see PieceTheatre#PieceTheatre()
	 * @see PieceTheatre#PieceTheatre(String, String, String, int)
	 * @see PieceTheatre#toString()
	 */
	int nbEntractes; 

	/**
	 * Constructeur PieceTheatre vide
	 * @see PieceTheatre#metteurEnScene
	 * @see PieceTheatre#nbEntractes
	 */
	public PieceTheatre() {
		System.out.print("Quel est le titre de la pièce : ");
		this.titre = in.nextLine();
		System.out.print("Quels sont le ou les interpretes de la pièce : ");
		this.interpretes = in.nextLine();
		System.out.print("Quel est le metteur en scène de la pièce : ");
		this.metteurEnScene = in.nextLine();
		System.out.print("Combien y a t-il d'entractes : ");
		while(!in.hasNextInt()) {
			System.out.print("Combien y a t-il d'entractes : ");
			in.next();
		}
		this.nbEntractes = in.nextInt();
	}
	
	/**
	 * Constructeur PieceTheatre
	 * 
	 * @param titre
	 * 		Le titre de la piece
	 * @param interprete
	 * 		Les interpretes de la piece
	 * @param metteurEnScene
	 * 		Le metteur en scene de la piece
	 * @param nbEntractes
	 * 		Le nombre d'entractes de la piece
	 * 
	 * @see Spectacle#setTitre(String)*
	 * @see Spectacle#setInterprete(String)
	 * @see PieceTheatre#metteurEnScene
	 * @see PieceTheatre#nbEntractes
	 * 
	 */
	public PieceTheatre(String titre, String interprete, String metteurEnScene, int nbEntractes) {
		super();
		super.setTitre(titre);
		super.setInterprete(interprete);
		this.metteurEnScene = metteurEnScene;
		this.nbEntractes = nbEntractes;
	}
	
	/**
	 * Permet l'affichage d'une description de la piece
	 * 
	 * @return la description de la piece sous forme d'une chaine de caractere
	 * 
	 * @see Spectacle#toString()
	 * @see PieceTheatre#metteurEnScene
	 * @see PieceTheatre#nbEntractes
	 */
	public String toString() {
		return (super.toString() + ", est mise en scène par " + this.metteurEnScene + " et composée de " + this.nbEntractes + " entractes");
	}

	

	/**
	 * Compare le titre de la piece de theatre au titre de la piece en parametre
	 * 
	 * @return le resulatat de la comparaison sous forme d'un entier positif, negatif ou nul
	 * 
	 * @see Spectacle#titre
	 */
	@Override
	public int compareTo(PieceTheatre a) {
		return this.titre.compareTo(a.titre);
	}
}
