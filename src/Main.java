import com.kwyjibo.directory.util.DirectoryScanner;
import com.kwyjibo.file.scanner.util.FileScanner;

public class Main {

	public static void main(String[] args) {
		DirectoryScanner ds = new DirectoryScanner();
		ds.listDirectories(args[0]);
		FileScanner fs = new FileScanner();
		fs.listFiles(ds.getDirectories());
		fs.printFiles();
	}

}
