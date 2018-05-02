package mainWindows;

//Imports
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import classes.FileClass;
import java.awt.Color;
import java.awt.Component;
import javax.swing.UIManager;
import javax.swing.border.Border;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SetupWindow {
	// Instance Variables
	private JFrame frmSetupWindow;
	private JTextField tfFileNameFormat;
	private JLabel lblSaveLocation;
	private JTextField tfSaveLocation;
	private JLabel lblBackupLocation;
	private JTextField tfBackupLocation;
	private JLabel lblFormatCodes;
	private JLabel lblDateFormat;
	private JTextField tfDateFormat;
	private JLabel lblDateFormatCodes;
	private JButton btnResetDefault;
	private JButton btnDone;
	private JButton btnSaveLocation;
	private JButton btnBackupLocation;
	private Border defaultBorder;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetupWindow window = new SetupWindow();
					window.frmSetupWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SetupWindow() {
		initialize();
	}

	/**
	 * Activates the window.
	 */
	public void activate() {
		initialize();
		frmSetupWindow.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		FileClass file = new FileClass();
		frmSetupWindow = new JFrame();
		frmSetupWindow.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				int confirmation = JOptionPane.showConfirmDialog(null, "This is a required part of setup, closing now can cause many problems and even make the program not work at all. Are you sure you want to close? Doing so will stop the program.");
				if(confirmation == JOptionPane.YES_OPTION) {
					System.exit(0);
				} else {
					
				}
			}
		});
		frmSetupWindow.getContentPane().setBackground(SystemColor.menu);
		frmSetupWindow.setResizable(false);
		frmSetupWindow.setTitle("Setup Window");
		frmSetupWindow.setBounds(100, 100, 403, 229);
		frmSetupWindow.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		tfFileNameFormat = new JTextField();
		tfFileNameFormat.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfFileNameFormat.setBorder(defaultBorder);
			}
		});
		tfFileNameFormat.setToolTipText("Default: $DF%-$CN%-$TN%");
		tfFileNameFormat.setColumns(25);
		frmSetupWindow.getContentPane().setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		lblSaveLocation = new JLabel("Save Location:");
		lblSaveLocation.setHorizontalAlignment(SwingConstants.LEFT);
		frmSetupWindow.getContentPane().add(lblSaveLocation);
		tfSaveLocation = new JTextField();
		lblSaveLocation.setLabelFor(tfSaveLocation);
		tfSaveLocation.setToolTipText("If left empty, it will create the folders where you have saved the program.");
		tfSaveLocation.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				tfSaveLocation.setBorder(defaultBorder);
			}
		});
		tfSaveLocation.setColumns(20);
		frmSetupWindow.getContentPane().add(tfSaveLocation);
		defaultBorder = tfSaveLocation.getBorder();

		btnSaveLocation = new JButton("");
		btnSaveLocation.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				tfSaveLocation
						.setText(String.valueOf(file.selectFolder("Select save location").getSelectedFile().getPath()));
			}
		});
		btnSaveLocation.setIcon(
				new ImageIcon(SetupWindow.class.getResource("/javax/swing/plaf/metal/icons/ocean/directory.gif")));
		frmSetupWindow.getContentPane().add(btnSaveLocation);
		lblBackupLocation = new JLabel("Backup Location:");
		lblBackupLocation.setHorizontalAlignment(SwingConstants.LEFT);
		frmSetupWindow.getContentPane().add(lblBackupLocation);

		tfBackupLocation = new JTextField();
		lblBackupLocation.setLabelFor(tfBackupLocation);
		tfBackupLocation.setToolTipText("If left empty, it will create the folders where you have saved the program.");
		tfBackupLocation.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				tfBackupLocation.setBorder(defaultBorder);
			}
		});
		tfBackupLocation.setColumns(20);
		frmSetupWindow.getContentPane().add(tfBackupLocation);

		btnBackupLocation = new JButton("");
		btnBackupLocation.addMouseListener(new MouseAdapter() {
			// Button to open up file selection for backup location
			@Override
			public void mouseClicked(MouseEvent e) {
				tfBackupLocation.setText(
						String.valueOf(file.selectFolder("Select backup location").getSelectedFile().getPath()));
			}
		});
		btnBackupLocation.setIcon(
				new ImageIcon(SetupWindow.class.getResource("/javax/swing/plaf/metal/icons/ocean/directory.gif")));
		frmSetupWindow.getContentPane().add(btnBackupLocation);

		JLabel lblFileNameFormat = new JLabel("File Name Format:");
		lblFileNameFormat.setLabelFor(tfFileNameFormat);
		lblFileNameFormat.setHorizontalAlignment(SwingConstants.LEFT);
		frmSetupWindow.getContentPane().add(lblFileNameFormat);
		frmSetupWindow.getContentPane().add(tfFileNameFormat);

		lblFormatCodes = new JLabel();
		lblFormatCodes.setHorizontalAlignment(SwingConstants.CENTER);
		lblFormatCodes.setBackground(SystemColor.menu);
		lblFormatCodes.setFont(UIManager.getFont("Label.font"));
		lblFormatCodes.setText("Format Codes: $CN%-Class Name, $TN%- Test Name\r\n$DF%- Date");
		frmSetupWindow.getContentPane().add(lblFormatCodes);

		lblDateFormat = new JLabel("Date Format:");
		lblDateFormat.setHorizontalAlignment(SwingConstants.LEFT);
		frmSetupWindow.getContentPane().add(lblDateFormat);

		tfDateFormat = new JTextField();
		lblDateFormat.setLabelFor(tfDateFormat);
		tfDateFormat.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfDateFormat.setBorder(defaultBorder);
			}
		});
		tfDateFormat.setToolTipText("Default: $YYYY%_$MM%_$DD%");
		tfDateFormat.setColumns(25);
		frmSetupWindow.getContentPane().add(tfDateFormat);

		lblDateFormatCodes = new JLabel();
		lblDateFormatCodes.setHorizontalAlignment(SwingConstants.CENTER);
		lblDateFormatCodes.setText("Date Codes: $DD% - Day, $MM% - Month, $YYYY% - Year");
		lblDateFormatCodes.setFont(UIManager.getFont("Label.font"));
		lblDateFormatCodes.setBackground(SystemColor.menu);
		frmSetupWindow.getContentPane().add(lblDateFormatCodes);

		btnResetDefault = new JButton("Reset Default");
		btnResetDefault.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				tfDateFormat.setText("$YYYY%_$MM%_$DD%");
				tfFileNameFormat.setText("$DF%-$CN%-$TN%");
			}
		});
		frmSetupWindow.getContentPane().add(btnResetDefault);

		btnDone = new JButton("Done");
		btnDone.addMouseListener(new MouseAdapter() {
			// Button to confirm settings for first run
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean done = true;
				// Checks to make sure Date Format is valid
				if (tfDateFormat.getText().equals("")) {
					tfDateFormat.setText("$YYYY%_$MM%_$DD%");
				} else {
					String error = file.checkDateFormat(tfDateFormat.getText());
					if (!error.equals("clear")) {
						tfDateFormat.setBorder(BorderFactory.createLineBorder(Color.red));
						tfDateFormat.setToolTipText(error);
						done = false;
					}

				}

				// Checks to make sure File Name Format is valid
				if (tfFileNameFormat.getText().equals("")) {
					tfFileNameFormat.setText("$DF%-$CN%-$TN%");
				} else {
					String error = file.checkFileNameFormat(tfFileNameFormat.getText());
					if (!error.equals("clear")) {
						tfFileNameFormat.setBorder(BorderFactory.createLineBorder(Color.red));
						tfFileNameFormat.setToolTipText(error);
						done = false;
					}
				}

				// Checks to make sure Save Location is a dir
				File saveLocationCheck = new File(tfSaveLocation.getText());
				if (tfSaveLocation.getText().equals("")) {
					saveLocationCheck = new File("");
				} else {
					saveLocationCheck = new File(tfSaveLocation.getText());
					if (saveLocationCheck.isDirectory() == false) {
						tfSaveLocation.setBorder(BorderFactory.createLineBorder(Color.red));
						tfSaveLocation.setToolTipText("Not a valid directory.");
						done = false;
					}
				}

				// Checks to make sure Backup Location is a dir
				File backupLocationCheck;
				if (tfBackupLocation.getText().equals("")) {
					backupLocationCheck = new File("");
				} else {
					backupLocationCheck = new File(tfBackupLocation.getText());
					if (backupLocationCheck.isDirectory() == false) {
						tfBackupLocation.setBorder(BorderFactory.createLineBorder(Color.red));
						tfBackupLocation.setToolTipText("Not a valid directory.");
						done = false;
					}
				}

				if (done == true) {
					file.saveSettings(tfDateFormat.getText(), tfFileNameFormat.getText(), saveLocationCheck,
							backupLocationCheck);
					frmSetupWindow.setVisible(false);
					frmSetupWindow.dispose();
				}
			}
		});
		frmSetupWindow.getContentPane().add(btnDone);
		frmSetupWindow.getContentPane().setFocusTraversalPolicy(
				new FocusTraversalOnArray(new Component[] { lblFileNameFormat, tfFileNameFormat, lblSaveLocation,
						tfSaveLocation, btnSaveLocation, lblBackupLocation, tfBackupLocation, btnBackupLocation,
						lblFormatCodes, lblDateFormat, tfDateFormat, lblDateFormatCodes, btnResetDefault, btnDone }));
	}
}
