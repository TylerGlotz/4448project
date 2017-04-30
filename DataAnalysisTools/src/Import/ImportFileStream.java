package Import;

public interface ImportFileStream {
	public <File> void importFile(File f);
	public <File> void importFile(File f, String delimeter);
}
