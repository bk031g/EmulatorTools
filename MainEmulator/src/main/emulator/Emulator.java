package main.emulator;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

import org.apache.xmlrpc.XmlRpcClient;
import org.apache.xmlrpc.XmlRpcException;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import javax.swing.JTabbedPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.SpinnerListModel;
import javax.swing.UIManager;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTree;
import javax.swing.JCheckBox;
import javax.swing.border.BevelBorder;
import javax.swing.JSpinner;

import java.awt.Component;

import javax.swing.JComboBox;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.border.SoftBevelBorder;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.JTable;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.GridLayout;

/**
 *
 * 
 */
@SuppressWarnings("serial")
public class Emulator extends JFrame {
	
	
	// End of variables declaration//GEN-END:variables
	Vector<?> emptyParam = new Vector<Object>();
	Vector<String> verifyFileParams = new Vector<String>();
    String TestPlanVersion = "";
    Vector<String> status;
    Vector<String> task_result = new Vector<>();
    Vector<String> taskID = new Vector<String>();
    XmlRpcClient baton;
	ArrayList<String> tasks = new ArrayList<String>();
    private JTabbedPane tabbedPane;
    private JLabel label_BatonIP;
    private JComboBox<?> textField_BatonIP;
    private JList<String> list_TestPlan;
    private JPanel panel_2;
    private JPanel jobCreationPanel;
    private JPanel contentPane;
	ArrayList<String> contentFolderList = new ArrayList<String>();
	private String parentFolder;
	JFileChooser atemeChooser = new JFileChooser();
	private JComboBox<?> textField_AtemeIP;
	private JTree tree;
	private JComboBox<?> txtCmsprofiler;
	private JComboBox<?> textField_BatonHeaderIP;
	private JList<String> list_AtemePreset;
	private JList<String> list_ElementalPreset;
	private JButton btnAtemePopulate;
	private JSpinner spinner;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JCheckBox chckbxManualPresetEntry;
	private JTextField textField_4;
	private JCheckBox chckbxManualTestplanEntry;
	private JTextField textField_BatonFilter;
	private JTextField textField_AtemeFilter;
	private JButton btnNewButton;
	
	private String startingDirectory = "\\\\isilonla3.vod.dtveng.net\\ifs";
	private String startingAtemeDirectory = "\\\\isilonla3.vod.dtveng.net\\ifs\\ATEME";
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_ElementalFilter;
	private JTextField textField_11;
	private JButton btnNewButton_2;
	
	private final JFrame frame = new JFrame();
	private JCheckBox chckbxAtemeTranscode;
	private JTextField textField_12;
	private JScrollPane scrollPane;
	private JPanel panel_4;
	private JButton btnRefreshContentTable;
	
	private JLabel btnGoTo;
	
	private ArrayList<String> listOfAtemePresets;
	private ArrayList<String> listOfElementalPresets;
	private Vector<String> listOfTestPlans;
	private JCheckBox chckbxBatonFullQc;
	private JPanel atemePanel;
	private JPanel fullQCPanel;
	private JPanel elementalPanel;
	private JPanel headerCheckPanel;
	private JCheckBox chckbxBatonHeader;
	private JCheckBox chckbxElementalTranscode;
	private JPanel atemePanel2;
	private JPanel atemePanel3;
	private JTabbedPane tabbedPane_1;
	private JLabel lblNewLabel;
	private JSpinner spinner_2;
	private JButton btnAtemeInput;
	
	private ArrayList<JobConductor> JobList = new ArrayList<JobConductor>();
	private JPanel panel_JobTracker;
	private JTable table;
	private JPanel panelJobTrack;
	private JScrollPane scrollPane_2;
	private JTable table_1;
	private JTextField textField_13;
	private JPanel elementalPanel1;
	private JPanel elementalPanel2;
	private JComboBox<?> textField_ElementalIP;
	
	
	
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					Emulator frame = new Emulator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/*
     * _______________________________________________
     */
	
	/*
	 * Constructor
	 */
	
	/*
     * _______________________________________________
     */
    public Emulator() {
    	
    	/*
    	 * Initialize GUI
    	 */
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 910);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
        initComponents();
        
        
        /*
         * Startup conditions
         */
        setPanelEnabled(0, false);
        setPanelEnabled(1, false);
        setPanelEnabled(2, false);
        setPanelEnabled(3, false);
        atemeChooser.setCurrentDirectory(new File(startingAtemeDirectory));
        PopulateGUI.atemeChooser.setCurrentDirectory(new File(startingAtemeDirectory));
    }
    
    
    /*
     * ____________________________________________
     */
	
	/*
	 * GUI
	 */
	
	/*
     * ____________________________________________
     */

    
    private void initComponents() {

		new JFileChooser();

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		new JList<>();

		jobCreationPanel = new JPanel();
		tabbedPane.addTab("Job Creation", null, jobCreationPanel, null);

		tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);

		panel_4 = new JPanel();
		panel_4.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null,
				null, null));

		btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

			}
		});

		scrollPane = new JScrollPane();

		textField_12 = new JTextField();
		textField_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				startingDirectory = textField_12.getText();
				createContentTable(startingDirectory);
			}
		});
		textField_12.setColumns(10);

		btnRefreshContentTable = new JButton(
				" \\\\isilonla3.vod.dtveng.net\\ifs");
		btnRefreshContentTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				startingDirectory = "\\\\isilonla3.vod.dtveng.net\\ifs";
				createContentTable(startingDirectory);
			}
		});

		btnGoTo = new JLabel("Go to:");

		JLabel lblReturnTo = new JLabel("Return to:");

		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
            gl_panel_4.setHorizontalGroup(
            	gl_panel_4.createParallelGroup(Alignment.TRAILING)
            		.addGroup(gl_panel_4.createSequentialGroup()
            			.addContainerGap()
            			.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
            				.addGroup(gl_panel_4.createSequentialGroup()
            					.addComponent(lblReturnTo, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
            					.addPreferredGap(ComponentPlacement.UNRELATED))
            				.addGroup(gl_panel_4.createSequentialGroup()
            					.addComponent(btnGoTo)
            					.addGap(40)))
            			.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING, false)
            				.addComponent(btnRefreshContentTable, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            				.addComponent(textField_12, GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE))
            			.addGap(23))
            		.addGroup(Alignment.LEADING, gl_panel_4.createSequentialGroup()
            			.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 429, GroupLayout.PREFERRED_SIZE)
            			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            gl_panel_4.setVerticalGroup(
            	gl_panel_4.createParallelGroup(Alignment.LEADING)
            		.addGroup(gl_panel_4.createSequentialGroup()
            			.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
            				.addComponent(lblReturnTo)
            				.addComponent(btnRefreshContentTable))
            			.addPreferredGap(ComponentPlacement.RELATED)
            			.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
            				.addComponent(btnGoTo)
            				.addComponent(textField_12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            			.addPreferredGap(ComponentPlacement.RELATED)
            			.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 721, Short.MAX_VALUE))
            );

		File file = new File(startingDirectory);
		MyFile mf = new MyFile(file);
		TreeModel model = new FileTreeModel(mf);

		tree = new JTree(model);

		addContentTreeListener();

		scrollPane.setViewportView(tree);
		tree.setEditable(true);
		panel_4.setLayout(gl_panel_4);

		atemePanel = new JPanel();
		atemePanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("asd");
			}
		});
		tabbedPane_1.addTab("ATEME", null, atemePanel, null);

		JLabel lblAtemeIp = new JLabel();
		lblAtemeIp.setText("ATEME IP");

		String[] AtemeIP = { "10.27.99.62", "10.27.99.66", "10.27.99.60" };
		textField_AtemeIP = new JComboBox<Object>(AtemeIP);
		textField_AtemeIP.setEditable(true);

		btnAtemePopulate = new JButton();
		btnAtemePopulate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					populateAteme();
				} catch (JDOMException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnAtemePopulate.setText("Populate");

		JScrollPane scrollPane_AtemePreset = new JScrollPane();

		String[] atemePriority = { "Low", "Normal", "High", "Urgent" };
		new SpinnerListModel(atemePriority);

		atemePanel2 = new JPanel();
		atemePanel2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null,null, null));

		JLabel lblOutputDirectory = new JLabel();
		lblOutputDirectory.setText("Output Folder:");

		textField = new JTextField();
		textField.setColumns(10);

		JButton btnAtemeOutput = new JButton("Select Folder");
		btnAtemeOutput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AtemeOutputActionPerformed(arg0);
			}
		});

		JLabel lblOutputName = new JLabel();
		lblOutputName.setText("Output Name:");

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JButton btnAtemeXML = new JButton("Extract XML");
		
		JButton btnExtractXmlTo = new JButton("Extract XML to Excel");
		GroupLayout gl_atemePanel2 = new GroupLayout(atemePanel2);
		gl_atemePanel2.setHorizontalGroup(
			gl_atemePanel2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_atemePanel2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_atemePanel2.createParallelGroup(Alignment.LEADING)
						.addComponent(lblOutputName)
						.addComponent(lblOutputDirectory, GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_atemePanel2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_atemePanel2.createSequentialGroup()
							.addComponent(btnAtemeXML, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnExtractXmlTo))
						.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, gl_atemePanel2.createSequentialGroup()
							.addComponent(textField, GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAtemeOutput, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_atemePanel2.setVerticalGroup(
			gl_atemePanel2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_atemePanel2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_atemePanel2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblOutputName)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_atemePanel2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblOutputDirectory)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAtemeOutput, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_atemePanel2.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAtemeXML)
						.addComponent(btnExtractXmlTo))
					.addGap(37))
		);
		atemePanel2.setLayout(gl_atemePanel2);

		chckbxManualPresetEntry = new JCheckBox("Manual Preset Entry:");
		chckbxManualPresetEntry.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {

				if (chckbxManualPresetEntry.isSelected()) {
					textField_3.setEnabled(true);
					list_AtemePreset.setEnabled(false);
				} else {
					textField_3.setEnabled(false);
					list_AtemePreset.setEnabled(true);
				}

			}
		});

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setEnabled(false);

		textField_AtemeFilter = new JTextField();

		textField_AtemeFilter.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				filterATEMEPresets();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				filterATEMEPresets();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				filterATEMEPresets();
			}

		});

		textField_AtemeFilter.setColumns(10);

		JLabel lblFilterPresets = new JLabel();
		lblFilterPresets.setText("Filter Presets:");

		btnAtemeInput = new JButton();
		btnAtemeInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AtemeInputActionPerformed(arg0);
			}
		});
		btnAtemeInput.setText("Folder");

		btnNewButton_2 = new JButton("Info");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				JOptionPane.showMessageDialog(frame, "if 'Job Name' or 'Output Name' is empty, \n 'Content(Preset)' will be used as naming convention.");
			}
		});

		atemePanel3 = new JPanel();
		atemePanel3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		GroupLayout gl_panel_atemeMain = new GroupLayout(atemePanel);
            gl_panel_atemeMain.setHorizontalGroup(
            	gl_panel_atemeMain.createParallelGroup(Alignment.LEADING)
            		.addGroup(gl_panel_atemeMain.createSequentialGroup()
            			.addContainerGap()
            			.addGroup(gl_panel_atemeMain.createParallelGroup(Alignment.LEADING)
            				.addGroup(Alignment.TRAILING, gl_panel_atemeMain.createSequentialGroup()
            					.addComponent(lblAtemeIp, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
            					.addPreferredGap(ComponentPlacement.RELATED)
            					.addComponent(textField_AtemeIP, 0, 317, Short.MAX_VALUE)
            					.addPreferredGap(ComponentPlacement.RELATED)
            					.addComponent(btnAtemePopulate, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
            					.addPreferredGap(ComponentPlacement.RELATED)
            					.addComponent(btnAtemeInput, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
            				.addComponent(scrollPane_AtemePreset, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
            				.addComponent(atemePanel2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
            				.addGroup(Alignment.TRAILING, gl_panel_atemeMain.createSequentialGroup()
            					.addGroup(gl_panel_atemeMain.createParallelGroup(Alignment.LEADING)
            						.addComponent(chckbxManualPresetEntry)
            						.addComponent(lblFilterPresets, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
            					.addGap(18)
            					.addGroup(gl_panel_atemeMain.createParallelGroup(Alignment.LEADING)
            						.addComponent(textField_AtemeFilter, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
            						.addComponent(textField_3, GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)))
            				.addGroup(Alignment.TRAILING, gl_panel_atemeMain.createSequentialGroup()
            					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 478, GroupLayout.PREFERRED_SIZE)
            					.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
            					.addComponent(btnNewButton_2))
            				.addComponent(atemePanel3, GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE))
            			.addContainerGap())
            );
            gl_panel_atemeMain.setVerticalGroup(
            	gl_panel_atemeMain.createParallelGroup(Alignment.LEADING)
            		.addGroup(gl_panel_atemeMain.createSequentialGroup()
            			.addContainerGap()
            			.addGroup(gl_panel_atemeMain.createParallelGroup(Alignment.BASELINE)
            				.addComponent(lblAtemeIp)
            				.addComponent(textField_AtemeIP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            				.addComponent(btnAtemeInput)
            				.addComponent(btnAtemePopulate))
            			.addGap(10)
            			.addComponent(scrollPane_AtemePreset, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
            			.addPreferredGap(ComponentPlacement.RELATED)
            			.addGroup(gl_panel_atemeMain.createParallelGroup(Alignment.BASELINE)
            				.addComponent(textField_AtemeFilter, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            				.addComponent(lblFilterPresets))
            			.addPreferredGap(ComponentPlacement.RELATED)
            			.addGroup(gl_panel_atemeMain.createParallelGroup(Alignment.BASELINE)
            				.addComponent(chckbxManualPresetEntry)
            				.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            			.addGap(10)
            			.addComponent(atemePanel2, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
            			.addPreferredGap(ComponentPlacement.RELATED)
            			.addComponent(atemePanel3, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
            			.addGroup(gl_panel_atemeMain.createParallelGroup(Alignment.LEADING, false)
            				.addGroup(gl_panel_atemeMain.createSequentialGroup()
            					.addGap(55)
            					.addComponent(btnNewButton_2))
            				.addGroup(gl_panel_atemeMain.createSequentialGroup()
            					.addPreferredGap(ComponentPlacement.RELATED)
            					.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            			.addContainerGap())
            );
            
		JLabel lblJobName = new JLabel();
		lblJobName.setText("Job Name:");

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		spinner = new JSpinner(new SpinnerListModel(new String[] { "Low", "Normal", "High", "Urgent" }));

		JLabel lblJobPriority = new JLabel();
		lblJobPriority.setText("Job Priority:");
		GroupLayout gl_atemePanel3 = new GroupLayout(atemePanel3);
            gl_atemePanel3.setHorizontalGroup(
            	gl_atemePanel3.createParallelGroup(Alignment.LEADING)
            		.addGroup(gl_atemePanel3.createSequentialGroup()
            			.addContainerGap()
            			.addComponent(lblJobName)
            			.addPreferredGap(ComponentPlacement.RELATED)
            			.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
            			.addGap(18)
            			.addComponent(lblJobPriority, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
            			.addPreferredGap(ComponentPlacement.RELATED)
            			.addComponent(spinner, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
            			.addContainerGap())
            );
            gl_atemePanel3.setVerticalGroup(
            	gl_atemePanel3.createParallelGroup(Alignment.LEADING)
            		.addGroup(gl_atemePanel3.createSequentialGroup()
            			.addGap(14)
            			.addGroup(gl_atemePanel3.createParallelGroup(Alignment.BASELINE)
            				.addComponent(lblJobName)
            				.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            				.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            				.addComponent(lblJobPriority))
            			.addGap(47))
            );
		atemePanel3.setLayout(gl_atemePanel3);

		list_AtemePreset = new JList<String>();
		scrollPane_AtemePreset.setViewportView(list_AtemePreset);
		atemePanel.setLayout(gl_panel_atemeMain);

		fullQCPanel = new JPanel();
		tabbedPane_1.addTab("Baton", null, fullQCPanel, null);

		JScrollPane scrollPane_TestPlan = new JScrollPane();

		list_TestPlan = new JList<String>();
		scrollPane_TestPlan.setViewportView(list_TestPlan);
		list_TestPlan.getAccessibleContext().setAccessibleName("Testplans");

		label_BatonIP = new JLabel();
		label_BatonIP.setText("Baton IP");

		String[] BatonIP = { "10.26.78.45", "10.26.86.18" };
		textField_BatonIP = new JComboBox<Object>(BatonIP);
		textField_BatonIP.setEditable(true);

		JButton btnBatonPopulate = new JButton();
		btnBatonPopulate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					populateBaton();
				} catch (JDOMException | IOException | XmlRpcException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnBatonPopulate.setText("Populate");

		headerCheckPanel = new JPanel();
		headerCheckPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		chckbxManualTestplanEntry = new JCheckBox("Manual Test Plan Entry:");
		chckbxManualTestplanEntry.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if (chckbxManualTestplanEntry.isSelected()) {
					textField_4.setEnabled(true);
					list_TestPlan.setEnabled(false);
					textField_BatonFilter.setEnabled(false);
				} else {
					textField_4.setEnabled(false);
					list_TestPlan.setEnabled(true);
					textField_BatonFilter.setEnabled(true);
				}
			}
		});

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setEnabled(false);

		JLabel BatonSearch = new JLabel();
		BatonSearch.setText("Filter Test Plans:");

		textField_BatonFilter = new JTextField();

		textField_BatonFilter.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				filterTestPlans();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				filterTestPlans();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				filterTestPlans();
			}

		});
		textField_BatonFilter.setColumns(10);

		lblNewLabel = new JLabel("Job Priority");

		String[] batonSpinnerValues = { "Low", "Normal", "High", "Urgent" };
		SpinnerListModel batonSpinnerModel = new SpinnerListModel(
				batonSpinnerValues);
		spinner_2 = new JSpinner(batonSpinnerModel);

		GroupLayout gl_panel_1 = new GroupLayout(fullQCPanel);
            gl_panel_1.setHorizontalGroup(
            	gl_panel_1.createParallelGroup(Alignment.LEADING)
            		.addGroup(gl_panel_1.createSequentialGroup()
            			.addContainerGap()
            			.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
            				.addComponent(scrollPane_TestPlan, GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
            				.addGroup(gl_panel_1.createSequentialGroup()
            					.addComponent(label_BatonIP, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
            					.addPreferredGap(ComponentPlacement.RELATED)
            					.addComponent(textField_BatonIP, 0, 408, Short.MAX_VALUE)
            					.addPreferredGap(ComponentPlacement.RELATED)
            					.addComponent(btnBatonPopulate, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
            				.addComponent(headerCheckPanel, GroupLayout.PREFERRED_SIZE, 316, GroupLayout.PREFERRED_SIZE)
            				.addGroup(gl_panel_1.createSequentialGroup()
            					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
            						.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
            							.addComponent(lblNewLabel)
            							.addPreferredGap(ComponentPlacement.RELATED)
            							.addComponent(spinner_2))
            						.addComponent(chckbxManualTestplanEntry, Alignment.LEADING)
            						.addComponent(BatonSearch, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
            					.addPreferredGap(ComponentPlacement.RELATED)
            					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
            						.addComponent(textField_BatonFilter, GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
            						.addComponent(textField_4, GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE))))
            			.addContainerGap())
            );
            gl_panel_1.setVerticalGroup(
            	gl_panel_1.createParallelGroup(Alignment.LEADING)
            		.addGroup(gl_panel_1.createSequentialGroup()
            			.addContainerGap()
            			.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
            				.addComponent(label_BatonIP)
            				.addComponent(textField_BatonIP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            				.addComponent(btnBatonPopulate))
            			.addGap(10)
            			.addComponent(scrollPane_TestPlan, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
            			.addPreferredGap(ComponentPlacement.RELATED)
            			.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
            				.addComponent(textField_BatonFilter, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            				.addComponent(BatonSearch))
            			.addGap(5)
            			.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
            				.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            				.addComponent(chckbxManualTestplanEntry))
            			.addGap(18)
            			.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
            				.addComponent(spinner_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            				.addComponent(lblNewLabel))
            			.addGap(59)
            			.addComponent(headerCheckPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            			.addGap(57))
            );

		JLabel lblBatonHeaderIp = new JLabel();
		lblBatonHeaderIp.setText("Baton Header IP:");

		JLabel lblHeaderTestPlan = new JLabel();
		lblHeaderTestPlan.setText("Header Test Plan:");

		String[] BatonHeaderIP = { "10.26.78.45", "10.26.86.18" };
		textField_BatonHeaderIP = new JComboBox<Object>(BatonHeaderIP);
		textField_BatonHeaderIP.setEditable(true);

		String[] HeaderTestPlans = { "CMS_Profiler", "CMS_Header_4K" };
		txtCmsprofiler = new JComboBox<Object>(HeaderTestPlans);
		txtCmsprofiler.setEditable(true);

		JButton btnAdvancedSettings = new JButton("Advanced Settings");
		GroupLayout gl_panel_3 = new GroupLayout(headerCheckPanel);
            gl_panel_3.setHorizontalGroup(
            	gl_panel_3.createParallelGroup(Alignment.LEADING)
            		.addGroup(gl_panel_3.createSequentialGroup()
            			.addContainerGap()
            			.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
            				.addGroup(gl_panel_3.createSequentialGroup()
            					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
            						.addComponent(lblHeaderTestPlan, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
            						.addComponent(lblBatonHeaderIp, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
            					.addPreferredGap(ComponentPlacement.RELATED)
            					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
            						.addComponent(textField_BatonHeaderIP, 0, 177, Short.MAX_VALUE)
            						.addComponent(txtCmsprofiler, 0, 177, Short.MAX_VALUE))
            					.addContainerGap())
            				.addGroup(gl_panel_3.createSequentialGroup()
            					.addComponent(btnAdvancedSettings, GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
            					.addGap(11))))
            );
            gl_panel_3.setVerticalGroup(
            	gl_panel_3.createParallelGroup(Alignment.LEADING)
            		.addGroup(gl_panel_3.createSequentialGroup()
            			.addContainerGap()
            			.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
            				.addComponent(textField_BatonHeaderIP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            				.addComponent(lblBatonHeaderIp))
            			.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
            				.addGroup(gl_panel_3.createSequentialGroup()
            					.addGap(9)
            					.addComponent(lblHeaderTestPlan))
            				.addGroup(gl_panel_3.createSequentialGroup()
            					.addPreferredGap(ComponentPlacement.RELATED)
            					.addComponent(txtCmsprofiler, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
            			.addPreferredGap(ComponentPlacement.UNRELATED)
            			.addComponent(btnAdvancedSettings)
            			.addContainerGap(19, Short.MAX_VALUE))
            );
		headerCheckPanel.setLayout(gl_panel_3);
		fullQCPanel.setLayout(gl_panel_1);

		chckbxBatonHeader = new JCheckBox("Baton Header");
		
		chckbxBatonHeader.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chckbxBatonHeader.isSelected()) {
					setPanelEnabled(0, true);
				} else
					setPanelEnabled(0, false);
			}
		});
		

		chckbxAtemeTranscode = new JCheckBox("ATEME Transcode");
		chckbxAtemeTranscode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chckbxAtemeTranscode.isSelected()) {
					setPanelEnabled(1, true);
				} else
					setPanelEnabled(1, false);
			}
		});

		chckbxBatonFullQc = new JCheckBox("Baton Full QC");
		chckbxBatonFullQc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chckbxBatonFullQc.isSelected()) {
					setPanelEnabled(2, true);
				} else
					setPanelEnabled(2, false);
			}
		});

		JButton btnSubmit = new JButton();
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				button_submitActionPerformed(arg0);
			}
		});
		btnSubmit.setText("Submit");

		JLabel lblContentInput = new JLabel("Content Input");

		chckbxElementalTranscode = new JCheckBox("Elemental Transcode");
		chckbxElementalTranscode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chckbxElementalTranscode.isSelected()) {
					setPanelEnabled(3, true);
				} else
					setPanelEnabled(3, false);
			}
		});

		GroupLayout gl_jobCreationPanel = new GroupLayout(jobCreationPanel);
            gl_jobCreationPanel.setHorizontalGroup(
            	gl_jobCreationPanel.createParallelGroup(Alignment.LEADING)
            		.addGroup(gl_jobCreationPanel.createSequentialGroup()
            			.addContainerGap()
            			.addGroup(gl_jobCreationPanel.createParallelGroup(Alignment.LEADING)
            				.addComponent(lblContentInput, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
            				.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 433, GroupLayout.PREFERRED_SIZE))
            			.addPreferredGap(ComponentPlacement.RELATED)
            			.addGroup(gl_jobCreationPanel.createParallelGroup(Alignment.LEADING)
            				.addGroup(gl_jobCreationPanel.createSequentialGroup()
            					.addComponent(chckbxBatonHeader)
            					.addPreferredGap(ComponentPlacement.RELATED)
            					.addComponent(chckbxAtemeTranscode)
            					.addPreferredGap(ComponentPlacement.RELATED)
            					.addComponent(chckbxBatonFullQc)
            					.addPreferredGap(ComponentPlacement.RELATED)
            					.addComponent(chckbxElementalTranscode))
            				.addGroup(gl_jobCreationPanel.createParallelGroup(Alignment.TRAILING)
            					.addComponent(tabbedPane_1, GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE)
            					.addGroup(Alignment.LEADING, gl_jobCreationPanel.createSequentialGroup()
            						.addGap(65)
            						.addComponent(btnNewButton)
            						.addPreferredGap(ComponentPlacement.RELATED, 341, Short.MAX_VALUE)
            						.addComponent(btnSubmit, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))))
            			.addGap(18))
            );
            gl_jobCreationPanel.setVerticalGroup(
            	gl_jobCreationPanel.createParallelGroup(Alignment.LEADING)
            		.addGroup(gl_jobCreationPanel.createSequentialGroup()
            			.addGap(11)
            			.addGroup(gl_jobCreationPanel.createParallelGroup(Alignment.BASELINE)
            				.addComponent(chckbxBatonHeader)
            				.addComponent(chckbxAtemeTranscode)
            				.addComponent(chckbxBatonFullQc)
            				.addComponent(lblContentInput)
            				.addComponent(chckbxElementalTranscode))
            			.addGap(7)
            			.addGroup(gl_jobCreationPanel.createParallelGroup(Alignment.LEADING)
            				.addGroup(Alignment.TRAILING, gl_jobCreationPanel.createSequentialGroup()
            					.addComponent(tabbedPane_1, GroupLayout.PREFERRED_SIZE, 731, GroupLayout.PREFERRED_SIZE)
            					.addGap(6)
            					.addGroup(gl_jobCreationPanel.createParallelGroup(Alignment.TRAILING)
            						.addComponent(btnNewButton)
            						.addComponent(btnSubmit)))
            				.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            			.addContainerGap())
            );

		elementalPanel = new JPanel();
		tabbedPane_1.addTab("Elemental", null, elementalPanel, null);

		JLabel lblElementalIp = new JLabel();
		lblElementalIp.setText("Elemental IP");

		String[] ElementalIP = { "10.26.78.41", "10.27.99.181" };
		textField_ElementalIP = new JComboBox<Object>(ElementalIP);
		textField_ElementalIP.setEditable(true);

		JButton button_1 = new JButton();
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					populateElemental();
				} catch (JDOMException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		button_1.setText("Populate");

		JButton button_2 = new JButton();
		button_2.setText("Folder");

		JScrollPane scrollPane_ElementalPreset = new JScrollPane();

		elementalPanel2 = new JPanel();
		elementalPanel2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		JLabel label_1 = new JLabel();
		label_1.setText("Job Name:");

		JLabel label_2 = new JLabel();
		label_2.setText("Job Priority:");

		textField_7 = new JTextField();
		textField_7.setColumns(10);

		String[] elementalPriority = { "Low", "Normal", "High", "Urgent" };
		SpinnerListModel elementalPriorityModel = new SpinnerListModel(elementalPriority);
		JSpinner spinner_1 = new JSpinner(elementalPriorityModel);

            GroupLayout gl_elementalPanel2 = new GroupLayout(elementalPanel2);
            gl_elementalPanel2.setHorizontalGroup(
            	gl_elementalPanel2.createParallelGroup(Alignment.LEADING)
            		.addGap(0, 241, Short.MAX_VALUE)
            		.addGroup(gl_elementalPanel2.createSequentialGroup()
            			.addContainerGap()
            			.addGroup(gl_elementalPanel2.createParallelGroup(Alignment.LEADING)
            				.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
            				.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
            			.addPreferredGap(ComponentPlacement.RELATED)
            			.addGroup(gl_elementalPanel2.createParallelGroup(Alignment.LEADING)
            				.addComponent(textField_7, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
            				.addComponent(spinner_1, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))
            			.addContainerGap())
            );
            gl_elementalPanel2.setVerticalGroup(
            	gl_elementalPanel2.createParallelGroup(Alignment.LEADING)
            		.addGap(0, 75, Short.MAX_VALUE)
            		.addGroup(gl_elementalPanel2.createSequentialGroup()
            			.addContainerGap()
            			.addGroup(gl_elementalPanel2.createParallelGroup(Alignment.BASELINE)
            				.addComponent(label_1)
            				.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            			.addPreferredGap(ComponentPlacement.RELATED)
            			.addGroup(gl_elementalPanel2.createParallelGroup(Alignment.BASELINE)
            				.addComponent(spinner_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            				.addComponent(label_2))
            			.addContainerGap(14, Short.MAX_VALUE))
            );
		elementalPanel2.setLayout(gl_elementalPanel2);

		elementalPanel1 = new JPanel();
		elementalPanel1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		JLabel label_3 = new JLabel();
		label_3.setText("Output Name:");

		JLabel label_4 = new JLabel();
		label_4.setText("Output Folder:");

		textField_8 = new JTextField();
		textField_8.setColumns(10);

		textField_9 = new JTextField();
		textField_9.setColumns(10);

		JButton button_3 = new JButton("Select Folder");
		GroupLayout gl_elementalPanel1 = new GroupLayout(elementalPanel1);
            gl_elementalPanel1.setHorizontalGroup(
            	gl_elementalPanel1.createParallelGroup(Alignment.TRAILING)
            		.addGap(0, 557, Short.MAX_VALUE)
            		.addGroup(gl_elementalPanel1.createSequentialGroup()
            			.addContainerGap()
            			.addGroup(gl_elementalPanel1.createParallelGroup(Alignment.LEADING)
            				.addComponent(label_3)
            				.addComponent(label_4, GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE))
            			.addPreferredGap(ComponentPlacement.RELATED)
            			.addGroup(gl_elementalPanel1.createParallelGroup(Alignment.LEADING)
            				.addComponent(textField_8, GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
            				.addComponent(textField_9, GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
            				.addComponent(button_3, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE))
            			.addContainerGap())
            );
            gl_elementalPanel1.setVerticalGroup(
            	gl_elementalPanel1.createParallelGroup(Alignment.LEADING)
            		.addGap(0, 99, Short.MAX_VALUE)
            		.addGroup(gl_elementalPanel1.createSequentialGroup()
            			.addContainerGap()
            			.addGroup(gl_elementalPanel1.createParallelGroup(Alignment.BASELINE)
            				.addComponent(label_3)
            				.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            			.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            			.addGroup(gl_elementalPanel1.createParallelGroup(Alignment.BASELINE)
            				.addComponent(label_4)
            				.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            			.addPreferredGap(ComponentPlacement.RELATED)
            			.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
            			.addGap(37))
            );
		elementalPanel1.setLayout(gl_elementalPanel1);

		JCheckBox checkBox = new JCheckBox("Manual Preset Entry:");

		JLabel label_5 = new JLabel();
		label_5.setText("Filter Presets:");

		textField_ElementalFilter = new JTextField();
		
		textField_ElementalFilter.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				filterElementalPreset();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				filterElementalPreset();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				filterElementalPreset();
			}

		});
		
		textField_ElementalFilter.setColumns(10);

		textField_11 = new JTextField();
		textField_11.setEnabled(false);
		textField_11.setColumns(10);
		GroupLayout gl_panel_7 = new GroupLayout(elementalPanel);
            gl_panel_7.setHorizontalGroup(
            	gl_panel_7.createParallelGroup(Alignment.LEADING)
            		.addGroup(gl_panel_7.createSequentialGroup()
            			.addContainerGap()
            			.addGroup(gl_panel_7.createParallelGroup(Alignment.TRAILING)
            				.addGroup(gl_panel_7.createSequentialGroup()
            					.addGroup(gl_panel_7.createParallelGroup(Alignment.LEADING)
            						.addGroup(Alignment.TRAILING, gl_panel_7.createSequentialGroup()
            							.addComponent(lblElementalIp, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
            							.addPreferredGap(ComponentPlacement.RELATED)
            							.addComponent(textField_ElementalIP, GroupLayout.PREFERRED_SIZE, 291, GroupLayout.PREFERRED_SIZE)
            							.addPreferredGap(ComponentPlacement.RELATED)
            							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
            							.addPreferredGap(ComponentPlacement.RELATED)
            							.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
            						.addComponent(scrollPane_ElementalPreset, GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE))
            					.addContainerGap())
            				.addGroup(gl_panel_7.createSequentialGroup()
            					.addComponent(elementalPanel2, GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
            					.addGap(326))
            				.addGroup(gl_panel_7.createSequentialGroup()
            					.addComponent(elementalPanel1, GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
            					.addContainerGap())
            				.addGroup(gl_panel_7.createSequentialGroup()
            					.addGroup(gl_panel_7.createParallelGroup(Alignment.LEADING)
            						.addComponent(checkBox)
            						.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
            					.addGap(18)
            					.addGroup(gl_panel_7.createParallelGroup(Alignment.LEADING)
            						.addComponent(textField_ElementalFilter, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
            						.addComponent(textField_11, GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE))
            					.addContainerGap())))
            );
            gl_panel_7.setVerticalGroup(
            	gl_panel_7.createParallelGroup(Alignment.LEADING)
            		.addGroup(gl_panel_7.createSequentialGroup()
            			.addContainerGap()
            			.addGroup(gl_panel_7.createParallelGroup(Alignment.BASELINE)
            				.addComponent(lblElementalIp)
            				.addComponent(textField_ElementalIP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            				.addComponent(button_2)
            				.addComponent(button_1))
            			.addGap(10)
            			.addComponent(scrollPane_ElementalPreset, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
            			.addPreferredGap(ComponentPlacement.RELATED)
            			.addGroup(gl_panel_7.createParallelGroup(Alignment.BASELINE)
            				.addComponent(textField_ElementalFilter, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            				.addComponent(label_5))
            			.addPreferredGap(ComponentPlacement.RELATED)
            			.addGroup(gl_panel_7.createParallelGroup(Alignment.BASELINE)
            				.addComponent(checkBox)
            				.addComponent(textField_11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            			.addGap(10)
            			.addComponent(elementalPanel1, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
            			.addPreferredGap(ComponentPlacement.RELATED)
            			.addComponent(elementalPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            			.addContainerGap(61, Short.MAX_VALUE))
            );
            
            list_ElementalPreset = new JList<String>();
            scrollPane_ElementalPreset.setViewportView(list_ElementalPreset);
		elementalPanel.setLayout(gl_panel_7);
		jobCreationPanel.setLayout(gl_jobCreationPanel);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(tabbedPane);
		contentPane.add(tabbedPane);
		
		panel_JobTracker = new JPanel();
		tabbedPane.addTab("New tab", null, panel_JobTracker, null);
		
		panelJobTrack = new JPanel();
		GroupLayout gl_panel_JobTracker = new GroupLayout(panel_JobTracker);
		gl_panel_JobTracker.setHorizontalGroup(
			gl_panel_JobTracker.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_JobTracker.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelJobTrack, GroupLayout.DEFAULT_SIZE, 1029, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_JobTracker.setVerticalGroup(
			gl_panel_JobTracker.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_JobTracker.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelJobTrack, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(549, Short.MAX_VALUE))
		);
		
		scrollPane_2 = new JScrollPane();
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		GroupLayout gl_panelJobTrack = new GroupLayout(panelJobTrack);
		gl_panelJobTrack.setHorizontalGroup(
			gl_panelJobTrack.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelJobTrack.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelJobTrack.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
						.addComponent(textField_13, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_panelJobTrack.setVerticalGroup(
			gl_panelJobTrack.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelJobTrack.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
					.addComponent(textField_13, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		
		
		
		DefaultTableModel jobModel = new DefaultTableModel() {
			@Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		};
		jobModel.addColumn("Jobs");
		jobModel.addColumn("Header Check");
		jobModel.addColumn("Transcode");
		jobModel.addColumn("Full QC");
		
		for (int i = 0; i<9; i++){
			jobModel.addRow(new Object[]{String.format("Column %s", i), "Column %s"});
		}
		jobModel.addRow(new Object[]{"Column 2", "Column 3"});
		jobModel.setRowCount(10);
		
		
		table_1 = new JTable(jobModel);
		scrollPane_2.setViewportView(table_1);
		panelJobTrack.setLayout(gl_panelJobTrack);
		
		table_1.addMouseListener(new MouseAdapter() {
			  public void mousePressed(MouseEvent e) {
			    if (e.getClickCount() == 2) {
			      JTable target = (JTable)e.getSource();
			      int row = target.getSelectedRow();
			      int column = target.getSelectedColumn();
			      
			      System.out.println(row + " " + column);
			      // do some action if appropriate column
			    }
			  }
			});
		
		
		panel_JobTracker.setLayout(gl_panel_JobTracker);
		
		panel_2 = new JPanel();
		tabbedPane.addTab("Grid Management", null, panel_2, null);
		
        }

    
    /*
     * ____________________________________________
     */
    
    /*
     * Events
     */
    
    /*
     * ____________________________________________
     */
    
    
    /*
     * Ateme Input Output Buttons
     */
    
    private void AtemeInputActionPerformed(java.awt.event.ActionEvent arg0){
		list_AtemePreset.setListData(PopulateGUI.folderPopulateAteme());
    }
    
    private void AtemeOutputActionPerformed(java.awt.event.ActionEvent arg0){
    	textField.setText(PopulateGUI.folderOutputAteme());
    }
    
    
    /*
     * Submit
     */
    
	private void button_submitActionPerformed(java.awt.event.ActionEvent arg0){
		
		final ArrayList<String> selectedDirectories = new ArrayList<String>();

		boolean atemeTCEnabled = false;
		boolean batonQCEnabled = false;
		boolean batonHCEnabled = false;
		boolean missingField = false;

		if (tree.isSelectionEmpty()) {
			missingField = true;
			JOptionPane.showMessageDialog(frame, "Select content(s).");
		}
		if (chckbxAtemeTranscode.isSelected()) {
			atemeTCEnabled = true;
			if (!fieldCheckAtemeTC()) {
				missingField = true;
			}
		}
		if (chckbxBatonFullQc.isSelected()) {
			batonQCEnabled = true;
			if (!fieldCheckBatonQC()) {
				missingField = true;
			}
		}
		if (chckbxBatonHeader.isSelected()) {
			batonHCEnabled = true;
			if (!fieldCheckBatonHC()) {
				missingField = true;
			}
		}
		
		if (!missingField) {

			for (TreePath path : tree.getSelectionPaths()) {
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < path.getPathCount(); i++)
					sb.append("\\" + path.getPathComponent(i).toString());
				selectedDirectories.add(sb.toString());
			}

			for (String iterateDirectory : selectedDirectories) {
				
				boolean singleHeaderCheck = true;
				
				if (atemeTCEnabled) {

					List<String> selectedPresets = new ArrayList<String>();
					if (chckbxManualPresetEntry.isSelected()) {
						selectedPresets.add(textField_3.getText());
					} else
						selectedPresets = list_AtemePreset.getSelectedValuesList();
					
					String jobPriority = ((String) spinner.getValue()).toLowerCase();
					System.out.println(jobPriority);
					
					for (String Preset : selectedPresets) {
						
						JobConductor initConductor = new JobConductor();
						JobList.add(initConductor);
						Thread conductorThread = new Thread(JobList.get(JobList.size()-1));
						
						if (batonHCEnabled && singleHeaderCheck) {
							String selectedDirectory = startingDirectory + iterateDirectory.substring(iterateDirectory.indexOf("\\",iterateDirectory.indexOf("\\") + 1));
							conductBatonHeader(selectedDirectory);
							singleHeaderCheck = false;
						}
						
						String fillerName = iterateDirectory.substring(iterateDirectory.lastIndexOf("\\") + 1,iterateDirectory.lastIndexOf("."))+ "(" + Preset + ")"+".ts";
						String jobName = textField_2.getText().trim().equals("") ? fillerName : textField_2.getText();
						String ipAddr = (String) textField_AtemeIP.getSelectedItem();
						String jobPreset = Preset;
						String jobInput = startingDirectory + iterateDirectory.substring(iterateDirectory.indexOf("\\",iterateDirectory.indexOf("\\") + 1));
						String jobSegmentNumber = "1";
						String jobState = "pending";
						
						String jobOutput;
						String outputFolder = textField.getText();
						if (textField.getText().endsWith("\\"))
							outputFolder = textField.getText().substring(0, textField.getText().length() - 1);
						if(textField_1.getText().trim().equals(""))
							jobOutput = outputFolder + "\\" + fillerName;
						else 
							jobOutput = outputFolder + "\\" + textField_1.getText()+".ts";
						
						
						initConductor.setAtemeTCEnabled(true);
						initConductor.atemeTC.setIpAddr(ipAddr);
						initConductor.atemeTC.setJobPreset(jobPreset);
						initConductor.atemeTC.setJobInput(jobInput);
						initConductor.atemeTC.setJobSegmentNumber(jobSegmentNumber);
						initConductor.atemeTC.setJobOutput(jobOutput);
						initConductor.atemeTC.setJobState(jobState);
						initConductor.atemeTC.setJobName(jobName);
						initConductor.atemeTC.setJobPriority(jobPriority);
						
						if (batonQCEnabled){
							conductBaton(jobOutput);
						}
						
						conductorThread.start();
					}
					
				}
				
				else {
					
					if (batonHCEnabled) {
						JobConductor initConductor = new JobConductor();
						JobList.add(initConductor);
						Thread conductorThread = new Thread(JobList.get(JobList.size()-1));
						String selectedDirectory = startingDirectory + iterateDirectory.substring(iterateDirectory.indexOf("\\",iterateDirectory.indexOf("\\") + 1));
						conductBatonHeader(selectedDirectory);
						conductorThread.start();
					}
					if (batonQCEnabled){
						JobConductor initConductor = new JobConductor();
						JobList.add(initConductor);
						Thread conductorThread = new Thread(JobList.get(JobList.size()-1));
						String selectedDirectory = startingDirectory + iterateDirectory.substring(iterateDirectory.indexOf("\\",iterateDirectory.indexOf("\\") + 1));
						conductBaton(selectedDirectory);
						conductorThread.start();
					}
				}
			}
		}
	}
	
	private void conductBaton(String iterateDirectory){
		List<String> selectedTestPlans = new ArrayList<String>();
		if (chckbxManualTestplanEntry.isSelected()) {
			selectedTestPlans.add(textField_4.getText());
		} else
			selectedTestPlans = list_TestPlan.getSelectedValuesList();

		String Priority = (String) spinner.getValue();
		
		for (String TestPlan : selectedTestPlans) {
			
			JobList.get(JobList.size()-1).setBatonQCEnabled(true);
			JobList.get(JobList.size()-1).batonQC.setIpAddr((String) textField_BatonIP.getSelectedItem());
			JobList.get(JobList.size()-1).batonQC.setPriority(Priority);
			JobList.get(JobList.size()-1).batonQC.setSelectedDirectory(iterateDirectory);
			JobList.get(JobList.size()-1).batonQC.setTestPlan(TestPlan);
			JobList.get(JobList.size()-1).batonQC.setTestPlanVersion(TestPlanVersion);
		}
	}
	
	private void conductBatonHeader(String iterateDirectory){
		String selectedTestPlan = txtCmsprofiler.getSelectedItem().toString();
		String Priority = (String) spinner.getValue();

		JobList.get(JobList.size() - 1).setBatonHCEnabled(true);
		JobList.get(JobList.size() - 1).batonHC.setIpAddr(textField_BatonHeaderIP.getSelectedItem().toString());
		JobList.get(JobList.size() - 1).batonHC.setPriority(Priority);
		JobList.get(JobList.size() - 1).batonHC.setSelectedDirectory(iterateDirectory);
		JobList.get(JobList.size() - 1).batonHC.setTestPlan(selectedTestPlan);
		JobList.get(JobList.size() - 1).batonHC.setTestPlanVersion(TestPlanVersion);
	}
	
		/*
		 * Field check
		 */
	
	private boolean fieldCheckAtemeTC(){
		if ((list_AtemePreset.isSelectionEmpty() && !chckbxManualPresetEntry.isSelected())
				|| (textField_3.getText().isEmpty() && chckbxManualPresetEntry.isSelected())) {
			JOptionPane.showMessageDialog(frame, "Select Preset(s).");
			return false;
		}
		else if (textField.getText().isEmpty()){
			JOptionPane.showMessageDialog(frame,"Select Output Folder.");
			return false;
		}
		else
			return true;
	}
	
	private boolean fieldCheckBatonQC(){
		System.out.println(textField_4.getText().isEmpty() && chckbxManualTestplanEntry.isSelected());
		if (list_TestPlan.isSelectionEmpty() && !chckbxManualTestplanEntry.isSelected()
				|| (textField_4.getText().isEmpty() && chckbxManualTestplanEntry.isSelected())) {
			JOptionPane.showMessageDialog(frame, "Select Test Plan(s).");
			return false;
		}
		else
			return true;
	}
	
	private boolean fieldCheckBatonHC(){
		if (textField_BatonHeaderIP.getSelectedItem().toString().isEmpty()){
			JOptionPane.showMessageDialog(frame, "Select Baton Header IP.");
			return false;
		}
		else if (txtCmsprofiler.getSelectedItem().toString().isEmpty()){
			JOptionPane.showMessageDialog(frame, "Select Baton Header Test Plan.");
			return false;
		}
		else
			return true;
	}
	
	/*
	 * Auto-Populate 
	 */
	
	private void populateAteme() throws JDOMException, IOException {
		list_AtemePreset.setListData(PopulateGUI.populateAteme((String)textField_AtemeIP.getSelectedItem()));
	}
	
	private void populateElemental() throws JDOMException, IOException{
		list_ElementalPreset.setListData(PopulateGUI.populateElemental((String)textField_ElementalIP.getSelectedItem()));
	}
	
	private void populateBaton() throws JDOMException, IOException, XmlRpcException{
        list_TestPlan.setListData(PopulateGUI.populateBaton((String)textField_BatonIP.getSelectedItem()));
    }
	
	/*
	 * Filter
	 */
    
    private void filterATEMEPresets(){
    	if(!PopulateGUI.listOfAtemePresets.isEmpty()){
            try {
				list_AtemePreset.setListData(PopulateGUI.filterAteme(textField_AtemeFilter.getText()));
			} catch (JDOMException | IOException | XmlRpcException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }
    
    private void filterTestPlans() {
		if (!PopulateGUI.listOfTestPlans.isEmpty()) {
			try {
				list_TestPlan.setListData(PopulateGUI.filterBaton(textField_BatonFilter.getText()));
			} catch (JDOMException | IOException | XmlRpcException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
    
    private void filterElementalPreset(){
    	if(!PopulateGUI.listOfElementalPresets.isEmpty()){
            try {
				list_ElementalPreset.setListData(PopulateGUI.filterElemental(textField_ElementalFilter.getText()));
			} catch (JDOMException | IOException | XmlRpcException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }
    
    
    private void createContentTable(String targetDirectory){
    	
    	File file = new File(targetDirectory);
        MyFile mf = new MyFile(file);
        TreeModel model = new FileTreeModel(mf);
        
        tree = new JTree(model);
        scrollPane.setViewportView(tree);
        tree.setEditable(true);
        addContentTreeListener();
    }
    
	private void addContentTreeListener() {
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent arg0) {

				TreePath path = tree.getSelectionPath();
				StringBuilder sb = new StringBuilder();

				for (int i = 0; i < path.getPathCount(); i++)
					sb.append("\\" + path.getPathComponent(i).toString());

				textField_12.setText(startingDirectory.substring(0, startingDirectory.lastIndexOf("\\")) + sb.toString());
			}
		});
	}
	
	
    
    private void setPanelEnabled(int panelSelection, boolean panelState){
    	switch (panelSelection){
    	case 0:
    		if (panelState)
    			chckbxBatonHeader.setBackground(Color.GREEN);
    		else
    			chckbxBatonHeader.setBackground(Color.RED);
    		for(Component panelComponent : headerCheckPanel.getComponents())
    			panelComponent.setEnabled(panelState);
    		break;
    	case 1:
    		if (panelState)
    			chckbxAtemeTranscode.setBackground(Color.GREEN);
    		else
    			chckbxAtemeTranscode.setBackground(Color.RED);
    		for(Component panelComponent : atemePanel.getComponents()){
    			panelComponent.setEnabled(panelState);
    		}
    		for(Component panelComponent : atemePanel2.getComponents()){
    			panelComponent.setEnabled(panelState);
    		}
    		for(Component panelComponent : atemePanel3.getComponents()){
    			panelComponent.setEnabled(panelState);
    		}
    		list_AtemePreset.setEnabled(panelState);
    		break;
    	case 2:
    		if (panelState)
    			chckbxBatonFullQc.setBackground(Color.GREEN);
    		else
    			chckbxBatonFullQc.setBackground(Color.RED);
    		for(Component panelComponent : fullQCPanel.getComponents())
    			panelComponent.setEnabled(panelState);
    		list_TestPlan.setEnabled(panelState);
    		break;
    	case 3:
    		if (panelState)
    			chckbxElementalTranscode.setBackground(Color.GREEN);
    		else
    			chckbxElementalTranscode.setBackground(Color.RED);
    		for(Component panelComponent : elementalPanel.getComponents())
    			panelComponent.setEnabled(panelState);
    		for(Component panelComponent : elementalPanel1.getComponents())
    			panelComponent.setEnabled(panelState);
    		for(Component panelComponent : elementalPanel2.getComponents())
    			panelComponent.setEnabled(panelState);
    		break;
    	}
    }
}
