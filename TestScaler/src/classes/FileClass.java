package classes;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFileChooser;

public class FileClass {
	String dateFormat;
	public FileClass() {
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
	
	public String fileLocation() {
		
		return null;
	}
	
	public void setDateFormat(String format) {
		dateFormat = format;
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
	
}
