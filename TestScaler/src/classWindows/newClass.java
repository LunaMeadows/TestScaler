package classWindows;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.Rectangle;

import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JScrollPane;
import java.awt.ScrollPane;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JTabbedPane;
import java.beans.PropertyChangeListener;
import java.util.Vector;
import java.beans.PropertyChangeEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.HierarchyBoundsAdapter;
import java.awt.event.HierarchyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Box;
import javax.swing.BoxLayout;

import org.eclipse.wb.swing.FocusTraversalOnArray;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class newClass {

	private static JFrame frame;
	private static JTable table;
	private JLabel lblNewLabel;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblClassName;
	private Box verticalBox;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnDone;
	private Box verticalBox_1;
	private Component verticalStrut;
	private JButton btnUpdate;
	private JPanel panel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newClass window = new newClass();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public newClass() {
		initialize();
	}
	
	public void activate() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		
		
		frame.setBounds(100, 100, 441, 536);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JScrollPane scrollPane = new JScrollPane();
		//frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setRowSelectionAllowed(false);
		table.setModel(new DefaultTableModel(40,1));
		table.getColumnModel().getColumn(0).setHeaderValue("Class Name");
		table.setRowHeight(20);
		table.setPreferredSize(new Dimension(200,table.getRowHeight()*table.getRowCount()));
		table.setPreferredScrollableViewportSize(new Dimension(200,frame.getHeight()-70));
		scrollPane.setViewportView(table);
		//frame.getContentPane().add(new JScrollPane(table));
		frame.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				table.setPreferredScrollableViewportSize(new Dimension(200,frame.getHeight()-70));
				scrollPane.setViewportView(table);
			}
		});
		frame.getContentPane().add(scrollPane);
		
		verticalBox_1 = Box.createVerticalBox();
		frame.getContentPane().add(verticalBox_1);
		
		verticalBox = Box.createVerticalBox();
		verticalBox_1.add(verticalBox);
		
		panel = new JPanel();
		panel.setAlignmentX(Component.LEFT_ALIGNMENT);
		verticalBox.add(panel);
		
		lblNewLabel = new JLabel("Class Size");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		panel.add(textField);
		
		textField.setColumns(10);
		
		panel_1 = new JPanel();
		panel_1.setAlignmentX(Component.LEFT_ALIGNMENT);
		verticalBox.add(panel_1);
		
		lblClassName = new JLabel("Class Name");
		lblClassName.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblClassName);
		
		textField_1 = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				table.setModel(new DefaultTableModel(Integer.parseInt(textField.getText()),1));
				table.setPreferredSize(new Dimension(200,table.getRowHeight()*table.getRowCount()));
				scrollPane.setViewportView(table);
			}
		});
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		panel_2 = new JPanel();
		panel_2.setAlignmentX(0.0f);
		verticalBox.add(panel_2);
		
		btnDone = new JButton("Done");
		panel_2.add(btnDone);
		
		btnUpdate = new JButton("Update");
		
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				table.setModel(new DefaultTableModel(Integer.parseInt(textField.getText()),1));
				table.setPreferredSize(new Dimension(200,table.getRowHeight()*table.getRowCount()));
				scrollPane.setViewportView(table);
			}
		});
		panel_2.add(btnUpdate);
		
		verticalStrut = Box.createVerticalStrut(20);
		verticalStrut.setPreferredSize(new Dimension(0,frame.getHeight()-127));
		verticalBox_1.add(verticalStrut);
	}

}
