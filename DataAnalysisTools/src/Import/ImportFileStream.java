package Import;

import Driver.driver;

import java.io.File;

public interface ImportFileStream {
	
	public void importFile(File f, String table, String path, String un, String pass);
	public void importFile(File f, String table, String path, String un, String pass, String delimeter);
}
