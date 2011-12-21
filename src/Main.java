import com.kwyjibo.directory.util.DirectoryScanner;

public class Main {

	public static void main(String[] args) {
		DirectoryScanner ds = new DirectoryScanner();
		ds.listDirectories(args[0]);
		
	}

}
