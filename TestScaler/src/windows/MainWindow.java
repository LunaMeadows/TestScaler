package windows;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainWindow {

	private JFrame MainWindow;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.MainWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}
	
	/**
	 * Activates main window.
	 */
	public void activate() {
		initialize();
		MainWindow.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		MainWindow = new JFrame();
		MainWindow.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				/*int confirmation = JOptionPane.showConfirmDialog(null, "This is a required part of setup, closing now can cause many problems and even make the program not work at all. Are you sure you want to close? Doing so will stop the program.");
				if(confirmation == JOptionPane.YES_OPTION) {
					System.exit(0);
				} else {
					
				}*/
				System.exit(0);
			}
		});
		MainWindow.setTitle("Main Window");
		MainWindow.setResizable(false);
		MainWindow.setBounds(100, 100, 460, 140);
		MainWindow.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		MainWindow.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		Dimension size = new Dimension();
		size.setSize(MainWindow.getWidth(), 65);
		tabbedPane.setPreferredSize(size);
		MainWindow.getContentPane().add(tabbedPane);
		
		JPanel pClass = new JPanel();
		tabbedPane.addTab("New tab", null, pClass, null);
		pClass.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewClass = new JButton("New Class");
		pClass.add(btnNewClass);
		
		JButton btnEditClass = new JButton("Edit Class");
		pClass.add(btnEditClass);
		
		JButton btnViewClass = new JButton("View Classes");
		pClass.add(btnViewClass);
		
		JButton btnRemoveClass = new JButton("Remove Class");
		pClass.add(btnRemoveClass);
		
		JPanel pTest = new JPanel();
		tabbedPane.addTab("New tab", null, pTest, null);
		pTest.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewTest = new JButton("New Test");
		pTest.add(btnNewTest);
		
		JButton btnEditTest = new JButton("Edit Test");
		pTest.add(btnEditTest);
		
		JButton btnViewTest = new JButton("View Tests");
		pTest.add(btnViewTest);
		
		JButton btnRemoveTest = new JButton("Remove Tests");
		pTest.add(btnRemoveTest);
		
		JButton btnBackup = new JButton("Backup");
		MainWindow.getContentPane().add(btnBackup);
		
		JButton btnDone = new JButton("Done");
		MainWindow.getContentPane().add(btnDone);
		
		JButton btnSettings = new JButton("Settings");
		btnSettings.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				SettingsWindow settings = new SettingsWindow();
				settings.activate();
			}
		});
		MainWindow.getContentPane().add(btnSettings);
		
		JButton btnUpdate = new JButton("Update");
		MainWindow.getContentPane().add(btnUpdate);
	}

}
