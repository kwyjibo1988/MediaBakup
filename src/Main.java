import java.io.IOException;

import com.kwyjibo.database.util.DataStore;
import com.kwyjibo.database.util.Database;
import com.kwyjibo.directory.util.DirectoryScanner;
import com.kwyjibo.file.scanner.util.FileScanner;
import com.kwyjibo.file.tagger.util.FileTagger;

public class Main {

	public static void main(String[] args) throws IOException {
		DirectoryScanner ds = new DirectoryScanner();
		ds.listDirectories(args[0]);
		FileScanner fs = new FileScanner();
		fs.listFiles(ds.getDirectories());
		FileTagger ft = new FileTagger();
		ft.getMusicTags(fs.getFiles());
		Database db = new DataStore();
		db.populateFailed(ft.getFailed());
		//FileCopier fc = new FileCopier(args[1], ft.getSongs());
		//fc.copyFile();
	}

}
