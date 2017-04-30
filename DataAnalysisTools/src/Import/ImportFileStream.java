package Import;

import Driver.driver;

import java.io.File;

public interface ImportFileStream {
	public void importFile(File f);
	public void importFile(File f, String delimeter);
}
