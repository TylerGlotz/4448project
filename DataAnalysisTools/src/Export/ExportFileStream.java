package Export;import java.io.File;

public interface ExportFileStream {
	
	public void export(String db, String table, String path, String un, String pass, String delimeter);

}
