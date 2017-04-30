package Import;

import java.io.File;

public class importTXT implements ImportFileStream {
	
	private File f;
	
	public void importFileStream(File file){
		file=f;
	}
	
	@Override
	public void importFile(File f, String table, String path, String un, String pass){
		
		
	}
	
	@Override	
	public void importFile(File f, String table, String path, String un, String pass, String delimeter){
		
		
	}
	
}
