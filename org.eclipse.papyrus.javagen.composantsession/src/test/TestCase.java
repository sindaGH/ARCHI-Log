package test;

import Groupe.Eleve;
import Groupe.Sujet;
import Groupe.GroupeImplementation;
import Groupe.UniteEnseignement;

public class TestCase {
	public static void main(String[] args) throws ClassNotFoundException {
		GroupeImplementation si = new GroupeImplementation();
		si.initDatabase();
		System.out.println(Eleve.getAll());
		System.out.println(Sujet.getAll());
		System.out.println(UniteEnseignement.getAll());
		String EU = "{ \"code\":\"1243\",\"intitule\":\"test\",\"cours\":\"1.5\",\"tp\":\"1.5\",\"td\":\"1.5\",\"valeur\":\"1.5\" }";
		String resEu = si.createEU(EU);
		System.out.println(resEu);

		String sujet = "{\"debut\":\"10:20\",\"fin\":\"10:21\",\"jour\":\"2016-10-08\"}";
		String resCr = si.createSujet(sujet);
		System.out.println(resCr);

		String eleve = "{ \"prenom\":\"1\",\"nom\":\"INFO\"}";
		String resCl = si.createEleve(eleve);
		System.out.println(resCl);

		String Groupe = "{ " + resEu.replace("id", "UE").substring(1, resEu.length() - 1) + ","
				+ resCr.replace("id", "sujet").substring(1, resCr.length() + 4) + ","
				+ resCl.replace("id", "eleve").substring(1, resCl.length() + 3) + "}";

		String crSres = si.createGroupe(Groupe);
		
		System.out.println(si.changeSujetGroupe(crSres));
		System.out.println(si.createGroupeSujet(crSres));

		String dlSres = si.createGroupe(Groupe);
		System.out.println(dlSres);

		System.out.println(si.deleteEU(resEu.replace("id", "UUID")));

		System.out.println(si.deleteSujet(resCr.replace("id", "UUID")));

		System.out.println(si.deleteEleve(resCl.replace("id", "UUID")));
		
	}
}
