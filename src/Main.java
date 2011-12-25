import java.io.IOException;

import com.kwyjibo.directory.util.DirectoryScanner;
import com.kwyjibo.file.copier.util.FileCopier;
import com.kwyjibo.file.scanner.util.FileScanner;
import com.kwyjibo.file.tagger.util.FileTagger;

public class Main {

	public static void main(String[] args) throws IOException {
		DirectoryScanner ds = new DirectoryScanner();
		ds.listDirectories(args[0]);
		//FileScanner fs = new FileScanner();
		//fs.listFiles(ds.getDirectories());
		//FileTagger ft = new FileTagger();
		//ft.getMusicTags(fs.getFiles());
		//ft.printSongs();
		//FileCopier fc = new FileCopier(args[1], ft.getSongs());
		//fc.copyFile();
	}

}
