package Export;import java.io.File;

public interface ExportFileStream {
	
	public void exportFile(File f, String table, String path, String un, String pass);
	public void export(File f, String table, String path, String un, String pass, String delimeter);

}
