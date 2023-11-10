package app;
import java.awt.EventQueue;

import IHM.MainWindow;
import Groupe.GroupeImplementation;
public class Controller {


	
		
public static void main(String[] args) {
	
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				GroupeImplementation sess = new GroupeImplementation();
				sess.initDatabase();
				MainWindow window = new MainWindow(sess);
				window.frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
}
		

	
}
