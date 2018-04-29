package runners;

import java.awt.Component;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.swing.JFileChooser;

import windows.SetupWindow;

/**
 * @author Derrick Bush
 * 
 * @version 1.0
 *
 */
public class Runner {
	
	public static void main(String[] args) {
		JFileChooser chooser = new JFileChooser();
		int hold = chooser.showOpenDialog(null);
		String settings = "Settings.ini";
		System.out.println((chooser.getSelectedFile()).getPath());
		try {
			FileReader checker = new FileReader(settings);
		} catch (FileNotFoundException e) {
			//Create Settings.ini file and open First Run window
		}
	}
	
}
