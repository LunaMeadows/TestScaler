package windows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import classes.FileClass;

import java.awt.Color;
import java.awt.Component;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPopupMenu;

public class SetupWindow {

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
		frmSetupWindow.getContentPane().setBackground(SystemColor.menu);
		frmSetupWindow.setResizable(false);
		frmSetupWindow.setTitle("Setup Window");
		frmSetupWindow.setBounds(100, 100, 403, 229);
		frmSetupWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		tfFileNameFormat = new JTextField();
		tfFileNameFormat.setToolTipText("Default: $DF%-$CN%-$TN%");
		tfFileNameFormat.setColumns(25);
		frmSetupWindow.getContentPane().setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		lblSaveLocation = new JLabel("Save Location:");
		lblSaveLocation.setHorizontalAlignment(SwingConstants.LEFT);
		frmSetupWindow.getContentPane().add(lblSaveLocation);
		
		tfSaveLocation = new JTextField();
		tfSaveLocation.setColumns(20);
		frmSetupWindow.getContentPane().add(tfSaveLocation);
		
		btnSaveLocation = new JButton("");
		btnSaveLocation.addMouseListener(new MouseAdapter() {
			//Button to open up file selection for save location
			@Override
			public void mouseClicked(MouseEvent arg0) {
				tfSaveLocation.setText(String.valueOf(file.selectFolder("Select save location").getSelectedFile().getPath()));
			}
		});
		btnSaveLocation.setIcon(new ImageIcon(SetupWindow.class.getResource("/javax/swing/plaf/metal/icons/ocean/directory.gif")));
		frmSetupWindow.getContentPane().add(btnSaveLocation);
		
		lblBackupLocation = new JLabel("Backup Location:");
		lblBackupLocation.setHorizontalAlignment(SwingConstants.LEFT);
		frmSetupWindow.getContentPane().add(lblBackupLocation);
		
		tfBackupLocation = new JTextField();
		tfBackupLocation.setColumns(20);
		frmSetupWindow.getContentPane().add(tfBackupLocation);
		
		btnBackupLocation = new JButton("");
		btnBackupLocation.addMouseListener(new MouseAdapter() {
			//Button to open up file selection for backup location
			@Override
			public void mouseClicked(MouseEvent e) {
				tfBackupLocation.setText(String.valueOf(file.selectFolder("Select backup location").getSelectedFile().getPath()));
			}
		});
		btnBackupLocation.setIcon(new ImageIcon(SetupWindow.class.getResource("/javax/swing/plaf/metal/icons/ocean/directory.gif")));
		frmSetupWindow.getContentPane().add(btnBackupLocation);
		
		JLabel lblFileNameFormat = new JLabel("File Name Format:");
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
		frmSetupWindow.getContentPane().add(btnResetDefault);
		
		btnDone = new JButton("Done");
		btnDone.addMouseListener(new MouseAdapter() {
			//Button to confirm settings for first run
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean done = true;
				if(tfDateFormat.getText().equals("")) {
					file.setDateFormat("$YYYY%_$MM%_$DD%");
				} else {
					file.checkDateFormat("$YYYY%_$MM%_$DD%");
					String error = file.checkDateFormat(tfDateFormat.getText());
					if(!error.equals("clear")) {
						tfDateFormat.setBorder(BorderFactory.createLineBorder(Color.red));
						tfDateFormat.setToolTipText(error);
					}
					
				}
				if(tfFileNameFormat.getText().equals("")) {
					file.setDateFormat("$YYYY%_$MM%_$DD%");
				} else {
					file.setDateFormat("$YYYY%_$MM%_$DD%");
				}
			}
		});
		frmSetupWindow.getContentPane().add(btnDone);
		frmSetupWindow.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblFileNameFormat, tfFileNameFormat, lblSaveLocation, tfSaveLocation, btnSaveLocation, lblBackupLocation, tfBackupLocation, btnBackupLocation, lblFormatCodes, lblDateFormat, tfDateFormat, lblDateFormatCodes, btnResetDefault, btnDone}));
	}
}
