package windows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Window.Type;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JButton;

public class SetupWindow {

	private JFrame frmSetupWindow;
	private JTextField txtFormatCodescnclass;
	private JLabel lblSaveLocation;
	private JTextField textField_1;
	private JLabel label;
	private JTextField textField_2;
	private JTextArea txtrFormatCodescnclass;
	private JLabel lblDateFormat;
	private JTextField textField;
	private JTextArea txtrFormatCodesddDay;
	private JButton btnResetDefault;
	private JButton btnDone;

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
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSetupWindow = new JFrame();
		frmSetupWindow.getContentPane().setBackground(SystemColor.menu);
		frmSetupWindow.setResizable(false);
		frmSetupWindow.setTitle("Setup Window");
		frmSetupWindow.setBounds(100, 100, 317, 229);
		frmSetupWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		txtFormatCodescnclass = new JTextField();
		txtFormatCodescnclass.setToolTipText("Format Codes: $CN%-Class Name, $TN%- Test Name, $D%- Date,");
		txtFormatCodescnclass.setColumns(25);
		frmSetupWindow.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblSaveLocation = new JLabel("Save Location:");
		frmSetupWindow.getContentPane().add(lblSaveLocation);
		
		textField_1 = new JTextField();
		textField_1.setColumns(25);
		frmSetupWindow.getContentPane().add(textField_1);
		
		label = new JLabel("Backup Location:");
		frmSetupWindow.getContentPane().add(label);
		
		textField_2 = new JTextField();
		textField_2.setColumns(25);
		frmSetupWindow.getContentPane().add(textField_2);
		
		JLabel lblTeacherName = new JLabel("File Name Format:");
		frmSetupWindow.getContentPane().add(lblTeacherName);
		frmSetupWindow.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblTeacherName, txtFormatCodescnclass}));
		frmSetupWindow.getContentPane().add(txtFormatCodescnclass);
		
		txtrFormatCodescnclass = new JTextArea();
		txtrFormatCodescnclass.setBackground(SystemColor.menu);
		txtrFormatCodescnclass.setFont(UIManager.getFont("Label.font"));
		txtrFormatCodescnclass.setColumns(35);
		txtrFormatCodescnclass.setLineWrap(true);
		txtrFormatCodescnclass.setTabSize(20);
		txtrFormatCodescnclass.setEditable(false);
		txtrFormatCodescnclass.setText("Format Codes: $CN%-Class Name, $TN%- Test Name\r\n$DF%- Date");
		frmSetupWindow.getContentPane().add(txtrFormatCodescnclass);
		
		lblDateFormat = new JLabel("Date Format:");
		frmSetupWindow.getContentPane().add(lblDateFormat);
		
		textField = new JTextField();
		textField.setToolTipText("Format Codes: $CN%-Class Name, $TN%- Test Name, $D%- Date,");
		textField.setColumns(25);
		frmSetupWindow.getContentPane().add(textField);
		
		txtrFormatCodesddDay = new JTextArea();
		txtrFormatCodesddDay.setText("$DD% - Day, $MM% - Month, $YYYY% - Year");
		txtrFormatCodesddDay.setTabSize(20);
		txtrFormatCodesddDay.setLineWrap(true);
		txtrFormatCodesddDay.setFont(UIManager.getFont("Label.font"));
		txtrFormatCodesddDay.setEditable(false);
		txtrFormatCodesddDay.setColumns(28);
		txtrFormatCodesddDay.setBackground(SystemColor.menu);
		frmSetupWindow.getContentPane().add(txtrFormatCodesddDay);
		
		btnResetDefault = new JButton("Reset Default");
		frmSetupWindow.getContentPane().add(btnResetDefault);
		
		btnDone = new JButton("Done");
		frmSetupWindow.getContentPane().add(btnDone);
	}
}
