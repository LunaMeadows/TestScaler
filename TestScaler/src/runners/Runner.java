package runners;

import java.io.FileNotFoundException;
import java.io.FileReader;

import classes.UpdateChecker;
import windows.SetupWindow;

/**
 * @author Derrick Bush
 * 
 * @version 0.1
 *
 */
public class Runner{

	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception {
		/*
		 * JFileChooser chooser = new JFileChooser(); int hold =
		 * chooser.showOpenDialog(null);
		 */
		if (UpdateChecker.sendGet() == -1) {
			// Run updater code
			System.out.println("You need to update");
		} else {
			String settings = "Settings.ini";
			// System.out.println((chooser.getSelectedFile()).getPath());
			try {
				@SuppressWarnings("resource")
				FileReader checker = new FileReader(settings);
			} catch (FileNotFoundException e) {
				SetupWindow setup = new SetupWindow();
				setup.activate();
			}
		}
	}

}
