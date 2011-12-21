import com.kwyjibo.directory.util.DirectoryScanner;
import com.kwyjibo.file.scanner.util.FileScanner;
import com.kwyjibo.file.tagger.util.FileTagger;

public class Main {

	public static void main(String[] args) {
		DirectoryScanner ds = new DirectoryScanner();
		ds.listDirectories(args[0]);
		FileScanner fs = new FileScanner();
		fs.listFiles(ds.getDirectories());
		FileTagger ft = new FileTagger();
		ft.getMusicTags(fs.getFiles());
	}

}
