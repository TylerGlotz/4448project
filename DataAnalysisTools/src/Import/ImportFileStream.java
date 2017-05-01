package Import;

import java.io.File;
import java.io.IOException;
import com.opencsv.*;

public interface ImportFileStream {

	public void importFile(String db, String table, String path, String un, String pass, String delimeter) throws IOException;
}
