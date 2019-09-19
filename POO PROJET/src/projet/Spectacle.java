package projet;
import java.util.Scanner;

/**
 * 
 *<b>Spectacle est la classe représentant un  Spectacle.</b>
 * <p>
 * Un Spectable est caractérisé par les informations suivantes :
 * <ul>
 * <li>Un titre (String), modifiable.</li>
 * <li>Des interpretes (String), modifiables.</li>
 * </ul>
 * </p>
 * 
 * @see Film
 * @see PieceTheatre
  */
public abstract class Spectacle {
	public static Scanner in = new Scanner (System.in);
	
	/**
	 * Le titre du spectacle (String), modifiable.
	 *  @see Spectacle#Spectacle()
	 *  @see Spectacle#Spectacle(String titre, String interprete)
	 *  @see setTitre
	 */
	String titre;
	/**
	 * Les interpretes du spectacle (String), modifiable
	 * @see Spectacle#Spectacle
	 * @see setInterprete
	 */
	String interpretes;
	
	
	/**
	 * Constructeur Spectacle
	 * 
	 * @param titre 
	 * 		Le titre du spectacle
	 * @param interprete
	 * 		Les interpretes du spectacle
	 * 
	 * @see Spectacle#titre
	 * @see Spectacle#interprete
	 */
	public Spectacle(String titre, String interprete) {
		this.titre = titre;
		this.interpretes = interprete;
	}
	
	/**
	 * Constructeur Spectacle vide
	 * 
	 * @see Spectacle#titre
	 * @see Spectacle#interprete
	 */
	public Spectacle() {
		//System.out.print("Quel est le titre du film : ");
		this.titre = " ";
		//System.out.print("Quels sont le ou les interpretes du film : ");
		this.interpretes = " ";
	}
	
	/**
	 * Met a jour le titre du spectacle
	 * 
	 * @param titre
	 * 		Le nouveau titre su spectacle
	 * 
	 * @see Spectacle#titre
	 */
	public void setTitre (String titre) {
		this.titre = titre;
	}
	
	/**
	 * Met a jour les interpretes du spectacle
	 * 
	 * @param interprete
	 * 		Les nouveaux interpretes
	 * 
	 * @see Spectacle#interprete
	 */
	public void setInterprete (String interprete) {
		this.interpretes = interprete;
	}
	
	/**
	 * Permet l'affichage d'une description du spectacle
	 * 
	 * @return la description du spectacle sous forme d'une chaine de caractere
	 * 
	 * @see Spectacle#titre
	 * @see Spectacle#interprete
	 */
	public String toString() {
		return ("'" + this.titre + "' est interpreté par " + this.interpretes);
	}
}
