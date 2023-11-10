// --------------------------------------------------------
// Code revised for Eleve management
// --------------------------------------------------------

package Groupe;

import java.util.List;
import java.util.HashMap;

/************************************************************/
/**
 * 
 */
public class Personne extends SqlUtils {
	/**
	 * 
	 */
	private String id;
	/**
	 * 
	 */
	private String prenom;
	/**
	 * 
	 */
	private String nom;
	/**
	 * 
	 */
	private String mail;

	/**
	 * Constructeur pour un élève.
	 * 
	 * @param id L'identifiant unique de l'élève
	 * @param prenom Le prénom de l'élève
	 * @param nom Le nom de famille de l'élève
	 * @param mail L'adresse email de l'élève
	 */
	public Personne(String id, String prenom, String nom, String mail) {
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.mail = mail;
	}
	
	/**
	 * Enregistre un nouvel élève dans la base de données.
	 */
	public void save() {
		this.connect();
		this.requestUpdate(String.format("INSERT INTO ELEVE VALUES('%s','%s','%s','%s')",
				this.id, this.prenom, this.nom, this.mail));
		this.disconnect();
	}
	
	/**
	 * Met à jour les informations de l'élève dans la base de données.
	 */
	public void update() {
		this.connect();
		this.requestUpdate(String.format("UPDATE ELEVE SET prenom='%s',nom='%s',mail='%s' WHERE id='%s'",
				this.prenom, this.nom, this.mail, this.id));
		this.disconnect();
	}
	
	// Vous pouvez définir des méthodes supplémentaires comme delete(), getById(), getAll(), getAllByFilter() selon vos besoins.
	
	// Getters et Setters pour chaque propriété peuvent également être ajoutés ici.
};
