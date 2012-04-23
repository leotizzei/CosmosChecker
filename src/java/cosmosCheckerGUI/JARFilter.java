package cosmosCheckerGUI;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class JARFilter extends FileFilter{

	private final String jar = "jar";
	private final String JAR = "JAR";

	@Override
	public boolean accept(File f) {
		if (f.isDirectory()) {
			return true;
		}

		String extension =  getExtension(f);
		if (extension != null) {
			if (extension.equals( jar ) || extension.equals( JAR)) 
				return true;
			else 
				return false;

		}

		return false;
	}

	@Override
	public String getDescription() {
		    String type = "JAR File";
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
