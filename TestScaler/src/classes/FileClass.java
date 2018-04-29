package classes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;


public class FileClass {
	String dateFormat;
	String fileNameFormat;
	File saveLocation;
	File backupLocation;
	
	public FileClass() {
	}
	
	public String getDateFormat() {
		return dateFormat;
	}

	public String getFileNameFormat() {
		return fileNameFormat;
	}

	public File getSaveLocation() {
		return saveLocation;
	}

	public File getBackupLocation() {
		return backupLocation;
	}

	public void setDateFormat(String format) {
		dateFormat = format;
	}
	
	public void setFileNameFormat(String format) {
		fileNameFormat = format;
	}
	
	public void setSaveLocation(File saveLocation) {
		this.saveLocation = saveLocation;
	}

	public void setBackupLocation(File backupLocation) {
		this.backupLocation = backupLocation;
	}
	
	public JFileChooser selectFolder(String windowTitle) {
		/*
		 * 
		 * Fragment from http://www.rgagnon.com/javadetails/java-0370.html
		 * 
		 */
		JFileChooser chooser = new JFileChooser(); 
		chooser.setCurrentDirectory(new java.io.File("."));
		chooser.setDialogTitle(windowTitle);
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		chooser.showDialog(null, "Select");
		return chooser;
	}

	public String checkDateFormat(String format) {
		String copy = format;
		String[] arr = copy.split("[$%YMD_]", 0);
		for(int i = 0; i < arr.length; i++) {
			if(!arr[i].equals("")) {
				return "You used an invalid character, please only use the codes and _";
			}
		}
		copy = format;
		String year = "$YYYY%";
		String month = "$MM%";
		String date = "$DD%";
		if(copy.contains("$YYYY%")) {
			year = null;
		}
		if(copy.contains("$MM%")) {
			month = null;
		}
		if(copy.contains("$DD%")) {
			date = null;
		}
		if(year == null && month == null && date == null) {
			return "clear";
		} else {
			return ("You forgot to include a code, here are the ones that are not present: " + year + " " + month + " " + date);
		}
	}
	
	public String checkFileNameFormat(String format) {
		String copy = format;
		String[] arr = copy.split("[$%DFCNT-]", 0);
		for(int i = 0; i < arr.length; i++) {
			if(!arr[i].equals("")) {
				return "You used an invalid character, please only use the codes and -";
			}
		}
		copy = format;
		String date = "$DF%";
		String className = "$CN%";
		String test = "$TN%";
		if(copy.contains("$DF%")) {
			date = null;
		}
		if(copy.contains("$CN%")) {
			className = null;
		}
		if(copy.contains("$TN%")) {
			test = null;
		}
		if(date == null && className == null && test == null) {
			return "clear";
		} else {
			return ("You forgot to include a code, here are the ones that are not present: " + date + " " + className + " " + test);
		}
	}
	
	public void saveSettings(String dateFormat, String fileNameFormat, File saveLocation, File backupLocation) {
		String settings = "settings.ini";
		File settingsFile = new File(settings);
		try {
			FileWriter writer = new FileWriter(settingsFile);
			writer.write("Date format: " + dateFormat + "\n");
			writer.write("File format: " + fileNameFormat + "\n");
			writer.write("Save Location: " + saveLocation.getAbsolutePath() + "\n");
			writer.write("Backup Location: " + backupLocation.getAbsolutePath() + "\n");
			writer.close();
		} catch (IOException e) {
			try {
				settingsFile.createNewFile();
				saveSettings(dateFormat, fileNameFormat, saveLocation, backupLocation);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	
}
