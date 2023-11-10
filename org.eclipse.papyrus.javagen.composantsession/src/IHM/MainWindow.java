
package IHM;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

import org.json.JSONObject;

import Groupe.GroupeImplementation;

public class MainWindow {

	public JFrame frame;
	/**
	 * Create the application.
	 */
	public MainWindow(GroupeImplementation sess) {

		initialize(sess);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(GroupeImplementation sess) {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 600);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JFormattedTextField prenom = new JFormattedTextField();
		prenom.setText("Prenom");
		prenom.setBounds(6, 6, 79, 26);
		frame.getContentPane().add(prenom);

		JFormattedTextField nom = new JFormattedTextField();
		nom.setText("Nom");
		nom.setBounds(85, 6, 79, 26);
		frame.getContentPane().add(nom);



		JFormattedTextField titre = new JFormattedTextField();
		titre.setText("titre");
		titre.setBounds(6, 34, 79, 26);
		frame.getContentPane().add(titre);

		JFormattedTextField fin = new JFormattedTextField();
		fin.setText("Fin");
		fin.setBounds(85, 34, 79, 26);
		frame.getContentPane().add(fin);

		JFormattedTextField jour = new JFormattedTextField();
		jour.setText("Jour");
		jour.setBounds(167, 34, 79, 26);
		frame.getContentPane().add(jour);



		JFormattedTextField code = new JFormattedTextField();
		code.setText("Code");
		code.setBounds(6, 63, 79, 26);
		frame.getContentPane().add(code);

		JFormattedTextField intitule = new JFormattedTextField();
		intitule.setText("Intitule");
		intitule.setBounds(85, 63, 79, 26);
		frame.getContentPane().add(intitule);

		JFormattedTextField td = new JFormattedTextField();
		td.setText("TD");
		td.setBounds(167, 63, 79, 26);
		frame.getContentPane().add(td);

		JFormattedTextField tp = new JFormattedTextField();
		tp.setText("TP");
		tp.setBounds(247, 63, 79, 26);
		frame.getContentPane().add(tp);

		JFormattedTextField cours = new JFormattedTextField();
		cours.setText("Cours");
		cours.setBounds(332, 63, 79, 26);
		frame.getContentPane().add(cours);

		JFormattedTextField valeur = new JFormattedTextField();
		valeur.setText("Valeur");
		valeur.setBounds(411, 63, 68, 26);
		frame.getContentPane().add(valeur);

		JFormattedTextField idEleve = new JFormattedTextField();
		idEleve.setText("ID");
		idEleve.setBounds(6, 186, 295, 26);
		frame.getContentPane().add(idEleve);


		JFormattedTextField idSujet = new JFormattedTextField();
		idSujet.setText("ID");
		idSujet.setBounds(6, 214, 295, 26);
		frame.getContentPane().add(idSujet);


		JFormattedTextField idUE = new JFormattedTextField();
		idUE.setText("ID");
		idUE.setBounds(6, 243, 295, 26);
		frame.getContentPane().add(idUE);



		JFormattedTextField iEleve = new JFormattedTextField();
		iEleve.setText("ID Eleve");
		iEleve.setBounds(6, 90, 79, 26);
		frame.getContentPane().add(iEleve);

		JFormattedTextField iSujet = new JFormattedTextField();
		iSujet.setText("ID Sujet");
		iSujet.setBounds(85, 90, 79, 26);
		frame.getContentPane().add(iSujet);

		JFormattedTextField iEU = new JFormattedTextField();
		iEU.setText("ID UE");
		iEU.setBounds(167, 90, 79, 26);
		frame.getContentPane().add(iEU);


		JFormattedTextField idGroupe = new JFormattedTextField();
		idGroupe.setText("ID");
		idGroupe.setBounds(6, 157, 295, 26);
		frame.getContentPane().add(idGroupe);

		JTextArea console = new JTextArea();
		console.setEditable(false);
		console.setBounds(6, 342, 588, 230);
		frame.getContentPane().add(console);

		JButton dGroupe = new JButton("Supprimer groupe");
		dGroupe.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = idGroupe.getText();
				JSONObject obj = new JSONObject();
				obj.put("UUID", id);
				console.setText("");
				JSONObject objRet = new JSONObject(sess.deleteGroupe(obj.toString()));
				if (objRet.getString("result").equals("done"))
					console.append("groupe supprimée, id :"+ id);
				else
					console.append("Erreur suppression vérfier l'exitence de l'id");
				

			}
		});
		dGroupe.setBounds(436, 157, 158, 29);
		frame.getContentPane().add(dGroupe);

		JButton vGroupe = new JButton("Afficher groupe");
		vGroupe.setBounds(303, 157, 135, 29);
		frame.getContentPane().add(vGroupe);

		JButton cGroupe = new JButton("Creer groupe");
		cGroupe.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String isu = iSujet.getText();
				String iel = iEleve.getText();
				String iue = iEU.getText();
				String id = UUID.randomUUID().toString();
				JSONObject obj = new JSONObject();
				obj.put("id", id);
				obj.put("ueID", iue);
				obj.put("eleveID", iel);
				obj.put("sujetID", isu);
				console.setText("");
				JSONObject objRet = new JSONObject(sess.createEleve(obj.toString()));
				console.append("Groupe cree, id :"+ objRet.getString("id"));
			}
		});
		cGroupe.setBounds(477, 90, 117, 29);
		frame.getContentPane().add(cGroupe);

		JButton dUE = new JButton("Supprimer UE");
		dUE.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = idUE.getText();
				JSONObject obj = new JSONObject();
				obj.put("UUID", id);
				console.setText("");
				JSONObject objRet = new JSONObject(sess.deleteEU(obj.toString()));
				if (objRet.getString("result").equals("done"))
					console.append("UE supprimé, id :"+ id);
				else
					console.append("Erreur suppression vérfier l'exitence de l'id");
			}
		});
		dUE.setBounds(436, 243, 158, 29);
		frame.getContentPane().add(dUE);

		JButton vEleve = new JButton("Afficher �leve");
		vEleve.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JSONObject req = new JSONObject();
				req.put("id", idEleve.getText());
				String rep = sess.getEleve(req.toString());
				if (!rep.equals("erreur"))
				{
					JSONObject view  = new JSONObject(rep);
					String id = view.getString("id");
					String prenom = view.getString("prenom");
					String nom = view.getString("nom");
					console.setText("");
					console.append("ID;Prenom;Nom \n");
					console.append(""+id+" ; "+ prenom +" ; "+ nom +"\n");
				}
				else
				{
					console.setText("");
					console.append("Erreur affichage vérfier l'exitence de l'id\n");
				}


			}
		});
		vEleve.setBounds(303, 186, 135, 29);
		frame.getContentPane().add(vEleve);

		JButton vSujet = new JButton("Afficher sujet");
		vSujet.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JSONObject req = new JSONObject();
				req.put("id", idSujet.getText());
				String rep = sess.getSujet(req.toString());
				if (!rep.equals("erreur"))
				{
					JSONObject view  = new JSONObject(rep);
					String id = view.getString("id");
					String titre = view.getString("titre");
					LocalTime fin = LocalTime.parse(view.getString("fin"));
					LocalDate jour = LocalDate.parse(view.getString("jour"));
					console.setText("");
					console.append("ID;titre;fin;jour \n");
					console.append(""+id+" ; "+ titre +" ; "+ fin +" ; "+jour +"\n");
				}
				else
				{
					console.setText("");
					console.append("Erreur affichage vérfier l'exitence de l'id\n");
				}

			}
		});
		vSujet.setBounds(303, 214, 135, 29);
		frame.getContentPane().add(vSujet);

		JButton vUE = new JButton("Afficher UE");
		vUE.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JSONObject req = new JSONObject();
				req.put("id", idUE.getText());
				String rep = sess.getUE(req.toString());
				if (!rep.equals("erreur"))
				{
					JSONObject view  = new JSONObject(rep);
					String id = view.getString("id");
					String code = view.getString("code");
					String intitule = view.getString("intitule");
					float cours = Float.parseFloat(view.getString("cours"));
					float td = Float.parseFloat(view.getString("td"));
					float tp = Float.parseFloat(view.getString("tp"));
					float valeur = Float.parseFloat(view.getString("valeur"));
					console.setText("");
					console.append("ID;code;intitule;cours;td;tp;valeur \n");
					console.append(""+id+" ; "+ code +" ; "+ intitule +" ; "+cours +" ; "+td+ " ; "+ tp +" ; "+valeur+"\n");
				}
				else
				{
					console.setText("");
					console.append("Erreur affichage vérfier l'exitence de l'id\n");
				}
			}
		});
		vUE.setBounds(303, 243, 135, 29);
		frame.getContentPane().add(vUE);

		JButton dSujet = new JButton("Supprimer sujet");
		dSujet.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = idSujet.getText();
				JSONObject obj = new JSONObject();
				obj.put("UUID", id);
				console.setText("");
				JSONObject objRet = new JSONObject(sess.deleteSujet(obj.toString()));
				if (objRet.getString("result").equals("done"))
					console.append("Sujet supprimé, id :"+ id);
				else
					console.append("Erreur suppression vérfier l'exitence de l'id");
				//TODO: This needs testing (not tested)
			}
		});
		dSujet.setBounds(436, 214, 158, 29);
		frame.getContentPane().add(dSujet);

		JButton dEleve = new JButton("Supprimer �leve");
		dEleve.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = idEleve.getText();
				JSONObject obj = new JSONObject();
				obj.put("UUID", id);
				console.setText("");
				JSONObject objRet = new JSONObject(sess.deleteEleve(obj.toString()));
				if (objRet.getString("result").equals("done"))
					console.append("Eleve supprimé, id :"+ id);
				else
					console.append("Erreur suppression vérfier l'exitence de l'id");
			}
		});
		dEleve.setBounds(436, 186, 158, 29);
		frame.getContentPane().add(dEleve);

		JButton cUE = new JButton("Creer UE");
		cUE.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String co = code.getText();
				String inti = intitule.getText();
				String cou = cours.getText();
				String TD = td.getText();
				String TP = tp.getText();
				String val = valeur.getText();
				String id = UUID.randomUUID().toString();
				JSONObject obj = new JSONObject();
				obj.put("id", id);
				obj.put("code", co);
				obj.put("intitule", inti);
				obj.put("cours", cou);
				obj.put("td", TD);
				obj.put("tp", TP);
				obj.put("valeur", val);
				console.setText("");
				JSONObject objRet = new JSONObject(sess.createEU(obj.toString()));
				console.append("UE cree, id :"+ objRet.getString("id"));

			}
		});
		cUE.setBounds(477, 63, 117, 29);
		frame.getContentPane().add(cUE);

		JButton cSujet = new JButton("Creer Sujet");
		cSujet.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = UUID.randomUUID().toString();
				String tit = titre.getText();
				String fi = fin.getText();
				String jo = jour.getText();
				JSONObject obj = new JSONObject();
				obj.put("id", id);
				obj.put("titre", tit);
				obj.put("fin", fi);
				obj.put("jour", jo);
				//TODO: Test this shit !
				console.setText("");
				JSONObject objRet = new JSONObject(sess.createSujet(obj.toString()));
				console.append("Sujet cree, id :"+ objRet.getString("id"));

			}
		});
		cSujet.setBounds(477, 34, 117, 29);
		frame.getContentPane().add(cSujet);

		JButton cEleve = new JButton("Creer Eleve");
		cEleve.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String p = prenom.getText();
				String n = nom.getText();
				String id = UUID.randomUUID().toString();
				JSONObject obj = new JSONObject();
				obj.put("id", id);
				obj.put("prenom", p);
				obj.put("nom", n);
				console.setText("");
				JSONObject objRet = new JSONObject(sess.createEleve(obj.toString()));
				console.append("Eleve cree, id :"+ objRet.getString("id"));

			}
		});
		cEleve.setBounds(477, 6, 117, 29);
		frame.getContentPane().add(cEleve);

		JButton lGroupe = new JButton("Lister groupes");
		lGroupe.setBounds(6, 281, 127, 29);
		frame.getContentPane().add(lGroupe);

		JButton lEleve = new JButton("Lister �leves");
		lEleve.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String ls = sess.listEleve();
				JSONObject obj = new JSONObject(ls);
				console.setText("");
				console.append("ID;Prenom;Nom \n");
				console.append(obj.getString("response"));

			}
		});
		lEleve.setBounds(162, 281, 127, 29);
		frame.getContentPane().add(lEleve);

		JButton lSujet = new JButton("Lister sujet");
		lSujet.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String ls = sess.listSujet();
				JSONObject obj = new JSONObject(ls);
				console.setText("");
				console.append("ID;titre;fin;jour \n");
				console.append(obj.getString("response"));
			}
		});
		lSujet.setBounds(317, 281, 127, 29);
		frame.getContentPane().add(lSujet);

		JButton lUE = new JButton("Lister UE");
		lUE.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String ls = sess.listEU();
				JSONObject obj = new JSONObject(ls);
				console.setText("");
				console.append("ID;code;intitule;cours;td;tp;valeur \n");
				console.append(obj.getString("response"));
			}
		});
		lUE.setBounds(467, 281, 127, 29);
		frame.getContentPane().add(lUE);


	}
}
