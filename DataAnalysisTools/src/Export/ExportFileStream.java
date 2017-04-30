package Export;import java.io.File;

public interface ExportFileStream {
	public void exportFile(File f);
	public void export(File f, String delimeter);

}
