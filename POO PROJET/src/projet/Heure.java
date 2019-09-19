package projet;


/**
 * 
 *<b>Heure est la classe représentant un horaire.</b>
 * <p>
 * Une Heure est caractérisée par les informations suivantes :
 * <ul>
 * <li>Des minutes (int).</li>
 * </ul>
 * </p>
 * 
 *@see Comparable
 * 
 */
public class Heure implements Comparable<Heure>{
	
	
	/**
	 * Les minutes
	 * 
	 * @see Heure#Heure(int, int)
	 * @see Heure#getMinutes()
	 * @see Heure#getHeures()
	 */
	int minutes;

	
	/**
	 * Constructeur de Heure qui met sous forme de minutes l'heure donnee sous forme d'heures+minutes
	 * 
	 * @param heures
	 * 		Les heures
	 * @param minutes
	 * 		Les minutes
	 * 
	 * @see Heure#minutes
	 */
	public Heure(int heures, int minutes) {
		this.minutes = ((minutes + (heures * 60)));
	}
	
	
	/**
	 * Retourne le nombre de minutes pour l'heure sous forme heures+minutes
	 * 
	 * @return le nombre de minutes sous forme d'entier
	 * 
	 * @see Heure#minutes
	 */
	public int getMinutes() {
		return (minutes%60);
	}
	
	
	/**
	 * Retourne le nombre d'heures pour l'heure sous forme heures+minutes
	 * 
	 * @return le nombre d'heures sous forme d'entier
	 * 
	 * @see Heure#minutes
	 */
	public int getHeures() {
		return (minutes/60);
	}
	
	
	/**
	 * Retourne l'heure sous forme heures+minutes
	 * 
	 * @return l'heure sous forme d'une chaine de caracteres
	 * 
	 * @see Heure#getHeures()
	 * @see Heure#getMinutes()
	 */
	public String toString () {
		if (getMinutes() == 0) {
			return (this.getHeures() + "h");
		}else {
			return (this.getHeures() + "h" + this.getMinutes() + "min");
		}
	}

	
	/**
	 * Compare deux objets Heure
	 * 
	 * @return le resultat de la comparaison sous forme d'entier positif, negatif ou nul
	 * 
	 * @see Heure#getHeures()
	 * @see Heure#getMinutes()
	 */
	@Override
	public int compareTo(Heure o) {//negatif si this est plus petit
		if (this.getHeures() > o.getHeures()) {
			return 1;
		}
		if (this.getHeures() < o.getHeures()) {
			return -1;
		}
		if (this.getHeures() == o.getHeures()) {
			if (this.getMinutes() > o.getMinutes()) {
				return 1;
			}
			if (this.getMinutes() < o.getMinutes()) {
				return -1;
			}
		}
		return 0;
	}
}
