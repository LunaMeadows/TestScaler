package runners;

import java.io.File;

import classes.UpdateChecker;
import mainWindows.MainWindow;
import mainWindows.SetupWindow;

/**
 * @author Derrick Bush
 * 
 * @version 0.2
 *
 */
public class Runner {

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
