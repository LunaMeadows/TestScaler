package runners;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import classes.UpdateChecker;
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
		/*
		 * JFileChooser chooser = new JFileChooser(); int hold =
		 * chooser.showOpenDialog(null);
		 */
		String settings = "settings.ini";
		File file = new File(settings);
		// System.out.println((chooser.getSelectedFile()).getPath());
		UpdateChecker.sendGet();
		try {
			@SuppressWarnings("resource")
			FileReader checker = new FileReader(file);
		} catch (FileNotFoundException e) {
			SetupWindow setup = new SetupWindow();
			setup.activate();
		}
	}

}
