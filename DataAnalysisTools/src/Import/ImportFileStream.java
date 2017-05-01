package Import;

import java.io.File;

public interface ImportFileStream {

	public void importFile(String db, String table, String path, String un, String pass, String delimeter);
}
