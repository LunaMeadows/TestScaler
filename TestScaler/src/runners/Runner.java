package runners;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import classes.UpdateChecker;
import windows.MainWindow;
import windows.SetupWindow;

/**
 * @author Derrick Bush
 * 
 * @version 0.2
 *
 */
public class Runner {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception {
		File file = new File("settings.ini");
		UpdateChecker.updateCheckStandalone();
		if(!file.exists()) {
			SetupWindow setup = new SetupWindow();
			setup.activate();
			while(!file.exists()) {
			}
		}
		MainWindow main = new MainWindow();
		main.activate();
	}

}
