package cosmosCheckerGUI;

import java.awt.Font;
import java.awt.Rectangle;
import java.io.BufferedReader;
import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileFilter;

import cosmosChecker.impl.ComponentFactory;
import cosmosChecker.spec.prov.ICosmosConstraints;
import cosmosChecker.spec.prov.IManager;



public class GraphicCosmosChecker extends JFrame {

	private javax.swing.JFileChooser jFileChooser = null;  //  @jve:decl-index=0:visual-constraint="130,706"

	private static final long serialVersionUID = 1L;

	private final String COSMOSCHECKERLOG = "cosmosCheckerLog.txt";  //  @jve:decl-index=0:

	private final String HELP = "README.txt";  //  @jve:decl-index=0:

	private JPanel jContentPane = null;

	private JLabel jLabelDirPath = null;

	private JLabel jLabel1 = null;


	private JLabel jLabel2 = null;

	private JTextArea jTextArea = null;



	private JLabel jLabel3 = null;

	private JButton jDirPathButton = null;

	private JScrollPane jScrollPane = null;

	private JLabel jLabel = null;

	private JTextField jTextField = null;

	private JButton jButton = null;

	private JButton jButton1 = null;

	private JTextField jTextField1 = null;

	private JTextField jTextField2 = null;

	private JButton jButton2 = null;

	/**
	 * This method initializes jTextArea	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getJTextArea() {
		if (jTextArea == null) {
			jTextArea = new JTextArea();

		}
		//jTextArea.setText("hello 2007");
		return jTextArea;
	}




	private void loadFile(JTextField jTF , FileFilter ff ) {
		int state = getJFileChooser( ff ).showOpenDialog(this);
		//System.out.println("entrou no loadfile ");
		if (state == JFileChooser.APPROVE_OPTION) {
			File f = getJFileChooser( ff ).getSelectedFile();
			String path = f.getAbsolutePath();
			jTF.setText( path );

			if( ( jTF.equals( jTextField1) ) && ( !path.endsWith( "drl" ) ) ){
				JOptionPane.showMessageDialog(jTF, "The rules file should have 'drl' extension");
			}
			//setTitle(title);
		}
	}

	/**
	 * This method initializes jDirPathButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJDirPathButton() {
		if (jDirPathButton == null) {
			jDirPathButton = new JButton();
			jDirPathButton.setBounds(new Rectangle(139, 91, 77, 24));
			jDirPathButton.setText("File...");			
		}
		jDirPathButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				loadFile( jTextField1 , (FileFilter) new DRLFilter() );
			}
		});
		return jDirPathButton;
	}

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(9, 367, 622, 219));
			jScrollPane.setViewportView(getJTextArea());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes jTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField() {
		if (jTextField == null) {
			jTextField = new JTextField();
			jTextField.setBounds(new Rectangle(12, 195, 616, 26));
		}
		return jTextField;
	}



	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setBounds(new Rectangle(287, 254, 76, 27));
			jButton.setText("File...");
		}
		jButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				loadFile( jTextField2 , null );
			}
		});
		return jButton;
	}



	/**
	 * This method initializes jButton1	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setBounds(new Rectangle(227, 330, 174, 30));
			jButton1.setText("Run CosmosChecker");
		}
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				String cosmosRulesFile = jTextField1.getText();
				String componentPath = jTextField2.getText();
				String componentPackage = jTextField.getText();

				/*String cosmosRulesFile = "/home/lsd/ra001973/workspace2/CosmosChecker/src/rules/cosmosRules.drl";
				String componentPath = "/home/lsd/ra001973/componentSample/patrick/ComponentesExcepcionais/tratadorChequeSustado/br/unicamp/ic/estCaso/tratadores/tratadorChequeSustado";
				String componentPackage = "br.unicamp.ic.estCaso.tratadores.tratadorChequeSustado";
				 */

				System.out.println( "cosmosRulesFile = " + cosmosRulesFile);
				System.out.println("componentPath = "+ componentPath);
				System.out.println("componentPackage = "+ componentPackage);
				boolean res = runCosmosChecker(cosmosRulesFile, componentPath, componentPackage );
			}
		});
		return jButton1;
	}

	private boolean runCosmosChecker(String cosmosRulesFile, String componentPath, String componentPackage){
		System.out.println("running CosmosChecker...");
		boolean res = false;
		IManager manager = ComponentFactory.createInstance(); 
		ICosmosConstraints icosmos = (ICosmosConstraints) manager.getProvidedInterface("ICosmosConstraints");
		setupLog();
		
		/*cosmosRulesFile = "/home/lsd/ra001973/workspace2/CosmosChecker/src/rules/cosmosRules.drl";
		componentPath = "/home/lsd/ra001973/componentSample/patrick/ComponenteDeNegocio/gerenciamentoColigada/br/unicamp/ic/estCaso/negocio/gerenciamentoColigada";
		componentPackage = "br.unicamp.ic.estCaso.negocio.gerenciamentoColigada";	*/
		
		res = icosmos.isCosmos(cosmosRulesFile, componentPath, componentPackage);
		showResult( res , componentPath);
		return res;
	}

	/**
	 * this method delete the log if it already exists, and create a new one
	 *
	 */
	private void setupLog(){
		File file = new File( COSMOSCHECKERLOG );
		if( file.exists() ){
			file.delete();
		}
		boolean createFile;
		try {
			createFile = file.createNewFile();
			if( createFile )
				System.out.println("File "+file.getAbsolutePath() + " created");
			else
				System.out.println("File "+file.getAbsolutePath() + " wasn't created");
		} catch (IOException e) {
			System.err.println("File was not created");
			e.printStackTrace();
		}


	}

	private void showResult(boolean res, String componentPath){
		String result = "";
		File file = new File( COSMOSCHECKERLOG );
		try {

			BufferedReader br = new BufferedReader( new FileReader( file ));
			String aux2 = br.readLine();
			while( aux2 != null ){
				result += aux2 + "\n";
				//System.out.println("aux2 = " + aux2);
				aux2 = br.readLine();

			}
			if( res )
				result += "\n\nThe component "+ componentPath +" is COSMOS";
			else
				result += "\n\nThe component "+ componentPath +" is NOT COSMOS";
			jTextArea.setText( result );
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result);
	}

	/**
	 * This method initializes jTextField1	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField1() {
		if (jTextField1 == null) {
			jTextField1 = new JTextField();
			jTextField1.setBounds(new Rectangle(11, 117, 619, 26));
		}
		return jTextField1;
	}




	/**
	 * This method initializes jTextField2	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField2() {
		if (jTextField2 == null) {
			jTextField2 = new JTextField();
			jTextField2.setBounds(new Rectangle(13, 283, 620, 26));
		}
		return jTextField2;
	}




	/**
	 * This method initializes jButton2	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton2() {
		if (jButton2 == null) {
			jButton2 = new JButton();
			jButton2.setBounds(new Rectangle(409, 331, 72, 29));
			jButton2.setText("Help");
		}
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				String message = "See the README.txt for more information about how to use CosmosChecker";
				JOptionPane.showMessageDialog(jButton2, message);
				
			}
		});
		return jButton2;


	}

/*	private String readHelp(String help){
		File file = new File( help );
		String result = null;
		if( file.exists() ){
			
			BufferedReader br;
			try {
				br = new BufferedReader( new FileReader( file ));
				String aux2 = br.readLine();
				while( aux2 != null ){
					result += aux2 + "\n";
					//System.out.println("aux2 = " + aux2);
					aux2 = br.readLine();

				}

			} catch (FileNotFoundException e) {
				System.err.println("Configuration file was not found");
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
					}
		return result;
	}
*/
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				GraphicCosmosChecker thisClass = new GraphicCosmosChecker();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
			}
		});
	}

	/**
	 * This is the default constructor
	 */
	public GraphicCosmosChecker() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(660, 655);
		this.setContentPane(getJContentPane());
		this.setTitle("JFrame");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(206, 11, 210, 39));
			jLabel.setFont(new Font("Dialog", Font.BOLD, 24));
			jLabel.setText("CosmosChecker");
			jLabel3 = new JLabel();
			jLabel3.setBounds(new Rectangle(19, 117, 619, 25));
			jLabel3.setText("");
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(9, 87, 127, 28));
			jLabel2.setText("Select the rules file");
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(16, 168, 173, 24));
			jLabel1.setText("Write component package");
			jLabelDirPath = new JLabel();
			jLabelDirPath.setBounds(new Rectangle(9, 256, 276, 24));
			jLabelDirPath.setText("Select the path to the component directory ");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jLabelDirPath, null);
			jContentPane.add(jLabel1, null);


			jContentPane.add(jLabel2, null);

			jContentPane.add(getJDirPathButton(), null);
			jContentPane.add(getJScrollPane(), null);
			jContentPane.add(jLabel, null);
			jContentPane.add(getJTextField(), null);
			jContentPane.add(getJButton(), null);
			jContentPane.add(getJButton1(), null);
			jContentPane.add(getJTextField1(), null);
			jContentPane.add(getJTextField2(), null);
			jContentPane.add(getJButton2(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jFileChooser
	 * 
	 * @return javax.swing.JFileChooser
	 */
	private javax.swing.JFileChooser getJFileChooser( javax.swing.filechooser.FileFilter ff ) {
		if (jFileChooser == null) {
			jFileChooser = new javax.swing.JFileChooser();
			jFileChooser.setMultiSelectionEnabled(false);
			/*BUG!!!*/
			jFileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			jFileChooser.setFileFilter( ff );
			//System.out.println("Files and Directories");
		}


		return jFileChooser;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
