package Import;

import Driver.driver;

import java.io.File;

public interface ImportFileStream {

	public void importFile(String table, String path, String un, String pass, String delimeter);
}
