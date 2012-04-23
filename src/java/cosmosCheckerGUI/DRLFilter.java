package cosmosCheckerGUI;

import java.io.File;


public class DRLFilter extends javax.swing.filechooser.FileFilter{

	private final String drl = "drl";


	@Override
	public boolean accept(File f) {
		if (f.isDirectory()) {
			return true;
		}

		String extension =  getExtension(f);
		if (extension != null) {
			if (extension.equals( drl ) ) 
				return true;
			else 
				return false;

		}

		return false;
	}

	@Override
	public String getDescription() {
		    String type = "DRL File";
		return type;
	}

	public String getExtension(File f) {
		String ext = null;
		String s = f.getName();
		int i = s.lastIndexOf('.');

		if (i > 0 &&  i < s.length() - 1) {
			ext = s.substring(i+1).toLowerCase();
		}
		return ext;
	}

	

	
	
}
